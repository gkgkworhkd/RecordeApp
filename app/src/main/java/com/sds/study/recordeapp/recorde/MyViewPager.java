package com.sds.study.recordeapp.recorde;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * Created by 고재광 on 2016-11-17.
 */

public class MyViewPager extends ViewPager{
    String TAG;
    public MyViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        TAG=getClass().getSimpleName();
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return false;
    }

}
