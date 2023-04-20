package ar.edu.utn.frba.dds;

public class Prendas {
    Estado estado;
    Double precioBase;

    public Double precioTotal(){
        return estado.precioFinal(precioBase);
    }
    public Prendas(Estado estado,Double precioBase) {
        this.estado = estado;
        this.precioBase = precioBase;
    }

}
