package com.filipkesteli.implicitniservis;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.widget.Toast;

/**
 * Created by Filip on 19.5.2016..
 */
public class SimpleService extends Service {

    //check flag (zastavica provjere) -> postavimo na true:
    private boolean serviceOn = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (!serviceOn) {
            //jesam li startan? (service):
            Toast.makeText(SimpleService.this, "Simple Service Started", Toast.LENGTH_SHORT).show();
            serviceOn = true;
        } else {
            Toast.makeText(SimpleService.this, "Simple Service already started", Toast.LENGTH_SHORT).show();
        }
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
