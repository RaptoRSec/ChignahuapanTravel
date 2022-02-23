package com.devsden.turismov01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class VisitarActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitar);

        recyclerView=findViewById(R.id.recycleview);
        ArrayList<Items> itemsList;

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvlayoutManager=layoutManager;
        recyclerView.setLayoutManager(rvlayoutManager);

        itemsList=new ArrayList<>();
        itemsList.add(new Items(R.drawable.vis1,"Laguna Chignahuapan",""));
        itemsList.add(new Items(R.drawable.vis2,"Basílica Inmaculada Concepción",""));
        itemsList.add(new Items(R.drawable.vis3,"Kiosco estilo Mudéjar",""));
        itemsList.add(new Items(R.drawable.vis4,"Parroquia de Santiago Apóstol",""));
        itemsList.add(new Items(R.drawable.vis5,"Cascadas de Quetzalapan",""));

        AdaptadorVisitar adapter =new AdaptadorVisitar(this,itemsList);
        recyclerView.setAdapter(adapter);
    }
}