package com.alibaba.mtl.log.e;

import android.text.TextUtils;
import com.xiaomi.push.service.av;
import java.util.Map;

/* compiled from: DeviceUtil */
public final class d {
    private static Map<String, String> a;

    public static synchronized java.util.Map<java.lang.String, java.lang.String> a(android.content.Context r6) {
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
        r0 = com.alibaba.mtl.log.e.d.class;
        monitor-enter(r0);
        r1 = a;	 Catch:{ all -> 0x0173 }
        if (r1 == 0) goto L_0x005c;	 Catch:{ all -> 0x0173 }
    L_0x0007:
        r1 = a;	 Catch:{ all -> 0x0173 }
        r2 = com.alibaba.mtl.log.model.LogField.CHANNEL;	 Catch:{ all -> 0x0173 }
        r2 = r2.toString();	 Catch:{ all -> 0x0173 }
        r3 = com.alibaba.mtl.log.e.b.c();	 Catch:{ all -> 0x0173 }
        r1.put(r2, r3);	 Catch:{ all -> 0x0173 }
        r1 = a;	 Catch:{ all -> 0x0173 }
        r2 = com.alibaba.mtl.log.model.LogField.APPKEY;	 Catch:{ all -> 0x0173 }
        r2 = r2.toString();	 Catch:{ all -> 0x0173 }
        r3 = com.alibaba.mtl.log.e.b.f();	 Catch:{ all -> 0x0173 }
        r1.put(r2, r3);	 Catch:{ all -> 0x0173 }
        r1 = com.alibaba.mtl.log.e.m.a(r6);	 Catch:{ all -> 0x0173 }
        r2 = com.alibaba.mtl.log.e.m.b(r6);	 Catch:{ all -> 0x0173 }
        r3 = android.text.TextUtils.isEmpty(r1);	 Catch:{ all -> 0x0173 }
        if (r3 != 0) goto L_0x0039;	 Catch:{ all -> 0x0173 }
    L_0x0033:
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ all -> 0x0173 }
        if (r3 == 0) goto L_0x003d;	 Catch:{ all -> 0x0173 }
    L_0x0039:
        r1 = "";	 Catch:{ all -> 0x0173 }
        r2 = "";	 Catch:{ all -> 0x0173 }
    L_0x003d:
        r3 = a;	 Catch:{ all -> 0x0173 }
        r4 = com.alibaba.mtl.log.model.LogField.IMEI;	 Catch:{ all -> 0x0173 }
        r4 = r4.toString();	 Catch:{ all -> 0x0173 }
        r3.put(r4, r1);	 Catch:{ all -> 0x0173 }
        r1 = a;	 Catch:{ all -> 0x0173 }
        r3 = com.alibaba.mtl.log.model.LogField.IMSI;	 Catch:{ all -> 0x0173 }
        r3 = r3.toString();	 Catch:{ all -> 0x0173 }
        r1.put(r3, r2);	 Catch:{ all -> 0x0173 }
        r1 = a;	 Catch:{ all -> 0x0173 }
        a(r1, r6);	 Catch:{ all -> 0x0173 }
        r6 = a;	 Catch:{ all -> 0x0173 }
        monitor-exit(r0);
        return r6;
    L_0x005c:
        r1 = new java.util.HashMap;	 Catch:{ all -> 0x0173 }
        r1.<init>();	 Catch:{ all -> 0x0173 }
        a = r1;	 Catch:{ all -> 0x0173 }
        r1 = 0;	 Catch:{ all -> 0x0173 }
        if (r6 == 0) goto L_0x0171;	 Catch:{ all -> 0x0173 }
    L_0x0066:
        r2 = a;	 Catch:{ all -> 0x0173 }
        if (r2 == 0) goto L_0x016d;
    L_0x006a:
        r2 = com.alibaba.mtl.log.e.m.a(r6);	 Catch:{ Exception -> 0x016b }
        r3 = com.alibaba.mtl.log.e.m.b(r6);	 Catch:{ Exception -> 0x016b }
        r4 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x016b }
        if (r4 != 0) goto L_0x007e;	 Catch:{ Exception -> 0x016b }
    L_0x0078:
        r4 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x016b }
        if (r4 == 0) goto L_0x0082;	 Catch:{ Exception -> 0x016b }
    L_0x007e:
        r2 = "";	 Catch:{ Exception -> 0x016b }
        r3 = "";	 Catch:{ Exception -> 0x016b }
    L_0x0082:
        r4 = a;	 Catch:{ Exception -> 0x016b }
        r5 = com.alibaba.mtl.log.model.LogField.IMEI;	 Catch:{ Exception -> 0x016b }
        r5 = r5.toString();	 Catch:{ Exception -> 0x016b }
        r4.put(r5, r2);	 Catch:{ Exception -> 0x016b }
        r2 = a;	 Catch:{ Exception -> 0x016b }
        r4 = com.alibaba.mtl.log.model.LogField.IMSI;	 Catch:{ Exception -> 0x016b }
        r4 = r4.toString();	 Catch:{ Exception -> 0x016b }
        r2.put(r4, r3);	 Catch:{ Exception -> 0x016b }
        r2 = a;	 Catch:{ Exception -> 0x016b }
        r3 = com.alibaba.mtl.log.model.LogField.BRAND;	 Catch:{ Exception -> 0x016b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x016b }
        r4 = android.os.Build.BRAND;	 Catch:{ Exception -> 0x016b }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x016b }
        r2 = a;	 Catch:{ Exception -> 0x016b }
        r3 = com.alibaba.mtl.log.model.LogField.DEVICE_MODEL;	 Catch:{ Exception -> 0x016b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x016b }
        r4 = android.os.Build.MODEL;	 Catch:{ Exception -> 0x016b }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x016b }
        r2 = a;	 Catch:{ Exception -> 0x016b }
        r3 = com.alibaba.mtl.log.model.LogField.RESOLUTION;	 Catch:{ Exception -> 0x016b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x016b }
        r4 = b(r6);	 Catch:{ Exception -> 0x016b }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x016b }
        r2 = a;	 Catch:{ Exception -> 0x016b }
        r3 = com.alibaba.mtl.log.model.LogField.CHANNEL;	 Catch:{ Exception -> 0x016b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x016b }
        r4 = com.alibaba.mtl.log.e.b.c();	 Catch:{ Exception -> 0x016b }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x016b }
        r2 = a;	 Catch:{ Exception -> 0x016b }
        r3 = com.alibaba.mtl.log.model.LogField.APPKEY;	 Catch:{ Exception -> 0x016b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x016b }
        r4 = com.alibaba.mtl.log.e.b.f();	 Catch:{ Exception -> 0x016b }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x016b }
        r2 = a;	 Catch:{ Exception -> 0x016b }
        r3 = com.alibaba.mtl.log.model.LogField.APPVERSION;	 Catch:{ Exception -> 0x016b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x016b }
        r4 = c(r6);	 Catch:{ Exception -> 0x016b }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x016b }
        r2 = a;	 Catch:{ Exception -> 0x016b }
        r3 = com.alibaba.mtl.log.model.LogField.LANGUAGE;	 Catch:{ Exception -> 0x016b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x016b }
        r4 = c();	 Catch:{ Exception -> 0x016b }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x016b }
        r2 = a;	 Catch:{ Exception -> 0x016b }
        r3 = com.alibaba.mtl.log.model.LogField.OS;	 Catch:{ Exception -> 0x016b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x016b }
        r4 = "a";	 Catch:{ Exception -> 0x016b }
        r5 = a();	 Catch:{ Exception -> 0x016b }
        if (r5 == 0) goto L_0x0115;	 Catch:{ Exception -> 0x016b }
    L_0x010d:
        r5 = d();	 Catch:{ Exception -> 0x016b }
        if (r5 != 0) goto L_0x0115;	 Catch:{ Exception -> 0x016b }
    L_0x0113:
        r4 = "y";	 Catch:{ Exception -> 0x016b }
    L_0x0115:
        r2.put(r3, r4);	 Catch:{ Exception -> 0x016b }
        r2 = a;	 Catch:{ Exception -> 0x016b }
        r3 = com.alibaba.mtl.log.model.LogField.OSVERSION;	 Catch:{ Exception -> 0x016b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x016b }
        r4 = android.os.Build.VERSION.RELEASE;	 Catch:{ Exception -> 0x016b }
        r5 = a();	 Catch:{ Exception -> 0x016b }
        if (r5 == 0) goto L_0x0134;	 Catch:{ Exception -> 0x016b }
    L_0x0128:
        r4 = "ro.yunos.version";	 Catch:{ Exception -> 0x016b }
        java.lang.System.getProperty(r4);	 Catch:{ Exception -> 0x016b }
        r4 = f();	 Catch:{ Exception -> 0x016b }
        android.text.TextUtils.isEmpty(r4);	 Catch:{ Exception -> 0x016b }
    L_0x0134:
        r2.put(r3, r4);	 Catch:{ Exception -> 0x016b }
        r2 = a;	 Catch:{ Exception -> 0x016b }
        r3 = com.alibaba.mtl.log.model.LogField.SDKVERSION;	 Catch:{ Exception -> 0x016b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x016b }
        r4 = "2.5.1_for_bc";	 Catch:{ Exception -> 0x016b }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x016b }
        r2 = a;	 Catch:{ Exception -> 0x016b }
        r3 = com.alibaba.mtl.log.model.LogField.SDKTYPE;	 Catch:{ Exception -> 0x016b }
        r3 = r3.toString();	 Catch:{ Exception -> 0x016b }
        r4 = "mini";	 Catch:{ Exception -> 0x016b }
        r2.put(r3, r4);	 Catch:{ Exception -> 0x016b }
        r2 = a;	 Catch:{ Throwable -> 0x0161 }
        r3 = com.alibaba.mtl.log.model.LogField.UTDID;	 Catch:{ Throwable -> 0x0161 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0161 }
        r4 = com.ut.device.UTDevice.getUtdid(r6);	 Catch:{ Throwable -> 0x0161 }
        r2.put(r3, r4);	 Catch:{ Throwable -> 0x0161 }
        goto L_0x0165;
    L_0x0161:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ Exception -> 0x016b }
    L_0x0165:
        r2 = a;	 Catch:{ Exception -> 0x016b }
        a(r2, r6);	 Catch:{ Exception -> 0x016b }
        goto L_0x016d;
    L_0x016b:
        monitor-exit(r0);
        return r1;
    L_0x016d:
        r6 = a;	 Catch:{ all -> 0x0173 }
        monitor-exit(r0);
        return r6;
    L_0x0171:
        monitor-exit(r0);
        return r1;
    L_0x0173:
        r6 = move-exception;
        monitor-exit(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.d.a(android.content.Context):java.util.Map<java.lang.String, java.lang.String>");
    }

    private static void a(java.util.Map<java.lang.String, java.lang.String> r4, android.content.Context r5) {
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
        r0 = com.alibaba.mtl.log.e.l.c();	 Catch:{ Exception -> 0x0033 }
        r1 = com.alibaba.mtl.log.model.LogField.ACCESS;	 Catch:{ Exception -> 0x0033 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0033 }
        r2 = 0;	 Catch:{ Exception -> 0x0033 }
        r3 = r0[r2];	 Catch:{ Exception -> 0x0033 }
        r4.put(r1, r3);	 Catch:{ Exception -> 0x0033 }
        r1 = r0[r2];	 Catch:{ Exception -> 0x0033 }
        r2 = "2G/3G";	 Catch:{ Exception -> 0x0033 }
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x0033 }
        if (r1 == 0) goto L_0x0027;	 Catch:{ Exception -> 0x0033 }
    L_0x001a:
        r1 = com.alibaba.mtl.log.model.LogField.ACCESS_SUBTYPE;	 Catch:{ Exception -> 0x0033 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0033 }
        r2 = 1;	 Catch:{ Exception -> 0x0033 }
        r0 = r0[r2];	 Catch:{ Exception -> 0x0033 }
        r4.put(r1, r0);	 Catch:{ Exception -> 0x0033 }
        goto L_0x0049;	 Catch:{ Exception -> 0x0033 }
    L_0x0027:
        r0 = com.alibaba.mtl.log.model.LogField.ACCESS_SUBTYPE;	 Catch:{ Exception -> 0x0033 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0033 }
        r1 = "Unknown";	 Catch:{ Exception -> 0x0033 }
        r4.put(r0, r1);	 Catch:{ Exception -> 0x0033 }
        goto L_0x0049;
    L_0x0033:
        r0 = com.alibaba.mtl.log.model.LogField.ACCESS;
        r0 = r0.toString();
        r1 = "Unknown";
        r4.put(r0, r1);
        r0 = com.alibaba.mtl.log.model.LogField.ACCESS_SUBTYPE;
        r0 = r0.toString();
        r1 = "Unknown";
        r4.put(r0, r1);
    L_0x0049:
        r0 = "phone";	 Catch:{ Exception -> 0x0072 }
        r5 = r5.getSystemService(r0);	 Catch:{ Exception -> 0x0072 }
        r5 = (android.telephony.TelephonyManager) r5;	 Catch:{ Exception -> 0x0072 }
        r0 = "";	 Catch:{ Exception -> 0x0072 }
        if (r5 == 0) goto L_0x0060;	 Catch:{ Exception -> 0x0072 }
    L_0x0055:
        r1 = r5.getSimState();	 Catch:{ Exception -> 0x0072 }
        r2 = 5;	 Catch:{ Exception -> 0x0072 }
        if (r1 != r2) goto L_0x0060;	 Catch:{ Exception -> 0x0072 }
    L_0x005c:
        r0 = r5.getNetworkOperatorName();	 Catch:{ Exception -> 0x0072 }
    L_0x0060:
        r5 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x0072 }
        if (r5 == 0) goto L_0x0068;	 Catch:{ Exception -> 0x0072 }
    L_0x0066:
        r0 = "Unknown";	 Catch:{ Exception -> 0x0072 }
    L_0x0068:
        r5 = com.alibaba.mtl.log.model.LogField.CARRIER;	 Catch:{ Exception -> 0x0072 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x0072 }
        r4.put(r5, r0);	 Catch:{ Exception -> 0x0072 }
        return;
    L_0x0072:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.d.a(java.util.Map, android.content.Context):void");
    }

    private static java.lang.String c() {
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
        r0 = "Unknown";
        r1 = java.util.Locale.getDefault();	 Catch:{ Throwable -> 0x000b }
        r1 = r1.getLanguage();	 Catch:{ Throwable -> 0x000b }
        r0 = r1;
    L_0x000b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.d.c():java.lang.String");
    }

    private static java.lang.String b(android.content.Context r3) {
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
        r0 = "Unknown";
        r3 = r3.getResources();	 Catch:{ Exception -> 0x0028 }
        r3 = r3.getDisplayMetrics();	 Catch:{ Exception -> 0x0028 }
        r1 = r3.widthPixels;	 Catch:{ Exception -> 0x0028 }
        r3 = r3.heightPixels;	 Catch:{ Exception -> 0x0028 }
        if (r1 <= r3) goto L_0x0013;	 Catch:{ Exception -> 0x0028 }
    L_0x0010:
        r1 = r1 ^ r3;	 Catch:{ Exception -> 0x0028 }
        r3 = r3 ^ r1;	 Catch:{ Exception -> 0x0028 }
        r1 = r1 ^ r3;	 Catch:{ Exception -> 0x0028 }
    L_0x0013:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0028 }
        r2.<init>();	 Catch:{ Exception -> 0x0028 }
        r2.append(r3);	 Catch:{ Exception -> 0x0028 }
        r3 = "*";	 Catch:{ Exception -> 0x0028 }
        r2.append(r3);	 Catch:{ Exception -> 0x0028 }
        r2.append(r1);	 Catch:{ Exception -> 0x0028 }
        r3 = r2.toString();	 Catch:{ Exception -> 0x0028 }
        goto L_0x0029;
    L_0x0028:
        r3 = r0;
    L_0x0029:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.d.b(android.content.Context):java.lang.String");
    }

    private static java.lang.String c(android.content.Context r4) {
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
        r0 = com.alibaba.mtl.log.b.a();
        r0 = r0.g;
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x000d;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = "Unknown";
        r1 = r4.getPackageManager();	 Catch:{ Throwable -> 0x002e }
        r4 = r4.getPackageName();	 Catch:{ Throwable -> 0x002e }
        r2 = 0;	 Catch:{ Throwable -> 0x002e }
        r4 = r1.getPackageInfo(r4, r2);	 Catch:{ Throwable -> 0x002e }
        if (r4 == 0) goto L_0x002e;	 Catch:{ Throwable -> 0x002e }
    L_0x001e:
        r1 = a;	 Catch:{ Throwable -> 0x002e }
        r2 = com.alibaba.mtl.log.model.LogField.APPVERSION;	 Catch:{ Throwable -> 0x002e }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x002e }
        r3 = r4.versionName;	 Catch:{ Throwable -> 0x002e }
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x002e }
        r4 = r4.versionName;	 Catch:{ Throwable -> 0x002e }
        r0 = r4;
    L_0x002e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.d.c(android.content.Context):java.lang.String");
    }

    public static boolean a() {
        if ((System.getProperty("java.vm.name") == null || !System.getProperty("java.vm.name").toLowerCase().contains("lemur")) && System.getProperty("ro.yunos.version") == null) {
            if (TextUtils.isEmpty(q.a("ro.yunos.build.version"))) {
                return d();
            }
        }
        return true;
    }

    private static boolean d() {
        if (TextUtils.isEmpty(a("ro.yunos.product.chip"))) {
            if (TextUtils.isEmpty(a("ro.yunos.hardware"))) {
                return false;
            }
        }
        return true;
    }

    private static String a(String str) {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls.newInstance(), new Object[]{str});
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static String b() {
        Object a = q.a("ro.aliyun.clouduuid", av.b);
        if (av.b.equals(a)) {
            a = q.a("ro.sys.aliyun.clouduuid", av.b);
        }
        return TextUtils.isEmpty(a) ? e() : a;
    }

    private static java.lang.String e() {
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
        r0 = 0;
        r1 = "com.yunos.baseservice.clouduuid.CloudUUID";	 Catch:{ Exception -> 0x0019 }
        r1 = java.lang.Class.forName(r1);	 Catch:{ Exception -> 0x0019 }
        r2 = "getCloudUUID";	 Catch:{ Exception -> 0x0019 }
        r3 = 0;	 Catch:{ Exception -> 0x0019 }
        r4 = new java.lang.Class[r3];	 Catch:{ Exception -> 0x0019 }
        r1 = r1.getMethod(r2, r4);	 Catch:{ Exception -> 0x0019 }
        r2 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x0019 }
        r1 = r1.invoke(r0, r2);	 Catch:{ Exception -> 0x0019 }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x0019 }
        r0 = r1;
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.d.e():java.lang.String");
    }

    private static java.lang.String f() {
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
        r0 = android.os.Build.class;	 Catch:{ Exception -> 0x001a }
        r1 = "YUNOS_BUILD_VERSION";	 Catch:{ Exception -> 0x001a }
        r0 = r0.getDeclaredField(r1);	 Catch:{ Exception -> 0x001a }
        if (r0 == 0) goto L_0x001a;	 Catch:{ Exception -> 0x001a }
    L_0x000a:
        r1 = 1;	 Catch:{ Exception -> 0x001a }
        r0.setAccessible(r1);	 Catch:{ Exception -> 0x001a }
        r1 = new java.lang.String;	 Catch:{ Exception -> 0x001a }
        r1.<init>();	 Catch:{ Exception -> 0x001a }
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x001a }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x001a }
        return r0;
    L_0x001a:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.d.f():java.lang.String");
    }
}
