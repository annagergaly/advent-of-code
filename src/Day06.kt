class fish(var age: Int) {
    fun tick() : Boolean{
        if (age == 0) {
            age = 6
            return true
        } else {
            age--
            return false
        }
    }
}


fun main() {
    val input = readInput("Day06")
    val numbers = List(input[0].split(",").size) {input[0].split(",")[it].toInt()}

    val fishies = mutableListOf<fish>()
    for (n in numbers)
        fishies.add(fish(n))

    repeat(80) {
        var newfish = 0
        for (f in fishies) {
            if (f.tick())
                newfish++
        }
        repeat(newfish) {
            fishies.add(fish(8))
        }
    }
    println(fishies.size)

    val ages = Array(9) {0L}
    for (n in numbers)
        ages[n]++
    repeat(256) {
        val temp = ages[0]
        for (i in 0..7) {
            ages[i] = ages[i+1]
        }
        ages[8] = temp
        ages[6] += temp
    }
    var sum = 0L
    for (i in 0..8) {
        sum += ages[i]
    }
    println(sum)
}