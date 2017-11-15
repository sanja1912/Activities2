package com.example.dev7.activities2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;

/**
 * Created by dev7 on 15.11.17..
 */

public class SimplePagerAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public SimplePagerAdapter(FragmentManager fm,int mNumOfTabs) {
        super(fm);
        this.mNumOfTabs=mNumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                FragmentMovies fMovies=new FragmentMovies();
                return fMovies;

            case 1:
                FragmentSongs fSongs=new FragmentSongs();
                return fSongs;

            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 2;
    }
}
