package com.devsden.turismov01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Onboarding extends AppCompatActivity {

    private ViewPager mSlideviewPager;
    private LinearLayout mDotLayout;

    private slide_adapter slideradapter;

    private Button mNextbtn;
    private Button mBackbtn;
    private int currentPage;
    // los puntitos :v
    private TextView[] mDots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        View overlay = findViewById(R.id.slideviewpager);

        overlay.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_FULLSCREEN);

        SharedPreferences preferences =  getSharedPreferences("my_preferences",
                MODE_PRIVATE);

        // Check if onboarding_complete is false
        if(preferences.getBoolean("onboarding_complete",false)) {
            // Start Main Activity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

            // Close Onboarding
            finish();
            return;
        }


        mSlideviewPager = (ViewPager) findViewById(R.id.viewpager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotslayout);

        //para mostrar lass vistas del ViewPager desde la clase adaptador
        slideradapter = new slide_adapter(this);

        mSlideviewPager.setAdapter(slideradapter);

        mNextbtn =(Button)findViewById(R.id.next);
        mBackbtn =(Button)findViewById(R.id.prev);

        addDotsIndicator(0);

        mSlideviewPager.addOnPageChangeListener(viewListener);

        //los eventos de cambio de pagina onclicklistner
        mNextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mSlideviewPager.getCurrentItem()+1<slideradapter.getCount()){
                    mSlideviewPager.setCurrentItem(slideradapter.getCount()+1);

                }else{
                    finishOnboarding();
                }
            }
        });
        mBackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mSlideviewPager .setCurrentItem(currentPage-1);

            }
        });

    }

    private void finishOnboarding() {
        // Get the shared preferences
        SharedPreferences preferences =
                getSharedPreferences("my_preferences", MODE_PRIVATE);

        // Set onboarding_complete to true
        preferences.edit()
                .putBoolean("onboarding_complete",true).apply();

        // Launch the main Activity, called MainActivity
        Intent main = new Intent(this, MainActivity.class);
        startActivity(main);

        // Close the OnboardingActivity
        finish();
    }

    public void addDotsIndicator(int position) {

        mDots = new TextView[3];
        mDotLayout.removeAllViews();

        for (int i = 0; i < mDots.length; i++) {

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#8226;"));
            mDots[i].setTextSize(45);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);
        }

        if (mDots.length > 0) {
            mDots[position].setTextColor(getResources().getColor(R.color.colorwhite));
        }
    }


        ViewPager.OnPageChangeListener viewListener =new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }

            @Override
            public void onPageSelected(int i) {

            addDotsIndicator(i);

            currentPage = i;

            if(i==0){
                mNextbtn.setEnabled(true);
                mBackbtn.setEnabled(false);
                mBackbtn.setVisibility(View.INVISIBLE);

                mNextbtn.setText("");
                mBackbtn.setText("");

            }else if(i==mDots.length -1){
                mNextbtn.setEnabled(true);
                mBackbtn.setEnabled(true);
                mBackbtn.setVisibility(View.VISIBLE);

                mNextbtn.setText("Listo");
                mBackbtn.setText("");
            }else{

                mNextbtn.setEnabled(true);
                mBackbtn.setEnabled(true);
                mBackbtn.setVisibility(View.VISIBLE);

                mNextbtn.setText("");
                mBackbtn.setText("");
            }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        };
    }