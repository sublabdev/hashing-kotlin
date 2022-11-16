package dev.sublab.ss58

internal val networkTypeLengthRange1 = 0..63
internal val networkTypeLengthRange2 = 64..16383
internal const val publicKeySize = 32
internal const val prefix = "SS58PRE"
internal const val prefixSize = 2

class InvalidAddressException: IllegalArgumentException("Invalid address")
class InvalidChecksumException: IllegalArgumentException("Invalid address checksum")