package dev.sublab.hashing

import dev.sublab.hashing.hashers.blake2b_256
import dev.sublab.hashing.support.TestCase
import dev.sublab.hex.hex
import kotlin.test.Test
import kotlin.test.assertContentEquals

class TestBlake2b {
    private val blake2b256Cases = listOf(
        TestCase("DQHyqj4mJRegcgFFBmFmXAdCwFhAPLiVFiARBbAoU4EDhMM", "0xbcf136a9e09e0a858111de57745c2d143647677aa6d8d28606db3247a164da48".hex.decode()),
    )

    @Test
    internal fun testBlake2b_256() {
        for (case in blake2b256Cases) {
            val valueByteArray = case.value.toByteArray()

            val byteArrayHash = valueByteArray.hashing.blake2b_256()
            assertContentEquals(case.expectedHash, byteArrayHash)

            val stringHash = case.value.hashing.blake2b_256()
            assertContentEquals(case.expectedHash, stringHash)
        }
    }
}