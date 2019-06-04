package com.example.wikimovies.Model;

import com.example.wikimovies.Datos.Favorito;
import com.example.wikimovies.Datos.PeliGeneros;
import com.example.wikimovies.Datos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DatosModel {
    public DatosModel() {
    }

    private List<Favorito> favoritos= new ArrayList<>();
    private List<PeliGeneros> generos = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private Usuario u = new Usuario();


    private Favorito currentFavorito= new Favorito();
    private PeliGeneros currentGenero = new PeliGeneros();
    private Usuario currentUser = new Usuario();
    public Usuario getU() {
        return u;
    }

    public void setU(Usuario u) {
        this.u = u;
    }

    public List<Favorito> getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(List<Favorito> favoritos) {
        this.favoritos = favoritos;
    }

    public List<PeliGeneros> getGeneros() {
        return generos;
    }

    public void setGeneros(List<PeliGeneros> generos) {
        this.generos = generos;
    }

    public Favorito getCurrentFavorito() {
        return currentFavorito;
    }

    public void setCurrentFavorito(Favorito currentFavorito) {
        this.currentFavorito = currentFavorito;
    }

    public PeliGeneros getCurrentGenero() {
        return currentGenero;
    }

    public void setCurrentGenero(PeliGeneros currentGenero) {
        this.currentGenero = currentGenero;
    }

    private String modo="Editar";

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    private boolean cargado=false;




    public DatosModel(List<Favorito> fav, List<PeliGeneros> gen) {
        this.favoritos = fav;
        this.generos = gen;
    }

    public boolean isCargado() {
        return cargado;
    }

    public void setCargado(boolean cargado) {
        this.cargado = cargado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Usuario currentUser) {
        this.currentUser = currentUser;
    }
}
