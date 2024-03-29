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

package dev.sublab.ss58

internal val networkTypeLengthRange1 = 0..63
internal val networkTypeLengthRange2 = 64..16383
internal const val publicKeySize = 32
internal const val prefix = "SS58PRE"
internal const val prefixSize = 2

class InvalidAddressException: IllegalArgumentException("Invalid address")
class InvalidChecksumException: IllegalArgumentException("Invalid address checksum")