package com.example.kcs.airpollution_7_18;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.Date;

/**
 * Created by KCS on 2016-07-20.
 */
public class airDataService extends Service {
    int co2,co,no2,o3,so2,pm;
    Date time;

    @Override
    public void onCreate() {

        super.onCreate();
    }
    public airDataService(){

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}

