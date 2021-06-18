package com.example.rickmorty.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rickmorty.Models.Personajes;
import com.example.rickmorty.R;

import java.util.List;

public class AdapterPersonajes extends BaseAdapter {
    protected Activity activity;
    protected List<Personajes> listaPersonajes;

    public AdapterPersonajes(Activity activity, List<Personajes> listaPersonajes) {
        this.activity = activity;
        this.listaPersonajes = listaPersonajes;
    }

    @Override
    public int getCount() {
        return listaPersonajes.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPersonajes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (convertView == null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.personajes_item,null);
        }
        Personajes rick = listaPersonajes.get(position);

        TextView id = v.findViewById(R.id.txtidperson);
        id.setText  (String.valueOf(rick.getId()));

        TextView name = v.findViewById(R.id.txtnameperson);
        name.setText(rick.getName());

        TextView status = v.findViewById(R.id.txtstatusperson);
        status.setText(rick.getStatus());

        TextView specie = v.findViewById(R.id.txtspecieperson);
        specie.setText(rick.getSpecies());

        return v;
    }
}
