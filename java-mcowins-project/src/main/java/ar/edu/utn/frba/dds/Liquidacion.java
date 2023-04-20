package ar.edu.utn.frba.dds;

public class Liquidacion implements Estado {
    public Double precioFinal(Double precioBase){
        return precioBase * 0.5;
    }
}
