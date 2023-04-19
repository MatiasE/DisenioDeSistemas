package ar.edu.utn.frba.dds;

public class TipoCategoria {

    private TCategoria nombre;

    public TipoCategoria(TCategoria _nombre) {
        this.nombre = _nombre;
    }

    public TCategoria getNombre() {
        return nombre;
    }

    public enum TCategoria {
        PARTE_SUPERIOR,
        CALZADO,
        PARTE_INFERIOR,
        ACCESORIOS;
    }
}
