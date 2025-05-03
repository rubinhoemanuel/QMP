package ar.edu.utn.frba.dds.qmp;

import lombok.Getter;

@Getter
public class Prenda {

  private TipoPrenda tipoPrenda;
  private Categoria categoria;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario;

  public Prenda(TipoPrenda tipoPrenda,
                Categoria categoria,
                Material material,
                Color colorPrincipal,
                Color colorSecundario) {
    this.validarPrenda(tipoPrenda, categoria, material, colorPrincipal, colorSecundario);
    this.tipoPrenda = tipoPrenda;
    this.categoria = categoria;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  public void validarPrenda(TipoPrenda tipoPrenda,
                            Categoria categoria,
                            Material material,
                            Color colorPrincipal,
                            Color colorSecundario) {
    if (tipoPrenda == null) {
      throw new RuntimeException("El tipo de prenda no puede ser nulo");
    }
    if (categoria == null) {
      throw new RuntimeException("La categoría no puede ser nula");
    }
    if (material == null) {
      throw new RuntimeException("El material no puede ser nulo");
    }
    if (colorPrincipal == null) {
      throw new RuntimeException("El color principal no puede ser nulo o vacío");
    }
    if (categoria != tipoPrenda.getCategoria()) {
      throw new RuntimeException("La categoría de la prenda no coincide con la categoría del tipo"
          + " de prenda");
    }
  }

  public boolean existeColorSecundario() {
    return colorSecundario != null;
  }

}
