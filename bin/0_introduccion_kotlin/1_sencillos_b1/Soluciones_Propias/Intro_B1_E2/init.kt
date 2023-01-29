/* Intro_B1_E2:
    En este ejercicio tenemos que intercambiar el valor de dos
    variables. El intercambio de variables es muy importante entenderlo bien pues
    se utiliza mucho en todo tipo de programas. En el siguiente código, la variable z
    la usarás como variable intermedia o de apoyo para conseguir que x e y
    intercambien correctamente sus valores.
    fun main() {
        var x=10
        var y=20
        var z:Int
        println("ANTES: x vale "+ x + " y vale "+y )
        ........instrucciones que realizan el intercambio de valores
        println("DESPUES: x vale $x y vale $y" )
    }
*/

fun main() {
    var x = 10
    var y = 20
    var z: Int
    println("ANTES: x vale " + x + " y vale " + y)
    z = x
    x = y
    y = z
    println("DESPUES: x vale $x y vale $y")
}
