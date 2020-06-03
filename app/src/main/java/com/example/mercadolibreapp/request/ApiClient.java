package com.example.mercadolibreapp.request;

import android.util.Log;


import com.example.mercadolibreapp.model.Categoria;
import com.example.mercadolibreapp.model.DetalleCategoria;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class ApiClient {

    private static final String PATH="https://api.mercadolibre.com/";
    private static  MyApiInterface myApiInteface;

    public static MyApiInterface getMyApiClient(){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Log.d("mensaje",retrofit.baseUrl().toString());
        myApiInteface=retrofit.create(MyApiInterface.class);
        return myApiInteface;
    }





    public interface MyApiInterface {


        @GET("sites/{site}/categories")
        Call<List<Categoria>> obtenerCategorias(@Path("site") String sitio);

        //https://api.mercadolibre.com/categories/MLA5725
        @GET("categories/{categoria}")
        Call<DetalleCategoria> obtenerDetalleCategoria(@Path("categoria") String cat);
        //listarClientes.php
        //@GET("listarClientes.php")
        //Call<List<Cliente>> getClientes();

        //@GET("insertarClientes.php")
        //Call<Cliente> createCliente(@Query("dni") int dni, @Query("apellido") String apellido, @Query("nombre") String nombre);
    }

}
