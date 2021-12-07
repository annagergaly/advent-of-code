import kotlin.math.absoluteValue

fun main() {
    val input = readInput("Day07")
    val numbers = List(input[0].split(",").size) { input[0].split(",")[it].toInt() }
    val median = numbers.sorted()[numbers.size/2]
    var sum = 0
    for (n in numbers) {
        sum += (n-median).absoluteValue
    }
    println(sum)

    var min = Int.MAX_VALUE
    for (i in 0 until numbers.maxOf { it }) {
        sum = 0
        for (n in numbers) {
            val change = (n-i).absoluteValue
            val fuel = change*(change+1)/2
            sum += fuel
        }
        if (sum < min)
            min = sum
    }
    println(min)

}