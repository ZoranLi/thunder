package com.igexin.push.d;

import com.igexin.push.config.m;
import com.igexin.push.core.b.g;
import com.igexin.push.f.b.e;
import com.igexin.push.util.a;

public class b {
    private int a;
    private int b;
    private boolean c;
    private int d;
    private long e;
    private int f;
    private long g;
    private d h;
    private i i;

    private b() {
        this.a = m.H;
        this.b = m.J;
        this.i = new f();
        this.h = a.d() ? d.WIFI : d.MOBILE;
    }

    public static b a() {
        return e.a;
    }

    private void a(int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = com.igexin.push.core.g.f;
        if (r0 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = new android.content.Intent;	 Catch:{ Throwable -> 0x0035 }
        r0.<init>();	 Catch:{ Throwable -> 0x0035 }
        r1 = "com.igexin.sdk.action.polling";	 Catch:{ Throwable -> 0x0035 }
        r0.setAction(r1);	 Catch:{ Throwable -> 0x0035 }
        r1 = new android.os.Bundle;	 Catch:{ Throwable -> 0x0035 }
        r1.<init>();	 Catch:{ Throwable -> 0x0035 }
        r2 = "code";	 Catch:{ Throwable -> 0x0035 }
        r1.putInt(r2, r4);	 Catch:{ Throwable -> 0x0035 }
        r0.putExtras(r1);	 Catch:{ Throwable -> 0x0035 }
        r4 = com.igexin.push.util.a.e();	 Catch:{ Throwable -> 0x0035 }
        if (r4 == 0) goto L_0x0030;	 Catch:{ Throwable -> 0x0035 }
    L_0x0022:
        r4 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x0035 }
        r4 = r4.getApplicationContext();	 Catch:{ Throwable -> 0x0035 }
        r4 = android.support.v4.content.LocalBroadcastManager.getInstance(r4);	 Catch:{ Throwable -> 0x0035 }
        r4.sendBroadcast(r0);	 Catch:{ Throwable -> 0x0035 }
        return;	 Catch:{ Throwable -> 0x0035 }
    L_0x0030:
        r4 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x0035 }
        r4.sendBroadcast(r0);	 Catch:{ Throwable -> 0x0035 }
    L_0x0035:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.b.a(int):void");
    }

    private void h() {
        com.igexin.b.a.c.a.b("ConnectModelCoordinator|reset current model = normal");
        if (!(this.i == null || (this.i instanceof f))) {
            this.i = new f();
        }
        e.g().i();
        this.f = 0;
        this.d = 0;
        this.c = false;
        g.a().b(this.c);
    }

    private void i() {
        a(0);
    }

    private void j() {
        a(1);
    }

    public void a(boolean z) {
        this.c = z;
        StringBuilder stringBuilder = new StringBuilder("ConnectModelCoordinator|init, current is polling model = ");
        stringBuilder.append(z);
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        if (z) {
            e.g().h();
        }
    }

    public synchronized void b() {
        d dVar = a.d() ? d.WIFI : d.MOBILE;
        if (dVar != this.h) {
            StringBuilder stringBuilder = new StringBuilder("ConnectModelCoordinator|net type changed ");
            stringBuilder.append(this.h);
            stringBuilder.append("->");
            stringBuilder.append(dVar);
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            h();
            this.h = dVar;
        }
    }

    public i c() {
        return this.i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void d() {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.c;	 Catch:{ all -> 0x0066 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r6);
        return;
    L_0x0007:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x0066 }
        r2 = r6.e;	 Catch:{ all -> 0x0066 }
        r4 = r0 - r2;
        r0 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0064;
    L_0x0015:
        r0 = 200000; // 0x30d40 float:2.8026E-40 double:9.8813E-319;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 >= 0) goto L_0x0064;
    L_0x001c:
        r0 = r6.d;	 Catch:{ all -> 0x0066 }
        r1 = 1;
        r0 = r0 + r1;
        r6.d = r0;	 Catch:{ all -> 0x0066 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0066 }
        r2 = "ConnectModelCoordinator|read len = -1, interval = ";
        r0.<init>(r2);	 Catch:{ all -> 0x0066 }
        r0.append(r4);	 Catch:{ all -> 0x0066 }
        r2 = ", disconnect =";
        r0.append(r2);	 Catch:{ all -> 0x0066 }
        r2 = r6.d;	 Catch:{ all -> 0x0066 }
        r0.append(r2);	 Catch:{ all -> 0x0066 }
        r0 = r0.toString();	 Catch:{ all -> 0x0066 }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ all -> 0x0066 }
        r0 = r6.d;	 Catch:{ all -> 0x0066 }
        r2 = r6.a;	 Catch:{ all -> 0x0066 }
        if (r0 < r2) goto L_0x0064;
    L_0x0043:
        r0 = "ConnectModelCoordinator|enter polling mode ####";
        com.igexin.b.a.c.a.b(r0);	 Catch:{ all -> 0x0066 }
        r6.i();	 Catch:{ all -> 0x0066 }
        r6.c = r1;	 Catch:{ all -> 0x0066 }
        r0 = new com.igexin.push.d.g;	 Catch:{ all -> 0x0066 }
        r0.<init>();	 Catch:{ all -> 0x0066 }
        r6.i = r0;	 Catch:{ all -> 0x0066 }
        r0 = com.igexin.push.f.b.e.g();	 Catch:{ all -> 0x0066 }
        r0.h();	 Catch:{ all -> 0x0066 }
        r0 = com.igexin.push.core.b.g.a();	 Catch:{ all -> 0x0066 }
        r1 = r6.c;	 Catch:{ all -> 0x0066 }
        r0.b(r1);	 Catch:{ all -> 0x0066 }
    L_0x0064:
        monitor-exit(r6);
        return;
    L_0x0066:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.d.b.d():void");
    }

    public synchronized void e() {
        if (this.c) {
            if (System.currentTimeMillis() - this.g >= 120000) {
                this.f++;
                StringBuilder stringBuilder = new StringBuilder("ConnectModelCoordinator|polling mode, cur hearbeat =");
                stringBuilder.append(this.f);
                com.igexin.b.a.c.a.b(stringBuilder.toString());
                if (this.f >= this.b) {
                    com.igexin.b.a.c.a.b("ConnectModelCoordinator|enter normal mode ####");
                    j();
                    com.igexin.push.core.g.E = 0;
                    h();
                }
            }
            this.g = System.currentTimeMillis();
        }
    }

    public void f() {
        this.e = System.currentTimeMillis();
        if (this.c) {
            this.i = new g();
            e.g().h();
            this.f = 0;
        }
    }

    public void g() {
        if (this.c && this.i != null && !(this.i instanceof f)) {
            this.i = new f();
        }
    }
}
