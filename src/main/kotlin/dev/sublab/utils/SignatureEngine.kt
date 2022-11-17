package dev.sublab.utils

interface SignatureEngine {
    fun createPrivateKey(): ByteArray
    fun publicKey(): ByteArray
    fun sign(privateKey: ByteArray): ByteArray
    fun verify(signature: ByteArray, publicKey: ByteArray): Boolean
}