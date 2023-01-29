/* Intro_B1_E3
    Calcula el IMC de una persona cuyo peso y altura los tenemos almacenados en
    sus respectivas variables dentro de nuestro programa. La fórmula que calcula el
    IMC es:
        IMC = peso(kg) / altura^2(m)

    Si observas la salida ejemplo, el programa debe imprimir dos cosas:
        ● el IMC calculado para el peso y altura almacenados en las variables
        ● una tabla informativa sobre el IMC para observar en qué tramo se
          encuentran el peso y altura utilizados.

    peso: 74
    altura: 1.66
    IMC: 26.854405574103644


    TABLA INC
    ---------
    Delgado: <18.5
    Normal: entre 18.5 y 24.9
    Sobrepeso: entre 25 y 29.9
    Obeso >=30
*/

fun main() {
    var peso = 74
    var altura = 1.66
    var imc = peso / (altura * altura)
    println("peso: $peso")
    println("altura: $altura")
    println("IMC: $imc")

    println("TABLA INC")
    println("---------")
    println("Delgado: <18.5")
    println("Normal: entre 18.5 y 24.9")
    println("Sobrepeso: entre 25 y 29.9")
    println("Obeso >=30")
}
