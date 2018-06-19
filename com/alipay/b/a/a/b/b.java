package com.alipay.b.a.a.b;

import android.content.Context;
import com.alipay.b.a.a.a.a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.LinkedHashMap;
import java.util.Map;

public final class b {
    private static b a = new b();

    private b() {
    }

    public static b a() {
        return a;
    }

    public static java.lang.String a(android.content.Context r2) {
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
        r0 = "android.permission.READ_PHONE_STATE";
        r0 = a(r2, r0);
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        r2 = "";
        return r2;
    L_0x000b:
        r0 = 0;
        if (r2 == 0) goto L_0x001d;
    L_0x000e:
        r1 = "phone";	 Catch:{ Exception -> 0x001d }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x001d }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Exception -> 0x001d }
        if (r2 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x001d }
    L_0x0018:
        r2 = r2.getDeviceId();	 Catch:{ Exception -> 0x001d }
        r0 = r2;
    L_0x001d:
        if (r0 != 0) goto L_0x0021;
    L_0x001f:
        r0 = "";
    L_0x0021:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.a(android.content.Context):java.lang.String");
    }

    private static boolean a(Context context, String str) {
        return !(context.getPackageManager().checkPermission(str, context.getPackageName()) == 0);
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
        r0 = android.os.Environment.getDataDirectory();	 Catch:{ Exception -> 0x0019 }
        r1 = new android.os.StatFs;	 Catch:{ Exception -> 0x0019 }
        r0 = r0.getPath();	 Catch:{ Exception -> 0x0019 }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0019 }
        r0 = r1.getBlockSize();	 Catch:{ Exception -> 0x0019 }
        r2 = (long) r0;	 Catch:{ Exception -> 0x0019 }
        r0 = r1.getAvailableBlocks();	 Catch:{ Exception -> 0x0019 }
        r0 = (long) r0;
        r0 = r0 * r2;
        goto L_0x001b;
    L_0x0019:
        r0 = 0;
    L_0x001b:
        r0 = java.lang.String.valueOf(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.b():java.lang.String");
    }

    public static java.lang.String b(android.content.Context r2) {
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
        r1 = "android.permission.READ_PHONE_STATE";
        r1 = a(r2, r1);
        if (r1 == 0) goto L_0x000d;
    L_0x000a:
        r2 = "";
        return r2;
    L_0x000d:
        if (r2 == 0) goto L_0x001e;
    L_0x000f:
        r1 = "phone";	 Catch:{ Exception -> 0x001e }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x001e }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Exception -> 0x001e }
        if (r2 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x001e }
    L_0x0019:
        r2 = r2.getSubscriberId();	 Catch:{ Exception -> 0x001e }
        r0 = r2;
    L_0x001e:
        if (r0 != 0) goto L_0x0022;
    L_0x0020:
        r0 = "";
    L_0x0022:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.b(android.content.Context):java.lang.String");
    }

    public static java.lang.String c() {
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
        r2 = android.os.Environment.getExternalStorageState();	 Catch:{ Exception -> 0x0027 }
        r3 = "mounted";	 Catch:{ Exception -> 0x0027 }
        r2 = r3.equals(r2);	 Catch:{ Exception -> 0x0027 }
        if (r2 == 0) goto L_0x0027;	 Catch:{ Exception -> 0x0027 }
    L_0x000e:
        r2 = com.alipay.b.a.a.a.a.a();	 Catch:{ Exception -> 0x0027 }
        r3 = new android.os.StatFs;	 Catch:{ Exception -> 0x0027 }
        r2 = r2.getPath();	 Catch:{ Exception -> 0x0027 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0027 }
        r2 = r3.getBlockSize();	 Catch:{ Exception -> 0x0027 }
        r4 = (long) r2;	 Catch:{ Exception -> 0x0027 }
        r2 = r3.getAvailableBlocks();	 Catch:{ Exception -> 0x0027 }
        r0 = (long) r2;
        r4 = r4 * r0;
        r0 = r4;
    L_0x0027:
        r0 = java.lang.String.valueOf(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.c():java.lang.String");
    }

    public static java.lang.String c(android.content.Context r2) {
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
        r2 = r2.getContentResolver();	 Catch:{ Exception -> 0x000c }
        r1 = "airplane_mode_on";	 Catch:{ Exception -> 0x000c }
        r2 = android.provider.Settings.System.getInt(r2, r1, r0);	 Catch:{ Exception -> 0x000c }
        goto L_0x000d;
    L_0x000c:
        r2 = r0;
    L_0x000d:
        r0 = 1;
        if (r2 != r0) goto L_0x0013;
    L_0x0010:
        r2 = "1";
        return r2;
    L_0x0013:
        r2 = "0";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.c(android.content.Context):java.lang.String");
    }

    public static java.lang.String d() {
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
        r0 = "0000000000000000";
        r1 = 0;
        r2 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x006e, all -> 0x005b }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x006e, all -> 0x005b }
        r4 = "/proc/cpuinfo";	 Catch:{ Exception -> 0x006e, all -> 0x005b }
        r3.<init>(r4);	 Catch:{ Exception -> 0x006e, all -> 0x005b }
        r2.<init>(r3);	 Catch:{ Exception -> 0x006e, all -> 0x005b }
        r3 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0059, all -> 0x0056 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0059, all -> 0x0056 }
        r4 = new java.io.LineNumberReader;	 Catch:{ Exception -> 0x0070, all -> 0x0054 }
        r4.<init>(r3);	 Catch:{ Exception -> 0x0070, all -> 0x0054 }
        r1 = 1;
        r5 = r1;
    L_0x001b:
        r6 = 100;
        if (r5 >= r6) goto L_0x004a;
    L_0x001f:
        r6 = r4.readLine();	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        if (r6 == 0) goto L_0x004a;	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
    L_0x0025:
        r7 = "Serial";	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        r7 = r6.indexOf(r7);	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        if (r7 < 0) goto L_0x0042;	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
    L_0x002d:
        r5 = ":";	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        r5 = r6.indexOf(r5);	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        r5 = r5 + r1;	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        r1 = r6.length();	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        r1 = r6.substring(r5, r1);	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        r1 = r1.trim();	 Catch:{ Exception -> 0x0048, all -> 0x0045 }
        r0 = r1;
        goto L_0x004a;
    L_0x0042:
        r5 = r5 + 1;
        goto L_0x001b;
    L_0x0045:
        r0 = move-exception;
        r1 = r4;
        goto L_0x005e;
    L_0x0048:
        r1 = r4;
        goto L_0x0070;
    L_0x004a:
        r4.close();	 Catch:{ Exception -> 0x004d }
    L_0x004d:
        r3.close();	 Catch:{ Exception -> 0x0050 }
    L_0x0050:
        r2.close();	 Catch:{ Exception -> 0x007d }
        goto L_0x007d;
    L_0x0054:
        r0 = move-exception;
        goto L_0x005e;
    L_0x0056:
        r0 = move-exception;
        r3 = r1;
        goto L_0x005e;
    L_0x0059:
        r3 = r1;
        goto L_0x0070;
    L_0x005b:
        r0 = move-exception;
        r2 = r1;
        r3 = r2;
    L_0x005e:
        if (r1 == 0) goto L_0x0063;
    L_0x0060:
        r1.close();	 Catch:{ Exception -> 0x0063 }
    L_0x0063:
        if (r3 == 0) goto L_0x0068;
    L_0x0065:
        r3.close();	 Catch:{ Exception -> 0x0068 }
    L_0x0068:
        if (r2 == 0) goto L_0x006d;
    L_0x006a:
        r2.close();	 Catch:{ Exception -> 0x006d }
    L_0x006d:
        throw r0;
    L_0x006e:
        r2 = r1;
        r3 = r2;
    L_0x0070:
        if (r1 == 0) goto L_0x0075;
    L_0x0072:
        r1.close();	 Catch:{ Exception -> 0x0075 }
    L_0x0075:
        if (r3 == 0) goto L_0x007a;
    L_0x0077:
        r3.close();	 Catch:{ Exception -> 0x007a }
    L_0x007a:
        if (r2 == 0) goto L_0x007d;
    L_0x007c:
        goto L_0x0050;
    L_0x007d:
        if (r0 != 0) goto L_0x0081;
    L_0x007f:
        r0 = "";
    L_0x0081:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.d():java.lang.String");
    }

    public static java.lang.String d(android.content.Context r7) {
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
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "audio";	 Catch:{ Exception -> 0x0065 }
        r7 = r7.getSystemService(r1);	 Catch:{ Exception -> 0x0065 }
        r7 = (android.media.AudioManager) r7;	 Catch:{ Exception -> 0x0065 }
        r1 = r7.getRingerMode();	 Catch:{ Exception -> 0x0065 }
        r2 = 0;	 Catch:{ Exception -> 0x0065 }
        r3 = 1;	 Catch:{ Exception -> 0x0065 }
        if (r1 != 0) goto L_0x0017;	 Catch:{ Exception -> 0x0065 }
    L_0x0015:
        r1 = r3;	 Catch:{ Exception -> 0x0065 }
        goto L_0x0018;	 Catch:{ Exception -> 0x0065 }
    L_0x0017:
        r1 = r2;	 Catch:{ Exception -> 0x0065 }
    L_0x0018:
        r2 = r7.getStreamVolume(r2);	 Catch:{ Exception -> 0x0065 }
        r3 = r7.getStreamVolume(r3);	 Catch:{ Exception -> 0x0065 }
        r4 = 2;	 Catch:{ Exception -> 0x0065 }
        r4 = r7.getStreamVolume(r4);	 Catch:{ Exception -> 0x0065 }
        r5 = 3;	 Catch:{ Exception -> 0x0065 }
        r5 = r7.getStreamVolume(r5);	 Catch:{ Exception -> 0x0065 }
        r6 = 4;	 Catch:{ Exception -> 0x0065 }
        r7 = r7.getStreamVolume(r6);	 Catch:{ Exception -> 0x0065 }
        r6 = "ringermode";	 Catch:{ Exception -> 0x0065 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x0065 }
        r0.put(r6, r1);	 Catch:{ Exception -> 0x0065 }
        r1 = "call";	 Catch:{ Exception -> 0x0065 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ Exception -> 0x0065 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0065 }
        r1 = "system";	 Catch:{ Exception -> 0x0065 }
        r2 = java.lang.String.valueOf(r3);	 Catch:{ Exception -> 0x0065 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0065 }
        r1 = "ring";	 Catch:{ Exception -> 0x0065 }
        r2 = java.lang.String.valueOf(r4);	 Catch:{ Exception -> 0x0065 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0065 }
        r1 = "music";	 Catch:{ Exception -> 0x0065 }
        r2 = java.lang.String.valueOf(r5);	 Catch:{ Exception -> 0x0065 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0065 }
        r1 = "alarm";	 Catch:{ Exception -> 0x0065 }
        r7 = java.lang.String.valueOf(r7);	 Catch:{ Exception -> 0x0065 }
        r0.put(r1, r7);	 Catch:{ Exception -> 0x0065 }
    L_0x0065:
        r7 = r0.toString();
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.d(android.content.Context):java.lang.String");
    }

    public static java.lang.String e(android.content.Context r2) {
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
        if (r2 == 0) goto L_0x0012;
    L_0x0003:
        r1 = "phone";	 Catch:{ Exception -> 0x0012 }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x0012 }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Exception -> 0x0012 }
        if (r2 == 0) goto L_0x0012;	 Catch:{ Exception -> 0x0012 }
    L_0x000d:
        r2 = r2.getNetworkOperatorName();	 Catch:{ Exception -> 0x0012 }
        r0 = r2;
    L_0x0012:
        if (r0 == 0) goto L_0x001c;
    L_0x0014:
        r2 = "null";
        r2 = r2.equals(r0);
        if (r2 == 0) goto L_0x001e;
    L_0x001c:
        r0 = "";
    L_0x001e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.e(android.content.Context):java.lang.String");
    }

    public static String f() {
        String w = w();
        return !a.a(w) ? w : x();
    }

    public static java.lang.String f(android.content.Context r2) {
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
        r0 = "android.permission.READ_PHONE_STATE";
        r0 = a(r2, r0);
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        r2 = "";
        return r2;
    L_0x000b:
        r0 = "";
        if (r2 == 0) goto L_0x001e;
    L_0x000f:
        r1 = "phone";	 Catch:{ Exception -> 0x001e }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x001e }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Exception -> 0x001e }
        if (r2 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x001e }
    L_0x0019:
        r2 = r2.getLine1Number();	 Catch:{ Exception -> 0x001e }
        r0 = r2;
    L_0x001e:
        if (r0 != 0) goto L_0x0022;
    L_0x0020:
        r0 = "";
    L_0x0022:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.f(android.content.Context):java.lang.String");
    }

    public static java.lang.String g() {
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
        r1 = new java.io.FileReader;	 Catch:{ Exception -> 0x0046, all -> 0x0037 }
        r2 = "/proc/cpuinfo";	 Catch:{ Exception -> 0x0046, all -> 0x0037 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0046, all -> 0x0037 }
        r2 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0047, all -> 0x0032 }
        r2.<init>(r1);	 Catch:{ Exception -> 0x0047, all -> 0x0032 }
        r0 = r2.readLine();	 Catch:{ Exception -> 0x0030, all -> 0x002e }
        r3 = ":\\s+";	 Catch:{ Exception -> 0x0030, all -> 0x002e }
        r4 = 2;	 Catch:{ Exception -> 0x0030, all -> 0x002e }
        r0 = r0.split(r3, r4);	 Catch:{ Exception -> 0x0030, all -> 0x002e }
        if (r0 == 0) goto L_0x0027;	 Catch:{ Exception -> 0x0030, all -> 0x002e }
    L_0x001a:
        r3 = r0.length;	 Catch:{ Exception -> 0x0030, all -> 0x002e }
        r4 = 1;	 Catch:{ Exception -> 0x0030, all -> 0x002e }
        if (r3 <= r4) goto L_0x0027;	 Catch:{ Exception -> 0x0030, all -> 0x002e }
    L_0x001e:
        r0 = r0[r4];	 Catch:{ Exception -> 0x0030, all -> 0x002e }
        r1.close();	 Catch:{ Exception -> 0x0023 }
    L_0x0023:
        r2.close();	 Catch:{ Exception -> 0x0026 }
    L_0x0026:
        return r0;
    L_0x0027:
        r1.close();	 Catch:{ Exception -> 0x002a }
    L_0x002a:
        r2.close();	 Catch:{ Exception -> 0x0051 }
        goto L_0x0051;
    L_0x002e:
        r0 = move-exception;
        goto L_0x003b;
    L_0x0030:
        r0 = r2;
        goto L_0x0047;
    L_0x0032:
        r2 = move-exception;
        r5 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x003b;
    L_0x0037:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
        r1 = r2;
    L_0x003b:
        if (r1 == 0) goto L_0x0040;
    L_0x003d:
        r1.close();	 Catch:{ Exception -> 0x0040 }
    L_0x0040:
        if (r2 == 0) goto L_0x0045;
    L_0x0042:
        r2.close();	 Catch:{ Exception -> 0x0045 }
    L_0x0045:
        throw r0;
    L_0x0046:
        r1 = r0;
    L_0x0047:
        if (r1 == 0) goto L_0x004c;
    L_0x0049:
        r1.close();	 Catch:{ Exception -> 0x004c }
    L_0x004c:
        if (r0 == 0) goto L_0x0051;
    L_0x004e:
        r0.close();	 Catch:{ Exception -> 0x0051 }
    L_0x0051:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.g():java.lang.String");
    }

    public static java.lang.String g(android.content.Context r4) {
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
        if (r4 == 0) goto L_0x004e;
    L_0x0003:
        r1 = "sensor";	 Catch:{ Exception -> 0x004e }
        r4 = r4.getSystemService(r1);	 Catch:{ Exception -> 0x004e }
        r4 = (android.hardware.SensorManager) r4;	 Catch:{ Exception -> 0x004e }
        if (r4 == 0) goto L_0x004e;	 Catch:{ Exception -> 0x004e }
    L_0x000d:
        r1 = -1;	 Catch:{ Exception -> 0x004e }
        r4 = r4.getSensorList(r1);	 Catch:{ Exception -> 0x004e }
        if (r4 == 0) goto L_0x004e;	 Catch:{ Exception -> 0x004e }
    L_0x0014:
        r1 = r4.size();	 Catch:{ Exception -> 0x004e }
        if (r1 <= 0) goto L_0x004e;	 Catch:{ Exception -> 0x004e }
    L_0x001a:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x004e }
        r1.<init>();	 Catch:{ Exception -> 0x004e }
        r4 = r4.iterator();	 Catch:{ Exception -> 0x004e }
    L_0x0023:
        r2 = r4.hasNext();	 Catch:{ Exception -> 0x004e }
        if (r2 == 0) goto L_0x0045;	 Catch:{ Exception -> 0x004e }
    L_0x0029:
        r2 = r4.next();	 Catch:{ Exception -> 0x004e }
        r2 = (android.hardware.Sensor) r2;	 Catch:{ Exception -> 0x004e }
        r3 = r2.getName();	 Catch:{ Exception -> 0x004e }
        r1.append(r3);	 Catch:{ Exception -> 0x004e }
        r3 = r2.getVersion();	 Catch:{ Exception -> 0x004e }
        r1.append(r3);	 Catch:{ Exception -> 0x004e }
        r2 = r2.getVendor();	 Catch:{ Exception -> 0x004e }
        r1.append(r2);	 Catch:{ Exception -> 0x004e }
        goto L_0x0023;	 Catch:{ Exception -> 0x004e }
    L_0x0045:
        r4 = r1.toString();	 Catch:{ Exception -> 0x004e }
        r4 = com.alipay.b.a.a.a.a.d(r4);	 Catch:{ Exception -> 0x004e }
        r0 = r4;
    L_0x004e:
        if (r0 != 0) goto L_0x0052;
    L_0x0050:
        r0 = "";
    L_0x0052:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.g(android.content.Context):java.lang.String");
    }

    public static java.lang.String h() {
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
        r0 = "/proc/meminfo";
        r1 = 0;
        r2 = 0;
        r4 = new java.io.FileReader;	 Catch:{ Exception -> 0x0045, all -> 0x0036 }
        r4.<init>(r0);	 Catch:{ Exception -> 0x0045, all -> 0x0036 }
        r0 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0046, all -> 0x0031 }
        r5 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ Exception -> 0x0046, all -> 0x0031 }
        r0.<init>(r4, r5);	 Catch:{ Exception -> 0x0046, all -> 0x0031 }
        r1 = r0.readLine();	 Catch:{ Exception -> 0x002f, all -> 0x002d }
        if (r1 == 0) goto L_0x0026;	 Catch:{ Exception -> 0x002f, all -> 0x002d }
    L_0x0017:
        r5 = "\\s+";	 Catch:{ Exception -> 0x002f, all -> 0x002d }
        r1 = r1.split(r5);	 Catch:{ Exception -> 0x002f, all -> 0x002d }
        r5 = 1;	 Catch:{ Exception -> 0x002f, all -> 0x002d }
        r1 = r1[r5];	 Catch:{ Exception -> 0x002f, all -> 0x002d }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ Exception -> 0x002f, all -> 0x002d }
        r1 = (long) r1;
        r2 = r1;
    L_0x0026:
        r4.close();	 Catch:{ Exception -> 0x0029 }
    L_0x0029:
        r0.close();	 Catch:{ Exception -> 0x0050 }
        goto L_0x0050;
    L_0x002d:
        r1 = move-exception;
        goto L_0x003a;
    L_0x002f:
        r1 = r0;
        goto L_0x0046;
    L_0x0031:
        r0 = move-exception;
        r6 = r1;
        r1 = r0;
        r0 = r6;
        goto L_0x003a;
    L_0x0036:
        r0 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x003a:
        if (r4 == 0) goto L_0x003f;
    L_0x003c:
        r4.close();	 Catch:{ Exception -> 0x003f }
    L_0x003f:
        if (r0 == 0) goto L_0x0044;
    L_0x0041:
        r0.close();	 Catch:{ Exception -> 0x0044 }
    L_0x0044:
        throw r1;
    L_0x0045:
        r4 = r1;
    L_0x0046:
        if (r4 == 0) goto L_0x004b;
    L_0x0048:
        r4.close();	 Catch:{ Exception -> 0x004b }
    L_0x004b:
        if (r1 == 0) goto L_0x0050;
    L_0x004d:
        r1.close();	 Catch:{ Exception -> 0x0050 }
    L_0x0050:
        r0 = java.lang.String.valueOf(r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.h():java.lang.String");
    }

    public static java.lang.String h(android.content.Context r5) {
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
        r0 = new org.json.JSONArray;
        r0.<init>();
        if (r5 == 0) goto L_0x0054;
    L_0x0007:
        r1 = "sensor";	 Catch:{ Exception -> 0x0054 }
        r5 = r5.getSystemService(r1);	 Catch:{ Exception -> 0x0054 }
        r5 = (android.hardware.SensorManager) r5;	 Catch:{ Exception -> 0x0054 }
        if (r5 == 0) goto L_0x0054;	 Catch:{ Exception -> 0x0054 }
    L_0x0011:
        r1 = -1;	 Catch:{ Exception -> 0x0054 }
        r5 = r5.getSensorList(r1);	 Catch:{ Exception -> 0x0054 }
        if (r5 == 0) goto L_0x0054;	 Catch:{ Exception -> 0x0054 }
    L_0x0018:
        r1 = r5.size();	 Catch:{ Exception -> 0x0054 }
        if (r1 <= 0) goto L_0x0054;	 Catch:{ Exception -> 0x0054 }
    L_0x001e:
        r5 = r5.iterator();	 Catch:{ Exception -> 0x0054 }
    L_0x0022:
        r1 = r5.hasNext();	 Catch:{ Exception -> 0x0054 }
        if (r1 == 0) goto L_0x0054;	 Catch:{ Exception -> 0x0054 }
    L_0x0028:
        r1 = r5.next();	 Catch:{ Exception -> 0x0054 }
        r1 = (android.hardware.Sensor) r1;	 Catch:{ Exception -> 0x0054 }
        if (r1 == 0) goto L_0x0022;	 Catch:{ Exception -> 0x0054 }
    L_0x0030:
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0054 }
        r2.<init>();	 Catch:{ Exception -> 0x0054 }
        r3 = "name";	 Catch:{ Exception -> 0x0054 }
        r4 = r1.getName();	 Catch:{ Exception -> 0x0054 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x0054 }
        r3 = "version";	 Catch:{ Exception -> 0x0054 }
        r4 = r1.getVersion();	 Catch:{ Exception -> 0x0054 }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x0054 }
        r3 = "vendor";	 Catch:{ Exception -> 0x0054 }
        r1 = r1.getVendor();	 Catch:{ Exception -> 0x0054 }
        r2.put(r3, r1);	 Catch:{ Exception -> 0x0054 }
        r0.put(r2);	 Catch:{ Exception -> 0x0054 }
        goto L_0x0022;
    L_0x0054:
        r5 = r0.toString();
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.h(android.content.Context):java.lang.String");
    }

    public static java.lang.String i() {
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
        r0 = android.os.Environment.getDataDirectory();	 Catch:{ Exception -> 0x0019 }
        r1 = new android.os.StatFs;	 Catch:{ Exception -> 0x0019 }
        r0 = r0.getPath();	 Catch:{ Exception -> 0x0019 }
        r1.<init>(r0);	 Catch:{ Exception -> 0x0019 }
        r0 = r1.getBlockSize();	 Catch:{ Exception -> 0x0019 }
        r2 = (long) r0;	 Catch:{ Exception -> 0x0019 }
        r0 = r1.getBlockCount();	 Catch:{ Exception -> 0x0019 }
        r0 = (long) r0;
        r0 = r0 * r2;
        goto L_0x001b;
    L_0x0019:
        r0 = 0;
    L_0x001b:
        r0 = java.lang.String.valueOf(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.i():java.lang.String");
    }

    public static java.lang.String i(android.content.Context r2) {
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
        r2 = r2.getResources();	 Catch:{ Exception -> 0x0029 }
        r2 = r2.getDisplayMetrics();	 Catch:{ Exception -> 0x0029 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0029 }
        r0.<init>();	 Catch:{ Exception -> 0x0029 }
        r1 = r2.widthPixels;	 Catch:{ Exception -> 0x0029 }
        r1 = java.lang.Integer.toString(r1);	 Catch:{ Exception -> 0x0029 }
        r0.append(r1);	 Catch:{ Exception -> 0x0029 }
        r1 = "*";	 Catch:{ Exception -> 0x0029 }
        r0.append(r1);	 Catch:{ Exception -> 0x0029 }
        r2 = r2.heightPixels;	 Catch:{ Exception -> 0x0029 }
        r2 = java.lang.Integer.toString(r2);	 Catch:{ Exception -> 0x0029 }
        r0.append(r2);	 Catch:{ Exception -> 0x0029 }
        r2 = r0.toString();	 Catch:{ Exception -> 0x0029 }
        return r2;
    L_0x0029:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.i(android.content.Context):java.lang.String");
    }

    public static java.lang.String j() {
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
        r2 = android.os.Environment.getExternalStorageState();	 Catch:{ Exception -> 0x0027 }
        r3 = "mounted";	 Catch:{ Exception -> 0x0027 }
        r2 = r3.equals(r2);	 Catch:{ Exception -> 0x0027 }
        if (r2 == 0) goto L_0x0027;	 Catch:{ Exception -> 0x0027 }
    L_0x000e:
        r2 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x0027 }
        r3 = new android.os.StatFs;	 Catch:{ Exception -> 0x0027 }
        r2 = r2.getPath();	 Catch:{ Exception -> 0x0027 }
        r3.<init>(r2);	 Catch:{ Exception -> 0x0027 }
        r2 = r3.getBlockSize();	 Catch:{ Exception -> 0x0027 }
        r4 = (long) r2;	 Catch:{ Exception -> 0x0027 }
        r2 = r3.getBlockCount();	 Catch:{ Exception -> 0x0027 }
        r0 = (long) r2;
        r4 = r4 * r0;
        r0 = r4;
    L_0x0027:
        r0 = java.lang.String.valueOf(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.j():java.lang.String");
    }

    public static java.lang.String j(android.content.Context r1) {
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
        r1 = r1.getResources();	 Catch:{ Exception -> 0x0017 }
        r1 = r1.getDisplayMetrics();	 Catch:{ Exception -> 0x0017 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0017 }
        r0.<init>();	 Catch:{ Exception -> 0x0017 }
        r1 = r1.widthPixels;	 Catch:{ Exception -> 0x0017 }
        r0.append(r1);	 Catch:{ Exception -> 0x0017 }
        r1 = r0.toString();	 Catch:{ Exception -> 0x0017 }
        return r1;
    L_0x0017:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.j(android.content.Context):java.lang.String");
    }

    public static java.lang.String k() {
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
        r1 = "android.os.SystemProperties";	 Catch:{ Exception -> 0x0030 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0030 }
        r2 = r1.newInstance();	 Catch:{ Exception -> 0x0030 }
        r3 = "get";	 Catch:{ Exception -> 0x0030 }
        r4 = 2;	 Catch:{ Exception -> 0x0030 }
        r5 = new java.lang.Class[r4];	 Catch:{ Exception -> 0x0030 }
        r6 = java.lang.String.class;	 Catch:{ Exception -> 0x0030 }
        r7 = 0;	 Catch:{ Exception -> 0x0030 }
        r5[r7] = r6;	 Catch:{ Exception -> 0x0030 }
        r6 = java.lang.String.class;	 Catch:{ Exception -> 0x0030 }
        r8 = 1;	 Catch:{ Exception -> 0x0030 }
        r5[r8] = r6;	 Catch:{ Exception -> 0x0030 }
        r1 = r1.getMethod(r3, r5);	 Catch:{ Exception -> 0x0030 }
        r3 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0030 }
        r4 = "gsm.version.baseband";	 Catch:{ Exception -> 0x0030 }
        r3[r7] = r4;	 Catch:{ Exception -> 0x0030 }
        r4 = "no message";	 Catch:{ Exception -> 0x0030 }
        r3[r8] = r4;	 Catch:{ Exception -> 0x0030 }
        r1 = r1.invoke(r2, r3);	 Catch:{ Exception -> 0x0030 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0030 }
        r0 = r1;
    L_0x0030:
        if (r0 != 0) goto L_0x0034;
    L_0x0032:
        r0 = "";
    L_0x0034:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.k():java.lang.String");
    }

    public static java.lang.String k(android.content.Context r1) {
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
        r1 = r1.getResources();	 Catch:{ Exception -> 0x0017 }
        r1 = r1.getDisplayMetrics();	 Catch:{ Exception -> 0x0017 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0017 }
        r0.<init>();	 Catch:{ Exception -> 0x0017 }
        r1 = r1.heightPixels;	 Catch:{ Exception -> 0x0017 }
        r0.append(r1);	 Catch:{ Exception -> 0x0017 }
        r1 = r0.toString();	 Catch:{ Exception -> 0x0017 }
        return r1;
    L_0x0017:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.k(android.content.Context):java.lang.String");
    }

    public static java.lang.String l() {
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
        r1 = android.os.Build.SERIAL;	 Catch:{ Exception -> 0x0005 }
        r0 = r1;
    L_0x0005:
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        r0 = "";
    L_0x0009:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.l():java.lang.String");
    }

    public static java.lang.String l(android.content.Context r2) {
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
        r0 = "android.permission.ACCESS_WIFI_STATE";
        r0 = a(r2, r0);
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        r2 = "";
        return r2;
    L_0x000b:
        r0 = "";
        r1 = "wifi";	 Catch:{ Exception -> 0x0032 }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x0032 }
        r2 = (android.net.wifi.WifiManager) r2;	 Catch:{ Exception -> 0x0032 }
        r2 = r2.getConnectionInfo();	 Catch:{ Exception -> 0x0032 }
        r2 = r2.getMacAddress();	 Catch:{ Exception -> 0x0032 }
        if (r2 == 0) goto L_0x002d;
    L_0x001f:
        r0 = r2.length();	 Catch:{ Exception -> 0x0033 }
        if (r0 == 0) goto L_0x002d;	 Catch:{ Exception -> 0x0033 }
    L_0x0025:
        r0 = "02:00:00:00:00:00";	 Catch:{ Exception -> 0x0033 }
        r0 = r0.equals(r2);	 Catch:{ Exception -> 0x0033 }
        if (r0 == 0) goto L_0x0033;	 Catch:{ Exception -> 0x0033 }
    L_0x002d:
        r0 = v();	 Catch:{ Exception -> 0x0033 }
        return r0;
    L_0x0032:
        r2 = r0;
    L_0x0033:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.l(android.content.Context):java.lang.String");
    }

    public static java.lang.String m() {
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
        r1 = java.util.Locale.getDefault();	 Catch:{ Exception -> 0x000b }
        r1 = r1.toString();	 Catch:{ Exception -> 0x000b }
        r0 = r1;
    L_0x000b:
        if (r0 != 0) goto L_0x000f;
    L_0x000d:
        r0 = "";
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.m():java.lang.String");
    }

    public static java.lang.String m(android.content.Context r2) {
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
        r0 = "android.permission.READ_PHONE_STATE";
        r0 = a(r2, r0);
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        r2 = "";
        return r2;
    L_0x000b:
        r0 = "";
        r1 = "phone";	 Catch:{ Exception -> 0x0025 }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x0025 }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Exception -> 0x0025 }
        r2 = r2.getSimSerialNumber();	 Catch:{ Exception -> 0x0025 }
        if (r2 == 0) goto L_0x0023;
    L_0x001b:
        if (r2 == 0) goto L_0x0026;
    L_0x001d:
        r0 = r2.length();	 Catch:{ Exception -> 0x0026 }
        if (r0 != 0) goto L_0x0026;	 Catch:{ Exception -> 0x0026 }
    L_0x0023:
        r0 = "";	 Catch:{ Exception -> 0x0026 }
    L_0x0025:
        r2 = r0;
    L_0x0026:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.m(android.content.Context):java.lang.String");
    }

    public static java.lang.String n() {
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
        r1 = java.util.TimeZone.getDefault();	 Catch:{ Exception -> 0x000c }
        r2 = 0;	 Catch:{ Exception -> 0x000c }
        r1 = r1.getDisplayName(r2, r2);	 Catch:{ Exception -> 0x000c }
        r0 = r1;
    L_0x000c:
        if (r0 != 0) goto L_0x0010;
    L_0x000e:
        r0 = "";
    L_0x0010:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.n():java.lang.String");
    }

    public static java.lang.String n(android.content.Context r2) {
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
        r2 = r2.getContentResolver();	 Catch:{ Exception -> 0x000d }
        r1 = "android_id";	 Catch:{ Exception -> 0x000d }
        r2 = android.provider.Settings.Secure.getString(r2, r1);	 Catch:{ Exception -> 0x000d }
        goto L_0x000e;
    L_0x000d:
        r2 = r0;
    L_0x000e:
        if (r2 != 0) goto L_0x0012;
    L_0x0010:
        r2 = "";
    L_0x0012:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.n(android.content.Context):java.lang.String");
    }

    public static java.lang.String o() {
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
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x001d }
        r2 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Exception -> 0x001d }
        r4 = r0 - r2;	 Catch:{ Exception -> 0x001d }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x001d }
        r0.<init>();	 Catch:{ Exception -> 0x001d }
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x001d }
        r1 = r4 % r1;	 Catch:{ Exception -> 0x001d }
        r6 = r4 - r1;	 Catch:{ Exception -> 0x001d }
        r0.append(r6);	 Catch:{ Exception -> 0x001d }
        r0 = r0.toString();	 Catch:{ Exception -> 0x001d }
        return r0;
    L_0x001d:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.o():java.lang.String");
    }

    public static java.lang.String o(android.content.Context r2) {
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
        r0 = "android.permission.BLUETOOTH";
        r0 = a(r2, r0);
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        r2 = "";
        return r2;
    L_0x000b:
        r0 = y();
        if (r0 == 0) goto L_0x001f;
    L_0x0011:
        r1 = r0.length();	 Catch:{ Exception -> 0x002f }
        if (r1 == 0) goto L_0x001f;	 Catch:{ Exception -> 0x002f }
    L_0x0017:
        r1 = "02:00:00:00:00:00";	 Catch:{ Exception -> 0x002f }
        r1 = r1.equals(r0);	 Catch:{ Exception -> 0x002f }
        if (r1 == 0) goto L_0x002a;	 Catch:{ Exception -> 0x002f }
    L_0x001f:
        r2 = r2.getContentResolver();	 Catch:{ Exception -> 0x002f }
        r1 = "bluetooth_address";	 Catch:{ Exception -> 0x002f }
        r2 = android.provider.Settings.Secure.getString(r2, r1);	 Catch:{ Exception -> 0x002f }
        r0 = r2;	 Catch:{ Exception -> 0x002f }
    L_0x002a:
        if (r0 != 0) goto L_0x002f;	 Catch:{ Exception -> 0x002f }
    L_0x002c:
        r2 = "";	 Catch:{ Exception -> 0x002f }
        return r2;
    L_0x002f:
        r2 = r0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.o(android.content.Context):java.lang.String");
    }

    public static java.lang.String p() {
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
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0011 }
        r0.<init>();	 Catch:{ Exception -> 0x0011 }
        r1 = android.os.SystemClock.elapsedRealtime();	 Catch:{ Exception -> 0x0011 }
        r0.append(r1);	 Catch:{ Exception -> 0x0011 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0011 }
        return r0;
    L_0x0011:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.p():java.lang.String");
    }

    public static java.lang.String p(android.content.Context r1) {
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
        r0 = "phone";	 Catch:{ Exception -> 0x0013 }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x0013 }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x0013 }
        if (r1 == 0) goto L_0x0013;	 Catch:{ Exception -> 0x0013 }
    L_0x000a:
        r1 = r1.getNetworkType();	 Catch:{ Exception -> 0x0013 }
        r1 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x0013 }
        return r1;
    L_0x0013:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.p(android.content.Context):java.lang.String");
    }

    public static java.lang.String q() {
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
        r0 = "00";	 Catch:{ Exception -> 0x0061 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0061 }
        r1.<init>();	 Catch:{ Exception -> 0x0061 }
        r2 = 7;	 Catch:{ Exception -> 0x0061 }
        r3 = new java.lang.String[r2];	 Catch:{ Exception -> 0x0061 }
        r4 = "/dev/qemu_pipe";	 Catch:{ Exception -> 0x0061 }
        r5 = 0;	 Catch:{ Exception -> 0x0061 }
        r3[r5] = r4;	 Catch:{ Exception -> 0x0061 }
        r4 = "/dev/socket/qemud";	 Catch:{ Exception -> 0x0061 }
        r6 = 1;	 Catch:{ Exception -> 0x0061 }
        r3[r6] = r4;	 Catch:{ Exception -> 0x0061 }
        r4 = 2;	 Catch:{ Exception -> 0x0061 }
        r6 = "/system/lib/libc_malloc_debug_qemu.so";	 Catch:{ Exception -> 0x0061 }
        r3[r4] = r6;	 Catch:{ Exception -> 0x0061 }
        r4 = 3;	 Catch:{ Exception -> 0x0061 }
        r6 = "/sys/qemu_trace";	 Catch:{ Exception -> 0x0061 }
        r3[r4] = r6;	 Catch:{ Exception -> 0x0061 }
        r4 = 4;	 Catch:{ Exception -> 0x0061 }
        r6 = "/system/bin/qemu-props";	 Catch:{ Exception -> 0x0061 }
        r3[r4] = r6;	 Catch:{ Exception -> 0x0061 }
        r4 = 5;	 Catch:{ Exception -> 0x0061 }
        r6 = "/dev/socket/genyd";	 Catch:{ Exception -> 0x0061 }
        r3[r4] = r6;	 Catch:{ Exception -> 0x0061 }
        r4 = 6;	 Catch:{ Exception -> 0x0061 }
        r6 = "/dev/socket/baseband_genyd";	 Catch:{ Exception -> 0x0061 }
        r3[r4] = r6;	 Catch:{ Exception -> 0x0061 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0061 }
        r4.<init>();	 Catch:{ Exception -> 0x0061 }
        r4.append(r0);	 Catch:{ Exception -> 0x0061 }
        r0 = ":";	 Catch:{ Exception -> 0x0061 }
        r4.append(r0);	 Catch:{ Exception -> 0x0061 }
        r0 = r4.toString();	 Catch:{ Exception -> 0x0061 }
        r1.append(r0);	 Catch:{ Exception -> 0x0061 }
    L_0x0041:
        if (r5 >= r2) goto L_0x005c;	 Catch:{ Exception -> 0x0061 }
    L_0x0043:
        r0 = r3[r5];	 Catch:{ Exception -> 0x0061 }
        r4 = new java.io.File;	 Catch:{ Exception -> 0x0061 }
        r4.<init>(r0);	 Catch:{ Exception -> 0x0061 }
        r0 = r4.exists();	 Catch:{ Exception -> 0x0061 }
        if (r0 == 0) goto L_0x0056;	 Catch:{ Exception -> 0x0061 }
    L_0x0050:
        r0 = "1";	 Catch:{ Exception -> 0x0061 }
    L_0x0052:
        r1.append(r0);	 Catch:{ Exception -> 0x0061 }
        goto L_0x0059;	 Catch:{ Exception -> 0x0061 }
    L_0x0056:
        r0 = "0";	 Catch:{ Exception -> 0x0061 }
        goto L_0x0052;	 Catch:{ Exception -> 0x0061 }
    L_0x0059:
        r5 = r5 + 1;	 Catch:{ Exception -> 0x0061 }
        goto L_0x0041;	 Catch:{ Exception -> 0x0061 }
    L_0x005c:
        r0 = r1.toString();	 Catch:{ Exception -> 0x0061 }
        return r0;
    L_0x0061:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.q():java.lang.String");
    }

    public static java.lang.String q(android.content.Context r2) {
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
        r1 = "android.permission.ACCESS_WIFI_STATE";
        r1 = a(r2, r1);
        if (r1 == 0) goto L_0x000d;
    L_0x000a:
        r2 = "";
        return r2;
    L_0x000d:
        r1 = "wifi";	 Catch:{ Throwable -> 0x0024 }
        r2 = r2.getSystemService(r1);	 Catch:{ Throwable -> 0x0024 }
        r2 = (android.net.wifi.WifiManager) r2;	 Catch:{ Throwable -> 0x0024 }
        r1 = r2.isWifiEnabled();	 Catch:{ Throwable -> 0x0024 }
        if (r1 == 0) goto L_0x0024;	 Catch:{ Throwable -> 0x0024 }
    L_0x001b:
        r2 = r2.getConnectionInfo();	 Catch:{ Throwable -> 0x0024 }
        r2 = r2.getBSSID();	 Catch:{ Throwable -> 0x0024 }
        r0 = r2;
    L_0x0024:
        if (r0 != 0) goto L_0x0028;
    L_0x0026:
        r0 = "";
    L_0x0028:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.q(android.content.Context):java.lang.String");
    }

    public static java.lang.String r() {
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
        r0 = "00";
        r1 = 1;
        r1 = new java.lang.String[r1];
        r2 = "dalvik.system.Taint";
        r3 = 0;
        r1[r3] = r2;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r0 = ":";
        r2.append(r0);
        r0 = r3;
    L_0x0018:
        if (r0 > 0) goto L_0x002d;
    L_0x001a:
        r4 = r1[r3];
        java.lang.Class.forName(r4);	 Catch:{ Exception -> 0x0025 }
        r4 = "1";	 Catch:{ Exception -> 0x0025 }
        r2.append(r4);	 Catch:{ Exception -> 0x0025 }
        goto L_0x002a;
    L_0x0025:
        r4 = "0";
        r2.append(r4);
    L_0x002a:
        r0 = r0 + 1;
        goto L_0x0018;
    L_0x002d:
        r0 = r2.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.r():java.lang.String");
    }

    public static java.lang.String r(android.content.Context r4) {
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
        r1 = "android.permission.ACCESS_NETWORK_STATE";	 Catch:{ Exception -> 0x009d }
        r1 = a(r4, r1);	 Catch:{ Exception -> 0x009d }
        if (r1 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x009d }
    L_0x000a:
        r4 = "";	 Catch:{ Exception -> 0x009d }
        goto L_0x0074;	 Catch:{ Exception -> 0x009d }
    L_0x000e:
        r1 = "connectivity";	 Catch:{ Exception -> 0x009d }
        r4 = r4.getSystemService(r1);	 Catch:{ Exception -> 0x009d }
        r4 = (android.net.ConnectivityManager) r4;	 Catch:{ Exception -> 0x009d }
        r4 = r4.getActiveNetworkInfo();	 Catch:{ Exception -> 0x009d }
        r1 = 0;	 Catch:{ Exception -> 0x009d }
        if (r4 != 0) goto L_0x001f;	 Catch:{ Exception -> 0x009d }
    L_0x001d:
        r4 = r1;	 Catch:{ Exception -> 0x009d }
        goto L_0x0074;	 Catch:{ Exception -> 0x009d }
    L_0x001f:
        r2 = r4.getType();	 Catch:{ Exception -> 0x009d }
        r3 = 1;	 Catch:{ Exception -> 0x009d }
        if (r2 != r3) goto L_0x0029;	 Catch:{ Exception -> 0x009d }
    L_0x0026:
        r4 = "WIFI";	 Catch:{ Exception -> 0x009d }
        goto L_0x0074;	 Catch:{ Exception -> 0x009d }
    L_0x0029:
        r2 = r4.getType();	 Catch:{ Exception -> 0x009d }
        if (r2 != 0) goto L_0x001d;	 Catch:{ Exception -> 0x009d }
    L_0x002f:
        r4 = r4.getSubtype();	 Catch:{ Exception -> 0x009d }
        r1 = 4;	 Catch:{ Exception -> 0x009d }
        if (r4 == r1) goto L_0x0072;	 Catch:{ Exception -> 0x009d }
    L_0x0036:
        if (r4 == r3) goto L_0x0072;	 Catch:{ Exception -> 0x009d }
    L_0x0038:
        r1 = 2;	 Catch:{ Exception -> 0x009d }
        if (r4 == r1) goto L_0x0072;	 Catch:{ Exception -> 0x009d }
    L_0x003b:
        r1 = 7;	 Catch:{ Exception -> 0x009d }
        if (r4 == r1) goto L_0x0072;	 Catch:{ Exception -> 0x009d }
    L_0x003e:
        r1 = 11;	 Catch:{ Exception -> 0x009d }
        if (r4 != r1) goto L_0x0043;	 Catch:{ Exception -> 0x009d }
    L_0x0042:
        goto L_0x0072;	 Catch:{ Exception -> 0x009d }
    L_0x0043:
        r1 = 3;	 Catch:{ Exception -> 0x009d }
        if (r4 == r1) goto L_0x006f;	 Catch:{ Exception -> 0x009d }
    L_0x0046:
        r1 = 5;	 Catch:{ Exception -> 0x009d }
        if (r4 == r1) goto L_0x006f;	 Catch:{ Exception -> 0x009d }
    L_0x0049:
        r1 = 6;	 Catch:{ Exception -> 0x009d }
        if (r4 == r1) goto L_0x006f;	 Catch:{ Exception -> 0x009d }
    L_0x004c:
        r1 = 8;	 Catch:{ Exception -> 0x009d }
        if (r4 == r1) goto L_0x006f;	 Catch:{ Exception -> 0x009d }
    L_0x0050:
        r1 = 9;	 Catch:{ Exception -> 0x009d }
        if (r4 == r1) goto L_0x006f;	 Catch:{ Exception -> 0x009d }
    L_0x0054:
        r1 = 10;	 Catch:{ Exception -> 0x009d }
        if (r4 == r1) goto L_0x006f;	 Catch:{ Exception -> 0x009d }
    L_0x0058:
        r1 = 12;	 Catch:{ Exception -> 0x009d }
        if (r4 == r1) goto L_0x006f;	 Catch:{ Exception -> 0x009d }
    L_0x005c:
        r1 = 14;	 Catch:{ Exception -> 0x009d }
        if (r4 == r1) goto L_0x006f;	 Catch:{ Exception -> 0x009d }
    L_0x0060:
        r1 = 15;	 Catch:{ Exception -> 0x009d }
        if (r4 != r1) goto L_0x0065;	 Catch:{ Exception -> 0x009d }
    L_0x0064:
        goto L_0x006f;	 Catch:{ Exception -> 0x009d }
    L_0x0065:
        r1 = 13;	 Catch:{ Exception -> 0x009d }
        if (r4 != r1) goto L_0x006c;	 Catch:{ Exception -> 0x009d }
    L_0x0069:
        r4 = "4G";	 Catch:{ Exception -> 0x009d }
        goto L_0x0074;	 Catch:{ Exception -> 0x009d }
    L_0x006c:
        r4 = "UNKNOW";	 Catch:{ Exception -> 0x009d }
        goto L_0x0074;	 Catch:{ Exception -> 0x009d }
    L_0x006f:
        r4 = "3G";	 Catch:{ Exception -> 0x009d }
        goto L_0x0074;	 Catch:{ Exception -> 0x009d }
    L_0x0072:
        r4 = "2G";	 Catch:{ Exception -> 0x009d }
    L_0x0074:
        r1 = z();	 Catch:{ Exception -> 0x009d }
        r2 = com.alipay.b.a.a.a.a.b(r4);	 Catch:{ Exception -> 0x009d }
        if (r2 == 0) goto L_0x009d;	 Catch:{ Exception -> 0x009d }
    L_0x007e:
        r1 = com.alipay.b.a.a.a.a.b(r1);	 Catch:{ Exception -> 0x009d }
        if (r1 == 0) goto L_0x009d;	 Catch:{ Exception -> 0x009d }
    L_0x0084:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009d }
        r1.<init>();	 Catch:{ Exception -> 0x009d }
        r1.append(r4);	 Catch:{ Exception -> 0x009d }
        r4 = ":";	 Catch:{ Exception -> 0x009d }
        r1.append(r4);	 Catch:{ Exception -> 0x009d }
        r4 = z();	 Catch:{ Exception -> 0x009d }
        r1.append(r4);	 Catch:{ Exception -> 0x009d }
        r4 = r1.toString();	 Catch:{ Exception -> 0x009d }
        r0 = r4;
    L_0x009d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.r(android.content.Context):java.lang.String");
    }

    public static java.lang.String s() {
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
        r0 = "00";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = new java.util.LinkedHashMap;
        r2.<init>();
        r3 = "/system/build.prop";
        r4 = "ro.product.name=sdk";
        r2.put(r3, r4);
        r3 = "/proc/tty/drivers";
        r4 = "goldfish";
        r2.put(r3, r4);
        r3 = "/proc/cpuinfo";
        r4 = "goldfish";
        r2.put(r3, r4);
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r0);
        r0 = ":";
        r3.append(r0);
        r0 = r3.toString();
        r1.append(r0);
        r0 = r2.keySet();
        r0 = r0.iterator();
    L_0x003d:
        r3 = r0.hasNext();
        if (r3 == 0) goto L_0x0092;
    L_0x0043:
        r3 = r0.next();
        r3 = (java.lang.String) r3;
        r4 = 0;
        r5 = 48;
        r6 = new java.io.LineNumberReader;	 Catch:{ Exception -> 0x0089, all -> 0x007f }
        r7 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0089, all -> 0x007f }
        r8 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0089, all -> 0x007f }
        r8.<init>(r3);	 Catch:{ Exception -> 0x0089, all -> 0x007f }
        r7.<init>(r8);	 Catch:{ Exception -> 0x0089, all -> 0x007f }
        r6.<init>(r7);	 Catch:{ Exception -> 0x0089, all -> 0x007f }
    L_0x005b:
        r4 = r6.readLine();	 Catch:{ Exception -> 0x007d, all -> 0x007a }
        if (r4 == 0) goto L_0x0073;	 Catch:{ Exception -> 0x007d, all -> 0x007a }
    L_0x0061:
        r4 = r4.toLowerCase();	 Catch:{ Exception -> 0x007d, all -> 0x007a }
        r7 = r2.get(r3);	 Catch:{ Exception -> 0x007d, all -> 0x007a }
        r7 = (java.lang.CharSequence) r7;	 Catch:{ Exception -> 0x007d, all -> 0x007a }
        r4 = r4.contains(r7);	 Catch:{ Exception -> 0x007d, all -> 0x007a }
        if (r4 == 0) goto L_0x005b;
    L_0x0071:
        r5 = 49;
    L_0x0073:
        r1.append(r5);
        r6.close();	 Catch:{ Exception -> 0x003d }
        goto L_0x003d;
    L_0x007a:
        r0 = move-exception;
        r4 = r6;
        goto L_0x0080;
    L_0x007d:
        r4 = r6;
        goto L_0x0089;
    L_0x007f:
        r0 = move-exception;
    L_0x0080:
        r1.append(r5);
        if (r4 == 0) goto L_0x0088;
    L_0x0085:
        r4.close();	 Catch:{ Exception -> 0x0088 }
    L_0x0088:
        throw r0;
    L_0x0089:
        r1.append(r5);
        if (r4 == 0) goto L_0x003d;
    L_0x008e:
        r4.close();	 Catch:{ Exception -> 0x003d }
        goto L_0x003d;
    L_0x0092:
        r0 = r1.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.s():java.lang.String");
    }

    public static java.lang.String s(android.content.Context r9) {
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
        r0 = "keyguard";
        r9 = r9.getSystemService(r0);
        r9 = (android.app.KeyguardManager) r9;
        r9 = r9.isKeyguardSecure();
        if (r9 != 0) goto L_0x0011;
    L_0x000e:
        r9 = "0:0";
        return r9;
    L_0x0011:
        r9 = 5;
        r0 = new java.lang.String[r9];
        r1 = "/data/system/password.key";
        r2 = 0;
        r0[r2] = r1;
        r1 = "/data/system/gesture.key";
        r3 = 1;
        r0[r3] = r1;
        r1 = 2;
        r3 = "/data/system/gatekeeper.password.key";
        r0[r1] = r3;
        r1 = 3;
        r3 = "/data/system/gatekeeper.gesture.key";
        r0[r1] = r3;
        r1 = 4;
        r3 = "/data/system/gatekeeper.pattern.key";
        r0[r1] = r3;
        r3 = 0;
    L_0x002f:
        if (r2 >= r9) goto L_0x0046;
    L_0x0031:
        r1 = r0[r2];
        r5 = -1;
        r7 = new java.io.File;	 Catch:{ Exception -> 0x003f }
        r7.<init>(r1);	 Catch:{ Exception -> 0x003f }
        r7 = r7.lastModified();	 Catch:{ Exception -> 0x003f }
        r5 = r7;
    L_0x003f:
        r3 = java.lang.Math.max(r5, r3);
        r2 = r2 + 1;
        goto L_0x002f;
    L_0x0046:
        r9 = new java.lang.StringBuilder;
        r0 = "1:";
        r9.<init>(r0);
        r9.append(r3);
        r9 = r9.toString();
        return r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.s(android.content.Context):java.lang.String");
    }

    public static java.lang.String t() {
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
        r0 = "00";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r2.append(r0);
        r0 = ":";
        r2.append(r0);
        r0 = r2.toString();
        r1.append(r0);
        r0 = new java.util.LinkedHashMap;
        r0.<init>();
        r2 = "BRAND";
        r3 = "generic";
        r0.put(r2, r3);
        r2 = "BOARD";
        r3 = "unknown";
        r0.put(r2, r3);
        r2 = "DEVICE";
        r3 = "generic";
        r0.put(r2, r3);
        r2 = "HARDWARE";
        r3 = "goldfish";
        r0.put(r2, r3);
        r2 = "PRODUCT";
        r3 = "sdk";
        r0.put(r2, r3);
        r2 = "MODEL";
        r3 = "sdk";
        r0.put(r2, r3);
        r2 = r0.keySet();
        r2 = r2.iterator();
    L_0x0052:
        r3 = r2.hasNext();
        if (r3 == 0) goto L_0x008d;
    L_0x0058:
        r3 = r2.next();
        r3 = (java.lang.String) r3;
        r4 = 48;
        r5 = android.os.Build.class;	 Catch:{ Exception -> 0x0089, all -> 0x0084 }
        r5 = r5.getField(r3);	 Catch:{ Exception -> 0x0089, all -> 0x0084 }
        r6 = 0;	 Catch:{ Exception -> 0x0089, all -> 0x0084 }
        r5 = r5.get(r6);	 Catch:{ Exception -> 0x0089, all -> 0x0084 }
        r5 = (java.lang.String) r5;	 Catch:{ Exception -> 0x0089, all -> 0x0084 }
        r3 = r0.get(r3);	 Catch:{ Exception -> 0x0089, all -> 0x0084 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x0089, all -> 0x0084 }
        if (r5 == 0) goto L_0x0079;	 Catch:{ Exception -> 0x0089, all -> 0x0084 }
    L_0x0075:
        r6 = r5.toLowerCase();	 Catch:{ Exception -> 0x0089, all -> 0x0084 }
    L_0x0079:
        if (r6 == 0) goto L_0x0089;	 Catch:{ Exception -> 0x0089, all -> 0x0084 }
    L_0x007b:
        r3 = r6.contains(r3);	 Catch:{ Exception -> 0x0089, all -> 0x0084 }
        if (r3 == 0) goto L_0x0089;
    L_0x0081:
        r4 = 49;
        goto L_0x0089;
    L_0x0084:
        r0 = move-exception;
        r1.append(r4);
        throw r0;
    L_0x0089:
        r1.append(r4);
        goto L_0x0052;
    L_0x008d:
        r0 = r1.toString();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.t():java.lang.String");
    }

    public static java.lang.String t(android.content.Context r3) {
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
        r0 = new android.content.IntentFilter;	 Catch:{ Exception -> 0x003f }
        r1 = "android.intent.action.BATTERY_CHANGED";	 Catch:{ Exception -> 0x003f }
        r0.<init>(r1);	 Catch:{ Exception -> 0x003f }
        r1 = 0;	 Catch:{ Exception -> 0x003f }
        r3 = r3.registerReceiver(r1, r0);	 Catch:{ Exception -> 0x003f }
        r0 = "level";	 Catch:{ Exception -> 0x003f }
        r1 = -1;	 Catch:{ Exception -> 0x003f }
        r0 = r3.getIntExtra(r0, r1);	 Catch:{ Exception -> 0x003f }
        r2 = "status";	 Catch:{ Exception -> 0x003f }
        r3 = r3.getIntExtra(r2, r1);	 Catch:{ Exception -> 0x003f }
        r1 = 2;	 Catch:{ Exception -> 0x003f }
        if (r3 == r1) goto L_0x0022;	 Catch:{ Exception -> 0x003f }
    L_0x001c:
        r1 = 5;	 Catch:{ Exception -> 0x003f }
        if (r3 != r1) goto L_0x0020;	 Catch:{ Exception -> 0x003f }
    L_0x001f:
        goto L_0x0022;	 Catch:{ Exception -> 0x003f }
    L_0x0020:
        r3 = 0;	 Catch:{ Exception -> 0x003f }
        goto L_0x0023;	 Catch:{ Exception -> 0x003f }
    L_0x0022:
        r3 = 1;	 Catch:{ Exception -> 0x003f }
    L_0x0023:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003f }
        r1.<init>();	 Catch:{ Exception -> 0x003f }
        if (r3 == 0) goto L_0x002d;	 Catch:{ Exception -> 0x003f }
    L_0x002a:
        r3 = "1";	 Catch:{ Exception -> 0x003f }
        goto L_0x002f;	 Catch:{ Exception -> 0x003f }
    L_0x002d:
        r3 = "0";	 Catch:{ Exception -> 0x003f }
    L_0x002f:
        r1.append(r3);	 Catch:{ Exception -> 0x003f }
        r3 = ":";	 Catch:{ Exception -> 0x003f }
        r1.append(r3);	 Catch:{ Exception -> 0x003f }
        r1.append(r0);	 Catch:{ Exception -> 0x003f }
        r3 = r1.toString();	 Catch:{ Exception -> 0x003f }
        return r3;
    L_0x003f:
        r3 = "";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.t(android.content.Context):java.lang.String");
    }

    public static String u() {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("00");
        stringBuilder2.append(Constants.COLON_SEPARATOR);
        stringBuilder.append(stringBuilder2.toString());
        Map linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("ro.hardware", "goldfish");
        linkedHashMap.put("ro.kernel.qemu", "1");
        linkedHashMap.put("ro.product.device", "generic");
        linkedHashMap.put("ro.product.model", "sdk");
        linkedHashMap.put("ro.product.brand", "generic");
        linkedHashMap.put("ro.product.name", "sdk");
        linkedHashMap.put("ro.build.fingerprint", "test-keys");
        linkedHashMap.put("ro.product.manufacturer", "unknow");
        for (String str : linkedHashMap.keySet()) {
            char c = '0';
            String str2 = (String) linkedHashMap.get(str);
            String str3 = a.b(str3, "");
            if (str3 != null && str3.contains(str2)) {
                c = '1';
            }
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static java.lang.String v() {
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
        r0 = java.net.NetworkInterface.getNetworkInterfaces();	 Catch:{ Exception -> 0x006d }
        r0 = java.util.Collections.list(r0);	 Catch:{ Exception -> 0x006d }
        if (r0 == 0) goto L_0x006d;	 Catch:{ Exception -> 0x006d }
    L_0x000a:
        r0 = r0.iterator();	 Catch:{ Exception -> 0x006d }
    L_0x000e:
        r1 = r0.hasNext();	 Catch:{ Exception -> 0x006d }
        if (r1 == 0) goto L_0x006d;	 Catch:{ Exception -> 0x006d }
    L_0x0014:
        r1 = r0.next();	 Catch:{ Exception -> 0x006d }
        r1 = (java.net.NetworkInterface) r1;	 Catch:{ Exception -> 0x006d }
        if (r1 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x006d }
    L_0x001c:
        r2 = r1.getName();	 Catch:{ Exception -> 0x006d }
        if (r2 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x006d }
    L_0x0022:
        r2 = r1.getName();	 Catch:{ Exception -> 0x006d }
        r3 = "wlan0";	 Catch:{ Exception -> 0x006d }
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ Exception -> 0x006d }
        if (r2 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x006d }
    L_0x002e:
        r0 = r1.getHardwareAddress();	 Catch:{ Exception -> 0x006d }
        if (r0 != 0) goto L_0x0037;	 Catch:{ Exception -> 0x006d }
    L_0x0034:
        r0 = "02:00:00:00:00:00";	 Catch:{ Exception -> 0x006d }
        return r0;	 Catch:{ Exception -> 0x006d }
    L_0x0037:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x006d }
        r1.<init>();	 Catch:{ Exception -> 0x006d }
        r2 = r0.length;	 Catch:{ Exception -> 0x006d }
        r3 = 0;	 Catch:{ Exception -> 0x006d }
        r4 = r3;	 Catch:{ Exception -> 0x006d }
    L_0x003f:
        r5 = 1;	 Catch:{ Exception -> 0x006d }
        if (r4 >= r2) goto L_0x005a;	 Catch:{ Exception -> 0x006d }
    L_0x0042:
        r6 = r0[r4];	 Catch:{ Exception -> 0x006d }
        r7 = "%02X:";	 Catch:{ Exception -> 0x006d }
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x006d }
        r6 = r6 & 255;	 Catch:{ Exception -> 0x006d }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ Exception -> 0x006d }
        r5[r3] = r6;	 Catch:{ Exception -> 0x006d }
        r5 = java.lang.String.format(r7, r5);	 Catch:{ Exception -> 0x006d }
        r1.append(r5);	 Catch:{ Exception -> 0x006d }
        r4 = r4 + 1;	 Catch:{ Exception -> 0x006d }
        goto L_0x003f;	 Catch:{ Exception -> 0x006d }
    L_0x005a:
        r0 = r1.length();	 Catch:{ Exception -> 0x006d }
        if (r0 <= 0) goto L_0x0068;	 Catch:{ Exception -> 0x006d }
    L_0x0060:
        r0 = r1.length();	 Catch:{ Exception -> 0x006d }
        r0 = r0 - r5;	 Catch:{ Exception -> 0x006d }
        r1.deleteCharAt(r0);	 Catch:{ Exception -> 0x006d }
    L_0x0068:
        r0 = r1.toString();	 Catch:{ Exception -> 0x006d }
        return r0;
    L_0x006d:
        r0 = "02:00:00:00:00:00";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.v():java.lang.String");
    }

    private static java.lang.String w() {
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
        r0 = "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq";
        r1 = 0;
        r2 = new java.io.FileReader;	 Catch:{ Exception -> 0x0041, all -> 0x0034 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0041, all -> 0x0034 }
        r0 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0042, all -> 0x0032 }
        r3 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ Exception -> 0x0042, all -> 0x0032 }
        r0.<init>(r2, r3);	 Catch:{ Exception -> 0x0042, all -> 0x0032 }
        r1 = r0.readLine();	 Catch:{ Exception -> 0x0030, all -> 0x002b }
        r3 = com.alipay.b.a.a.a.a.a(r1);	 Catch:{ Exception -> 0x0030, all -> 0x002b }
        if (r3 != 0) goto L_0x0024;	 Catch:{ Exception -> 0x0030, all -> 0x002b }
    L_0x0019:
        r1 = r1.trim();	 Catch:{ Exception -> 0x0030, all -> 0x002b }
        r0.close();	 Catch:{ Exception -> 0x0020 }
    L_0x0020:
        r2.close();	 Catch:{ Exception -> 0x0023 }
    L_0x0023:
        return r1;
    L_0x0024:
        r0.close();	 Catch:{ Exception -> 0x0027 }
    L_0x0027:
        r2.close();	 Catch:{ Exception -> 0x004a }
        goto L_0x004a;
    L_0x002b:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
        goto L_0x0036;
    L_0x0030:
        r1 = r0;
        goto L_0x0042;
    L_0x0032:
        r0 = move-exception;
        goto L_0x0036;
    L_0x0034:
        r0 = move-exception;
        r2 = r1;
    L_0x0036:
        if (r1 == 0) goto L_0x003b;
    L_0x0038:
        r1.close();	 Catch:{ Exception -> 0x003b }
    L_0x003b:
        if (r2 == 0) goto L_0x0040;
    L_0x003d:
        r2.close();	 Catch:{ Exception -> 0x0040 }
    L_0x0040:
        throw r0;
    L_0x0041:
        r2 = r1;
    L_0x0042:
        if (r1 == 0) goto L_0x0047;
    L_0x0044:
        r1.close();	 Catch:{ Exception -> 0x0047 }
    L_0x0047:
        if (r2 == 0) goto L_0x004a;
    L_0x0049:
        goto L_0x0027;
    L_0x004a:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.w():java.lang.String");
    }

    private static java.lang.String x() {
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
        r0 = "/proc/cpuinfo";
        r1 = "";
        r2 = 0;
        r3 = new java.io.FileReader;	 Catch:{ Exception -> 0x0057, all -> 0x0049 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0057, all -> 0x0049 }
        r0 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0058, all -> 0x0046 }
        r4 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ Exception -> 0x0058, all -> 0x0046 }
        r0.<init>(r3, r4);	 Catch:{ Exception -> 0x0058, all -> 0x0046 }
    L_0x0011:
        r2 = r0.readLine();	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
        if (r2 == 0) goto L_0x003b;	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
    L_0x0017:
        r4 = com.alipay.b.a.a.a.a.a(r2);	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
        if (r4 != 0) goto L_0x0011;	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
    L_0x001d:
        r4 = ":";	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
        r2 = r2.split(r4);	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
        if (r2 == 0) goto L_0x0011;	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
    L_0x0025:
        r4 = r2.length;	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
        r5 = 1;	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
        if (r4 <= r5) goto L_0x0011;	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
    L_0x0029:
        r4 = 0;	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
        r4 = r2[r4];	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
        r6 = "BogoMIPS";	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
        r4 = r4.contains(r6);	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
        if (r4 == 0) goto L_0x0011;	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
    L_0x0034:
        r2 = r2[r5];	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
        r2 = r2.trim();	 Catch:{ Exception -> 0x0044, all -> 0x0042 }
        r1 = r2;
    L_0x003b:
        r3.close();	 Catch:{ Exception -> 0x003e }
    L_0x003e:
        r0.close();	 Catch:{ Exception -> 0x0062 }
        return r1;
    L_0x0042:
        r1 = move-exception;
        goto L_0x004c;
    L_0x0044:
        r2 = r0;
        goto L_0x0058;
    L_0x0046:
        r1 = move-exception;
        r0 = r2;
        goto L_0x004c;
    L_0x0049:
        r1 = move-exception;
        r0 = r2;
        r3 = r0;
    L_0x004c:
        if (r3 == 0) goto L_0x0051;
    L_0x004e:
        r3.close();	 Catch:{ Exception -> 0x0051 }
    L_0x0051:
        if (r0 == 0) goto L_0x0056;
    L_0x0053:
        r0.close();	 Catch:{ Exception -> 0x0056 }
    L_0x0056:
        throw r1;
    L_0x0057:
        r3 = r2;
    L_0x0058:
        if (r3 == 0) goto L_0x005d;
    L_0x005a:
        r3.close();	 Catch:{ Exception -> 0x005d }
    L_0x005d:
        if (r2 == 0) goto L_0x0062;
    L_0x005f:
        r2.close();	 Catch:{ Exception -> 0x0062 }
    L_0x0062:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.x():java.lang.String");
    }

    private static java.lang.String y() {
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
        r1 = android.bluetooth.BluetoothAdapter.getDefaultAdapter();	 Catch:{ Exception -> 0x0016 }
        if (r1 == 0) goto L_0x0011;	 Catch:{ Exception -> 0x0016 }
    L_0x0008:
        r2 = r1.isEnabled();	 Catch:{ Exception -> 0x0016 }
        if (r2 != 0) goto L_0x0011;	 Catch:{ Exception -> 0x0016 }
    L_0x000e:
        r1 = "";	 Catch:{ Exception -> 0x0016 }
        return r1;	 Catch:{ Exception -> 0x0016 }
    L_0x0011:
        r1 = r1.getAddress();	 Catch:{ Exception -> 0x0016 }
        r0 = r1;
    L_0x0016:
        if (r0 != 0) goto L_0x001a;
    L_0x0018:
        r0 = "";
    L_0x001a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.y():java.lang.String");
    }

    private static java.lang.String z() {
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
        r0 = java.net.NetworkInterface.getNetworkInterfaces();	 Catch:{ Exception -> 0x0033 }
    L_0x0004:
        r1 = r0.hasMoreElements();	 Catch:{ Exception -> 0x0033 }
        if (r1 == 0) goto L_0x0033;	 Catch:{ Exception -> 0x0033 }
    L_0x000a:
        r1 = r0.nextElement();	 Catch:{ Exception -> 0x0033 }
        r1 = (java.net.NetworkInterface) r1;	 Catch:{ Exception -> 0x0033 }
        r1 = r1.getInetAddresses();	 Catch:{ Exception -> 0x0033 }
    L_0x0014:
        r2 = r1.hasMoreElements();	 Catch:{ Exception -> 0x0033 }
        if (r2 == 0) goto L_0x0004;	 Catch:{ Exception -> 0x0033 }
    L_0x001a:
        r2 = r1.nextElement();	 Catch:{ Exception -> 0x0033 }
        r2 = (java.net.InetAddress) r2;	 Catch:{ Exception -> 0x0033 }
        r3 = r2.isLoopbackAddress();	 Catch:{ Exception -> 0x0033 }
        if (r3 != 0) goto L_0x0014;	 Catch:{ Exception -> 0x0033 }
    L_0x0026:
        r3 = r2 instanceof java.net.Inet4Address;	 Catch:{ Exception -> 0x0033 }
        if (r3 == 0) goto L_0x0014;	 Catch:{ Exception -> 0x0033 }
    L_0x002a:
        r0 = r2.getHostAddress();	 Catch:{ Exception -> 0x0033 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0033 }
        return r0;
    L_0x0033:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.z():java.lang.String");
    }

    public final java.lang.String e() {
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
        r0 = new java.io.File;	 Catch:{ Exception -> 0x0016 }
        r1 = "/sys/devices/system/cpu/";	 Catch:{ Exception -> 0x0016 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0016 }
        r1 = new com.alipay.b.a.a.b.c;	 Catch:{ Exception -> 0x0016 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0016 }
        r0 = r0.listFiles(r1);	 Catch:{ Exception -> 0x0016 }
        r0 = r0.length;	 Catch:{ Exception -> 0x0016 }
        r0 = java.lang.String.valueOf(r0);	 Catch:{ Exception -> 0x0016 }
        return r0;
    L_0x0016:
        r0 = "1";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.b.b.e():java.lang.String");
    }
}
