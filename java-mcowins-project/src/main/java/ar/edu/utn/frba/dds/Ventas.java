package ar.edu.utn.frba.dds;

import java.time.LocalDate;
import java.util.List;

public class Ventas {
    LocalDate fecha;
    List<Items> itemsList;

    public Ventas(LocalDate fecha, List<Items> itemsList) {
        this.fecha = fecha;
        this.itemsList = itemsList;
    }

    public Boolean esDeFecha(LocalDate fecha) {
        return this.fecha == fecha;
    }

    public Double getPrecio() {
        Double precio = itemsList.stream().mapToDouble(Items::importeItem).sum();
        return precio;
    }
}
