package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static ar.edu.utn.frba.dds.TipoTrama.TTrama.LISA;

public class TestPrenda {
    @Test
    public void testTipoPrenda() {
        TipoPrenda tipoPrenda = new TipoPrenda(TipoPrenda.TPrenda.ZAPATO);
        Assertions.assertEquals(TipoPrenda.TPrenda.ZAPATO, tipoPrenda.getNombre());
    }

    @Test
    public void testTipoCategoria() {
        TipoCategoria tipoCategoria = new TipoCategoria(TipoCategoria.TCategoria.CALZADO);
        Assertions.assertEquals(TipoCategoria.TCategoria.CALZADO, tipoCategoria.getNombre());
    }

    @Test
    public void testTipoMaterial() {
        TipoMaterial tipoMaterial = new TipoMaterial(TipoMaterial.TMaterial.CUERO);
        Assertions.assertEquals(TipoMaterial.TMaterial.CUERO, tipoMaterial.getNombre());
    }

    @Test
    public void testTipoColorPrincipal() {
        TipoColorPrincipal tipoColorPrincipal = new TipoColorPrincipal(TipoColorPrincipal.TColorPrincipal.GRIS);
        Assertions.assertEquals(TipoColorPrincipal.TColorPrincipal.GRIS, tipoColorPrincipal.getNombre());
    }

    @Test
    public void testInstanciarPrenda() {
        Borrador borrador = new Borrador();
        TipoPrenda tipoPrenda = new TipoPrenda(TipoPrenda.TPrenda.ZAPATO);
        TipoCategoria tipoCategoria = new TipoCategoria(TipoCategoria.TCategoria.CALZADO);
        TipoMaterial tipoMaterial = new TipoMaterial(TipoMaterial.TMaterial.CUERO);
        TipoColorPrincipal tipoColorPrincipal = new TipoColorPrincipal(TipoColorPrincipal.TColorPrincipal.GRIS);
        TipoTrama tipoTrama = new TipoTrama(TipoTrama.TTrama.CUADROS);
        String colorSecundario = "Negro";
        Prenda prenda = borrador.crearPrenda(tipoPrenda, tipoCategoria, tipoMaterial, tipoColorPrincipal, tipoTrama, colorSecundario);
        Assertions.assertEquals("Fui Instanciada Correctamente", prenda.instancieCorrectamente());
    }

    @Test
    public void testInstanciarPrendaInvalido() {
        Borrador borrador = new Borrador();
        TipoPrenda tipoPrenda = new TipoPrenda(TipoPrenda.TPrenda.ZAPATO);
        TipoCategoria tipoCategoria = new TipoCategoria(TipoCategoria.TCategoria.CALZADO);
        TipoMaterial tipoMaterial = new TipoMaterial(TipoMaterial.TMaterial.CUERO);

        Assertions.assertThrows(NullException.class, () -> borrador.crearPrenda(tipoPrenda, tipoCategoria, tipoMaterial, null, null, null));
    }

    @Test
    public void testInstanaciarTiposYCategoriasDistintas() {
        Borrador borrador = new Borrador();
        TipoPrenda tipoPrenda = new TipoPrenda(TipoPrenda.TPrenda.ZAPATO);
        TipoCategoria tipoCategoria = new TipoCategoria(TipoCategoria.TCategoria.PARTE_SUPERIOR);
        TipoMaterial tipoMaterial = new TipoMaterial(TipoMaterial.TMaterial.CUERO);
        TipoColorPrincipal tipoColorPrincipal = new TipoColorPrincipal(TipoColorPrincipal.TColorPrincipal.GRIS);
        TipoTrama tipoTrama = new TipoTrama(LISA);
        String colorSecundario = "Ninguno";

        Assertions.assertThrows(TiposException.class, () -> borrador.crearPrenda(tipoPrenda, tipoCategoria, tipoMaterial, tipoColorPrincipal, tipoTrama, colorSecundario));
    }

    @Test
    public void testObtenerPorDefectoUnaTramaLisa() {
        Borrador borrador = new Borrador();
        TipoPrenda tipoPrenda = new TipoPrenda(TipoPrenda.TPrenda.ZAPATO);
        TipoCategoria tipoCategoria = new TipoCategoria(TipoCategoria.TCategoria.CALZADO);
        TipoMaterial tipoMaterial = new TipoMaterial(TipoMaterial.TMaterial.CUERO);
        TipoColorPrincipal tipoColorPrincipal = new TipoColorPrincipal(TipoColorPrincipal.TColorPrincipal.GRIS);
        String colorSecundario = "Negro";
        Prenda prenda = borrador.crearPrenda(tipoPrenda, tipoCategoria, tipoMaterial, tipoColorPrincipal, null, colorSecundario);

        Assertions.assertEquals(LISA, prenda.getTTrama());
    }
}
