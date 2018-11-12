package com.zecollokaris.cryptocurrency;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class LoginAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public LoginAdapter(FragmentManager fm, int NumberOfTabs){
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            //Slide to Tab1
            case 0:
                Tab1 tab1 = new Tab1();
                return tab1;
            //Slide to tab2
            case 1:
                Tab2 tab2 = new Tab2();
                return tab2;

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}
