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

package dev.sublab.hashing

import dev.sublab.hashing.hashers.xx128
import dev.sublab.hashing.support.TestCase
import dev.sublab.hex.hex
import kotlin.test.Test
import kotlin.test.assertContentEquals

class TestXXHash {
    private val xx128TestCases = listOf(
        TestCase("Sudo", "0x5c0d1176a568c1f92944340dbfed9e9c".hex.decode()),
        TestCase("Key", "0x530ebca703c85910e7164cb7d1c9e47b".hex.decode()),
        TestCase("Balances", "0xc2261276cc9d1f8598ea4b6a74b15c2f".hex.decode()),
        TestCase("FreeBalance", "0x6482b9ade7bc6657aaca787ba1add3b4".hex.decode()),
    )

    @Test
    internal fun testXX128() {
        for (case in xx128TestCases) {
            val valueByteArray = case.value.toByteArray()

            val byteArrayHash = valueByteArray.hashing.xx128()
            assertContentEquals(case.expectedHash, byteArrayHash)

            val stringHash = case.value.hashing.xx128()
            assertContentEquals(case.expectedHash, stringHash)
        }
    }
}