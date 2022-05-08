package com.profedev.blogapp.controlador.data;

import java.util.List;
import java.util.Optional;

//Interface que deben implementar todos los objetos DAO
public interface Dao<T> {
    Optional<T> get(int id);
    List<T> getAll();
    boolean save(T t);
    void delete(T t);
}
