package ar.edu.utn.frba.dds;

import static ar.edu.utn.frba.dds.TipoPrenda.TPrenda.*;
import static ar.edu.utn.frba.dds.TipoCategoria.TCategoria.*;
public class Prenda {
    TipoPrenda prenda;
    TipoCategoria categoria;
    TipoMaterial material;
    TipoColorPrincipal color;
    String colorSecundario;

    public Prenda(
            TipoPrenda _prenda,
            TipoCategoria _categoria,
            TipoMaterial _material,
            TipoColorPrincipal _colorPrimario,
            String _colorSecundario)
    {
        // Instancio los Tipos:
        TipoCategoria calzado = new TipoCategoria(CALZADO);
        TipoCategoria parte_inferior = new TipoCategoria(PARTE_INFERIOR);
        TipoCategoria parte_superior = new TipoCategoria(PARTE_SUPERIOR);
        TipoCategoria accesorios = new TipoCategoria(ACCESORIOS);
        TipoPrenda pantalon = new TipoPrenda(PANTALON);
        TipoPrenda camisa_manga_corta = new TipoPrenda(CAMISA_MANGA_CORTA);
        TipoPrenda zapato = new TipoPrenda(ZAPATO);

        // Hago las validaciones de todos los puntos:
        if((_categoria.getNombre() == calzado.getNombre()) && ((_prenda.getNombre() == camisa_manga_corta.getNombre()) || (_prenda.getNombre() == pantalon.getNombre()))) {
            throw new TiposException(_prenda + " no es de tipo " + _categoria);
        }
        if((_categoria.getNombre() == parte_inferior.getNombre()) && (_prenda.getNombre() == camisa_manga_corta.getNombre())) {
            throw new TiposException(_prenda + " no es de tipo " + _categoria);
        }
        if((_categoria.getNombre() == parte_superior.getNombre()) && (_prenda.getNombre() == pantalon.getNombre() || _prenda.getNombre() == zapato.getNombre())) {
            throw new TiposException(_prenda + " no es de tipo " + _categoria);
        }
        if((_categoria.getNombre() == accesorios.getNombre()) && (_prenda.getNombre() == pantalon.getNombre() || _prenda.getNombre() == zapato.getNombre() || _prenda.getNombre() == camisa_manga_corta.getNombre())) {
            throw new TiposException(_prenda + " no es de tipo " + _categoria);
        }
        if (_prenda == null) {
            throw new NullException(_prenda + " es Null");
        } else {
            this.prenda = _prenda;
        }
        if (_categoria == null) {
            throw new NullException(_categoria + " es Null");
        } else {
            this.categoria = _categoria;
        }
        if (_material == null) {
            throw new NullException(_material + " es Null");
        } else {
            this.material = _material;
        }
        if (_colorPrimario == null) {
            throw new NullException(_colorPrimario + " es Null");
        } else {
            this.color = _colorPrimario;
        }
        this.colorSecundario = _colorSecundario;
    }

    // Metodos:

    // Creo un metodo para saber si instancio correctamente la clase.
    public String instancieCorrectamente() {
        return "Fui Instanciada Correctamente";
    }
}
