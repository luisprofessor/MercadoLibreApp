package com.example.mercadolibreapp.model;

import android.graphics.Bitmap;

public class Categoria {
    private String id;
    private String name;



    public Categoria() {
    }

    public Categoria(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
