package IV_Arrays_y_Diseño_dos_capas.IV_Array_Multidimensionales.F_ejercicios_matriz_multidimensionales.sol_propias.Ejercicio_8_Escapando_de_las_fuerzas_imperiales_432;

/* Ejercicio_8_Fuerzas_imperiales_reto_432
        acepta el reto: Escapando de las fuerzas imperiales (432)

        Nuestros héroes, a bordo del Halcón Milenario y confiando en la pericia de Han Solo, 
        están intentado escapar de las fuerzas rebeldes. Para despistar a las fuerzas imperiales, 
        Han Solo quiere introducirse en un campo de asteroides.

        Pero antes de tan arriesgada maniobra quiere saber si, una vez dentro, podrán salir de él 
        o es mejor buscar una alternativa más prudente.

        El campo de asteroides es una cuadrícula en el que el Halcón Milenario puede moverse en 
        horizontal y en vertical, pero no en diagonal. Las casillas pueden ser transitables, o 
        estar ocupadas por asteroides inmóviles.
                
        Entrada

        Cada caso de prueba comienza con una pareja de números 1 ≤ F,C ≤ 20 indicando, 
        respectivamente, el número de filas y columnas de la cuadrícula que representa el campo de 
        asteroides.

        A continuación irán F líneas, cada una con C caracteres. Un asterisco ('*') indica una celda 
        con asteroide, y un punto ('.') indica una celda transitable. El Halcón Milenario entra al 
        campo de asteroides en la celda identificada con la letra S, y necesita salir de él en la 
        celda F. 
        En el mapa, existirá una y solo una de cada una de esas letras y sus celdas deben 
        considerarse transitables.

        Ten en cuenta que, gracias al hiperespacio, las celdas S y F pueden estar en cualquier 
        posición, no únicamente en los extremos.

        Salida

        Por cada caso de prueba el programa escribirá "SI" si es viable que el Halcón Milenario se 
        adentre en el campo de asteroides porque hay al menos un camino desde el punto S al punto F 
        siguiendo las reglas de movimiento de la nave. En otro caso, el programa escribirá "NO".

        Por ejemplo:
        
        Entrada 	

        2 2
        SF
        ..

        2 3
        S*F
        *..

        3 3
        .S.
        **.
        F..

        Resultado    

        SI
        NO
        SI
 */
/*
 * f alto filas
 * c ancho columnas
 * S casilla para entrar
 * f casilla salir
 * * casilla asteroide
 * . casilla libre
 *
 * - Pedir f y c (ancho filas y alto columnas cuadrante), entre 1 y 20
 * - Pedir en una línea los caracteres que hay en cada línea.
 *
 * - Comprobar que, entrando desde casilla s, hasta casilla f, se puede
 *      recorrer el camino solo moviendose en horizontal y vertical (no diagonal)
 * - Mostrar "SI" o "NO" según sea o no posible
 *
 */

import java.util.Scanner;

public class Ejercicio_8_Fuerzas_imperiales_reto_432 {

  private static Scanner sc = new Scanner(System.in);
  static final char espacio = '.';
  static final char meteorito = '*';
  static final char entrada = 'S';
  static final char salida = 'F';
  static final char visitado = 'V';

  public static void main(String[] args) {
    while (true) {
      // Pedimos dimension del campo asteroides
      String[] dimension;
      if (sc.hasNextLine()) {
        String input = sc.nextLine();
        if (input.isEmpty()) {
          return;
        } else {
          dimension = input.split(" ");
        }
      } else {
        return;
      }

      // Pasamos a int
      int f = Integer.parseInt(dimension[0]);
      int c = Integer.parseInt(dimension[1]);

      // Creamos campo
      char[][] campo = new char[f][c];

      // Pedimos e datos campo y marcamos inicio
      int initX = -1;
      int initY = -1;
      for (int i = 0; i < f; i++) {
        String lineSt = sc.nextLine().toUpperCase();
        for (int j = 0; j < c; j++) {
          campo[i][j] = lineSt.charAt(j);
          if (lineSt.charAt(j) == 'S') {
            initX = i;
            initY = j;
          }
        }
      }
      // ENTRADA PARA PRUEBAS
      /*
        int f = 3;
        int c = 3;
        char[][] campo = {
        { '.', 'S', '.' },
        { '*', '*', '.' },
        { 'F', '.', '.' },
        };
        int initX = 0;
        int initY = 1;

      /* 
        // Mostramos campo
        for (int i = 0; i < f; i++) {
        for (int j = 0; j < c; j++) {
        System.out.print(campo[i][j]);
        }
        System.out.println();
        }
        System.out.println();
      */

      // Localizamos salida
      if (hayCamino(initX, initY, campo)) {
        System.out.println("SI");
      } else {
        System.out.println("NO");
      }
    }
  }

  /**
   * Busca camino para llegar al final
   */
  static boolean hayCamino(int i, int j, char[][] laberinto) {
    // System.out.print("Buscando [" + i + "," + j + "]");
    if (i < 0 || i > laberinto.length - 1) {
      // System.out.println("Fuera rango i False");
      return false;
    }
    if (j < 0 || j > laberinto[i].length - 1) {
      // System.out.println("Fuera rango j; False");
      return false;
    }
    // System.out.print(" Valor " + laberinto[i][j] + " ");
    if (laberinto[i][j] == meteorito) {
      // System.out.println("Meteorito; False");
      return false;
    }
    if (laberinto[i][j] == visitado) {
      // System.out.println("visitado; False");
      return false;
    }

    if (laberinto[i][j] == salida) {
      // System.out.println("Salida; True");
      return true;
    }

    laberinto[i][j] = visitado;
    // System.out.println("\nBUSCANDO SALIDA [" + i + ", " + j + "]");
    // Arriba
    // System.out.println("ARRIBA [" + i + ", " + j + "]");
    if (hayCamino(i - 1, j, laberinto)) return true;
    // Abajo
    // System.out.println("ABAJO [" + i + ", " + j + "]");
    if (hayCamino(i + 1, j, laberinto)) return true;
    // Izquierda
    // System.out.println("IZQUIERDA [" + i + ", " + j + "]");
    if (hayCamino(i, j - 1, laberinto)) return true;
    // Derecha
    // System.out.println("DERECHA [" + i + ", " + j + "]");
    if (hayCamino(i, j + 1, laberinto)) return true;
    laberinto[i][j] = meteorito;
    return false;
  }
}
