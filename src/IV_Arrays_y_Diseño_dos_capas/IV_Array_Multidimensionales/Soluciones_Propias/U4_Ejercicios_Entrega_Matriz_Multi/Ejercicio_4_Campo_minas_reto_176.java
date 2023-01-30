package IV_Arrays_y_Diseño_dos_capas.IV_Array_Multidimensionales.Soluciones_Propias.U4_Ejercicios_Entrega_Matriz_Multi;


/* Ejercicio U4_B4B_E1: 
    Acepta el reto Campo de minas id 176.
    Buscamos texto en enlace

    Campo de minas
    Tiempo máximo: 1,000-2,000 s Memoria máxima: 8192 KiB
    Juego de 'Buscaminas' con muchas minas

    Aunque existieron antecedentes previos, el juego Buscaminas comenzó a ser famoso 
    cuando se incluyó en la versión 3.1 de Windows, en el lejano 1992. Corre el rumor 
    de que fue incluído para que los usuarios se entretuvieran mientras, sin saberlo, 
    cogían práctica utilizando un dispositivo por aquel tiempo apenas conocido: el ratón.
    Hoy el juego es archiconocido (y el dispositivo también). El número de variantes e 
    implementaciones es inmenso, y sigue estando incluído en la gran mayoría de los 
    sistemas de escritorio.

    El juego consiste en un tablero rectangular con celdas, algunas de las cuales 
    ocultan minas. El usuario debe ir destapando las celdas con cuidado para no 
    seleccionar ninguna mina. Como ayuda, cada vez que destapa una celda libre, se le 
    muestra cuántas minas tiene alrededor.

    En este problema os daremos la configuración de un tablero de Buscaminas totalmente 
    descubierto, y os pedimos que nos digáis cuántas celdas vacías tienen al menos 6 
    minas a su alrededor.
    Entrada

    La entrada estará compuesta de múltiples casos de prueba. Cada uno comienza con
    - una línea conteniendo dos números enteros positivos, menores que 1.000, que indican, 
    respectivamente, el ancho y el alto del tablero. 
    - A continuación vendrá una línea por cada fila del tablero. Cada celda se representa con 
    un * indicando que en esa celda hay una mina, o con un - indicando que está libre.

    La entrada termina con un tablero de ancho o alto 0.

    Salida

    Para cada caso de prueba se debe indicar, en una única línea, el número de celdas 
    vacías con al menos 6 minas alrededor.

    Entrada de ejemplo

    5 4
    *--**
    ---*-
    ---**
    ***--
    4 5
    **-*
    ****
    *--*
    **-*
    -***
    0 0

    Salida de ejemplo

    0
    3
 */

/*
 * - pedir ancho y alto
 * - Repetir si ancho o alto == 0
 *      
 *      - Pedir linea con datos para las minas en cada fila
 *      - Convertir tablero con las minas en matriz
 * 
 *      - Combrobar cuantas celdas vacias tienen 6 minas alrededor
 */
import java.util.Scanner;

 public class Ejercicio_4_Campo_minas_reto_176 {
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
 
         String input = sc.nextLine();
         while (!input.contains("0")) {
             String[] inputList = input.split(" ");
             int ancho = Integer.parseInt(inputList[0]);
             int alto = Integer.parseInt(inputList[1]);
 
             char[][] matriz = new char[alto][ancho];
 
             for (int i = 0; i < alto; i++) {
                 String line = sc.nextLine();
                 for (int j = 0; j < ancho; j++) {
                     matriz[i][j] = line.charAt(j);
                 }
             }
             int ast_6 = 0;
             for (int i = 0; i < alto; i++) {
                 for (int j = 0; j < ancho; j++) {
                     if (contarAsteriscos(matriz, i, j) >= 6) {
                         ast_6++;
                     }
                 }
             }
 
             System.out.println(ast_6);
 
             input = sc.nextLine();
         }
 
         sc.close();
     }
 
     static int contarAsteriscos(char[][] matriz, int fila, int col) {
         // suponemos que fila y col son índices correctos (en rango)
         int total = 0;
         for (int f = Math.max(0, fila - 1); f < Math.min(matriz.length, fila + 2); f++) {
             for (int c = Math.max(0, col - 1); c < Math.min(matriz[f].length, col + 2); c++) {
                 if (f == fila && c == col) {
                     continue;
                 }
                 if (matriz[f][c] == '*') {
                     total++;
                 }
 
             }
         }
         return total;
     }
 }
 