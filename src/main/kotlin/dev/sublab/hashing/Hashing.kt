package dev.sublab.hashing

import dev.sublab.common.ByteArrayConvertible
import dev.sublab.common.asByteArrayConvertible

class Hashing(internal val value: ByteArrayConvertible)

val ByteArray.hashing: Hashing
    get() = Hashing(asByteArrayConvertible())

val String.hashing: Hashing
    get() = Hashing(asByteArrayConvertible())