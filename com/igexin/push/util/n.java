package com.igexin.push.util;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.LinkedBlockingQueue;

final class n implements ServiceConnection {
    boolean a;
    private final LinkedBlockingQueue<IBinder> b;

    private n() {
        this.a = false;
        this.b = new LinkedBlockingQueue(1);
    }

    public final IBinder a() {
        if (this.a) {
            throw new IllegalStateException();
        }
        this.a = true;
        return (IBinder) this.b.take();
    }

    public final void onServiceConnected(android.content.ComponentName r1, android.os.IBinder r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r1 = r0.b;	 Catch:{ Exception -> 0x0005 }
        r1.put(r2);	 Catch:{ Exception -> 0x0005 }
    L_0x0005:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.n.onServiceConnected(android.content.ComponentName, android.os.IBinder):void");
    }

    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
