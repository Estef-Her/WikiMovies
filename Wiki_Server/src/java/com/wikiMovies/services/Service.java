/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wikiMovies.services;

/**
 *
 * @author Addiel
 */
public class Service {
    private static Service uniqueInstance;
    public Servicio_Favoritos sf;
    public Servicio_Usuario su;
    public Servicio_Pelicula sp;
    public Servicio_WikiGeneros sw;
    public static Service instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Service();
        }
        return uniqueInstance;
    }   

    public Servicio_Favoritos getServicio_Favoritos() {
        return sf;
    }

    public Servicio_Usuario getServicio_Usuario() {
        return su;
    }

    public Servicio_Pelicula getServicio_Pelicula() {
        return sp;
    }

    public Servicio_WikiGeneros getServicio_WikiGeneros() {
        return sw;
    }
    
}
