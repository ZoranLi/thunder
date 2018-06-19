package com.igexin.push.core;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.Message;
import com.igexin.b.a.b.c;
import com.igexin.b.a.d.a.b;
import com.igexin.b.a.d.a.e;
import com.igexin.push.e.j;
import com.igexin.push.f.b.h;
import com.igexin.push.util.a;
import com.igexin.sdk.PushConsts;
import com.igexin.sdk.a.d;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class f implements b {
    private static f l;
    private Context a;
    private h b = new h();
    private Handler c;
    private ConcurrentLinkedQueue<Message> d = new ConcurrentLinkedQueue();
    private com.igexin.push.core.a.f e;
    private ConnectivityManager f;
    private c g;
    private com.igexin.b.a.b.b h;
    private j i;
    private com.igexin.push.e.c j;
    private com.igexin.push.b.b k;
    private final int m = 100;
    private final int n = 30;
    private final AtomicBoolean o = new AtomicBoolean(false);

    private f() {
    }

    public static f a() {
        if (l == null) {
            l = new f();
        }
        return l;
    }

    private void q() {
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
        r8 = this;
        r0 = com.igexin.push.config.m.p;	 Catch:{ Throwable -> 0x0073 }
        if (r0 == 0) goto L_0x0073;	 Catch:{ Throwable -> 0x0073 }
    L_0x0004:
        r0 = r8.p();	 Catch:{ Throwable -> 0x0073 }
        if (r0 != 0) goto L_0x000b;	 Catch:{ Throwable -> 0x0073 }
    L_0x000a:
        return;	 Catch:{ Throwable -> 0x0073 }
    L_0x000b:
        r0 = r8.a;	 Catch:{ Throwable -> 0x0073 }
        r0 = r0.getPackageName();	 Catch:{ Throwable -> 0x0073 }
        r1 = r8.a;	 Catch:{ Throwable -> 0x0073 }
        r1 = r1.getPackageManager();	 Catch:{ Throwable -> 0x0073 }
        r2 = 4;	 Catch:{ Throwable -> 0x0073 }
        r1 = r1.getInstalledPackages(r2);	 Catch:{ Throwable -> 0x0073 }
        if (r1 == 0) goto L_0x0073;	 Catch:{ Throwable -> 0x0073 }
    L_0x001e:
        r2 = r1.isEmpty();	 Catch:{ Throwable -> 0x0073 }
        if (r2 == 0) goto L_0x0025;	 Catch:{ Throwable -> 0x0073 }
    L_0x0024:
        return;	 Catch:{ Throwable -> 0x0073 }
    L_0x0025:
        r1 = r1.iterator();	 Catch:{ Throwable -> 0x0073 }
    L_0x0029:
        r2 = r1.hasNext();	 Catch:{ Throwable -> 0x0073 }
        if (r2 == 0) goto L_0x0073;	 Catch:{ Throwable -> 0x0073 }
    L_0x002f:
        r2 = r1.next();	 Catch:{ Throwable -> 0x0073 }
        r2 = (android.content.pm.PackageInfo) r2;	 Catch:{ Throwable -> 0x0073 }
        r3 = r2.applicationInfo;	 Catch:{ Throwable -> 0x0073 }
        r3 = r3.flags;	 Catch:{ Throwable -> 0x0073 }
        r3 = r3 & 1;	 Catch:{ Throwable -> 0x0073 }
        if (r3 == 0) goto L_0x0045;	 Catch:{ Throwable -> 0x0073 }
    L_0x003d:
        r3 = r2.applicationInfo;	 Catch:{ Throwable -> 0x0073 }
        r3 = r3.flags;	 Catch:{ Throwable -> 0x0073 }
        r3 = r3 & 128;	 Catch:{ Throwable -> 0x0073 }
        if (r3 == 0) goto L_0x0029;	 Catch:{ Throwable -> 0x0073 }
    L_0x0045:
        r3 = r2.services;	 Catch:{ Throwable -> 0x0073 }
        if (r3 == 0) goto L_0x0029;	 Catch:{ Throwable -> 0x0073 }
    L_0x0049:
        r4 = r3.length;	 Catch:{ Throwable -> 0x0073 }
        if (r4 == 0) goto L_0x0029;	 Catch:{ Throwable -> 0x0073 }
    L_0x004c:
        r4 = r3.length;	 Catch:{ Throwable -> 0x0073 }
        r5 = 0;	 Catch:{ Throwable -> 0x0073 }
    L_0x004e:
        if (r5 >= r4) goto L_0x0029;	 Catch:{ Throwable -> 0x0073 }
    L_0x0050:
        r6 = r3[r5];	 Catch:{ Throwable -> 0x0073 }
        r7 = com.igexin.push.util.a.a(r6, r2);	 Catch:{ Throwable -> 0x0073 }
        if (r7 == 0) goto L_0x0070;	 Catch:{ Throwable -> 0x0073 }
    L_0x0058:
        r3 = r2.packageName;	 Catch:{ Throwable -> 0x0073 }
        r3 = r0.equals(r3);	 Catch:{ Throwable -> 0x0073 }
        if (r3 != 0) goto L_0x0029;	 Catch:{ Throwable -> 0x0073 }
    L_0x0060:
        r3 = com.igexin.push.core.b.g.a();	 Catch:{ Throwable -> 0x0073 }
        r3 = r3.d();	 Catch:{ Throwable -> 0x0073 }
        r2 = r2.packageName;	 Catch:{ Throwable -> 0x0073 }
        r4 = r6.name;	 Catch:{ Throwable -> 0x0073 }
        r3.put(r2, r4);	 Catch:{ Throwable -> 0x0073 }
        goto L_0x0029;
    L_0x0070:
        r5 = r5 + 1;
        goto L_0x004e;
    L_0x0073:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.f.q():void");
    }

    private boolean r() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        intentFilter.addAction("com.igexin.sdk.action.snlrefresh");
        intentFilter.addAction("com.igexin.sdk.action.snlretire");
        intentFilter.addAction(g.V);
        intentFilter.addAction("com.igexin.sdk.action.execute");
        intentFilter.addAction("com.igexin.sdk.action.doaction");
        intentFilter.addAction("android.intent.action.TIME_SET");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        if (a.c()) {
            intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        }
        if (this.a.registerReceiver(n.a(), intentFilter) == null) {
            com.igexin.b.a.c.a.b("CoreLogic|InternalPublicReceiver|Failed");
        }
        intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        if (this.a.registerReceiver(m.a(), intentFilter) == null) {
            com.igexin.b.a.c.a.b("CoreLogic|InternalPackageReceiver|Failed");
        }
        return true;
    }

    public void a(e eVar) {
        this.c = eVar;
    }

    public boolean a(Context context) {
        this.a = context;
        if (this.b == null || !this.b.isAlive()) {
            if (!this.o.getAndSet(true)) {
                com.igexin.b.a.c.a.b("CoreLogic|start coreThread +++++");
                this.b.start();
            }
            return true;
        }
        com.igexin.b.a.c.a.b("CoreLogic|coreThread is alive +++++");
        return true;
    }

    public boolean a(Message message) {
        if (g.g.get()) {
            this.c.sendMessage(message);
        } else {
            this.d.add(message);
        }
        return true;
    }

    public boolean a(e eVar, com.igexin.b.a.d.f fVar) {
        return this.e != null && this.e.a((Object) eVar);
    }

    public boolean a(com.igexin.b.a.d.e eVar, com.igexin.b.a.d.f fVar) {
        return this.e != null && this.e.a(eVar);
    }

    public boolean a(h hVar) {
        return hVar != null && c.b().a(hVar, false, true);
    }

    public boolean a(java.lang.String r8) {
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
        r7 = this;
        r8 = com.igexin.push.core.a.f.a();
        r0 = "ss";
        r8 = r8.c(r0);
        r0 = com.igexin.push.core.g.f;
        r1 = 1;
        if (r0 == 0) goto L_0x0097;
    L_0x000f:
        r0 = r7.j;
        if (r0 == 0) goto L_0x0097;
    L_0x0013:
        r0 = new com.igexin.sdk.a.d;
        r2 = com.igexin.push.core.g.f;
        r0.<init>(r2);
        r0.b();
        r0 = 0;
        com.igexin.push.core.g.i = r0;
        com.igexin.push.core.g.m = r0;
        r0 = new com.igexin.push.e.a;
        r0.<init>();
        r2 = com.igexin.push.core.c.g;
        r0.a(r2);
        r2 = r7.j;
        r2.a(r0);
        if (r8 == 0) goto L_0x0097;
    L_0x0033:
        r0 = "1";
        r8 = r0.equals(r8);
        if (r8 == 0) goto L_0x0097;
    L_0x003b:
        r8 = "ps";
        r0 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x0094 }
        r8 = r0.exec(r8);	 Catch:{ Exception -> 0x0094 }
        r8 = r8.getInputStream();	 Catch:{ Exception -> 0x0094 }
        if (r8 == 0) goto L_0x0094;	 Catch:{ Exception -> 0x0094 }
    L_0x004b:
        r0 = com.igexin.push.core.g.f;	 Catch:{ Exception -> 0x0094 }
        r0 = r0.getPackageName();	 Catch:{ Exception -> 0x0094 }
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0094 }
        r3 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0094 }
        r3.<init>(r8);	 Catch:{ Exception -> 0x0094 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0094 }
    L_0x005b:
        r3 = r2.readLine();	 Catch:{ Exception -> 0x0094 }
        if (r3 == 0) goto L_0x008e;	 Catch:{ Exception -> 0x0094 }
    L_0x0061:
        r4 = "\\s+";	 Catch:{ Exception -> 0x0094 }
        r4 = r3.split(r4);	 Catch:{ Exception -> 0x0094 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0094 }
        r5.<init>();	 Catch:{ Exception -> 0x0094 }
        r5.append(r0);	 Catch:{ Exception -> 0x0094 }
        r6 = "/files/gdaemon";	 Catch:{ Exception -> 0x0094 }
        r5.append(r6);	 Catch:{ Exception -> 0x0094 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0094 }
        r3 = r3.contains(r5);	 Catch:{ Exception -> 0x0094 }
        if (r3 == 0) goto L_0x005b;	 Catch:{ Exception -> 0x0094 }
    L_0x007e:
        r3 = r4.length;	 Catch:{ Exception -> 0x0094 }
        if (r3 <= 0) goto L_0x005b;	 Catch:{ Exception -> 0x0094 }
    L_0x0081:
        r0 = r4[r1];	 Catch:{ Exception -> 0x0094 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x0094 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x0094 }
        android.os.Process.killProcess(r0);	 Catch:{ Exception -> 0x0094 }
    L_0x008e:
        r2.close();	 Catch:{ Exception -> 0x0094 }
        r8.close();	 Catch:{ Exception -> 0x0094 }
    L_0x0094:
        r7.e();
    L_0x0097:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.f.a(java.lang.String):boolean");
    }

    public boolean a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("CoreLogic|start sdkSwitch isSlave = ");
        stringBuilder.append(z);
        com.igexin.b.a.c.a.b(stringBuilder.toString());
        if (!(g.f == null || this.j == null)) {
            new d(g.f).a();
            g.i = true;
            if (!new com.igexin.sdk.a.b(g.f).b()) {
                new com.igexin.sdk.a.c(g.f).a();
                g.j = true;
                new com.igexin.sdk.a.b(g.f).a();
            }
            if (z) {
                new com.igexin.sdk.a.c(g.f).a();
                g.j = true;
            }
            com.igexin.b.a.c.a.b("CoreLogic|snlCoordinator.doEvent start ++++");
            com.igexin.push.e.a aVar = new com.igexin.push.e.a();
            aVar.a(c.a);
            this.j.a(aVar);
        }
        return true;
    }

    public void b() {
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
        r5 = this;
        r0 = new com.igexin.push.b.b;	 Catch:{ Throwable -> 0x0133 }
        r1 = r5.a;	 Catch:{ Throwable -> 0x0133 }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0133 }
        r5.k = r0;	 Catch:{ Throwable -> 0x0133 }
        r0 = r5.a;	 Catch:{ Throwable -> 0x0133 }
        r1 = "connectivity";	 Catch:{ Throwable -> 0x0133 }
        r0 = r0.getSystemService(r1);	 Catch:{ Throwable -> 0x0133 }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ Throwable -> 0x0133 }
        r5.f = r0;	 Catch:{ Throwable -> 0x0133 }
        r0 = r5.a;	 Catch:{ Throwable -> 0x0133 }
        com.igexin.push.core.g.a(r0);	 Catch:{ Throwable -> 0x0133 }
        r0 = com.igexin.push.config.k.a();	 Catch:{ Throwable -> 0x0133 }
        r0.b();	 Catch:{ Throwable -> 0x0133 }
        r5.r();	 Catch:{ Throwable -> 0x0133 }
        r0 = com.igexin.b.a.b.c.b();	 Catch:{ Throwable -> 0x0133 }
        r5.g = r0;	 Catch:{ Throwable -> 0x0133 }
        r0 = new com.igexin.push.d.a;	 Catch:{ Throwable -> 0x0133 }
        r1 = r5.a;	 Catch:{ Throwable -> 0x0133 }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0133 }
        r1 = r5.g;	 Catch:{ Throwable -> 0x0133 }
        r1.a(r0);	 Catch:{ Throwable -> 0x0133 }
        r0 = r5.g;	 Catch:{ Throwable -> 0x0133 }
        r0.a(r5);	 Catch:{ Throwable -> 0x0133 }
        r0 = r5.g;	 Catch:{ Throwable -> 0x0133 }
        r1 = r5.a;	 Catch:{ Throwable -> 0x0133 }
        r0.a(r1);	 Catch:{ Throwable -> 0x0133 }
        r0 = new com.igexin.push.b.a;	 Catch:{ Throwable -> 0x0133 }
        r0.<init>();	 Catch:{ Throwable -> 0x0133 }
        r1 = com.igexin.push.core.b.g.a();	 Catch:{ Throwable -> 0x0133 }
        r0.a(r1);	 Catch:{ Throwable -> 0x0133 }
        r1 = com.igexin.push.core.b.d.a();	 Catch:{ Throwable -> 0x0133 }
        r0.a(r1);	 Catch:{ Throwable -> 0x0133 }
        r1 = com.igexin.push.core.b.b.a();	 Catch:{ Throwable -> 0x0133 }
        r0.a(r1);	 Catch:{ Throwable -> 0x0133 }
        r1 = com.igexin.push.config.a.a();	 Catch:{ Throwable -> 0x0133 }
        r0.a(r1);	 Catch:{ Throwable -> 0x0133 }
        r1 = com.igexin.push.core.b.af.a();	 Catch:{ Throwable -> 0x0133 }
        r0.a(r1);	 Catch:{ Throwable -> 0x0133 }
        r1 = r5.g;	 Catch:{ Throwable -> 0x0133 }
        r2 = 0;	 Catch:{ Throwable -> 0x0133 }
        r3 = 1;	 Catch:{ Throwable -> 0x0133 }
        r1.a(r0, r3, r2);	 Catch:{ Throwable -> 0x0133 }
        r0 = com.igexin.b.a.b.c.b();	 Catch:{ Throwable -> 0x0133 }
        r1 = com.igexin.push.core.g.B;	 Catch:{ Throwable -> 0x0133 }
        r1 = r1.getBytes();	 Catch:{ Throwable -> 0x0133 }
        r1 = com.igexin.b.b.a.a(r1);	 Catch:{ Throwable -> 0x0133 }
        r0.a(r1);	 Catch:{ Throwable -> 0x0133 }
        r0 = r5.g;	 Catch:{ Throwable -> 0x0133 }
        r1 = com.igexin.push.f.b.c.g();	 Catch:{ Throwable -> 0x0133 }
        r0 = r0.a(r1, r2, r3);	 Catch:{ Throwable -> 0x0133 }
        com.igexin.push.core.g.af = r0;	 Catch:{ Throwable -> 0x0133 }
        r0 = r5.g;	 Catch:{ Throwable -> 0x0133 }
        r1 = com.igexin.push.f.b.g.g();	 Catch:{ Throwable -> 0x0133 }
        r0 = r0.a(r1, r3, r3);	 Catch:{ Throwable -> 0x0133 }
        com.igexin.push.core.g.ag = r0;	 Catch:{ Throwable -> 0x0133 }
        r0 = com.igexin.push.c.i.a();	 Catch:{ Throwable -> 0x0133 }
        r0.c();	 Catch:{ Throwable -> 0x0133 }
        r5.c();	 Catch:{ Throwable -> 0x0133 }
        r0 = com.igexin.push.core.a.f.a();	 Catch:{ Throwable -> 0x0133 }
        r5.e = r0;	 Catch:{ Throwable -> 0x0133 }
        r5.d();	 Catch:{ Throwable -> 0x0133 }
        r0 = new com.igexin.push.e.j;	 Catch:{ Throwable -> 0x0133 }
        r0.<init>();	 Catch:{ Throwable -> 0x0133 }
        r5.i = r0;	 Catch:{ Throwable -> 0x0133 }
        r0 = r5.i;	 Catch:{ Throwable -> 0x0133 }
        r1 = r5.a;	 Catch:{ Throwable -> 0x0133 }
        r2 = r5.g;	 Catch:{ Throwable -> 0x0133 }
        r4 = r5.e;	 Catch:{ Throwable -> 0x0133 }
        r0.a(r1, r2, r4);	 Catch:{ Throwable -> 0x0133 }
        r0 = new com.igexin.push.e.c;	 Catch:{ Throwable -> 0x0133 }
        r0.<init>();	 Catch:{ Throwable -> 0x0133 }
        r5.j = r0;	 Catch:{ Throwable -> 0x0133 }
        r0 = r5.j;	 Catch:{ Throwable -> 0x0133 }
        r1 = r5.a;	 Catch:{ Throwable -> 0x0133 }
        r0.a(r1);	 Catch:{ Throwable -> 0x0133 }
        r0 = new com.igexin.push.e.a;	 Catch:{ Throwable -> 0x0133 }
        r0.<init>();	 Catch:{ Throwable -> 0x0133 }
        r1 = com.igexin.push.core.c.a;	 Catch:{ Throwable -> 0x0133 }
        r0.a(r1);	 Catch:{ Throwable -> 0x0133 }
        r1 = r5.j;	 Catch:{ Throwable -> 0x0133 }
        r1.a(r0);	 Catch:{ Throwable -> 0x0133 }
        r0 = com.igexin.push.a.a.c.c();	 Catch:{ Throwable -> 0x0133 }
        r0.d();	 Catch:{ Throwable -> 0x0133 }
        r0 = com.igexin.push.core.g.g;	 Catch:{ Throwable -> 0x0133 }
        r0.set(r3);	 Catch:{ Throwable -> 0x0133 }
        r0 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x0133 }
        r1 = r5.e;	 Catch:{ Throwable -> 0x0133 }
        r1.a(r0);	 Catch:{ Throwable -> 0x0133 }
        r5.q();	 Catch:{ Throwable -> 0x0133 }
        r0 = com.igexin.push.extension.a.a();	 Catch:{ Throwable -> 0x0133 }
        r1 = r5.a;	 Catch:{ Throwable -> 0x0133 }
        r0.a(r1);	 Catch:{ Throwable -> 0x0133 }
        r0 = r5.d;	 Catch:{ Throwable -> 0x0133 }
        r0 = r0.iterator();	 Catch:{ Throwable -> 0x0133 }
    L_0x0103:
        r1 = r0.hasNext();	 Catch:{ Throwable -> 0x0133 }
        if (r1 == 0) goto L_0x0119;	 Catch:{ Throwable -> 0x0133 }
    L_0x0109:
        r1 = r0.next();	 Catch:{ Throwable -> 0x0133 }
        r1 = (android.os.Message) r1;	 Catch:{ Throwable -> 0x0133 }
        r2 = r5.c;	 Catch:{ Throwable -> 0x0133 }
        if (r2 == 0) goto L_0x0103;	 Catch:{ Throwable -> 0x0133 }
    L_0x0113:
        r2 = r5.c;	 Catch:{ Throwable -> 0x0133 }
        r2.sendMessage(r1);	 Catch:{ Throwable -> 0x0133 }
        goto L_0x0103;	 Catch:{ Throwable -> 0x0133 }
    L_0x0119:
        r0 = com.igexin.push.core.a.f.a();	 Catch:{ Throwable -> 0x0133 }
        r0.s();	 Catch:{ Throwable -> 0x0133 }
        r0 = com.igexin.assist.sdk.AssistPushManager.getInstance();	 Catch:{ Throwable -> 0x0132 }
        r1 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x0132 }
        r0.initialize(r1);	 Catch:{ Throwable -> 0x0132 }
        r0 = com.igexin.assist.sdk.AssistPushManager.getInstance();	 Catch:{ Throwable -> 0x0132 }
        r1 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x0132 }
        r0.register(r1);	 Catch:{ Throwable -> 0x0132 }
    L_0x0132:
        return;
    L_0x0133:
        r0 = move-exception;
        r1 = new java.lang.StringBuilder;
        r2 = "CoreLogic|init|failed|";
        r1.<init>(r2);
        r0 = r0.toString();
        r1.append(r0);
        r0 = r1.toString();
        com.igexin.b.a.c.a.b(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.f.b():void");
    }

    public boolean b(String str) {
        if (!(g.f == null || this.j == null)) {
            new com.igexin.sdk.a.c(g.f).b();
            g.j = false;
            g.m = false;
            com.igexin.push.e.a aVar = new com.igexin.push.e.a();
            aVar.a(c.g);
            this.j.a(aVar);
        }
        return true;
    }

    public com.igexin.push.f.b.a c() {
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
        r0 = com.igexin.push.f.b.a.g();
        r1 = new com.igexin.push.a.a.a;
        r1.<init>();
        r0.a(r1);
        r1 = new com.igexin.push.a.a.b;
        r1.<init>();
        r0.a(r1);
        r1 = new com.igexin.push.a.a.d;
        r1.<init>();
        r0.a(r1);
        r1 = com.igexin.push.a.a.c.c();
        r0.a(r1);
        r1 = r4.g;
        r2 = 0;
        r3 = 1;
        r1 = r1.a(r0, r2, r3);
        com.igexin.push.core.g.ah = r1;
        r1 = r4.a;	 Catch:{ Throwable -> 0x0037 }
        r2 = new android.content.Intent;	 Catch:{ Throwable -> 0x0037 }
        r2.<init>();	 Catch:{ Throwable -> 0x0037 }
        r1.sendBroadcast(r2);	 Catch:{ Throwable -> 0x0037 }
    L_0x0037:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.f.c():com.igexin.push.f.b.a");
    }

    public void d() {
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
        r0 = com.igexin.push.core.g.w;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return;
    L_0x0009:
        r0 = com.igexin.push.util.a.a();	 Catch:{ Throwable -> 0x003d }
        if (r0 == 0) goto L_0x003d;	 Catch:{ Throwable -> 0x003d }
    L_0x000f:
        r0 = r2.a;	 Catch:{ Throwable -> 0x003d }
        r1 = "wifi";	 Catch:{ Throwable -> 0x003d }
        r0 = r0.getSystemService(r1);	 Catch:{ Throwable -> 0x003d }
        r0 = (android.net.wifi.WifiManager) r0;	 Catch:{ Throwable -> 0x003d }
        r0 = r0.getConnectionInfo();	 Catch:{ Throwable -> 0x003d }
        if (r0 == 0) goto L_0x002a;	 Catch:{ Throwable -> 0x003d }
    L_0x001f:
        r1 = com.igexin.push.core.b.g.a();	 Catch:{ Throwable -> 0x003d }
        r0 = r0.getMacAddress();	 Catch:{ Throwable -> 0x003d }
        r1.a(r0);	 Catch:{ Throwable -> 0x003d }
    L_0x002a:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x003d }
        r1 = "CoreLogic mac:";	 Catch:{ Throwable -> 0x003d }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x003d }
        r1 = com.igexin.push.core.g.w;	 Catch:{ Throwable -> 0x003d }
        r0.append(r1);	 Catch:{ Throwable -> 0x003d }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x003d }
        com.igexin.b.a.c.a.b(r0);	 Catch:{ Throwable -> 0x003d }
    L_0x003d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.f.d():void");
    }

    public void e() {
        this.a.stopService(new Intent(this.a, com.igexin.push.core.a.f.a().a(g.f)));
    }

    public com.igexin.b.a.b.b f() {
        if (this.h == null) {
            this.h = com.igexin.push.d.a.b.a();
        }
        return this.h;
    }

    public j g() {
        return this.i;
    }

    public com.igexin.push.e.c h() {
        return this.j;
    }

    public com.igexin.push.core.a.f i() {
        return this.e;
    }

    public ConnectivityManager j() {
        return this.f;
    }

    public com.igexin.push.b.b k() {
        return this.k;
    }

    public void l() {
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
        r0 = r2.a;	 Catch:{ Exception -> 0x0009 }
        r1 = com.igexin.b.a.b.c.b();	 Catch:{ Exception -> 0x0009 }
        r0.unregisterReceiver(r1);	 Catch:{ Exception -> 0x0009 }
    L_0x0009:
        r0 = r2.a;	 Catch:{ Exception -> 0x0012 }
        r1 = com.igexin.push.core.m.a();	 Catch:{ Exception -> 0x0012 }
        r0.unregisterReceiver(r1);	 Catch:{ Exception -> 0x0012 }
    L_0x0012:
        r0 = r2.a;	 Catch:{ Exception -> 0x001b }
        r1 = com.igexin.push.core.n.a();	 Catch:{ Exception -> 0x001b }
        r0.unregisterReceiver(r1);	 Catch:{ Exception -> 0x001b }
    L_0x001b:
        r0 = com.igexin.push.extension.a.a();	 Catch:{ Throwable -> 0x0022 }
        r0.b();	 Catch:{ Throwable -> 0x0022 }
    L_0x0022:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.f.l():void");
    }

    public String m() {
        if (this.f == null) {
            return null;
        }
        NetworkInfo activeNetworkInfo = this.f.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            if (activeNetworkInfo.getType() == 0) {
                return "mobile";
            }
        }
        return null;
    }

    public boolean n() {
        return true;
    }

    public long o() {
        return 94808;
    }

    public boolean p() {
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
        r11 = this;
        r0 = 0;
        r1 = com.igexin.push.core.g.f;	 Catch:{ Throwable -> 0x0062 }
        r2 = "activity";	 Catch:{ Throwable -> 0x0062 }
        r1 = r1.getSystemService(r2);	 Catch:{ Throwable -> 0x0062 }
        r1 = (android.app.ActivityManager) r1;	 Catch:{ Throwable -> 0x0062 }
        r2 = new android.app.ActivityManager$MemoryInfo;	 Catch:{ Throwable -> 0x0062 }
        r2.<init>();	 Catch:{ Throwable -> 0x0062 }
        r1.getMemoryInfo(r2);	 Catch:{ Throwable -> 0x0062 }
        r3 = r2.availMem;	 Catch:{ Throwable -> 0x0062 }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ Throwable -> 0x0062 }
        r3 = r3 / r5;	 Catch:{ Throwable -> 0x0062 }
        r3 = r3 / r5;	 Catch:{ Throwable -> 0x0062 }
        r1 = r2.lowMemory;	 Catch:{ Throwable -> 0x0062 }
        if (r1 == 0) goto L_0x0036;	 Catch:{ Throwable -> 0x0062 }
    L_0x001d:
        r1 = "CoreLogic";	 Catch:{ Throwable -> 0x0062 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0062 }
        r5 = "system in lowMemory, available menmory = ";	 Catch:{ Throwable -> 0x0062 }
        r2.<init>(r5);	 Catch:{ Throwable -> 0x0062 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0062 }
        r3 = "M";	 Catch:{ Throwable -> 0x0062 }
        r2.append(r3);	 Catch:{ Throwable -> 0x0062 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0062 }
        com.igexin.b.a.c.a.b(r1, r2);	 Catch:{ Throwable -> 0x0062 }
        return r0;	 Catch:{ Throwable -> 0x0062 }
    L_0x0036:
        r1 = 100;	 Catch:{ Throwable -> 0x0062 }
        r7 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1));	 Catch:{ Throwable -> 0x0062 }
        if (r7 >= 0) goto L_0x003d;	 Catch:{ Throwable -> 0x0062 }
    L_0x003c:
        return r0;	 Catch:{ Throwable -> 0x0062 }
    L_0x003d:
        r1 = java.lang.Runtime.getRuntime();	 Catch:{ Throwable -> 0x0062 }
        r1 = r1.maxMemory();	 Catch:{ Throwable -> 0x0062 }
        r3 = java.lang.Runtime.getRuntime();	 Catch:{ Throwable -> 0x0062 }
        r3 = r3.totalMemory();	 Catch:{ Throwable -> 0x0062 }
        r7 = java.lang.Runtime.getRuntime();	 Catch:{ Throwable -> 0x0062 }
        r7 = r7.freeMemory();	 Catch:{ Throwable -> 0x0062 }
        r9 = r1 - r3;	 Catch:{ Throwable -> 0x0062 }
        r1 = r9 + r7;	 Catch:{ Throwable -> 0x0062 }
        r1 = r1 / r5;	 Catch:{ Throwable -> 0x0062 }
        r1 = r1 / r5;	 Catch:{ Throwable -> 0x0062 }
        r3 = 30;
        r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1));
        if (r5 <= 0) goto L_0x0062;
    L_0x0061:
        r0 = 1;
    L_0x0062:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.f.p():boolean");
    }
}
