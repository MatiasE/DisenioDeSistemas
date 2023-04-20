package ar.edu.utn.frba.dds;

import java.time.LocalDate;
import java.util.List;

public class Negocio {
    String nombre;
    List<Ventas> ventasList;

    public Negocio(String nombre, List<Ventas> ventasList) {
        this.nombre = nombre;
        this.ventasList = ventasList;
    }

    public String getNombre() {
        return nombre;
    }

    public Double totalVenta() {
        double suma = ventasList.stream().mapToDouble(Ventas::getPrecio).sum();
        return suma;
    }

    public List<Ventas> esDeFecha(LocalDate unaFecha) {
        List<Ventas> ventasPorFecha = ventasList.stream().filter(venta -> venta.esDeFecha(unaFecha)).toList();
        return ventasPorFecha;
    }

    public Double totalVentaFecha(LocalDate fecha) {
        List<Ventas> ventasFiltradaPorFecha = this.esDeFecha(fecha);
        double sumaPorFecha = ventasFiltradaPorFecha.stream().mapToDouble(Ventas::getPrecio).sum();
        return sumaPorFecha;
    }
}
