package com.devsden.turismov01;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.palette.graphics.Palette;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Objects;

public class hotelcinco extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotelcinco);

        //FAB
        FloatingActionButton item1,item2,item3,item4;
        item1=findViewById(R.id.gps);
        item2=findViewById(R.id.telefono);
        item3=findViewById(R.id.redsocial);
        item4=findViewById(R.id.insta);

        Bundle extras =getIntent().getExtras();
        if(extras != null){
            String claveitem=extras.getString("header");
        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Hotel 9 Manantiales");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        final CollapsingToolbarLayout collapsingToolbarLayout =findViewById(R.id.collapsing);
        //fondo de color automatico por degradado de imagen y autoselector de color
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.hotel5);
        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                if (palette!=null){
                    collapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(R.attr.colorPrimary));
                }
            }
        });

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setHomeButtonEnabled(false);
        }

        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/place/Hotel+9+Manantiales/@19.8414471,-98.025616,17z/data=!3m1!4b1!4m8!3m7!1s0x85d06c1524f11c29:0xff99d883819f0732!5m2!4m1!1i2!8m2!3d19.8414421!4d-98.0234273"));
                startActivity(intent);
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7979711892"));
                startActivity(intent);
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.facebook.com/Hotel9M/";
                Intent iface = new Intent(Intent.ACTION_VIEW);
                iface.setData(Uri.parse(url));
                startActivity(iface);
            }
        });

        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.instagram.com/hotel9manantiales/";
                Intent iface = new Intent(Intent.ACTION_VIEW);
                iface.setData(Uri.parse(url));
                startActivity(iface);
            }
        });
    }
}