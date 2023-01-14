package dev.sublab.ss58

import dev.sublab.base58.base58
import dev.sublab.hashing.hashers.blake2b_256
import dev.sublab.hashing.hashers.blake2b_512
import dev.sublab.hashing.hashing

/**
 * Wrapper over ByteArray for working with SS58
 */
class ByteArraySS58(private val byteArray: ByteArray) {
    /**
     * Returns `AccountId` hashed using blake2b for 256 bits if the provided byteArray is
     * bigger then `SS58`'s public key's size. Otherwise return a plain `AccountId`.
     */
    fun accountId(): AccountId = if (byteArray.size > publicKeySize) {
        byteArray.hashing.blake2b_256()
    } else byteArray

    /**
     * Address for a specific network type
     */
    fun address(type: Int): String {
        val accountId = byteArray.ss58.accountId()

        val single = type and 0x3fff
        val networkType = when (type) {
            in networkTypeLengthRange1 -> byteArrayOf(single.toByte())
            in networkTypeLengthRange2 -> {
                val hi = ((single and 0xfc) shr 2) or 0x40
                val lo = (single shr 8) or ((single and 0x3f) shl 6)

                byteArrayOf(hi.toByte(), lo.toByte())
            }
            else -> throw InvalidAddressException()
        }

        val checksum = (prefix.toByteArray() + networkType + accountId)
            .hashing.blake2b_512()
            .copyOf(prefixSize)

        return (networkType + accountId + checksum).base58.encode()
    }
}

/**
 * An access point to SS58 functionality for ByteArray
 */
val ByteArray.ss58
    get() = ByteArraySS58(this)