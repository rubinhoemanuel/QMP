package ar.edu.utn.frba.dds.qmp;

import java.util.List;

public class MotorUsuariosMayores55 extends MotorSugerencias {

    @Override
    public List<Atuendo> generarSugerencias(List<Prenda> prendas) {
        List<Prenda> prendasFormales = this.filtrarPorPrendasFormales(prendas);
        return super.generarSugerencias(prendasFormales);
    }

  private List<Prenda> filtrarPorPrendasFormales(List<Prenda> prendas) {
    return prendas.stream()
        .filter(prenda -> prenda.getFormalidad() == FormalidadPrenda.FORMAL)
        .toList();
  }

}
