import java.io.InputStream

/**
 * Day 1
 */

fun launchTask1() {
    val array = readFileLineByLineUsingForEachLine("test.txt")
    println(firstTask(array))
    println(secondTask(array))
}

fun readFileLineByLineUsingForEachLine(fileName: String): List<Int> {
    val inputStream: InputStream = {}.javaClass.getResourceAsStream(fileName)
    val lineList = mutableListOf<Int>()
    inputStream.bufferedReader().forEachLine { lineList.add(it.toInt()) }
    inputStream.close()
    return lineList
}

fun firstTask(array: List<Int>): Int = array
    .zip(array.drop(1))
    .map { it.first < it.second }
    .count { it }

fun secondTask(array: List<Int>): Int = firstTask(array
    .zip(array.drop(1))
    .zip(array.drop(2))
    .map { it.first.first + it.first.second + it.second })