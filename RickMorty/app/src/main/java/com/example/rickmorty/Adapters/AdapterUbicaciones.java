package com.example.rickmorty.Adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rickmorty.Models.Ubicaciones;
import com.example.rickmorty.R;

import java.util.List;

public class AdapterUbicaciones extends BaseAdapter {
    protected Activity activity;
    protected List<Ubicaciones> listaUbicaciones;

    public AdapterUbicaciones(Activity activity, List<Ubicaciones> listaUbicaciones) {
        this.activity = activity;
        this.listaUbicaciones = listaUbicaciones;
    }

    @Override
    public int getCount() {
        return listaUbicaciones.size();
    }

    @Override
    public Object getItem(int position) {
        return listaUbicaciones.get(position);
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
            v = inf.inflate(R.layout.localizacion_item,null );
        }

        Ubicaciones tierra = listaUbicaciones.get(position);

        TextView id = v.findViewById(R.id.txtidUbi);
        id.setText  (String.valueOf(tierra.getId()));

        TextView name = v.findViewById(R.id.txtnameUbi);
        name.setText(tierra.getName());

        TextView type = v.findViewById(R.id.txttypeUbi);
        type.setText(tierra.getType());

        return v;
    }

}
