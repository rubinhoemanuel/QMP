package ar.edu.utn.frba.dds;

import com.google.common.collect.Lists;
import java.util.List;

public abstract class MotorDeSugerencias {

  protected List<Prenda> prendasValidas;

  public abstract List<Prenda> obtenerPrendasValidas(List<Prenda> prendas, Integer edad);

  public abstract List<Sugerencia> generarSugerenciasCon(List<Prenda> prendas, Integer edad);

  public List<Sugerencia> obtenerCombinaciones(List<Prenda> prendasValidas) {

    List<Prenda> prendasSuperiores = obtenerPrendasSuperiores(prendasValidas);
    List<Prenda> prendasInferiores = obtenerPrendasInferiores(prendasValidas);
    List<Prenda> prendasCalzados = obtenerPrendasCalzado(prendasValidas);

    List<List<Prenda>> combinaciones = Lists.cartesianProduct(prendasSuperiores,prendasInferiores,prendasCalzados);

    return combinaciones
        .stream()
        .map(comb -> new Sugerencia(comb.get(0), comb.get(1), comb.get(2)))
        .toList();
  }

  private List<Prenda> obtenerPrendasCalzado(List<Prenda> prendasValidas) {
    return prendasValidas.stream().filter(Prenda::esPrendaCalzado).toList();
  }

  private List<Prenda> obtenerPrendasInferiores(List<Prenda> prendasValidas) {
    return prendasValidas.stream().filter(Prenda::esPrendaInferior).toList();
  }

  private List<Prenda> obtenerPrendasSuperiores(List<Prenda> prendasValidas) {
    return prendasValidas.stream().filter(Prenda::esPrendaSuperior).toList();
  }

}
