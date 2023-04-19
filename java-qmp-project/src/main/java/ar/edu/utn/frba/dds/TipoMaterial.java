package ar.edu.utn.frba.dds;

public class TipoMaterial {
    private TMaterial nombre;

    public TipoMaterial(TMaterial _nombre) {
        this.nombre = _nombre;
    }

    public TMaterial getNombre() {
        return nombre;
    }

    public enum TMaterial {
        CUERO,
        JEAN;
    }
}
