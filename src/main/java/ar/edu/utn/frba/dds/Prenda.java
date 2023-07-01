package ar.edu.utn.frba.dds;

public class Prenda {

  private TipoPrenda tipo;
  private CategoriaPrenda categoria;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario;

  public Prenda(TipoPrenda tipo, CategoriaPrenda categoria, Material material, Color colorPrincipal, Color colorSecundario) {
    this.validaciones(tipo,categoria,material,colorPrincipal);
    this.tipo = tipo;
    this.categoria = categoria;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  private void validaciones(TipoPrenda tipo, CategoriaPrenda categoria, Material material, Color colorPrincipal) {
    if (tipo == null) {
      throw new RuntimeException("No se especifico el tipo para la prenda");
    }
    if (categoria == null) {
      throw new RuntimeException("No se especifico la categoria para la prenda");
    }
    if (material == null) {
      throw new RuntimeException("No se especifico el material para la prenda");
    }
    if (colorPrincipal == null) {
      throw new RuntimeException("No se especifico el color principal para la prenda");
    }
    if (categoria != tipo.getCategoria()) {
      throw new RuntimeException("La categoria de la prenda con se condice con la categoria del tipo de prenda");
    }
  }

  public boolean existeColorSecundario() {
    return this.colorSecundario != null;
  }

}
