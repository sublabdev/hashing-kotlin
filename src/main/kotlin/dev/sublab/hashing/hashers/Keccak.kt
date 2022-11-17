package dev.sublab.hashing.hashers

import com.appmattus.crypto.Algorithm
import dev.sublab.hashing.Hashing
import dev.sublab.hashing.InvalidHashOutputSizeException

private fun ByteArray.keccak(outputSize: Int) =
    when (outputSize) {
        224 -> Algorithm.Keccak224
        256 -> Algorithm.Keccak256
        288 -> Algorithm.Keccak288
        384 -> Algorithm.Keccak384
        512 -> Algorithm.Keccak512
        else -> throw InvalidHashOutputSizeException(outputSize)
    }
    .createDigest()
    .apply { update(this@keccak) }
    .digest()

private fun Hashing.keccak(outputSize: Int) = value.toByteArray().keccak(outputSize)
fun Hashing.keccak224() = keccak(224)
fun Hashing.keccak256() = keccak(256)
fun Hashing.keccak288() = keccak(288)
fun Hashing.keccak384() = keccak(384)
fun Hashing.keccak512() = keccak(512)