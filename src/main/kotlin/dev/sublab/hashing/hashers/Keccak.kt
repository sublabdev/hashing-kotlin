package dev.sublab.hashing.hashers

import com.appmattus.crypto.Algorithm
import dev.sublab.hashing.Hashing
import dev.sublab.hashing.InvalidHashOutputSizeException
import dev.sublab.keccak.sphlib.Keccak1600
import dev.sublab.keccak.sphlib.prepareForKeccakF1600

private fun ByteArray.keccak(outputSize: Int) =
    when (outputSize) {
        224 -> Algorithm.Keccak224.createDigest()
        256 -> Algorithm.Keccak256.createDigest()
        288 -> Algorithm.Keccak288.createDigest()
        384 -> Algorithm.Keccak384.createDigest()
        512 -> Algorithm.Keccak512.createDigest()
        1600 -> Keccak1600()
        else -> throw InvalidHashOutputSizeException(outputSize)
    }
    .apply { update(this@keccak) }
    .digest()

private fun Hashing.keccak(outputSize: Int) = value.toByteArray().keccak(outputSize)
fun Hashing.keccak224() = keccak(224)
fun Hashing.keccak256() = keccak(256)
fun Hashing.keccak288() = keccak(288)
fun Hashing.keccak384() = keccak(384)
fun Hashing.keccak512() = keccak(512)
fun Hashing.keccak1600() = value.toByteArray().prepareForKeccakF1600().keccak(1600)