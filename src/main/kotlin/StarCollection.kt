class StarCollection() {
    var stars = mutableListOf<Star>()
    var minX = Int.MAX_VALUE
    var maxX = Int.MIN_VALUE
    var minY = Int.MAX_VALUE
    var maxY = Int.MIN_VALUE
    var rangeX = Int.MAX_VALUE
    var rangeY = Int.MAX_VALUE

    fun add(star: Star): Unit {
        stars.add(star)
    }

    fun getRange(): Int {
        minX = Int.MAX_VALUE
        maxX = Int.MIN_VALUE
        minY = Int.MAX_VALUE
        maxY = Int.MIN_VALUE
        for (star in stars) {
            minX = Math.min(star.posX, minX)
            maxX = Math.max(star.posX, maxX)
            minY = Math.min(star.posY, minY)
            maxY = Math.max(star.posY, maxY)
        }
        return maxX - minX
    }

    fun step(step: Int): Int {
        for (star in stars) {
            star.move(step)
        }
        return getRange()
    }

    fun findMinRange() {
        rangeX = getRange()
        var newRange = rangeX
        var steps = 0;
        while (rangeX >= newRange) {
            steps++
            rangeX = newRange
            newRange = step(1)
        }
        steps--
        rangeX = step(-1)
        rangeY = maxY - minY
        println("steps ${steps}, range ${rangeX} ")

        var message = Array(rangeY + 1) { Array(rangeX + 1) { "." } }

        for (star in stars) {
            message[star.posY - minY][star.posX - minX] = "X"
        }
        for (array in message) {
            for (value in array) {
                print(value)
            }
            println()
        }
    }
}