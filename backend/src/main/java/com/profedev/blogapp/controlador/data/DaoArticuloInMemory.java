package com.profedev.blogapp.controlador.data;

import com.profedev.blogapp.modelo.Articulo;
import com.profedev.blogapp.modelo.Subseccion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class DaoArticuloInMemory implements Dao<Articulo>{

    List<Articulo> lista = new ArrayList<>();

    @Override
    public Optional<Articulo> get(int id) {
        Articulo articulo = null;

        for(Articulo a:this.lista){
            if (a.getIdArt().equals(id)) {
                articulo = a;
            }
        }

        return Optional.ofNullable(articulo);
    }

    @Override
    public List<Articulo> getAll() {

        Articulo na = new Articulo();
        na.setIdArt(1);
        na.setTituloArt("Article heading");
        na.setTextoArt("Lorem ipsum dolor sit amet, consectetur adipisicing elit. "
                + "Donec a diam lectus. Set sit amet ipsum mauris. Maecenas congue ligula as quam viverra nec "
                + "consectetur ant hendrerit. Donec et mollis dolor. Praesent et diam eget libero egestas mattis "
                + "sit amet vitae augue. Nam tincidunt congue enim, ut porta lorem lacinia consectetur.");
        na.addSubseccion(new Subseccion(1,"Subsection","Donzxzec ut librero sed accu vehicula ultricies a non"
                + "tortor. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aenean ut gravida lorem. "
                + "Ut turpis felis, pulvinar a semper sed, adipiscing id dolor. Pelientesque auctor nisi id "
                + "magna consequat sagittis. "));
        na.addSubseccion(new Subseccion(2,"Another subsection","Donec viverra mi quis quam pulvinar at malesuada "
                + "arcu rhoncus. Cum soclis natoque penatibus et manis dis parturient montes, nascetur ridiculus mus. "
                + "In rutrum accumsan ultricies. Mauris vitae nisi at sem facilisis semper ac in est."));
        lista.add(na);

        return lista;
    }

    @Override
    public boolean save(Articulo articuloNuevo) {

        //Si existe el articulo, lo elimina para guardar el articulo modificado
        for(Articulo articuloAnterior:this.lista){
            if (articuloNuevo.getIdArt().equals(articuloAnterior.getIdArt())) {
                lista.remove(articuloAnterior);
            }
        }
        //Agrega el artículo modificado
        lista.add(articuloNuevo);
        return true;
    }

    @Override
    public void delete(Articulo articulo) {

    }
}
