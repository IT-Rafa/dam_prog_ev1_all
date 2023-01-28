// SieteYMedia.java
package IV_Arrays_y_Diseño_2_capas.III_Usar_dos_capas_Logicas.Soluciones_Propias.sieteymediosolution.sieteymedia;

import IV_Arrays_y_Diseño_2_capas.III_Usar_dos_capas_Logicas.Soluciones_Propias.sieteymediosolution.recursos.Baraja;
import IV_Arrays_y_Diseño_2_capas.III_Usar_dos_capas_Logicas.Soluciones_Propias.sieteymediosolution.recursos.Carta;

/**
 * Clase encargada de gestinar el juego "siete y medio" para
 * una interface.
 */
public class SieteYMedia {

  // PROPERTIES
  /**
   * Cartas máximas que puede tener un jugador
   */
  private static final int CARTASJUGADOR = 15;
  /**
   * Valor que no se debe pasar en siete y medio
   */
  public static final double MAXPUNTUACION = 7.5;

  private Baraja baraja;
  private Carta[] cartasJugador;
  private Carta[] cartasBanca;

  // CONSTRUCTORS
  /**
   * Constructor sin parámetros que prepara partida. Crea la baraja, la reparte, y prepara las cartas de los jugadores,
   * Usuario y Banca
   */
  public SieteYMedia() {
    baraja = new Baraja();
    baraja.barajar();
    // se van pidiendo cartas al jugar pero matemáticamente a partir de 15 siempre
    // nos pasamos
    // hay 12 cartas de medio puntos, si sacara estas 12 luego cartas con valor 1
    // vemos que a partir de 15 cartas siempre se pasas
    cartasJugador = new Carta[CARTASJUGADOR];
    cartasBanca = new Carta[CARTASJUGADOR];
  }

  /**
   * Devuelve el valor de las cartas actuales del Usuario
   * @return double. Valor de las cartas de Usuario
   */
  public double valorCartasJugador() {
    return valorCartas(cartasJugador);
  }

  /**
   * Devuelve el valor de las cartas actuales de la Banca
   * @return double. Valor de las cartas de la Banca
   */
  public double valorCartasBanca() {
    return valorCartas(cartasBanca);
  }

  /**
   * Devuelve el valor de un grupo de cartas a elegir
   *
   * @param cartas El grupo de cartas a contar
   * @return double. Valor de las cartas indicadas
   */
  private double valorCartas(Carta[] cartas) {
    double total = 0.0;
    int val;
    int i = 0;
    while (cartas[i] != null) {
      val = cartas[i].getNumero();
      total += (val > 7) ? 0.5 : val;
      i++;
    }
    return total;
  }

  /**
   * Jugador Usuario pide una carta de la baraja
   *
   * @return Array en String de las cartas de Usuario tras recibir la carta
   */
  public String[] jugadorPideCarta() {
    return pedirCarta(cartasJugador);
  }

  /**
   * Jugador Banca pide una carta de la baraja
   * @return Array en String de las cartas de la Banca tras recibir la carta
   */
  public String[] bancaPideCarta() {
    return pedirCarta(cartasBanca);
  }

  /**
   * Se pide una carta de la baraja y se incluye en las cartas indicadas
   *
   * @param cartas Grupo de cartas donde se añade la carta
   * @return lista de cartas actuales como array String
   */
  private String[] pedirCarta(Carta[] cartas) {
    Carta c = baraja.darCartas(1)[0];
    // insertamos c en las cartas del jugador
    insertarCartaEnArray(cartas, c);
    return CartasToStringArray(cartas);
  }

  /**
   * Añade una carta al grupo de cartas
   *
   * @param cartas Grupo de cartas donde se añade.
   * @param c Carta a añadir
   */
  private void insertarCartaEnArray(Carta[] cartas, Carta c) {
    // inserta al final detectando el primer null
    int i = 0;
    while (cartas[i] != null) {
      i++;
    }
    cartas[i] = c;
  }

  /**
   * Convierte un grupo de cartas en una lista de strings que muestran el palo y
   * el valor de cada carta del grupo
   *
   * @param cartas Array de clase Cartas a convertir
   * @return Array String con cartas convertidas
   */
  protected String[] CartasToStringArray(Carta[] cartas) {
    // Preparamos var con mismo tamaño que cartas jugador.
    // El espacio de cartas usado, será el mismo.
    String[] result = new String[CARTASJUGADOR];

    // Recorremos la lista de cartas mientras tengan datos
    int i = 0;
    while (cartas[i] != null) {
      // añadimos array a lista String
      result[i] = cartas[i].toString();
      i++;
    }
    return result;
  }
}
