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