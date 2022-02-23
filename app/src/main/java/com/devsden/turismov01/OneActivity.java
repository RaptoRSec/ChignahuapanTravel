package com.devsden.turismov01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;

public class OneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String url = "https://www.facebook.com/FestivalDeLaLuzyDeLaVida";
        Intent iface = new Intent(Intent.ACTION_VIEW);
        iface.setData(Uri.parse(url));
        startActivity(iface);

    }
}