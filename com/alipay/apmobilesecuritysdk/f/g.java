package com.alipay.apmobilesecuritysdk.f;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.alipay.b.a.a.a.a;
import com.alipay.b.a.a.d.c;

public final class g {
    public static synchronized String a(Context context, String str) {
        synchronized (g.class) {
            StringBuilder stringBuilder = new StringBuilder("openApi");
            stringBuilder.append(str);
            String a = c.a(context, "openapi_file_pri", stringBuilder.toString(), "");
            if (a.a(a)) {
                a = "";
                return a;
            }
            a = com.alipay.b.a.a.a.a.c.b(com.alipay.b.a.a.a.a.c.a(), a);
            if (a.a(a)) {
                a = "";
                return a;
            }
            return a;
        }
    }

    public static synchronized void a() {
        synchronized (g.class) {
        }
    }

    public static synchronized void a(Context context) {
        synchronized (g.class) {
            Editor edit = context.getSharedPreferences("openapi_file_pri", 0).edit();
            if (edit != null) {
                edit.clear();
                edit.commit();
            }
        }
    }

    public static synchronized void a(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
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
        r0 = com.alipay.apmobilesecuritysdk.f.g.class;
        monitor-enter(r0);
        r1 = "openapi_file_pri";	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
        r2 = 0;	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
        r3 = r3.getSharedPreferences(r1, r2);	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
        r3 = r3.edit();	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
        if (r3 == 0) goto L_0x002c;	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
    L_0x0010:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
        r2 = "openApi";	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
        r1.append(r4);	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
        r4 = r1.toString();	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
        r1 = com.alipay.b.a.a.a.a.c.a();	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
        r5 = com.alipay.b.a.a.a.a.c.a(r1, r5);	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
        r3.putString(r4, r5);	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
        r3.commit();	 Catch:{ Throwable -> 0x0031, all -> 0x002e }
    L_0x002c:
        monitor-exit(r0);
        return;
    L_0x002e:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
    L_0x0031:
        monitor-exit(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.apmobilesecuritysdk.f.g.a(android.content.Context, java.lang.String, java.lang.String):void");
    }
}
