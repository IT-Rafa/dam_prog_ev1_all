package IV_Arrays_y_Diseño_2_capas.III_2_capas_Logicas.Soluciones_Propias.sieteymediosolution.sieteymedia;

import IV_Arrays_y_Diseño_2_capas.III_2_capas_Logicas.Soluciones_Propias.sieteymediosolution.recursos.*;

public class SieteYMedia {

  int CARTASJUGADOR = 15;
  Baraja baraja;
  Carta[] cartasJugador;
  Carta[] cartasBanca;

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

  public double valorCartasJugador() {
    return valorCartas(cartasJugador);
  }

  public double valorCartasBanca() {
    return valorCartas(cartasBanca);
  }

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

  public String[] jugadorPideCarta() {
    return pedirCarta(cartasJugador);
  }

  public String[] bancaPideCarta() {
    return pedirCarta(cartasBanca);
  }

  private String[] pedirCarta(Carta[] cartas) {
    Carta c = baraja.darCartas(1)[0];
    // insertamos c en las cartas del jugador
    insertarCartaEnArray(cartas, c);
    return CartasToStringArray(cartas);
  }

  void insertarCartaEnArray(Carta[] cartas, Carta c) {
    // inserta al final detectando el primer null
    int i = 0;
    while (cartas[i] != null) {
      i++;
    }
    cartas[i] = c;
  }

  String[] CartasToStringArray(Carta[] cartas) {
    String[] result = new String[CARTASJUGADOR];
    int i = 0;
    while (cartas[i] != null) {
      result[i] = cartas[i].toString();
      i++;
    }
    return result;
  }
}
