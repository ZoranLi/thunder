package com.igexin.b.a.b.a.a;

import android.os.Message;
import com.igexin.b.a.b.b;
import com.igexin.b.a.b.c;
import com.igexin.b.a.c.a;
import com.igexin.b.a.d.f;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class d {
    private static d l;
    private static final Object m = new Object();
    public Lock a = new ReentrantLock();
    public Condition b = this.a.newCondition();
    public ConcurrentLinkedQueue<k> c = new ConcurrentLinkedQueue();
    public List<k> d = new ArrayList();
    private b e;
    private com.igexin.b.a.b.d f;
    private Socket g;
    private j h;
    private l i;
    private c j;
    private boolean k;
    private i n = new i(this);
    private long o;
    private final Comparator<k> p = new h(this);

    private d() {
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (l == null) {
                l = new d();
            }
            dVar = l;
        }
        return dVar;
    }

    private void a(Socket socket) {
        try {
            if (!this.j.g()) {
                this.g = socket;
                this.f = new com.igexin.b.a.b.d();
                b(socket);
                c(socket);
            }
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("S-SM|");
            stringBuilder.append(e.toString());
            a.b(stringBuilder.toString());
            b();
        }
    }

    private void b(k kVar) {
        if (kVar.y > 0) {
            if (kVar.D != null) {
                long currentTimeMillis = System.currentTimeMillis();
                kVar.b(currentTimeMillis);
                synchronized (m) {
                    this.d.add(kVar);
                    Collections.sort(this.d, this.p);
                    this.o = TimeUnit.SECONDS.toMillis((long) ((k) this.d.get(0)).y);
                    if (this.o > 0 && this.d.size() == 1) {
                        StringBuilder stringBuilder = new StringBuilder("S-SM|add : ");
                        stringBuilder.append(kVar.toString());
                        stringBuilder.append(" --- ");
                        stringBuilder.append(kVar.c.getClass().getName());
                        stringBuilder.append(" set alarm delay = ");
                        stringBuilder.append(this.o + f.u);
                        a.b(stringBuilder.toString());
                        c.b().b((currentTimeMillis + this.o) + f.u);
                    }
                }
                return;
            }
        }
        kVar.p();
    }

    private void b(Socket socket) {
        this.h = new j(new m(socket.getInputStream()), this.e, this.f);
        this.h.a(new f(this));
        c.b().a(this.h, true);
    }

    private void c(Socket socket) {
        this.i = new l(new n(socket.getOutputStream()), this.e, this.f);
        this.i.a(new g(this));
        c.b().a(this.i, true);
    }

    private void e() {
        a.b("S-SM|disconnect = true, reconnect");
        this.j = new c(new e(this));
        c.b().a(this.j, true);
    }

    private void f() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = "S-SM|disconnect";
        com.igexin.b.a.c.a.b(r0);
        r0 = r1.j;
        if (r0 == 0) goto L_0x000e;
    L_0x0009:
        r0 = r1.j;
        r0.h();
    L_0x000e:
        r0 = r1.i;
        if (r0 == 0) goto L_0x0024;
    L_0x0012:
        r0 = r1.i;
        r0.h();
        r0 = r1.i;
        r0 = r0.j;
        if (r0 == 0) goto L_0x0024;
    L_0x001d:
        r0 = r1.i;	 Catch:{ Exception -> 0x0024 }
        r0 = r0.j;	 Catch:{ Exception -> 0x0024 }
        r0.a();	 Catch:{ Exception -> 0x0024 }
    L_0x0024:
        r0 = r1.h;
        if (r0 == 0) goto L_0x003a;
    L_0x0028:
        r0 = r1.h;
        r0.h();
        r0 = r1.h;
        r0 = r0.i;
        if (r0 == 0) goto L_0x003a;
    L_0x0033:
        r0 = r1.h;	 Catch:{ Exception -> 0x003a }
        r0 = r0.i;	 Catch:{ Exception -> 0x003a }
        r0.a();	 Catch:{ Exception -> 0x003a }
    L_0x003a:
        r0 = r1.g;
        if (r0 == 0) goto L_0x004b;
    L_0x003e:
        r0 = r1.g;	 Catch:{ Exception -> 0x004b }
        r0 = r0.isClosed();	 Catch:{ Exception -> 0x004b }
        if (r0 != 0) goto L_0x004b;	 Catch:{ Exception -> 0x004b }
    L_0x0046:
        r0 = r1.g;	 Catch:{ Exception -> 0x004b }
        r0.close();	 Catch:{ Exception -> 0x004b }
    L_0x004b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.a.a.d.f():void");
    }

    private void g() {
        if (!this.k) {
            this.k = true;
            h();
            com.igexin.push.core.a.f.a().b(false);
        }
    }

    private void h() {
        if (this.i != null) {
            this.i.j = null;
            this.i = null;
        }
        if (this.h != null) {
            this.h.i = null;
            this.h = null;
        }
        this.j = null;
        this.g = null;
        this.f = null;
    }

    private boolean i() {
        return (this.j == null || this.j.e) && ((this.h == null || this.h.e) && (this.i == null || this.i.e));
    }

    private boolean j() {
        return (this.g == null || this.g.isClosed()) ? false : true;
    }

    private void k() {
        c.b().e();
        a.b("S-SM|cancel alrm");
        synchronized (m) {
            if (!this.d.isEmpty()) {
                for (k p : this.d) {
                    p.p();
                }
                this.d.clear();
            }
        }
        if (!l.c.isEmpty()) {
            Iterator it = l.c.iterator();
            while (it.hasNext()) {
                ((k) it.next()).p();
            }
            l.c.clear();
        }
    }

    public final void a(com.igexin.b.a.b.a.a.k r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = r1.a;	 Catch:{ Exception -> 0x001c, all -> 0x0015 }
        r0.lock();	 Catch:{ Exception -> 0x001c, all -> 0x0015 }
        r0 = r1.c;	 Catch:{ Exception -> 0x001c, all -> 0x0015 }
        r0.offer(r2);	 Catch:{ Exception -> 0x001c, all -> 0x0015 }
        r2 = r1.b;	 Catch:{ Exception -> 0x001c, all -> 0x0015 }
        r2.signalAll();	 Catch:{ Exception -> 0x001c, all -> 0x0015 }
        r2 = r1.a;	 Catch:{ Exception -> 0x0014 }
        r2.unlock();	 Catch:{ Exception -> 0x0014 }
    L_0x0014:
        return;
    L_0x0015:
        r2 = move-exception;
        r0 = r1.a;	 Catch:{ Exception -> 0x001b }
        r0.unlock();	 Catch:{ Exception -> 0x001b }
    L_0x001b:
        throw r2;
    L_0x001c:
        r2 = r1.a;	 Catch:{ Exception -> 0x0021 }
        r2.unlock();	 Catch:{ Exception -> 0x0021 }
    L_0x0021:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.a.a.d.a(com.igexin.b.a.b.a.a.k):void");
    }

    public final void a(b bVar) {
        this.e = bVar;
        if (this.h != null) {
            this.h.j = bVar;
        }
        if (this.i != null) {
            this.i.i = bVar;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r11) {
        /*
        r10 = this;
        r0 = java.lang.System.currentTimeMillis();
        r2 = m;
        monitor-enter(r2);
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f9 }
        r4 = "S-SM|";
        r3.<init>(r4);	 Catch:{ all -> 0x00f9 }
        r3.append(r11);	 Catch:{ all -> 0x00f9 }
        r11 = " -- resp";
        r3.append(r11);	 Catch:{ all -> 0x00f9 }
        r11 = r3.toString();	 Catch:{ all -> 0x00f9 }
        com.igexin.b.a.c.a.b(r11);	 Catch:{ all -> 0x00f9 }
        r11 = r10.d;	 Catch:{ all -> 0x00f9 }
        r11 = r11.iterator();	 Catch:{ all -> 0x00f9 }
    L_0x0023:
        r3 = r11.hasNext();	 Catch:{ all -> 0x00f9 }
        r4 = 0;
        r6 = 0;
        if (r3 == 0) goto L_0x005c;
    L_0x002c:
        r3 = r11.next();	 Catch:{ all -> 0x00f9 }
        r3 = (com.igexin.b.a.b.a.a.k) r3;	 Catch:{ all -> 0x00f9 }
        r7 = r3.D;	 Catch:{ all -> 0x00f9 }
        r7 = r7.a(r0, r3);	 Catch:{ all -> 0x00f9 }
        if (r7 == 0) goto L_0x0047;
    L_0x003a:
        r3.p();	 Catch:{ all -> 0x00f9 }
        r7 = r3.D;	 Catch:{ all -> 0x00f9 }
        r7.a(r3);	 Catch:{ all -> 0x00f9 }
        r3 = 1;
        r11.remove();	 Catch:{ all -> 0x00f9 }
        goto L_0x005d;
    L_0x0047:
        r6 = r3.D;	 Catch:{ all -> 0x00f9 }
        r6 = r6.b(r0, r3);	 Catch:{ all -> 0x00f9 }
        r8 = r10.o;	 Catch:{ all -> 0x00f9 }
        r3 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1));
        if (r3 < 0) goto L_0x0059;
    L_0x0053:
        r3 = r10.o;	 Catch:{ all -> 0x00f9 }
        r5 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1));
        if (r5 <= 0) goto L_0x0023;
    L_0x0059:
        r10.o = r6;	 Catch:{ all -> 0x00f9 }
        goto L_0x0023;
    L_0x005c:
        r3 = r6;
    L_0x005d:
        r11 = com.igexin.b.a.b.c.b();	 Catch:{ all -> 0x00f9 }
        r11.e();	 Catch:{ all -> 0x00f9 }
        if (r3 == 0) goto L_0x0070;
    L_0x0066:
        r11 = "S-SM|time out";
        com.igexin.b.a.c.a.b(r11);	 Catch:{ all -> 0x00f9 }
        r10.d();	 Catch:{ all -> 0x00f9 }
        monitor-exit(r2);	 Catch:{ all -> 0x00f9 }
        return;
    L_0x0070:
        r11 = r10.d;	 Catch:{ all -> 0x00f9 }
        r11 = r11.size();	 Catch:{ all -> 0x00f9 }
        if (r11 <= 0) goto L_0x00b6;
    L_0x0078:
        r11 = r10.d;	 Catch:{ all -> 0x00f9 }
        r11 = r11.get(r6);	 Catch:{ all -> 0x00f9 }
        r11 = (com.igexin.b.a.b.a.a.k) r11;	 Catch:{ all -> 0x00f9 }
        r11.p();	 Catch:{ all -> 0x00f9 }
        r3 = com.igexin.b.a.b.c.b();	 Catch:{ all -> 0x00f9 }
        r3.a(r11);	 Catch:{ all -> 0x00f9 }
        r3 = r10.d;	 Catch:{ all -> 0x00f9 }
        r3.remove(r11);	 Catch:{ all -> 0x00f9 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f9 }
        r6 = "S-SM|remove : ";
        r3.<init>(r6);	 Catch:{ all -> 0x00f9 }
        r6 = r11.toString();	 Catch:{ all -> 0x00f9 }
        r3.append(r6);	 Catch:{ all -> 0x00f9 }
        r6 = " -- ";
        r3.append(r6);	 Catch:{ all -> 0x00f9 }
        r11 = r11.c;	 Catch:{ all -> 0x00f9 }
        r11 = r11.getClass();	 Catch:{ all -> 0x00f9 }
        r11 = r11.getSimpleName();	 Catch:{ all -> 0x00f9 }
        r3.append(r11);	 Catch:{ all -> 0x00f9 }
        r11 = r3.toString();	 Catch:{ all -> 0x00f9 }
        com.igexin.b.a.c.a.b(r11);	 Catch:{ all -> 0x00f9 }
    L_0x00b6:
        r11 = r10.d;	 Catch:{ all -> 0x00f9 }
        r11 = r11.size();	 Catch:{ all -> 0x00f9 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f9 }
        r6 = "S-SM|r, size = ";
        r3.<init>(r6);	 Catch:{ all -> 0x00f9 }
        r3.append(r11);	 Catch:{ all -> 0x00f9 }
        r3 = r3.toString();	 Catch:{ all -> 0x00f9 }
        com.igexin.b.a.c.a.b(r3);	 Catch:{ all -> 0x00f9 }
        if (r11 <= 0) goto L_0x00f7;
    L_0x00cf:
        r6 = r10.o;	 Catch:{ all -> 0x00f9 }
        r11 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r11 <= 0) goto L_0x00f7;
    L_0x00d5:
        r11 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f9 }
        r3 = "S-SM|set alarm = ";
        r11.<init>(r3);	 Catch:{ all -> 0x00f9 }
        r3 = r10.o;	 Catch:{ all -> 0x00f9 }
        r11.append(r3);	 Catch:{ all -> 0x00f9 }
        r11 = r11.toString();	 Catch:{ all -> 0x00f9 }
        com.igexin.b.a.c.a.b(r11);	 Catch:{ all -> 0x00f9 }
        r11 = com.igexin.b.a.b.c.b();	 Catch:{ all -> 0x00f9 }
        r3 = r10.o;	 Catch:{ all -> 0x00f9 }
        r5 = r0 + r3;
        r0 = com.igexin.b.a.d.f.u;	 Catch:{ all -> 0x00f9 }
        r3 = r5 + r0;
        r11.b(r3);	 Catch:{ all -> 0x00f9 }
    L_0x00f7:
        monitor-exit(r2);	 Catch:{ all -> 0x00f9 }
        return;
    L_0x00f9:
        r11 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00f9 }
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.a.a.d.a(java.lang.String):void");
    }

    public final synchronized void a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("S-SM|reconnect, reset = ");
        stringBuilder.append(z);
        a.b(stringBuilder.toString());
        Message obtain = Message.obtain();
        obtain.obj = Boolean.valueOf(z);
        obtain.what = 5;
        this.n.sendMessage(obtain);
    }

    public final synchronized void b() {
        this.n.sendEmptyMessage(4);
    }

    public final void c() {
        this.n.sendEmptyMessage(0);
    }

    public final synchronized void d() {
        a.b("S-SM|alarm timeout disconnect");
        this.n.sendEmptyMessage(4);
    }
}
