package ar.edu.utn.frba.dds.qmp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UniformeTest {

  @Test
  public void testFabricarUniformeSastreJohnson() {

    // Arrange
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Sastre sastreJohnson = new SastreJohnson();

    Material materialAlgodon = new Material(Trama.LISA);
    Material materialCuero = new Material(Trama.LISA);

    Prenda prendaSuperiorCamisaBlanca = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_SUPERIOR))
        .especificarMaterial(materialAlgodon)
        .especificarCategoria(Categoria.PARTE_SUPERIOR)
        .especificarColorPrincipal(new Color(255, 255, 255))
        .crearPrenda();

    Prenda prendaInferiorPantalonVestirNegro = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_INFERIOR))
        .especificarMaterial(materialAlgodon)
        .especificarCategoria(Categoria.PARTE_INFERIOR)
        .especificarColorPrincipal(new Color(0, 0, 0))
        .crearPrenda();

    Prenda prendaCalzadoZapatosNegros = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.CALZADO))
        .especificarMaterial(materialCuero)
        .especificarCategoria(Categoria.CALZADO)
        .especificarColorPrincipal(new Color(0, 0, 0))
        .crearPrenda();

    // Act
    Uniforme uniforme = sastreJohnson.fabricarUniforme();

    // Assert
    assertEquals(uniforme.getPrendaSuperior(), uniforme.getPrendaSuperior());
    assertEquals(uniforme.getPrendaInferior(), uniforme.getPrendaInferior());
    assertEquals(uniforme.getCalzado(), uniforme.getCalzado());

  }

  @Test
  public void testFabricarUniformeSastreSanJuan() {

    // Arrange
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Sastre sastreSanJuan = new SastreSanJuan();

    Material materialPique = new Material(Trama.LISA);
    Material materialAcetato = new Material(Trama.LISA);
    Material materialCuero = new Material(Trama.LISA);

    Prenda prendaSuperiorChombaVerdeDePique = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_SUPERIOR))
        .especificarMaterial(materialPique)
        .especificarCategoria(Categoria.PARTE_SUPERIOR)
        .especificarColorPrincipal(new Color(0, 128, 0))
        .crearPrenda();

    Prenda prendaInferiorPantalonDeAcetatoGris = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_INFERIOR))
        .especificarMaterial(materialAcetato)
        .especificarCategoria(Categoria.PARTE_INFERIOR)
        .especificarColorPrincipal(new Color(128, 128, 128))
        .crearPrenda();

    Prenda prendaCalzadoZapatillasBlancas = prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.CALZADO))
        .especificarMaterial(materialCuero)
        .especificarCategoria(Categoria.CALZADO)
        .especificarColorPrincipal(new Color(255, 255, 255))
        .crearPrenda();

    // Act
    Uniforme uniforme = sastreSanJuan.fabricarUniforme();

    // Assert
    assertEquals(uniforme.getPrendaSuperior(), uniforme.getPrendaSuperior());
    assertEquals(uniforme.getPrendaInferior(), uniforme.getPrendaInferior());
    assertEquals(uniforme.getCalzado(), uniforme.getCalzado());

  }

}
