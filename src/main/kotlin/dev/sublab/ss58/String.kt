/**
 *
 * Copyright 2023 SUBSTRATE LABORATORY LLC <info@sublab.dev>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package dev.sublab.ss58

import dev.sublab.base58.base58
import dev.sublab.hashing.hashers.blake2b_512
import dev.sublab.hashing.hashing

/**
 * SS58 handler for String
 */
class StringSS58(private val string: String) {
    /**
     * Decoding the provided String value using Base58
     */
    private fun decode() = string.base58.decode().apply {
        if (size < 2) throw InvalidAddressException()
    }

    private fun networkTypeLength(byteArray: ByteArray) = when (byteArray[0]) {
        in networkTypeLengthRange1 -> 1
        in networkTypeLengthRange2 -> 2
        else -> throw InvalidAddressException()
    }

    /**
     * Returns public key from provided String value
     */
    fun accountId(): AccountId = decode().let { decoded ->
        val networkTypeLength = networkTypeLength(decoded)
        val publicKey = decoded.copyOfRange(networkTypeLength, networkTypeLength + publicKeySize)

        // check sum
        val checkByteArray = prefix.toByteArray() + decoded.copyOf(networkTypeLength) + publicKey
        val checksum = checkByteArray.hashing.blake2b_512().copyOf(prefixSize)
        val checkFrom = networkTypeLength + publicKeySize
        val check = decoded.copyOfRange(checkFrom, checkFrom + prefixSize)
        if (!check.contentEquals(checksum)) throw InvalidChecksumException()

        publicKey
    }

    /**
     * The network type from provided String value
     */
    fun networkType() = decode().let { decoded ->
        val first = decoded[0].toInt()

        when (networkTypeLength(decoded)) {
            1 -> first
            2 -> {
                val second = decoded[1].toInt()
                val lo = ((first and 0x3f) shl 2) or (second shr 6)
                val hi = (second and 0x3f) shl 8

                lo or hi
            }
            else -> throw InvalidAddressException()
        }
    }
}

/**
 * And access point for SS58 functionality for [String]
 */
val String.ss58
    get() = StringSS58(this)