package com.sds.study.recordeapp.recorde;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by 고재광 on 2016-11-17.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    Fragment[] fragments = new Fragment[2];

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
        fragments[0]=new ListFragment();
        fragments[1]=new DetailFragment();
    }

    @Override
    public int getCount() {
        return fragments.length;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments[position];
    }
}
