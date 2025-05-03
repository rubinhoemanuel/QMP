package ar.edu.utn.frba.dds.qmp;

import lombok.Getter;

@Getter
public class TipoPrenda {

  private Categoria categoria;

  public TipoPrenda(Categoria categoria) {
    this.categoria = categoria;
  }

}
