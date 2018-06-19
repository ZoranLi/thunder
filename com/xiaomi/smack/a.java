package com.xiaomi.smack;

import android.util.Pair;
import com.xiaomi.channel.commonutils.string.c;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.ap;
import com.xiaomi.push.service.as;
import com.xiaomi.slim.b;
import com.xiaomi.smack.packet.d;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class a {
    public static boolean a = false;
    private static final AtomicInteger p = new AtomicInteger(0);
    protected int b = 0;
    protected long c = -1;
    protected volatile long d = 0;
    protected volatile long e = 0;
    protected int f;
    protected final Map<f, a> g = new ConcurrentHashMap();
    protected final Map<f, a> h = new ConcurrentHashMap();
    protected com.xiaomi.smack.debugger.a i = null;
    protected String j = "";
    protected String k = "";
    protected final int l = p.getAndIncrement();
    protected b m;
    protected XMPushService n;
    protected long o = 0;
    private LinkedList<Pair<Integer, Long>> q = new LinkedList();
    private final Collection<d> r = new CopyOnWriteArrayList();
    private int s = 2;
    private long t = 0;

    public static class a {
        private f a;
        private com.xiaomi.smack.filter.a b;

        public a(f fVar, com.xiaomi.smack.filter.a aVar) {
            this.a = fVar;
            this.b = aVar;
        }

        public void a(b bVar) {
            this.a.a(bVar);
        }

        public void a(d dVar) {
            if (this.b == null || this.b.a(dVar)) {
                this.a.b(dVar);
            }
        }
    }

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.util.concurrent.atomic.AtomicInteger;
        r1 = 0;
        r0.<init>(r1);
        p = r0;
        r0 = "smack.debugEnabled";	 Catch:{ Exception -> 0x0010 }
        r0 = java.lang.Boolean.getBoolean(r0);	 Catch:{ Exception -> 0x0010 }
        a = r0;	 Catch:{ Exception -> 0x0010 }
    L_0x0010:
        com.xiaomi.smack.g.a();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.a.<clinit>():void");
    }

    protected a(XMPushService xMPushService, b bVar) {
        this.m = bVar;
        this.n = xMPushService;
        j();
    }

    private String a(int i) {
        return i == 1 ? "connected" : i == 0 ? "connecting" : i == 2 ? "disconnected" : "unknown";
    }

    private void b(int i) {
        synchronized (this.q) {
            if (i == 1) {
                this.q.clear();
            } else {
                this.q.add(new Pair(Integer.valueOf(i), Long.valueOf(System.currentTimeMillis())));
                if (this.q.size() > 6) {
                    this.q.remove(0);
                }
            }
        }
    }

    public void a(int i, int i2, Exception exception) {
        if (i != this.s) {
            com.xiaomi.channel.commonutils.logger.b.a(String.format("update the connection status. %1$s -> %2$s : %3$s ", new Object[]{a(this.s), a(i), as.a(i2)}));
        }
        if (com.xiaomi.channel.commonutils.network.d.c(this.n)) {
            b(i);
        }
        if (i == 1) {
            this.n.a(10);
            if (this.s != 0) {
                com.xiaomi.channel.commonutils.logger.b.a("try set connected while not connecting.");
            }
            this.s = i;
            for (d a : this.r) {
                a.a(this);
            }
        } else if (i == 0) {
            if (this.s != 2) {
                com.xiaomi.channel.commonutils.logger.b.a("try set connecting while not disconnected.");
            }
            this.s = i;
            for (d a2 : this.r) {
                a2.b(this);
            }
        } else {
            if (i == 2) {
                this.n.a(10);
                if (this.s == 0) {
                    for (d a3 : this.r) {
                        a3.a(this, exception == null ? new CancellationException("disconnect while connecting") : exception);
                    }
                } else if (this.s == 1) {
                    for (d a4 : this.r) {
                        a4.a(this, i2, exception);
                    }
                }
                this.s = i;
            }
        }
    }

    public abstract void a(ap.b bVar);

    public void a(d dVar) {
        if (!(dVar == null || this.r.contains(dVar))) {
            this.r.add(dVar);
        }
    }

    public void a(f fVar, com.xiaomi.smack.filter.a aVar) {
        if (fVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.g.put(fVar, new a(fVar, aVar));
    }

    public abstract void a(d dVar);

    public synchronized void a(String str) {
        if (this.s == 0) {
            StringBuilder stringBuilder = new StringBuilder("setChallenge hash = ");
            stringBuilder.append(c.a(str).substring(0, 8));
            com.xiaomi.channel.commonutils.logger.b.a(stringBuilder.toString());
            this.j = str;
            a(1, 0, null);
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.a("ignore setChallenge because connection was disconnected");
    }

    public abstract void a(String str, String str2);

    public abstract void a(b[] bVarArr);

    public synchronized boolean a(long j) {
        return this.t >= j;
    }

    public abstract void b(int i, Exception exception);

    public abstract void b(b bVar);

    public void b(d dVar) {
        this.r.remove(dVar);
    }

    public void b(f fVar, com.xiaomi.smack.filter.a aVar) {
        if (fVar == null) {
            throw new NullPointerException("Packet listener is null.");
        }
        this.h.put(fVar, new a(fVar, aVar));
    }

    public abstract void b(boolean z);

    public boolean b() {
        return false;
    }

    public b d() {
        return this.m;
    }

    public String e() {
        return this.m.e();
    }

    public String f() {
        return this.m.c();
    }

    public int g() {
        return this.f;
    }

    public long h() {
        return this.e;
    }

    public void i() {
        b(0, null);
    }

    protected void j() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.m;
        r0 = r0.f();
        if (r0 == 0) goto L_0x0057;
    L_0x0008:
        r0 = r6.i;
        if (r0 != 0) goto L_0x0057;
    L_0x000c:
        r0 = 0;
        r1 = "smack.debuggerClass";	 Catch:{ Throwable -> 0x0014 }
        r1 = java.lang.System.getProperty(r1);	 Catch:{ Throwable -> 0x0014 }
        goto L_0x0015;
    L_0x0014:
        r1 = r0;
    L_0x0015:
        if (r1 == 0) goto L_0x0021;
    L_0x0017:
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x001d }
        r0 = r1;
        goto L_0x0021;
    L_0x001d:
        r1 = move-exception;
        r1.printStackTrace();
    L_0x0021:
        if (r0 != 0) goto L_0x002b;
    L_0x0023:
        r0 = new com.xiaomi.measite.smack.a;
        r0.<init>(r6);
        r6.i = r0;
        return;
    L_0x002b:
        r1 = 3;
        r1 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x004e }
        r2 = com.xiaomi.smack.a.class;	 Catch:{ Exception -> 0x004e }
        r3 = 0;	 Catch:{ Exception -> 0x004e }
        r1[r3] = r2;	 Catch:{ Exception -> 0x004e }
        r2 = java.io.Writer.class;	 Catch:{ Exception -> 0x004e }
        r4 = 1;	 Catch:{ Exception -> 0x004e }
        r1[r4] = r2;	 Catch:{ Exception -> 0x004e }
        r2 = 2;	 Catch:{ Exception -> 0x004e }
        r5 = java.io.Reader.class;	 Catch:{ Exception -> 0x004e }
        r1[r2] = r5;	 Catch:{ Exception -> 0x004e }
        r0 = r0.getConstructor(r1);	 Catch:{ Exception -> 0x004e }
        r1 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x004e }
        r1[r3] = r6;	 Catch:{ Exception -> 0x004e }
        r0 = r0.newInstance(r1);	 Catch:{ Exception -> 0x004e }
        r0 = (com.xiaomi.smack.debugger.a) r0;	 Catch:{ Exception -> 0x004e }
        r6.i = r0;	 Catch:{ Exception -> 0x004e }
        return;
    L_0x004e:
        r0 = move-exception;
        r1 = new java.lang.IllegalArgumentException;
        r2 = "Can't initialize the configured debugger!";
        r1.<init>(r2, r0);
        throw r1;
    L_0x0057:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.smack.a.j():void");
    }

    public boolean k() {
        return this.s == 0;
    }

    public boolean l() {
        return this.s == 1;
    }

    public int m() {
        return this.b;
    }

    public int n() {
        return this.s;
    }

    public synchronized void o() {
        this.t = System.currentTimeMillis();
    }

    public synchronized boolean p() {
        return System.currentTimeMillis() - this.t < ((long) g.b());
    }

    public synchronized boolean q() {
        return System.currentTimeMillis() - this.o < ((long) g.b());
    }

    public void r() {
        synchronized (this.q) {
            this.q.clear();
        }
    }
}
