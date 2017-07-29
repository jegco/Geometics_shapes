package com.example.j.rec_jorge_caro.Recycler_and_Card_views;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.j.rec_jorge_caro.R;

/**
 * Created by j on 03/05/2017.
 */

public class RecyclerViewHolder extends RecyclerView.ViewHolder {

    private ImageView imageView;
    private TextView nombre, descripcion;

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        imageView = (ImageView) itemView.findViewById(R.id.imagen);
        nombre = (TextView) itemView.findViewById(R.id.nombre);
        descripcion = (TextView) itemView.findViewById(R.id.descripcion);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public TextView getNombre() {
        return nombre;
    }

    public TextView getDescripcion() {
        return descripcion;
    }
}
