/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.Model;

import com.wikiMovies.domain.Usuario;
import com.wikiMovies.services.Servicio_Usuario;
import java.util.List;


/**
 *
 * @author Addiel
 */
public class Usuario_Model {
    private final Servicio_Usuario su;
    private static Usuario_Model uniqueInstance;
    public static Usuario_Model instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Usuario_Model();
        }
        return uniqueInstance;
    }    

    public Usuario_Model() {
        this.su = new Servicio_Usuario();
    }
   
    public void add(Usuario o) {
       this.su.add(o);
    }

   
    public Usuario merge(Usuario o) {
        return this.su.merge(o);
    }

  
    public void delete(Usuario o) {
        this.su.delete(o);
    }

  
    public Usuario findById(Integer o) {
        return this.su.findById(o);
    }

   
    public List<Usuario> findAll() {
        return this.su.findAll();
    }
    
     public Usuario findByEmail(String e) {
        return this.su.findByEmail(e);
    }
    
    public Usuario doLogin(Usuario o){
        return this.su.doLogin(o);
    }
}
