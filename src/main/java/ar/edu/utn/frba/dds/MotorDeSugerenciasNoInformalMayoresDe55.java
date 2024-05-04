package ar.edu.utn.frba.dds;

import java.util.List;

public class MotorDeSugerenciasNoInformalMayoresDe55 extends MotorDeSugerencias {

  @Override
  public List<Prenda> obtenerPrendasValidas(List<Prenda> prendas, Integer edad) {
    return prendasValidas = edad > 55 ? prendas.stream().filter(p -> !p.esInformal()).toList() : prendas;
  }

  @Override
  public List<Sugerencia> generarSugerenciasCon(List<Prenda> prendas, Integer edad) {
    prendasValidas = this.obtenerPrendasValidas(prendas, edad);
    return obtenerCombinaciones(prendasValidas);
  }

}
