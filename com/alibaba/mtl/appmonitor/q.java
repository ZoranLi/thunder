package com.alibaba.mtl.appmonitor;

import android.app.Application;
import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.a.e;
import com.alibaba.mtl.appmonitor.a.f;
import com.alibaba.mtl.appmonitor.d.j;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alibaba.mtl.appmonitor.model.UTDimensionValueSet;
import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.l;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: AppMonitorDelegate */
public final class q {
    public static boolean a = false;
    static volatile boolean b = false;
    private static Application c;

    /* compiled from: AppMonitorDelegate */
    public static class a {
        public static void a(String str, String str2, String str3) {
            String str4 = str;
            String str5 = str2;
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        com.alibaba.mtl.log.b.a.i();
                        if (q.b && com.alibaba.mtl.log.a.a.b() && f.ALARM.isOpen() && (q.a || j.a(str4, str5, Boolean.valueOf(true), null))) {
                            i.a("AppMonitorDelegate", "commitSuccess module:", str4, " monitorPoint:", str5);
                            com.alibaba.mtl.log.b.a.j();
                            e a = e.a();
                            int a2 = f.ALARM.a();
                            UTDimensionValueSet a3 = e.a(a2);
                            UTDimensionValueSet uTDimensionValueSet = a3;
                            ((com.alibaba.mtl.appmonitor.a.a) a.a(a3, str4, str5, str3, com.alibaba.mtl.appmonitor.a.a.class)).a();
                            if (com.alibaba.mtl.log.a.a.a()) {
                                com.alibaba.mtl.appmonitor.a.a aVar = (com.alibaba.mtl.appmonitor.a.a) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.a.a.class, Integer.valueOf(a2), str4, str5, str3);
                                aVar.a();
                                com.alibaba.mtl.appmonitor.f.c.a(uTDimensionValueSet, aVar);
                            }
                            a.a(f.a(a2), a.b);
                            return;
                        }
                        i.b("log discard !", "");
                        return;
                    }
                }
                i.b("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.a(th);
            }
        }

        public static void a(String str, String str2, String str3, String str4, String str5) {
            String str6 = str;
            String str7 = str2;
            String str8 = str4;
            String str9 = str5;
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        com.alibaba.mtl.log.b.a.i();
                        Map hashMap = new HashMap();
                        hashMap.put("_status", "0");
                        if (q.b && com.alibaba.mtl.log.a.a.b() && f.ALARM.isOpen() && (q.a || j.a(str6, str7, Boolean.valueOf(false), hashMap))) {
                            i.a("AppMonitorDelegate", "commitFail module:", str6, " monitorPoint:", str7, " errorCode:", str8, "errorMsg:", str9);
                            com.alibaba.mtl.log.b.a.j();
                            e a = e.a();
                            int a2 = f.ALARM.a();
                            UTDimensionValueSet a3 = e.a(a2);
                            UTDimensionValueSet uTDimensionValueSet = a3;
                            int i = a2;
                            e eVar = a;
                            com.alibaba.mtl.appmonitor.a.a aVar = (com.alibaba.mtl.appmonitor.a.a) a.a(a3, str6, str7, str3, com.alibaba.mtl.appmonitor.a.a.class);
                            aVar.b();
                            aVar.a(str8, str9);
                            if (com.alibaba.mtl.log.a.a.a()) {
                                aVar = (com.alibaba.mtl.appmonitor.a.a) com.alibaba.mtl.appmonitor.c.a.a().a(com.alibaba.mtl.appmonitor.a.a.class, Integer.valueOf(i), str6, str7, str3);
                                aVar.b();
                                aVar.a(str8, str9);
                                com.alibaba.mtl.appmonitor.f.c.a(uTDimensionValueSet, aVar);
                            }
                            e eVar2 = eVar;
                            eVar2.a(f.a(i), eVar2.b);
                            return;
                        }
                        i.b("log discard !", "");
                        return;
                    }
                }
                i.b("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.a(th);
            }
        }
    }

    /* compiled from: AppMonitorDelegate */
    public static class b {
        public static void a(String str, String str2, String str3, double d) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        com.alibaba.mtl.log.b.a.g();
                        if (q.b && com.alibaba.mtl.log.a.a.b() && f.COUNTER.isOpen() && (q.a || j.a(f.COUNTER, str, str2))) {
                            i.a("AppMonitorDelegate", "commitCount module: ", str, " monitorPoint: ", str2, " value: ", Double.valueOf(d));
                            com.alibaba.mtl.log.b.a.h();
                            e.a().a(f.COUNTER.a(), str, str2, str3, d);
                        }
                        return;
                    }
                }
                i.b("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (String str4) {
                com.alibaba.mtl.appmonitor.b.b.a(str4);
            }
        }
    }

    /* compiled from: AppMonitorDelegate */
    public static class c {
        public static void a(String str, String str2, DimensionValueSet dimensionValueSet, double d) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        com.alibaba.mtl.log.b.a.c();
                        if (q.b && com.alibaba.mtl.log.a.a.b() && f.STAT.isOpen() && (q.a || j.a(f.STAT, str, str2))) {
                            i.a("AppMonitorDelegate", "statEvent commit. module: ", str, " monitorPoint: ", str2);
                            com.alibaba.mtl.appmonitor.model.i a = com.alibaba.mtl.appmonitor.model.j.a().a(str, str2);
                            com.alibaba.mtl.log.b.a.d();
                            if (a != null) {
                                List list = a.d.a;
                                if (list.size() == 1) {
                                    a(str, str2, dimensionValueSet, ((MeasureValueSet) com.alibaba.mtl.appmonitor.c.a.a().a(MeasureValueSet.class, new Object[0])).a(((Measure) list.get(0)).b(), d));
                                }
                            }
                        }
                        return;
                    }
                }
                i.b("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (String str3) {
                com.alibaba.mtl.appmonitor.b.b.a(str3);
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void a(java.lang.String r12, java.lang.String r13, com.alibaba.mtl.appmonitor.model.DimensionValueSet r14, com.alibaba.mtl.appmonitor.model.MeasureValueSet r15) {
            /*
            r0 = android.text.TextUtils.isEmpty(r12);	 Catch:{ Throwable -> 0x007f }
            if (r0 != 0) goto L_0x0077;
        L_0x0006:
            r0 = android.text.TextUtils.isEmpty(r13);	 Catch:{ Throwable -> 0x007f }
            if (r0 == 0) goto L_0x000d;
        L_0x000c:
            goto L_0x0077;
        L_0x000d:
            com.alibaba.mtl.log.b.a.c();	 Catch:{ Throwable -> 0x007f }
            r0 = com.alibaba.mtl.appmonitor.q.b;	 Catch:{ Throwable -> 0x007f }
            r1 = 3;
            r2 = 2;
            r3 = 1;
            r4 = 0;
            r5 = 4;
            if (r0 == 0) goto L_0x0063;
        L_0x0019:
            r0 = com.alibaba.mtl.log.a.a.b();	 Catch:{ Throwable -> 0x007f }
            if (r0 == 0) goto L_0x0063;
        L_0x001f:
            r0 = com.alibaba.mtl.appmonitor.a.f.STAT;	 Catch:{ Throwable -> 0x007f }
            r0 = r0.isOpen();	 Catch:{ Throwable -> 0x007f }
            if (r0 == 0) goto L_0x0063;
        L_0x0027:
            r0 = com.alibaba.mtl.appmonitor.q.a;	 Catch:{ Throwable -> 0x007f }
            if (r0 != 0) goto L_0x003b;
        L_0x002b:
            r0 = com.alibaba.mtl.appmonitor.a.f.STAT;	 Catch:{ Throwable -> 0x007f }
            if (r14 == 0) goto L_0x0034;
        L_0x002f:
            r6 = r14.b();	 Catch:{ Throwable -> 0x007f }
            goto L_0x0035;
        L_0x0034:
            r6 = 0;
        L_0x0035:
            r0 = com.alibaba.mtl.appmonitor.d.j.a(r0, r12, r13, r6);	 Catch:{ Throwable -> 0x007f }
            if (r0 == 0) goto L_0x0063;
        L_0x003b:
            r0 = "statEvent commit success";
            r5 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x007f }
            r6 = "statEvent commit. module: ";
            r5[r4] = r6;	 Catch:{ Throwable -> 0x007f }
            r5[r3] = r12;	 Catch:{ Throwable -> 0x007f }
            r3 = " monitorPoint: ";
            r5[r2] = r3;	 Catch:{ Throwable -> 0x007f }
            r5[r1] = r13;	 Catch:{ Throwable -> 0x007f }
            com.alibaba.mtl.log.e.i.a(r0, r5);	 Catch:{ Throwable -> 0x007f }
            com.alibaba.mtl.log.b.a.d();	 Catch:{ Throwable -> 0x007f }
            r6 = com.alibaba.mtl.appmonitor.a.e.a();	 Catch:{ Throwable -> 0x007f }
            r0 = com.alibaba.mtl.appmonitor.a.f.STAT;	 Catch:{ Throwable -> 0x007f }
            r7 = r0.a();	 Catch:{ Throwable -> 0x007f }
            r8 = r12;
            r9 = r13;
            r10 = r15;
            r11 = r14;
            r6.a(r7, r8, r9, r10, r11);	 Catch:{ Throwable -> 0x007f }
            return;
        L_0x0063:
            r14 = "statEvent commit failed,log discard";
            r15 = new java.lang.Object[r5];	 Catch:{ Throwable -> 0x007f }
            r0 = " ,. module: ";
            r15[r4] = r0;	 Catch:{ Throwable -> 0x007f }
            r15[r3] = r12;	 Catch:{ Throwable -> 0x007f }
            r12 = " monitorPoint: ";
            r15[r2] = r12;	 Catch:{ Throwable -> 0x007f }
            r15[r1] = r13;	 Catch:{ Throwable -> 0x007f }
            com.alibaba.mtl.log.e.i.a(r14, r15);	 Catch:{ Throwable -> 0x007f }
            return;
        L_0x0077:
            r12 = "AppMonitorDelegate";
            r13 = "module & monitorPoint must not null";
            com.alibaba.mtl.log.e.i.b(r12, r13);	 Catch:{ Throwable -> 0x007f }
            return;
        L_0x007f:
            r12 = move-exception;
            com.alibaba.mtl.appmonitor.b.b.a(r12);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.q.c.a(java.lang.String, java.lang.String, com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.model.MeasureValueSet):void");
        }
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = com.alibaba.mtl.appmonitor.q.class;
        monitor-enter(r0);
        r1 = "AppMonitorDelegate";	 Catch:{ all -> 0x0036 }
        r2 = 1;	 Catch:{ all -> 0x0036 }
        r3 = new java.lang.Object[r2];	 Catch:{ all -> 0x0036 }
        r4 = 0;	 Catch:{ all -> 0x0036 }
        r5 = "start init";	 Catch:{ all -> 0x0036 }
        r3[r4] = r5;	 Catch:{ all -> 0x0036 }
        com.alibaba.mtl.log.e.i.a(r1, r3);	 Catch:{ all -> 0x0036 }
        r1 = b;	 Catch:{ Throwable -> 0x0031 }
        if (r1 != 0) goto L_0x002f;	 Catch:{ Throwable -> 0x0031 }
    L_0x0014:
        c = r6;	 Catch:{ Throwable -> 0x0031 }
        r1 = r6.getApplicationContext();	 Catch:{ Throwable -> 0x0031 }
        com.alibaba.mtl.log.a.a(r1);	 Catch:{ Throwable -> 0x0031 }
        com.alibaba.mtl.appmonitor.x.a();	 Catch:{ Throwable -> 0x0031 }
        com.alibaba.mtl.appmonitor.y.a();	 Catch:{ Throwable -> 0x0031 }
        com.alibaba.mtl.appmonitor.w.a(r6);	 Catch:{ Throwable -> 0x0031 }
        r6 = r6.getApplicationContext();	 Catch:{ Throwable -> 0x0031 }
        com.alibaba.mtl.log.e.l.b(r6);	 Catch:{ Throwable -> 0x0031 }
        b = r2;	 Catch:{ Throwable -> 0x0031 }
    L_0x002f:
        monitor-exit(r0);
        return;
    L_0x0031:
        a();	 Catch:{ all -> 0x0036 }
        monitor-exit(r0);
        return;
    L_0x0036:
        r6 = move-exception;
        monitor-exit(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.q.a(android.app.Application):void");
    }

    public static synchronized void a() {
        synchronized (q.class) {
            try {
                i.a("AppMonitorDelegate", "start destory");
                if (b) {
                    y.c();
                    y.b();
                    x.b();
                    if (c != null) {
                        l.c(c.getApplicationContext());
                    }
                    b = false;
                }
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.a(th);
            }
        }
    }

    public static synchronized void b() {
        synchronized (q.class) {
            try {
                i.a("AppMonitorDelegate", "triggerUpload");
                if (b && com.alibaba.mtl.log.a.a.b()) {
                    y.c();
                }
            } catch (Throwable th) {
                com.alibaba.mtl.appmonitor.b.b.a(th);
            }
        }
    }

    public static void a(int i) {
        for (f fVar : f.a()) {
            fVar.setStatisticsInterval(i);
            a(fVar, i);
        }
    }

    public static void b(int i) {
        Object[] objArr = new Object[1];
        int i2 = 0;
        objArr[0] = "[setSampling]";
        i.a("AppMonitorDelegate", objArr);
        f[] a = f.a();
        int length = a.length;
        while (i2 < length) {
            f fVar = a[i2];
            fVar.c(i);
            j.a().a(fVar, i);
            i2++;
        }
    }

    public static void a(boolean z) {
        i.a("AppMonitorDelegate", "[enableLog]");
        i.a(z);
    }

    public static void a(String str, String str2, MeasureSet measureSet) {
        a(str, str2, measureSet, null);
    }

    public static void a(String str, String str2, MeasureSet measureSet, boolean z) {
        a(str, str2, measureSet, null, z);
    }

    public static void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) {
        a(str, str2, measureSet, dimensionSet, false);
    }

    public static void a(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            if (b) {
                if (!com.alibaba.mtl.appmonitor.f.b.b(str)) {
                    if (!com.alibaba.mtl.appmonitor.f.b.b(str2)) {
                        com.alibaba.mtl.appmonitor.model.j.a().a(new com.alibaba.mtl.appmonitor.model.i(str, str2, measureSet, dimensionSet, z));
                    }
                }
                i.a("AppMonitorDelegate", "register stat event. module: ", str, " monitorPoint: ", str2);
                if (a != null) {
                    throw new com.alibaba.mtl.appmonitor.b.a("register error. module and monitorPoint can't be null");
                }
            }
        } catch (String str3) {
            com.alibaba.mtl.appmonitor.b.b.a(str3);
        }
    }

    static void a(f fVar, int i) {
        try {
            if (b && fVar != null) {
                y.a(fVar.a(), i);
                if (i > 0) {
                    fVar.b((boolean) 1);
                    return;
                }
                fVar.b((boolean) 0);
            }
        } catch (f fVar2) {
            com.alibaba.mtl.appmonitor.b.b.a(fVar2);
        }
    }

    public static void a(boolean z, String str, String str2, String str3) {
        com.alibaba.mtl.log.f.b cVar;
        if (z) {
            cVar = new com.alibaba.mtl.log.f.c(str, str3);
        } else {
            cVar = new com.alibaba.mtl.log.f.a(str, str2);
        }
        com.alibaba.mtl.log.a.a(cVar);
        com.alibaba.mtl.log.a.a.g();
    }

    public static void a(String str) {
        com.alibaba.mtl.log.a.a(str);
    }

    public static void a(Map<String, String> map) {
        com.alibaba.mtl.log.a.a.a((Map) map);
    }

    public static void c() {
        i.a("AppMonitorDelegate", "[turnOffRealTimeDebug]");
    }
}
