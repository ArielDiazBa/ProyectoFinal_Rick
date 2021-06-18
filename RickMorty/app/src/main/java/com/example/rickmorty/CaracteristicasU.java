package com.example.rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.rickmorty.Models.Personajes;
import com.example.rickmorty.Models.Ubicaciones;

public class CaracteristicasU extends AppCompatActivity {

    TextView idubicaciones;
    TextView nameubicaciones;
    TextView typeubicaciones;
    TextView dimensionubicacion;
    TextView urlubicacion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristicas_u);
        idubicaciones = findViewById(R.id.txtidUbicacion);
        nameubicaciones = findViewById(R.id.txtnameUbicacion);
        typeubicaciones = findViewById(R.id.txttypeUbicacion);
        dimensionubicacion = findViewById(R.id.txtdimensionUbicacion);
        urlubicacion = findViewById(R.id.txturlU);

        Ubicaciones ubicaciones = (Ubicaciones) getIntent().getSerializableExtra("obect_ubicaciones");

        idubicaciones.setText(String.valueOf(ubicaciones.getId()));
        nameubicaciones.setText(ubicaciones.getName());
        typeubicaciones.setText(ubicaciones.getType());
        dimensionubicacion.setText(ubicaciones.getDimension());
        urlubicacion.setText(ubicaciones.getUrl());
    }
}