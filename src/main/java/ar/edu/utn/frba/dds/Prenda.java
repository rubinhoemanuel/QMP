package ar.edu.utn.frba.dds;

public class Prenda {

    private TipoPrenda tipo;
    private CategoriaPrenda categoria;
    private Material material;
    private Color colorPrincipal;
    private Color colorSecundario;

    public Prenda(TipoPrenda tipo, CategoriaPrenda categoria, Material material, Color colorPrincipal, Color colorSecundario) {
        validar(tipo, categoria, material, colorPrincipal, colorSecundario);
        this.tipo = tipo;
        this.categoria = categoria;
        this.material = material;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
    }

    private void validar(TipoPrenda tipo, CategoriaPrenda categoria, Material material, Color colorPrincipal, Color colorSecundario) {
        if (tipo==null) {
            throw new RuntimeException("No se cargo el tipo de prenda");
        }
        if (categoria==null) {
            throw new RuntimeException("No se cargo la categoria de la prenda");
        }
        if (material==null) {
            throw new RuntimeException("No se cargo el material de la prenda");
        }
        if (colorPrincipal==null) {
            throw new RuntimeException("No se cargo el color primario de la prenda");
        }
        if (tipo.getCategoria() != categoria) {
            throw new RuntimeException("La categoria del tipo de prenda no se condice con la categoria de la prenda");
        }
    }

    public boolean existeColorSecundario() {
        return colorSecundario != null;
    }

}
