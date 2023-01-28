package U4_B4A;

/* Ejercicio U4_B4A_E5:
    Con una matriz cuadrada, introduciendo el tamaño por argumento EN LLAMADA DESDE CONSOLA, inicializar aleatoriamente
    la matriz con enteros de 0 a 99 y luego modificarla invirtiendo los valores de la diagonal
    principal entre ellos, y los de la diagonal secundaria entre ellos como ilustra el ejemplo

    38 98 88 20
    81 43 46 79
    46 87 83 87
    2  81 92 11

    11 98 88 2
    81 83 87 79
    46 46 43 87
    20 81 92 38

    Relación indices
    Para cada fila i hasta que i < tam/2:
    En diagonal principal matriz[i][i] <=> matriz[tam-1-i][tam-1-i];
    En diagonal secundaria matriz[i][tam-1-i] <=> matriz[tam-1-i][i];
 */
public class Ejercicio_U4_B4A_E5 {
    public static void main(String[] args) {
        // Capturamos argumento en la llamada si existe
        int size;
        if(args.length == 1){
            size = Integer.parseInt(args[0]);
        }else{
            System.out.println("Fallo. Precisa argumento entero.");
            return;
        }
        // Creamos matriz cuadrada
        int[][] matriz = new int[size][size];

        // Añadimos valores a la matriz y la mostramos
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                // números de 0 a 99 aleatorios
                matriz[i][j] = (int) (Math.random() * (99 - 0)) + 0;
                // Mostramos matriz
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < matriz.length / 2; i++) {
            // invirtiendo los valores de la diagonal principal entre ellos,
            int pos = matriz.length - 1 - i;
            int temp = matriz[i][i];
            matriz[i][i] = matriz[pos][pos];
            matriz[pos][pos] = temp;
            // y los de la diagonal secundaria entre ellos
            int temp2 = matriz[i][pos];
            matriz[i][pos] = matriz[pos][i];
            matriz[pos][i] = temp2;
        }
        // Mostramos matriz modificada
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
