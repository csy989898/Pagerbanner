package com.example.administrator.bannerapplication;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by zhengshaorui
 * time: 2018/9/16
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);
    }
}
