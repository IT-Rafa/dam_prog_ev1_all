package IV_Arrays_y_Diseño_dos_capas.V_Acepta_El_Reto_arrays_1_dimension.Soluciones_Propias;

import java.util.Scanner;

/* Va de modas
    Dado un conjunto, o distribución, de valores se de�ine la moda como el valor 
    (o valores) que más se repite en dicho conjunto.
    En este problema te pedimos que calcules la moda de un conjunto de números.

    Entrada
    
    La entrada consta de una serie de casos de prueba.
    Cada caso comienza con un número que representa el número de valores que tiene 
    el conjunto, que nunca será mayor de 25.000. 
    
    En la siguiente línea se proporcionan, separados por espacio, los valores de 
    todos los elementos del conjunto. Todos ellos serán números enteros.

    La entrada terminará con una serie de 0 valores.

    Salida
    Para cada caso de prueba se mostrará la moda de la distribución, es decir el 
    número que más se repite.
    Se garantiza que ningún caso de prueba contendrá más de una moda, es decir 
    únicamente habrá un valor que aparezca el mayor número de veces.
    
    Por ejemplo:
    Entrada
     
    11
    1 2 2 3 3 3 4 4 4 4 5
    17
    1 8 9 6 3 2 1 5 4 7 9 6 3 2 1 4 7
    0 

    Resultado
    4
    1
*/

/*
 * Pedimos cant números (cantNum)
 * Si cantNum == 0; finalizamos
 *      capturamos array de int con valores
 * 
 */

public class AceptaReto_Ej3_num_152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Capturamos primera cantidad valores
        int cantValores = sc.nextInt();

        // Si no es 0, continua
        while (cantValores != 0) {
            // lista valores
            int[] lista = new int[cantValores];
            // contador de veces que sale número
            int[] contadores  = new int[cantValores];

            // Capturamos valores del usuario
            for (int i = 0; i < cantValores; i++) {
                lista[i] = sc.nextInt();
            }

            // Sumamos cuanto sale cada número
            // variable que almacena la primera aparición del número más repetido
            int pos = 0;
            // Recorremos lista números
            for (int i = 0; i < cantValores; i++) {
                // Recorremos lista para contar en la primera posición del número visto
                for (int j = 0; j < cantValores; j++) {
                    // Si número coincide aumentamos contador
                    if(lista[i] == lista[j]){
                        contadores[j]++;
                        // Si es mayor que el mayor contador, lo guardamos
                        if(contadores[pos] < contadores[j]){
                            pos = j;
                        }
                        break; // evita guardar en todas posiciones
                    }
                }
            }
            // Mostramos el número mas repetido
            System.out.println(lista[pos]);

            // Pedimos siguiente valor
            cantValores = sc.nextInt();
        }
        sc.close();
    }
}
