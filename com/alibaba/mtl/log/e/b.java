package com.alibaba.mtl.log.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;

/* compiled from: AppInfoUtil */
public final class b {
    private static String a = "";
    private static String b;

    public static String d() {
        return "";
    }

    public static String e() {
        return "";
    }

    public static java.lang.String a() {
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
        r0 = "";
        r1 = com.alibaba.mtl.log.a.c();
        if (r1 != 0) goto L_0x0009;
    L_0x0008:
        return r0;
    L_0x0009:
        r1 = com.alibaba.mtl.log.a.c();	 Catch:{ Exception -> 0x0032 }
        r2 = "UTCommon";	 Catch:{ Exception -> 0x0032 }
        r3 = 0;	 Catch:{ Exception -> 0x0032 }
        r1 = r1.getSharedPreferences(r2, r3);	 Catch:{ Exception -> 0x0032 }
        r2 = "_lun";	 Catch:{ Exception -> 0x0032 }
        r3 = "";	 Catch:{ Exception -> 0x0032 }
        r1 = r1.getString(r2, r3);	 Catch:{ Exception -> 0x0032 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0032 }
        if (r2 != 0) goto L_0x0032;	 Catch:{ Exception -> 0x0032 }
    L_0x0022:
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x0032 }
        r1 = r1.getBytes();	 Catch:{ Exception -> 0x0032 }
        r1 = com.alibaba.mtl.log.e.c.a(r1);	 Catch:{ Exception -> 0x0032 }
        r3 = "UTF-8";	 Catch:{ Exception -> 0x0032 }
        r2.<init>(r1, r3);	 Catch:{ Exception -> 0x0032 }
        r0 = r2;
    L_0x0032:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.b.a():java.lang.String");
    }

    public static java.lang.String b() {
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
        r0 = com.alibaba.mtl.log.a.c();
        if (r0 != 0) goto L_0x0009;
    L_0x0006:
        r0 = "";
        return r0;
    L_0x0009:
        r0 = "";
        r1 = com.alibaba.mtl.log.a.c();	 Catch:{ Exception -> 0x0034 }
        r2 = "UTCommon";	 Catch:{ Exception -> 0x0034 }
        r3 = 0;	 Catch:{ Exception -> 0x0034 }
        r1 = r1.getSharedPreferences(r2, r3);	 Catch:{ Exception -> 0x0034 }
        r2 = "_luid";	 Catch:{ Exception -> 0x0034 }
        r3 = "";	 Catch:{ Exception -> 0x0034 }
        r1 = r1.getString(r2, r3);	 Catch:{ Exception -> 0x0034 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0034 }
        if (r2 != 0) goto L_0x0034;	 Catch:{ Exception -> 0x0034 }
    L_0x0024:
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x0034 }
        r1 = r1.getBytes();	 Catch:{ Exception -> 0x0034 }
        r1 = com.alibaba.mtl.log.e.c.a(r1);	 Catch:{ Exception -> 0x0034 }
        r3 = "UTF-8";	 Catch:{ Exception -> 0x0034 }
        r2.<init>(r1, r3);	 Catch:{ Exception -> 0x0034 }
        r0 = r2;
    L_0x0034:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.b.b():java.lang.String");
    }

    public static String c() {
        return a;
    }

    public static void a(String str) {
        i.a("AppInfoUtil", "[setChannle]", str);
        if (!TextUtils.isEmpty(str)) {
            int indexOf = str.indexOf("@");
            if (indexOf == -1) {
                a = str;
                return;
            }
            a = str.substring(0, indexOf);
        }
    }

    public static String f() {
        return b;
    }

    public static void b(String str) {
        i.a("AppInfoUtil", "set Appkey:", str);
        b = str;
    }

    public static boolean a(android.content.Context r5) {
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
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = "activity";	 Catch:{ Throwable -> 0x0043 }
        r1 = r5.getSystemService(r1);	 Catch:{ Throwable -> 0x0043 }
        r1 = (android.app.ActivityManager) r1;	 Catch:{ Throwable -> 0x0043 }
        r2 = "power";	 Catch:{ Throwable -> 0x0043 }
        r2 = r5.getSystemService(r2);	 Catch:{ Throwable -> 0x0043 }
        r2 = (android.os.PowerManager) r2;	 Catch:{ Throwable -> 0x0043 }
        r5 = r5.getPackageName();	 Catch:{ Throwable -> 0x0043 }
        r1 = r1.getRunningAppProcesses();	 Catch:{ Throwable -> 0x0043 }
        r1 = r1.iterator();	 Catch:{ Throwable -> 0x0043 }
    L_0x0020:
        r3 = r1.hasNext();	 Catch:{ Throwable -> 0x0043 }
        if (r3 == 0) goto L_0x0043;	 Catch:{ Throwable -> 0x0043 }
    L_0x0026:
        r3 = r1.next();	 Catch:{ Throwable -> 0x0043 }
        r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3;	 Catch:{ Throwable -> 0x0043 }
        r4 = r3.processName;	 Catch:{ Throwable -> 0x0043 }
        r4 = r4.equals(r5);	 Catch:{ Throwable -> 0x0043 }
        if (r4 == 0) goto L_0x0020;	 Catch:{ Throwable -> 0x0043 }
    L_0x0034:
        r3 = r3.importance;	 Catch:{ Throwable -> 0x0043 }
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;	 Catch:{ Throwable -> 0x0043 }
        if (r3 != r4) goto L_0x003b;	 Catch:{ Throwable -> 0x0043 }
    L_0x003a:
        return r0;	 Catch:{ Throwable -> 0x0043 }
    L_0x003b:
        r3 = r2.isScreenOn();	 Catch:{ Throwable -> 0x0043 }
        if (r3 == 0) goto L_0x0020;
    L_0x0041:
        r5 = 1;
        return r5;
    L_0x0043:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.b.a(android.content.Context):boolean");
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        int myPid = Process.myPid();
        for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
            if (runningAppProcessInfo.pid == myPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }
}
