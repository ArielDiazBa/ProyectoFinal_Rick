package com.example.rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rickmorty.Adapters.AdapterEpisodios;
import com.example.rickmorty.ApiManager.RetrofitClient;
import com.example.rickmorty.listamodels.episodios_response;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Episodios extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listarepisodios;
    episodios_response listtepisodios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episodios);
        listarepisodios = findViewById(R.id.listEpisodios);
        getEpisodios();
        listarepisodios.setOnItemClickListener(this);
    }

    private  void getEpisodios(){
        Call<episodios_response> call = RetrofitClient.getInstance().getMyApi().getEpisodioz();
        call.enqueue(new Callback<episodios_response>() {
            @Override
            public void onResponse(Call<episodios_response> call, Response<episodios_response> response) {
                listtepisodios = response.body();
                AdapterEpisodios adapterEpisodios = new AdapterEpisodios(Episodios.this,listtepisodios.getMylistResultEpisodioz());
                listarepisodios.setAdapter(adapterEpisodios);
            }

            @Override
            public void onFailure(Call<episodios_response> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio un error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent inEpisodio = new Intent(this, CaracteristicasE.class);
        inEpisodio.putExtra("id_episodio", listtepisodios.getMylistResultEpisodioz().get(position).getId());
        startActivity(inEpisodio);
    }
}