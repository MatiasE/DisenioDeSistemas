package ar.edu.utn.frba.dds;

public class TipoPrenda {
    private TPrenda nombre;

    public TipoPrenda(TPrenda _nombre) {
        this.nombre = _nombre;
    }

    public TPrenda getNombre() {
        return nombre;
    }

    public enum TPrenda {
        ZAPATO,
        CAMISA_MANGA_CORTA,
        PANTALON;
    }
}