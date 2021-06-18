package com.example.rickmorty.ApiManager;

import com.example.rickmorty.Models.Epizodiz;
import com.example.rickmorty.listamodels.episodios_response;
import com.example.rickmorty.listamodels.personajesresponse;
import com.example.rickmorty.listamodels.ubicacion_response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface Api {
    String BASE_URL = "https://rickandmortyapi.com/api/";

    @GET("character")
    Call<personajesresponse> getPersonajes();

    @GET("location")
    Call<ubicacion_response> getLocalizacion();

    @GET("episode")
   Call<episodios_response> getEpisodioz();

    @GET("episode/{id}")
    Call<Epizodiz> getEpisodio(@Path("id") int id);


}
