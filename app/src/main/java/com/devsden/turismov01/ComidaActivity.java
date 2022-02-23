package com.devsden.turismov01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class ComidaActivity extends AppCompatActivity{

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comida);

        recyclerView=findViewById(R.id.recycleview);
        ArrayList<Items> itemsList;

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvlayoutManager=layoutManager;
        recyclerView.setLayoutManager(rvlayoutManager);

        itemsList=new ArrayList<>();
        itemsList.add(new Items(R.drawable.chiconahui,"Restaurante Chiconahui","Restaurante, Bar y Café."));
        itemsList.add(new Items(R.drawable.mhrestaurante,"Restaurante MH","Hotel y Restaurante."));
        itemsList.add(new Items(R.drawable.parroquia,"Café Parroquia","Restaurante tradicional."));
        itemsList.add(new Items(R.drawable.cafe,"Café del Centro","Bar y Café."));
        itemsList.add(new Items(R.drawable.rincon,"Rincón Mexicano","Restaurante, Bar y Café."));
        itemsList.add(new Items(R.drawable.emiliano,"Restaurante Emiliano", "Comida mexicana y café."));
        itemsList.add(new Items(R.drawable.veneno,"Restaurante El Veneno","Restaurante tradicional."));

        AdaptadorComida adapter =new AdaptadorComida(this,itemsList);
        recyclerView.setAdapter(adapter);
    }
}