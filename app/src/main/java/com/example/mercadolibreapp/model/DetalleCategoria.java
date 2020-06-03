package com.example.mercadolibreapp.model;

import android.graphics.Bitmap;

public class DetalleCategoria {
    private String id;
    private String name;
    private String picture;
    private long total_items_in_this_category;
    private Bitmap bitmap;

    public DetalleCategoria() {
    }

    public DetalleCategoria(String id, String name, String picture, long total_items_in_this_category) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.total_items_in_this_category = total_items_in_this_category;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public long getTotal_items_in_this_category() {
        return total_items_in_this_category;
    }

    public void setTotal_items_in_this_category(long total_items_in_this_category) {
        this.total_items_in_this_category = total_items_in_this_category;
    }
    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}
