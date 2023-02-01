package IV_Arrays_y_Diseño_dos_capas.IV_Array_Multidimensionales.A_04A_Array_de_varias_dimensiones_fundamentos_U4_B4A.sol_propias.Ejercicio_U4_B4A_E6;

import java.util.Random;

/* Ejercicio U4_B4A_E6: 
    Como caso concreto del cuadro anterior, se pide que simules un conteo con 3 dimensiones:
    hora, día y mes. Cada mes tendrá los días que naturalmente le corresponda (31, 30 o 28), 
    para simplificar, despreciamos años bisiestos de forma que febrero siempre tiene 28 días
    (en el dibujo de abajo debería poner 27 en lugar de 28 para febrero).

    Llenamos aleatoriamente el conte con números de coches entre 0 y 999.
    Podemos hacer esto por ejemplo con el siguiente código:

    import java.util.Random;
    public class Unidad4 {
        static int calcularDiasMes(int month) {
            int numDays =
            switch (month) {
                case 1,3,5,7,8,10,12->31;
                case 4,6,9,11->30;
                case 2->28;

                default->99;//mes erróneo
            };
            return numDays;
        }

        public static void main(String[] args) {
            //creamos array [mes][dia][hora]
            int[][][] conteo = new int[12][][];

            for (int mes = 0; mes < conteo.length; mes++) {
                //cada mes tiene un número de dias diferentes
                //se van creando las dimensiones dia y hora mes a mes
                conteo[mes] = new int[calcularDiasMes(mes + 1)][24];
            }
            //inicializamos el array. suponemos conteo entre 0 y 999
            Random r = new Random();
            for (int mes = 0; mes < conteo.length; mes++) {
                for (int dia = 0; dia < conteo[mes].length; dia++) {
                    for (int hora = 0; hora < conteo[mes][dia].length; hora++) {
                        conteo[mes][dia][hora] = r.nextInt(1000);
                    }
                }
            }
            imprimirConteos(conteo);
        }
    }

    Se pide completar el código escribiendo el método
    imprimirConteos()
*/
public class Ejercicio_U4_B4A_E6 {

    /**
     * @param month
     * @return
     */
    static int calcularDiasMes(int month) {
        final int numDays = switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;

            default -> 99;// mes erróneo
        };
        return numDays;
    }

    public static void main(String[] args) {
        // creamos array [mes][dia][hora]
        int[][][] conteo = new int[12][][];

        for (int mes = 0; mes < conteo.length; mes++) {
            // cada mes tiene un número de dias diferentes
            // se van creando las dimensiones dia y hora mes a mes
            conteo[mes] = new int[calcularDiasMes(mes + 1)][24];
        }
        // inicializamos el array. suponemos conteo entre 0 y 999
        Random r = new Random();
        for (int mes = 0; mes < conteo.length; mes++) {

            for (int dia = 0; dia < conteo[mes].length; dia++) {
                for (int hora = 0; hora < conteo[mes][dia].length; hora++) {
                    conteo[mes][dia][hora] = r.nextInt(1000);
                }
            }
        }
        imprimirConteos(conteo);
    }

    static void imprimirConteos(int[][][] c) {
        // Recorremos array
        for (int mes = 0; mes < c.length; mes++) {
            // Cabecera por cada mes
            System.out.println("MES " + (mes + 1) + "\n------");

            for (int dia = 0; dia < c[mes].length; dia++) {
                // Cabecera por cada día del mes
                System.out.print("\n    día " + (dia + 1) + ":\n    -------\n");
                for (int hora = 0; hora < c[mes][dia].length; hora++) {
                    // Cabeceras misma línea en grupos 8 horas
                    if (hora == 0) {
                        System.out.print("\t 0-8 horas: ");

                    } else if (hora == 8) {
                        System.out.print("\n\t 8-16 horas: ");

                    } else if (hora == 16) {
                        System.out.print("\n\t 16-24 horas: ");
                    }
                    // Mostrar datos
                    System.out.print("\t" + c[mes][dia][hora]);
                }
                System.out.println();
            }
        }
    }
}
