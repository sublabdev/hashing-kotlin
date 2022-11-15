package dev.sublab.hashing

interface ByteArrayConvertible {
    fun toByteArray(): ByteArray
}

class Hashing(internal val value: ByteArrayConvertible)

val ByteArray.hashing: Hashing
    get() = Hashing(object : ByteArrayConvertible {
        override fun toByteArray() = this@hashing
    })

val String.hashing: Hashing
    get() = Hashing(object : ByteArrayConvertible {
        override fun toByteArray() = this@hashing.toByteArray()
    })