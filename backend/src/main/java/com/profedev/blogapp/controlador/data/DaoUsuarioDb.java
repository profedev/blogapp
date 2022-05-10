package com.profedev.blogapp.controlador.data;

import com.profedev.blogapp.modelo.Articulo;
import com.profedev.blogapp.modelo.Usuario;
import sun.usagetracker.UsageTrackerClient;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class DaoUsuarioDb implements Dao<Usuario>{
    @Override
    public Optional<Usuario> get(int id) {
        return Optional.ofNullable(DataBase.conection().find(Usuario.class, id));
    }

    @Override
    public List<Usuario> getAll() {
        return null;
    }

    @Override
    public boolean save(Usuario usuario) {
        return false;
    }

    @Override
    public void delete(Usuario usuario) {

    }

    public Usuario getUserByNombreUsuario(String nombreUsuario){
        DataBase.connect();
        TypedQuery<Usuario> query = DataBase.conection().createQuery(
                "SELECT u FROM Usuario u WHERE u.nombreUsu = :nu" , Usuario.class);
        return query.setParameter("nu", nombreUsuario).getSingleResult();
    }
}
