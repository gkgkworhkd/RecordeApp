package com.sds.study.recordeapp.page;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.sds.study.recordeapp.R;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myAdapter=new MyAdapter(getSupportFragmentManager());
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        viewPager.setAdapter(myAdapter);
    }
    public void btn(View view){
        if(view.getId()==R.id.bt_a){
            viewPager.setCurrentItem(0);
        }else if(view.getId()==R.id.bt_b){
            viewPager.setCurrentItem(1);
        }else if(view.getId()==R.id.bt_c){
            viewPager.setCurrentItem(2);
        }
    }
}
