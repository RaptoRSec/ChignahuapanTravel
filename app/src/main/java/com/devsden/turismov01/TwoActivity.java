package com.devsden.turismov01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class TwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        String url = "https://www.facebook.com/FeriaNacionalChignahuapan/";
        Intent iface = new Intent(Intent.ACTION_VIEW);
        iface.setData(Uri.parse(url));
        startActivity(iface);
    }
}