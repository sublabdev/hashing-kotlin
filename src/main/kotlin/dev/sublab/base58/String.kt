package dev.sublab.base58

/**
 * An object that handles `String`'s decoding using `Base58`
 * @property string the `String` to decode
 */c
class StringBase58(private val string: String) {
    fun decode() = Base58Coder.decode(string)
}

/**
 * `String` decoder using base58
 */
val String.base58
    get() = StringBase58(this)