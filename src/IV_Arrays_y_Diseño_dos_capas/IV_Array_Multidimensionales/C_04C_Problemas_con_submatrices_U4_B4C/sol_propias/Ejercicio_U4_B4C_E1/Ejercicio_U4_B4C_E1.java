package IV_Arrays_y_Diseño_dos_capas.IV_Array_Multidimensionales.C_04C_Problemas_con_submatrices_U4_B4C.sol_propias.Ejercicio_U4_B4C_E1;

/* Ejercicio U4_B4C_E1: 
    Generalizamos un poco el código anterior escribiendo un método que 
    nos imprima las coordenadas origen de las submatrices de cualquier 
    rango mxn (no necesariamente m=n).
    Escribe el método para que funcione el código:

    public class Unidad4{
        static void obtenerOrigenSubMatrices(String[][] matriz,int tamFilas, int tamCol){
        //escribir código de este método
        }

        public static void main(String[] args) {
            String [][] matriz= new String[11][11];
            for (int i=0;i<11;i++){
                for(int j=0;j<11;j++){
                    matriz[i][j]=i+"-"+j;
                }
            }
            System.out.println("Matriz original");
            for(String[] fila:matriz){
                for(String s:fila){
                    System.out.print(s+"\t");
                }
                System.out.println("");
            }
            obtenerOrigenSubMatrices(matriz,5,5);
            obtenerOrigenSubMatrices(matriz,3,5);
            obtenerOrigenSubMatrices(matriz,5,3);
        }
    }

    Salida:
    Matriz original
    0-0     0-1     0-2     0-3     0-4     0-5     0-6     0-7     0-8   0-9      0-10
    1-0     1-1     1-2     1-3     1-4     1-5     1-6     1-7     1-8   1-9      1-10
    2-0     2-1     2-2     2-3     2-4     2-5     2-6     2-7     2-8   2-9      2-10
    3-0     3-1     3-2     3-3     3-4     3-5     3-6     3-7     3-8   3-9      3-10
    4-0     4-1     4-2     4-3     4-4     4-5     4-6     4-7     4-8   4-9      4-10
    5-0     5-1     5-2     5-3     5-4     5-5     5-6     5-7     5-8   5-9      5-10
    6-0     6-1     6-2     6-3     6-4     6-5     6-6     6-7     6-8   6-9      6-10
    7-0     7-1     7-2     7-3     7-4     7-5     7-6     7-7     7-8   7-9      7-10
    8-0     8-1     8-2     8-3     8-4     8-5     8-6     8-7     8-8   8-9      8-10
    9-0     9-1     9-2     9-3     9-4     9-5     9-6     9-7     9-8   9-9      9-10
    10-0    10-1    10-2    10-3    10-4    10-5    10-6    10-7    10-8  10-9     10-10
    coordenadas origen Submatrices 5x5
    (0,0) (0,5)
    (5,0) (5,5)
    coordenadas origen Submatrices 3x5
    (0,0) (0,5)
    (3,0) (3,5)
    (6,0) (6,5)
    coordenadas origen Submatrices 5x3
    (0,0) (0,3) (0,6)
    (5,0) (5,3) (5,6)
*/

public class Ejercicio_U4_B4C_E1 {

  /**
   * @param matriz
   * @param tamFilas
   * @param tamCol
   */
  static void obtenerOrigenSubMatrices(
    String[][] matriz,
    int tamFilas,
    int tamCol
  ) {
    System.out.println("Coordenadas submatrices de " + tamFilas + "x" + tamCol);
    for (int i = 0; i < matriz.length / tamFilas; i++) {
      for (int j = 0; j < matriz[0].length / tamCol; j++) {
        System.out.print("(" + (i * tamFilas) + "," + (j * tamCol) + ") ");
      }
      System.out.println();
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    String[][] matriz = new String[11][11];
    for (int i = 0; i < 11; i++) {
      for (int j = 0; j < 11; j++) {
        matriz[i][j] = i + "-" + j;
      }
    }
    System.out.println("Matriz original");
    for (String[] fila : matriz) {
      for (String s : fila) {
        System.out.print(s + "\t");
      }
      System.out.println("");
    }
    obtenerOrigenSubMatrices(matriz, 5, 5);
    obtenerOrigenSubMatrices(matriz, 3, 5);
    obtenerOrigenSubMatrices(matriz, 5, 3);
  }
}
