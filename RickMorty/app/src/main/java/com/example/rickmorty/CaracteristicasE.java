package com.example.rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rickmorty.ApiManager.RetrofitClient;
import com.example.rickmorty.Models.Epizodiz;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CaracteristicasE extends AppCompatActivity {
    TextView idgame;
    TextView namegame;
    TextView airdategame;
    TextView episodiogame;
    TextView urlgame;
    int IdEgame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caracteristicas_e);
        idgame = findViewById(R.id.txtidgame);
        namegame = findViewById(R.id.txtnamegame);
        airdategame = findViewById(R.id.txtairdategame);
        episodiogame = findViewById(R.id.txtepisodegame);
        urlgame = findViewById(R.id.txturlgame);

        Bundle in = getIntent().getExtras();
        IdEgame = in.getInt("id_episodio");
        getEpisodioById(IdEgame);

    }

    private void getEpisodioById(int idEgame) {
        Call<Epizodiz> call = RetrofitClient.getInstance().getMyApi().getEpisodio(idEgame);
        call.enqueue(new Callback<Epizodiz>() {
            @Override
            public void onResponse(Call<Epizodiz> call, Response<Epizodiz> response) {
                Epizodiz epizodiz = response.body();
                idgame.setText(String.valueOf(epizodiz.getId()));
                namegame.setText(epizodiz.getName());
                airdategame.setText(epizodiz.getAir_date());
                episodiogame.setText(epizodiz.getEpisode());
                urlgame.setText(epizodiz.getUrl());
            }

            @Override
            public void onFailure(Call<Epizodiz> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}