fun Array<Array<Int>>.containsLarge() : Boolean {
    for (i in 0..9) {
        for (j in 0..9) {
            if (this[i][j] > 9) {
                return true
            }
        }
    }
    return false
}

fun main() {
    val input = readInput("Day11")
    val list = List(10) { input[it].toCharArray()}
    val octopuses = Array(10) {Array(10) {0} }
    val flashed = Array(10) {Array(10) {false} }

    for (i in 0..9) {
        for (j in 0..9) {
            octopuses[i][j] = list[i][j].digitToInt()
        }
    }
    var all : Boolean
    var flashes = 0
    repeat(1000) {
        for (i in 0..9) {
            for (j in 0..9) {
                octopuses[i][j]++
            }
        }

        while (octopuses.containsLarge()) {
            for (i in 0..9) {
                for (j in 0..9) {
                    if (octopuses[i][j] > 9 && !flashed[i][j]) {
                        flashes++
                        flashed[i][j] = true
                        octopuses[i][j] = 0
                        for (x in -1..1) {
                            for (y in -1..1) {
                                if (i+x in 0..9 && j+y in 0..9 && !(x == 0 && y == 0)) {
                                    if (!flashed[i+x][j+y])
                                        octopuses[i+x][j+y]++
                                }
                            }
                        }
                    }
                }
            }
        }

        all = true
        for (i in 0..9) {
            for (j in 0..9) {
                if (flashed[i][j]) {
                    flashed[i][j] = false
                    octopuses[i][j] = 0
                } else {
                    all = false
                }
            }
        }
        if (all) {
            println(it + 1)
        }
    }
    println(flashes)

}