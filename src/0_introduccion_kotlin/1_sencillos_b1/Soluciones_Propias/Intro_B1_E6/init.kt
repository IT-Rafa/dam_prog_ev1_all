/* Intro_ B1_E6
    Escribe código equivalente al siguiente sin utilizar el operador ++

    fun main() {
        var x = 3
        val y: Int
        y = ++x * 2
        println("x: $x y:$y")
    }
*/

fun main() {
    var x = 3
    val y: Int
    x = x + 1
    y = x * 2
    println("x:$x y:$y")
}
