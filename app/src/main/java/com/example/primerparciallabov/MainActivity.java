package com.example.primerparciallabov;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.primerparciallabov.FormularioUsuario.UsuarioModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyOnClickItem{
    List<UsuarioModel> usuarios =new ArrayList<>();
    UsuarioAdapter adapter;
    Intent i;
    private int itemSeleccionado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarios.add(new UsuarioModel("SRoumieu", super.getString(R.string.administrador), "1234"));
        usuarios.add(new UsuarioModel("LVatano", super.getString(R.string.administrador), "1234"));
        usuarios.add(new UsuarioModel("FRoumieu", super.getString(R.string.usuario), "1234"));
        usuarios.add(new UsuarioModel("STombolesi", super.getString(R.string.usuario), "1234"));
        usuarios.add(new UsuarioModel("VDuca", super.getString(R.string.usuario), "1234"));
        usuarios.add(new UsuarioModel("TCeglie", super.getString(R.string.usuario), "1234"));
        usuarios.add(new UsuarioModel("JVatano", super.getString(R.string.usuario), "1234"));
        usuarios.add(new UsuarioModel("JRoumieu", super.getString(R.string.usuario), "1234"));
        usuarios.add(new UsuarioModel("MCantero", super.getString(R.string.usuario), "1234"));
        usuarios.add(new UsuarioModel("ACasanova", super.getString(R.string.usuario), "1234"));

        adapter = new UsuarioAdapter(usuarios, this);
        RecyclerView rv = super.findViewById(R.id.rvUsuario);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    //sobreecribimos el metodo de la interfaz listener
    @Override
    public void onClickItem(int position) {
        i = new Intent(this,UsuarioActivity.class);
        i.putExtra("usuario", this.usuarios.get(position));

        startActivity(i);
        this.itemSeleccionado = position;
    }

    //sobreescribimos los metodos del menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.principal, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d("bandera", "entro al evento del menu");
        if(item.getItemId()==R.id.opNuevo){
            i = new Intent(this,UsuarioActivity.class);
            startActivity(i);

            //Group g= super.findViewById(R.id.group2);
            //g.setVisible(false);  no funciona
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {

        if (UsuarioActivity.usuarioRetorno != null) {
            Log.d("index", "");
            List<UsuarioModel> usuarios = adapter.getUsuarios();

            if(!UsuarioActivity.usuarioNuevo) {

                usuarios.set(itemSeleccionado, UsuarioActivity.usuarioRetorno);
                adapter.notifyItemChanged(itemSeleccionado);
            }
            else {
                usuarios.add( UsuarioActivity.usuarioRetorno);
                adapter.notifyDataSetChanged();
            }
        }

        Log.d("main","volio!!");
        super.onRestart();
    }
}