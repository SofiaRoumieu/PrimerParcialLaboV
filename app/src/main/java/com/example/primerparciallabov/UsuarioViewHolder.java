package com.example.primerparciallabov;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UsuarioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private MyOnClickItem listener;
    private int position;
    TextView tvNombreUsuario;
    TextView tvTipoUsuario;
    ImageButton btnModificar;


    public UsuarioViewHolder(View item, MyOnClickItem listener) {
        super(item);
        this.tvTipoUsuario= item.findViewById(R.id.tvTipoUsuario);
        this.tvNombreUsuario = item.findViewById(R.id.tvNombreUsuario);
        this.btnModificar = item.findViewById(R.id.btnModificar);
        this.listener=listener;
        this.btnModificar.setOnClickListener(this);
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void onClick(View view) {
        listener.onClickItem(position);
    }
}
