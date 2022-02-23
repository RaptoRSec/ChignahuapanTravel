package com.devsden.turismov01;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import java.util.List;

public class Adapter extends PagerAdapter {

    private List<Models> models;
    private LayoutInflater layoutInflater;
    private Context context;

    public Adapter(List<Models> models, Context context) {
        this.models = models;
        this.context = context;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, final int position) {
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item, container,false);

        ImageView imageView;
        TextView titulo, descripcion;

        imageView=view.findViewById(R.id.image_adapter);
        titulo=view.findViewById(R.id.titulo);
        descripcion=view.findViewById(R.id.descripcion);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(context, OneActivity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(context, TwoActivity.class);
                        context.startActivity(intent1);
                        break;
                }
            }
        });

        imageView.setImageResource(models.get(position).getImage());
        titulo.setText(models.get(position).getTitulo());
        descripcion.setText(models.get(position).getDesc());
        container.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View)object);
    }
}
