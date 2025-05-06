package ar.edu.utn.frba.dds.qmp;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PrendaTest {

  @Test
  public void testCreacionPrendaSinColorSecundario() {
    Prenda prendaSinColorSecudario = new Prenda(new TipoPrenda(Categoria.PARTE_SUPERIOR), Categoria.PARTE_SUPERIOR, new Material(null), new Color(0,0,0), null);
    assertFalse(prendaSinColorSecudario.existeColorSecundario());
  }

  @Test
  public void testCreacionPrendaConColorSecundario() {
    Prenda prendaSinColorSecudario = new Prenda(new TipoPrenda(Categoria.PARTE_SUPERIOR), Categoria.PARTE_SUPERIOR, new Material(Trama.A_CUADROS), new Color(0,0,0), new Color(255,255,255));
    assertTrue(prendaSinColorSecudario.existeColorSecundario());
  }

}
