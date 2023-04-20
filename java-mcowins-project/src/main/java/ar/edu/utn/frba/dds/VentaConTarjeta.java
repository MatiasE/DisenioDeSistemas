package ar.edu.utn.frba.dds;

import java.time.LocalDate;
import java.util.List;

public class VentaConTarjeta extends Ventas {
    Double cantidadDeCuotas;
    Double coeficienteTarjeta;
    public void setCantidadDeCuotas(Double cantidadDeCuotas) {
        this.cantidadDeCuotas = cantidadDeCuotas;
    }

    public void setCoeficienteTarjeta(Double coeficienteTarjeta) {
        this.coeficienteTarjeta = coeficienteTarjeta;
    }

    public VentaConTarjeta(LocalDate fecha, List<Items> itemsList) {
        super(fecha, itemsList);
    }

    @Override
    public Double getPrecio() {
        return (coeficienteTarjeta * cantidadDeCuotas) + (0.01 * super.getPrecio()) + super.getPrecio();
    }
}
