package ar.edu.utn.frba.dds;

public class TipoTrama {
    private TipoTrama.TTrama nombre;

    public TipoTrama(TipoTrama.TTrama _nombre) {
        this.nombre = _nombre;
    }

    public TipoTrama.TTrama getNombre() {
        return nombre;
    }

    public enum TTrama {
        LISA,
        RAYADA,
        LUNARES,
        CUADROS,
        ESTAMPADO
    }
}
