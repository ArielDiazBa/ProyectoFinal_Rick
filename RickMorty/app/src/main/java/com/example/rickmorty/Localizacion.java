package com.example.rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rickmorty.Adapters.AdapterPersonajes;
import com.example.rickmorty.Adapters.AdapterUbicaciones;
import com.example.rickmorty.ApiManager.RetrofitClient;
import com.example.rickmorty.listamodels.ubicacion_response;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Localizacion extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listlocalizacion;
    ubicacion_response listasubicaciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localizacion);
        listlocalizacion = findViewById(R.id.listlocalizacion);
        getUbicaciones();
        listlocalizacion.setOnItemClickListener(this);
    }

    private void getUbicaciones(){
        Call<ubicacion_response> call = RetrofitClient.getInstance().getMyApi().getLocalizacion();
        call.enqueue(new Callback<ubicacion_response>() {
            @Override
            public void onResponse(Call<ubicacion_response> call, Response<ubicacion_response> response) {
                listasubicaciones = response.body();
                AdapterUbicaciones adapter = new AdapterUbicaciones(Localizacion.this,listasubicaciones.getMylistResultUbicaciones());
                listlocalizacion.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ubicacion_response> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent Inubicacion = new Intent(this, CaracteristicasU.class);
        Inubicacion.putExtra("obect_ubicaciones", listasubicaciones.getMylistResultUbicaciones().get(position));
        startActivity(Inubicacion);


    }
}