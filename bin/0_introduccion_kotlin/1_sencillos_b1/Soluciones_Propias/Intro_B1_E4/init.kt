/* Intro_B1_E4.
    Dados unos segundos iniciales (500000 en el ejemplo) los distribuimos en días,
    horas, minutos y segundos como en el ejemplo que sigue.
    Para resolver el problema tendrás que usar la división entera tanto para obtener
    el cociente como el resto.

    500000 segundos= 5 días, 18 horas, 53 minutos y 20 segundos
*/

fun main() {
    var segMin = 60
    var segHora = segMin * 60
    var segDia = segHora * 24

    var segundos = 500000
    var resto = segundos
    var dias = resto / segDia
    resto = resto % segDia

    var horas = resto / segHora
    resto = resto % segHora

    var minutos = resto / segMin
    resto = resto % segMin

    println("$segundos segundos = $dias dias, $horas horas, $minutos minutos y $resto segundos")
}
