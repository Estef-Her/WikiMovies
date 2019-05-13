/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.services;

import com.wikiMovies.Dao.Favorito_Dao;
import com.wikiMovies.domain.Favoritos;
import java.util.List;

/**
 *
 * @author Addiel
 */
public class Servicio_Favoritos implements Services_Interface<Favoritos,Integer> {
    Favorito_Dao fav = new Favorito_Dao();
    private static Servicio_Favoritos uniqueInstance;
    public static Servicio_Favoritos instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Servicio_Favoritos();
        }
        return uniqueInstance;
    }   

    @Override
    public void add(Favoritos o) {
        this.fav.add(o);
    }

    @Override
    public Favoritos merge(Favoritos o) {
        return this.fav.merge(o);
    }

    @Override
    public void delete(Favoritos o) {
        this.fav.delete(o);
    }

    @Override
    public Favoritos findById(Integer o) {
        return this.fav.findById(o);
    }

    @Override
    public List<Favoritos> findAll() {
        return this.fav.findAll();
    }
}
