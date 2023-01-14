package dev.sublab.hashing.hashers

import com.appmattus.crypto.Algorithm
import dev.sublab.hashing.Hashing
import dev.sublab.hashing.InvalidHashOutputSizeException
import dev.sublab.keccak.keccak

private fun ByteArray.keccak(outputSize: Int) =
    when (outputSize) {
        224 -> Algorithm.Keccak224.createDigest()
        256 -> Algorithm.Keccak256.createDigest()
        288 -> Algorithm.Keccak288.createDigest()
        384 -> Algorithm.Keccak384.createDigest()
        512 -> Algorithm.Keccak512.createDigest()
        else -> throw InvalidHashOutputSizeException(outputSize)
    }
    .apply { update(this@keccak) }
    .digest()

/**
 * Hashing via Keccak using the provided output size
 */
private fun Hashing.keccak(outputSize: Int) = value.toByteArray().keccak(outputSize)
/**
 * Hashing via Keccak with output size of 224
 */
fun Hashing.keccak224() = keccak(224)

/**
 * Hashing via Keccak with output size of 256
 */
fun Hashing.keccak256() = keccak(256)

/**
 * Hashing via Keccak with output size of 288
 */
fun Hashing.keccak288() = keccak(288)

/**
 * Hashing via Keccak with output size of 384
 */
fun Hashing.keccak384() = keccak(384)

/**
 * Hashing via Keccak with output size of 512
 */
fun Hashing.keccak512() = keccak(512)

/**
 * Hashing via Keccak 1600
 */
fun Hashing.keccak1600() = value.toByteArray().keccak.f1600()