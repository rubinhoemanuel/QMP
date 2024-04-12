package ar.edu.utn.frba.dds;

public class TipoPrenda {

    private String nombre;

    private CategoriaPrenda categoria;

    public TipoPrenda(String nombre, CategoriaPrenda categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public CategoriaPrenda getCategoria() {
        return categoria;
    }

}
