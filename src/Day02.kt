fun main() {
    val input = readInput("Day02")
    var depth = 0
    var forward = 0
    var aim = 0
    for (i in 0 until input.size) {
        if (input[i].startsWith("forward"))
            forward += input[i].split(" ")[1].toInt()
        if (input[i].startsWith("down"))
            depth += input[i].split(" ")[1].toInt()
        if (input[i].startsWith("up"))
            depth -= input[i].split(" ")[1].toInt()
    }
    println(depth * forward)

    depth = 0
    forward = 0
    for (i in 0 until input.size) {
        if (input[i].startsWith("forward")) {
            forward += input[i].split(" ")[1].toInt()
            depth += aim * input[i].split(" ")[1].toInt()
        }
        if (input[i].startsWith("down"))
            aim += input[i].split(" ")[1].toInt()
        if (input[i].startsWith("up"))
            aim -= input[i].split(" ")[1].toInt()
    }
    println(depth * forward)
}