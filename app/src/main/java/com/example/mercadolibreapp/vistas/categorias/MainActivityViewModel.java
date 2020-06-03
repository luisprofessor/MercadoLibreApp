package com.example.mercadolibreapp.vistas.categorias;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mercadolibreapp.model.Categoria;
import com.example.mercadolibreapp.request.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {
    private MutableLiveData<List<Categoria>> lista;

    public LiveData<List<Categoria>> getLista(){
        if(lista==null){
            lista=new MutableLiveData<>();
        }
        return lista;
    }

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
    }




    public void armarListView(){

        String argentina="MLA";
        Call<List<Categoria>> datos= ApiClient.getMyApiClient().obtenerCategorias(argentina);
        datos.enqueue(new Callback<List<Categoria>>() {
            @Override
            public void onResponse(Call<List<Categoria>> call, Response<List<Categoria>> response) {
                if(response.isSuccessful()) {
                    Log.d("nombre ", response.body().get(0).getName());
                    lista.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Categoria>> call, Throwable t) {
                Log.d("nombre","no pudo leer");

            }
        });


    }

    public void llamarDetalle(String categoria){

        Intent intent=new Intent(getApplication(),DetalleCategoriaActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("id",categoria);
        getApplication().startActivity(intent);

    }


}
