package IV_Arrays_y_Diseño_2_capas.IV_Array_Multidimensionales.Soluciones_Propias.U4_B4A;
/* Ejercicio U4_B4A_E9:
    Acepta el reto.Matrices Triangulares id 160
    
    En enlace se añade en PDF en el texto
    https://www.aceptaelreto.com/problem/statement.php?id=160

    Texto en el reto

    Matrices triangulares
    Tiempo máximo: 1,000-6,000 s Memoria máxima: 4096 KiB

    Se dice que una matriz cuadrada, es decir que tiene el mismo número de filas que de columnas, 
    es triangular cuando todos los valores que están por encima o por debajo de la diagonal 
    principal son cero. 
    También son triangulares aquellas matrices que cumplen estas dos condiciones a la vez.
               _     _
              | 1 2 3 |
      T_3 =   | 0 6 4 |
              |_0 0 5_|
              

    Realiza un programa que diga si una matriz cuadrada dada es o no triangular.
    Entrada

    La entrada consta de una serie de casos de prueba. 
    Cada caso comienza con un número que representa el número de filas, mayor que cero y menor o 
    igual que 50, de la matriz cuadrada. A continuación se dan los elementos que forman la matriz.

    La entrada terminará con una matriz de 0 filas.

    Salida

    Para cada caso de prueba se indicará SI si la matriz es triangular y NO en caso contrario.

    Entrada de ejemplo

    3
    1 2 3   00 01 02
    0 6 4   10 11 12       1 adelante y 0 hasta mitad 1      0 hasta penultimo  mitad hasta final
    0 0 5   20 21 22       10 20 21     -   01 02 12

    3
    1 0 0
    2 3 0
    4 5 6

    3
    1 1 1
    1 1 1
    0 0 1

    0

    Salida de ejemplo

    SI
    SI
    NO
 */

import java.util.Scanner;

public class Ejercicio_U4_B4A_E9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos un entero del tamaño (mismo alto y longitud de filas). Max 50
        // System.out.print("Tamaño: ");
        int size = Integer.parseInt(sc.nextLine());
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
            /* // Mostramos valores guardados
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(matriz[i][j] + " ");
                }
                System.out.println();
            }
            */
            // Asumimos que sí y comprobamos los valores. 
            String result = "SÍ";

            // Comprobamos si la zona inferior izquierda es triangular
            // Ignoramos la línea 0, que no es relevante y seguimos
            for (int i = 1; i < size; i++) {
                // Vamos hasta el mismo anterior a la línea - mitad izquierda, menos diagonal
                for (int j = 0; j < i; j++) {
                    // System.out.println("comprobamos1 " + i + "," + j + ": " + matriz[i][j]);
                    
                    // Si no coincide, el resultado es no y finalizamos bucle
                    if (matriz[i][j] != 0) {
                        // System.out.println("NO ES");
                        result = "NO";
                        break;
                    }
                }
                // En caso de encontrar un no, finalizamos bucle superior
                if (result.equalsIgnoreCase("NO")) {
                    break;
                }

            }
            // Si el resultdo fué positivo, ya no hace falta seguir
            if (result == "NO") {
                // Si no fue positivo se comprueba la parte superior derecha para ver si es triangular

                result = "SI";
                // Ignoramos la última línea, que no es relevante y seguimos
                for (int i = 0; i < size - 1; i++) {
                    // Vamos hasta el siguiente de i hasta final- mitad derecha, menos diagonal
                    for (int j = i + 1; j < size; j++) {
                        // System.out.println("comprobamos2 " + i + "," + j + ": " + matriz[i][j]);
                        
                        // Si no coincide, el resultado es no y finalizamos bucle
                        if (matriz[i][j] != 0) {
                            // System.out.println("NO ES");
                            result = "NO";
                            break;
                        }
                    }
                    // En caso de encontrar un no, finalizamos bucle superior
                    if (result.equalsIgnoreCase("NO")) {
                        break;
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
