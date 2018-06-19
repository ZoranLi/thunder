package com.xiaomi.smack;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.network.Fallback;
import com.xiaomi.network.Host;
import com.xiaomi.network.HostManager;
import com.xiaomi.push.service.XMPushService;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class h extends a {
    protected Exception p = null;
    protected Socket q;
    String r = null;
    protected XMPushService s;
    protected volatile long t = 0;
    protected volatile long u = 0;
    protected volatile long v = 0;
    private String w;
    private int x;

    public h(XMPushService xMPushService, b bVar) {
        super(xMPushService, bVar);
        this.s = xMPushService;
    }

    private void a(b bVar) {
        a(bVar.e(), bVar.d());
    }

    private void a(String str, int i) {
        StringBuilder stringBuilder;
        Exception exception;
        boolean z;
        Exception exception2;
        Exception exception3;
        Throwable th;
        boolean z2;
        Throwable th2;
        String str2 = str;
        int i2 = i;
        this.p = null;
        ArrayList arrayList = new ArrayList();
        StringBuilder stringBuilder2 = new StringBuilder("get bucket for host : ");
        stringBuilder2.append(str2);
        int intValue = b.e(stringBuilder2.toString()).intValue();
        Fallback b = b(str);
        b.a(Integer.valueOf(intValue));
        boolean z3 = true;
        if (b != null) {
            arrayList = b.a(true);
        }
        if (arrayList.isEmpty()) {
            arrayList.add(str2);
        }
        r1.v = 0;
        CharSequence k = d.k(r1.s);
        StringBuilder stringBuilder3 = new StringBuilder();
        Iterator it = arrayList.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            String str3 = (String) it.next();
            long currentTimeMillis = System.currentTimeMillis();
            r1.b++;
            try {
                stringBuilder = new StringBuilder("begin to connect to ");
                stringBuilder.append(str3);
                b.a(stringBuilder.toString());
                r1.q = u();
                r1.q.connect(Host.b(str3, i2), 8000);
                b.a("tcp connected");
                r1.q.setTcpNoDelay(true);
                r1.w = str3;
                c();
                try {
                    r1.c = System.currentTimeMillis() - currentTimeMillis;
                    r1.k = k;
                    if (b != null) {
                        b.b(str3, r1.c, 0);
                    }
                    r1.v = SystemClock.elapsedRealtime();
                    StringBuilder stringBuilder4 = new StringBuilder("connected to ");
                    stringBuilder4.append(str3);
                    stringBuilder4.append(" in ");
                    stringBuilder4.append(r1.c);
                    b.a(stringBuilder4.toString());
                } catch (Exception e) {
                    exception = e;
                    z = true;
                } catch (Exception e2) {
                    exception = e2;
                    z = true;
                    if (b == null) {
                        exception2 = exception;
                        b.b(str3, System.currentTimeMillis() - currentTimeMillis, 0, exception);
                        exception3 = exception2;
                    } else {
                        exception3 = exception;
                    }
                    r1.p = exception3;
                    stringBuilder = new StringBuilder("SMACK: Could not connect to:");
                    stringBuilder.append(str3);
                    b.d(stringBuilder.toString());
                    stringBuilder3.append("SMACK: Could not connect to ");
                    stringBuilder3.append(str3);
                    stringBuilder3.append(" port:");
                    stringBuilder3.append(i2);
                    stringBuilder3.append(" ");
                    stringBuilder3.append(exception3.getMessage());
                    stringBuilder3.append("\n");
                    if (!z) {
                        com.xiaomi.stats.h.a(str3, r1.p);
                        if (!TextUtils.equals(k, d.k(r1.s))) {
                            HostManager.getInstance().persist();
                            if (z) {
                                throw new l(stringBuilder3.toString());
                            }
                            return;
                        }
                    }
                    z4 = z;
                } catch (Throwable th3) {
                    th2 = th3;
                }
            } catch (Exception e22) {
                exception = e22;
                z = z4;
                if (b != null) {
                    try {
                        Exception exception4 = exception;
                        b.b(str3, System.currentTimeMillis() - currentTimeMillis, 0, exception);
                        exception3 = exception4;
                    } catch (Throwable th32) {
                        th2 = th32;
                        z3 = z;
                    }
                } else {
                    exception3 = exception;
                }
                r1.p = exception3;
                stringBuilder = new StringBuilder("SMACK: Could not connect to:");
                stringBuilder.append(str3);
                b.d(stringBuilder.toString());
                stringBuilder3.append("SMACK: Could not connect to ");
                stringBuilder3.append(str3);
                stringBuilder3.append(" port:");
                stringBuilder3.append(i2);
                stringBuilder3.append(" ");
                stringBuilder3.append(exception3.getMessage());
                stringBuilder3.append("\n");
                if (!z) {
                    com.xiaomi.stats.h.a(str3, r1.p);
                    if (!TextUtils.equals(k, d.k(r1.s))) {
                        HostManager.getInstance().persist();
                        if (z) {
                            throw new l(stringBuilder3.toString());
                        }
                        return;
                    }
                }
                z4 = z;
            } catch (Exception e222) {
                exception = e222;
                z = z4;
                if (b == null) {
                    exception3 = exception;
                } else {
                    exception2 = exception;
                    b.b(str3, System.currentTimeMillis() - currentTimeMillis, 0, exception);
                    exception3 = exception2;
                }
                r1.p = exception3;
                stringBuilder = new StringBuilder("SMACK: Could not connect to:");
                stringBuilder.append(str3);
                b.d(stringBuilder.toString());
                stringBuilder3.append("SMACK: Could not connect to ");
                stringBuilder3.append(str3);
                stringBuilder3.append(" port:");
                stringBuilder3.append(i2);
                stringBuilder3.append(" ");
                stringBuilder3.append(exception3.getMessage());
                stringBuilder3.append("\n");
                if (z) {
                    com.xiaomi.stats.h.a(str3, r1.p);
                    if (TextUtils.equals(k, d.k(r1.s))) {
                        HostManager.getInstance().persist();
                        if (z) {
                            throw new l(stringBuilder3.toString());
                        }
                        return;
                    }
                }
                z4 = z;
            } catch (Throwable th322) {
                th2 = th322;
                z3 = z4;
            }
            z = z3;
        }
        z = z4;
        HostManager.getInstance().persist();
        if (z) {
            throw new l(stringBuilder3.toString());
        }
        return;
        if (!z3) {
            com.xiaomi.stats.h.a(str3, r1.p);
            if (TextUtils.equals(k, d.k(r1.s))) {
            }
            z = z3;
            HostManager.getInstance().persist();
            if (z) {
                throw new l(stringBuilder3.toString());
            }
            return;
        }
        throw th2;
    }

    public synchronized void a(int r3, java.lang.Exception r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.n();	 Catch:{ all -> 0x001e }
        r1 = 2;
        if (r0 != r1) goto L_0x000a;
    L_0x0008:
        monitor-exit(r2);
        return;
    L_0x000a:
        r2.a(r1, r3, r4);	 Catch:{ all -> 0x001e }
        r3 = "";	 Catch:{ all -> 0x001e }
        r2.j = r3;	 Catch:{ all -> 0x001e }
        r3 = r2.q;	 Catch:{ Throwable -> 0x0016 }
        r3.close();	 Catch:{ Throwable -> 0x0016 }
    L_0x0016:
        r3 = 0;
        r2.t = r3;	 Catch:{ all -> 0x001e }
        r2.u = r3;	 Catch:{ all -> 0x001e }
        monitor-exit(r2);
        return;
    L_0x001e:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.h.a(int, java.lang.Exception):void");
    }

    protected void a(Exception exception) {
        if (SystemClock.elapsedRealtime() - this.v < 300000) {
            if (d.c(this.s)) {
                this.x++;
                if (this.x >= 2) {
                    String e = e();
                    StringBuilder stringBuilder = new StringBuilder("max short conn time reached, sink down current host:");
                    stringBuilder.append(e);
                    b.a(stringBuilder.toString());
                    a(e, 0, exception);
                } else {
                    return;
                }
            }
            return;
        }
        this.x = 0;
    }

    protected void a(String str, long j, Exception exception) {
        Fallback fallbacksByHost = HostManager.getInstance().getFallbacksByHost(b.b(), false);
        if (fallbacksByHost != null) {
            fallbacksByHost.b(str, j, 0, exception);
            HostManager.getInstance().persist();
        }
    }

    public abstract void a(boolean z);

    public void a(com.xiaomi.slim.b[] bVarArr) {
        throw new l("Don't support send Blob");
    }

    com.xiaomi.network.Fallback b(java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = com.xiaomi.network.HostManager.getInstance();
        r1 = 0;
        r0 = r0.getFallbacksByHost(r5, r1);
        r2 = r0.b();
        if (r2 != 0) goto L_0x0017;
    L_0x000f:
        r2 = new com.xiaomi.smack.k;
        r2.<init>(r4, r5);
        com.xiaomi.smack.util.e.a(r2);
    L_0x0017:
        r4.f = r1;
        r5 = r0.f;	 Catch:{ UnknownHostException -> 0x0051 }
        r5 = java.net.InetAddress.getByName(r5);	 Catch:{ UnknownHostException -> 0x0051 }
        r5 = r5.getAddress();	 Catch:{ UnknownHostException -> 0x0051 }
        r1 = r5[r1];	 Catch:{ UnknownHostException -> 0x0051 }
        r1 = r1 & 255;	 Catch:{ UnknownHostException -> 0x0051 }
        r4.f = r1;	 Catch:{ UnknownHostException -> 0x0051 }
        r1 = r4.f;	 Catch:{ UnknownHostException -> 0x0051 }
        r2 = 1;	 Catch:{ UnknownHostException -> 0x0051 }
        r2 = r5[r2];	 Catch:{ UnknownHostException -> 0x0051 }
        r2 = r2 << 8;	 Catch:{ UnknownHostException -> 0x0051 }
        r3 = 65280; // 0xff00 float:9.1477E-41 double:3.22526E-319;	 Catch:{ UnknownHostException -> 0x0051 }
        r2 = r2 & r3;	 Catch:{ UnknownHostException -> 0x0051 }
        r1 = r1 | r2;	 Catch:{ UnknownHostException -> 0x0051 }
        r4.f = r1;	 Catch:{ UnknownHostException -> 0x0051 }
        r1 = r4.f;	 Catch:{ UnknownHostException -> 0x0051 }
        r2 = 2;	 Catch:{ UnknownHostException -> 0x0051 }
        r2 = r5[r2];	 Catch:{ UnknownHostException -> 0x0051 }
        r2 = r2 << 16;	 Catch:{ UnknownHostException -> 0x0051 }
        r3 = 16711680; // 0xff0000 float:2.3418052E-38 double:8.256667E-317;	 Catch:{ UnknownHostException -> 0x0051 }
        r2 = r2 & r3;	 Catch:{ UnknownHostException -> 0x0051 }
        r1 = r1 | r2;	 Catch:{ UnknownHostException -> 0x0051 }
        r4.f = r1;	 Catch:{ UnknownHostException -> 0x0051 }
        r1 = r4.f;	 Catch:{ UnknownHostException -> 0x0051 }
        r2 = 3;	 Catch:{ UnknownHostException -> 0x0051 }
        r5 = r5[r2];	 Catch:{ UnknownHostException -> 0x0051 }
        r5 = r5 << 24;	 Catch:{ UnknownHostException -> 0x0051 }
        r2 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;	 Catch:{ UnknownHostException -> 0x0051 }
        r5 = r5 & r2;	 Catch:{ UnknownHostException -> 0x0051 }
        r5 = r5 | r1;	 Catch:{ UnknownHostException -> 0x0051 }
        r4.f = r5;	 Catch:{ UnknownHostException -> 0x0051 }
    L_0x0051:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.h.b(java.lang.String):com.xiaomi.network.Fallback");
    }

    public void b(int i, Exception exception) {
        a(i, exception);
        if ((exception != null || i == 18) && this.v != 0) {
            a(exception);
        }
    }

    public void b(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        a(z);
        if (!z) {
            this.s.a(new i(this, 13, currentTimeMillis), 10000);
        }
    }

    public synchronized void c() {
    }

    public void c(int i, Exception exception) {
        this.s.a(new j(this, 2, i, exception));
    }

    public String e() {
        return this.w;
    }

    public String s() {
        return this.j;
    }

    public synchronized void t() {
        try {
            if (!l()) {
                if (!k()) {
                    a(0, 0, null);
                    a(this.m);
                    return;
                }
            }
            b.a("WARNING: current xmpp has connected");
        } catch (Throwable e) {
            throw new l(e);
        }
    }

    public Socket u() {
        return new Socket();
    }

    public void v() {
        this.t = SystemClock.elapsedRealtime();
    }

    public void w() {
        this.u = SystemClock.elapsedRealtime();
    }
}
