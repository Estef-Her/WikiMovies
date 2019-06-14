package com.example.wikimovies.Model;

import com.example.wikimovies.Datos.Favorito;
import com.example.wikimovies.Datos.Genero;
import com.example.wikimovies.Datos.Usuario;

import java.util.ArrayList;
import java.util.List;

public class DatosModel {
    public DatosModel() {
    }

    private List<Favorito> favoritos= new ArrayList<>();
    private List<Genero> generos = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();
    private Usuario u = new Usuario();


    private Favorito currentFavorito= new Favorito();
    private Genero currentGenero = new Genero();
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

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public Favorito getCurrentFavorito() {
        return currentFavorito;
    }

    public void setCurrentFavorito(Favorito currentFavorito) {
        this.currentFavorito = currentFavorito;
    }

    public Genero getCurrentGenero() {
        return currentGenero;
    }

    public void setCurrentGenero(Genero currentGenero) {
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




    public DatosModel(List<Favorito> fav, List<Genero> gen) {
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
