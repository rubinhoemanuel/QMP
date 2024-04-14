package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PrendaTest {

    private TipoPrenda tipoPrendaRemera;
    private Color colorNegro;
    private Color colorBlanco;

    @BeforeEach
    public void init() {
        tipoPrendaRemera = new TipoPrenda("Nike", CategoriaPrenda.PARTE_SUPERIOR);
        colorNegro = new Color(0,0,0);
        colorBlanco = new Color(255,255,255);
    }

    @Test
    public void crearPrendaSinTipo() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Prenda prendaSinTipo = new Prenda(null, null, null, null, null);
        });
        String expectedMessage = "No se cargo el tipo de prenda";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void crearPrendaSinCategoria() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Prenda prendaSinCategoria = new Prenda(tipoPrendaRemera, null, null, null, null);
        });
        String expectedMessage = "No se cargo la categoria de la prenda";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void crearPrendaSinMaterial() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Prenda prendaSinMaterial = new Prenda(tipoPrendaRemera, CategoriaPrenda.PARTE_SUPERIOR, null, null, null);
        });
        String expectedMessage = "No se cargo el material de la prenda";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void crearPrendaSinColorPrimario() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Prenda prendaSinColorPrimario = new Prenda(tipoPrendaRemera, CategoriaPrenda.PARTE_SUPERIOR, Material.ALGODON, null, null);
        });
        String expectedMessage = "No se cargo el color primario de la prenda";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void crearPrendaSinCoincidirCategoriaTipoPrendaConCategoria() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Prenda prendaSinColorPrimario = new Prenda(tipoPrendaRemera, CategoriaPrenda.CALZADO, Material.ALGODON, colorNegro, null);
        });
        String expectedMessage = "La categoria del tipo de prenda no se condice con la categoria de la prenda";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void verificarColorSecundarioPrenda() {
        Prenda prendaConColorSecundario = new Prenda(tipoPrendaRemera, CategoriaPrenda.PARTE_SUPERIOR, Material.ALGODON, colorNegro, colorBlanco);
        assertTrue(prendaConColorSecundario.existeColorSecundario());
    }

}
