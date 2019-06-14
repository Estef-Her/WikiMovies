package com.example.wikimovies.Datos;

public class Favorito {
    String pelicula;
    String usuario;
    int puntuacion;
    public Favorito() {
    }

    public Favorito(String pelicula, String usuario) {
        this.pelicula = pelicula;
        this.usuario = usuario;
    }

    public Favorito(String pelicula, String usuario, int puntuacion) {
        this.pelicula = pelicula;
        this.usuario = usuario;
        this.puntuacion = puntuacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
