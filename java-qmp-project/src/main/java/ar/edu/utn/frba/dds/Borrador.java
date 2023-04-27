package ar.edu.utn.frba.dds;

import static ar.edu.utn.frba.dds.TipoCategoria.TCategoria.*;
import static ar.edu.utn.frba.dds.TipoCategoria.TCategoria.ACCESORIOS;
import static ar.edu.utn.frba.dds.TipoPrenda.TPrenda.*;

public class Borrador {
    Prenda prenda;
    TipoPrenda tprenda;
    TipoCategoria categoria;
    TipoMaterial material;
    TipoColorPrincipal colorPrimario;
    TipoTrama trama;
    String colorSecundario;

    public void especificarTipo(TipoPrenda _tprenda) {
        if(_tprenda == null) {
            throw new NullException(_tprenda + " no puede ser NULL");
        }
        this.tprenda = _tprenda;
    }

    public void especificarCategoria(TipoCategoria _categoria) {
        if(_categoria == null) {
            throw new NullException(_categoria + " no puede ser NULL");
        }
        this.categoria = _categoria;
    }

    public void especificarMaterial(TipoMaterial _material) {
        if(_material == null) {
            throw new NullException(_material + " no puede ser NULL");
        }
        this.material = _material;
    }

    public void especificarColorPrimario(TipoColorPrincipal _colorPrimario) {
        if(_colorPrimario == null) {
            throw new NullException(_colorPrimario + " no puede ser NULL");
        }
        this.colorPrimario = _colorPrimario;
    }

    public void especificarTrama(TipoTrama _trama) {
        if(_trama == null) {
            this.trama = new TipoTrama(TipoTrama.TTrama.LISA);
        } else {
            this.trama = _trama;
        }
    }

    public void especificarColorSecundario(String _colorSecundario) {
        this.colorSecundario = _colorSecundario;
    }

    public Prenda crearPrenda(
            TipoPrenda _prenda,
            TipoCategoria _categoria,
            TipoMaterial _material,
            TipoColorPrincipal _colorPrimario,
            TipoTrama _trama,
            String _colorSecundario
    ) {
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

        this.especificarTipo(_prenda);
        this.especificarColorPrimario(_colorPrimario);
        this.especificarColorSecundario(_colorSecundario);
        this.especificarMaterial(_material);
        this.especificarCategoria(_categoria);
        this.especificarTrama(_trama);

        return new Prenda(_prenda, _categoria, _material, _colorPrimario, _trama, _colorSecundario);
    }
}
