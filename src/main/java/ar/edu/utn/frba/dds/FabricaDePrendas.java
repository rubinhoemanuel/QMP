package ar.edu.utn.frba.dds;

public class FabricaDePrendas {

    public FabricaDePrendas() {

    }

    public Prenda crearPrenda(TipoPrenda tipo, CategoriaPrenda categoria, Material material, Color colorPrimario, Color colorSecundario) {
        if (tipo==null) {
            throw new RuntimeException("No se cargo el tipo de prenda");
        }
        if (categoria==null) {
            throw new RuntimeException("No se cargo la categoria de la prenda");
        }
        if (material==null) {
            throw new RuntimeException("No se cargo el material de la prenda");
        }
        if (colorPrimario==null) {
            throw new RuntimeException("No se cargo el color primario de la prenda");
        }
        if (tipo.getCategoria() != categoria) {
            throw new RuntimeException("La categoria del tipo de prenda no se condice con la categoria de la prenda");
        }
        return new Prenda(tipo, categoria, material, colorPrimario, colorSecundario);
    }

}
