package ar.edu.utn.frba.dds.qmp;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class SastreJohnson implements Sastre {

  @Override
  public Atuendo fabricarUniforme() {
    return new Atuendo(
        this.fabricarParteSuperior(),
        this.fabricarParteInferior(),
        this.fabricarCalzado()
    );
  }

  @Override
  public Prenda fabricarParteSuperior() {
    //fabricar una camisa blanca
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Material seda = new Material(Trama.LISA);
    return prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_SUPERIOR))
        .especificarMaterial(seda)
        .especificarCategoria(Categoria.PARTE_SUPERIOR)
        .especificarColorPrincipal(new Color(255, 255, 255))
        .crearPrenda();
  }

  @Override
  public Prenda fabricarParteInferior() {
    //fabricar un pantalón de vestir negro
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Material lino = new Material(Trama.LISA);
    return prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.PARTE_INFERIOR))
        .especificarMaterial(lino)
        .especificarCategoria(Categoria.PARTE_INFERIOR)
        .especificarColorPrincipal(new Color(0, 0, 0))
        .crearPrenda();
  }

  @Override
  public Prenda fabricarCalzado() {
    //fabricar unos zapatos negros
    PrendaBorrador prendaBorrador = new PrendaBorrador();
    Material cuero = new Material(Trama.LISA);
    return prendaBorrador
        .especificarTipoPrenda(new TipoPrenda(Categoria.CALZADO))
        .especificarMaterial(cuero)
        .especificarCategoria(Categoria.CALZADO)
        .especificarColorPrincipal(new Color(0, 0, 0))
        .crearPrenda();
  }
}
