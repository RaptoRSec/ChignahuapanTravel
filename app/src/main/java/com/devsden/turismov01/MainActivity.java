package com.devsden.turismov01;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

     FloatingActionButton fabmain, face, insta,tiktok;
     float translationY =100f;
     boolean IsmenuAbierto = false;
     OvershootInterpolator interpolator =new OvershootInterpolator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initfabmenu();

        //comida actvity
        ImageView imageView=(ImageView)findViewById(R.id.imgcomida);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comidaact();
            }
        });
        //aventura activity
        ImageView imageView1=(ImageView)findViewById(R.id.imgaventura);
        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aventuraact();
            }
        });

        //visitarActivity
        ImageView imageView2=(ImageView) findViewById(R.id.imgvisitar);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visitaract();
            }
        });
        //hotel activity
        ImageView imageView3=(ImageView) findViewById(R.id.imghotel);
        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HotelActc();
            }
        });

        ImageView imageView4=(ImageView) findViewById(R.id.imgdulces);
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DulceAct();
            }
        });
    }

    public void comidaact(){
        Intent intent =new Intent(this,ComidaActivity.class);
        startActivity(intent);
    }

    public void aventuraact(){
        Intent intent =new Intent(this,DashboardAventura.class);
        startActivity(intent);
    }

    public void visitaract(){
        Intent intent=new Intent(this, VisitarActivity.class);
        startActivity(intent);
    }

    public void HotelActc(){
        Intent intent =new Intent(this,HotelActivity.class);
        startActivity(intent);
    }

    public void DulceAct(){
        Intent intent =new Intent(this,DulcesActivity.class);
        startActivity(intent);
    }
    //floating action button metodos
    public void initfabmenu(){
        fabmain=findViewById(R.id.main_fab);
        face=findViewById(R.id.face_fab);
        insta=findViewById(R.id.insta_fab);
        tiktok=findViewById(R.id.tiktok_fab);

        face.setAlpha(0f);
        insta.setAlpha(0f);
        tiktok.setAlpha(0f);

        face.setTranslationY(translationY);
        insta.setTranslationY(translationY);
        tiktok.setTranslationY(translationY);

        fabmain.setOnClickListener(this);
        face.setOnClickListener(this);
        insta.setOnClickListener(this);
        tiktok.setOnClickListener(this);
    }

    private void Openmenu(){
        IsmenuAbierto =! IsmenuAbierto;

        fabmain.animate().setInterpolator(interpolator).rotation(45f).setDuration(300).start();

        face.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        insta.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();
        tiktok.animate().translationY(0f).alpha(1f).setInterpolator(interpolator).setDuration(300).start();

    }
    private void Closemenu(){
        IsmenuAbierto =! IsmenuAbierto;

        fabmain.animate().setInterpolator(interpolator).rotation(0f).setDuration(300).start();

        face.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        insta.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
        tiktok.animate().translationY(translationY).alpha(0f).setInterpolator(interpolator).setDuration(300).start();
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.main_fab:
                if (IsmenuAbierto){
                    Closemenu();
                }else{
                    Openmenu();
                }
                break;
            case R.id.face_fab:
                String url = "http://www.facebook.com/Chignahuapan.travel/";
                Intent iface = new Intent(Intent.ACTION_VIEW);
                iface.setData(Uri.parse(url));
                startActivity(iface);
                break;
            case R.id.insta_fab :
                String url1 = "http://instagram.com/chignahuapan.travel";
                Intent iinsta = new Intent(Intent.ACTION_VIEW);
                iinsta.setData(Uri.parse(url1));
                startActivity(iinsta);
                break;
            case R.id.tiktok_fab:
                String url2 = "https://vm.tiktok.com/ZMJSB9ayQ/";
                Intent itiktok = new Intent(Intent.ACTION_VIEW);
                itiktok.setData(Uri.parse(url2));
                startActivity(itiktok);
                break;
        }
    }
}