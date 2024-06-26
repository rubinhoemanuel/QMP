package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioTest {

  private MotorDeSugerenciasBasico motorBasico;
  private MotorDeSugerenciasNoInformalMayoresDe55 motorNoInformalMayoresDe55;
  private ServicioMeteorologicoAccuWeather servicioMeteorologico;
  private AccuWeatherAPI apiClima;
  private Borrador borrador;

  @BeforeEach
  public void setUp() {
    this.borrador = new Borrador();
    this.apiClima = new AccuWeatherAPI();
    this.servicioMeteorologico = new ServicioMeteorologicoAccuWeather(apiClima);
    motorBasico = new MotorDeSugerenciasBasico(this.servicioMeteorologico);
    motorNoInformalMayoresDe55 = new MotorDeSugerenciasNoInformalMayoresDe55(this.servicioMeteorologico);
  }

  @Test
  public void sugerenciasDeUsuarioMenorDe55ConMotorBasico() {
    ServiceLocator.getInstance().setMotorDeSugerencias(motorBasico);
    List<Prenda> prendas = generarPrendas();
    Usuario jose = new Usuario(prendas, 30);
    List<Sugerencia> sugerencias = jose.generarSugerencias();
    assertEquals(sugerencias.size(), 1);
  }

  @Test
  public void sugerenciasDeUsuarioMayorDe55ConMotorBasico() {
    ServiceLocator.getInstance().setMotorDeSugerencias(motorBasico);
    List<Prenda> prendas = generarPrendas();
    Usuario pedro = new Usuario(prendas, 60);
    List<Sugerencia> sugerencias = pedro.generarSugerencias();
    assertEquals(sugerencias.size(), 1);
  }

  @Test
  public void sugerenciasDeUsuarioMenorDe55ConMotorDeSugerenciasNoInformalMayoresDe55() {
    ServiceLocator.getInstance().setMotorDeSugerencias(motorNoInformalMayoresDe55);
    List<Prenda> prendas = generarPrendas();
    Usuario maria = new Usuario(prendas, 22);
    List<Sugerencia> sugerencias = maria.generarSugerencias();
    assertEquals(sugerencias.size(), 1);
  }

  @Test
  public void sugerenciasDeUsuarioMayorDe55ConMotorDeSugerenciasNoInformalMayoresDe55() {
    ServiceLocator.getInstance().setMotorDeSugerencias(motorNoInformalMayoresDe55);
    List<Prenda> prendas = generarPrendas();
    Usuario rosa = new Usuario(prendas, 70);
    List<Sugerencia> sugerencias = rosa.generarSugerencias();
    assertEquals(sugerencias.size(), 1);
  }

  private List<Prenda> generarPrendas() {

    TipoPrenda tipoCamisa = new TipoPrenda("camisas", CategoriaPrenda.PARTE_SUPERIOR);
    TipoPrenda tipoRemera = new TipoPrenda("remeras", CategoriaPrenda.PARTE_SUPERIOR);

    TipoPrenda tipoPantalon = new TipoPrenda("pantalones", CategoriaPrenda.PARTE_INFERIOR);
    TipoPrenda tipoPollera = new TipoPrenda("polleras", CategoriaPrenda.PARTE_INFERIOR);

    TipoPrenda tipoZapatilla = new TipoPrenda("zapatillas", CategoriaPrenda.CALZADO);
    TipoPrenda tipoZapato = new TipoPrenda("zapatos", CategoriaPrenda.CALZADO);

    Material materialAlgodonRayado = new Material(TipoMaterial.ALGODON, Trama.RAYADA);
    Material materialPoliesterLiso = new Material(TipoMaterial.POLIESTER, Trama.LISA);
    Material materialCueroACuadros = new Material(TipoMaterial.CUERO, Trama.A_CUADROS);

    Color colorRojo = new Color(255,0,0);
    Color colorVerde = new Color(0,255,0);
    Color colorNegro = new Color(0,0,255);

    Prenda prendaCamisaAlgodonRayadoRojo = this.borrador
        .tipoPrenda(tipoCamisa)
        .categoria(CategoriaPrenda.PARTE_SUPERIOR)
        .material(materialAlgodonRayado)
        .colorPrincipal(colorRojo)
        .formalidad(Formalidad.FORMAL)
        .temperaturaMaxima(20)
        .crear();

    Prenda prendaRemeraPoliesterLisaRoja = this.borrador
        .tipoPrenda(tipoRemera)
        .categoria(CategoriaPrenda.PARTE_SUPERIOR)
        .material(materialPoliesterLiso)
        .colorPrincipal(colorVerde)
        .formalidad(Formalidad.NEUTRA)
        .temperaturaMaxima(10)
        .crear();

    Prenda prendaPantalonAlgodonRayadoNegro = this.borrador
        .tipoPrenda(tipoPantalon)
        .categoria(CategoriaPrenda.PARTE_INFERIOR)
        .material(materialAlgodonRayado)
        .colorPrincipal(colorNegro)
        .formalidad(Formalidad.FORMAL)
        .temperaturaMaxima(20)
        .crear();

    Prenda prendaPolleraCueroACuadrosRoja = this.borrador
        .tipoPrenda(tipoPollera)
        .categoria(CategoriaPrenda.PARTE_INFERIOR)
        .material(materialCueroACuadros)
        .colorPrincipal(colorRojo)
        .formalidad(Formalidad.INFORMAL)
        .temperaturaMaxima(10)
        .crear();

    Prenda prendaZapatillaCueroACuadrosVerde = this.borrador
        .tipoPrenda(tipoZapatilla)
        .categoria(CategoriaPrenda.CALZADO)
        .material(materialCueroACuadros)
        .colorPrincipal(colorNegro)
        .formalidad(Formalidad.FORMAL)
        .temperaturaMaxima(20)
        .crear();
      //new Prenda(tipoZapatilla, CategoriaPrenda.CALZADO, materialCueroACuadros, colorNegro, null, Formalidad.FORMAL);

    Prenda prendaZapatoCueroACuadrosNegra = this.borrador
        .tipoPrenda(tipoZapato)
        .categoria(CategoriaPrenda.CALZADO)
        .material(materialCueroACuadros)
        .colorPrincipal(colorNegro)
        .formalidad(Formalidad.INFORMAL)
        .temperaturaMaxima(10)
        .crear();

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
