//Carta.java
package IV_Arrays_y_Diseño_2_capas.III_Usar_dos_capas_Logicas.Soluciones_Propias.sieteymediosolution.recursos;

public class Carta {

  private Palo palo;
  private int numero;

  public Carta(Palo palo, int numero) {
    this.palo = palo;
    this.numero = numero;
  }

  public String getPalo() {
    return palo.toString();
  }

  public int getNumero() {
    return numero;
  }

  @Override
  public String toString() {
    return "(" + palo + ", " + numero + ')';
  }
}
