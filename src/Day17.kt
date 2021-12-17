fun main() {
    val xLower = 94
    val xHigher = 151
    val yLower = -156
    val yHigher = -103
    val maxHeights = mutableListOf<Int>()
    for (vx in 13..152) {
        for (vy in -157..1000) {
            var x = 0
            var y = 0
            var xcurrent = vx
            var ycurrent =vy
            var maxHeight = 0
            while (x < xHigher && y > yLower) {
                x += xcurrent
                y += ycurrent
                if (y > maxHeight)
                    maxHeight = y
                if (xcurrent > 0)
                    xcurrent--
                ycurrent--
                if (x in xLower..xHigher && y in yLower..yHigher) {
                    maxHeights.add(maxHeight)
                    break
                }
            }
        }
    }

    println(maxHeights.maxOrNull())
    println(maxHeights.size)
}