package dev.sublab.hashing

class InvalidHashOutputSizeException(size: Int): IllegalArgumentException("Invalid hasher size provided: $size")
class InvalidHashOutputSizesException(sizes: IntArray): IllegalArgumentException("Invalid hasher list of sizes provided: $sizes")