package com.example.rickmorty.listamodels;

import com.example.rickmorty.Models.Epizodiz;
import com.example.rickmorty.Models.Personajes;
import com.example.rickmorty.Models.Ubicaciones;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class episodios_response {
    @SerializedName("results")
    List<Epizodiz> MylistResultEpisodioz;

    public List<Epizodiz> getMylistResultEpisodioz() {
        return MylistResultEpisodioz;
    }

    public void setMylistResultEpisodio(List<Epizodiz> mylistResultEpisodioz) {
        MylistResultEpisodioz = getMylistResultEpisodioz();

    }
}