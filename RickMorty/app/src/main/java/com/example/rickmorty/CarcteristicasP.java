package com.example.rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rickmorty.Models.Personajes;
import com.squareup.picasso.Picasso;

public class CarcteristicasP extends AppCompatActivity {
    TextView idcaracteristicas;
    TextView namecaracteristicas;
    TextView statuscaracteristicas;
    TextView Speciecaracteristicas;
    TextView Typecaracteriscticas;
    TextView generocaracteristicas;
    TextView Urlcaracteristicas;
    ImageView imgfoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carcteristicas_p);
        idcaracteristicas = findViewById(R.id.txtidca);
        namecaracteristicas = findViewById(R.id.txtnameca);
        statuscaracteristicas = findViewById(R.id.txtstatusca);
        Speciecaracteristicas = findViewById(R.id.txtspecieca);
        Typecaracteriscticas = findViewById(R.id.txttypeca);
        generocaracteristicas = findViewById(R.id.txtgenderca);
        Urlcaracteristicas = findViewById(R.id.txturlca);
        imgfoto = findViewById(R.id.imgfoto);

        Personajes personaje = (Personajes) getIntent().getSerializableExtra("obect_personajes");

        Picasso.with(this).load(personaje.getImage())
                .error(R.drawable.epis).into(imgfoto);

        idcaracteristicas.setText(String.valueOf(personaje.getId()));
        namecaracteristicas.setText(personaje.getName());
        statuscaracteristicas.setText(personaje.getStatus());
        Speciecaracteristicas.setText(personaje.getSpecies());
        Typecaracteriscticas.setText(personaje.getType());
        generocaracteristicas.setText(personaje.getGender());
        Urlcaracteristicas.setText(personaje.getUrl());
    }
}