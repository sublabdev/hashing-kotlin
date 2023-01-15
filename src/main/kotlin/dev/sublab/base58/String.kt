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

package dev.sublab.base58

/**
 * An object that handles `String`'s decoding using `Base58`
 * @property string the `String` to decode
 */c
class StringBase58(private val string: String) {
    fun decode() = Base58Coder.decode(string)
}

/**
 * `String` decoder using base58
 */
val String.base58
    get() = StringBase58(this)