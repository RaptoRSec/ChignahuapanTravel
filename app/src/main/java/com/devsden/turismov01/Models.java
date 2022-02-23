package com.devsden.turismov01;

import android.graphics.drawable.Drawable;


public class Models {
    public Models(int image, String titulo, String desc) {
        this.image = image;
        this.titulo = titulo;
        this.desc = desc;
    }

    private int image;
    private String titulo;
    private String desc;

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

