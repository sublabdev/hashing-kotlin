package dev.sublab.hashing

class InvalidHashOutputSizeException(size: Int): IllegalArgumentException("Invalid hasher size provided: $size")