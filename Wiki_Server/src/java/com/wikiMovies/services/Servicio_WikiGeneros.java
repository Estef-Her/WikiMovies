/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.services;

import com.wikiMovies.Dao.WikiGenero_Dao;
import com.wikiMovies.domain.WikiGeneros;
import java.util.List;

/**
 *
 * @author Addiel
 */
public class Servicio_WikiGeneros implements Services_Interface<WikiGeneros,Integer> {
    WikiGenero_Dao wiki = new WikiGenero_Dao();
    private static Servicio_WikiGeneros uniqueInstance;
    public static Servicio_WikiGeneros instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Servicio_WikiGeneros();
        }
        return uniqueInstance;
    }   

    @Override
    public void add(WikiGeneros o) {
        this.wiki.add(o);
    }

    @Override
    public WikiGeneros merge(WikiGeneros o) {
        return this.wiki.merge(o);
    }

    @Override
    public void delete(WikiGeneros o) {
        this.wiki.delete(o);
    }

    @Override
    public WikiGeneros findById(Integer o) {
        return this.wiki.findById(o);
    }

    @Override
    public List<WikiGeneros> findAll() {
        return this.wiki.findAll();
    }
    
       public List<WikiGeneros> findByEmail(String e) {
        return this.wiki.findByKey(e);
    }
}
