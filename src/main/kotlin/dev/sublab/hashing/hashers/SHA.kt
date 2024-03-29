/**
 *
 * Copyright 2023 SUBSTRATE LABORATORY LLC <info@sublab.dev>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0

 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package dev.sublab.hashing.hashers

import com.appmattus.crypto.Algorithm
import dev.sublab.hashing.Hashing
import dev.sublab.hashing.InvalidHashOutputSizesException

private fun ByteArray.sha(outputSize: IntArray) =
    when  {
        outputSize contentEquals intArrayOf(0) -> Algorithm.SHA_0
        outputSize contentEquals intArrayOf(1) -> Algorithm.SHA_1
        outputSize contentEquals intArrayOf(224) -> Algorithm.SHA_224
        outputSize contentEquals intArrayOf(256) -> Algorithm.SHA_256
        outputSize contentEquals intArrayOf(384) -> Algorithm.SHA_384
        outputSize contentEquals intArrayOf(512) -> Algorithm.SHA_512
        outputSize contentEquals intArrayOf(512, 224) -> Algorithm.SHA_512_224
        outputSize contentEquals intArrayOf(512, 256) -> Algorithm.SHA_512_256
        else -> throw InvalidHashOutputSizesException(outputSize)
    }
    .createDigest()
    .apply { update(this@sha) }
    .digest()

/**
 * Hashing via SHA using the provided output size
 * @param outputSize output size used when hashing via SHA
 */
private fun Hashing.sha(vararg outputSize: Int) = value.toByteArray().sha(outputSize)

/**
 * Hashing via [Algorithm.SHA_0] with output size of 0
 */
fun Hashing.sha0() = sha(0)

/**
 * Hashing via [Algorithm.SHA_1] with output size of 1
 */
fun Hashing.sha1() = sha(1)

/**
 * Hashing via [Algorithm.SHA_224] with output size of 224
 */
fun Hashing.sha224() = sha(224)

/**
 * Hashing via [Algorithm.SHA_256] with output size of 256
 */
fun Hashing.sha256() = sha(256)

/**
 * Hashing via [Algorithm.SHA_384] with output size of 384
 */
fun Hashing.sha384() = sha(384)

/**
 * Hashing via [Algorithm.SHA_512] with output size of 512
 */
fun Hashing.sha512() = sha(512)

/**
 * Hashing via [Algorithm.SHA_512_224] with output size of 224
 */
fun Hashing.sha512_224() = sha(512, 224)

/**
 * Hashing via [Algorithm.SHA_512_256] with output size of 256
 */
fun Hashing.sha512_256() = sha(512, 256)