fun main() {
    val input = readInput("Day14")
    var string = input[0]
    val rules = input.takeLast(input.size-2).map { Pair(it.split(" -> ")[0], it.split(" -> ")[1])}.toMap()
    repeat(10) {
        var new = string[0].toString()
        for (i in 0..string.length-2) {
            val key = string.substring(i, i+2)
            new += rules[key]!! + key[1]
        }
        string = new
    }
    val values = string.map { string.filter { c: Char -> c==it }.count() }.sortedDescending()
    println(values.first()-values.last())

    var pairCount = input.takeLast(input.size-2).map { Pair(it.split(" -> ")[0], 0L)}.toMap().toMutableMap()
    val pairs = input.takeLast(input.size-2).map { it.split(" -> ")[0] }
    for (i in 0..string.length-2) {
        val key = string.substring(i, i+2)
        pairCount[key] = pairCount[key]!!.plus(1)
    }
    repeat(30) {
        val new = mutableMapOf<String, Long>()
        for (element in pairCount) {
            val newChar = rules[element.key]!!
            val keys = listOf(element.key[0].toString() + newChar, newChar + element.key[1].toString())
            for (key in keys) {
                if (new.containsKey(key)) {
                    new[key] = new[key]!!+element.value
                } else {
                    new[key] = element.value
                }
            }
        }
        pairCount = new
    }
    val characters = pairs.flatMap { it.toList() }.toSet().toList()
    val count = MutableList(characters.count()) {0L}

    for (element in pairCount) {
        count[characters.indexOf(element.key[0])] += element.value
        count[characters.indexOf(element.key[1])] += element.value
    }
    count.sort()
    println((count.last() - count.first())/2)
}