package IV_Arrays_y_Diseño_dos_capas.IV_Array_Multidimensionales.Soluciones_Propias.U4_B4A;
/* Ejercicio U4_B4A_E2:
    Inicializa arrayDosD con la sintaxis anterior para que contenga el
    contenido del siguiente gráfico (e imprime para comprobar)

    1 array
        3 Arrays
            0 con lengh 4 y valores = 11 12 13 14
            1 con lengh 2 y valores = 21 22
            2 con lengh 3 y valores = 31 32 33

 */
public class Ejercicio_U4_B4A_E2 {
    public static void main(String[] args) {
        int[][] arrayDosD = { { 11, 12, 13, 14 }, { 21, 22 }, { 31, 32, 33 } };

        // Mostramos array
        for (int i = 0; i < arrayDosD.length; i++) {
            for (int j = 0; j < arrayDosD[i].length; j++) {
                System.out.println("arrayDosD[" + i + "][" + j + "] = " + arrayDosD[i][j]);
            }
            System.out.println();
        }
    }
}
