/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.profedev.blogapp.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author faguirre
 */
@Entity
@Table(name = "subsecciones")
public class Subseccion implements Serializable {

    @Id
    @Column(name = "idSub")
    private Integer idSub;
    @Column(name = "tituloSub")
    private String tituloSub;
    @Column(name = "textoSub")
    private String textoSub;

    public Subseccion() {
    }

    public Subseccion(Integer idSub, String tituloSub, String textoSub) {
        this.idSub = idSub;
        this.tituloSub = tituloSub;
        this.textoSub = textoSub;
    }

    public Subseccion(Integer idSub) {
        this.idSub = idSub;
    }

    public Integer getIdSub() {
        return idSub;
    }

    public void setIdSub(Integer idSub) {
        this.idSub = idSub;
    }

    public String getTituloSub() {
        return tituloSub;
    }

    public void setTituloSub(String tituloSub) {
        this.tituloSub = tituloSub;
    }

    public String getTextoSub() {
        return textoSub;
    }

    public void setTextoSub(String textoSub) {
        this.textoSub = textoSub;
    }
   
}
