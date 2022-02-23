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

public class comidatres extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comidatres);

        //FAB
        FloatingActionButton item1, item2, item3, item4;
        item1=findViewById(R.id.gps);
        item2=findViewById(R.id.telefono);
        item3=findViewById(R.id.redsocial);
        item4=findViewById(R.id.insta);

        Bundle extras =getIntent().getExtras();
        if(extras != null){
            String claveitem=extras.getString("header");
        }


        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Café Parroquia");
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        final CollapsingToolbarLayout collapsingToolbarLayout =findViewById(R.id.collapsing);
        //fondo de color automatico por degradado de imagen y autoselector de color
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.parroquia);
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

        //FAB
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(android.content.Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.com/maps/place/Caf%C3%A9+Parroquia/@19.8382469,-98.0340779,17z/data=!3m1!4b1!4m5!3m4!1s0x85d06c6ce8cc01cb:0x894fcb9a564badad!8m2!3d19.8382419!4d-98.0318892"));
                startActivity(intent);
            }
        });

        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:7979714185"));
                startActivity(intent);
            }
        });

        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.facebook.com/CAFE-Parroquia-Chignahuapan-222270594627102";
                Intent iface = new Intent(Intent.ACTION_VIEW);
                iface.setData(Uri.parse(url));
                startActivity(iface);
            }
        });

        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.instagram.com/cafe_parroquia_chignahuapan/";
                Intent iface = new Intent(Intent.ACTION_VIEW);
                iface.setData(Uri.parse(url));
                startActivity(iface);
            }
        });
    }
}