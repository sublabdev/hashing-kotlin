package dev.sublab.ss58

import dev.sublab.base58.base58
import dev.sublab.hashing.hashers.blake2b_512
import dev.sublab.hashing.hashing

class StringSS58(private val string: String) {
    private fun decode() = string.base58.decode().apply {
        if (size < 2) throw InvalidAddressException()
    }

    private fun networkTypeLength(byteArray: ByteArray) = when (byteArray[0]) {
        in networkTypeLengthRange1 -> 1
        in networkTypeLengthRange2 -> 2
        else -> throw InvalidAddressException()
    }

    fun accountId() = decode().let { decoded ->
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

val String.ss58
    get() = StringSS58(this)