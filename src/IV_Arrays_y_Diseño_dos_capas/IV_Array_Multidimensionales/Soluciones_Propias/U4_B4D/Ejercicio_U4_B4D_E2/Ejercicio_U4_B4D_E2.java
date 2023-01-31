package IV_Arrays_y_Diseño_dos_capas.IV_Array_Multidimensionales.Soluciones_Propias.U4_B4D.Ejercicio_U4_B4D_E2;

/* Ejercicio U4_B4D_E2:
	Ahora queremos ver el jardín dividido en 4 cuadrantes con una
	casa C ubicada en el punto central, es decir, punto (0,0).

	Seguimos considerando que el plano es una cuadrícula de líneas 
	verticales y horizontales y suponemos que ambas son impares 
	para trabajar con un plano simétrico desde el centro. 

	Igual que en el ejercicio anterior podemos plantar un árbol en 
	cualquier intersección excepto en (0,0) que está la casa.

	class Unidad4{
		public static void main(String[] args) {
			//se indica al constructor hileras verticales y horizontales
			PlanoJardin plano=new PlanoJardin(11,9);
			System.out.println("Antes de plantar");
			plano.imprimirPlano();
			plano.plantarArbol(2,3);
			plano.plantarArbol(2,-3);
			plano.plantarArbol(-2,3);
			plano.plantarArbol(-2,-3);
			System.out.println("Despues de plantar");
			plano.imprimirPlano();
			System.out.println(plano.hayArbol(2,-3));
			System.out.println(plano.hayArbol(3,0));
		}
	}
 */

public class Ejercicio_U4_B4D_E2 {

  public static void main(String[] args) {
    //se indica al constructor hileras verticales y horizontales
    PlanoJardin plano = new PlanoJardin(11, 9);
    System.out.println("Antes de plantar");
    plano.imprimirPlano();

    System.out.println("Despues de plantar");
    plano.plantarArbol(2, 3);
    plano.plantarArbol(2, -3);
    plano.plantarArbol(-2, 3);
    plano.plantarArbol(-2, -3);
    plano.imprimirPlano();
    
    System.out.println(plano.hayArbol(2, -3));
    System.out.println(plano.hayArbol(3, 0));
    
  }
}

/**
 * Representa el plano de un jardin.
 * Las coordenadas se indican como un plano de coordenadas
 * matemático con cuatro cuadrantes, es decir, que la posición 0,0
 * está en el centro del plano del jardín.
 * Las coordenadas deben ser impares para que el centro coincida igual
 * con todas las esquinas
 *
 *     (nº Filas = 4 = alto = y)
 *             3
 *             2
 *             1
 * -4 -3 -2 -1 0 1 2 3 4 (nº Columnas= 5 = ancho = x)
 *            -1
 *            -2
 *            -3
 *
 * El para indicar una zona se indica (x = Columna) + (y = Línea)
 * Para localizar el plano en una matriz de ordenador se usa
 * matriz[y = Línea][x = Columna]
 */
class PlanoJardin {

  // PROPERTIES
  private char[][] jardin;
  private int centroX;
  private int centroY;

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
    this.centroX = alto / 2;
    this.centroY = ancho / 2;
    jardin[this.centroX][this.centroY] = 'C';
  }

  /**
   * Muestra el plano del jardin en consola
   */
  public void imprimirPlano() {
    for (int fila = 0; fila < this.jardin.length; fila++) {
      for (int col = 0; col < this.jardin[fila].length; col++) {
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
    if (posX != 0 && posY != 0) {
      jardin[centroX - posY][centroY + posX] = 'A';
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
  public boolean hayArbol(int posX, int posY) {
    if (jardin[centroX - posY][centroY + posX] == 'A') {
      return true;
    } else {
      return false;
    }
  }
}
