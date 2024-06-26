package ar.edu.utn.frba.dds;

public class Borrador {

    private TipoPrenda tipoPrenda;
    private Material material;
    private CategoriaPrenda categoriaPrenda;
    private Color colorPrincipal;
    private Color colorSecundario;
    private Formalidad formalidad;
    private Integer temperaturaMaxima;

    public Borrador tipoPrenda(TipoPrenda tipoPrenda){
        if (tipoPrenda==null) {
            throw new RuntimeException("No se cargo el tipo de prenda");
        }
        this.tipoPrenda = tipoPrenda;
        return this;
    }

    public Borrador material(Material material){
        if (material==null) {
            throw new RuntimeException("No se cargo el material de la prenda");
        }
        if (material.getTrama()==null) {
            material.setTrama(Trama.LISA);
        }
        this.material = material;
        return this;
    }

    public Borrador categoria(CategoriaPrenda categoriaPrenda){
        if (categoriaPrenda==null) {
            throw new RuntimeException("No se cargo la categoria de la prenda");
        }
        this.categoriaPrenda = categoriaPrenda;
        return this;
    }

    public Borrador colorPrincipal(Color colorPrincipal) {
        if (colorPrincipal==null) {
            throw new RuntimeException("No se cargo el color primario de la prenda");
        }
        this.colorPrincipal = colorPrincipal;
        return this;
    }

    public Borrador colorSecundario(Color colorSecundario){
        this.colorSecundario = colorSecundario;
        return this;
    }

    public Borrador formalidad(Formalidad formalidad){
        this.formalidad = formalidad;
        return this;
    }

    public Borrador temperaturaMaxima(Integer unaTemperatura) {
        this.temperaturaMaxima = unaTemperatura;
        return this;
    }

    public Prenda crear(){
        if (tipoPrenda.getCategoria() != categoriaPrenda) {
            throw new RuntimeException("La categoria del tipo de prenda no se condice con la categoria de la prenda");
        }
        return new Prenda(tipoPrenda, categoriaPrenda, material, colorPrincipal, colorSecundario, formalidad, temperaturaMaxima);
    }


}
