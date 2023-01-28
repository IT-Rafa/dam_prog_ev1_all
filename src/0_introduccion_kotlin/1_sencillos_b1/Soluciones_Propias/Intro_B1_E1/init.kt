/* Intro_B1_E1:
    Escribe un programa que guarde en una variable entera la longitud del lado de
    un cuadrado, con dicha variable calcula el área del cuadrado y almacena este
    valor en otra variable. Imprime por pantalla el valor de esta última variable.

    Piensa al hacer este sencillo ejercicio en nombres apropiados para las variables
    utilizadas y piensa también en si es mejor declarar el tipo o
    dejar que el compilador lo deduzca.

    Ejemplo de posible salida:
    Para un cuadrado de lado 4 su area es 16
*/

fun main() {
    var lado = 4
    var area = lado * lado
    println("Para un cuadrado de lado $lado, su area es $area")
}
