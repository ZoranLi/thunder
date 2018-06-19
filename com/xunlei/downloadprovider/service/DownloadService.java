package com.xunlei.downloadprovider.service;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build.VERSION;
import android.os.IBinder;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.task.k;
import com.xunlei.xllib.android.XLIntent;
import java.lang.reflect.Method;

public class DownloadService extends Service {
    private static final ServiceConnection a = new a();
    private static DownloadService b;
    private static c c;
    private static final Class<?>[] f = new Class[]{Boolean.TYPE};
    private static final Class<?>[] g = new Class[]{Integer.TYPE, Notification.class};
    private static final Class<?>[] h = new Class[]{Boolean.TYPE};
    private volatile k d;
    private a e = new a(this);
    private Method i;
    private Method j;
    private Method k;
    private Object[] l = new Object[1];
    private Object[] m = new Object[2];
    private Object[] n = new Object[1];
    private int o = 111;

    public interface c {
        void a(DownloadService downloadService);
    }

    public static DownloadService a() {
        return b;
    }

    public final k b() {
        if (this.d == null) {
            synchronized (DownloadService.class) {
                if (this.d == null) {
                    this.d = new k(this);
                }
            }
        }
        return this.d;
    }

    public static void a(c cVar) {
        Context applicationInstance = BrothersApplication.getApplicationInstance();
        if (applicationInstance != null) {
            c = cVar;
            try {
                cVar = new XLIntent();
                cVar.setClass(applicationInstance, DownloadService.class);
                applicationInstance.bindService(cVar, a, 1);
            } catch (c cVar2) {
                cVar2.printStackTrace();
            }
        }
    }

    public void onCreate() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        super.onCreate();
        r0 = r4.d;
        if (r0 != 0) goto L_0x000e;
    L_0x0007:
        r0 = new com.xunlei.downloadprovider.download.engine.task.k;
        r0.<init>(r4);
        r4.d = r0;
    L_0x000e:
        r0 = r4.d;
        r0.b();
        r0 = g();
        if (r0 == 0) goto L_0x007a;
    L_0x0019:
        r0 = r4.getClass();	 Catch:{ NoSuchMethodException -> 0x0036 }
        r1 = "startForeground";	 Catch:{ NoSuchMethodException -> 0x0036 }
        r2 = g;	 Catch:{ NoSuchMethodException -> 0x0036 }
        r0 = r0.getMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0036 }
        r4.j = r0;	 Catch:{ NoSuchMethodException -> 0x0036 }
        r0 = r4.getClass();	 Catch:{ NoSuchMethodException -> 0x0036 }
        r1 = "stopForeground";	 Catch:{ NoSuchMethodException -> 0x0036 }
        r2 = h;	 Catch:{ NoSuchMethodException -> 0x0036 }
        r0 = r0.getMethod(r1, r2);	 Catch:{ NoSuchMethodException -> 0x0036 }
        r4.k = r0;	 Catch:{ NoSuchMethodException -> 0x0036 }
        goto L_0x004c;
    L_0x0036:
        r0 = 0;
        r4.j = r0;
        r4.k = r0;
        r1 = r4.getClass();	 Catch:{ NoSuchMethodException -> 0x004a }
        r2 = "setForeground";	 Catch:{ NoSuchMethodException -> 0x004a }
        r3 = f;	 Catch:{ NoSuchMethodException -> 0x004a }
        r1 = r1.getMethod(r2, r3);	 Catch:{ NoSuchMethodException -> 0x004a }
        r4.i = r1;	 Catch:{ NoSuchMethodException -> 0x004a }
        goto L_0x004c;
    L_0x004a:
        r4.i = r0;
    L_0x004c:
        r0 = r4.o;
        r1 = new android.app.Notification;
        r1.<init>();
        r2 = r4.j;
        r3 = 0;
        if (r2 == 0) goto L_0x006d;
    L_0x0058:
        r2 = r4.m;
        r0 = java.lang.Integer.valueOf(r0);
        r2[r3] = r0;
        r0 = r4.m;
        r2 = 1;
        r0[r2] = r1;
        r0 = r4.j;
        r1 = r4.m;
        r4.a(r0, r1);
        return;
    L_0x006d:
        r0 = r4.l;
        r1 = java.lang.Boolean.TRUE;
        r0[r3] = r1;
        r0 = r4.i;
        r1 = r4.l;
        r4.a(r0, r1);
    L_0x007a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.service.DownloadService.onCreate():void");
    }

    private static boolean g() {
        return VERSION.SDK_INT < 18;
    }

    private boolean a(java.lang.reflect.Method r1, java.lang.Object[] r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r1.invoke(r0, r2);	 Catch:{ InvocationTargetException -> 0x0005, InvocationTargetException -> 0x0005 }
        r1 = 1;
        goto L_0x0006;
    L_0x0005:
        r1 = 0;
    L_0x0006:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.service.DownloadService.a(java.lang.reflect.Method, java.lang.Object[]):boolean");
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        return super.onStartCommand(intent, i, i2);
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.d != null) {
            this.d.c();
        }
        if (g()) {
            if (this.k != null) {
                this.n[0] = Boolean.TRUE;
                a(this.k, this.n);
                return;
            }
            this.l[0] = Boolean.FALSE;
            a(this.i, this.l);
        }
    }

    public IBinder onBind(Intent intent) {
        StringBuilder stringBuilder = new StringBuilder("onBind<Action: ");
        stringBuilder.append(intent.getAction());
        stringBuilder.append(">");
        return this.e;
    }

    public static void c() {
        if (!(b == null || b.b() == null)) {
            k b = b.b();
            b.c.cancelAllNotifications();
            b.a.b();
            b.b = false;
        }
        Intent xLIntent = new XLIntent();
        xLIntent.setClass(BrothersApplication.getApplicationInstance(), DownloadService.class);
        try {
            BrothersApplication.getApplicationInstance().unbindService(a);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        BrothersApplication.getApplicationInstance().stopService(xLIntent);
        b = null;
        xLIntent = new XLIntent();
        xLIntent.setClass(BrothersApplication.getApplicationInstance(), com.android.providers.downloads.DownloadService.class);
        BrothersApplication.getApplicationInstance().stopService(xLIntent);
    }
}
