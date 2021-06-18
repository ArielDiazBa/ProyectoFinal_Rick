package com.example.rickmorty.listamodels;

import com.example.rickmorty.Models.Personajes;
import com.example.rickmorty.Models.Ubicaciones;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ubicacion_response {
    @SerializedName("results")
    List<Ubicaciones> MylistResultUbicaciones;

    public List<Ubicaciones> getMylistResultUbicaciones() {
        return MylistResultUbicaciones;
    }

    public void setMylistResultUbicaciones(List<Ubicaciones> mylistResultUbicaciones) {
        MylistResultUbicaciones = mylistResultUbicaciones;
    }
}
