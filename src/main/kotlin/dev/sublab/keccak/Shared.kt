package dev.sublab.keccak

/**
 * Encode a 64-bit integer with little-endian convention.
 *
 * @param [value]   the integer to encode
 * @param dst   the destination buffer
 * @param off   the destination offset
 */
internal fun encodeLELong(value: Long, dst: ByteArray, off: Int) {
    dst[off + 0] = value.toByte()
    dst[off + 1] = (value.toInt() ushr 8).toByte()
    dst[off + 2] = (value.toInt() ushr 16).toByte()
    dst[off + 3] = (value.toInt() ushr 24).toByte()
    dst[off + 4] = (value ushr 32).toByte()
    dst[off + 5] = (value ushr 40).toByte()
    dst[off + 6] = (value ushr 48).toByte()
    dst[off + 7] = (value ushr 56).toByte()
}

/**
 * Decode a 64-bit little-endian integer.
 *
 * @param buf   the source buffer
 * @param off   the source offset
 * @return the decoded integer
 */
internal fun decodeLELong(buf: ByteArray, off: Int): Long {
    return (buf[off + 0].toLong() and 0xFF
            or ((buf[off + 1].toLong() and 0xFF) shl 8)
            or ((buf[off + 2].toLong() and 0xFF) shl 16)
            or ((buf[off + 3].toLong() and 0xFF) shl 24)
            or ((buf[off + 4].toLong() and 0xFF) shl 32)
            or ((buf[off + 5].toLong() and 0xFF) shl 40)
            or ((buf[off + 6].toLong() and 0xFF) shl 48)
            or ((buf[off + 7].toLong() and 0xFF) shl 56))
}