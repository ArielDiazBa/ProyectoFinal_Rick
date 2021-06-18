package com.example.rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView personaje;
    private ImageView localizacion;
    private ImageView episodios;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        personaje = findViewById(R.id.imgpersonaje);
        localizacion = findViewById(R.id.imglocalizacion);
        episodios = findViewById(R.id.imgepisodios);
        personaje.setOnClickListener(this);
        localizacion.setOnClickListener(this);
        episodios.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.imgpersonaje){
            Intent personaje = new Intent(this,Personaje.class);
            startActivity(personaje);
        }
        if (v.getId() == R.id.imglocalizacion){
            Intent localizacion = new Intent(this,Localizacion.class);
            startActivity(localizacion);
        }
        if (v.getId() == R.id.imgepisodios){
            Intent episodios = new Intent(this,Episodios.class);
            startActivity(episodios);
        }

    }
}