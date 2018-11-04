package com.zecollokaris.cryptocurrency;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

    //Arrays
    public int [] slideimages = {

            R.drawable.cryptologo1,
            R.drawable.cryptologo2,
            R.drawable.cryptologo4
    };

    public String [] slideheading = {

            "EAT",
            "SLEEP",
            "CODE"

    };

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return false;
    }
}
