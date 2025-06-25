package ar.edu.utn.frba.dds.qmp;

import java.util.List;
import lombok.Setter;

public class Guardarropa {

  private List<Prenda> prendas;

  @Setter
  private MotorSugerencias motorSugerencias;

  public Guardarropa(List<Prenda> prendas, MotorSugerencias motorSugerencias) {
    this.prendas = prendas;
    this.motorSugerencias = motorSugerencias;
  }

  public List<Atuendo> generarSugerencias() {
    return motorSugerencias.generarSugerencias(this.prendas);
  }

}
