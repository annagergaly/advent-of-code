class decoder(clues: String) {
    val numbers = clues.split(" ")
    val one = numbers.find { it.length == 2 }!!
    val four = numbers.find { it.length == 4 }!!
    val fourminusone = four.replace(one[0].toString(), "").replace(one[1].toString(), "")
    fun decode(input: String): Int {
        when (input.length) {
            2 -> return 1
            3 -> return 7
            4 -> return 4
            5 -> {
                if (input.contains(one[0]) && input.contains(one[1])) {
                    return 3
                } else {
                    if (input.contains(fourminusone[0]) && input.contains(fourminusone[1])) {
                        return 5
                    } else {
                        return 2
                    }
                }
            }
            6 -> {
                if (!(input.contains(one[0]) && input.contains(one[1]))) {
                    return 6
                } else {
                    if (input.contains(four[0]) && input.contains(four[1]) && input.contains(four[2]) && input.contains(four[3])) {
                        return 9
                    } else {
                        return 0
                    }
                }
            }
            7 -> return 8
        }
        return -1
    }
}

fun main() {
    val input = readInput("Day08")
    val outputs = List(input.size) { input[it].split(" | ")[1]}
    val values = outputs.flatMap { line: String ->line.split(" ") }
    var count = 0
    for (v in values) {
        when (v.length) {
            in 2..4 -> count++
            7 -> count++
        }
    }
    println(count)

    val clues = List(input.size) { input[it].split(" | ")[0]}

    var sum = 0
    for (i in 0 until input.size) {
        val d = decoder(clues[i])
        val digits = outputs[i].split(" ")
        sum += 1000 * d.decode(digits[0])
        sum += 100 * d.decode(digits[1])
        sum += 10 * d.decode(digits[2])
        sum += d.decode(digits[3])
    }
    println(sum)
}