package com.example.maianhvu.demoappmusic;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button mButtonPlay,mButtonStop;
    private myService mMyService;
    private boolean mIRunning=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    mButtonPlay = findViewById(R.id.btnPlay);
    mButtonStop = findViewById(R.id.btnStop);
    mButtonPlay.setOnClickListener(this);
    mButtonStop.setOnClickListener(this);


    Intent intent = new Intent(this,myService.class);
    bindService(intent,mServiceConnection,BIND_AUTO_CREATE);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btnPlay:
                mMyService.music();
                break;
            case R.id.btnStop:
                if (mIRunning){
                    unbindService(mServiceConnection);
                    mIRunning = false;
                }

                break;
        }
    }
    ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            myService.serviceMusic muSic = (myService.serviceMusic)service;
            mMyService  = muSic.getBoundService();
            mIRunning = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIRunning = false;
        }
    };
}
