package com.sds.study.recordeapp.recorde;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.Image;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.sds.study.recordeapp.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 고재광 on 2016-11-17.
 */

public class RecordeMainActivity extends AppCompatActivity{
static final int REACORD_PERMISSION=1;
    MediaRecorder mediaRecorder;
    String TAG;
    ImageView imageView;
    Intent intent;
    File path;
    boolean isStart=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.record_main);
        TAG=getClass().getSimpleName();
        imageView=(ImageView)findViewById(R.id.record);

    }

    public String getSaveDir(){
        path=new File(Environment.getExternalStorageDirectory(),"iotrecorde");
        Date d=new Date();
        String currentTime=new SimpleDateFormat("yyyy-MM-dd HHmmss").format(d);
        File filePath=new File(path,currentTime+".mp4");
        return filePath.getAbsolutePath();
    }

    public void init(){
        mediaRecorder=new MediaRecorder();
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

    }

    public void startRecorde(){
        if(isStart){
            try {
                //기본 setting
                init();
                mediaRecorder.setOutputFile(getSaveDir());
                Log.d(TAG,"경로저장");
                imageView.setImageResource(R.drawable.stop);

                mediaRecorder.prepare();
                Log.d(TAG,"준   비");
                mediaRecorder.start();
                Log.d(TAG,"시작");
                isStart=false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            imageView.setImageResource(R.drawable.play);
            mediaRecorder.stop();
            mediaRecorder.reset();
            mediaRecorder.release();
            mediaRecorder=null;


            Log.d(TAG,"mediaRecorder : "+mediaRecorder);
            isStart=true;
            intent=new Intent(this,FileListActivity.class);
            intent.putExtra("data",path.getAbsolutePath());
            startActivity(intent);
        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        Log.d(TAG,"1로넘어와야한다"+requestCode);
        Log.d(TAG,"GrantResult0번은? "+grantResults[0]+"  grantResult 1번째는?"+grantResults[1]);
        Log.d(TAG,"수락하명 0이 아니다"+permissions.length);


        switch (requestCode){
            case REACORD_PERMISSION:
                if(permissions.length!=0&&grantResults[0]==PackageManager.PERMISSION_DENIED){
                    Toast.makeText(this,"사용하시려면 접근권한필요",Toast.LENGTH_SHORT).show();
                }else if(permissions.length!=0&&grantResults[1]==PackageManager.PERMISSION_DENIED){
                    Toast.makeText(this,"사용하시려면 오디오권한필요",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void btnClick(View view){

        int writePermission= ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int recordeAudio=ContextCompat.checkSelfPermission(this,Manifest.permission.RECORD_AUDIO);
        if(PackageManager.PERMISSION_DENIED==writePermission||PackageManager.PERMISSION_DENIED==recordeAudio){
            //요청
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.RECORD_AUDIO
            },REACORD_PERMISSION);
        }else {
            startRecorde();
        }


    }
}
