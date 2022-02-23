package com.devsden.turismov01;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

public class slide_adapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;

    public slide_adapter(Context context){
        this.context = context;
    }

//arreglos para la vista de viewpager
    public int[]slide_images={
        R.mipmap.cutlery,
        R.mipmap.skull,
        R.mipmap.travel
    };

    public String[] slide_headings={
            "Disfruta",
            "Descubre",
            "Explora"
    };

    public String[] slide_desc={
            "Disfruta la gastronomía tradicional que tenemos para ofrecerte en compañía de tus seres queridos",
            "Vive una experiencia cultural con nuestros festivales llenos de misticismo y tradición",
            "Descubre nuevos lugares y sumérgete con su historia que te sorprenderá"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject( View view,  Object object) {
        return view == (RelativeLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem( ViewGroup container, int position) {

        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =layoutInflater.inflate(R.layout.slide_layout,container,false);

        ImageView slideImageview =(ImageView) view.findViewById(R.id.imageViewonboarding);
        TextView slideHeading =(TextView) view.findViewById(R.id.textonboarding);
        TextView slideDescrip =(TextView) view.findViewById(R.id.text2onboarding);

        slideImageview.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescrip.setText(slide_desc[position]);

        container.addView(view);
        return view;

    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((RelativeLayout)object);
    }
}
