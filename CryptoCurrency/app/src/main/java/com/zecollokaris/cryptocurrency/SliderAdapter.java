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

            R.drawable.cryptologo1,
            R.drawable.cryptologo2,
            R.drawable.cryptologo4
    };

    //HEADING SLIDER
    public String [] slideheading = {

            "EAT",
            "SLEEP",
            "CODE"
    };

    //TEXT SLIDER
    public String [] slidedesc ={

            "First lorem to test out Code Lorem ipsumaslhflasfn lasfnlaskdbf lsa flasnfs fkasnadk asdkandasdna sdlaskd;adma; dalsdn klsadasd kakskda;sd lasdlaskd admlas dasd" +
                    "first",
            "Second lorem to test out Code Lorem ipsumaslhflasfn lasfnlaskdbf lsa flasnfs fkasnadk asdkandasdna sdlaskd;adma; dalsdn klsadasd kakskda;sd lasdlaskd admlas dasd" +
                    "second",
            "Third lorem to test out Code Lorem ipsumaslhflasfn lasfnlaskdbf lsa flasnfs fkasnadk asdkandasdna sdlaskd;adma; dalsdn klsadasd kakskda;sd lasdlaskd admlas dasd" +
                    "third",
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


   

}
