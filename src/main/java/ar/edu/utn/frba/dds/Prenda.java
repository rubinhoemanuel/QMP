package ar.edu.utn.frba.dds;

public class Prenda {

    private TipoPrenda tipo;
    private CategoriaPrenda categoria;
    private Material material;
    private Color colorPrincipal;
    private Color colorSecundario;

    public Prenda(TipoPrenda tipo, CategoriaPrenda categoria, Material material, Color colorPrincipal, Color colorSecundario) {
        this.tipo = tipo;
        this.categoria = categoria;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
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

}
