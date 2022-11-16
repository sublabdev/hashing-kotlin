package dev.sublab.utils

interface ByteArrayConvertible {
    fun toByteArray(): ByteArray
}

fun String.asByteArrayConvertible() = object : ByteArrayConvertible {
    override fun toByteArray() = this@asByteArrayConvertible.toByteArray()
}

fun ByteArray.asByteArrayConvertible() = object : ByteArrayConvertible {
    override fun toByteArray() = this@asByteArrayConvertible
}