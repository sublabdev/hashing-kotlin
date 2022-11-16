package dev.sublab.hashing.hashers

import com.appmattus.crypto.Algorithm
import dev.sublab.hashing.Hashing

private fun ByteArray.blake2b(outputSize: Int) = Algorithm.Blake2b(outputSize)
    .createDigest()
    .apply { update(this@blake2b) }
    .digest()

fun Hashing.blake2b(outputSize: Int) = value.toByteArray().blake2b(outputSize)
fun Hashing.blake2b_128() = blake2b(128)
fun Hashing.blake2b_160() = blake2b(160)
fun Hashing.blake2b_256() = blake2b(256)
fun Hashing.blake2b_384() = blake2b(384)
fun Hashing.blake2b_512() = blake2b(512)