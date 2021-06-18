package com.example.rickmorty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.rickmorty.Adapters.AdapterPersonajes;
import com.example.rickmorty.ApiManager.RetrofitClient;
import com.example.rickmorty.Models.Personajes;
import com.example.rickmorty.listamodels.personajesresponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Personaje extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listapersonajess;
    personajesresponse Listpersonajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personaje);
        listapersonajess = findViewById(R.id.listpersonajes);
        getPersonajes();
        listapersonajess.setOnItemClickListener(this);
    }

    private void getPersonajes(){
   Call<personajesresponse> call = RetrofitClient.getInstance().getMyApi().getPersonajes();
   call.enqueue(new Callback<personajesresponse>() {
       @Override
       public void onResponse(Call<personajesresponse> call, Response<personajesresponse> response) {
         Listpersonajes = response.body();
           AdapterPersonajes adapter = new AdapterPersonajes(Personaje.this, Listpersonajes.getMylistResultPersonajes());
           listapersonajess.setAdapter(adapter);

       }

       @Override
       public void onFailure(Call<personajesresponse> call, Throwable t) {
           Toast.makeText(getApplicationContext(),"Ocurrio un error", Toast.LENGTH_SHORT).show();
       }
   });



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
      Intent inPersonaje = new Intent(this, CarcteristicasP.class);
        inPersonaje.putExtra("obect_personajes", Listpersonajes.getMylistResultPersonajes().get(position));
        startActivity(inPersonaje);

    }
}