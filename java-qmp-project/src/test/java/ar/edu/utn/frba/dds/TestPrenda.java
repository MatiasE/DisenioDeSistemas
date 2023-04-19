package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
        TipoPrenda tipoPrenda = new TipoPrenda(TipoPrenda.TPrenda.ZAPATO);
        TipoCategoria tipoCategoria = new TipoCategoria(TipoCategoria.TCategoria.CALZADO);
        TipoMaterial tipoMaterial = new TipoMaterial(TipoMaterial.TMaterial.CUERO);
        TipoColorPrincipal tipoColorPrincipal = new TipoColorPrincipal(TipoColorPrincipal.TColorPrincipal.GRIS);

        Prenda prenda = new Prenda(tipoPrenda, tipoCategoria, tipoMaterial, tipoColorPrincipal, null);
        Assertions.assertEquals("Fui Instanciada Correctamente", prenda.instancieCorrectamente());
    }

    @Test
    public void testInstanciarPrendaInvalido() {
        TipoPrenda tipoPrenda = new TipoPrenda(TipoPrenda.TPrenda.ZAPATO);
        TipoCategoria tipoCategoria = new TipoCategoria(TipoCategoria.TCategoria.CALZADO);
        TipoMaterial tipoMaterial = new TipoMaterial(TipoMaterial.TMaterial.CUERO);

        Assertions.assertThrows(NullException.class, () -> new Prenda(tipoPrenda, tipoCategoria, tipoMaterial, null, null));
    }

    @Test
    public void testInstanaciarTiposYCategoriasDistintas() {
        TipoPrenda tipoPrenda = new TipoPrenda(TipoPrenda.TPrenda.ZAPATO);
        TipoCategoria tipoCategoria = new TipoCategoria(TipoCategoria.TCategoria.PARTE_SUPERIOR);
        TipoMaterial tipoMaterial = new TipoMaterial(TipoMaterial.TMaterial.CUERO);
        TipoColorPrincipal tipoColorPrincipal = new TipoColorPrincipal(TipoColorPrincipal.TColorPrincipal.GRIS);

        Assertions.assertThrows(TiposException.class, () -> new Prenda(tipoPrenda, tipoCategoria, tipoMaterial, tipoColorPrincipal, null));
    }
}
