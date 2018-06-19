package com.alipay.b.a.a.b;

import android.os.Build;
import android.os.Build.VERSION;
import anet.channel.strategy.dispatch.DispatchConstants;

public final class d {
    private static d a = new d();

    private d() {
    }

    public static d a() {
        return a;
    }

    private static java.lang.String a(java.lang.String r7, java.lang.String r8) {
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
        r0 = "android.os.SystemProperties";	 Catch:{ Exception -> 0x0027 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0027 }
        r1 = "get";	 Catch:{ Exception -> 0x0027 }
        r2 = 2;	 Catch:{ Exception -> 0x0027 }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x0027 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0027 }
        r5 = 0;	 Catch:{ Exception -> 0x0027 }
        r3[r5] = r4;	 Catch:{ Exception -> 0x0027 }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x0027 }
        r6 = 1;	 Catch:{ Exception -> 0x0027 }
        r3[r6] = r4;	 Catch:{ Exception -> 0x0027 }
        r0 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x0027 }
        r1 = 0;	 Catch:{ Exception -> 0x0027 }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x0027 }
        r2[r5] = r7;	 Catch:{ Exception -> 0x0027 }
        r2[r6] = r8;	 Catch:{ Exception -> 0x0027 }
        r7 = r0.invoke(r1, r2);	 Catch:{ Exception -> 0x0027 }
        r7 = (java.lang.String) r7;	 Catch:{ Exception -> 0x0027 }
        return r7;
    L_0x0027:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.d.a(java.lang.String, java.lang.String):java.lang.String");
    }

    public static boolean a(android.content.Context r7) {
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
        r1 = android.os.Build.HARDWARE;	 Catch:{ Exception -> 0x0066 }
        r2 = "goldfish";	 Catch:{ Exception -> 0x0066 }
        r1 = r1.contains(r2);	 Catch:{ Exception -> 0x0066 }
        r2 = 1;	 Catch:{ Exception -> 0x0066 }
        if (r1 != 0) goto L_0x0065;	 Catch:{ Exception -> 0x0066 }
    L_0x000c:
        r1 = android.os.Build.PRODUCT;	 Catch:{ Exception -> 0x0066 }
        r3 = "sdk";	 Catch:{ Exception -> 0x0066 }
        r1 = r1.contains(r3);	 Catch:{ Exception -> 0x0066 }
        if (r1 != 0) goto L_0x0065;	 Catch:{ Exception -> 0x0066 }
    L_0x0016:
        r1 = android.os.Build.FINGERPRINT;	 Catch:{ Exception -> 0x0066 }
        r3 = "generic";	 Catch:{ Exception -> 0x0066 }
        r1 = r1.contains(r3);	 Catch:{ Exception -> 0x0066 }
        if (r1 == 0) goto L_0x0021;	 Catch:{ Exception -> 0x0066 }
    L_0x0020:
        return r2;	 Catch:{ Exception -> 0x0066 }
    L_0x0021:
        r1 = "phone";	 Catch:{ Exception -> 0x0066 }
        r1 = r7.getSystemService(r1);	 Catch:{ Exception -> 0x0066 }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x0066 }
        if (r1 == 0) goto L_0x0056;	 Catch:{ Exception -> 0x0066 }
    L_0x002b:
        r1 = r1.getDeviceId();	 Catch:{ Exception -> 0x0066 }
        if (r1 == 0) goto L_0x0052;	 Catch:{ Exception -> 0x0066 }
    L_0x0031:
        r3 = r1.length();	 Catch:{ Exception -> 0x0066 }
        if (r3 != 0) goto L_0x0038;	 Catch:{ Exception -> 0x0066 }
    L_0x0037:
        goto L_0x0052;	 Catch:{ Exception -> 0x0066 }
    L_0x0038:
        r4 = r0;	 Catch:{ Exception -> 0x0066 }
    L_0x0039:
        if (r4 >= r3) goto L_0x0052;	 Catch:{ Exception -> 0x0066 }
    L_0x003b:
        r5 = r1.charAt(r4);	 Catch:{ Exception -> 0x0066 }
        r5 = java.lang.Character.isWhitespace(r5);	 Catch:{ Exception -> 0x0066 }
        if (r5 != 0) goto L_0x004f;	 Catch:{ Exception -> 0x0066 }
    L_0x0045:
        r5 = r1.charAt(r4);	 Catch:{ Exception -> 0x0066 }
        r6 = 48;	 Catch:{ Exception -> 0x0066 }
        if (r5 == r6) goto L_0x004f;	 Catch:{ Exception -> 0x0066 }
    L_0x004d:
        r1 = r0;	 Catch:{ Exception -> 0x0066 }
        goto L_0x0053;	 Catch:{ Exception -> 0x0066 }
    L_0x004f:
        r4 = r4 + 1;	 Catch:{ Exception -> 0x0066 }
        goto L_0x0039;	 Catch:{ Exception -> 0x0066 }
    L_0x0052:
        r1 = r2;	 Catch:{ Exception -> 0x0066 }
    L_0x0053:
        if (r1 == 0) goto L_0x0056;	 Catch:{ Exception -> 0x0066 }
    L_0x0055:
        return r2;	 Catch:{ Exception -> 0x0066 }
    L_0x0056:
        r7 = r7.getContentResolver();	 Catch:{ Exception -> 0x0066 }
        r1 = "android_id";	 Catch:{ Exception -> 0x0066 }
        r7 = android.provider.Settings.Secure.getString(r7, r1);	 Catch:{ Exception -> 0x0066 }
        r7 = com.alipay.b.a.a.a.a.a(r7);	 Catch:{ Exception -> 0x0066 }
        return r7;
    L_0x0065:
        return r2;
    L_0x0066:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.d.a(android.content.Context):boolean");
    }

    public static String b() {
        return DispatchConstants.ANDROID;
    }

    public static boolean c() {
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
        r0 = 5;
        r1 = new java.lang.String[r0];
        r2 = "/system/bin/";
        r3 = 0;
        r1[r3] = r2;
        r2 = "/system/xbin/";
        r4 = 1;
        r1[r4] = r2;
        r2 = "/system/sbin/";
        r5 = 2;
        r1[r5] = r2;
        r2 = "/sbin/";
        r5 = 3;
        r1[r5] = r2;
        r2 = "/vendor/bin/";
        r5 = 4;
        r1[r5] = r2;
        r2 = r3;
    L_0x001d:
        if (r2 >= r0) goto L_0x0041;
    L_0x001f:
        r5 = new java.io.File;	 Catch:{ Exception -> 0x0041 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0041 }
        r6.<init>();	 Catch:{ Exception -> 0x0041 }
        r7 = r1[r2];	 Catch:{ Exception -> 0x0041 }
        r6.append(r7);	 Catch:{ Exception -> 0x0041 }
        r7 = "su";	 Catch:{ Exception -> 0x0041 }
        r6.append(r7);	 Catch:{ Exception -> 0x0041 }
        r6 = r6.toString();	 Catch:{ Exception -> 0x0041 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x0041 }
        r5 = r5.exists();	 Catch:{ Exception -> 0x0041 }
        if (r5 == 0) goto L_0x003e;
    L_0x003d:
        return r4;
    L_0x003e:
        r2 = r2 + 1;
        goto L_0x001d;
    L_0x0041:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.d.c():boolean");
    }

    public static String d() {
        return Build.BOARD;
    }

    public static String e() {
        return Build.BRAND;
    }

    public static String f() {
        return Build.DEVICE;
    }

    public static String g() {
        return Build.DISPLAY;
    }

    public static String h() {
        return VERSION.INCREMENTAL;
    }

    public static String i() {
        return Build.MANUFACTURER;
    }

    public static String j() {
        return Build.MODEL;
    }

    public static String k() {
        return Build.PRODUCT;
    }

    public static String l() {
        return VERSION.RELEASE;
    }

    public static String m() {
        return VERSION.SDK;
    }

    public static String n() {
        return Build.TAGS;
    }

    public static String o() {
        return a("ro.kernel.qemu", "0");
    }
}
