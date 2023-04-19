package ar.edu.utn.frba.dds;

public class TipoColorPrincipal {
    private TColorPrincipal nombre;

    public TipoColorPrincipal(TColorPrincipal _nombre) {
        this.nombre = _nombre;
    }

    public TColorPrincipal getNombre() {
        return nombre;
    }

    public enum TColorPrincipal {
        ROJO,
        VERDE,
        GRIS;
    }
}
