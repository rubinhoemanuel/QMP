package ar.edu.utn.frba.dds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@AllArgsConstructor
@Getter
public class Usuario {

  private List<Prenda> prendas;
  private Integer edad;

  public List<Sugerencia> generarSugerencias() {
    return ServiceLocator.getInstance().getMotorDeSugerencias().generarSugerenciasCon(this.prendas, edad);
  }

}
