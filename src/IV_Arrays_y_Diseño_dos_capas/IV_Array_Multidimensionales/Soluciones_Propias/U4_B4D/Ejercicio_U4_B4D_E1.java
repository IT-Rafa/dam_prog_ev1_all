package IV_Arrays_y_Diseño_dos_capas.IV_Array_Multidimensionales.Soluciones_Propias.U4_B4D;

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
  }
}

class PlanoJardin {

  // PROPERTIES
  private char[][] jardin;
  private int ancho;
  private int alto;

  // CONSTRUCTORS
  public PlanoJardin(int alto, int ancho) {
    this.alto = alto;
    this.ancho = ancho;
    this.jardin = new char[ancho][alto];
    for (int fila = 0; fila < this.jardin.length; fila++) {
      for (int col = 0; col < this.jardin[fila].length; col++) {
        jardin[fila][col] = '-';
      }
    }
  }

  public void imprimirPlano() {
    for (int fila = 0; fila < this.jardin.length; fila++) {
      for (int col = 0; col < this.jardin[fila].length; col++) {
        System.out.print(jardin[fila][col] + " ");
      }
      System.out.println();
    }
  }

  public void plantarArbol(int posY, int posX) {
    jardin[posX][posY] = 'A';
  }
}
