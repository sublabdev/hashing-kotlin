package dev.sublab.base58

class ByteArrayBase58(private val byteArray: ByteArray) {
    fun encode() = Base58Coder.encode(byteArray)
}

val ByteArray.base58
    get() = ByteArrayBase58(this)