package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import com.xiaomi.channel.commonutils.logger.b;

class ag implements ServiceConnection {
    final /* synthetic */ ac a;

    ag(ac acVar) {
        this.a = acVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.a) {
            this.a.l = new Messenger(iBinder);
            this.a.s = false;
            for (Message send : this.a.r) {
                try {
                    this.a.l.send(send);
                } catch (Throwable e) {
                    b.a(e);
                }
            }
            this.a.r.clear();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.a.l = null;
        this.a.s = false;
    }
}
