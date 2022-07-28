package com.example.easybookingapp.Model;

import java.util.Calendar;
import java.util.Date;

public class Usuario {
    private String nombre;
    private String fechaNacimiento;
    private String usuario;
    private String clave;

    public Usuario(String nombre, String fechaNacimiento, String usuario, String clave) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() { return fechaNacimiento;}

    public void setFechaNacimiento(String fechaNacimiento) { this.fechaNacimiento = fechaNacimiento;}

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario= usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
