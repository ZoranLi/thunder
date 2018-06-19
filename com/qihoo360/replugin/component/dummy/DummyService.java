package com.qihoo360.replugin.component.dummy;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class DummyService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        stopSelf();
    }
}
