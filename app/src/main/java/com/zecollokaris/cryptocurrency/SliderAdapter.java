package com.zecollokaris.cryptocurrency;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context = context;
    }

//DETAILS TO BE SHOWN ON THE SLIDERS!!
    //IMAGE SLIDER
    public int [] slideimages = {

            R.drawable.cryptowelcome,
            R.drawable.cryptotrusting,
            R.drawable.cryptorise2
    };

    //HEADING SLIDER
    public String [] slideheading = {

            "Welcome",
            "Trusted",
            "Prices"
    };

    //TEXT SLIDER
    public String [] slidedesc ={

            "The technology likely to have a greatest impact over the next decade has just arrived. Welcome to a decentralized peer to peer system where trading of money has never been this efficient" +
                    ".",
            "CryptoByte is your trusted source for live cryptocurrency price charts and real-time cryptocurrency price and trades" +
                    ".",
            " Get in-depth pricing information on cryptocurrency exchanges and live cryptocurrency trades. Enjoy the latest information to buy Bitcoin, trade in digital currencies" +
                    ".",
    };

    @Override
    public int getCount() {
        return slideheading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == (RelativeLayout) o;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

        ImageView slideImageView = (ImageView) view.findViewById(R.id.slideimages);
        TextView slideHeading = (TextView) view.findViewById(R.id.slideheading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slidedesc);

        slideImageView.setImageResource(slideimages[position]);
        slideHeading.setText(slideheading[position]);
        slideDescription.setText(slidedesc[position]);

        container.addView(view);

        return view;

    }


    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout) object);

    }

}
