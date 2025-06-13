package ar.edu.utn.frba.dds.qmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class UniformeTest {

  @Test
  public void testFabricarUniformeSastreJohnson() {

    // Arrange
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Sastre sastreJohnson = new SastreJohnson();

    Material materialAlgodon = new Material(Trama.LISA);
    Material materialCuero = new Material(Trama.LISA);
    Color colorBlanco = new Color(255, 255, 255);
    Color colorNegro = new Color(0, 0, 0);

    Prenda prendaSuperiorCamisaBlanca = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_SUPERIOR))
        .especificarMaterial(materialAlgodon)
        .especificarCategoria(Categoria.PARTE_SUPERIOR)
        .especificarColorPrincipal(colorBlanco)
        .crearPrenda();

    Prenda prendaInferiorPantalonVestirNegro = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_INFERIOR))
        .especificarMaterial(materialAlgodon)
        .especificarCategoria(Categoria.PARTE_INFERIOR)
        .especificarColorPrincipal(colorNegro)
        .crearPrenda();

    Prenda prendaCalzadoZapatosNegros = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.CALZADO))
        .especificarMaterial(materialCuero)
        .especificarCategoria(Categoria.CALZADO)
        .especificarColorPrincipal(colorNegro)
        .crearPrenda();

    // Act
    Uniforme uniforme = sastreJohnson.fabricarUniforme();

    // Assert
    assertEquals(prendaSuperiorCamisaBlanca.getTipoPrenda().getCategoria(),uniforme.getPrendaSuperior().getCategoria());
    assertTrue(prendaSuperiorCamisaBlanca.getColorPrincipal().esIgual(uniforme.getPrendaSuperior().getColorPrincipal()));

    assertEquals(prendaInferiorPantalonVestirNegro.getTipoPrenda().getCategoria(),uniforme.getPrendaInferior().getCategoria());
    assertTrue(prendaInferiorPantalonVestirNegro.getColorPrincipal().esIgual(uniforme.getPrendaInferior().getColorPrincipal()));

    assertEquals(prendaCalzadoZapatosNegros.getTipoPrenda().getCategoria(),uniforme.getCalzado().getCategoria());
    assertTrue(prendaCalzadoZapatosNegros.getColorPrincipal().esIgual(uniforme.getCalzado().getColorPrincipal()));
  }

  @Test
  public void testFabricarUniformeSastreSanJuan() {

    // Arrange
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Sastre sastreSanJuan = new SastreSanJuan();

    Material materialPique = new Material(Trama.LISA);
    Material materialAcetato = new Material(Trama.LISA);
    Material materialCuero = new Material(Trama.LISA);
    Color colorVerde = new Color(0, 128, 0);
    Color colorGris = new Color(128, 128, 128);
    Color colorBlanco = new Color(255, 255, 255);

    Prenda prendaSuperiorChombaVerdeDePique = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_SUPERIOR))
        .especificarMaterial(materialPique)
        .especificarCategoria(Categoria.PARTE_SUPERIOR)
        .especificarColorPrincipal(colorVerde)
        .crearPrenda();

    Prenda prendaInferiorPantalonDeAcetatoGris = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_INFERIOR))
        .especificarMaterial(materialAcetato)
        .especificarCategoria(Categoria.PARTE_INFERIOR)
        .especificarColorPrincipal(colorGris)
        .crearPrenda();

    Prenda prendaCalzadoZapatillasBlancas = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.CALZADO))
        .especificarMaterial(materialCuero)
        .especificarCategoria(Categoria.CALZADO)
        .especificarColorPrincipal(colorBlanco)
        .crearPrenda();

    // Act
    Uniforme uniforme = sastreSanJuan.fabricarUniforme();

    // Assert
    assertEquals(prendaSuperiorChombaVerdeDePique.getTipoPrenda().getCategoria(),
        uniforme.getPrendaSuperior().getCategoria());
    assertTrue(uniforme.getPrendaSuperior().getColorPrincipal().esIgual(colorVerde));
    assertEquals(materialPique.getTrama(), uniforme.getPrendaSuperior().getMaterial().getTrama());

    assertEquals(prendaInferiorPantalonDeAcetatoGris.getTipoPrenda().getCategoria(),
        uniforme.getPrendaInferior().getCategoria());
    assertTrue(uniforme.getPrendaInferior().getColorPrincipal().esIgual(colorGris));
    assertEquals(materialAcetato.getTrama(), uniforme.getPrendaSuperior().getMaterial().getTrama());

    assertEquals(prendaCalzadoZapatillasBlancas.getTipoPrenda().getCategoria(),
        uniforme.getCalzado().getCategoria());
    assertTrue(uniforme.getCalzado().getColorPrincipal().esIgual(colorBlanco));
  }

}
