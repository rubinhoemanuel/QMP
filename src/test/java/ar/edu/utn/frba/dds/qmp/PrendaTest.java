package ar.edu.utn.frba.dds.qmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PrendaTest {

  @Test
  public void testCreacionPrendaSinTipo() {
    Exception exception = assertThrows(RuntimeException.class, () -> {
      new Prenda(null, Categoria.PARTE_SUPERIOR, Material.ALGODON, new Color(0,0,0), new Color(255,255,255));
    });
    assertEquals("El tipo de prenda no puede ser nulo", exception.getMessage());
  }

  @Test
  public void testCreacionPrendaSinCategoria() {
    Exception exception = assertThrows(RuntimeException.class, () -> {
      new Prenda(new TipoPrenda(Categoria.PARTE_SUPERIOR), null, Material.ALGODON, new Color(0,0,0), new Color(255,255,255));
    });
    assertEquals("La categoría no puede ser nula", exception.getMessage());
  }

  @Test
  public void testCreacionPrendaSinMaterial() {
    Exception exception = assertThrows(RuntimeException.class, () -> {
      new Prenda(new TipoPrenda(Categoria.PARTE_SUPERIOR), Categoria.PARTE_SUPERIOR, null, new Color(0,0,0), new Color(255,255,255));
    });
    assertEquals("El material no puede ser nulo", exception.getMessage());
  }

  @Test
  public void testCreacionPrendaSinColorPrincipal() {
    Exception exception = assertThrows(RuntimeException.class, () -> {
      new Prenda(new TipoPrenda(Categoria.PARTE_SUPERIOR), Categoria.PARTE_SUPERIOR, Material.ALGODON, null, new Color(255,255,255));
    });
    assertEquals("El color principal no puede ser nulo o vacío", exception.getMessage());
  }

  @Test
  public void testCreacionPrendaNoCoincideCategoriaConTipoPrendaCategoria() {
    Exception exception = assertThrows(RuntimeException.class, () -> {
      new Prenda(new TipoPrenda(Categoria.PARTE_SUPERIOR), Categoria.PARTE_INFERIOR, Material.ALGODON, new Color(0,0,0), new Color(255,255,255));
    });
    assertEquals("La categoría de la prenda no coincide con la categoría del tipo de prenda", exception.getMessage());
  }

  @Test
  public void testCreacionPrendaSinColorSecundario() {
    Prenda prendaSinColorSecudario = new Prenda(new TipoPrenda(Categoria.PARTE_SUPERIOR), Categoria.PARTE_SUPERIOR, Material.ALGODON, new Color(0,0,0), null);
    assertFalse(prendaSinColorSecudario.existeColorSecundario());
  }

  @Test
  public void testCreacionPrendaConColorSecundario() {
    Prenda prendaSinColorSecudario = new Prenda(new TipoPrenda(Categoria.PARTE_SUPERIOR), Categoria.PARTE_SUPERIOR, Material.ALGODON, new Color(0,0,0), new Color(255,255,255));
    assertTrue(prendaSinColorSecudario.existeColorSecundario());
  }

}
