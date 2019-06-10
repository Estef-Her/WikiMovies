/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

/**
 *
 * @author Addiel
 */
public class Data{
    private Service service;
    private ServicioBusquedas serviciobusquedas;
    private ServicioUsuario serviciousuario;
    private ServicioFavoritos serviciofavoritos;
    private ServicioWikiGeneros serviciowikigeneros;
    private static Data uniqueInstance;    
    public static Data instance(){
        if (uniqueInstance == null){
            uniqueInstance = new Data();
        }
        return uniqueInstance;
    }
    public Data() {
        service = new Service();
        serviciobusquedas = new ServicioBusquedas();
        serviciousuario = new ServicioUsuario();
        serviciofavoritos =  new ServicioFavoritos();
        serviciowikigeneros =  new ServicioWikiGeneros();       
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ServicioBusquedas getServiciobusquedas() {
        return serviciobusquedas;
    }

    public void setServiciobusquedas(ServicioBusquedas serviciobusquedas) {
        this.serviciobusquedas = serviciobusquedas;
    }

    public ServicioUsuario getServiciousuario() {
        return serviciousuario;
    }

    public void setServiciousuario(ServicioUsuario serviciousuario) {
        this.serviciousuario = serviciousuario;
    }

    public static Data getUniqueInstance() {
        return uniqueInstance;
    }

    public static void setUniqueInstance(Data uniqueInstance) {
        Data.uniqueInstance = uniqueInstance;
    }

    public ServicioFavoritos getServiciofavoritos() {
        return serviciofavoritos;
    }

    public void setServiciofavoritos(ServicioFavoritos serviciofavoritos) {
        this.serviciofavoritos = serviciofavoritos;
    }

    public ServicioWikiGeneros getServiciowikigeneros() {
        return serviciowikigeneros;
    }

    public void setServiciowikigeneros(ServicioWikiGeneros serviciowikigeneros) {
        this.serviciowikigeneros = serviciowikigeneros;
    }

  
    
    
}
