fun main() {
    val input = readInput("Day15")
    val risk = Array(input.size) {i: Int ->  Array(input[i].length) {input[i][it].digitToInt()} }
    val found = Array(input.size) {Array(input[0].length) {false} }
    val totalrisk = Array(input.size) {Array(input[0].length) {Int.MAX_VALUE} }
    var current = Pair(0,0)
    totalrisk[0][0] = 0
    while (!found[input.size-1][input[0].length-1]) {
        val x = current.first
        val y = current.second
        found[x][y] =  true
        if (x+1 in input.indices && !found[x+1][y]) {
            if (totalrisk[x+1][y] == 0)
                totalrisk[x+1][y] = totalrisk[x][y] + risk[x+1][y]
            else {
                if (totalrisk[x][y] + risk[x+1][y] < totalrisk[x+1][y])
                    totalrisk[x+1][y] = totalrisk[x][y] + risk[x+1][y]
            }
        }
        if (x-1 in input.indices && !found[x-1][y]) {
            if (totalrisk[x-1][y] == 0)
                totalrisk[x-1][y] = totalrisk[x][y] + risk[x-1][y]
            else {
                if (totalrisk[x][y] + risk[x-1][y] < totalrisk[x-1][y])
                    totalrisk[x-1][y] = totalrisk[x][y] + risk[x-1][y]
            }
        }
        if (y-1 in input.indices && !found[x][y-1]) {
            if (totalrisk[x][y-1] == 0)
                totalrisk[x][y-1] = totalrisk[x][y] + risk[x][y-1]
            else {
                if (totalrisk[x][y] + risk[x][y-1] < totalrisk[x][y-1])
                    totalrisk[x][y-1] = totalrisk[x][y] + risk[x][y-1]
            }
        }
        if (y+1 in input.indices && !found[x][y+1]) {
            if (totalrisk[x][y+1] == 0)
                totalrisk[x][y+1] = totalrisk[x][y] + risk[x][y+1]
            else {
                if (totalrisk[x][y] + risk[x][y+1] < totalrisk[x][y+1])
                    totalrisk[x][y+1] = totalrisk[x][y] + risk[x][y+1]
            }
        }
        var minvalue = Int.MAX_VALUE
        var min = Pair(0,0)
        for (i in input.indices) {
            for (j in input[0].indices) {
                if (totalrisk[i][j] < minvalue && !found[i][j]) {
                    minvalue = totalrisk[i][j]
                    min = Pair(i,j)
                }
            }
        }
        current = min
    }
    println(totalrisk[input.size-1][input[0].length-1])

    val risk5 = Array(500) {i: Int ->  Array(500) {
        if ((input[i.mod(input.size)][it.mod(input.size)].digitToInt() + i/input.size + it / input.size).mod(9) == 0){
            9
        }else {
            (input[i.mod(input.size)][it.mod(input.size)].digitToInt() + i/input.size + it / input.size).mod(9)
        }
    }
    }
    val found5 = Array(input.size*5) {Array(input[0].length*5) {false} }
    val totalrisk5 = Array(input.size*5) {Array(input[0].length*5) {Int.MAX_VALUE} }
    current = Pair(0,0)
    totalrisk5[0][0] = 0

    while (!found5[input.size*5-1][input[0].length*5-1]) {
        val x = current.first
        val y = current.second
        found5[x][y] =  true
        println(current)
        if (x+1 in found5.indices && !found5[x+1][y]) {
            if (totalrisk5[x+1][y] == 0)
                totalrisk5[x+1][y] = totalrisk5[x][y] + risk5[x+1][y]
            else {
                if (totalrisk5[x][y] + risk5[x+1][y] < totalrisk5[x+1][y])
                    totalrisk5[x+1][y] = totalrisk5[x][y] + risk5[x+1][y]
            }
        }
        if (x-1 in found5.indices && !found5[x-1][y]) {
            if (totalrisk5[x-1][y] == 0)
                totalrisk5[x-1][y] = totalrisk5[x][y] + risk5[x-1][y]
            else {
                if (totalrisk5[x][y] + risk5[x-1][y] < totalrisk5[x-1][y])
                    totalrisk5[x-1][y] = totalrisk5[x][y] + risk5[x-1][y]
            }
        }
        if (y-1 in found5.indices && !found5[x][y-1]) {
            if (totalrisk5[x][y-1] == 0)
                totalrisk5[x][y-1] = totalrisk5[x][y] + risk5[x][y-1]
            else {
                if (totalrisk5[x][y] + risk5[x][y-1] < totalrisk5[x][y-1])
                    totalrisk5[x][y-1] = totalrisk5[x][y] + risk5[x][y-1]
            }
        }
        if (y+1 in found5.indices && !found5[x][y+1]) {
            if (totalrisk5[x][y+1] == 0)
                totalrisk5[x][y+1] = totalrisk5[x][y] + risk5[x][y+1]
            else {
                if (totalrisk5[x][y] + risk5[x][y+1] < totalrisk5[x][y+1])
                    totalrisk5[x][y+1] = totalrisk5[x][y] + risk5[x][y+1]
            }
        }
        var minvalue = Int.MAX_VALUE
        var min = Pair(0,0)
        for (i in found5.indices) {
            for (j in found5.indices) {
                if (!found5[i][j] && totalrisk5[i][j] < minvalue) {
                    minvalue = totalrisk5[i][j]
                    min = Pair(i,j)
                }
            }
        }
        current = min
    }
    println(totalrisk5[input.size*5-1][input[0].length*5-1])
}