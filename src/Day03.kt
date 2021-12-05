fun main() {
    val input = readInput("Day03")
    var gamma = ""
    var epsilon = ""
    for (i in 0 until input[0].length) {
        var ones = 0
        var zeroes = 0
        for (j in 0 until input.size) {
            if (input[j][i] == '1')
                ones ++
            if (input[j][i] == '0')
                zeroes ++
        }
        if (zeroes > ones) {
            gamma += '0'
            epsilon += '1'
        } else {
            gamma += '1'
            epsilon += '0'
        }
    }
    val gammarate = gamma.toInt(2)
    val epsilonrate = epsilon.toInt(2)
    println(gammarate*epsilonrate)

    val list = mutableListOf<String>()
    list.addAll(input)
    var index = 0

    while (list.size > 1) {
        var ones = 0
        var zeroes = 0
        for (j in 0 until list.size) {
            if (list[j][index] == '1')
                ones ++
            if (list[j][index] == '0')
                zeroes ++
        }
        if (zeroes > ones) {
            for (j in 0 until input.size) {
                if (input[j][index] == '1')
                    list.remove(input[j])
            }
        } else {
            for (j in 0 until input.size) {
                if (input[j][index] == '0')
                    list.remove(input[j])
            }
        }
        index++
    }
    val oxygen = list[0].toInt(2)

    list.clear()
    list.addAll(input)
    index = 0

    while (list.size > 1) {
        var ones = 0
        var zeroes = 0
        for (j in 0 until list.size) {
            if (list[j][index] == '1')
                ones ++
            if (list[j][index] == '0')
                zeroes ++
        }
        if (zeroes > ones) {
            for (j in 0 until input.size) {
                if (input[j][index] == '0')
                    list.remove(input[j])
            }
        } else {
            for (j in 0 until input.size) {
                if (input[j][index] == '1')
                    list.remove(input[j])
            }
        }
        index++
    }

    val CO2 = list[0].toInt(2)

    println(oxygen*CO2)
}
