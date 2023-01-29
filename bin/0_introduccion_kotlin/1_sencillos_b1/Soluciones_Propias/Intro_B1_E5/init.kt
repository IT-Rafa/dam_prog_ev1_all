/* Intro_B1_E5
    Escribe código equivalente al siguiente sin utilizar el operador unario ++, es
    decir incrementando de la forma x=x+1
    
    fun main() {
        var x = 3
        val y: Int
        y = x++ * 2
        println("x: $x y:$y")
    }
*/

// Time to do: 5 minutes


fun main() {
    var x = 3
    val y: Int
    y = x * 2
    x = x + 1
    println("x:$x y:$y")
}
