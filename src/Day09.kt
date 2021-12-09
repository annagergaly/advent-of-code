fun main() {
    val input = readInput("Day09")
    var values = Array(input.size+2) {Array(input[0].length+2) {9} }
    for (i in 0 until input.size) {
        val string = input[i].toCharArray()
        for (j in 0 until string.size) {
            values[i+1][j+1] = string[j].digitToInt()
        }
    }

    var sum = 0
    val lowpoints = mutableListOf<Pair<Int, Int>>()

    for (i in 1 until values.size-1) {
        for (j in 1 until values[0].size-1) {
            if (values[i][j] < values[i+1][j] && values[i][j] < values[i][j+1] && values[i][j] < values[i-1][j] && values[i][j] < values[i][j-1]) {
                sum += values[i][j]+1
                lowpoints.add(Pair(i, j))
            }
        }
    }
    println(sum)

    val basins = List(lowpoints.size) {1}.toMutableList()

    for (lp in lowpoints) {
        val visiting = mutableListOf<Pair<Int, Int>>()
        val visited = mutableSetOf<Pair<Int, Int>>()
        visiting.add(lp)
        while (visiting.size > 0) {
            val current = visiting[0]
            visiting.removeAt(0)
            visited.add(current)
            if (!visited.contains(Pair(current.first-1, current.second)) && values[current.first-1][current.second] < 9 ) {
                visiting.add(Pair(current.first-1, current.second))
            }
            if (!visited.contains(Pair(current.first+1, current.second)) && values[current.first+1][current.second] < 9 ) {
                visiting.add(Pair(current.first+1, current.second))
            }
            if (!visited.contains(Pair(current.first, current.second-1)) && values[current.first][current.second-1] < 9 ) {
                visiting.add(Pair(current.first, current.second-1))
            }
            if (!visited.contains(Pair(current.first, current.second+1)) && values[current.first][current.second+1] < 9 ) {
                visiting.add(Pair(current.first, current.second+1))
            }
        }
        basins[lowpoints.indexOf(lp)] = visited.size
    }

    val largest = basins.sorted().takeLast(3)
    var product = 1
    for (large in largest)
        product *= large

    println(product)
}