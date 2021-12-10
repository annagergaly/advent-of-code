fun main() {
    val input = readInput("Day10")
    val remaining = input.toMutableList()
    var points = 0
    for (line in input) {
        val list = mutableListOf<Char>()
        val array = line.toCharArray()
        for (char in array) {
            when (char) {
                '(' -> list.add('(')
                '[' -> list.add('[')
                '{' -> list.add('{')
                '<' -> list.add('<')
                ')' -> {
                    if (list.last() == '(') {
                        list.removeLast()
                    } else {
                        points += 3
                        remaining.remove(line)
                        break
                    }
                }
                ']' -> {
                    if (list.last() == '[') {
                        list.removeLast()
                    } else {
                        points += 57
                        remaining.remove(line)
                        break
                    }
                }
                '}' -> {
                    if (list.last() == '{') {
                        list.removeLast()
                    } else {
                        points += 1197
                        remaining.remove(line)
                        break
                    }
                }
                '>' -> {
                    if (list.last() == '<') {
                        list.removeLast()
                    } else {
                        points += 25137
                        remaining.remove(line)
                        break
                    }
                }
            }
        }
    }
    println(points)

    val scores = Array(remaining.size) {0L}
    for (i in 0 until remaining.size) {
        val list = mutableListOf<Char>()
        val array = remaining[i].toCharArray()
        for (char in array) {
            when (char) {
                '(' -> list.add('(')
                '[' -> list.add('[')
                '{' -> list.add('{')
                '<' -> list.add('<')
                else -> list.removeLast()
            }
        }
        for (j in list.indices.reversed()) {
            scores[i] *= 5L
            scores[i] += when (list[j]){
                '(' -> 1L
                '[' -> 2L
                '{' -> 3L
                '<' -> 4L
                else -> 0L
            }
        }
    }
    println(scores.sorted()[scores.size/2])
}