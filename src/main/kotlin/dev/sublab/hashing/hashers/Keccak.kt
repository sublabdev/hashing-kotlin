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
 * @param outputSize output size to use when hashing via Keccak
 */
private fun Hashing.keccak(outputSize: Int) = value.toByteArray().keccak(outputSize)
/**
 * Hashing via [Algorithm.Keccak224] with output size of 224
 */
fun Hashing.keccak224() = keccak(224)

/**
 * Hashing via [Algorithm.Keccak256] with output size of 256
 */
fun Hashing.keccak256() = keccak(256)

/**
 * Hashing via [Algorithm.Keccak288] with output size of 288
 */
fun Hashing.keccak288() = keccak(288)

/**
 * Hashing via [Algorithm.Keccak384] with output size of 384
 */
fun Hashing.keccak384() = keccak(384)

/**
 * Hashing via [Algorithm.Keccak512] with output size of 512
 */
fun Hashing.keccak512() = keccak(512)

/**
 * Hashing via Keccak's F1600
 */
fun Hashing.keccak1600() = value.toByteArray().keccak.f1600()