package com.example.mercadolibreapp.vistas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mercadolibreapp.R;
import com.example.mercadolibreapp.model.Categoria;

import java.util.List;

public class CategoriaItemAdapter extends ArrayAdapter<Categoria> {
    private Context context;
    private List<Categoria> lista;
    private LayoutInflater li;
    public CategoriaItemAdapter(@NonNull Context context, int resource, @NonNull List<Categoria> objects, LayoutInflater li) {
        super(context, resource, objects);
        this.context = context;
        this.lista = objects;
        this.li = li;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if(itemView==null){
            itemView = li.inflate(R.layout.categoria_item, parent, false);
        }
        Categoria categoria = lista.get(position);
        TextView id = itemView.findViewById(R.id.tvID);
        id.setText(categoria.getId());

        TextView nombre = itemView.findViewById(R.id.tvNombre);
        nombre.setText(categoria.getName());

        return itemView;
    }
}
