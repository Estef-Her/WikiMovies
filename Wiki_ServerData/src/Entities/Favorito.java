package Entities;

public class Favorito  implements java.io.Serializable {


     private Usuario usuario;
     private Double puntuacion;
     private String pelicula;
    public Favorito() {
    }

    public Favorito(Usuario usuario, Double puntuacion, String pelicula) {
        this.usuario = usuario;
        this.puntuacion = puntuacion;
        this.pelicula = pelicula;
    }

    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }



}


