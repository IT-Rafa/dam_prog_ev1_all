package IV_Arrays_y_Diseño_dos_capas.IV_Array_Multidimensionales.A_04A_Array_de_varias_dimensiones_fundamentos_U4_B4A.sol_propias.Ejercicio_U4_B4A_E4;

/* Ejercicio U4_B4A_E4:
    Con una matriz cuadrada, introduciendo el tamaño por argumento EN LLAMADA DESDE CONSOLA, inicializar 
    aleatoriamente la matriz con números de 0 a 99 y luego modificarla intercambiando 
    la diagonal principal con la secundaria.
    Ejemplo:
        63  41  80  81 ---  [0,0] <> [0,3]
        48  74  6   84 ---  [1,1] <> [1,2]
        54  2   42  7  ---  [2,1] <> [2,2]
        42  69  80  49 ---  [3,0] <> [3,3]

        81  41  80  63
        48  6   74  84
        54  42  2   7
        49  69  80  42
 */
public class Ejercicio_U4_B4A_E4 {
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

        // Intercambiamos matriz principal por secundaria
        for (int i = 0; i < matriz.length; i++) {
            int temp = matriz[i][i];
            matriz[i][i] = matriz[i][matriz.length - 1 - i];
            matriz[i][matriz.length - 1 - i] = temp;
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
