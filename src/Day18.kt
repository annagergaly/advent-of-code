fun main() {
    val input = readInput("Day18")
    var number = input[0]
    for (i in 1 until input.size) {
        number = "[" + number + "," + input[i] + "]"
        while (number.isWrong()) {
            if (number.isTooNested()) {
                number = number.explode()
            }
            if (number.isTooLarge()) {
                number = number.splitNumber()
            }
        }
    }
}
fun String.isTooNested() : Boolean {
    var counter = 0
    for (c in this) {
        if (c == '[')
            counter++
        if (c == ']')
            counter--
        if (counter >= 4)
            return true
    }
    return false
}

fun String.isTooLarge() : Boolean {
        val pieces = this.split(',', '[', ']')
        for (p in pieces) {
            if (p.length == 2) {
                return true
            }
        }
        return false

}

private fun String.isWrong(): Boolean {
    if (isTooLarge() || isTooNested())
        return true
    return false
}

fun String.explode() : String {
    var counter = 0
    for (i in 0 until length) {
        if (get(i) == '[')
            counter++
        if (get(i) == ']')
            counter--
        if (counter == 4) {
            val first = this.substring(i+1).split(",")[0].toInt()
            val second = this.substring(i+1).split(",")[1].toInt()
            var before = this.substring(0 until i)
            var after = this.substring(i+1).replaceBefore(']', "").removePrefix("]")
            val leftNumber = before.split(',', ']', '[').findLast { it.isNotEmpty() }?.toInt()
            if (leftNumber != null)

        }

    }
}

fun String.splitNumber() : String {

}