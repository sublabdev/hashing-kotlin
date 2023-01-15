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

private fun ByteArray.xx(width: Long) = (0 until width/64)
    .map {
        Algorithm.XXHash64(it)
            .createDigest()
            .apply { update(this@xx) }
            .digest()
            .reversedArray()
    }
    .fold(byteArrayOf()) { result, hash -> result + hash }

/**
 * Hashing via XX with output size of 64
 */
fun Hashing.xx64() = value.toByteArray().xx(64)

/**
 * Hashing via XX with output size of 128
 */
fun Hashing.xx128() = value.toByteArray().xx(128)

/**
 * Hashing via XX with output size of 256
 */
fun Hashing.xx256() = value.toByteArray().xx(256)