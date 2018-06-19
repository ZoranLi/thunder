package com.xiaomi.metoknlp.geofencing;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class a {
    private Context a;
    private c b;
    private boolean c = false;
    private int d = 0;
    private List<b> e = new ArrayList();
    private List<b> f = new ArrayList();
    private Handler g;
    private final ServiceConnection h = new b(this);

    public a(Context context) {
        this.a = context;
        this.c = false;
        a(context);
        HandlerThread handlerThread = new HandlerThread("GeoFencingServiceWrapper");
        handlerThread.start();
        this.g = new a(this, handlerThread.getLooper());
        if (!this.c) {
            this.g.sendEmptyMessageDelayed(1, 10000);
        }
    }

    private void a() {
        if (this.e != null) {
            this.e.size();
        }
        for (b bVar : this.e) {
            if (!(bVar == null || this.b == null)) {
                try {
                    this.b.a(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g);
                } catch (RemoteException e) {
                    new StringBuilder("registerPendingFence:").append(e);
                }
            }
        }
        if (this.e != null) {
            this.e.clear();
        }
    }

    private void b() {
        if (this.f != null) {
            this.f.size();
        }
        for (b bVar : this.f) {
            if (!(bVar == null || this.b == null)) {
                try {
                    this.b.a(bVar.e, bVar.f);
                } catch (RemoteException e) {
                    new StringBuilder("unregisterPendingFence:").append(e);
                }
            }
        }
        if (this.f != null) {
            this.f.clear();
        }
    }

    public void a(Context context) {
        if (!(this.c || context == null || this.b != null)) {
            Intent intent = new Intent("com.xiaomi.metoknlp.GeoFencingService");
            intent.setPackage("com.xiaomi.metoknlp");
            try {
                if (context.bindService(intent, this.h, 1)) {
                    this.c = true;
                } else {
                    this.c = false;
                }
            } catch (SecurityException e) {
                new StringBuilder("SecurityException:").append(e);
            }
        }
    }

    public void a(Context context, double d, double d2, float f, long j, String str, String str2, String str3) {
        a(context);
        if (this.b != null) {
            try {
                r13.b.a(d, d2, f, j, str, str2, str3);
                return;
            } catch (Throwable e) {
                throw new RuntimeException("GeoFencingService has died", e);
            }
        }
        r13.e.add(new b(r13, d, d2, f, j, str, str2, str3));
    }

    public void a(Context context, String str, String str2) {
        a(context);
        if (this.b != null) {
            try {
                this.b.a(str, str2);
                return;
            } catch (Throwable e) {
                throw new RuntimeException("GeoFencingService has died", e);
            }
        }
        this.f.add(new b(this, 0.0d, 0.0d, 0.0f, -1, str, str2, ""));
    }
}
