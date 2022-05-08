package com.profedev.blogapp.controlador.data;

import com.profedev.blogapp.modelo.Articulo;

import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.Optional;


public class DaoArticuloDb implements Dao<Articulo> {


    @Override
    public Optional<Articulo> get(int id) {
        return Optional.ofNullable(DataBase.conection().find(Articulo.class, id));
    }

    @Override
    public List<Articulo> getAll() {
        DataBase.connect();
        return DataBase.conection().createQuery("select a from Articulo a").getResultList();
    }

    @Override
    public boolean save(Articulo articulo) {
        EntityTransaction transaction =  DataBase.conection().getTransaction();
        transaction.begin();
        DataBase.conection().persist(articulo);
        transaction.commit();
        return true;
    }

    @Override
    public void delete(Articulo articulo) {

    }
}
