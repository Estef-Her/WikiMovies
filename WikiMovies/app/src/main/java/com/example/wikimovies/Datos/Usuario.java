package com.example.wikimovies.Datos;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    String nombre;
    String apellidos;
    String password;
    String email;
    int edad;
    String sexo;
    String rol;
    List<PeliGeneros> generosPelis = new ArrayList<>();
    List<Favorito> pelisFavoritas = new ArrayList<>();
    public Usuario() {
    }

    public Usuario(String nombre, String apellidos, String password, String email, int edad, String sexo, String rol) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.email = email;
        this.edad = edad;
        this.sexo = sexo;
        this.rol = rol;
    }

    public Usuario(String nombre, String apellidos, String password, String email, int edad, String sexo, String rol, List<PeliGeneros> generosPelis, List<Favorito> pelisFavoritas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.email = email;
        this.edad = edad;
        this.sexo = sexo;
        this.rol = rol;
        this.generosPelis = generosPelis;
        this.pelisFavoritas = pelisFavoritas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public List<PeliGeneros> getGenerosPelis() {
        return generosPelis;
    }

    public void setGenerosPelis(List<PeliGeneros> generosPelis) {
        this.generosPelis = generosPelis;
    }

    public List<Favorito> getPelisFavoritas() {
        return pelisFavoritas;
    }

    public void setPelisFavoritas(List<Favorito> pelisFavoritas) {
        this.pelisFavoritas = pelisFavoritas;
    }
}
