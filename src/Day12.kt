fun main() {
    val input = readInput("Day12")
    val parts = mutableSetOf<String>()

    for (line in input) {
        parts.add(line.split("-")[0])
        parts.add(line.split("-")[1])
    }
    val map = parts.map { it to mutableListOf<String>() }.toMap()

    for (line in input) {
        val start = line.split("-")[0]
        val end = line.split("-")[1]
        map[start]?.add(end)
        map[end]?.add(start)
    }

    val sum = dfs(map, "start", mutableListOf())
    println(sum)
    val lmao = dfstwice(map, "start", mutableListOf(), null, "")
    println(lmao)
}

fun dfs(graph: Map<String, List<String>>, current : String, visited : MutableList<String>) : Int {
    if (current == "end") {
        return 1
    }
    val new = mutableListOf<String>()
    new.addAll(visited)
    if (current[0].isLowerCase()) {
        new.add(current)
    }
    var sum = 0
    for (n in graph[current]!!) {
        if (!visited.contains(n)) {
            sum += dfs(graph, n, new)
        }
    }
    return sum
}

fun dfstwice(graph: Map<String, List<String>>, current : String, visited : MutableList<String>, twice : String?, out : String) : Int {
    if (current == "end") {
        println(out)
        if (twice != null && !visited.contains(twice)) {
            return 0
        }
        return 1
    }
    val new = mutableListOf<String>()
    new.addAll(visited)
    var sum = 0
    if (current[0].isLowerCase()) {
        if (twice == null && current != "start") {
            for (n in graph[current]!!) {
                if (!visited.contains(n)) {
                    sum += dfstwice(graph, n, new, current, "$out $current")
                }
            }
        }
        new.add(current)
    }
    for (n in graph[current]!!) {
        if (!visited.contains(n)) {
            sum += dfstwice(graph, n, new, twice, "$out $current")
        }
    }
    return sum
}