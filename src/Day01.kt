fun main() {
    val input = readInput("Day01")
    var count = 0
    for (i in 1 until input.size) {
        if (input[i].toInt() > input[i-1].toInt())
            count++
    }
    println(count)
    count = 0
    for (i in 1..input.size-3) {
        if (input[i+2].toInt() > input[i-1].toInt())
            count++
    }
    println(count)
}