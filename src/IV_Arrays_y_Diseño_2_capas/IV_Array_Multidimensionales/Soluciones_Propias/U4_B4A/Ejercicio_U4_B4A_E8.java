package U4_B4A;
/* Ejercicio U4_B4A_E8:
    Matriz identidad acepta el reto

    En enlace se añade en PDF en el texto
    https://www.aceptaelreto.com/problem/statement.php?id=151&cat=14

    Texto en el reto

    ¿Es matriz identidad?
    Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB

    Se dice que una matriz es identidad cuando todos sus elementos son cero a excepción 
    de la diagonal principal, que se encuentra rellena de unos:
               _     _
              | 1 0 0 |
      I_3 =   | 0 1 0 |
              |_0 0 1_|
              
    Para que una matriz sea identidad debe de ser cuadrada, es decir, tener el mismo número 
    de filas que de columnas.

    Entrada

    La entrada consta de una serie de casos de prueba. Cada uno comienza con un número que 
    representa el número de filas, como máximo 50, de una matriz cuadrada. 
    Tras él, aparecen los elementos que forman la matriz, que serán valores entre -1.000 y 
    1.000 (incluídos).

    La entrada terminará con una matriz de 0 filas.
    
    Salida

    Para cada caso de prueba se indicará SI si la matriz es identidad y NO en caso contrario.
    Entrada de ejemplo

    3
    1 0 0
    0 1 0
    0 0 1
    
    2
    0 1
    1 0
    
    5
    1 0 0 0 0
    0 5 0 0 0
    0 0 1 0 0
    0 0 0 1 0
    0 0 0 0 1

    0

    Salida de ejemplo

    SI
    NO
    NO / Creo que sí
*/

/*
 * - Pedimos un entero del tamaño (mismo alto y longitud de filas). Max 50
 * - Si tamaño == 0 finalizamos, si no repetimos esta parte
 *      - Pedimos los valores por cada fila entre -1000 y 1000
 *      - Comprobamos si la matriz es identidad
 *           es identidad cuando todos sus elementos son cero a excepción 
 *           de la diagonal principal, que se encuentra rellena de unos
 *       - Volvemos a pedir tamaño
 * - Fin
 */

import java.util.Scanner;

public class Ejercicio_U4_B4A_E8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos un entero del tamaño (mismo alto y longitud de filas). Max 50
        // System.out.print("Tamaño: ");
        int size = Integer.parseInt(sc.nextLine());
        // Si tamaño == 0 finalizamos, si no repetimos esta parte
        while (size != 0) {
            // Pedimos los valores por cada fila entre -1000 y 1000

            // array para los valores de la matriz
            int[][] matriz = new int[size][size];

            // Guardamos datos de cada línea
            for (int line = 0; line < size; line++) {
                // Capturamos valor en string
                // System.out.print("Linea " + line + ": ");
                String input = sc.nextLine();

                // Convertimos string a array string con cada valor
                String[] list = input.split(" ");

                // Guardamos valores de cada linea
                for (int column = 0; column < size; column++) {
                    matriz[line][column] = Integer.parseInt(list[column]);
                }
            }

            // Comprobamos si la matriz es identidad
            String result = "SÍ";
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (i == j && matriz[i][j] != 1) {
                        result = "NO";
                        break;
                    } else if (i != j && matriz[i][j] != 0) {
                        result = "NO";
                    }
                }
            }

            // Mostramos resultado
            System.out.println(result);

            // Volvemos a pedir tamaño
            // System.out.print("Tamaño: ");
            size = Integer.parseInt(sc.nextLine());
        }
        sc.close();
    }
}
