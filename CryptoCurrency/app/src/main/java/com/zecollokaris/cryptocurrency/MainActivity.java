package com.zecollokaris.cryptocurrency;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotsLayout;
    private SliderAdapter sliderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //VIEWSLIDERS
        mSlideViewPager = (ViewPager) findViewById(R.id.SlideViewPager);
        mDotsLayout = (LinearLayout) findViewById(R.id.DotsLayout);

    }
}
