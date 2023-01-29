package IV_Arrays_y_Diseño_dos_capas.IV_Array_Multidimensionales.Soluciones_Propias.U4_B4A;

/* Ejercicio U4_B4A_E3: 
    Si no lo hiciste ya, vuelve a escribir el ejercicio anterior de forma que
    utilice el "for mejorado". Puedes simplificar la impresión a algo del estilo de
    11 12 13 14
    21 22
    31 32 33
 */
public class Ejercicio_U4_B4A_E3 {
    public static void main(String[] args) {
        int[][] arrayDosD = { { 11, 12, 13, 14 }, { 21, 22 }, { 31, 32, 33 } };

        // Mostramos array usando for avanzado
        for (int[] arrayInt : arrayDosD) {
            for (int i : arrayInt) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
