fun main() {
    val input = readInput("Day13")
    val points = input.map { Pair(it.split(",")[0].toInt(), it.split(",")[1].toInt()) }
    var set = points.toSet()

    val folds = readInput("Day13_folds").map { it.removePrefix("fold along ") }.map { Pair(it.split("=")[0], it.split("=")[1].toInt())  }
    for (f in folds) {
        set = if (f.first == "x") {
            foldOnX(set, f.second)
        } else {
            foldOnY(set, f.second)
        }
    }
    println(set.count())
    for (i in 0..set.map { it.second }.maxOrNull()!!) {
        for (j in 0..set.map { it.first }.maxOrNull()!!) {
            if (set.contains(Pair(j, i))) {
                print("#")
            } else {
                print(".")
            }
        }
        println()
    }
}

fun foldOnX(points : Iterable<Pair<Int, Int>>, x : Int) : MutableSet<Pair<Int,Int>> {
    val set = mutableSetOf<Pair<Int, Int>>()
    for (p in points) {
        val first : Int = if (p.first < x) p.first else x - (p.first - x)
        val second = p.second
        set.add(Pair(first, second))
    }
    return set
}

fun foldOnY(points : Iterable<Pair<Int, Int>>, y : Int) : MutableSet<Pair<Int,Int>> {
    val set = mutableSetOf<Pair<Int, Int>>()
    for (p in points) {
        val first = p.first
        val second : Int = if (p.second < y) p.second else  y - (p.second - y)
        set.add(Pair(first, second))
    }
    return set
}
