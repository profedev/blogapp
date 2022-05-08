/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.profedev.blogapp.controlador.data;

import com.profedev.blogapp.modelo.Articulo;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author faguirre
 */
public class DataBase {
    private static EntityManagerFactory emfactory; 
    private static EntityManager entitymanager;
    
    public static void connect(){
       emfactory = Persistence.createEntityManagerFactory( "localdatabase" );
       entitymanager = emfactory.createEntityManager();       
    }

    public static EntityManager conection(){
        return entitymanager;
    }

}
