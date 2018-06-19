package com.xiaomi.metoknlp.devicediscover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.HandlerThread;
import com.igexin.sdk.PushConsts;
import com.xiaomi.metoknlp.b;

public class g {
    private static final long a = (b.b() ? StatisticConfig.MIN_UPLOAD_INTERVAL : 1800000);
    private static final Object e = new Object();
    private Context b;
    private ConnectivityManager c;
    private p d;
    private c f;
    private HandlerThread g;
    private o h;
    private BroadcastReceiver i = new l(this);

    static {
        b.a();
    }

    public g(Context context) {
        this.b = context;
    }

    private void a(boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 0;
        r1 = r4.b;	 Catch:{ Exception -> 0x0024 }
        if (r1 == 0) goto L_0x0024;	 Catch:{ Exception -> 0x0024 }
    L_0x0005:
        r1 = r4.b;	 Catch:{ Exception -> 0x0024 }
        r1 = r1.getPackageManager();	 Catch:{ Exception -> 0x0024 }
        r2 = "android.permission.ACCESS_NETWORK_STATE";	 Catch:{ Exception -> 0x0024 }
        r3 = r4.b;	 Catch:{ Exception -> 0x0024 }
        r3 = r3.getPackageName();	 Catch:{ Exception -> 0x0024 }
        r1 = r1.checkPermission(r2, r3);	 Catch:{ Exception -> 0x0024 }
        if (r1 != 0) goto L_0x0024;	 Catch:{ Exception -> 0x0024 }
    L_0x0019:
        r1 = r4.c;	 Catch:{ Exception -> 0x0024 }
        if (r1 == 0) goto L_0x0024;	 Catch:{ Exception -> 0x0024 }
    L_0x001d:
        r1 = r4.c;	 Catch:{ Exception -> 0x0024 }
        r1 = r1.getActiveNetworkInfo();	 Catch:{ Exception -> 0x0024 }
        r0 = r1;
    L_0x0024:
        r1 = r4.f;
        if (r1 != 0) goto L_0x0029;
    L_0x0028:
        return;
    L_0x0029:
        if (r0 == 0) goto L_0x0081;
    L_0x002b:
        r1 = r0.getType();
        r2 = 1;
        if (r1 != r2) goto L_0x0081;
    L_0x0032:
        r0 = r0.isConnected();
        if (r0 == 0) goto L_0x0081;
    L_0x0038:
        r0 = r4.b;
        r0 = com.xiaomi.metoknlp.devicediscover.j.a(r0, r2);
        r1 = r4.f;
        r1 = r1.b();
        if (r1 == 0) goto L_0x0052;
    L_0x0046:
        r1 = r4.f;
        r1 = r1.b();
        r1 = r1.equals(r0);
        if (r1 != 0) goto L_0x0057;
    L_0x0052:
        r1 = r4.f;
        r1.a(r0);
    L_0x0057:
        r0 = r4.h;
        r1 = 2;
        r0 = r0.hasMessages(r1);
        if (r0 == 0) goto L_0x0065;
    L_0x0060:
        r0 = r4.h;
        r0.removeMessages(r1);
    L_0x0065:
        r0 = r4.h;
        r0 = r0.obtainMessage(r1);
        r1 = a;
        r3 = java.lang.Boolean.valueOf(r5);
        r0.obj = r3;
        if (r5 == 0) goto L_0x007b;
    L_0x0075:
        r5 = r4.h;
        r5.sendMessage(r0);
        return;
    L_0x007b:
        r5 = r4.h;
        r5.sendMessageDelayed(r0, r1);
        return;
    L_0x0081:
        r5 = r4.f;
        r5.h();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.devicediscover.g.a(boolean):void");
    }

    private void b(boolean z) {
        if (!b.a().f()) {
            return;
        }
        if (z || (e() && g() && f())) {
            h();
            this.f.g();
            this.f.i();
        }
    }

    private boolean e() {
        long currentTimeMillis = System.currentTimeMillis();
        long c = this.f.c();
        long j = b.a().j();
        if (j == Long.MAX_VALUE) {
            j = a;
        }
        String b = this.f.b();
        return b != null && b.equals(j.a(this.b, 1)) && currentTimeMillis - c >= j;
    }

    private boolean f() {
        boolean z = true;
        if (b.a().h()) {
            long i = b.a().i();
            if (i == Long.MAX_VALUE) {
                i = 172800000;
            }
            this.f.f();
            if (this.f.d() > i) {
                return true;
            }
            z = false;
        }
        return z;
    }

    private boolean g() {
        long e = this.f.e();
        long g = b.a().g();
        if (g == Long.MAX_VALUE) {
            g = 172800000;
        }
        return System.currentTimeMillis() - e > g;
    }

    private void h() {
        this.d.a(this.f.b(), this.f.c(), this.f.d());
    }

    private int i() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.b;	 Catch:{ Exception -> 0x0009 }
        r0 = (com.xiaomi.metoknlp.a) r0;	 Catch:{ Exception -> 0x0009 }
        r0 = r0.b();	 Catch:{ Exception -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.devicediscover.g.i():int");
    }

    private void j() {
        this.b.registerReceiver(this.i, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
    }

    private void k() {
        if (this.h.hasMessages(1)) {
            this.h.removeMessages(1);
        }
        if (this.h.hasMessages(2)) {
            this.h.removeMessages(2);
        }
        this.b.unregisterReceiver(this.i);
    }

    public void a() {
        a(true);
    }

    public void a(p pVar) {
        synchronized (e) {
            this.d = pVar;
        }
    }

    public void b() {
        this.f = new c(this.b);
        this.c = (ConnectivityManager) this.b.getSystemService("connectivity");
        this.g = new HandlerThread("WifiCampStatics");
        this.g.start();
        this.h = new o(this, this.g.getLooper());
        if (i() == 0) {
            j();
        }
    }

    public void c() {
        if (i() == 0) {
            k();
        }
        this.c = null;
        this.f.a();
        if (this.g != null) {
            this.g.quitSafely();
            this.g = null;
        }
    }

    public void d() {
        synchronized (e) {
            this.d = null;
        }
    }
}
