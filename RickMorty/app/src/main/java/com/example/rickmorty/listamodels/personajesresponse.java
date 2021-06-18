package com.example.rickmorty.listamodels;

import com.example.rickmorty.Models.Personajes;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class personajesresponse {
    @SerializedName("results")
    List<Personajes> MylistResultPersonajes;

    public List<Personajes> getMylistResultPersonajes() {
        return MylistResultPersonajes;
    }

    public void setMylistResultPersonajes(List<Personajes> mylistResultPersonajes) {
        MylistResultPersonajes = mylistResultPersonajes;
    }
}
