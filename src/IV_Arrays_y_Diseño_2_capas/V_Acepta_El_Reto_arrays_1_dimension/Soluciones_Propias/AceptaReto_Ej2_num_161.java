import java.util.Arrays;
import java.util.Scanner;

/* Cálculo de la Mediana
    Tiempo máximo: 1,000-2,000 s Memoria máxima: 4096 KiB

    Dado un conjunto (o muestra) de valores positivos ordenados, se define la 
    mediana como el valor que ocupa la posición central de los datos dados:

    En el caso de tener un número impar de valores, la mediana está clara: será 
    aquel valor que tenga el mismo número de valores más pequeños y más grandes 
    que él en la muestra. En el caso de tener un número par de valores, habría 
    dos candidatos a ser mediana. En vez de decidirnos por uno, en este caso la 
    mediana viene dada por la media aritmética de esos dos valores que ocupan 
    las posiciones centrales.

    Dada una colección de números positivos, nos piden calcular la mediana. 
    Para evitar tener que trabajar con números decimales en algunos casos, habrá 
    que calcular su doble.

    Entrada

    La entrada consta de una serie de casos de prueba. Cada uno comienza con un 
    número, menor o igual que 25.000, que indica la cantidad de valores que 
    tiene la muestra. A continuación se dan los valores de la muestra, todos 
    números enteros positivos, de los que habrá que calcular la mediana 
    multiplicada por dos.

    La entrada terminará con una serie de 0 valores.

    Salida

    Para cada caso de prueba se mostrará el doble de la mediana de los valores 
    dados.

    Entrada de ejemplo

    11
    1 2 6 17 18 22 35 46 109 153 200
    5
    5 3 1 2 8
    4
    4 5 9 2
    2
    1 1
    0

    Salida de ejemplo

    44
    6
    9
    2
 */
/*
 * Pedimos cantidad valores
 * Seguimos hasta que valor número sea 0
 * Pedimos cada valor de la lista, como array
 */
public class AceptaReto_Ej2_num_161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Pedimos cantidad valores
        int cantValores = sc.nextInt();

        // Seguimos si cantidad valores no es 0
        while (cantValores != 0) {
            // lista valores en int
            int[] listaValores = new int[cantValores];

            // Pedimos lista valores
            for (int i = 0; i < cantValores; i++) {
                listaValores[i] = sc.nextInt();
            }

            // Capturamos mediana
            // Ordenamos valores
            Arrays.sort(listaValores);
            double mediana;
            int posMediana = listaValores.length / 2;
            if (listaValores.length % 2 == 0) {
                mediana = (listaValores[posMediana-1] + listaValores[posMediana]) / 2.0;
            } else {
                mediana = listaValores[posMediana];
            }

            System.out.println((int)(mediana * 2));

            cantValores = sc.nextInt();
        }
        sc.close();
    }
}
