package ar.edu.utn.frba.dds.qmp;

import java.util.List;

public abstract class MotorSugerencias {

  public List<Atuendo> generarSugerencias(List<Prenda> prendas) {
    List<Prenda> prendasSuperiores = this.filtrarPorPrendasSuperiores(prendas);
    List<Prenda> prendasInferiores = this.filtrarPorPrendasInferiores(prendas);
    List<Prenda> calzados = this.filtrarPorCalzados(prendas);
    return this.generarCombinaciones(prendasSuperiores, prendasInferiores, calzados);
  }

  private List<Atuendo> generarCombinaciones(List<Prenda> prendasSuperiores,
                                             List<Prenda> prendasInferiores,
                                             List<Prenda> calzados) {
    return prendasSuperiores.stream()
        .flatMap(prendaSuperior -> prendasInferiores.stream()
            .flatMap(prendaInferior -> calzados.stream()
                .map(calzado -> new Atuendo(prendaSuperior, prendaInferior, calzado))))
        .toList();
  }

  private List<Prenda> filtrarPorCalzados(List<Prenda> prendas) {
    return prendas.stream()
        .filter(prenda -> prenda.getCategoria() == Categoria.CALZADO)
        .toList();
  }

  private List<Prenda> filtrarPorPrendasInferiores(List<Prenda> prendas) {
    return prendas.stream()
        .filter(prenda -> prenda.getCategoria() == Categoria.PARTE_INFERIOR)
        .toList();
  }

  private List<Prenda> filtrarPorPrendasSuperiores(List<Prenda> prendas) {
    return prendas.stream()
        .filter(prenda -> prenda.getCategoria() == Categoria.PARTE_SUPERIOR)
        .toList();
  }

}
