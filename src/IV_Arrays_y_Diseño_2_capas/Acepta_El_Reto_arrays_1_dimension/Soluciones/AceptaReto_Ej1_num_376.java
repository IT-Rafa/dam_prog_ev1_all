package IV_Arrays_y_Diseño_2_capas.Acepta_El_Reto_arrays_1_dimension.Soluciones;

import java.util.Scanner;

/* 
    Siete picos
    Tiempo máximo: 1,000 sMemoria máxima: 4096 KiB
    Foto clásica de '7 Picos', antigua atracción del Parque de Atracciones 
    de Madrid

    En 1969 se inauguró el Parque de Atracciones de Madrid; su atracción 
    estrella era la montaña rusa "Siete picos", que, tras 36 años de 
    servicio y unos 77 millones de usuarios, fue desmontada en 2005 para, 
    como ella mismo "dijo" en su carta de despedida, dejar paso a las 
    nuevas generaciones.

    Curiosamente, pese a su nombre, aquella montaña rusa no tenía siete 
    picos. Si llamamos "pico" a un punto del recorrido que está más alto 
    que el inmediatamente anterior y el inmediatamente siguiente, entonces 
    tenía como mucho 6 y ni siquiera las crónicas se ponen de acuerdo en 
    esto.

    Dado el recorrido de varias montañas rusas, ¿puedes contar el número 
    de picos? Ten en cuenta que las montañas rusas son circulares, y el 
    punto de inicio de la entrada ¡podría ser un pico!

    Entrada

    El programa leerá de la entrada estándar múltiples casos de prueba, 
    cada  uno con la descripción de una montaña rusa.
    Una montaña rusa queda descrita por un primer número 2 ≤ n ≤ 1.000 
    indicando cuántas veces se ha anotado la altura del recorrido.
    A continuación vienen, en otra línea, n números positivos (menores que 
    1.000) con todas esas alturas.

    La entrada termina con una montaña rusa sin alturas que no deberá 
    procesarse.

    Salida

    Para cada caso de prueba el programa escribirá el número de picos de 
    la montaña rusa que representa. Recuerda que las montañas rusas son 
    circuitos cerrados, y tras el final vuelven a comenzar.
    
    Entrada de ejemplo

    4
    4 10 3 2
    4
    10 3 2 4
    5
    4 10 10 3 2
    0

    Salida de ejemplo

    1
    1
    0

 */
/* 
 * Captura número de picos
 *  - Captura altura picos
 *  - Compara picos con previo y posterior
 *      - El primero compara con el último y el segundo
 *      - El resto compara con el previo y el posterior
 *      - El último compara con el previo y el primero
 * 
 *   Muestra el contador tras acabar con cada lista de picos
*/

public class AceptaReto_Ej1_num_376 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Capturamos cant picos primera vez
        int numPicos = sc.nextInt();

        while (numPicos > 0) {
            // variable tamaños picos
            int[] tamPicos = new int[numPicos];

            // Capturamos tamaños picos
            for (int i = 0; i < numPicos; i++) {
                tamPicos[i] = sc.nextInt();
            }

            // contador picos
            int cont = 0;

            // comprobamos 1º pico
            if (tamPicos[0] > tamPicos[1] &&
                    tamPicos[0] > tamPicos[tamPicos.length - 1]) {
                cont++;
            }
            // comprobamos picos del medio
            for (int i = 1; i < numPicos - 1; i++) {
                if (tamPicos[i] > tamPicos[i - 1] &&
                        tamPicos[i] > tamPicos[i + 1]) {
                    cont++;
                }
            }
            // comprobamos último pico
            if (tamPicos[tamPicos.length - 1] > tamPicos[tamPicos.length - 2] &&
                    tamPicos[tamPicos.length - 1] > tamPicos[0]) {
                cont++;
            }
            // mostramos cant picos
            System.out.println(cont);

            // Pedimos siguiente cant picos
            numPicos = sc.nextInt();
        }

        sc.close();
    }
}
