package com.example.wikimovies.Datos;

import java.util.ArrayList;
import java.util.List;

public class Persona {
    String nombre;
    String apellidos;
    String password;
    String email;
    int edad;
    int sexo;
    List<String> generos;

    public Persona(String nombre, String apellidos, String password, String email, int edad, int sexo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.password = password;
        this.email = email;
        this.edad = edad;
        this.sexo = sexo;
        this.generos=new ArrayList<>();
    }

    public Persona(){
        this.generos=new ArrayList<>();
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
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

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
}
