package ar.edu.utn.frba.dds;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Prenda {

    private TipoPrenda tipo;
    private CategoriaPrenda categoria;
    private Material material;
    private Color colorPrincipal;
    private Color colorSecundario;
    private Formalidad formalidad;
    private Integer temperaturaMaxima;

    public boolean existeColorSecundario() {
        return colorSecundario != null;
    }

    public boolean esPrendaSuperior() {
        return this.getCategoria() == CategoriaPrenda.PARTE_SUPERIOR;
  }

    public boolean esPrendaInferior() {
        return this.getCategoria() == CategoriaPrenda.PARTE_INFERIOR;
    }

    public boolean esPrendaCalzado() {
        return this.getCategoria() == CategoriaPrenda.CALZADO;
    }

    public boolean esInformal() {
        return this.formalidad == Formalidad.INFORMAL;
    }

    public boolean esAdecuadaParaUnaTemperatura(Integer unaTemperatura) {
        return this.temperaturaMaxima > unaTemperatura;
    }

}
