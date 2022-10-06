package com.example.primerparciallabov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.primerparciallabov.FormularioUsuario.UsuarioController;
import com.example.primerparciallabov.FormularioUsuario.UsuarioModel;
import com.example.primerparciallabov.FormularioUsuario.UsuarioView;

public class UsuarioActivity extends AppCompatActivity {
    public static UsuarioModel usuarioRetorno;
    public static Boolean usuarioNuevo;
    UsuarioView view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);

        ActionBar actionBar = super.getSupportActionBar();

        UsuarioModel modelo = new UsuarioModel();
        UsuarioController controller = new UsuarioController(modelo);
        view = new UsuarioView(modelo, this, controller, actionBar);
        controller.setVista(view);

    }

    //fecha para atras del menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            UsuarioActivity.usuarioRetorno = null;
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}