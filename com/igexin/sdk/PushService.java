package com.igexin.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.igexin.b.a.c.a;

public class PushService extends Service {
    private static String a = "PushService";

    private int a(Intent intent) {
        Class userPushService = GTServiceManager.getInstance().getUserPushService(this);
        if (intent != null) {
            intent.setClass(getApplicationContext(), userPushService);
        } else {
            intent = new Intent(getApplicationContext(), userPushService);
        }
        getApplicationContext().startService(intent);
        stopSelf();
        return 1;
    }

    public IBinder onBind(Intent intent) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("|onBind");
        a.b(stringBuilder.toString());
        return GTServiceManager.getInstance().onBind(intent);
    }

    public void onCreate() {
        super.onCreate();
        GTServiceManager.getInstance().onCreate(this);
    }

    public void onDestroy() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("|onDestroy");
        a.b(stringBuilder.toString());
        if (!GTServiceManager.getInstance().isUserPushServiceSet(this)) {
            GTServiceManager.getInstance().onDestroy();
        }
        super.onDestroy();
    }

    public void onLowMemory() {
        super.onLowMemory();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(a);
        stringBuilder.append("|onLowMemory");
        a.b(stringBuilder.toString());
        GTServiceManager.getInstance().onLowMemory();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        try {
            return GTServiceManager.getInstance().isUserPushServiceSet(this) ? a(intent) : GTServiceManager.getInstance().onStartCommand(this, intent, i, i2);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|");
            stringBuilder.append(th.toString());
            a.b(stringBuilder.toString());
            return 1;
        }
    }
}
