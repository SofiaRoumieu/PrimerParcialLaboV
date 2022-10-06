package com.example.primerparciallabov.FormularioUsuario;

import java.io.Serializable;

public class UsuarioModel implements Serializable {
    private String nombre;
    private String contraseña;
    private String tipoUsuario;

    private String contraseñaBis;

    public UsuarioModel(){}
    public UsuarioModel(String nombre, String tipoUsuario, String contraseña){
        this.nombre=nombre;
        this.tipoUsuario=tipoUsuario;
        this.contraseña=contraseña;
    }

    public String getNombre (){ return nombre; }
    public void setNombre (String nombre){ this.nombre = nombre;}

    public String getTipoUsuario (){ return tipoUsuario; }
    public void setTipoUsuario (String tipoUsuario){ this.tipoUsuario = tipoUsuario;}

    public String getContraseña (){ return contraseña; }
    public void setContraseña (String contraseña){ this.contraseña = contraseña;}

    public String getContraseñaBis (){ return contraseñaBis; }
    public void setContraseñaBis (String contraseñaBis){ this.contraseñaBis = contraseñaBis;}

    @Override
    public String toString(){
        return "Usuario{" +
                "nombre='" + nombre + "\'"+
                ", contraseña='" + contraseña+ "\'"+
                ", contraseñaBis='" + contraseñaBis+ "\'"+
                ", tipoUsuario='" + tipoUsuario + "\'"+
                "}";
    }
}
