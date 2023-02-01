package IV_Arrays_y_Diseño_dos_capas.IV_Array_Multidimensionales.D_04D_Representar_un_plano_en_matriz.sol_propias.Ejercicio_U4_B4D_E3;

/* Ejercicio U4_B4D_E3:
	bocata de calamares en coderunner

 */
public class Ejercicio_U4_B4D_E3 {

  public static void main(String[] args) {
    int[][] matrix = new int[9][];
    double midPoint = (matrix.length - 1) / 2.0;
    for (int col = 0; col < matrix.length; col++) {
      int[] row = new int[matrix.length];
      double yy = col - midPoint;
      for (int x = 0; x < row.length; x++) {
        double xx = x - midPoint;
        if (Math.sqrt(xx * xx + yy * yy) <= midPoint) row[x] = 1;
        System.out.print(row[x]);
      }
      matrix[col] = row;
      System.out.println();
    }
  }
}
