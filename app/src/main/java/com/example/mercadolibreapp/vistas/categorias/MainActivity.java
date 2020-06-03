package com.example.mercadolibreapp.vistas.categorias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.mercadolibreapp.R;
import com.example.mercadolibreapp.model.Categoria;
import com.example.mercadolibreapp.vistas.adapter.CategoriaItemAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private MainActivityViewModel vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        vm.getLista().observe(this, new Observer<List<Categoria>>() {
            @Override
            public void onChanged(final List<Categoria> categorias) {

                    ArrayAdapter<Categoria> adapter = new CategoriaItemAdapter(getApplicationContext(),R.layout.categoria_item, categorias, getLayoutInflater());
                    ListView lv = findViewById(R.id.lvCategorias);

                    lv.setAdapter(adapter);
                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            vm.llamarDetalle(categorias.get(position).getId());
                        }
                    });


                Log.d("codigo",categorias.get(0).getId());
            }
        });
        vm.armarListView();

    }
}
