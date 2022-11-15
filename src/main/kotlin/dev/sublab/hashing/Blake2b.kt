package dev.sublab.hashing

import com.appmattus.crypto.Algorithm

private fun ByteArray.blake2b(outputSize: Int) = Algorithm.Blake2b(outputSize)
    .createDigest()
    .apply { update(this@blake2b) }
    .digest()

fun Hashing.blake2b_160() = value.toByteArray().blake2b(160)
fun Hashing.blake2b_256() = value.toByteArray().blake2b(256)
fun Hashing.blake2b_384() = value.toByteArray().blake2b(384)
fun Hashing.blake2b_512() = value.toByteArray().blake2b(512)