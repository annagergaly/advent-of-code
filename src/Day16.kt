fun main() {
    val input = readInput("Day16")
    var bits = ""
    for (c in input[0]) {
        bits += when (c) {
            '0' -> "0000"
            '1' -> "0001"
            '2' -> "0010"
            '3' -> "0011"
            '4' -> "0100"
            '5' -> "0101"
            '6' -> "0110"
            '7' -> "0111"
            '8' -> "1000"
            '9' -> "1001"
            'A' -> "1010"
            'B' -> "1011"
            'C' -> "1100"
            'D' -> "1101"
            'E' -> "1110"
            'F' -> "1111"
            else -> ""
        }
    }
    var sumVersion = 0

    fun List<Long>.product() : Long{
        var p = 1L
        for (n in this)
            p *= n
        return p
    }

    fun List<Long>.greater() : Long {
        if (this[0] > this[1]) {
            return 1L
        }
        return 0L
    }

    fun List<Long>.less() : Long {
        if (this[0] < this[1]) {
            return 1L
        }
        return 0L
    }

    fun List<Long>.equal() : Long {
        if (this[0] == this[1]) {
            return 1L
        }
        return 0L
    }

    fun parsePacket(start : Long) : Pair<Long,Long> {
        val part = bits.substring(start.toInt())
        val version = part.substring(0..2).toInt(2)
        sumVersion += version
        val type = part.substring(3..5).toInt(2)
        if (type == 4) {
            var done = false
            var s = 6
            var literal = ""
            while (!done) {
                if (part[s] == '0')
                    done = true
                literal += part.substring(s+1..s+4)
                s += 5
            }
            return Pair(s.toLong(), literal.toLong(2))
        } else {
            val operation = when (type) {
                0 -> List<Long>::sum
                1 -> List<Long>::product
                2 -> List<Long>::minOrNull
                3 -> List<Long>::maxOrNull
                5 -> List<Long>::greater
                6 -> List<Long>::less
                7 -> List<Long>::equal
                else -> List<Long>::first
            }
            var length = 0L
            val packets = mutableListOf<Long>()
            if (part[6] == '0') {
                val totalLength = part.substring(7 until 7+15).toLong(2)
                while (length < totalLength) {
                    val result = parsePacket(start+7+15+length)
                    length += result.first
                    packets.add(result.second)
                }
                return Pair(7+15+length, operation(packets)!!)
            } else {
                val numberOfPackets = part.substring(7 until 7+11).toLong(2)
                for (i in 0 until numberOfPackets) {
                    val result = parsePacket(start+7+11+length)
                    length += result.first
                    packets.add(result.second)
                }
                return Pair(7+11+length, operation(packets)!!)
            }
        }
    }
    val value = parsePacket(0).second
    println(sumVersion)
    println(value)
}

