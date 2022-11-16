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