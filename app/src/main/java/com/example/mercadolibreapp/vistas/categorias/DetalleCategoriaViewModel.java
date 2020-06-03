package com.example.mercadolibreapp.vistas.categorias;

import android.app.Application;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mercadolibreapp.model.DetalleCategoria;
import com.example.mercadolibreapp.request.ApiClient;

import java.io.InputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetalleCategoriaViewModel extends AndroidViewModel {
    private MutableLiveData<DetalleCategoria> detalleCategoria;
    private Bitmap bitmap;




    public DetalleCategoriaViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<DetalleCategoria> getDetalleCategoria(){
        if(detalleCategoria==null){
            detalleCategoria=new MutableLiveData<>();
        }
        return detalleCategoria;
    }

    public void verDetalle(String categoria){


        Call<DetalleCategoria> datos= ApiClient.getMyApiClient().obtenerDetalleCategoria(categoria);
        datos.enqueue(new Callback<DetalleCategoria>() {
            @Override
            public void onResponse(Call<DetalleCategoria> call, Response<DetalleCategoria> response) {
                if(response.isSuccessful()){


                    String urlFoto=response.body().getPicture();

                    new DownloadImageTask(response).execute(urlFoto);


                }
            }

            @Override
            public void onFailure(Call<DetalleCategoria> call, Throwable t) {

            }
        });
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        Response<DetalleCategoria> response;

        public DownloadImageTask(Response<DetalleCategoria> response) {


            this.response=response;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {

            response.body().setBitmap(result);
            detalleCategoria.postValue(response.body());
        }
    }
}
