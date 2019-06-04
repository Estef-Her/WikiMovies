package com.example.wikimovies.Datos;

public class PeliGeneros {
    String usuario;
    String descripcion;

    public PeliGeneros() {
    }

    public PeliGeneros(String usuario, String descripcion) {
        this.usuario = usuario;
        this.descripcion = descripcion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
