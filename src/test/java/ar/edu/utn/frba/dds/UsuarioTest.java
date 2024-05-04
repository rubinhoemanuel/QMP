package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {

  private MotorDeSugerenciasBasico motorBasico;
  private MotorDeSugerenciasNoInformalMayoresDe55 motorNoInformalMayoresDe55;

  @BeforeEach
  public void setUp() {
    motorBasico = new MotorDeSugerenciasBasico();
    motorNoInformalMayoresDe55 = new MotorDeSugerenciasNoInformalMayoresDe55();
  }

  @Test
  public void sugerenciasDeUsuarioMenorDe55ConMotorBasico() {
    ServiceLocator.getInstance().setMotorDeSugerencias(motorBasico);
    List<Prenda> prendas = generarPrendas();
    Usuario jose = new Usuario(prendas, 30);
    List<Sugerencia> sugerencias = jose.generarSugerencias();
    assertEquals(sugerencias.size(), 8);
  }

  @Test
  public void sugerenciasDeUsuarioMayorDe55ConMotorBasico() {
    ServiceLocator.getInstance().setMotorDeSugerencias(motorBasico);
    List<Prenda> prendas = generarPrendas();
    Usuario pedro = new Usuario(prendas, 60);
    List<Sugerencia> sugerencias = pedro.generarSugerencias();
    assertEquals(sugerencias.size(), 8);
  }

  @Test
  public void sugerenciasDeUsuarioMenorDe55ConMotorDeSugerenciasNoInformalMayoresDe55() {
    ServiceLocator.getInstance().setMotorDeSugerencias(motorNoInformalMayoresDe55);
    List<Prenda> prendas = generarPrendas();
    Usuario maria = new Usuario(prendas, 22);
    List<Sugerencia> sugerencias = maria.generarSugerencias();
    assertEquals(sugerencias.size(), 8);
  }

  @Test
  public void sugerenciasDeUsuarioMayorDe55ConMotorDeSugerenciasNoInformalMayoresDe55() {
    ServiceLocator.getInstance().setMotorDeSugerencias(motorNoInformalMayoresDe55);
    List<Prenda> prendas = generarPrendas();
    Usuario rosa = new Usuario(prendas, 70);
    List<Sugerencia> sugerencias = rosa.generarSugerencias();
    assertEquals(sugerencias.size(), 2);
  }

  private List<Prenda> generarPrendas() {

    TipoPrenda tipoCamisa = new TipoPrenda("camisas", CategoriaPrenda.PARTE_SUPERIOR);
    TipoPrenda tipoRemera = new TipoPrenda("remeras", CategoriaPrenda.PARTE_SUPERIOR);

    TipoPrenda tipoPantalon = new TipoPrenda("pantalones", CategoriaPrenda.PARTE_INFERIRO);
    TipoPrenda tipoPollera = new TipoPrenda("polleras", CategoriaPrenda.PARTE_INFERIRO);

    TipoPrenda tipoZapatilla = new TipoPrenda("zapatillas", CategoriaPrenda.CALZADO);
    TipoPrenda tipoZapato = new TipoPrenda("zapatos", CategoriaPrenda.CALZADO);

    Material materialAlgodonRayado = new Material(TipoMaterial.ALGODON, Trama.RAYADA);
    Material materialPoliesterLiso = new Material(TipoMaterial.POLIESTER, Trama.LISA);
    Material materialCueroACuadros = new Material(TipoMaterial.CUERO, Trama.A_CUADROS);

    Color colorRojo = new Color(255,0,0);
    Color colorVerde = new Color(0,255,0);
    Color colorNegro = new Color(0,0,255);

    Prenda prendaCamisaAlgodonRayadoRojo = new Prenda(tipoCamisa, CategoriaPrenda.PARTE_SUPERIOR, materialAlgodonRayado, colorRojo, null, Formalidad.FORMAL);
    Prenda prendaRemeraPoliesterLisaRoja = new Prenda(tipoRemera, CategoriaPrenda.PARTE_SUPERIOR, materialPoliesterLiso, colorVerde, null, Formalidad.NEUTRA);

    Prenda prendaPantalonAlgodonRayadoNegro = new Prenda(tipoPantalon, CategoriaPrenda.PARTE_INFERIRO, materialAlgodonRayado, colorNegro, null, Formalidad.FORMAL);
    Prenda prendaPolleraCueroACuadrosRoja = new Prenda(tipoPollera, CategoriaPrenda.PARTE_INFERIRO, materialCueroACuadros, colorRojo, null, Formalidad.INFORMAL);

    Prenda prendaZapatillaCueroACuadrosVerde = new Prenda(tipoZapatilla, CategoriaPrenda.CALZADO, materialCueroACuadros, colorNegro, null, Formalidad.FORMAL);
    Prenda prendaZapatoCueroACuadrosNegra = new Prenda(tipoZapato, CategoriaPrenda.CALZADO, materialCueroACuadros, colorNegro, null, Formalidad.INFORMAL);

    List<Prenda> prendas = new ArrayList<>();
    prendas.add(prendaCamisaAlgodonRayadoRojo);
    prendas.add(prendaRemeraPoliesterLisaRoja);
    prendas.add(prendaPantalonAlgodonRayadoNegro);
    prendas.add(prendaPolleraCueroACuadrosRoja);
    prendas.add(prendaZapatillaCueroACuadrosVerde);
    prendas.add(prendaZapatoCueroACuadrosNegra);

    return prendas;
  }

}
