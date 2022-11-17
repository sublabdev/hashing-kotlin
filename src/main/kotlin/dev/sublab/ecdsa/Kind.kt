package dev.sublab.ecdsa

import dev.sublab.hashing.Hashing
import dev.sublab.hashing.hashers.blake2b_256
import dev.sublab.hashing.hashers.keccak256

enum class Kind {
    SUBSTRATE,
    ETHEREUM
}

fun Kind.hash(hashing: Hashing) = when (this) {
    Kind.SUBSTRATE -> hashing.blake2b_256()
    Kind.ETHEREUM -> hashing.keccak256()
}