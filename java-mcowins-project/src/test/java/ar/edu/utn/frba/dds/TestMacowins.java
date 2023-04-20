package ar.edu.utn.frba.dds;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestMacowins {

    @Test
    public void testCrearNegocio() {
        Negocio macowins = new Negocio("Macowins", new ArrayList<>());
        Assertions.assertEquals("Macowins", macowins.getNombre());
    }

    @Test
    public void testPrecioVentas() {
        Negocio macowins = new Negocio("Macowins", new ArrayList<>());
        LocalDate fechaUno = LocalDate.of(2023, 9, 23);

        Estado nueva = new Nueva();
        Prendas prendaUno = new Prendas(nueva,1000.0);
        Prendas prendaDos = new Prendas(nueva,100.0);
        Items itemUno = new Items(prendaUno,4.0);
        Items itemDos = new Items(prendaDos,7.0);
        Ventas ventas = new Ventas(fechaUno,new ArrayList<>());
        ventas.itemsList.add(itemUno);
        ventas.itemsList.add(itemDos);
        macowins.ventasList.add(ventas);
        Assertions.assertEquals(4700.0, macowins.totalVentaFecha(fechaUno));
    }

    @Test
    public void testPrecioPorFechaUno() {
        Negocio macowins = new Negocio("Macowins", new ArrayList<>());
        LocalDate fechaUno = LocalDate.of(2023, 9, 23);
        LocalDate fechaDos = LocalDate.of(2023, 5, 23);

        Estado nueva = new Nueva();
        Prendas prendaUno = new Prendas(nueva,1000.0);
        Prendas prendaDos = new Prendas(nueva,100.0);
        Items itemUno = new Items(prendaUno,4.0);
        Items itemDos = new Items(prendaDos,7.0);

        Ventas ventaUno = new Ventas(fechaUno, new ArrayList<>());
        Ventas ventaDos = new Ventas(fechaDos, new ArrayList<>());

        ventaUno.itemsList.add(itemUno);
        ventaDos.itemsList.add(itemDos);

        macowins.ventasList.add(ventaUno);
        macowins.ventasList.add(ventaDos);
        Assertions.assertEquals(4000.0, macowins.totalVentaFecha(fechaUno));
    }

    @Test
    public void testPrecioPorFechaDos() {
        Negocio macowins = new Negocio("Macowins", new ArrayList<>());
        LocalDate fechaUno = LocalDate.of(2023, 9, 23);
        LocalDate fechaDos = LocalDate.of(2023, 5, 23);

        Estado nueva = new Nueva();
        Prendas prendaUno = new Prendas(nueva,1000.0);
        Prendas prendaDos = new Prendas(nueva,100.0);
        Items itemUno = new Items(prendaUno,4.0);
        Items itemDos = new Items(prendaDos,7.0);

        Ventas ventaUno = new Ventas(fechaUno, new ArrayList<>());
        Ventas ventaDos = new Ventas(fechaDos, new ArrayList<>());

        ventaUno.itemsList.add(itemUno);
        ventaDos.itemsList.add(itemDos);

        macowins.ventasList.add(ventaUno);
        macowins.ventasList.add(ventaDos);
        Assertions.assertEquals(700.0, macowins.totalVentaFecha(fechaDos));
    }

    @Test
    public void testPrecioPorFechaYPorItem() {
        Negocio macowins = new Negocio("Macowins", new ArrayList<>());
        LocalDate fechaUno = LocalDate.of(2023, 9, 23);
        LocalDate fechaDos = LocalDate.of(2023, 5, 23);
        LocalDate fechaTres = LocalDate.of(2023, 4, 23);

        Estado nueva = new Nueva();
        Prendas prendaUno = new Prendas(nueva,1000.0);
        Prendas prendaDos = new Prendas(nueva,100.0);
        Prendas prendaTres = new Prendas(nueva, 400.0);
        Items itemUno = new Items(prendaUno,4.0);
        Items itemDos = new Items(prendaDos,7.0);
        Items itemTres = new Items(prendaTres, 1.0);
        Ventas ventaUno = new Ventas(fechaUno, new ArrayList<>());
        Ventas ventaDos = new Ventas(fechaDos, new ArrayList<>());
        Ventas ventaTres = new Ventas(fechaTres, new ArrayList<>());
        ventaUno.itemsList.add(itemUno);
        ventaDos.itemsList.add(itemDos);
        ventaTres.itemsList.add(itemTres);

        macowins.ventasList.add(ventaUno);
        macowins.ventasList.add(ventaDos);
        macowins.ventasList.add(ventaTres);
        Assertions.assertEquals(5100.0, macowins.totalVenta());
    }

    @Test
    public void testVentaConTarjeta() {
        Negocio macowins = new Negocio("Macowins", new ArrayList<>());
        LocalDate fechaTres = LocalDate.of(2023, 4, 23);

        Estado nueva = new Nueva();
        Prendas prendaTres = new Prendas(nueva, 400.0);
        Items itemTres = new Items(prendaTres, 1.0);
        VentaConTarjeta ventaTres = new VentaConTarjeta(fechaTres, new ArrayList<>());
        ventaTres.setCantidadDeCuotas(4.0);
        ventaTres.setCoeficienteTarjeta(0.1);

        ventaTres.itemsList.add(itemTres);
        macowins.ventasList.add(ventaTres);
        Assertions.assertEquals(404.4, macowins.totalVentaFecha(fechaTres));
    }

    // 2 Tests repetidos.
    @Test
    public void testPrecioPorFecha() {
        Negocio macowins = new Negocio("Macowins", new ArrayList<>());
        LocalDate fechaUno = LocalDate.of(2023, 9, 23);
        LocalDate fechaDos = LocalDate.of(2023, 5, 23);
        LocalDate fechaTres = LocalDate.of(2023, 4, 23);

        Estado nueva = new Nueva();
        Prendas prendaUno = new Prendas(nueva,1000.0);
        Prendas prendaDos = new Prendas(nueva,100.0);
        Prendas prendaTres = new Prendas(nueva, 400.0);
        Items itemUno = new Items(prendaUno,4.0);
        Items itemDos = new Items(prendaDos,7.0);
        Items itemTres = new Items(prendaTres, 1.0);
        Ventas ventaUno = new Ventas(fechaUno, new ArrayList<>());
        Ventas ventaDos = new Ventas(fechaDos, new ArrayList<>());
        Ventas ventaTres = new Ventas(fechaTres, new ArrayList<>());
        ventaUno.itemsList.add(itemUno);
        ventaDos.itemsList.add(itemDos);
        ventaTres.itemsList.add(itemTres);

        macowins.ventasList.add(ventaUno);
        macowins.ventasList.add(ventaDos);
        macowins.ventasList.add(ventaTres);
        Assertions.assertEquals(4000.0, macowins.totalVentaFecha(fechaUno));
    }

   @Test
    public void testearVentas() {
        Negocio macowins = new Negocio("Macowins", new ArrayList<>());
        Estado nueva = new Nueva();
        LocalDate fechaUno = LocalDate.of(2023, 9, 23);

        Prendas prendaUno = new Prendas(nueva,1000.0);
        Prendas prendaDos = new Prendas(nueva,100.0);
        Items itemUno = new Items(prendaUno,4.0);
        Items itemDos = new Items(prendaDos,7.0);
        Ventas ventas = new Ventas(fechaUno,new ArrayList<>());
        ventas.itemsList.add(itemUno);
        ventas.itemsList.add(itemDos);
        macowins.ventasList.add(ventas);
        Assertions.assertEquals(4700.0, macowins.totalVentaFecha(fechaUno));
    }
}
