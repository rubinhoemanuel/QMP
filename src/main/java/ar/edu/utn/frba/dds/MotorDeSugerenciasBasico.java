package ar.edu.utn.frba.dds;

import com.google.common.collect.Lists;

import java.util.List;

public class MotorDeSugerenciasBasico extends MotorDeSugerencias {

  @Override
  public List<Prenda> obtenerPrendasValidas(List<Prenda> prendas, Integer edad) {
    return prendasValidas = prendas;
  }

  @Override
  public List<Sugerencia> generarSugerenciasCon(List<Prenda> prendas, Integer edad) {
    prendasValidas = this.obtenerPrendasValidas(prendas, edad);
    return obtenerCombinaciones(prendasValidas);
  }

}
