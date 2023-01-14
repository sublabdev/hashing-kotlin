package dev.sublab.base58

/**
 * An object that handles `ByteArray`'s encoding using `Base58`
 * @property byteArray the `Bytearray` to encode
 */
class ByteArrayBase58(private val byteArray: ByteArray) {
    fun encode() = Base58Coder.encode(byteArray)
}

/**
 * ByteArray encoder using base58
 */
val ByteArray.base58
    get() = ByteArrayBase58(this)