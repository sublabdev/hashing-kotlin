package dev.sublab.hashing.hashers

import com.appmattus.crypto.Algorithm
import dev.sublab.hashing.Hashing

private fun ByteArray.blake2b(outputSize: Int) = Algorithm.Blake2b(outputSize)
    .createDigest()
    .apply { update(this@blake2b) }
    .digest()

/**
 * Hashing via Blake2b using the provided output size
 */
fun Hashing.blake2b(outputSize: Int) = value.toByteArray().blake2b(outputSize)

/**
 * Hashes via Blake 2b with output size of 128
 */
fun Hashing.blake2b_128() = blake2b(128)

/**
 * Hashes via Blake 2b with output size of 160
 */
fun Hashing.blake2b_160() = blake2b(160)

/**
 * Hashes via Blake 2b with output size of 256
 */
fun Hashing.blake2b_256() = blake2b(256)

/**
 * Hashes via Blake 2b with output size of 384
 */
fun Hashing.blake2b_384() = blake2b(384)

/**
 * Hashes via Blake 2b with output size of 512
 */
fun Hashing.blake2b_512() = blake2b(512)