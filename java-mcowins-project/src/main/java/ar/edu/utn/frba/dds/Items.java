package ar.edu.utn.frba.dds;

import java.util.List;

public class Items {
    Prendas prenda;
    Double cantidad;

    public Items(Prendas prenda, Double cantidad) {
        this.prenda = prenda;
        this.cantidad = cantidad;
    }

    public Double importeItem() {
        return prenda.precioTotal() * cantidad;
    }
}
