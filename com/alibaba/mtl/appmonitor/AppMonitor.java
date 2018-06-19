package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.log.e.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class AppMonitor {
    protected static r a = null;
    private static Application b = null;
    private static f c = null;
    private static HandlerThread d = null;
    private static volatile boolean e = false;
    private static Object f = new Object();
    private static List<e> g = Collections.synchronizedList(new ArrayList());
    private static boolean h = false;
    private static String i;
    private static String j;
    private static boolean k;
    private static String l;
    private static b m = b.Local;
    private static Context n;
    private static ServiceConnection o = new f();
    private static String p;

    public static class a {
        public static void a(String str, String str2, String str3) {
            if (AppMonitor.m()) {
                AppMonitor.c.a(new l(str, str2, str3));
            }
        }

        public static void a(String str, String str2, String str3, String str4, String str5) {
            if (AppMonitor.m()) {
                AppMonitor.c.a(new m(str, str2, str3, str4, str5));
            }
        }
    }

    enum b {
        Local,
        Service
    }

    public static class c {
        public static void a(String str, String str2, String str3, double d) {
            if (AppMonitor.m()) {
                AppMonitor.c.a(new n(str, str2, str3, d));
            }
        }
    }

    public static class d {
        public static void a(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
            if (AppMonitor.m()) {
                AppMonitor.c.a(new p(str, str2, dimensionValueSet, measureValueSet));
            }
        }
    }

    static class e {
        public String a;
        public String b;
        public MeasureSet c;
        public DimensionSet d;
        public boolean e;

        e() {
        }
    }

    static class f extends Handler {
        boolean a = null;

        public f(Looper looper) {
            super(looper);
        }

        public final void a(java.lang.Runnable r3) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r2 = this;
            if (r3 != 0) goto L_0x0003;
        L_0x0002:
            return;
        L_0x0003:
            r0 = android.os.Message.obtain();	 Catch:{ Throwable -> 0x0010 }
            r1 = 1;	 Catch:{ Throwable -> 0x0010 }
            r0.what = r1;	 Catch:{ Throwable -> 0x0010 }
            r0.obj = r3;	 Catch:{ Throwable -> 0x0010 }
            r2.sendMessage(r0);	 Catch:{ Throwable -> 0x0010 }
            return;
        L_0x0010:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.AppMonitor.f.a(java.lang.Runnable):void");
        }

        public final void handleMessage(android.os.Message r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r4 = this;
            r0 = r4.a;	 Catch:{ Throwable -> 0x0030 }
            if (r0 == 0) goto L_0x001f;	 Catch:{ Throwable -> 0x0030 }
        L_0x0004:
            r0 = 0;	 Catch:{ Throwable -> 0x0030 }
            r4.a = r0;	 Catch:{ Throwable -> 0x0030 }
            r0 = com.alibaba.mtl.appmonitor.AppMonitor.f;	 Catch:{ Throwable -> 0x0030 }
            monitor-enter(r0);	 Catch:{ Throwable -> 0x0030 }
            r1 = com.alibaba.mtl.appmonitor.AppMonitor.f;	 Catch:{ InterruptedException -> 0x0018 }
            r2 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;	 Catch:{ InterruptedException -> 0x0018 }
            r1.wait(r2);	 Catch:{ InterruptedException -> 0x0018 }
            goto L_0x001b;
        L_0x0016:
            r1 = move-exception;
            goto L_0x001d;
        L_0x0018:
            com.alibaba.mtl.appmonitor.AppMonitor.l();	 Catch:{ all -> 0x0016 }
        L_0x001b:
            monitor-exit(r0);	 Catch:{ all -> 0x0016 }
            goto L_0x001f;	 Catch:{ all -> 0x0016 }
        L_0x001d:
            monitor-exit(r0);	 Catch:{ all -> 0x0016 }
            throw r1;	 Catch:{ Throwable -> 0x0030 }
        L_0x001f:
            r0 = r5.obj;	 Catch:{ Throwable -> 0x0030 }
            if (r0 == 0) goto L_0x0030;	 Catch:{ Throwable -> 0x0030 }
        L_0x0023:
            r0 = r5.obj;	 Catch:{ Throwable -> 0x0030 }
            r0 = r0 instanceof java.lang.Runnable;	 Catch:{ Throwable -> 0x0030 }
            if (r0 == 0) goto L_0x0030;	 Catch:{ Throwable -> 0x0030 }
        L_0x0029:
            r0 = r5.obj;	 Catch:{ Throwable -> 0x0030 }
            r0 = (java.lang.Runnable) r0;	 Catch:{ Throwable -> 0x0030 }
            r0.run();	 Catch:{ Throwable -> 0x0030 }
        L_0x0030:
            super.handleMessage(r5);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.AppMonitor.f.handleMessage(android.os.Message):void");
        }
    }

    static {
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
        r0 = new java.lang.Object;
        r0.<init>();
        f = r0;
        r0 = new java.util.ArrayList;
        r0.<init>();
        r0 = java.util.Collections.synchronizedList(r0);
        g = r0;
        r0 = com.alibaba.mtl.appmonitor.AppMonitor.b.Local;
        m = r0;
        r0 = "ut_c_api";	 Catch:{ Throwable -> 0x001b }
        java.lang.System.loadLibrary(r0);	 Catch:{ Throwable -> 0x001b }
    L_0x001b:
        r0 = new com.alibaba.mtl.appmonitor.f;
        r0.<init>();
        o = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.AppMonitor.<clinit>():void");
    }

    public static synchronized void a(android.app.Application r6) {
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
        r0 = com.alibaba.mtl.appmonitor.AppMonitor.class;
        monitor-enter(r0);
        r1 = "AppMonitor";	 Catch:{ all -> 0x008f }
        r2 = 1;	 Catch:{ all -> 0x008f }
        r3 = new java.lang.Object[r2];	 Catch:{ all -> 0x008f }
        r4 = "[init]";	 Catch:{ all -> 0x008f }
        r5 = 0;	 Catch:{ all -> 0x008f }
        r3[r5] = r4;	 Catch:{ all -> 0x008f }
        com.alibaba.mtl.log.e.i.a(r1, r3);	 Catch:{ all -> 0x008f }
        r1 = e;	 Catch:{ Throwable -> 0x008d }
        if (r1 != 0) goto L_0x008b;	 Catch:{ Throwable -> 0x008d }
    L_0x0014:
        b = r6;	 Catch:{ Throwable -> 0x008d }
        if (r6 == 0) goto L_0x0020;	 Catch:{ Throwable -> 0x008d }
    L_0x0018:
        r6 = b;	 Catch:{ Throwable -> 0x008d }
        r6 = r6.getApplicationContext();	 Catch:{ Throwable -> 0x008d }
        n = r6;	 Catch:{ Throwable -> 0x008d }
    L_0x0020:
        r6 = new android.os.HandlerThread;	 Catch:{ Throwable -> 0x008d }
        r1 = "AppMonitor_Client";	 Catch:{ Throwable -> 0x008d }
        r6.<init>(r1);	 Catch:{ Throwable -> 0x008d }
        d = r6;	 Catch:{ Throwable -> 0x008d }
        r6.start();	 Catch:{ Throwable -> 0x008d }
        r6 = new com.alibaba.mtl.appmonitor.AppMonitor$f;	 Catch:{ Throwable -> 0x008d }
        r1 = d;	 Catch:{ Throwable -> 0x008d }
        r1 = r1.getLooper();	 Catch:{ Throwable -> 0x008d }
        r6.<init>(r1);	 Catch:{ Throwable -> 0x008d }
        c = r6;	 Catch:{ Throwable -> 0x008d }
        r6 = m;	 Catch:{ Throwable -> 0x008d }
        r1 = com.alibaba.mtl.appmonitor.AppMonitor.b.Local;	 Catch:{ Throwable -> 0x008d }
        if (r6 != r1) goto L_0x0043;	 Catch:{ Throwable -> 0x008d }
    L_0x003f:
        l();	 Catch:{ Throwable -> 0x008d }
        goto L_0x007f;	 Catch:{ Throwable -> 0x008d }
    L_0x0043:
        r6 = b;	 Catch:{ Throwable -> 0x008d }
        if (r6 != 0) goto L_0x0049;	 Catch:{ Throwable -> 0x008d }
    L_0x0047:
        r6 = r5;	 Catch:{ Throwable -> 0x008d }
        goto L_0x0079;	 Catch:{ Throwable -> 0x008d }
    L_0x0049:
        r6 = b;	 Catch:{ Throwable -> 0x008d }
        r6 = r6.getApplicationContext();	 Catch:{ Throwable -> 0x008d }
        r1 = new android.content.Intent;	 Catch:{ Throwable -> 0x008d }
        r3 = b;	 Catch:{ Throwable -> 0x008d }
        r3 = r3.getApplicationContext();	 Catch:{ Throwable -> 0x008d }
        r4 = com.alibaba.mtl.appmonitor.AppMonitorService.class;	 Catch:{ Throwable -> 0x008d }
        r1.<init>(r3, r4);	 Catch:{ Throwable -> 0x008d }
        r3 = o;	 Catch:{ Throwable -> 0x008d }
        r6 = r6.bindService(r1, r3, r2);	 Catch:{ Throwable -> 0x008d }
        if (r6 != 0) goto L_0x0067;	 Catch:{ Throwable -> 0x008d }
    L_0x0064:
        l();	 Catch:{ Throwable -> 0x008d }
    L_0x0067:
        r1 = "AppMonitor";	 Catch:{ Throwable -> 0x008d }
        r3 = 2;	 Catch:{ Throwable -> 0x008d }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x008d }
        r4 = "bindsuccess:";	 Catch:{ Throwable -> 0x008d }
        r3[r5] = r4;	 Catch:{ Throwable -> 0x008d }
        r4 = java.lang.Boolean.valueOf(r6);	 Catch:{ Throwable -> 0x008d }
        r3[r2] = r4;	 Catch:{ Throwable -> 0x008d }
        com.alibaba.mtl.log.e.i.a(r1, r3);	 Catch:{ Throwable -> 0x008d }
    L_0x0079:
        if (r6 == 0) goto L_0x007f;	 Catch:{ Throwable -> 0x008d }
    L_0x007b:
        r6 = c;	 Catch:{ Throwable -> 0x008d }
        r6.a = r2;	 Catch:{ Throwable -> 0x008d }
    L_0x007f:
        r6 = c;	 Catch:{ Throwable -> 0x008d }
        r1 = new com.alibaba.mtl.appmonitor.h;	 Catch:{ Throwable -> 0x008d }
        r1.<init>();	 Catch:{ Throwable -> 0x008d }
        r6.a(r1);	 Catch:{ Throwable -> 0x008d }
        e = r2;	 Catch:{ Throwable -> 0x008d }
    L_0x008b:
        monitor-exit(r0);
        return;
    L_0x008d:
        monitor-exit(r0);
        return;
    L_0x008f:
        r6 = move-exception;
        monitor-exit(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.AppMonitor.a(android.app.Application):void");
    }

    public static void a(int i) {
        if (m()) {
            c.a(new a(i));
        }
    }

    public static void a() {
        if (m()) {
            c.a(new b());
        }
    }

    public static void a(java.lang.String r2, java.lang.String r3, com.alibaba.mtl.appmonitor.model.MeasureSet r4, com.alibaba.mtl.appmonitor.model.DimensionSet r5) {
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
        r0 = m();
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = new com.alibaba.mtl.appmonitor.c;
        r0.<init>(r2, r3, r4, r5);
        r1 = c;
        r1.a(r0);
        r0 = new com.alibaba.mtl.appmonitor.AppMonitor$e;	 Catch:{ Throwable -> 0x0027 }
        r0.<init>();	 Catch:{ Throwable -> 0x0027 }
        r0.a = r2;	 Catch:{ Throwable -> 0x0027 }
        r0.b = r3;	 Catch:{ Throwable -> 0x0027 }
        r0.c = r4;	 Catch:{ Throwable -> 0x0027 }
        r0.d = r5;	 Catch:{ Throwable -> 0x0027 }
        r2 = 0;	 Catch:{ Throwable -> 0x0027 }
        r0.e = r2;	 Catch:{ Throwable -> 0x0027 }
        r2 = g;	 Catch:{ Throwable -> 0x0027 }
        r2.add(r0);	 Catch:{ Throwable -> 0x0027 }
        return;
    L_0x0027:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.AppMonitor.a(java.lang.String, java.lang.String, com.alibaba.mtl.appmonitor.model.MeasureSet, com.alibaba.mtl.appmonitor.model.DimensionSet):void");
    }

    public static void a(boolean z, String str, String str2, String str3) {
        if (m()) {
            c.a(b(z, str, str2, str3));
            k = z;
            j = str;
            l = str2;
            p = str3;
        }
    }

    public static void a(String str) {
        if (m()) {
            c.a(b(str));
            i = str;
        }
    }

    public static void a(Map<String, String> map) {
        if (m()) {
            c.a(new d(map));
        }
    }

    public static void b() {
        if (m()) {
            c.a(new e());
        }
    }

    private static synchronized void k() {
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
        r0 = com.alibaba.mtl.appmonitor.AppMonitor.class;
        monitor-enter(r0);
        r1 = "AppMonitor";	 Catch:{ all -> 0x006e }
        r2 = 1;	 Catch:{ all -> 0x006e }
        r2 = new java.lang.Object[r2];	 Catch:{ all -> 0x006e }
        r3 = "[restart]";	 Catch:{ all -> 0x006e }
        r4 = 0;	 Catch:{ all -> 0x006e }
        r2[r4] = r3;	 Catch:{ all -> 0x006e }
        com.alibaba.mtl.log.e.i.a(r1, r2);	 Catch:{ all -> 0x006e }
        r1 = h;	 Catch:{ Throwable -> 0x006c }
        if (r1 == 0) goto L_0x006a;	 Catch:{ Throwable -> 0x006c }
    L_0x0014:
        h = r4;	 Catch:{ Throwable -> 0x006c }
        l();	 Catch:{ Throwable -> 0x006c }
        r1 = new com.alibaba.mtl.appmonitor.h;	 Catch:{ Throwable -> 0x006c }
        r1.<init>();	 Catch:{ Throwable -> 0x006c }
        r1.run();	 Catch:{ Throwable -> 0x006c }
        r1 = k;	 Catch:{ Throwable -> 0x006c }
        r2 = j;	 Catch:{ Throwable -> 0x006c }
        r3 = l;	 Catch:{ Throwable -> 0x006c }
        r5 = p;	 Catch:{ Throwable -> 0x006c }
        r1 = b(r1, r2, r3, r5);	 Catch:{ Throwable -> 0x006c }
        r1.run();	 Catch:{ Throwable -> 0x006c }
        r1 = i;	 Catch:{ Throwable -> 0x006c }
        r1 = b(r1);	 Catch:{ Throwable -> 0x006c }
        r1.run();	 Catch:{ Throwable -> 0x006c }
        r1 = g;	 Catch:{ Throwable -> 0x006c }
        monitor-enter(r1);	 Catch:{ Throwable -> 0x006c }
    L_0x003c:
        r2 = g;	 Catch:{ all -> 0x0067 }
        r2 = r2.size();	 Catch:{ all -> 0x0067 }
        if (r4 >= r2) goto L_0x0064;	 Catch:{ all -> 0x0067 }
    L_0x0044:
        r2 = g;	 Catch:{ all -> 0x0067 }
        r2 = r2.get(r4);	 Catch:{ all -> 0x0067 }
        r2 = (com.alibaba.mtl.appmonitor.AppMonitor.e) r2;	 Catch:{ all -> 0x0067 }
        if (r2 == 0) goto L_0x0061;
    L_0x004e:
        r6 = r2.a;	 Catch:{ Throwable -> 0x0061 }
        r7 = r2.b;	 Catch:{ Throwable -> 0x0061 }
        r8 = r2.c;	 Catch:{ Throwable -> 0x0061 }
        r9 = r2.d;	 Catch:{ Throwable -> 0x0061 }
        r10 = r2.e;	 Catch:{ Throwable -> 0x0061 }
        r2 = new com.alibaba.mtl.appmonitor.k;	 Catch:{ Throwable -> 0x0061 }
        r5 = r2;	 Catch:{ Throwable -> 0x0061 }
        r5.<init>(r6, r7, r8, r9, r10);	 Catch:{ Throwable -> 0x0061 }
        r2.run();	 Catch:{ Throwable -> 0x0061 }
    L_0x0061:
        r4 = r4 + 1;
        goto L_0x003c;
    L_0x0064:
        monitor-exit(r1);	 Catch:{ all -> 0x0067 }
        monitor-exit(r0);
        return;
    L_0x0067:
        r2 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0067 }
        throw r2;	 Catch:{ Throwable -> 0x006c }
    L_0x006a:
        monitor-exit(r0);
        return;
    L_0x006c:
        monitor-exit(r0);
        return;
    L_0x006e:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.AppMonitor.k():void");
    }

    private static void l() {
        a = new s(b);
        m = b.Local;
        i.b("AppMonitor", "Start AppMonitor Service failed,AppMonitor run in local Mode...");
    }

    private static boolean m() {
        if (!e) {
            i.a("AppMonitor", "Please call init() before call other method");
        }
        return e;
    }

    private static Runnable b(boolean z, String str, String str2, String str3) {
        return new i(z, str, str2, str3);
    }

    private static Runnable b(String str) {
        return new j(str);
    }

    static /* synthetic */ void a(Exception exception) {
        i.a("AppMonitor", (Object) "");
        if ((exception instanceof DeadObjectException) != null) {
            k();
        }
    }
}
