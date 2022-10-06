package com.example.primerparciallabov.FormularioUsuario;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;

import com.example.primerparciallabov.MainActivity;
import com.example.primerparciallabov.R;

public class UsuarioView {
    UsuarioModel modelo;
    Activity a;
    ActionBar actionBar;
    EditText etNombre;
    EditText etContrasenia;
    EditText etRepitaContrasenia;
    Button btnGuardar;
    RadioButton tuAdministrador;
    RadioButton tuUsuario;
    Boolean usuarioNuevo;


    public UsuarioView(UsuarioModel modelo, Activity a, UsuarioController controller,ActionBar actionBar){
        this.a=a;
        this.modelo=modelo;
        etNombre= a.findViewById(R.id.etNombre);
        etContrasenia=a.findViewById(R.id.etContrasenia);
        etRepitaContrasenia=a.findViewById(R.id.etRepitaContrasenia);
        btnGuardar = a.findViewById(R.id.btnGuardar);
        tuAdministrador= a.findViewById(R.id.btnAdministrador);
        tuUsuario=a.findViewById(R.id.btnUsuario);
        btnGuardar.setOnClickListener(controller);

        actionBar.setDisplayHomeAsUpEnabled(true);

        //Obtengo los extras que recibo desde el main activity
        Bundle bundle = a.getIntent().getExtras();

        if (bundle!=null){
            usuarioNuevo=false;
            UsuarioModel usuario = (UsuarioModel) bundle.getSerializable("usuario");
            actionBar.setTitle(a.getString(R.string.menu_edicion));
            modelo.setNombre(usuario.getNombre());
            modelo.setContraseña(usuario.getContraseña());

            if(usuario.getTipoUsuario().equals("Administrador")){
                modelo.setTipoUsuario("Administrador");
            }else{modelo.setTipoUsuario("Usuario");}
        }
        else{
            usuarioNuevo=true;
            actionBar.setTitle(a.getString(R.string.menu_nuevo));
        }
    }

    public void setModelo(){
        modelo.setNombre(etNombre.getText().toString());
        modelo.setContraseña(etContrasenia.getText().toString());

        modelo.setContraseñaBis(etRepitaContrasenia.getText().toString());
        if(tuAdministrador.isChecked()) {
            modelo.setTipoUsuario("Administrador");
        }else if(tuUsuario.isChecked()){
            modelo.setTipoUsuario("Usuario");
        }
    }
    public void showModelo(){
        etNombre.setText(modelo.getNombre());
        etContrasenia.setText(modelo.getContraseña());

        if(modelo.getTipoUsuario()!=null){
            if(modelo.getTipoUsuario().equals("Administrador")){
                tuAdministrador.setChecked(true);
                tuUsuario.setChecked(false);
            }
            else{
                tuAdministrador.setChecked(false);
                tuUsuario.setChecked(true);
            }
        }
    }
    public void mostrarMensaje(String texto) {
        Toast.makeText(this.a, texto, Toast.LENGTH_LONG).show();
    }
}
