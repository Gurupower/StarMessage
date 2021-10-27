
import java.io.File

fun main(args: Array<String>) {
    var stars = StarCollection()
    File("src/main/resources/msg.txt").useLines {lines -> lines.forEach {
        val parts = it.split("<" , ",", ">")
        println(it)
        stars.add(Star(parts[1].trim().toInt(), parts[2].trim().toInt(), parts[4].trim().toInt(), parts[5].trim().toInt()))

    }}
    stars.findMinRange()

}