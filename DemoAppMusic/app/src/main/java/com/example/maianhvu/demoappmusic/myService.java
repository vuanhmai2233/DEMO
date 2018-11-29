package com.example.maianhvu.demoappmusic;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class myService extends Service {
    private IBinder mIBinder = new serviceMusic();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mIBinder;
    }

    @Override
    public void onCreate() {
        Toast.makeText(this, "onCreate", Toast.LENGTH_SHORT).show();
        super.onCreate();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "onUnbind", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
    }

    public void music() {
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.buonkhongem);
        mediaPlayer.start();
    }

    public class serviceMusic extends Binder {
        public myService getBoundService() {
            return myService.this;
        }
    }
}
