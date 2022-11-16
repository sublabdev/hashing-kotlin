package dev.sublab.hashing

import dev.sublab.utils.ByteArrayConvertible
import dev.sublab.utils.asByteArrayConvertible

class Hashing(internal val value: ByteArrayConvertible)

val ByteArray.hashing: Hashing
    get() = Hashing(asByteArrayConvertible())

val String.hashing: Hashing
    get() = Hashing(asByteArrayConvertible())