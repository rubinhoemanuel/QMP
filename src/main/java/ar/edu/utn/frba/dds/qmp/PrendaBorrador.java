package ar.edu.utn.frba.dds.qmp;

public class PrendaBorrador {

  private TipoPrenda tipoPrenda;
  private Material material;
  private Categoria categoria;
  private Color colorPrincipal;
  private Color colorSecundario;

  public PrendaBorrador especificarTipoPrenda(TipoPrenda tipoPrenda) {
    this.tipoPrenda = tipoPrenda;
    return this;
  }

  public PrendaBorrador especificarMaterial(Material material) {
    this.material = material;
    return this;
  }

  public PrendaBorrador especificarCategoria(Categoria categoria) {
    this.categoria = categoria;
    return this;
  }

  public PrendaBorrador especificarColorPrincipal(Color colorPrincipal) {
    this.colorPrincipal = colorPrincipal;
    return this;
  }

  public PrendaBorrador especificarColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
    return this;
  }

  public Prenda crearPrenda() {
    this.validarPrendaBorrador();
    return new Prenda(this.tipoPrenda,
        this.categoria,
        this.material,
        this.colorPrincipal,
        this.colorSecundario);
  }

  private void validarPrendaBorrador() {
    if (this.tipoPrenda == null) {
      throw new RuntimeException("El tipo de prenda no puede ser nulo");
    }
    if (this.material == null) {
      throw new RuntimeException("El material no puede ser nulo");
    }
    if (this.categoria == null) {
      throw new RuntimeException("La categoría no puede ser nula");
    }
    if (this.colorPrincipal == null) {
      throw new RuntimeException("El color principal no puede ser nulo o vacío");
    }
    if (this.categoria != this.tipoPrenda.getCategoria()) {
      throw new RuntimeException("La categoría de la prenda no coincide con la categoría del tipo"
          + " de prenda");
    }
  }

}
