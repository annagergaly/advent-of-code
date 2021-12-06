fun main() {
    val input = readInput("Day05")
    val board = Array(1000) {Array(1000) {0} }
    val starting = List(input.size) {input[it].split(" -> ")[0]}
    val ending = List(input.size) {input[it].split(" -> ")[1]}

    for (i in 0 until starting.size) {
        val startX = starting[i].split(",")[0].toInt()
        val endX = ending[i].split(",")[0].toInt()
        val startY = starting[i].split(",")[1].toInt()
        val endY = ending[i].split(",")[1].toInt()

        if (startX == endX) {
            if (startY < endY) {
                for (y in startY..endY) {
                    board[startX][y]++
                }
            } else {
                for (y in endY..startY) {
                    board[startX][y]++
                }
            }
        } else if (startY == endY) {
            if (startX < endX) {
                for (x in startX..endX) {
                    board[x][startY]++
                }
            } else {
                for (x in endX..startX) {
                    board[x][startY]++
                }
            }
        } else {
            if (startX < endX) {
                if (startY < endY) {
                    for (j in 0..endY-startY) {
                        board[startX+j][startY+j]++
                    }
                } else {
                    for (j in 0..startY-endY) {
                        board[startX+j][startY-j]++
                    }
                }
            } else {
                if (startY < endY) {
                    for (j in 0..endY-startY) {
                        board[startX-j][startY+j]++
                    }
                } else {
                    for (j in 0..startY-endY) {
                        board[startX-j][startY-j]++
                    }
                }
            }
        }
    }

    var danger = 0
    for (i in 0 until 1000) {
        for (j in 0 until 1000) {
            print(board[j][i].toString() + " ")
            if (board[i][j] > 1)
                danger++
        }
        println()
    }
    println(danger)
}