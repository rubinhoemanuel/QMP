package ar.edu.utn.frba.dds;

import java.util.ArrayList;
import java.util.List;

public class ArmadorDeAtuendos {

    private List<Prenda> prendas;

    public ArmadorDeAtuendos(List<Prenda> prendas) {
        this.prendas = prendas;
    }

    public List<Atuendo> sugerirAtuendos(Prenda prendaSuperior, Prenda prendaInferior, Prenda prendaCalzado) {
        List<Prenda> prendasSuperiores = obtenerPrendasSuperiores(prendas);
        List<Prenda> prendasInferiores = obtenerPrendasInferiores(prendas);
        List<Prenda> prendasCalzados = obtenerPrendasCalzados(prendas);
        return armarAtuendosValidos(prendasSuperiores,prendasInferiores,prendasCalzados);
    }

    private List<Atuendo> armarAtuendosValidos(List<Prenda> prendasSuperiores, List<Prenda> prendasInferiores, List<Prenda> prendasCalzados) {
        List<Atuendo> atuendos = new ArrayList<>();
        prendasSuperiores.stream().map(ps ->
            prendas.stream().map(pi ->
                prendasCalzados.stream().map(pc ->
                    atuendos.add(new Atuendo(ps,pi,pc))
                )
            )
        );
        return atuendos;
    }


    private List<Prenda> obtenerPrendasCalzados(List<Prenda> prendas) {
        return prendas.stream().filter(pc -> pc.getCategoria().equals(CategoriaPrenda.CALZADO)).toList();
    }

    private List<Prenda> obtenerPrendasInferiores(List<Prenda> prendas) {
        return prendas.stream().filter(pi -> pi.getCategoria().equals(CategoriaPrenda.PARTE_INFERIRO)).toList();
    }

    private List<Prenda> obtenerPrendasSuperiores(List<Prenda> prendas) {
        return prendas.stream().filter(ps -> ps.getCategoria().equals(CategoriaPrenda.PARTE_SUPERIOR)).toList();
    }

}
