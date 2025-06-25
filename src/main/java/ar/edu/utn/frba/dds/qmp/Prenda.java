package ar.edu.utn.frba.dds.qmp;

import java.util.List;
import lombok.Getter;

@Getter
public class Prenda {

  private TipoPrenda tipoPrenda;
  private Categoria categoria;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario;
  private FormalidadPrenda formalidad;

  public Prenda(TipoPrenda tipoPrenda,
                Categoria categoria,
                Material material,
                Color colorPrincipal,
                Color colorSecundario,
                FormalidadPrenda formalidad) {
    this.tipoPrenda = tipoPrenda;
    this.categoria = categoria;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
    this.formalidad = formalidad;
  }

  public boolean existeColorSecundario() {
    return colorSecundario != null;
  }

}
