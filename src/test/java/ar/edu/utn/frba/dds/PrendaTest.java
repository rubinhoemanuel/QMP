package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrendaTest {

    private TipoPrenda tipoPrendaRemera;
    private Color colorNegro;
    private Color colorBlanco;
    private Borrador borrador;
    private Material materialAlgodonRayado;

    @BeforeEach
    public void init() {
        tipoPrendaRemera = new TipoPrenda("Nike", CategoriaPrenda.PARTE_SUPERIOR);
        colorNegro = new Color(0,0,0);
        colorBlanco = new Color(255,255,255);
        materialAlgodonRayado = new Material(TipoMaterial.ALGODON, Trama.RAYADA);
        borrador = new Borrador();
    }

    @Test
    public void crearPrendaSinTipo() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Prenda prendaSinTipo = borrador
                    .tipoPrenda(null)
                    .crear();
        });
        String expectedMessage = "No se cargo el tipo de prenda";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void crearPrendaSinCategoria() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Prenda prendaSinCategoria = borrador
                    .tipoPrenda(tipoPrendaRemera)
                    .categoria(null)
                    .crear();
        });
        String expectedMessage = "No se cargo la categoria de la prenda";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void crearPrendaSinMaterial() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            //Prenda prendaSinMaterial = new Prenda(tipoPrendaRemera, CategoriaPrenda.PARTE_SUPERIOR, null, null, null);
            Prenda prendaSinMaterial = borrador
                    .tipoPrenda(tipoPrendaRemera)
                    .material(null)
                    .crear();
        });
        String expectedMessage = "No se cargo el material de la prenda";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void crearPrendaSinColorPrimario() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            //Prenda prendaSinColorPrimario = new Prenda(tipoPrendaRemera, CategoriaPrenda.PARTE_SUPERIOR, Material.ALGODON, null, null);
            Prenda prendaSinColorPrimario = borrador
                    .tipoPrenda(tipoPrendaRemera)
                    .material(materialAlgodonRayado)
                    .categoria(CategoriaPrenda.PARTE_SUPERIOR)
                    .colorPrincipal(null)
                    .crear();
        });
        String expectedMessage = "No se cargo el color primario de la prenda";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void crearPrendaSinCoincidirCategoriaTipoPrendaConCategoria() {
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Prenda prendaSinColorPrimario = borrador
                    .tipoPrenda(tipoPrendaRemera)
                    .material(materialAlgodonRayado)
                    .categoria(CategoriaPrenda.CALZADO)
                    .colorPrincipal(colorNegro)
                    .colorSecundario(null)
                    .crear();
        });
        String expectedMessage = "La categoria del tipo de prenda no se condice con la categoria de la prenda";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void verificarColorSecundarioPrenda() {
        Prenda prendaConColorSecundario = borrador
                .tipoPrenda(tipoPrendaRemera)
                .material(materialAlgodonRayado)
                .categoria(CategoriaPrenda.PARTE_SUPERIOR)
                .colorPrincipal(colorBlanco)
                .colorSecundario(colorNegro)
                .crear();
        assertTrue(prendaConColorSecundario.existeColorSecundario());
    }

    @Test
    public void verificarTramaMaterialLisoCuandoNoHayTrama() {
        Prenda prendaSinTramaEnMaterial = borrador
                .tipoPrenda(tipoPrendaRemera)
                .material(new Material(TipoMaterial.ALGODON, null))
                .categoria(CategoriaPrenda.PARTE_SUPERIOR)
                .colorPrincipal(colorBlanco)
                .colorSecundario(colorNegro)
                .crear();
        assertEquals(Trama.LISA, prendaSinTramaEnMaterial.getMaterial().getTrama());
    }

}
