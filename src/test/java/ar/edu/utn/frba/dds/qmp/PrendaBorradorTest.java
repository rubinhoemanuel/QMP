package ar.edu.utn.frba.dds.qmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PrendaBorradorTest {

  @Test
  public void testEspecificarTipoPrendaNulo() {
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Exception exception = assertThrows(RuntimeException.class, () -> {
      prendaBorrador
          .especificarTipoPrenda(null)
          .especificarMaterial(new Material(Trama.A_CUADROS))
          .especificarCategoria(Categoria.CALZADO)
          .especificarColorPrincipal(new Color(0,0,0))
          .especificarColorSecundario(new Color(255,255,255))
          .crearPrenda();
    });
    assertEquals("El tipo de prenda no puede ser nulo", exception.getMessage());
  }

  @Test
  public void testEspecificarMaterialNulo() {
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Exception exception = assertThrows(RuntimeException.class, () -> {
      prendaBorrador
          .especificarTipoPrenda(new TipoPrenda(Categoria.ACCESORIO))
          .especificarMaterial(null)
          .especificarCategoria(Categoria.CALZADO)
          .especificarColorPrincipal(new Color(0,0,0))
          .crearPrenda();
    });
    assertEquals("El material no puede ser nulo", exception.getMessage());
  }

  @Test
  public void testCrearPrendaCategoriaNula() {
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Exception exception = assertThrows(RuntimeException.class, () -> {
      prendaBorrador
          .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_INFERIOR))
          .especificarMaterial(new Material(Trama.LISA))
          .especificarCategoria(null)
          .especificarColorPrincipal(new Color(0,0,0))
          .crearPrenda();
    });
    assertEquals("La categoría no puede ser nula", exception.getMessage());
  }

  @Test
  public void testCrearPrendaColorPrincipalNulo() {
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Exception exception = assertThrows(RuntimeException.class, () -> {
      prendaBorrador
          .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_INFERIOR))
          .especificarMaterial(new Material(Trama.LISA))
          .especificarCategoria(Categoria.PARTE_INFERIOR)
          .especificarColorPrincipal(null)
          .especificarColorSecundario(new Color(255,255,255))
          .crearPrenda();
    });
    assertEquals("El color principal no puede ser nulo o vacío", exception.getMessage());
  }

  @Test
  public void testCrearPrendaNoCoincideCategoriaConTipoPrendaCategoria() {
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Exception exception = assertThrows(RuntimeException.class, () -> {
      prendaBorrador
          .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_INFERIOR))
          .especificarMaterial(new Material(Trama.LISA))
          .especificarCategoria(Categoria.PARTE_SUPERIOR)
          .especificarColorPrincipal(new Color(0,0,0))
          .crearPrenda();
    });
    assertEquals("La categoría de la prenda no coincide con la categoría del tipo de prenda", exception.getMessage());
  }

  @Test
  public void testCrearPrendaConTramaNullRetornaLisa() {
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Prenda prenda = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_SUPERIOR))
        .especificarMaterial(new Material(null))
        .especificarCategoria(Categoria.PARTE_SUPERIOR)
        .especificarColorPrincipal(new Color(0,0,0))
        .crearPrenda();
    assertEquals(Trama.LISA, prenda.getMaterial().getTrama());
  }

  @Test
  public void testCrearPrendaConColorSecundario() {
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Prenda prenda = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_SUPERIOR))
        .especificarMaterial(new Material(Trama.A_CUADROS))
        .especificarCategoria(Categoria.PARTE_SUPERIOR)
        .especificarColorPrincipal(new Color(0,0,0))
        .especificarColorSecundario(new Color(255,255,255))
        .crearPrenda();
    assertTrue(prenda.existeColorSecundario());
  }

}
