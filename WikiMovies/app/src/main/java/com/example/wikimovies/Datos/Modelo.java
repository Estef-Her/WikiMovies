package com.example.wikimovies.Datos;

import java.util.ArrayList;
import java.util.List;

public class Modelo {
    List<Persona> personas = new ArrayList<>();
    Persona logueado = new Persona();

    public Modelo(){
        insertarDatosQuemados();
    }

    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    public void insertarDatosQuemados(){
        personas=new ArrayList<>();
        logueado=new Persona();
        Persona persona1= new Persona("Estefany","Hernández Arce","1","dh17376334@gmail.com",21,2);
        persona1.getGeneros().add("Terror");
        persona1.getGeneros().add("Comedia");
        persona1.getGeneros().add("Drama");
        persona1.getGeneros().add("Romance");
        this.personas.add(persona1);
        Persona persona2= new Persona("Roger","Amador","12345678","rogeramador@gmail.com",21,1);
        persona2.getGeneros().add("Terror");
        persona2.getGeneros().add("Comedia");
        persona2.getGeneros().add("Acción");
        this.personas.add(persona2);
    }
    public void agregarPersonaQuemado(Persona persona1){
        this.personas.add(persona1);
    }

    public boolean addGenerosQuemados(String email,String descripcion){
        boolean resultado =true;
        for (Persona p: personas){
            if(p.getEmail()==email){
                p.getGeneros().add(descripcion);
                resultado=true;
            }else {
                resultado= false;
            }
        }
          return  resultado;
    }

    public Persona loginQuemado(String email , String password){
        Persona logueado= null;
        for (Persona p: personas){
            if(p.getEmail().equals(email)){
                if(p.getPassword().equals(password)){
                    logueado=p;
                }
            }
        }
        return logueado;
    }

    public Persona getLogueado() {
        return logueado;
    }

    public void setLogueado(Persona logueado) {
        this.logueado = logueado;
    }
}

