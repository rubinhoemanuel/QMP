import ar.edu.utn.frba.dds.CategoriaPrenda;
import ar.edu.utn.frba.dds.Color;
import ar.edu.utn.frba.dds.Material;
import ar.edu.utn.frba.dds.Prenda;
import ar.edu.utn.frba.dds.TipoPrenda;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrendaTest {

  @Test
  public void crearPrendaSinTipo() {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      new Prenda(null,CategoriaPrenda.INFERIOR,Material.GABARDINA,crearColor(255, 255, 255),null);
    });
    Assertions.assertEquals("No se especifico el tipo para la prenda", thrown.getMessage());
  }

  @Test
  public void crearPrendaSinCategoria() {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      new Prenda(crearTipoPrenda(CategoriaPrenda.CALZADO),null,Material.GABARDINA,crearColor(255, 255, 255),null);
    });
    Assertions.assertEquals("No se especifico la categoria para la prenda", thrown.getMessage());
  }

  @Test
  public void crearPrendaSinMaterial() {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      new Prenda(crearTipoPrenda(CategoriaPrenda.CALZADO),CategoriaPrenda.CALZADO,null,crearColor(255, 255, 255),null);
    });
    Assertions.assertEquals("No se especifico el material para la prenda", thrown.getMessage());
  }

  @Test
  public void crearPrendaSinColorPrincipal() {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      new Prenda(crearTipoPrenda(CategoriaPrenda.CALZADO),CategoriaPrenda.CALZADO,Material.CUERO,null,null);
    });
    Assertions.assertEquals("No se especifico el color principal para la prenda", thrown.getMessage());
  }

  @Test
  public void validarColorSecundarioPrenda() {
    Prenda zapatillas = new Prenda(crearTipoPrenda(CategoriaPrenda.CALZADO),CategoriaPrenda.CALZADO,Material.CUERO,crearColor(255, 255, 255),crearColor(0, 0, 0));
    assertTrue(zapatillas.existeColorSecundario());
  }

  @Test
  public void validarSiCategoriaTipoPrendaCondiceConCategoriaPrenda() {
    RuntimeException thrown = Assertions.assertThrows(RuntimeException.class, () -> {
      new Prenda(crearTipoPrenda(CategoriaPrenda.CALZADO),CategoriaPrenda.SUPERIOR,Material.CUERO,crearColor(255, 255, 255),crearColor(0, 0, 0));
    });
    Assertions.assertEquals("La categoria de la prenda con se condice con la categoria del tipo de prenda", thrown.getMessage());
  }

  private TipoPrenda crearTipoPrenda(CategoriaPrenda categoriaPrenda) {
    return new TipoPrenda(categoriaPrenda);
  }

  private Color crearColor(int r, int g, int b) {
    return new Color(new BigDecimal(r),new BigDecimal(g), new BigDecimal(b));
  }

}
