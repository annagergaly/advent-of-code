class board(input : List<String>) {
    var numbers = Array(5) {Array(5) {0} }
    var hits = Array(5) {Array(5) {false} }
    var won = false

    init {
        for (i in 0..4) {
            val line = input[i].trim().split("\\s+".toRegex())
            for (j in 0..4) {
                numbers[i][j] = line[j].toInt()
            }
        }
    }

    fun numberDrawn(n: Int) : Boolean{
        for (i in 0..4) {
            for (j in 0..4) {
                if (numbers[i][j] == n) {
                    hits[i][j] = true
                    return didIWin(i, j)
                }
            }
        }
        return false
    }

    fun didIWin(i : Int, j : Int) : Boolean{
        var b = true
        for (n in 0..4) {
            if (!hits[i][n]) {
                b = false
            }
        }
        if (b)
            return true
        b = true
        for (n in 0..4) {
            if (!hits[n][j]) {
                b = false
            }
        }
        if (b)
            return true
        return false
    }

    fun uncalledSum() : Int {
        var sum = 0
        for (i in 0..4) {
            for (j in 0..4) {
                if (!hits[i][j]) {
                    sum += numbers[i][j]
                }
            }
        }
        return sum
    }
}

fun main() {
    val input = readInput("Day04")
    val nums = input[0].split(',')
    val numbers = List(nums.size) { nums[it].toInt() }
    val boards = mutableListOf<board>()

    for (i in 2..input.size step 6) {
        boards.add(board(input.subList(i, i+5)))
    }

    for (n in numbers) {
        for (b in boards) {
            if (!b.won && b.numberDrawn(n)) {
                println(b.uncalledSum() * n)
                b.won = true
            }
        }
    }
}