package IV_Arrays_y_Diseño_dos_capas.IV_Array_Multidimensionales.F_ejercicios_matriz_multidimensionales.sol_propias.Ejercicio_3_Copistas_daltónicos_reto_266;

/* Ejercicio 3: Copistas daltónicos

        https://www.aceptaelreto.com/problem/statement.php?id=266

        El daltonismo es un transtorno hereditario que ocasiona dificultad para 
        distinguir ciertos colores. Hay distintos tipos de daltonismo que hacen 
        que los colores que esas personas no distinguen varíen. Lo habitual, no 
        obstante, es no distinguir algunos matices de verde y rojo.

        Aunque el defecto genético no suele suponer ningún problema en la vida 
        diaria de los afectados, la realidad es que les imposibilita para 
        realizar algunos trabajos puntuales, como militares de carrera o pilotos.

        Otro de los trabajos difíciles de realizar por los daltónicos es el de 
        duplicador de obras de arte. El problema al hacer la copia de la obra es 
        que esos dos colores que cualquier otro vería distintos terminan siendo 
        el mismo en la copia. Si esa copia cae en las manos de un segundo 
        duplicador daltónico que hace una nueva copia, y luego otro, y luego 
        otro, el resultado final puede no parecerse en nada al original, sobre 
        todo si el tipo de daltonismo de cada uno difiere.

        Como ejemplo, en la figura aparece la transformación que puede sufrir un 
        cuadro de pixel art con uno de los personajes del Pacman tras el paso por 
        varios copistas daltónicos. Los colores originales son azul, rojo, blanco 
        y negro. En la primera reproducción el copista sufría un tipo de 
        daltonismo que le hacía ver igual los colores azul y rojo lo que hace que 
        todos los azules terminen siendo rojos. En la segunda reproducción el 
        copista convirtió todos los rojos en amarillo. El último de la serie veía 
        todos los negros grises.

        Camino de rellenado de los números

        Lo que haremos será, precisamente, simular esa transformación de la obra 
        original tras pasar por las manos de numerosos copistas daltónicos.
        Entrada

        La entrada estará compuesta por distintos casos de prueba. Cada caso de 
        prueba comienza con la descripción de un cuadro que será copiado en serie 
        por distintos daltónicos.

        Los cuadros se representarán mediante letras mayúsculas, cada uno 
        representando un color. Para eso una primera línea contendrá el tamaño del 
        cuadro: dos números entre 1 y 500 indicando el número de filas y el número 
        de columnas respectivamente, a lo que seguirá el cuadro. Acto seguido 
        aparecerá una línea con el número de daltónicos que copiarán el cuadro. 
        
        Por último por cada uno de los copistas aparecerá una línea con dos 
        caracteres; el primero indica el código del color que no es capaz de 
        distinguir y que es sustituido por el código del color marcado por el 
        segundo carácter.

        La salida terminará con un cuadro de tamaño 0×0 que no debe procesarse.
        Salida

        Para cada caso de prueba se escribirá el cuadro tal y como lo dibuja el 
        último copista utilizando la misma representación usada en la entrada.

        Por ejemplo:
        
        Entrada 	

        1 4
        ABCD
        1
        C D
        9 9
        AAAAAAAAA
        AARRRRRAA
        ARRRRRRRA
        ARBBRBBRA
        ARNBRNBRA
        ARRRRRRRA
        ARRRRRRRA
        ARARARARA
        AAAAAAAAA
        3
        A R
        R Y
        N G
        0 0

        Resultado

        ABDD
        YYYYYYYYY
        YYYYYYYYY
        YYYYYYYYY
        YYBBYBBYY
        YYGBYGBYY
        YYYYYYYYY
        YYYYYYYYY
        YYYYYYYYY
        YYYYYYYYY 
*/

/*
 * - Pedimos datos tamaño: filas + columnas
 * 
 *      - Cuando el cuadro sea de tamaño 0 x 0, finaliza el programa
 *      - lineas del cuadro
 *      - cantidad daltónicos que copiarán el cuadro
 *      - Por cada daltónico, se indican 2 caracteres
 *              el primero será sustituido y el segundo, con el que se sustituye
 *      - Se muestra el cuadro tal como queda tras todas las copias
 *      - Volvemos a pedir un nuevo cuadro
 *               datos tamaño: filas + columnas
 
 */

import java.util.Scanner;

/**
 *
 */
public class Ejercicio_3_Copistas_daltónicos_reto_266 {

  private static Scanner sc;

  /**
   * @param args
   */
  public static void main(String[] args) {
    sc = new Scanner(System.in);
    while (true) {
      // Pedimos a usuario tamaño lienzo
      String[] sizeSplit = sc.nextLine().split(" ");
      int width = Integer.parseInt(sizeSplit[0]);
      int height = Integer.parseInt(sizeSplit[1]);
      // Si ambos son 0, finalizamos
      if (width == 0 && height == 0) {
        return;
      }
      // Creamos el lienzo
      char[][] picture = new char[width][height];
      // Pedimos a usuario cada línea del lienzo y lo añadimos
      for (int file = 0; file < picture.length; file++) {
        String line = sc.nextLine();
        for (int col = 0; col < picture[file].length; col++) {
          picture[file][col] = line.charAt(col);
        }
      }
      // Pedimos cantidad de copias(copistas)
      int cantCop = Integer.parseInt(sc.nextLine());
      char[][] failCopy = new char[cantCop][2];
      // Por cada copista, añadimos los fallos que cometen
      for (int i = 0; i < cantCop; i++) {
        String[] failSplit = sc.nextLine().split(" ");
        failCopy[i][0] = failSplit[0].charAt(0);
        failCopy[i][1] = failSplit[1].charAt(0);
      }

      // Hacemos las copias
      // Por copista
      for (int i = 0; i < cantCop; i++) {
        for (int file = 0; file < picture.length; file++) {
          for (int col = 0; col < picture[file].length; col++) {
            if (picture[file][col] == failCopy[i][0]) {
              picture[file][col] = failCopy[i][1];
            }
          }
        }
      }
      for (int file = 0; file < picture.length; file++) {
        for (int col = 0; col < picture[file].length; col++) {
          System.out.print(picture[file][col]);
        }
        System.out.println();
      }
    }
  }
}
