package com.devsden.turismov01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class DashboardAventura extends AppCompatActivity {

    ViewPager viewPager;
    Adapter adapter;
    List<Models>models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator =new ArgbEvaluator();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_aventura);

        models=new ArrayList<>();
        models.add(new Models(R.drawable.fest1,"Festival de la Luz y la Vida","(1º al 3 de noviembre)"));
        models.add(new Models(R.drawable.fest3,"Feria Nacional del Árbol y la Esfera"," (Última semana de octubre y primera de noviembre)"));
        models.add(new Models(R.drawable.fest2,"Festival de la Barbacoa y el Pulque","(25 de julio)"));
        models.add(new Models(R.drawable.fest4,"Muestra Gastronómica del Tamal","(Primera semana de febrero)"));

        adapter=new Adapter(models,this);

        viewPager=findViewById(R.id.viewpager);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130,0,30,0);

        Integer[] Colors_Temp={
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
        };
        colors= Colors_Temp;
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if (position<(adapter.getCount()-1)&& position<colors.length-1){
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position +1]
                            )
                    );
                }
                else{
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}