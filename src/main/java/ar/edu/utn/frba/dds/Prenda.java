package ar.edu.utn.frba.dds;

public class Prenda {

    private TipoPrenda tipo;
    private CategoriaPrenda categoria;
    private Material material;
    private Color colorPrincipal;
    private Color colorSecundario;
    private Formalidad formalidad;

    public Prenda(TipoPrenda tipo, CategoriaPrenda categoria, Material material, Color colorPrincipal, Color colorSecundario, Formalidad formalidad) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
        this.formalidad = formalidad;
    }

    public boolean existeColorSecundario() {
        return colorSecundario != null;
    }

    public TipoPrenda getTipo() {
        return tipo;
    }

    public CategoriaPrenda getCategoria() {
        return categoria;
    }

    public Material getMaterial() {
        return material;
    }

    public Color getColorPrincipal() {
        return colorPrincipal;
    }

    public Color getColorSecundario() {
        return colorSecundario;
    }

    public Formalidad getFormalidad() {
        return formalidad;
    }

    public boolean esPrendaSuperior() {
        return this.getCategoria() == CategoriaPrenda.PARTE_SUPERIOR;
  }

    public boolean esPrendaInferior() {
        return this.getCategoria() == CategoriaPrenda.PARTE_INFERIRO;
    }

    public boolean esPrendaCalzado() {
        return this.getCategoria() == CategoriaPrenda.CALZADO;
    }

    public boolean esInformal() {
        return this.formalidad == Formalidad.INFORMAL;
    }
}
