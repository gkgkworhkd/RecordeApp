package com.sds.study.recordeapp.recorde;

import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sds.study.recordeapp.R;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by 고재광 on 2016-11-17.
 */

public class ListFragment extends Fragment implements AdapterView.OnItemClickListener{
    ArrayList<String> list = new ArrayList<String>();
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.frament_list,container,false);
        listView=(ListView)view.findViewById(R.id.listView);
        getFiles();
        return view;
    }
    public void getFiles(){

        File path = new File(Environment.getExternalStorageDirectory(),"iotrecorde");
        File[] files = path.listFiles();
        for (int i = 0; i < files.length; i++) {
            list.add(files[i].getName());
        }
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int index, long id) {
        TextView txt=(TextView) view;
        Toast.makeText(getContext(),"선택한 파일명은?"+txt.getText().toString(),Toast.LENGTH_SHORT).show();
        FileListActivity fileListActivity=(FileListActivity)getContext();
        fileListActivity.viewPager.setCurrentItem(2);
        //fileListActivity.viewPager.set
    }
}
