/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.profedev.blogapp.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author faguirre
 */
@Entity
@Table(name = "articulos")
public class Articulo implements Serializable {

    @Id
    @Column(name = "idArt")
    private Integer idArt;
    @Column(name = "tituloArt")
    private String tituloArt;
    @Column(name = "textoArt")
    private String textoArt;

    public Articulo(Integer idArt, String tituloArt, String textoArt) {
        this.idArt = idArt;
        this.tituloArt = tituloArt;
        this.textoArt = textoArt;
    }
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "articulo")
    private List<Subseccion> subsecciones = new ArrayList<>();

    public Articulo() {
    }

    public Articulo(Integer idArt) {
        this.idArt = idArt;
    }

    public Integer getIdArt() {
        return idArt;
    }

    public void setIdArt(Integer idArt) {
        this.idArt = idArt;
    }

    public String getTituloArt() {
        return tituloArt;
    }

    public void setTituloArt(String tituloArt) {
        this.tituloArt = tituloArt;
    }

    public String getTextoArt() {
        return textoArt;
    }

    public void setTextoArt(String textoArt) {
        this.textoArt = textoArt;
    }

    @XmlTransient
    public List<Subseccion> getSubsecciones() {
        return subsecciones;
    }

    public void setSubsecciones(List<Subseccion> subsecciones) {
        this.subsecciones = subsecciones;
    }
    
    public void addSubseccion(Subseccion ns){
        this.subsecciones.add(ns);
    }
   
}
