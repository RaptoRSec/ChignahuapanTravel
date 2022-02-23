package com.devsden.turismov01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class HotelActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        recyclerView=findViewById(R.id.recycleview);
        ArrayList<Items> itemsList;

        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        RecyclerView.LayoutManager rvlayoutManager=layoutManager;
        recyclerView.setLayoutManager(rvlayoutManager);

        itemsList=new ArrayList<>();
        itemsList.add(new Items(R.drawable.hotel1,"Hotel Osalle Inn",""));
        itemsList.add(new Items(R.drawable.hotel2,"Hotel Los Portales Chignahuapan",""));
        itemsList.add(new Items(R.drawable.hotel3,"Hotel Colonial",""));
        itemsList.add(new Items(R.drawable.hotel4,"Hotel Márquez",""));
        itemsList.add(new Items(R.drawable.hotel5,"Hotel 9 Manantiales",""));
        itemsList.add(new Items(R.drawable.hotel6,"Baños Termales",""));

        AdaptadorHotel adapter =new AdaptadorHotel(this,itemsList);
        recyclerView.setAdapter(adapter);
    }
}