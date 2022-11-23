package dev.sublab.hashing.hashers

import com.appmattus.crypto.Algorithm
import dev.sublab.hashing.Hashing

private fun ByteArray.xx(width: Long) = (0 until width/64)
    .map {
        Algorithm.XXHash64(it)
            .createDigest()
            .apply { update(this@xx) }
            .digest()
            .reversedArray()
    }
    .fold(byteArrayOf()) { result, hash -> result + hash }

fun Hashing.xx64() = value.toByteArray().xx(64)
fun Hashing.xx128() = value.toByteArray().xx(128)
fun Hashing.xx256() = value.toByteArray().xx(256)