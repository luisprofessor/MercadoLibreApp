package com.example.mercadolibreapp.vistas.categorias;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mercadolibreapp.R;
import com.example.mercadolibreapp.model.DetalleCategoria;

public class DetalleCategoriaActivity extends AppCompatActivity {
    private DetalleCategoriaViewModel vm;
    private TextView id,nombre, cantidad;
    private ImageView foto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_categoria);
        vm= ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(DetalleCategoriaViewModel.class);

        vm.getDetalleCategoria().observe(this, new Observer<DetalleCategoria>() {
            @Override
            public void onChanged(DetalleCategoria detalleCategoria) {
                id.setText(detalleCategoria.getId());
                nombre.setText(detalleCategoria.getName());

                foto.setImageBitmap(detalleCategoria.getBitmap());


                cantidad.setText(detalleCategoria.getTotal_items_in_this_category()+" ");

            }
        });
        vm.verDetalle(getIntent().getStringExtra("id"));
        inicializarVista();


    }

    public void inicializarVista(){
        id=findViewById(R.id.tvIdCategoria);
        nombre=findViewById(R.id.tvNombre);
        cantidad=findViewById(R.id.tvCantidad);
        foto=findViewById(R.id.ivPicture);
    }


}
