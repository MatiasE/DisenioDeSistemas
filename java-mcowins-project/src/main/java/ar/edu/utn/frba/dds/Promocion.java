package ar.edu.utn.frba.dds;

public class Promocion implements Estado {
    Double descuento;

    public Double precioFinal(Double precioBase){
        return precioBase - descuento;
    }
}
