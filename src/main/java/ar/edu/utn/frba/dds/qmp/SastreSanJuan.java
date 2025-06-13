package ar.edu.utn.frba.dds.qmp;

public class SastreSanJuan implements Sastre {

  @Override
  public Uniforme fabricarUniforme() {
    return new Uniforme(
        this.fabricarParteSuperior(),
        this.fabricarParteInferior(),
        this.fabricarCalzado()
    );
  }

  @Override
  public Prenda fabricarParteSuperior() {
    //fabricar una chomba verde de piqué
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Material pique = new Material(Trama.LISA);
    return prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_SUPERIOR))
        .especificarMaterial(pique)
        .especificarCategoria(Categoria.PARTE_SUPERIOR)
        .especificarColorPrincipal(new Color(0, 128, 0))
        .crearPrenda();
  }

  @Override
  public Prenda fabricarParteInferior() {
    //fabricar un pantalón de acetato gris
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Material acetato = new Material(Trama.LISA);
    return prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_INFERIOR))
        .especificarMaterial(acetato)
        .especificarCategoria(Categoria.PARTE_INFERIOR)
        .especificarColorPrincipal(new Color(128, 128, 128))
        .crearPrenda();
  }

  @Override
  public Prenda fabricarCalzado() {
    //fabricar unas zapatillas blancas
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Material lona = new Material(Trama.LISA);
    return prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.CALZADO))
        .especificarMaterial(lona)
        .especificarCategoria(Categoria.CALZADO)
        .especificarColorPrincipal(new Color(255, 255,  255))
        .crearPrenda();
  }
}
