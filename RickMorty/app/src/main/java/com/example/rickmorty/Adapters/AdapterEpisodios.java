package com.example.rickmorty.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rickmorty.Models.Epizodiz;
import com.example.rickmorty.R;

import java.util.List;

public class AdapterEpisodios extends BaseAdapter {
    protected Activity activity;
    protected List<Epizodiz> listaEspisodios;

    public AdapterEpisodios(Activity activity, List<Epizodiz> listaEspisodios) {
        this.activity = activity;
        this.listaEspisodios = listaEspisodios;
    }



    @Override
    public int getCount() {
        return listaEspisodios.size() ;
    }

    @Override
    public Object getItem(int position) {
        return listaEspisodios.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null){
            LayoutInflater inf =(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.episodios_item,null);
        }
        Epizodiz primer = listaEspisodios.get(position);

        TextView id = v.findViewById(R.id.txtidepis);
        id.setText  (String.valueOf(primer.getId()));

        TextView name = v.findViewById(R.id.txtnameepis);
        name.setText(primer.getName());

        TextView air_date = v.findViewById(R.id.txtairdateepis);
        air_date.setText(primer.getAir_date());

        TextView episode = v.findViewById(R.id.txtepisodeepis);
        episode.setText(primer.getEpisode());

        TextView url = v.findViewById(R.id.txturlepis);
        url.setText(primer.getUrl());

        return v;
    }
}
