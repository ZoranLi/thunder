package mtopsdk.xstate;

import android.app.Service;
import android.content.Intent;
import mtopsdk.xstate.a.b;

public class d extends Service {
    private b a = null;
    private Object b = new Object();

    public android.os.IBinder onBind(android.content.Intent r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r2 = r1.b;
        monitor-enter(r2);
        r0 = r1.a;	 Catch:{ all -> 0x0040 }
        if (r0 != 0) goto L_0x001d;	 Catch:{ all -> 0x0040 }
    L_0x0007:
        r0 = new mtopsdk.xstate.e;	 Catch:{ all -> 0x0040 }
        r0.<init>(r1);	 Catch:{ all -> 0x0040 }
        r1.a = r0;	 Catch:{ all -> 0x0040 }
        r0 = r1.a;	 Catch:{ RemoteException -> 0x001a, Throwable -> 0x0014 }
        r0.a();	 Catch:{ RemoteException -> 0x001a, Throwable -> 0x0014 }
        goto L_0x001d;
    L_0x0014:
        r0 = "[onBind]init() error";	 Catch:{ all -> 0x0040 }
    L_0x0016:
        mtopsdk.common.util.j.f(r0);	 Catch:{ all -> 0x0040 }
        goto L_0x001d;	 Catch:{ all -> 0x0040 }
    L_0x001a:
        r0 = "[onBind]init() exception";	 Catch:{ all -> 0x0040 }
        goto L_0x0016;	 Catch:{ all -> 0x0040 }
    L_0x001d:
        monitor-exit(r2);	 Catch:{ all -> 0x0040 }
        r2 = mtopsdk.common.util.TBSdkLog$LogEnable.InfoEnable;
        r2 = mtopsdk.common.util.j.a(r2);
        if (r2 == 0) goto L_0x003d;
    L_0x0026:
        r2 = new java.lang.StringBuilder;
        r0 = "[onBind] XStateService  stub= ";
        r2.<init>(r0);
        r0 = r1.a;
        r0 = r0.hashCode();
        r2.append(r0);
        r2 = r2.toString();
        mtopsdk.common.util.j.b(r2);
    L_0x003d:
        r2 = r1.a;
        return r2;
    L_0x0040:
        r0 = move-exception;
        monitor-exit(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.xstate.d.onBind(android.content.Intent):android.os.IBinder");
    }

    public void onDestroy() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        super.onDestroy();
        r0 = r2.b;
        monitor-enter(r0);
        r1 = r2.a;	 Catch:{ all -> 0x001b }
        if (r1 == 0) goto L_0x0019;
    L_0x000a:
        r1 = r2.a;	 Catch:{ RemoteException -> 0x0016, Throwable -> 0x0010 }
        r1.b();	 Catch:{ RemoteException -> 0x0016, Throwable -> 0x0010 }
        goto L_0x0019;
    L_0x0010:
        r1 = "[onDestroy]unInit() error";	 Catch:{ all -> 0x001b }
    L_0x0012:
        mtopsdk.common.util.j.f(r1);	 Catch:{ all -> 0x001b }
        goto L_0x0019;	 Catch:{ all -> 0x001b }
    L_0x0016:
        r1 = "[onDestroy]unInit() exception";	 Catch:{ all -> 0x001b }
        goto L_0x0012;	 Catch:{ all -> 0x001b }
    L_0x0019:
        monitor-exit(r0);	 Catch:{ all -> 0x001b }
        return;
    L_0x001b:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.xstate.d.onDestroy():void");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return 2;
    }
}
