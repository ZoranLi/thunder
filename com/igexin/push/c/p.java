package com.igexin.push.c;

import com.igexin.b.a.c.a;
import com.igexin.push.core.g;
import com.igexin.push.f.b.h;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class p extends h {
    public static final int a = ((int) a(20150601));
    private static final String b = "com.igexin.push.c.p";
    private volatile boolean L;
    private volatile boolean M;
    private j c;
    private Thread e;
    private o f;
    private long g;
    private Lock h;
    private Condition i;
    private final List<Object> j;

    public p() {
        super(604800000);
        this.g = -1;
        this.h = new ReentrantLock();
        this.i = this.h.newCondition();
        this.j = new ArrayList(1);
        this.L = true;
        this.o = true;
    }

    private void A() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = r1.e;	 Catch:{ Exception -> 0x0009 }
        if (r0 == 0) goto L_0x0009;	 Catch:{ Exception -> 0x0009 }
    L_0x0004:
        r0 = r1.e;	 Catch:{ Exception -> 0x0009 }
        r0.interrupt();	 Catch:{ Exception -> 0x0009 }
    L_0x0009:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.p.A():void");
    }

    private void B() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = r2.h;	 Catch:{ Exception -> 0x0021, all -> 0x001a }
        r0.lock();	 Catch:{ Exception -> 0x0021, all -> 0x001a }
        r0 = r2.j;	 Catch:{ Exception -> 0x0021, all -> 0x001a }
        r1 = new java.lang.Object;	 Catch:{ Exception -> 0x0021, all -> 0x001a }
        r1.<init>();	 Catch:{ Exception -> 0x0021, all -> 0x001a }
        r0.add(r1);	 Catch:{ Exception -> 0x0021, all -> 0x001a }
        r0 = r2.i;	 Catch:{ Exception -> 0x0021, all -> 0x001a }
        r0.signalAll();	 Catch:{ Exception -> 0x0021, all -> 0x001a }
        r0 = r2.h;	 Catch:{ Exception -> 0x0019 }
        r0.unlock();	 Catch:{ Exception -> 0x0019 }
    L_0x0019:
        return;
    L_0x001a:
        r0 = move-exception;
        r1 = r2.h;	 Catch:{ Exception -> 0x0020 }
        r1.unlock();	 Catch:{ Exception -> 0x0020 }
    L_0x0020:
        throw r0;
    L_0x0021:
        r0 = r2.h;	 Catch:{ Exception -> 0x0026 }
        r0.unlock();	 Catch:{ Exception -> 0x0026 }
    L_0x0026:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.p.B():void");
    }

    private static long a(long j) {
        double d = (double) (j / 10);
        return j + ((long) (((Math.random() * d) * 2.0d) - d));
    }

    private void x() {
        this.e = new Thread(new q(this));
        this.e.start();
    }

    private void y() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = java.util.concurrent.TimeUnit.MILLISECONDS;
        r1 = 1800000; // 0x1b7740 float:2.522337E-39 double:8.89318E-318;
        r3.a(r1, r0);
        r0 = r3.e;
        if (r0 != 0) goto L_0x001d;
    L_0x000c:
        r0 = 1;
        r3.L = r0;
        r0 = r3.j;
        r1 = new java.lang.Object;
        r1.<init>();
        r0.add(r1);
        r3.x();
        return;
    L_0x001d:
        r0 = r3.h;	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r0.lock();	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r0.<init>();	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r1 = b;	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r0.append(r1);	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r1 = "|detect ";	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r0.append(r1);	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r1 = r3.z();	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r0.append(r1);	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r1 = "running, start";	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r0.append(r1);	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r0 = r3.j;	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r1 = new java.lang.Object;	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r1.<init>();	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r0.add(r1);	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r0 = r3.i;	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r0.signalAll();	 Catch:{ Exception -> 0x0060, all -> 0x0059 }
        r0 = r3.h;	 Catch:{ Exception -> 0x0058 }
        r0.unlock();	 Catch:{ Exception -> 0x0058 }
    L_0x0058:
        return;
    L_0x0059:
        r0 = move-exception;
        r1 = r3.h;	 Catch:{ Exception -> 0x005f }
        r1.unlock();	 Catch:{ Exception -> 0x005f }
    L_0x005f:
        throw r0;
    L_0x0060:
        r0 = r3.h;	 Catch:{ Exception -> 0x0065 }
        r0.unlock();	 Catch:{ Exception -> 0x0065 }
    L_0x0065:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.c.p.y():void");
    }

    private String z() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.c.a());
        stringBuilder.append("[");
        stringBuilder.append(this.c.c());
        stringBuilder.append("] ");
        return stringBuilder.toString();
    }

    protected void a() {
        if (!this.M) {
            y();
        }
    }

    public void a(j jVar) {
        this.c = jVar;
    }

    public void a(o oVar) {
        this.f = oVar;
    }

    public void a(boolean z) {
        StringBuilder stringBuilder;
        if (z) {
            j();
            stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append("|detect ");
            stringBuilder.append(z());
            stringBuilder.append("reset delay = 0");
            a.b(stringBuilder.toString());
        }
        g.h = com.igexin.push.util.a.g();
        stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append("|network available : ");
        stringBuilder.append(g.h);
        a.b(stringBuilder.toString());
        if (g.h) {
            long j;
            long j2;
            if (this.g <= 2000) {
                j = this.g;
                j2 = 500;
            } else {
                j2 = 15000;
                if (this.g <= 15000) {
                    j = this.g;
                    j2 = 5000;
                } else if (this.g <= 60000) {
                    j = this.g;
                } else {
                    j = this.g;
                    j2 = 120000;
                }
            }
            this.g = j + j2;
            if (this.g > 3600000) {
                this.g = 3600000;
            }
            this.g = a(this.g);
            stringBuilder = new StringBuilder();
            stringBuilder.append(b);
            stringBuilder.append("|detect ");
            stringBuilder.append(z());
            stringBuilder.append("redetect delay = ");
            stringBuilder.append(this.g);
            a.b(stringBuilder.toString());
        } else {
            this.g = 604800000;
        }
        a(this.g, TimeUnit.MILLISECONDS);
    }

    public final int b() {
        return a;
    }

    public void c() {
        super.c();
    }

    public void d() {
    }

    public j d_() {
        return this.c;
    }

    public void g() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append("|detect ");
        stringBuilder.append(z());
        stringBuilder.append("finish, task stop");
        a.b(stringBuilder.toString());
        a(604800000, TimeUnit.MILLISECONDS);
    }

    public void h() {
        this.M = true;
        this.L = false;
        this.o = false;
        this.f = null;
        B();
        p();
        A();
    }

    public void i() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(b);
        stringBuilder.append("|detect ");
        stringBuilder.append(z());
        stringBuilder.append("start");
        a.b(stringBuilder.toString());
        this.g = 50;
        a(this.g, TimeUnit.MILLISECONDS);
    }

    public void j() {
        this.g = 0;
    }
}
