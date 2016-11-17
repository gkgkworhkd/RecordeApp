package com.sds.study.recordeapp.recorde;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Created by 고재광 on 2016-11-17.
 */

public class Myadapter extends BaseAdapter{
    Context context;

    public Myadapter(Context context) {
        this.context=context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
