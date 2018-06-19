package com.alibaba.mtl.appmonitor;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.alibaba.mtl.appmonitor.r.a;
import com.alibaba.mtl.log.e.i;

/* compiled from: AppMonitor */
final class f implements ServiceConnection {
    f() {
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (b.Service == AppMonitor.m) {
            AppMonitor.a = a.a(iBinder);
            if (!(AppMonitor.h == null || AppMonitor.c == null)) {
                AppMonitor.c.postAtFrontOfQueue(new g(this));
            }
        }
        synchronized (AppMonitor.f) {
            AppMonitor.f.notifyAll();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        i.a("AppMonitor", "[onServiceDisconnected]");
        synchronized (AppMonitor.f) {
            AppMonitor.f.notifyAll();
        }
        AppMonitor.h = true;
    }
}
