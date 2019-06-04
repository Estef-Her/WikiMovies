package com.example.wikimovies.Datos;

import java.util.ArrayList;
import java.util.List;

public class Modelo {
    List<Usuario> Usuarios = new ArrayList<>();
    Usuario logueado = new Usuario();

    public Modelo(){
        insertarDatosQuemados();
    }

    public List<Usuario> getUsuarios() {
        return Usuarios;
    }

    public void setUsuarios(List<Usuario> Usuarios) {
        this.Usuarios = Usuarios;
    }

    public void insertarDatosQuemados(){
        Usuarios=new ArrayList<>();
        logueado=new Usuario();
        Usuario Usuario1= new Usuario("Estefany","Hernández Arce","1","dh17376334@gmail.com",21,"F","user");
        Usuario1.getGenerosPelis().add(new PeliGeneros("dh17376334@gmail.com","comedia"));
        Usuario1.getGenerosPelis().add(new PeliGeneros("dh17376334@gmail.com","romance"));
        Usuario1.getGenerosPelis().add(new PeliGeneros("dh17376334@gmail.com","terror"));
        Usuario1.getGenerosPelis().add(new PeliGeneros("dh17376334@gmail.com","suspenso"));
        this.Usuarios.add(Usuario1);
        Usuario Usuario2= new Usuario("Roger","Amador","12345678","rogeramador@gmail.com",21,"M","admin");
        Usuario2.getGenerosPelis().add(new PeliGeneros("rogeramador@gmail.com","accion"));
        Usuario2.getGenerosPelis().add(new PeliGeneros("rogeramador@gmail.com","comedia"));
        Usuario2.getGenerosPelis().add(new PeliGeneros("rogeramador@gmail.com","romance"));
        this.Usuarios.add(Usuario2);
    }
    public void agregarUsuarioQuemado(Usuario Usuario1){
        this.Usuarios.add(Usuario1);
    }

    public boolean addGenerosQuemados(String email,String descripcion){
        boolean resultado =true;
        for (Usuario p: Usuarios){
            if(p.getEmail().equals(email)){
                p.getGenerosPelis().add(new PeliGeneros(email,descripcion));
                resultado=true;
            }else {
                resultado= false;
            }
        }
        return  resultado;
    }

    public Usuario loginQuemado(String email , String password){
        Usuario logueado= null;
        for (Usuario p: Usuarios){
            if(p.getEmail().equals(email)){
                if(p.getPassword().equals(password)){
                    logueado=p;
                }
            }
        }
        return logueado;
    }

    public Usuario actualizarDatos(String email, String nombre, String apellidos, int edad){
        Usuario per= null;
        for(Usuario p : Usuarios){
            if(p.getEmail().equals(email)){
                p.setNombre(nombre);
                p.setApellidos(apellidos);
                p.setEdad(edad);
                per=p;
            }
        }
        return per;
    }
    public Usuario cambiarCont(String email, String contA, String conN){
        Usuario per= null;
        for(Usuario p : Usuarios){
            if(p.getEmail().equals(email)){
                if(p.getPassword().equals(contA)){
                    p.setPassword(conN);
                    per=p;
                }
            }
        }
        return per;
    }
    public Usuario getLogueado() {
        return logueado;
    }

    public void setLogueado(Usuario logueado) {
        this.logueado = logueado;
    }
}
