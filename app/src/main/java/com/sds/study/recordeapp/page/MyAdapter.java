package com.sds.study.recordeapp.page;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by 고재광 on 2016-11-17.
 * viewpager 는 껍데에 불가 함으로
 * 어답터로 컨트롤해주어야함
 */

public class MyAdapter extends FragmentStatePagerAdapter{
    Fragment[] fragments=new Fragment[3];
    public MyAdapter(FragmentManager fm) {
        super(fm);
        fragments[0]=new FragmentA();
        fragments[1]=new FragmentB();
        fragments[2]=new FragmentC();
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
