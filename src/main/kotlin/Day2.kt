import java.io.InputStream
import kotlin.math.absoluteValue

fun launchDay2() {
    val array = readInput2("day2.txt")
    println(dayTwoFirstTask(array))
    println(dayTwoSecondTask(array))
}

fun readInput2(fileName: String): List<Pair<Direction, Int>> {
    val inputStream: InputStream = {}.javaClass.getResourceAsStream(fileName)
    val pairList = mutableListOf<Pair<Direction, Int>>()
    inputStream.bufferedReader().forEachLine {
        val splitted = it.split(" ")
        pairList.add(Pair(Direction.valueOf(splitted[0].uppercase()), splitted[1].toInt()))
    }
    inputStream.close()
    return pairList
}

fun dayTwoFirstTask(list: List<Pair<Direction, Int>>): Int {
    val map = list.groupBy { it.first }
    val forward = map[Direction.FORWARD]!!.sumOf { it.second }
    val up = map[Direction.UP]!!.sumOf { it.second }
    val down = map[Direction.DOWN]!!.sumOf { it.second }
    return forward * (down - up).absoluteValue
}

fun dayTwoSecondTask(list: List<Pair<Direction, Int>>): Int {
    var aim = 0
    var horizontal = 0
    var vertical = 0
    list.forEach{
        when(it.first) {
            Direction.UP -> aim -= it.second
            Direction.DOWN -> aim += it.second
            Direction.FORWARD -> {
                horizontal += it.second
                vertical += aim * it.second
            }
        }
    }
    return horizontal * vertical
}

enum class Direction {
    FORWARD,
    DOWN,
    UP
}