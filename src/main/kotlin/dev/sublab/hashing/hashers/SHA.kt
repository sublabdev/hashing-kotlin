package dev.sublab.hashing.hashers

import com.appmattus.crypto.Algorithm
import dev.sublab.hashing.Hashing
import dev.sublab.hashing.InvalidHashOutputSizesException

private fun ByteArray.sha(outputSize: IntArray) =
    when (outputSize) {
        intArrayOf(0) -> Algorithm.SHA_0
        intArrayOf(1) -> Algorithm.SHA_1
        intArrayOf(224) -> Algorithm.SHA_224
        intArrayOf(256) -> Algorithm.SHA_256
        intArrayOf(384) -> Algorithm.SHA_384
        intArrayOf(512) -> Algorithm.SHA_512
        intArrayOf(512, 224) -> Algorithm.SHA_512_224
        intArrayOf(512, 256) -> Algorithm.SHA_512_256
        else -> throw InvalidHashOutputSizesException(outputSize)
    }
    .createDigest()
    .apply { update(this@sha) }
    .digest()


private fun Hashing.sha(vararg outputSize: Int) = value.toByteArray().sha(outputSize)

fun Hashing.sha0() = sha(0)
fun Hashing.sha1() = sha(1)
fun Hashing.sha224() = sha(224)
fun Hashing.sha256() = sha(256)
fun Hashing.sha512() = sha(512)
fun Hashing.sha512_224() = sha(512, 224)
fun Hashing.sha512_256() = sha(512, 256)