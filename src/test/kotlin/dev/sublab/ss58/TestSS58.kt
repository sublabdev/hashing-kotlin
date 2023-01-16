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

import dev.sublab.hashing.support.TestCase
import dev.sublab.hex.hex
import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals

class TestSS58 {
    private val testCases = listOf(
        TestCase("HNZata7iMYWmk5RvZRTiAsSDhV8366zq2YGb3tLH5Upf74F", "0xd43593c715fdd31c61141abd04a99fd6822c8558854ccde39a5684e7a56da27d".hex.decode()),
        TestCase("jHEP5XeYLTTGzjhXroSczrWbV928KaxDQiQH6WakYtRjWuUzK", "0x65766d3a7dd4dda4ec7344de16fde4f0c08c95f038e99e960000000000000000".hex.decode())
    )

    @Test
    internal fun testAddressesDecoding() {
        for (case in testCases) {
            val accountId = case.value.ss58.accountId()
            assertContentEquals(case.expectedHash, accountId)

            val networkType = case.value.ss58.networkType()
            val address = accountId.ss58.address(networkType)
            assertEquals(case.value, address)
        }
    }
}