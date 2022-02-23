package com.devsden.turismov01;

import android.graphics.drawable.Drawable;

public class Items {
    private String item_titulo,item_desc;
    private int item_image;

//
    public Items(String item_titulo, String item_desc, int item_image) {
        this.item_titulo = item_titulo;
        this.item_desc = item_desc;
        this.item_image = item_image;
    }

    public Items(int item_image, String item_titulo, String item_desc) {
        this.item_titulo = item_titulo;
        this.item_desc = item_desc;
        this.item_image = item_image;
    }

    public String getItem_titulo() {
        return item_titulo;
    }

    public void setItem_titulo(String item_titulo) {
        this.item_titulo = item_titulo;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }

    public int getItem_image() {
        return item_image;
    }

    public void setItem_image(int item_image) {
        this.item_image = item_image;
    }
}
