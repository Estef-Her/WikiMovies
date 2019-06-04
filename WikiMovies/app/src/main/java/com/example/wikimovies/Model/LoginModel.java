package com.example.wikimovies.Model;

import com.example.wikimovies.Datos.Usuario;

public class LoginModel {
    private Usuario user = new Usuario();

    public LoginModel(Usuario user) {
        this.user = user;
    }
    public LoginModel() {
        this.user = new Usuario();
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
}

