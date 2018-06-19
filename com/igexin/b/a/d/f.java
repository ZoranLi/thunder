package com.igexin.b.a.d;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.PowerManager;
import com.igexin.b.a.c.a;
import com.igexin.b.a.d.a.b;
import com.igexin.b.a.d.a.e;
import java.util.Comparator;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class f extends BroadcastReceiver implements Comparator<e> {
    public static final String g = "com.igexin.b.a.d.f";
    public static final long u = TimeUnit.SECONDS.toMillis(2);
    private boolean a = false;
    final j h = new j(this);
    final HashMap<Long, b> i = new HashMap(7);
    final c j = new c();
    final d<e> k = new d(this, this);
    final ReentrantLock l = new ReentrantLock();
    PowerManager m;
    AlarmManager n;
    Intent o;
    PendingIntent p;
    Intent q;
    PendingIntent r;
    String s;
    volatile boolean t;

    protected f() {
        e.E = this;
    }

    public final int a(e eVar, e eVar2) {
        int i;
        if (eVar.A <= eVar2.A) {
            if (eVar.A >= eVar2.A) {
                if (eVar.v >= eVar2.v) {
                    if (eVar.v <= eVar2.v) {
                        i = 0;
                        if (eVar.u == eVar2.u) {
                            i = eVar.u < eVar2.u ? -1 : 1;
                        }
                        return i == 0 ? eVar.hashCode() - eVar2.hashCode() : i;
                    }
                }
            }
            i = 1;
            if (eVar.u == eVar2.u) {
                if (eVar.u < eVar2.u) {
                }
            }
            if (i == 0) {
            }
        }
        i = -1;
        if (eVar.u == eVar2.u) {
            if (eVar.u < eVar2.u) {
            }
        }
        if (i == 0) {
        }
    }

    @android.annotation.TargetApi(19)
    public final void a(long r5) {
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
        r4 = this;
        r0 = r4.t;
        if (r0 == 0) goto L_0x006f;
    L_0x0004:
        r0 = new java.lang.StringBuilder;
        r1 = "setalarm|";
        r0.<init>(r1);
        r1 = new java.text.SimpleDateFormat;
        r2 = "yyyy-MM-dd HH:mm:ss";
        r3 = java.util.Locale.US;
        r1.<init>(r2, r3);
        r2 = new java.util.Date;
        r2.<init>(r5);
        r1 = r1.format(r2);
        r0.append(r1);
        r0 = r0.toString();
        com.igexin.b.a.c.a.b(r0);
        r0 = 0;
        r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r2 >= 0) goto L_0x0036;
    L_0x002d:
        r5 = java.lang.System.currentTimeMillis();
        r0 = u;
        r2 = r5 + r0;
        r5 = r2;
    L_0x0036:
        r0 = r4.p;	 Catch:{ Throwable -> 0x0059 }
        if (r0 == 0) goto L_0x0058;	 Catch:{ Throwable -> 0x0059 }
    L_0x003a:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0059 }
        r1 = 19;	 Catch:{ Throwable -> 0x0059 }
        r2 = 0;	 Catch:{ Throwable -> 0x0059 }
        if (r0 >= r1) goto L_0x0049;	 Catch:{ Throwable -> 0x0059 }
    L_0x0041:
        r0 = r4.n;	 Catch:{ Throwable -> 0x0059 }
        r1 = r4.p;	 Catch:{ Throwable -> 0x0059 }
        r0.set(r2, r5, r1);	 Catch:{ Throwable -> 0x0059 }
        return;
    L_0x0049:
        r0 = r4.n;	 Catch:{ Throwable -> 0x0051 }
        r1 = r4.p;	 Catch:{ Throwable -> 0x0051 }
        r0.setExact(r2, r5, r1);	 Catch:{ Throwable -> 0x0051 }
        return;
    L_0x0051:
        r0 = r4.n;	 Catch:{ Throwable -> 0x0059 }
        r1 = r4.p;	 Catch:{ Throwable -> 0x0059 }
        r0.set(r2, r5, r1);	 Catch:{ Throwable -> 0x0059 }
    L_0x0058:
        return;
    L_0x0059:
        r5 = move-exception;
        r6 = new java.lang.StringBuilder;
        r0 = "TaskService";
        r6.<init>(r0);
        r5 = r5.toString();
        r6.append(r5);
        r5 = r6.toString();
        com.igexin.b.a.c.a.b(r5);
    L_0x006f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.f.a(long):void");
    }

    public final void a(android.content.Context r5) {
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
        r4 = this;
        r0 = r4.a;
        if (r0 != 0) goto L_0x00c9;
    L_0x0004:
        r0 = "power";
        r0 = r5.getSystemService(r0);
        r0 = (android.os.PowerManager) r0;
        r4.m = r0;
        r0 = 1;
        r4.t = r0;
        r1 = "alarm";
        r1 = r5.getSystemService(r1);
        r1 = (android.app.AlarmManager) r1;
        r4.n = r1;
        r1 = new android.content.IntentFilter;
        r2 = new java.lang.StringBuilder;
        r3 = "AlarmTaskSchedule.";
        r2.<init>(r3);
        r3 = r5.getPackageName();
        r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        r5.registerReceiver(r4, r1);
        r1 = new android.content.IntentFilter;
        r2 = new java.lang.StringBuilder;
        r3 = "AlarmTaskScheduleBak.";
        r2.<init>(r3);
        r3 = r5.getPackageName();
        r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        r5.registerReceiver(r4, r1);
        r1 = new android.content.IntentFilter;
        r2 = "android.intent.action.SCREEN_OFF";
        r1.<init>(r2);
        r5.registerReceiver(r4, r1);
        r1 = new android.content.IntentFilter;
        r2 = "android.intent.action.SCREEN_ON";
        r1.<init>(r2);
        r5.registerReceiver(r4, r1);
        r1 = new java.lang.StringBuilder;
        r2 = "AlarmNioTaskSchedule.";
        r1.<init>(r2);
        r2 = r5.getPackageName();
        r1.append(r2);
        r1 = r1.toString();
        r4.s = r1;
        r1 = new android.content.IntentFilter;
        r2 = r4.s;
        r1.<init>(r2);
        r5.registerReceiver(r4, r1);
        r1 = new android.content.Intent;
        r2 = new java.lang.StringBuilder;
        r3 = "AlarmTaskSchedule.";
        r2.<init>(r3);
        r3 = r5.getPackageName();
        r2.append(r3);
        r2 = r2.toString();
        r1.<init>(r2);
        r4.o = r1;
        r1 = r4.hashCode();
        r2 = r4.o;
        r3 = 134217728; // 0x8000000 float:3.85186E-34 double:6.63123685E-316;
        r1 = android.app.PendingIntent.getBroadcast(r5, r1, r2, r3);
        r4.p = r1;
        r1 = new android.content.Intent;
        r2 = r4.s;
        r1.<init>(r2);
        r4.q = r1;
        r1 = r4.hashCode();
        r1 = r1 + 2;
        r2 = r4.q;
        r5 = android.app.PendingIntent.getBroadcast(r5, r1, r2, r3);
        r4.r = r5;
        r5 = r4.h;
        r5.start();
        java.lang.Thread.yield();	 Catch:{ Throwable -> 0x00c7 }
    L_0x00c7:
        r4.a = r0;
    L_0x00c9:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.f.a(android.content.Context):void");
    }

    public final boolean a(b bVar) {
        if (bVar == null) {
            throw new NullPointerException();
        }
        ReentrantLock reentrantLock = this.l;
        if (!reentrantLock.tryLock()) {
            return false;
        }
        try {
            if (this.i.keySet().contains(Long.valueOf(bVar.o()))) {
                return false;
            }
            this.i.put(Long.valueOf(bVar.o()), bVar);
            reentrantLock.unlock();
            return true;
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("TaskService|");
            stringBuilder.append(th.toString());
            a.b(stringBuilder.toString());
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    final boolean a(e eVar, b bVar) {
        int b = eVar.b();
        if (b <= Integer.MIN_VALUE || b >= 0) {
            return (b < 0 || b >= Integer.MAX_VALUE) ? false : bVar.a(eVar, this);
        } else {
            e eVar2 = (e) eVar;
            boolean a = eVar2.t ? bVar.a(eVar2, this) : bVar.a(eVar, this);
            if (a) {
                eVar2.c();
            }
            return a;
        }
    }

    public final boolean a(e eVar, boolean z) {
        if (eVar == null) {
            throw new NullPointerException();
        }
        int i = 0;
        if (eVar.p || eVar.k) {
            return false;
        }
        d dVar = this.k;
        if (z) {
            i = dVar.e.incrementAndGet();
        }
        eVar.A = i;
        return dVar.a(eVar);
    }

    public final boolean a(com.igexin.b.a.d.e r3, boolean r4, boolean r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0041 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:60)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        if (r3 != 0) goto L_0x0008;
    L_0x0002:
        r3 = new java.lang.NullPointerException;
        r3.<init>();
        throw r3;
    L_0x0008:
        r0 = r3.m;
        r1 = 0;
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        return r1;
    L_0x000e:
        r0 = 1;
        if (r4 == 0) goto L_0x004a;
    L_0x0011:
        if (r5 != 0) goto L_0x004a;
    L_0x0013:
        r3.d();
        r3.b_();	 Catch:{ Exception -> 0x0029, all -> 0x0027 }
        r3.t();	 Catch:{ Exception -> 0x0029, all -> 0x0027 }
        r3.v();	 Catch:{ Exception -> 0x0029, all -> 0x0027 }
        r4 = r3.t;
        if (r4 != 0) goto L_0x0026;
    L_0x0023:
        r3.c();
    L_0x0026:
        return r0;
    L_0x0027:
        r4 = move-exception;
        goto L_0x0042;
    L_0x0029:
        r4 = move-exception;
        r3.t = r0;	 Catch:{ Exception -> 0x0029, all -> 0x0027 }
        r3.B = r4;	 Catch:{ Exception -> 0x0029, all -> 0x0027 }
        r3.p();	 Catch:{ Exception -> 0x0029, all -> 0x0027 }
        r3.w();	 Catch:{ Exception -> 0x0029, all -> 0x0027 }
        r2.a(r3);	 Catch:{ Exception -> 0x0029, all -> 0x0027 }
        r2.f();	 Catch:{ Exception -> 0x0029, all -> 0x0027 }
        r4 = r3.t;
        if (r4 != 0) goto L_0x0041;
    L_0x003e:
        r3.c();
    L_0x0041:
        return r1;
    L_0x0042:
        r5 = r3.t;
        if (r5 != 0) goto L_0x0049;
    L_0x0046:
        r3.c();
    L_0x0049:
        throw r4;
    L_0x004a:
        if (r5 == 0) goto L_0x004f;
    L_0x004c:
        if (r4 == 0) goto L_0x004f;
    L_0x004e:
        goto L_0x0050;
    L_0x004f:
        r0 = r1;
    L_0x0050:
        r3 = r2.a(r3, r0);
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.f.a(com.igexin.b.a.d.e, boolean, boolean):boolean");
    }

    public final boolean a(Class cls) {
        d dVar = this.k;
        return dVar != null && dVar.a(cls);
    }

    public final boolean a(java.lang.Object r5) {
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
        r4 = this;
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof com.igexin.push.d.c.p;	 Catch:{ Exception -> 0x003c }
        if (r1 == 0) goto L_0x003c;	 Catch:{ Exception -> 0x003c }
    L_0x0008:
        r1 = r5;	 Catch:{ Exception -> 0x003c }
        r1 = (com.igexin.push.d.c.p) r1;	 Catch:{ Exception -> 0x003c }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003c }
        r3 = "TaskService|responseTask|";	 Catch:{ Exception -> 0x003c }
        r2.<init>(r3);	 Catch:{ Exception -> 0x003c }
        r3 = r5.getClass();	 Catch:{ Exception -> 0x003c }
        r3 = r3.getName();	 Catch:{ Exception -> 0x003c }
        r2.append(r3);	 Catch:{ Exception -> 0x003c }
        r3 = "|";	 Catch:{ Exception -> 0x003c }
        r2.append(r3);	 Catch:{ Exception -> 0x003c }
        r3 = r5.hashCode();	 Catch:{ Exception -> 0x003c }
        r2.append(r3);	 Catch:{ Exception -> 0x003c }
        r3 = "|";	 Catch:{ Exception -> 0x003c }
        r2.append(r3);	 Catch:{ Exception -> 0x003c }
        r1 = r1.e;	 Catch:{ Exception -> 0x003c }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x003c }
        r2.append(r1);	 Catch:{ Exception -> 0x003c }
        r1 = r2.toString();	 Catch:{ Exception -> 0x003c }
        com.igexin.b.a.c.a.a(r1);	 Catch:{ Exception -> 0x003c }
    L_0x003c:
        r1 = new java.lang.StringBuilder;
        r2 = "TaskService|responseQueue ++ task = ";
        r1.<init>(r2);
        r2 = r5.getClass();
        r2 = r2.getName();
        r1.append(r2);
        r2 = "@";
        r1.append(r2);
        r2 = r5.hashCode();
        r1.append(r2);
        r1 = r1.toString();
        com.igexin.b.a.c.a.b(r1);
        r1 = r5 instanceof com.igexin.b.a.d.a.e;
        if (r1 != 0) goto L_0x006d;
    L_0x0065:
        r5 = new java.lang.ClassCastException;
        r0 = "response Obj is not a TaskResult ";
        r5.<init>(r0);
        throw r5;
    L_0x006d:
        r1 = r5;
        r1 = (com.igexin.b.a.d.a.e) r1;
        r2 = r1.l();
        if (r2 == 0) goto L_0x0077;
    L_0x0076:
        return r0;
    L_0x0077:
        r1.b(r0);
        r0 = r5 instanceof com.igexin.push.d.b.b;
        if (r0 != 0) goto L_0x0086;
    L_0x007e:
        r0 = r5 instanceof com.igexin.push.d.b.c;
        if (r0 != 0) goto L_0x0086;
    L_0x0082:
        r5 = r5 instanceof com.igexin.push.d.b.d;
        if (r5 == 0) goto L_0x0090;
    L_0x0086:
        r5 = r4.j;
        r5.a();
        r5 = "TaskService|scheduleQueue_response_change_queue primaryResponseQueue";
        com.igexin.b.a.c.a.b(r5);
    L_0x0090:
        r5 = r4.j;
        r5.a(r1);
        r5 = 1;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.f.a(java.lang.Object):boolean");
    }

    @android.annotation.TargetApi(19)
    public final void b(long r5) {
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
        r4 = this;
        r0 = new java.lang.StringBuilder;
        r1 = "setnioalarm|";
        r0.<init>(r1);
        r1 = new java.text.SimpleDateFormat;
        r2 = "yyyy-MM-dd HH:mm:ss";
        r3 = java.util.Locale.US;
        r1.<init>(r2, r3);
        r2 = new java.util.Date;
        r2.<init>(r5);
        r1 = r1.format(r2);
        r0.append(r1);
        r0 = r0.toString();
        com.igexin.b.a.c.a.b(r0);
        r0 = 0;
        r2 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r2 >= 0) goto L_0x0032;
    L_0x0029:
        r5 = java.lang.System.currentTimeMillis();
        r0 = u;
        r2 = r5 + r0;
        r5 = r2;
    L_0x0032:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0050 }
        r1 = 19;	 Catch:{ Throwable -> 0x0050 }
        r2 = 0;	 Catch:{ Throwable -> 0x0050 }
        if (r0 >= r1) goto L_0x0041;	 Catch:{ Throwable -> 0x0050 }
    L_0x0039:
        r0 = r4.n;	 Catch:{ Throwable -> 0x0050 }
        r1 = r4.r;	 Catch:{ Throwable -> 0x0050 }
        r0.set(r2, r5, r1);	 Catch:{ Throwable -> 0x0050 }
        return;
    L_0x0041:
        r0 = r4.n;	 Catch:{ Exception -> 0x0049 }
        r1 = r4.r;	 Catch:{ Exception -> 0x0049 }
        r0.setExact(r2, r5, r1);	 Catch:{ Exception -> 0x0049 }
        return;
    L_0x0049:
        r0 = r4.n;	 Catch:{ Throwable -> 0x0050 }
        r1 = r4.r;	 Catch:{ Throwable -> 0x0050 }
        r0.set(r2, r5, r1);	 Catch:{ Throwable -> 0x0050 }
    L_0x0050:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.f.b(long):void");
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return a((e) obj, (e) obj2);
    }

    public final void e() {
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
        r0 = r2.r;	 Catch:{ Throwable -> 0x000b }
        if (r0 == 0) goto L_0x000b;	 Catch:{ Throwable -> 0x000b }
    L_0x0004:
        r0 = r2.n;	 Catch:{ Throwable -> 0x000b }
        r1 = r2.r;	 Catch:{ Throwable -> 0x000b }
        r0.cancel(r1);	 Catch:{ Throwable -> 0x000b }
    L_0x000b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.f.e():void");
    }

    protected final void f() {
        if (this.h != null && !this.h.isInterrupted()) {
            this.h.interrupt();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final void g() {
        /*
        r9 = this;
        r0 = "TaskService|call notifyObserver ~~~~";
    L_0x0002:
        com.igexin.b.a.c.a.b(r0);
    L_0x0005:
        r0 = r9.j;
        r0 = r0.c();
        if (r0 != 0) goto L_0x00dc;
    L_0x000d:
        r0 = r9.j;
        r0 = r0.d();
        if (r0 != 0) goto L_0x0016;
    L_0x0015:
        return;
    L_0x0016:
        r1 = new java.lang.StringBuilder;
        r2 = "TaskService|notifyObserver responseQueue -- task = ";
        r1.<init>(r2);
        r1.append(r0);
        r1 = r1.toString();
        com.igexin.b.a.c.a.b(r1);
        r1 = 1;
        r0.b(r1);
        r1 = 0;
        r2 = r9.l;
        r2.lock();
        r3 = -2147483648; // 0xffffffff80000000 float:-0.0 double:NaN;
        r4 = r9.i;	 Catch:{ Throwable -> 0x009b }
        r4 = r4.isEmpty();	 Catch:{ Throwable -> 0x009b }
        if (r4 != 0) goto L_0x0085;
    L_0x003b:
        r4 = r0.m();	 Catch:{ Throwable -> 0x009b }
        r6 = 0;
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 == 0) goto L_0x005f;
    L_0x0045:
        r6 = r9.i;	 Catch:{ Throwable -> 0x009b }
        r4 = java.lang.Long.valueOf(r4);	 Catch:{ Throwable -> 0x009b }
        r4 = r6.get(r4);	 Catch:{ Throwable -> 0x009b }
        r4 = (com.igexin.b.a.d.a.b) r4;	 Catch:{ Throwable -> 0x009b }
        if (r4 == 0) goto L_0x0085;
    L_0x0053:
        r5 = r4.n();	 Catch:{ Throwable -> 0x009b }
        if (r5 == 0) goto L_0x0085;
    L_0x0059:
        r4 = r9.a(r0, r4);	 Catch:{ Throwable -> 0x009b }
        r1 = r4;
        goto L_0x0085;
    L_0x005f:
        r4 = r9.i;	 Catch:{ Throwable -> 0x009b }
        r4 = r4.values();	 Catch:{ Throwable -> 0x009b }
        r4 = r4.iterator();	 Catch:{ Throwable -> 0x009b }
    L_0x0069:
        r5 = r4.hasNext();	 Catch:{ Throwable -> 0x009b }
        if (r5 == 0) goto L_0x0085;
    L_0x006f:
        r5 = r4.next();	 Catch:{ Throwable -> 0x009b }
        r5 = (com.igexin.b.a.d.a.b) r5;	 Catch:{ Throwable -> 0x009b }
        r6 = r5.n();	 Catch:{ Throwable -> 0x009b }
        if (r6 == 0) goto L_0x0069;
    L_0x007b:
        r5 = r9.a(r0, r5);	 Catch:{ Throwable -> 0x009b }
        if (r5 == 0) goto L_0x0083;
    L_0x0081:
        r1 = r5;
        goto L_0x0085;
    L_0x0083:
        r1 = r5;
        goto L_0x0069;
    L_0x0085:
        if (r1 != 0) goto L_0x0095;
    L_0x0087:
        r1 = r0.b();
        if (r1 <= r3) goto L_0x0095;
    L_0x008d:
        if (r1 >= 0) goto L_0x0095;
    L_0x008f:
        r1 = r0;
        r1 = (com.igexin.b.a.d.e) r1;
        r1.c();
    L_0x0095:
        r2.unlock();
        goto L_0x00bc;
    L_0x0099:
        r4 = move-exception;
        goto L_0x00c9;
    L_0x009b:
        r4 = move-exception;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0099 }
        r6 = "TaskService|";
        r5.<init>(r6);	 Catch:{ all -> 0x0099 }
        r4 = r4.toString();	 Catch:{ all -> 0x0099 }
        r5.append(r4);	 Catch:{ all -> 0x0099 }
        r4 = r5.toString();	 Catch:{ all -> 0x0099 }
        com.igexin.b.a.c.a.b(r4);	 Catch:{ all -> 0x0099 }
        if (r1 != 0) goto L_0x0095;
    L_0x00b3:
        r1 = r0.b();
        if (r1 <= r3) goto L_0x0095;
    L_0x00b9:
        if (r1 >= 0) goto L_0x0095;
    L_0x00bb:
        goto L_0x008f;
    L_0x00bc:
        r0 = r0 instanceof com.igexin.push.d.c.m;
        if (r0 == 0) goto L_0x0005;
    L_0x00c0:
        r0 = r9.j;
        r0.b();
        r0 = "TaskService|scheduleQueue_response_change_queue secondResponseQueue";
        goto L_0x0002;
    L_0x00c9:
        if (r1 != 0) goto L_0x00d8;
    L_0x00cb:
        r1 = r0.b();
        if (r1 <= r3) goto L_0x00d8;
    L_0x00d1:
        if (r1 >= 0) goto L_0x00d8;
    L_0x00d3:
        r0 = (com.igexin.b.a.d.e) r0;
        r0.c();
    L_0x00d8:
        r2.unlock();
        throw r4;
    L_0x00dc:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.f.g():void");
    }

    public final void onReceive(android.content.Context r4, android.content.Intent r5) {
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
        r4 = "android.intent.action.SCREEN_OFF";
        r0 = r5.getAction();
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x002e;
    L_0x000c:
        r4 = 1;
        r3.t = r4;
        r4 = "screenoff";
        com.igexin.b.a.c.a.b(r4);
        r4 = r3.k;
        r4 = r4.h;
        r4 = r4.get();
        r0 = 0;
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0079;
    L_0x0022:
        r4 = r3.k;
        r4 = r4.h;
        r4 = r4.get();
        r3.a(r4);
        return;
    L_0x002e:
        r4 = "android.intent.action.SCREEN_ON";
        r0 = r5.getAction();
        r4 = r4.equals(r0);
        if (r4 == 0) goto L_0x0043;
    L_0x003a:
        r4 = 0;
        r3.t = r4;
        r4 = "screenon";
        com.igexin.b.a.c.a.b(r4);
        return;
    L_0x0043:
        r4 = r5.getAction();
        r0 = "AlarmTaskSchedule.";
        r4 = r4.startsWith(r0);
        if (r4 != 0) goto L_0x007a;
    L_0x004f:
        r4 = r5.getAction();
        r0 = "AlarmTaskScheduleBak.";
        r4 = r4.startsWith(r0);
        if (r4 == 0) goto L_0x005c;
    L_0x005b:
        goto L_0x007a;
    L_0x005c:
        r4 = r3.s;
        r5 = r5.getAction();
        r4 = r4.equals(r5);
        if (r4 == 0) goto L_0x0079;
    L_0x0068:
        r4 = "receive nioalarm";
        com.igexin.b.a.c.a.b(r4);
        r4 = "TaskService|alarm time out #######";	 Catch:{ Exception -> 0x0079 }
        com.igexin.b.a.c.a.b(r4);	 Catch:{ Exception -> 0x0079 }
        r4 = com.igexin.b.a.b.a.a.d.a();	 Catch:{ Exception -> 0x0079 }
        r4.d();	 Catch:{ Exception -> 0x0079 }
    L_0x0079:
        return;
    L_0x007a:
        r4 = new java.lang.StringBuilder;
        r5 = "receivealarm|";
        r4.<init>(r5);
        r5 = r3.t;
        r4.append(r5);
        r4 = r4.toString();
        com.igexin.b.a.c.a.b(r4);
        r3.f();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.f.onReceive(android.content.Context, android.content.Intent):void");
    }
}
