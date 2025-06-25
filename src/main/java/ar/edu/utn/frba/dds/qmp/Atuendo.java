package ar.edu.utn.frba.dds.qmp;

import lombok.Getter;

@Getter
public class Atuendo {

  private Prenda prendaSuperior;
  private Prenda prendaInferior;
  private Prenda calzado;

  public Atuendo(Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
  }

}
