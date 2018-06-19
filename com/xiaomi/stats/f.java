package com.xiaomi.stats;

import com.xiaomi.channel.commonutils.network.d;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.az;
import com.xiaomi.push.thrift.b;
import com.xiaomi.push.thrift.c;

public class f {
    private String a;
    private boolean b = false;
    private int c;
    private long d;
    private e e;
    private com.xiaomi.channel.commonutils.stats.a f = com.xiaomi.channel.commonutils.stats.a.a();

    static class a {
        static final f a = new f();
    }

    private b a(com.xiaomi.channel.commonutils.stats.a.a aVar) {
        if (aVar.a == 0) {
            return aVar.c instanceof b ? (b) aVar.c : null;
        } else {
            b f = f();
            f.a(com.xiaomi.push.thrift.a.CHANNEL_STATS_COUNTER.a());
            f.c(aVar.a);
            f.c(aVar.b);
            return f;
        }
    }

    public static f a() {
        return a.a;
    }

    private com.xiaomi.push.thrift.c b(int r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = new com.xiaomi.push.thrift.c;
        r2 = r7.a;
        r1.<init>(r2, r0);
        r2 = r7.e;
        r2 = r2.a;
        r2 = com.xiaomi.channel.commonutils.network.d.e(r2);
        if (r2 != 0) goto L_0x0021;
    L_0x0016:
        r2 = r7.e;
        r2 = r2.a;
        r2 = com.xiaomi.channel.commonutils.android.d.j(r2);
        r1.a(r2);
    L_0x0021:
        r2 = new org.apache.thrift.transport.b;
        r2.<init>(r8);
        r3 = new org.apache.thrift.protocol.k$a;
        r3.<init>();
        r3 = r3.a(r2);
        r1.b(r3);	 Catch:{ f -> 0x0032 }
    L_0x0032:
        r4 = r7.f;
        r4 = r4.c();
    L_0x0038:
        r5 = r4.size();	 Catch:{ NoSuchElementException -> 0x005c, NoSuchElementException -> 0x005c }
        if (r5 <= 0) goto L_0x005c;	 Catch:{ NoSuchElementException -> 0x005c, NoSuchElementException -> 0x005c }
    L_0x003e:
        r5 = r4.getLast();	 Catch:{ NoSuchElementException -> 0x005c, NoSuchElementException -> 0x005c }
        r5 = (com.xiaomi.channel.commonutils.stats.a.a) r5;	 Catch:{ NoSuchElementException -> 0x005c, NoSuchElementException -> 0x005c }
        r5 = r7.a(r5);	 Catch:{ NoSuchElementException -> 0x005c, NoSuchElementException -> 0x005c }
        if (r5 == 0) goto L_0x004d;	 Catch:{ NoSuchElementException -> 0x005c, NoSuchElementException -> 0x005c }
    L_0x004a:
        r5.b(r3);	 Catch:{ NoSuchElementException -> 0x005c, NoSuchElementException -> 0x005c }
    L_0x004d:
        r6 = r2.a_();	 Catch:{ NoSuchElementException -> 0x005c, NoSuchElementException -> 0x005c }
        if (r6 > r8) goto L_0x005c;	 Catch:{ NoSuchElementException -> 0x005c, NoSuchElementException -> 0x005c }
    L_0x0053:
        if (r5 == 0) goto L_0x0058;	 Catch:{ NoSuchElementException -> 0x005c, NoSuchElementException -> 0x005c }
    L_0x0055:
        r0.add(r5);	 Catch:{ NoSuchElementException -> 0x005c, NoSuchElementException -> 0x005c }
    L_0x0058:
        r4.removeLast();	 Catch:{ NoSuchElementException -> 0x005c, NoSuchElementException -> 0x005c }
        goto L_0x0038;
    L_0x005c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.stats.f.b(int):com.xiaomi.push.thrift.c");
    }

    public static e b() {
        e eVar;
        synchronized (a.a) {
            eVar = a.a.e;
        }
        return eVar;
    }

    private void g() {
        if (this.b && System.currentTimeMillis() - this.d > ((long) this.c)) {
            this.b = false;
            this.d = 0;
        }
    }

    public void a(int i) {
        if (i > 0) {
            i *= 1000;
            if (i > 604800000) {
                i = 604800000;
            }
            if (this.c != i || !this.b) {
                this.b = true;
                this.d = System.currentTimeMillis();
                this.c = i;
                StringBuilder stringBuilder = new StringBuilder("enable dot duration = ");
                stringBuilder.append(i);
                stringBuilder.append(" start = ");
                stringBuilder.append(this.d);
                com.xiaomi.channel.commonutils.logger.b.c(stringBuilder.toString());
            }
        }
    }

    public synchronized void a(XMPushService xMPushService) {
        this.e = new e(xMPushService);
        this.a = "";
        az.a().a(new g(this));
    }

    synchronized void a(b bVar) {
        this.f.a(bVar);
    }

    public boolean c() {
        return this.b;
    }

    boolean d() {
        g();
        return this.b && this.f.b() > 0;
    }

    synchronized c e() {
        c cVar;
        cVar = null;
        if (d()) {
            int i = 750;
            if (!d.e(this.e.a)) {
                i = 375;
            }
            cVar = b(i);
        }
        return cVar;
    }

    synchronized b f() {
        b bVar;
        bVar = new b();
        bVar.a(d.k(this.e.a));
        bVar.a = (byte) 0;
        bVar.c = 1;
        bVar.d((int) (System.currentTimeMillis() / 1000));
        if (this.e.b != null) {
            bVar.e(this.e.b.g());
        }
        return bVar;
    }
}
