package IV_Arrays_y_Diseño_dos_capas.V_Acepta_El_Reto_arrays_1_dimension.Soluciones_Propias;

import java.util.Scanner;

/* 
    Ventas
    Tiempo máximo: 1,000 s Memoria máxima: 4096 KiB

    Debido a la crisis, el bar de Javier ha notado un descenso de las consumiciones. 
    Además, según dicen en los telediarios, la ley antitabaco le está perjudicando 
    aún más. Como no termina de creerse todo lo que dicen en la televisión, ha 
    decidido hacer un estudio de mercado semanal de su establecimiento. 

    Para ello, ha estado apuntando la caja diaria que se ha realizado en las últimas 
    semanas. Le gustaría saber qué día de la semana se producen el mayor y el menor 
    número de ventas, y si las ventas del domingo superan a la media semanal. 
    
    De esta manera podrá establecer estrategias de marketing que le permitan 
    recuperar algo de las ganancias perdidas.

    Javier abre su bar todos los días menos los Lunes, que utiliza para descansar.

    Realiza un programa que ayude a Javier en su cometido. Dada una lista de valores 
    correspondiente a una semana, nuestro programa deberá decirle a Javier el día de 
    la semana que más y menos ha vendido, y si las ventas del domingo superan la 
    media.

    Entrada

    El programa recibirá una lista de semanas a evaluar. Cada semana constará de un 
    valor para cada día. El número de semanas es indeterminado. El programa terminará 
    de ejecutarse cuando para el primer día de la semana se indique una venta de -1.

    Salida

    Para cada caso de prueba, el programa escribirá una línea conteniendo dos días 
    de la semana (MARTES, MIERCOLES, JUEVES, VIERNES, SABADO o DOMINGO). 
    El primero indicará el día de más ventas y el segundo el de menos. 
    Después se indicará un SI si el domingo se realizaron más ventas que la media 
    semanal, y NO en caso contrario. Las tres palabras se separarán entre ellas por 
    un espacio.

    Si hay empate en alguno de los valores de ventas mínimo y máximo, se 
    especificará EMPATE.

    Entrada de ejemplo

    185,50
    250,36
    163,45
    535,20
    950,22
    450,38

    1
    2
    3
    4
    5
    6

    9
    9
    9
    9
    9
    9
    -1

    Salida de ejemplo

    SABADO JUEVES SI
    DOMINGO MARTES SI
    EMPATE

 */

/*
 * - Pedimos a usuario los valores de una semana (martes a domingo)
 * - Calculamos dia de mas ventas, el de menos y si el domingo está por encima de la media
       dias en fomato nombre - por encima media (SI NO EMPATE)
   - Volveos a pedir los valores de una semana

 */

public class AceptaReto_Ej4_num_105 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            double[] valorSemana = new double[7];

            valorSemana[1] = sc.nextDouble();
            if (valorSemana[1] == -1.0) {
                sc.close();
                return;
            }
            int posMayor = 1;
            int posMenor = 1;
            double suma = valorSemana[1];

            for (int i = 2; i < valorSemana.length; i++) {
                valorSemana[i] = sc.nextDouble(); // en mi terminal con coma
                if (valorSemana[i] == -1.0) {
                    sc.close();
                    return;
                } else {
                    suma += valorSemana[i];
                    if (valorSemana[i] > valorSemana[posMayor]) {
                        posMayor = i;
                    }
                    if (valorSemana[i] < valorSemana[posMenor]) {
                        posMenor = i;
                    }

                }
            }
            double media = suma / 6;
            String valorDomingo;
            if (valorSemana[valorSemana.length - 1] == media) {
                System.out.println("EMPATE");
                continue;
            } else if (valorSemana[valorSemana.length - 1] < media) {
                valorDomingo = "NO";
            } else {
                valorDomingo = "SI";
            }
            System.out.println(dia(posMayor) + " " + dia(posMenor) + " " + valorDomingo);

        }
    }

    private static String dia(int pos) {
        switch (pos) {
            case 0:
                return "LUNES";
            case 1:
                return "MARTES";
            case 2:
                return "MIERCOLES";
            case 3:
                return "JUEVES";
            case 4:
                return "VIERNES";
            case 5:
                return "SABADO";
            case 6:
                return "DOMINGO";
            default:
                return "ERROR";

        }
    }
}
