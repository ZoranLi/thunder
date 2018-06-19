package com.alibaba.mtl.log;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.mtl.log.c.c;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import com.alibaba.mtl.log.f.b;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: UTDC */
public final class a {
    public static boolean a = false;
    public static int b = 10000;
    public static int c = 0;
    public static long d = -1;
    public static boolean e = false;
    public static String f = String.valueOf(System.currentTimeMillis());
    public static final AtomicInteger g = new AtomicInteger(0);
    public static boolean h = true;
    public static b i = null;
    private static Context j = null;
    private static boolean k = false;
    private static boolean l = (c <= b);

    public static String g() {
        return "";
    }

    public static String h() {
        return "";
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(android.content.Context r4) {
        /*
        r0 = com.alibaba.mtl.log.a.class;
        monitor-enter(r0);
        if (r4 != 0) goto L_0x001c;
    L_0x0005:
        r1 = "UTDC";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x001a }
        r3 = "UTDC init failed ,context:";
        r2.<init>(r3);	 Catch:{ all -> 0x001a }
        r2.append(r4);	 Catch:{ all -> 0x001a }
        r4 = r2.toString();	 Catch:{ all -> 0x001a }
        com.alibaba.mtl.log.e.i.b(r1, r4);	 Catch:{ all -> 0x001a }
        monitor-exit(r0);
        return;
    L_0x001a:
        r4 = move-exception;
        goto L_0x0032;
    L_0x001c:
        r1 = k;	 Catch:{ all -> 0x001a }
        if (r1 != 0) goto L_0x0030;
    L_0x0020:
        r1 = 1;
        k = r1;	 Catch:{ all -> 0x001a }
        r4 = r4.getApplicationContext();	 Catch:{ all -> 0x001a }
        j = r4;	 Catch:{ all -> 0x001a }
        r4 = com.alibaba.mtl.log.d.a.a();	 Catch:{ all -> 0x001a }
        r4.b();	 Catch:{ all -> 0x001a }
    L_0x0030:
        monitor-exit(r0);
        return;
    L_0x0032:
        monitor-exit(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.a.a(android.content.Context):void");
    }

    public static void a(b bVar) {
        i = bVar;
        com.alibaba.mtl.log.e.b.b(bVar.a());
    }

    public static void a(String str) {
        com.alibaba.mtl.log.e.b.a(str);
    }

    public static void a() {
        i.a("UTDC", "[onBackground]");
        a = true;
        com.alibaba.mtl.log.b.a.k();
    }

    public static void b() {
        i.a("UTDC", "[onForeground]");
        a = false;
        com.alibaba.mtl.log.d.a.a().b();
    }

    public static void a(String str, String str2, String str3, String str4, String str5, Map<String, String> map) {
        if (j == null) {
            i.b("UTDC", "please call UTDC.init(context) before commit log,and this log will be discarded");
        } else if (i == null) {
            i.b("UTDC", "please call UTDC.setRequestAuthentication(auth) before commit log,and this log will be discarded");
        } else {
            i.a("UTDC", "[commit] page:", str, "eventId:", str2, "arg1:", str3, "arg2:", str4, "arg3:", str5, "args:", map);
            com.alibaba.mtl.log.b.a.a(str2);
            com.alibaba.mtl.log.model.a aVar = new com.alibaba.mtl.log.model.a(str, str2, str3, str4, str5, map);
            c a = c.a();
            i.a("LogStoreMgr", "[add] :", aVar.f);
            com.alibaba.mtl.log.b.a.b(aVar.b);
            a.b.add(aVar);
            if (a.b.size() >= 100) {
                r.a().a(1);
                r.a().a(1, a.c, 0);
                return;
            }
            if (!r.a().b(1)) {
                r.a().a(1, a.c, 5000);
            }
        }
    }

    public static Context c() {
        return j;
    }

    public static b d() {
        if ((i != null && !TextUtils.isEmpty(i.a())) || !i.a()) {
            return i;
        }
        throw new RuntimeException("please Set <meta-data android:value=\"YOU KEY\" android:name=\"com.alibaba.apmplus.app_key\"></meta-data> in app AndroidManifest.xml ");
    }

    public static java.lang.String e() {
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
        r0 = com.alibaba.mtl.log.e.l.c();	 Catch:{ Exception -> 0x0008 }
        r1 = 0;	 Catch:{ Exception -> 0x0008 }
        r0 = r0[r1];	 Catch:{ Exception -> 0x0008 }
        return r0;
    L_0x0008:
        r0 = "Unknown";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.a.e():java.lang.String");
    }

    public static java.lang.String f() {
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
        r0 = com.alibaba.mtl.log.e.l.c();	 Catch:{ Exception -> 0x0016 }
        r1 = 0;	 Catch:{ Exception -> 0x0016 }
        r1 = r0[r1];	 Catch:{ Exception -> 0x0016 }
        r2 = "2G/3G";	 Catch:{ Exception -> 0x0016 }
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x0016 }
        if (r1 == 0) goto L_0x0013;	 Catch:{ Exception -> 0x0016 }
    L_0x000f:
        r1 = 1;	 Catch:{ Exception -> 0x0016 }
        r0 = r0[r1];	 Catch:{ Exception -> 0x0016 }
        return r0;
    L_0x0013:
        r0 = "Unknown";
        return r0;
    L_0x0016:
        r0 = "Unknown";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.a.f():java.lang.String");
    }

    public static void i() {
        com.alibaba.mtl.log.d.a.a().b();
    }
}
