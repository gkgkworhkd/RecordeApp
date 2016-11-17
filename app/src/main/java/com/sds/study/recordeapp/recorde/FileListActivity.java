package com.sds.study.recordeapp.recorde;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.sds.study.recordeapp.R;
import java.util.zip.Inflater;

/**
 * Created by 고재광 on 2016-11-17.
 */

public class FileListActivity extends AppCompatActivity {
    ViewPager viewPager;
    FragmentAdapter fragdapter;


    Inflater inflater;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);
        inflater=new Inflater();
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        init();
    }

    public void init() {
        fragdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fragdapter);
    }

}
