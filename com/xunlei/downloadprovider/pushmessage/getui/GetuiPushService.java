package com.xunlei.downloadprovider.pushmessage.getui;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.igexin.sdk.GTServiceManager;

public class GetuiPushService extends Service {
    public void onCreate() {
        super.onCreate();
        GTServiceManager.getInstance().onCreate(this);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        return GTServiceManager.getInstance().onStartCommand(this, intent, i, i2);
    }

    public IBinder onBind(Intent intent) {
        return GTServiceManager.getInstance().onBind(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        GTServiceManager.getInstance().onDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        GTServiceManager.getInstance().onLowMemory();
    }
}
