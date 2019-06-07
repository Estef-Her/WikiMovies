/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.services;

import com.wikiMovies.Dao.Usuario_Dao;
import com.wikiMovies.domain.Usuario;
import java.util.List;

/**
 *
 * @author Addiel
 */
public class Servicio_Usuario implements Services_Interface<Usuario,Integer> {
    Usuario_Dao user = new Usuario_Dao();
    private static Servicio_Usuario uniqueInstance;
    public static Servicio_Usuario instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Servicio_Usuario();
        }
        return uniqueInstance;
    }    

    @Override
    public void add(Usuario o) {
       this.user.add(o);
    }

    @Override
    public Usuario merge(Usuario o) {
        return this.user.merge(o);
    }

    @Override
    public void delete(Usuario o) {
        this.user.delete(o);
    }

    @Override
    public Usuario findById(Integer o) {
        return this.user.findById(o);
    }

    @Override
    public List<Usuario> findAll() {
        return this.user.findAll();
    }
    
     public Usuario findByEmail(String e) {
        return this.user.findByEmail(e);
    }
    
    public Usuario doLogin(Usuario o){
        return this.user.findByData(o.getEmail(), o.getPassword());
    }
}
