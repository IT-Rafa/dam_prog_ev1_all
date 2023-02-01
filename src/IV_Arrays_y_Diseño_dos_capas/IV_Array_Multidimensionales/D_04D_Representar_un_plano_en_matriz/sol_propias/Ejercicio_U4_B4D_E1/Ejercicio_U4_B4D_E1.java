package IV_Arrays_y_Diseño_dos_capas.IV_Array_Multidimensionales.D_04D_Representar_un_plano_en_matriz.sol_propias.Ejercicio_U4_B4D_E1;

/* Ejercicio U4_B4D_E1:
	Escribir la clase PlanoJardin que representa el plano de un
	jardín para representar donde se van a plantar árboles. 
	El jardín se considera dividido en hileras verticales y horizontales 
	y los árboles se pueden plantar en el cruce de ambas.

    Almacenamos la plantación de árboles en una matriz pero ojo porque el 
	usuario de la clase desea utilizar el sistema clásico de las coordenadas 
	matemáticas (x,y) para indicar la ubicación de un árbol. La clase es 
	capaz de imprimir un pequeño plano tal cual lo dibuja el usuario en su 
	plano de coordenadas x,y. 
        Debe funcionar el siguiente main y producir la salida indicada
class Unidad4{
        public static void main(String[] args) {
                //se indica al constructor columnasxfilas
                PlanoJardin plano=new PlanoJardin(5,4);
                System.out.println("antes de plantar");
                plano.imprimirPlano();
                plano.plantarArbol(0, 3);
                plano.plantarArbol(4,3);
                plano.plantarArbol(2, 0);
                System.out.println("despues de plantar");
                plano.imprimirPlano();
                System.out.println(plano.hayArbol(0,3));
                System.out.println(plano.hayArbol(3,0));
        }
}
*/

public class Ejercicio_U4_B4D_E1 {

  public static void main(String[] args) {
    //se indica al constructor columnasxfilas
    PlanoJardin plano = new PlanoJardin(5, 4);
    System.out.println("antes de plantar");
    plano.imprimirPlano();
    plano.plantarArbol(0, 3);
    plano.plantarArbol(4, 3);
    plano.plantarArbol(2, 0);
    System.out.println("despues de plantar");
    plano.imprimirPlano();
    System.out.println(plano.hayArbol(0, 3));
    System.out.println(plano.hayArbol(3, 0));
  }
}

/**
 * Representa el plano de un jardin.
 * Las coordenadas se indican como un plano de coordenadas, es decir,
 * Las coordenadas se cuentan desde la parte inferior izquierda.
 * (nº Filas = 4 = alto = y)
 * 3
 * 2
 * 1
 * 0 1 2 3 4 (nº Columnas= 5 = ancho = x)
 * 
 * El para indicar una zona se indica (x = Columna) + (y = Línea)
 * Para localizar el plano en una matriz de ordenador se usa 
 * matriz[y = Línea][x = Columna]
 */
class PlanoJardin {

  // PROPERTIES
  private char[][] jardin;

  // CONSTRUCTORS
  /**
   * Constructor PlanoJardin con argumentos.
   * Se le indica el ancho de la tabla y su alto y se
   * rellena con char '-'.
   */
  public PlanoJardin(int ancho, int alto) {
    this.jardin = new char[alto][ancho];
    for (int fila = 0; fila < this.jardin.length; fila++) {
      for (int col = 0; col < this.jardin[fila].length; col++) {
        jardin[fila][col] = '-';
      }
    }
  }

  /**
   * Muestra el plano del jardin en consola
   */
  public void imprimirPlano() {
    for (int fila = 0; fila < this.jardin.length; fila++) {
      for (int col = 0; col < this.jardin[fila].length; col++) {
        //System.out.print(this.jardin.length - fila -1);

        System.out.print(jardin[fila][col] + " ");
      }
      System.out.println();
    }
  }

  /**
   * Inserta un arbol en una plaza del jardín.
   * La posición indicada es la de los planos (columna, fila). y los valores
   * a controlar son como de un plano de coordenadas matemático, con 1 cuadrante.
   * Es decir que la casilla 0,0 está a la izquierda y abajo.
   *
   * @param posX posición de línea del nuevo árbol
   * @param posY posición de columna del nuevo árbol
   */
  public void plantarArbol(int posX, int posY) {
    jardin[this.jardin.length - posY - 1][posX] = 'A';
  }

  /**
   * Inserta un arbol en una plaza del jardín.
   * La posición indicada es la de los planos (columna, fila). y los valores
   * a controlar son como de un plano de coordenadas matemático, con 1 cuadrante.
   * Es decir que la casilla 0,0 está a la izquierda y abajo.
   *
   * @param posX posición de línea del nuevo árbol
   * @param posY posición de columna del nuevo árbol
   */
  public boolean hayArbol(int posX, int posY) {
    if (jardin[this.jardin.length - posY - 1][posX] == 'A') {
      return true;
    } else {
      return false;
    }
  }
}
