package ar.edu.utn.frba.dds;

import java.util.List;

public class MotorDeSugerenciasBasico extends MotorDeSugerencias {

  public MotorDeSugerenciasBasico(ServicioMeteorologico servicioMeteorologico) {
    super(servicioMeteorologico);
  }

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
