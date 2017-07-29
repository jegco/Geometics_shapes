package com.example.j.rec_jorge_caro.Recycler_and_Card_views;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.j.rec_jorge_caro.Dibujo;
import com.example.j.rec_jorge_caro.R;

/**
 * Created by j on 03/05/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private String[] nombres;
    private String[] descripciones;
    private int[] imagenes;
    Context context;
    LayoutInflater layoutInflater;

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.nombres = inicializar_nombres();
        this.descripciones = inicializar_descripciones();
        this.imagenes = inicializar_imagenes();
    }

    public String[] inicializar_nombres(){
        String[] datos = {context.getResources().getString(R.string.card_view_circulo_nombre)
                ,context.getResources().getString(R.string.card_view_ovalo_nombre)
                ,context.getResources().getString(R.string.card_view_cuadrado_nombre)
                ,context.getResources().getString(R.string.card_view_rectangulo_nombre)
                ,context.getResources().getString(R.string.card_view_libre_nombre)};
        datos = context.getResources().getStringArray(R.array.figuras);
        return datos;
    }

    public int[] inicializar_imagenes(){
        int[] datos ={R.drawable.circle
                , R.drawable.oval
                , R.drawable.square
                , R.drawable.rectangle
                , R.drawable.star};
        return datos;
    }

    public String[] inicializar_descripciones(){
        String[] datos = {context.getResources().getString(R.string.card_view_circulo_descripcion)
                ,context.getResources().getString(R.string.card_view_ovalo_descripcion)
                ,context.getResources().getString(R.string.card_view_cuadrado_descripcion)
                ,context.getResources().getString(R.string.card_view_rectangulo_descripcion)
                ,context.getResources().getString(R.string.card_view_libre_descripcion)};
        return datos;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item, parent, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.getNombre().setText(nombres[position]);
        holder.getDescripcion().setText(descripciones[position]);
        holder.getImageView().setImageResource(imagenes[position]);

        holder.getImageView().setTag(holder);
        holder.getImageView().setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener= new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RecyclerViewHolder recyclerViewHolder = (RecyclerViewHolder) v.getTag();
            int pos = recyclerViewHolder.getAdapterPosition();
            final Intent intent = new Intent(context, Dibujo.class);
            intent.putExtra("id",pos);
            context.startActivity(intent);
            //si veo

        }
    };

    @Override
    public int getItemCount() {
        return nombres.length;
    }
}
