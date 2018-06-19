package com.igexin.push.config;

import android.content.Context;
import com.igexin.b.a.c.a;
import com.igexin.push.util.e;

public class n {
    private static String a = "FileConfig";

    public static void a() {
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
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = com.igexin.push.core.g.e;
        r0.append(r1);
        r1 = ".properties";
        r0.append(r1);
        r0 = r0.toString();
        r1 = com.igexin.push.core.g.f;
        r1 = r1.getResources();
        r1 = r1.getAssets();
        r2 = 0;
        r0 = r1.open(r0);	 Catch:{ Exception -> 0x0035, all -> 0x002d }
        a(r0);	 Catch:{ Exception -> 0x0036, all -> 0x002b }
        if (r0 == 0) goto L_0x0039;
    L_0x0027:
        r0.close();	 Catch:{ Exception -> 0x0039 }
        goto L_0x0039;
    L_0x002b:
        r1 = move-exception;
        goto L_0x002f;
    L_0x002d:
        r1 = move-exception;
        r0 = r2;
    L_0x002f:
        if (r0 == 0) goto L_0x0034;
    L_0x0031:
        r0.close();	 Catch:{ Exception -> 0x0034 }
    L_0x0034:
        throw r1;
    L_0x0035:
        r0 = r2;
    L_0x0036:
        if (r0 == 0) goto L_0x0039;
    L_0x0038:
        goto L_0x0027;
    L_0x0039:
        r1 = new java.io.File;
        r3 = com.igexin.push.core.g.W;
        r1.<init>(r3);
        r1 = r1.exists();
        if (r1 != 0) goto L_0x0047;
    L_0x0046:
        return;
    L_0x0047:
        r1 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x00b3, all -> 0x00a3 }
        r3 = com.igexin.push.core.g.W;	 Catch:{ Exception -> 0x00b3, all -> 0x00a3 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x00b3, all -> 0x00a3 }
        r0 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00b4, all -> 0x009e }
        r3 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x00b4, all -> 0x009e }
        r4 = "UTF-8";	 Catch:{ Exception -> 0x00b4, all -> 0x009e }
        r3.<init>(r1, r4);	 Catch:{ Exception -> 0x00b4, all -> 0x009e }
        r0.<init>(r3);	 Catch:{ Exception -> 0x00b4, all -> 0x009e }
    L_0x005a:
        r2 = r0.readLine();	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        if (r2 == 0) goto L_0x0093;	 Catch:{ Exception -> 0x009c, all -> 0x009a }
    L_0x0060:
        r3 = "#";	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        r3 = r2.startsWith(r3);	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        if (r3 != 0) goto L_0x005a;	 Catch:{ Exception -> 0x009c, all -> 0x009a }
    L_0x0068:
        r3 = "=";	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        r2 = r2.split(r3);	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        r3 = r2.length;	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        r4 = 2;	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        if (r3 < r4) goto L_0x005a;	 Catch:{ Exception -> 0x009c, all -> 0x009a }
    L_0x0072:
        r3 = 0;	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        r3 = r2[r3];	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        r3 = r3.trim();	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        r4 = 1;	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        r2 = r2[r4];	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        r2 = r2.trim();	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        r4 = "sdk.debug";	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        if (r3 == 0) goto L_0x005a;	 Catch:{ Exception -> 0x009c, all -> 0x009a }
    L_0x0088:
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        r2 = r2.booleanValue();	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        com.igexin.b.a.c.a.a = r2;	 Catch:{ Exception -> 0x009c, all -> 0x009a }
        goto L_0x005a;
    L_0x0093:
        r0.close();	 Catch:{ IOException -> 0x0096 }
    L_0x0096:
        r1.close();	 Catch:{ Exception -> 0x0099 }
    L_0x0099:
        return;
    L_0x009a:
        r2 = move-exception;
        goto L_0x00a8;
    L_0x009c:
        r2 = r0;
        goto L_0x00b4;
    L_0x009e:
        r0 = move-exception;
        r5 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x00a8;
    L_0x00a3:
        r1 = move-exception;
        r5 = r1;
        r1 = r0;
        r0 = r2;
        r2 = r5;
    L_0x00a8:
        if (r0 == 0) goto L_0x00ad;
    L_0x00aa:
        r0.close();	 Catch:{ IOException -> 0x00ad }
    L_0x00ad:
        if (r1 == 0) goto L_0x00b2;
    L_0x00af:
        r1.close();	 Catch:{ Exception -> 0x00b2 }
    L_0x00b2:
        throw r2;
    L_0x00b3:
        r1 = r0;
    L_0x00b4:
        if (r2 == 0) goto L_0x00b9;
    L_0x00b6:
        r2.close();	 Catch:{ IOException -> 0x00b9 }
    L_0x00b9:
        if (r1 == 0) goto L_0x00be;
    L_0x00bb:
        r1.close();	 Catch:{ Exception -> 0x00be }
    L_0x00be:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.n.a():void");
    }

    public static void a(android.content.Context r5) {
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
        r5 = r5.getResources();
        r5 = r5.getAssets();
        r0 = 0;
        r1 = new java.io.InputStreamReader;	 Catch:{ Throwable -> 0x005e, all -> 0x004f }
        r2 = "green.cfg";	 Catch:{ Throwable -> 0x005e, all -> 0x004f }
        r5 = r5.open(r2);	 Catch:{ Throwable -> 0x005e, all -> 0x004f }
        r1.<init>(r5);	 Catch:{ Throwable -> 0x005e, all -> 0x004f }
        r5 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x005f, all -> 0x004a }
        r5.<init>(r1);	 Catch:{ Throwable -> 0x005f, all -> 0x004a }
    L_0x0019:
        r0 = r5.readLine();	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        if (r0 == 0) goto L_0x003f;	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
    L_0x001f:
        r2 = "=";	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r0 = r0.split(r2);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r2 = r0.length;	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r3 = 2;	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        if (r2 != r3) goto L_0x0019;	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
    L_0x0029:
        r2 = 0;	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r2 = r0[r2];	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r2 = r2.trim();	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r3 = 1;	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r0 = r0[r3];	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r0 = r0.trim();	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r3 = com.igexin.push.core.g.b();	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        r3.put(r2, r0);	 Catch:{ Throwable -> 0x0048, all -> 0x0046 }
        goto L_0x0019;
    L_0x003f:
        r1.close();	 Catch:{ Exception -> 0x0042 }
    L_0x0042:
        r5.close();	 Catch:{ Exception -> 0x0045 }
    L_0x0045:
        return;
    L_0x0046:
        r0 = move-exception;
        goto L_0x0053;
    L_0x0048:
        r0 = r5;
        goto L_0x005f;
    L_0x004a:
        r5 = move-exception;
        r4 = r0;
        r0 = r5;
        r5 = r4;
        goto L_0x0053;
    L_0x004f:
        r5 = move-exception;
        r1 = r0;
        r0 = r5;
        r5 = r1;
    L_0x0053:
        if (r1 == 0) goto L_0x0058;
    L_0x0055:
        r1.close();	 Catch:{ Exception -> 0x0058 }
    L_0x0058:
        if (r5 == 0) goto L_0x005d;
    L_0x005a:
        r5.close();	 Catch:{ Exception -> 0x005d }
    L_0x005d:
        throw r0;
    L_0x005e:
        r1 = r0;
    L_0x005f:
        if (r1 == 0) goto L_0x0064;
    L_0x0061:
        r1.close();	 Catch:{ Exception -> 0x0064 }
    L_0x0064:
        if (r0 == 0) goto L_0x0069;
    L_0x0066:
        r0.close();	 Catch:{ Exception -> 0x0069 }
    L_0x0069:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.n.a(android.content.Context):void");
    }

    public static void a(java.io.InputStream r7) {
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
        r1 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0245, all -> 0x0238 }
        r2 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x0245, all -> 0x0238 }
        r3 = "UTF-8";	 Catch:{ Exception -> 0x0245, all -> 0x0238 }
        r2.<init>(r7, r3);	 Catch:{ Exception -> 0x0245, all -> 0x0238 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0245, all -> 0x0238 }
    L_0x000d:
        r7 = r1.readLine();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r7 == 0) goto L_0x022b;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0013:
        r0 = "#";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r0 = r7.startsWith(r0);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r0 != 0) goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x001b:
        r0 = "=";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.split(r0);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r0 = r7.length;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = 2;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r0 < r2) goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0025:
        r0 = 0;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r0 = r7[r0];	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r0 = r0.trim();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = 1;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7[r2];	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.trim();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = "sdk.cm_address";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x0045;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x003b:
        r0 = ",";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.split(r0);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.SDKUrlConfig.setXfrAddressIps(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0045:
        r2 = "sdk.config_address";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x0056;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x004d:
        r0 = ",";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.split(r0);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.SDKUrlConfig.CONFIG_ADDRESS_IPS = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0056:
        r2 = "sdk.bi_address";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x0067;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x005e:
        r0 = ",";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.split(r0);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.SDKUrlConfig.BI_ADDRESS_IPS = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0067:
        r2 = "sdk.state_address";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x0078;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x006f:
        r0 = ",";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.split(r0);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.SDKUrlConfig.STATE_ADDRESS_IPS = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0078:
        r2 = "sdk.log_address";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x0089;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0080:
        r0 = ",";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.split(r0);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.SDKUrlConfig.LOG_ADDRESS_IPS = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0089:
        r2 = "sdk.amp_address";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x009b;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0091:
        r0 = ",";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.split(r0);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.SDKUrlConfig.AMP_ADDRESS_IPS = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x009b:
        r2 = "sdk.lbs_address";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x00ad;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x00a3:
        r0 = ",";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.split(r0);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.SDKUrlConfig.LBS_ADDRESS_IPS = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x00ad:
        r2 = "sdk.cm_address_backup";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x00bf;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x00b5:
        r0 = ",";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.split(r0);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.SDKUrlConfig.XFR_ADDRESS_BAK = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x00bf:
        r2 = "sdk.inc_address";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x00d1;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x00c7:
        r0 = ",";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.split(r0);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.SDKUrlConfig.INC_ADDRESS_IPS = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x00d1:
        r2 = "sdk.debug";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x00e5;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x00d9:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.booleanValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.b.a.c.a.a = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x00e5:
        r2 = "sdk.domainbackup.enable";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x00f9;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x00ed:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.booleanValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.f = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x00f9:
        r2 = "sdk.readlocalcell.enable";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x010d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0101:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.booleanValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.g = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x010d:
        r2 = "sdk.uploadapplist.enable";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x0121;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0115:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.booleanValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.h = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0121:
        r2 = "sdk.feature.sendmessage.enable";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x0135;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0129:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.booleanValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.i = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0135:
        r2 = "sdk.feature.settag.enable";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x0149;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x013d:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.booleanValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.j = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0149:
        r2 = "sdk.feature.setsilenttime.enable";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x015d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0151:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.booleanValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.k = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x015d:
        r2 = "sdk.snl.enable";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x0171;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0165:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.booleanValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.n = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0171:
        r2 = "sdk.snl.maxactiveflow";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x0185;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0179:
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r7.longValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.o = r2;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0185:
        r2 = "sdk.feature.setheartbeatinterval.enable";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x0199;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x018d:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.booleanValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.l = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0199:
        r2 = "sdk.feature.setsockettimeout.enable";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x01ad;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x01a1:
        r7 = java.lang.Boolean.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.booleanValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.m = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x01ad:
        r2 = "sdk.stay.backup.time";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x01c4;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x01b7:
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r5 = r7.longValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r5 = r5 * r3;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.z = r5;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x01c4:
        r2 = "sdk.enter.backup.detect.failed.cnt";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x01d8;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x01cc:
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.intValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.A = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x01d8:
        r2 = "sdk.login.failed.cnt";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x01ec;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x01e0:
        r7 = java.lang.Integer.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r7 = r7.intValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.B = r7;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x01ec:
        r2 = "sdk.detect.ip.expired.time";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x0201;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x01f4:
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r5 = r7.longValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r5 = r5 * r3;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.C = r5;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0201:
        r2 = "sdk.detect.interval.time";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r2 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r2 == 0) goto L_0x0216;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0209:
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r5 = r7.longValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r5 = r5 * r3;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.D = r5;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x0216:
        r2 = "sdk.reset.reconnect.delay";	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r0 = r0.equals(r2);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        if (r0 == 0) goto L_0x000d;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
    L_0x021e:
        r7 = java.lang.Long.valueOf(r7);	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r5 = r7.longValue();	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        r5 = r5 * r3;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        com.igexin.push.config.m.y = r5;	 Catch:{ Exception -> 0x0236, all -> 0x0234 }
        goto L_0x000d;
    L_0x022b:
        r1.close();	 Catch:{ Exception -> 0x022f }
        return;
    L_0x022f:
        r7 = move-exception;
        r7.printStackTrace();
        return;
    L_0x0234:
        r7 = move-exception;
        goto L_0x023a;
    L_0x0236:
        r0 = r1;
        goto L_0x0245;
    L_0x0238:
        r7 = move-exception;
        r1 = r0;
    L_0x023a:
        if (r1 == 0) goto L_0x0244;
    L_0x023c:
        r1.close();	 Catch:{ Exception -> 0x0240 }
        goto L_0x0244;
    L_0x0240:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x0244:
        throw r7;
    L_0x0245:
        if (r0 == 0) goto L_0x024f;
    L_0x0247:
        r0.close();	 Catch:{ Exception -> 0x024b }
        return;
    L_0x024b:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x024f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.config.n.a(java.io.InputStream):void");
    }

    public static void b(Context context) {
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder();
            stringBuilder.append(context.getFilesDir().getPath());
            stringBuilder.append("/conf_n.pid");
            byte[] a = e.a(stringBuilder.toString());
            if (a != null) {
                m.w = Boolean.valueOf(new String(a)).booleanValue();
            }
        } catch (Throwable th) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append("|load need confgi error = ");
            stringBuilder.append(th.toString());
            a.b(stringBuilder.toString());
        }
    }
}
