package com.qihoo360.mobilesafe.loader.s;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class DummyService extends Service {
    public IBinder onBind(Intent intent) {
        return null;
    }
}
