package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

class ah implements ServiceConnection {
    final /* synthetic */ ac a;

    ah(ac acVar) {
        this.a = acVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a) {
            Messenger messenger = new Messenger(iBinder);
            Message obtain = Message.obtain(null, 0);
            obtain.what = 18;
            obtain.replyTo = this.a.m;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a.m = null;
    }
}
