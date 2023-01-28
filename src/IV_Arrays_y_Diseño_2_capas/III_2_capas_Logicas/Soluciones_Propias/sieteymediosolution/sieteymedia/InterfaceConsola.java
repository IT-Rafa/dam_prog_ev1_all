package IV_Arrays_y_Diseño_2_capas.III_2_capas_Logicas.Soluciones_Propias.sieteymediosolution.sieteymedia;

import java.util.Scanner;

public class InterfaceConsola {

  private Scanner sc = new Scanner(System.in);
  private SieteYMedia juego;

  public static void main(String[] args) {
    new InterfaceConsola();
  }

  public InterfaceConsola() {
    presentarJuego();
    jugar();
  }

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
      " Se comienza por el turno del jugador."
    );
    System.out.println(
      "- El jugador va pidiendo cartas a la banca de una en una."
    );
    System.out.println("- El jugador puede plantarse en cualquier momento.");
    System.out.print(
      "- Si la suma de los valores de las cartas sacadas es superior "
    );
    System.out.println(
      "a 7 y medio, el jugador 'se pasa de siete y medio' y pierde."
    );
    System.out.println(
      "- Si el jugador no se pasa, comienza a sacar cartas la banca" +
      " y ésta está obligada a sacar cartas hasta empatar o superar al jugador."
    );
    System.out.println(
      "- Si la banca consigue empatar o superar la puntuación del jugador " +
      "'sin pasarse de siete y medio', gana la banca."
    );
    System.out.println(
      "- La banca no se puede plantar y tiene que empatar o superar la " +
      "puntuación del jugador sin pasarse."
    );
    System.out.println(
      "- En este proceso puede ocurrir que la banca 'se pase' y entonces" +
      " pierde la banca y gana el jugador."
    );
    System.out.println("\nEmpecemos!!!\n");
  }

  public void jugar() {
    this.juego = new SieteYMedia();
    if (turnoJugador()) {
      turnoBanca();
    }

    System.out.println("Adios");
  }

  public boolean turnoJugador() {
    char opc = 'C';
    System.out.println(
      "Como mínimo recibes una carta, luego puedes decidir " +
      " si seguir o plantarte"
    );

    while (this.juego.valorCartasJugador() < 7.5 && opc == 'C') {
      String[] misCartas = this.juego.jugadorPideCarta();
      System.out.println("Éstas son tus cartas jugador:");
      for (int i = 0; misCartas[i] != null; i++) {
        System.out.print(misCartas[i] + "  ");
      }
      System.out.println();
      System.out.println(
        "\n\tValor de cartas: " + this.juego.valorCartasJugador()
      );
      if (this.juego.valorCartasJugador() < 7.5) {
        // suponemos que el usuario teclea bien !!!
        System.out.println("\n¿Pides [C]arta o te [P]lantas?");
        opc = sc.next().trim().toUpperCase().charAt(0);
      }

    }
    if (this.juego.valorCartasJugador() > 7.5) {
        System.out.println(
          "Jugador, te has pasado en tu jugada anterior, gana la banca"
        );
        return false;
      } else {
        return true;
      }
  }

  public void turnoBanca() {
    System.out.println("\n\nTurno de banca ...");
    // juega hasta empatar o superar
    while (this.juego.valorCartasBanca() < this.juego.valorCartasJugador()) {
      String[] cartasBanca = this.juego.bancaPideCarta();
      System.out.println("Éstas son mis cartas:");
      for (int i = 0; cartasBanca[i] != null; i++) {
        System.out.print(cartasBanca[i] + "  ");
      }
      System.out.println();
      System.out.println(
        "\n\nValor de mis cartas(banca): " + this.juego.valorCartasBanca()
      );
      if (this.juego.valorCartasBanca() > 7.5) {
        System.out.println("me pasé, ganas tú,jugador");
      } else {
        System.out.println("Gana la banca");
      }
    }
  }
}
