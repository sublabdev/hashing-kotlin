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

private fun ByteArray.blake2b(outputSize: Int) = Algorithm.Blake2b(outputSize)
    .createDigest()
    .apply { update(this@blake2b) }
    .digest()

/**
 * Hashing via [Algorithm.Blake2b] using the provided output size
 * @param outputSize the size of output
 */
fun Hashing.blake2b(outputSize: Int) = value.toByteArray().blake2b(outputSize)

/**
 * Hashes via [Algorithm.Blake2b] with output size of 128
 */
fun Hashing.blake2b_128() = blake2b(128)

/**
 * Hashes via [Algorithm.Blake2b] with output size of 160
 */
fun Hashing.blake2b_160() = blake2b(160)

/**
 * Hashes via [Algorithm.Blake2b] with output size of 256
 */
fun Hashing.blake2b_256() = blake2b(256)

/**
 * Hashes via [Algorithm.Blake2b] with output size of 384
 */
fun Hashing.blake2b_384() = blake2b(384)

/**
 * Hashes via [Algorithm.Blake2b] with output size of 512
 */
fun Hashing.blake2b_512() = blake2b(512)