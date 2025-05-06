package ar.edu.utn.frba.dds.qmp;

import lombok.Getter;

@Getter
public class Material {

  private Trama trama;

  public Material(Trama trama) {
    if (trama == null) {
      trama = Trama.LISA;
    }
    this.trama = trama;
  }

}
