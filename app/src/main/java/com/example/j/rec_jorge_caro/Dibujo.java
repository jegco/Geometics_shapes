package com.example.j.rec_jorge_caro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.j.rec_jorge_caro.Canvas.Lienzo;

public class Dibujo extends AppCompatActivity {

    private Lienzo lienzo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lienzo);
        int pos = getIntent().getIntExtra("id",4);
        lienzo = new Lienzo(this,pos);
        if(pos == 0) this.getSupportActionBar().setTitle(R.string.card_view_circulo_nombre);
        if(pos == 1) this.getSupportActionBar().setTitle(R.string.card_view_ovalo_nombre);
        if(pos == 2) this.getSupportActionBar().setTitle(R.string.card_view_cuadrado_nombre);
        if(pos == 3) this.getSupportActionBar().setTitle(R.string.card_view_rectangulo_nombre);
        if(pos == 4) this.getSupportActionBar().setTitle(R.string.card_view_libre_nombre);
        setContentView(lienzo);

    }
}
