/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.services;

import com.wikiMovies.Dao.Pelicula_Dao;
import com.wikiMovies.domain.Pelicula;
import java.util.List;

/**
 *
 * @author Addiel
 */
public class Servicio_Pelicula implements Services_Interface<Pelicula,Integer> {
    Pelicula_Dao peli = new Pelicula_Dao();
    private static Servicio_Pelicula uniqueInstance;
    public static Servicio_Pelicula instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Servicio_Pelicula();
        }
        return uniqueInstance;
    }   

    @Override
    public void add(Pelicula o) {
        this.peli.add(o);
    }

    @Override
    public Pelicula merge(Pelicula o) {
       return this.peli.merge(o);
    }

    @Override
    public void delete(Pelicula o) {
        this.peli.delete(o);
    }

    @Override
    public Pelicula findById(Integer o) {
        return this.peli.findById(o);
    }

    @Override
    public List<Pelicula> findAll() {
       return this.peli.findAll();
    }
}
