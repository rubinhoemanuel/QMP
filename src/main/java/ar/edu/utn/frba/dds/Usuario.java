package ar.edu.utn.frba.dds;

import java.util.List;

public class Usuario {

  private List<Prenda> prendas;
  private Integer edad;

  public Usuario(List<Prenda> prendas, Integer edad) {
    this.prendas = prendas;
    this.edad = edad;
  }

  List<Sugerencia> generarSugerencias() {
    return ServiceLocator.getInstance().getMotorDeSugerencias().generarSugerenciasCon(this.prendas, edad);
  }

}
