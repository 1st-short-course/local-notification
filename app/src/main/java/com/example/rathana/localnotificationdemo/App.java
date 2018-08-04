package com.example.rathana.localnotificationdemo;

import android.app.Application;

import com.example.rathana.localnotificationdemo.util.NotificationHelper;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        new NotificationHelper(this).createChannel(getString(R.string.channel_id_1),getString(R.string.channel_name_1));
    }
}
