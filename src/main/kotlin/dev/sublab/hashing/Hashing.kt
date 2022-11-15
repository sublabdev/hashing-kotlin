package dev.sublab.hashing

import dev.sublab.hashing.utils.ByteArrayConvertible
import dev.sublab.hashing.utils.asByteArrayConvertible

class Hashing(internal val value: ByteArrayConvertible)

val ByteArray.hashing: Hashing
    get() = Hashing(asByteArrayConvertible())

val String.hashing: Hashing
    get() = Hashing(asByteArrayConvertible())