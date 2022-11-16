package dev.sublab.base58

class StringBase58(private val string: String) {
    fun decode() = Base58Coder.decode(string)
}

val String.base58
    get() = StringBase58(this)