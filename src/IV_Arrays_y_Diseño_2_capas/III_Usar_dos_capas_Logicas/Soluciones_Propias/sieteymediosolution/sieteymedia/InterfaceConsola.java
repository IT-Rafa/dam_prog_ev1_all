package IV_Arrays_y_Diseño_2_capas.III_Usar_dos_capas_Logicas.Soluciones_Propias.sieteymediosolution.sieteymedia;

import java.util.Scanner;

/**
 * Clase encargada de mostrar al usuario el juego "siete y medio" en
 * consola del ordenador.
 *
 */
public class InterfaceConsola {

  // PROPERTIES
  private Scanner sc = new Scanner(System.in);
  private SieteYMedia juego;

  // CONSTRUCTORS
  /**
   * Constructor para mostrar instrucciones y preparar juego
   */
  public InterfaceConsola() {
    presentarJuego();
    jugar();
  }

  // STATIC METHODS
  /**
   * Clase para probar el programa.
   * @param args. Opciones para añadir desde llamada del sistema
   */
  public static void main(String[] args) {
    new InterfaceConsola();
  }

  // CLASS METHODS
  /**
   * Muestra las instrucciones del juego
   */
  public void presentarJuego() {
    System.out.println("- El usuario es el jugador y el ordenador la banca.");
    System.out.println(
      "- No hay en la baraja 8s y 9s. " +
      "El 10 es la sota, el 11 el caballo y el 12 el Rey."
    );
    System.out.println(
      "- las figuras (10-sota, 11-caballo y 12-rey) " +
      "valen medio punto y, el resto, su valor."
    );
    System.out.println(
      "- Hay dos turnos de juego: el turno del jugador y el turno de la banca." +
      "\n\tSe comienza por el turno del jugador."
    );
    System.out.println(
      "- El jugador va pidiendo cartas a la banca de una en una."
    );
    System.out.println("- El jugador puede plantarse en cualquier momento.");
    System.out.println(
      "- Si la suma de los valores de las cartas sacadas es superior a 7 y medio," +
      "\n\tel jugador 'se pasa de siete y medio' y pierde."
    );
    System.out.println(
      "- Si el jugador no se pasa, comienza a sacar cartas la banca y ésta está " +
      "\n\tobligada a sacar cartas hasta empatar o superar al jugador."
    );
    System.out.println(
      "- Si la banca consigue empatar o superar la puntuación del jugador " +
      "\n\t'sin pasarse de siete y medio', gana la banca."
    );
    System.out.println(
      "- La banca no se puede plantar y tiene que empatar o superar la puntuación " +
      "\n\tdel jugador sin pasarse."
    );
    System.out.println(
      "- En este proceso puede ocurrir que la banca 'se pase' y entonces pierde " +
      "\n\tla banca y gana el jugador."
    );
    System.out.println("\nEmpecemos!!!\n");
  }

  /**
   * Prepara el juego sieteymedio y controla los turnos
   */
  public void jugar() {
    // Preparamos partida
    this.juego = new SieteYMedia();

    // Si jugador supera el límite superior, la Banca ya no juega
    if (turnoJugador()) {
      turnoBanca();
    }
    // Despedida juego
    System.out.println("Adios");
  }

  /**
   * Controla el turno del jugador usuario
   *
   * @return Indica si el jugador sigue en partida (true) o perdió (false)
   */
  public boolean turnoJugador() {
    // Controla si jugador recibe carta, con 'c', o no
    char opc = 'C';

    System.out.println(
      "Como mínimo recibes una carta, luego puedes decidir " +
      " si seguir o plantarte"
    );

    // El usuario puede pedir cartas, mientras no supere los 7.5
    // variable statica final en SieteYMedia.MAXPUNTUACION
    while (
      this.juego.valorCartasJugador() < SieteYMedia.MAXPUNTUACION && opc == 'C'
    ) {
      // Se le da una carta al jugador
      String[] misCartas = this.juego.jugadorPideCarta();

      // Se muestran las cartas y la putuación
      System.out.println("Éstas son tus cartas jugador:");
      for (int i = 0; misCartas[i] != null; i++) {
        System.out.print(misCartas[i] + "  ");
      }
      System.out.println();
      System.out.println(
        "\n\tValor de cartas: " + this.juego.valorCartasJugador()
      );

      // Si cartas menores al valor superior, se pide confimar si quiere otra carta
      if (this.juego.valorCartasJugador() < SieteYMedia.MAXPUNTUACION) {
        // suponemos que el usuario teclea bien !!!
        System.out.println("\n¿Pides [C]arta o te [P]lantas?");
        // Pedimos opción al usuario.
        opc = sc.next().trim().toUpperCase().charAt(0);
      }
    }

    if (this.juego.valorCartasJugador() > SieteYMedia.MAXPUNTUACION) {
      // Si finalizo y supero el valor máximo, se le avisa que perdió
      System.out.println(
        "Jugador, te has pasado en tu jugada anterior, gana la banca"
      );
      return false;
    } else {
      // Jugador sigue en partida
      return true;
    }
  }

  /**
   * Controla el turno del jugador Banca.
   *
   */
  public void turnoBanca() {
    System.out.println("\n\nTurno de banca ...");
    // juega hasta alcanzar al
    // Comparamos el valor de cartas del jugador y el de la banca
    // Se piden cartas hasta llegar al valor del usuario, sin parsarse del máximo
    while (this.juego.valorCartasBanca() < this.juego.valorCartasJugador()) {
      // Banca pide 1 carta
      String[] cartasBanca = this.juego.bancaPideCarta();

      // Mostramos cartas de la banca y su valor
      System.out.println("Éstas son mis cartas:");
      for (int i = 0; cartasBanca[i] != null; i++) {
        System.out.print(cartasBanca[i] + "  ");
      }
      System.out.println();
      System.out.println(
        "\n\nValor de mis cartas(banca): " + this.juego.valorCartasBanca()
      );
    }

    // Las cartas el usuario se alcanzaron
    // Indicamos si están por debajo o por encima del máximo, y el ganador
    if (this.juego.valorCartasBanca() > SieteYMedia.MAXPUNTUACION) {
      System.out.println("me pasé, ganas tú, jugador");
    } else {
      System.out.println("Gana la banca");
    }
  }
}
