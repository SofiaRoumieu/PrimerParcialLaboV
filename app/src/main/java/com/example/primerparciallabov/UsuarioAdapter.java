package com.example.primerparciallabov;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.primerparciallabov.FormularioUsuario.UsuarioModel;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioViewHolder> {
    List<UsuarioModel> usuarios;
    private MyOnClickItem listener;
    public UsuarioAdapter(List<UsuarioModel> usuarios,MyOnClickItem listener){
        this.usuarios=usuarios;
        this.listener=listener;
    }
    public List<UsuarioModel> getUsuarios() {
        return this.usuarios;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item,parent,false);
        return new UsuarioViewHolder(v,listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder  holder, int position) {
        UsuarioModel u= this.usuarios.get(position);

        holder.tvTipoUsuario.setText(u.getTipoUsuario());
        holder.tvNombreUsuario.setText(u.getNombre());
        holder.setPosition(position);
    }

    @Override
    public int getItemCount() {
        return this.usuarios.size();
    }
}
