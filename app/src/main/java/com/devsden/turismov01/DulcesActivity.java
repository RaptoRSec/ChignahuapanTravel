package com.devsden.turismov01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DulcesActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dulces);

        recyclerView=findViewById(R.id.recycleview);
        ArrayList<Items> itemsList;

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvlayoutManager=layoutManager;
        recyclerView.setLayoutManager(rvlayoutManager);

        itemsList=new ArrayList<>();
        itemsList.add(new Items(R.drawable.ae,"Axolotl Extreme","Gotcha, Buggy, Bici, kayak"));
        itemsList.add(new Items(R.drawable.st,"Scooter Tours","Recorrido a los atractivos turísticos de la ciudad"));
        AdapterDulces adapter =new AdapterDulces(this,itemsList);
        recyclerView.setAdapter(adapter);
    }
}