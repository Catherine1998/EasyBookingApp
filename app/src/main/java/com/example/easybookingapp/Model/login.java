package com.example.easybookingapp.Model;

public class login {
    private String usuario;
    private String clave;
    private String nombre;

    public login(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void getnombre(String nombre) {
        this.nombre = clave;
    }
}
