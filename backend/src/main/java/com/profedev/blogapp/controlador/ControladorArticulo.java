/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.profedev.blogapp.controlador;

import com.profedev.blogapp.controlador.data.*;
import com.profedev.blogapp.modelo.*;
import java.util.List;

import org.springframework.web.bind.annotation.*;

/**
 *
 * @author faguirre
 */
@RestController
@RequestMapping("api")
public class ControladorArticulo {
    Dao daoArticulo = new DaoArticuloDb();

    @PostMapping("nuevoArticulo")
    public String nuevoArticulo(@RequestBody Articulo unArticulo){
        String msg = "Falló actualización";
        if (this.daoArticulo.save(unArticulo)) msg = "Actualización exitosa" ;
        return msg;
    }  
    
    //Método que devuelve una lista de artículos
    //@CrossOrigin(origins = "http://localhost:4200") //Habilita CORS desde esa URL
    @GetMapping("getArticulos")
    @ResponseBody
    public List<Articulo> getArticulos(){

        return daoArticulo.getAll();

    }
    
}
