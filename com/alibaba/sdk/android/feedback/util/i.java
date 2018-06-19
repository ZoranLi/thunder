package com.alibaba.sdk.android.feedback.util;

import android.content.Context;
import com.ta.utdid2.device.UTDevice;

public class i {
    public static java.util.Map a(android.content.Context r6) {
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
        r0 = new java.util.HashMap;
        r0.<init>();
        if (r6 == 0) goto L_0x0110;
    L_0x0007:
        r1 = "package";	 Catch:{ Exception -> 0x0110 }
        r2 = r6.getPackageName();	 Catch:{ Exception -> 0x0110 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0110 }
        r1 = r6.getPackageManager();	 Catch:{ Exception -> 0x0110 }
        r2 = r6.getPackageName();	 Catch:{ Exception -> 0x0110 }
        r3 = 0;	 Catch:{ Exception -> 0x0110 }
        r1 = r1.getPackageInfo(r2, r3);	 Catch:{ Exception -> 0x0110 }
        r2 = r1.versionName;	 Catch:{ Exception -> 0x0110 }
        if (r2 == 0) goto L_0x0027;	 Catch:{ Exception -> 0x0110 }
    L_0x0021:
        r4 = r2.length();	 Catch:{ Exception -> 0x0110 }
        if (r4 > 0) goto L_0x0029;	 Catch:{ Exception -> 0x0110 }
    L_0x0027:
        r2 = "";	 Catch:{ Exception -> 0x0110 }
    L_0x0029:
        r4 = com.alibaba.sdk.android.feedback.impl.FeedbackAPI.mExtInfo;	 Catch:{ Exception -> 0x0110 }
        if (r4 == 0) goto L_0x0053;	 Catch:{ Exception -> 0x0110 }
    L_0x002d:
        r4 = com.alibaba.sdk.android.feedback.impl.FeedbackAPI.mExtInfo;	 Catch:{ Exception -> 0x0110 }
        r5 = "AppVersionReplacement";	 Catch:{ Exception -> 0x0110 }
        r4 = r4.has(r5);	 Catch:{ Exception -> 0x0110 }
        if (r4 == 0) goto L_0x0053;	 Catch:{ Exception -> 0x0110 }
    L_0x0037:
        r2 = com.alibaba.sdk.android.feedback.impl.FeedbackAPI.mExtInfo;	 Catch:{ Exception -> 0x0110 }
        r4 = "AppVersionReplacement";	 Catch:{ Exception -> 0x0110 }
        r2 = r2.getString(r4);	 Catch:{ Exception -> 0x0110 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0110 }
        r5 = "Read property of AppVersionReplacement, the actual app_version ";	 Catch:{ Exception -> 0x0110 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x0110 }
        r1 = r1.versionName;	 Catch:{ Exception -> 0x0110 }
        r4.append(r1);	 Catch:{ Exception -> 0x0110 }
        r1 = " has been replaced with ";	 Catch:{ Exception -> 0x0110 }
        r4.append(r1);	 Catch:{ Exception -> 0x0110 }
        r4.append(r2);	 Catch:{ Exception -> 0x0110 }
    L_0x0053:
        if (r2 == 0) goto L_0x005b;	 Catch:{ Exception -> 0x0110 }
    L_0x0055:
        r1 = r2.length();	 Catch:{ Exception -> 0x0110 }
        if (r1 > 0) goto L_0x005d;	 Catch:{ Exception -> 0x0110 }
    L_0x005b:
        r2 = "";	 Catch:{ Exception -> 0x0110 }
    L_0x005d:
        r1 = "app_version";	 Catch:{ Exception -> 0x0110 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0110 }
        r1 = "sdk_version";	 Catch:{ Exception -> 0x0110 }
        r2 = "2.0.0";	 Catch:{ Exception -> 0x0110 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0110 }
        r1 = "os";	 Catch:{ Exception -> 0x0110 }
        r2 = "0";	 Catch:{ Exception -> 0x0110 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0110 }
        r1 = "os_version";	 Catch:{ Exception -> 0x0110 }
        r2 = android.os.Build.VERSION.RELEASE;	 Catch:{ Exception -> 0x0110 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0110 }
        r1 = "device_model";	 Catch:{ Exception -> 0x0110 }
        r2 = android.os.Build.MODEL;	 Catch:{ Exception -> 0x0110 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0110 }
        r1 = r6.getResources();	 Catch:{ Exception -> 0x0110 }
        r1 = r1.getDisplayMetrics();	 Catch:{ Exception -> 0x0110 }
        r2 = r1.widthPixels;	 Catch:{ Exception -> 0x0110 }
        r1 = r1.heightPixels;	 Catch:{ Exception -> 0x0110 }
        r4 = "resolution";	 Catch:{ Exception -> 0x0110 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0110 }
        r5.<init>();	 Catch:{ Exception -> 0x0110 }
        r5.append(r1);	 Catch:{ Exception -> 0x0110 }
        r1 = "x";	 Catch:{ Exception -> 0x0110 }
        r5.append(r1);	 Catch:{ Exception -> 0x0110 }
        r5.append(r2);	 Catch:{ Exception -> 0x0110 }
        r1 = r5.toString();	 Catch:{ Exception -> 0x0110 }
        r0.put(r4, r1);	 Catch:{ Exception -> 0x0110 }
        r1 = c(r6);	 Catch:{ Exception -> 0x00c9 }
        r2 = "access";	 Catch:{ Exception -> 0x00c9 }
        r4 = r1[r3];	 Catch:{ Exception -> 0x00c9 }
        r0.put(r2, r4);	 Catch:{ Exception -> 0x00c9 }
        r2 = r1[r3];	 Catch:{ Exception -> 0x00c9 }
        r3 = "2G/3G";	 Catch:{ Exception -> 0x00c9 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x00c9 }
        if (r2 == 0) goto L_0x00c1;	 Catch:{ Exception -> 0x00c9 }
    L_0x00b8:
        r2 = "access_subtype";	 Catch:{ Exception -> 0x00c9 }
        r3 = 1;	 Catch:{ Exception -> 0x00c9 }
        r1 = r1[r3];	 Catch:{ Exception -> 0x00c9 }
        r0.put(r2, r1);	 Catch:{ Exception -> 0x00c9 }
        goto L_0x00d7;	 Catch:{ Exception -> 0x00c9 }
    L_0x00c1:
        r1 = "access_subtype";	 Catch:{ Exception -> 0x00c9 }
        r2 = "Unknown";	 Catch:{ Exception -> 0x00c9 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x00c9 }
        goto L_0x00d7;
    L_0x00c9:
        r1 = "access";	 Catch:{ Exception -> 0x0110 }
        r2 = "Unknown";	 Catch:{ Exception -> 0x0110 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0110 }
        r1 = "access_subtype";	 Catch:{ Exception -> 0x0110 }
        r2 = "Unknown";	 Catch:{ Exception -> 0x0110 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0110 }
    L_0x00d7:
        r1 = "phone";	 Catch:{ Exception -> 0x0110 }
        r1 = r6.getSystemService(r1);	 Catch:{ Exception -> 0x0110 }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x0110 }
        if (r1 == 0) goto L_0x00f2;	 Catch:{ Exception -> 0x0110 }
    L_0x00e1:
        r1 = r1.getNetworkOperatorName();	 Catch:{ Exception -> 0x0110 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Exception -> 0x0110 }
        if (r2 == 0) goto L_0x00ed;	 Catch:{ Exception -> 0x0110 }
    L_0x00eb:
        r1 = "";	 Catch:{ Exception -> 0x0110 }
    L_0x00ed:
        r2 = "carrier";	 Catch:{ Exception -> 0x0110 }
        r0.put(r2, r1);	 Catch:{ Exception -> 0x0110 }
    L_0x00f2:
        r1 = "device_board";	 Catch:{ Exception -> 0x0110 }
        r2 = android.os.Build.BOARD;	 Catch:{ Exception -> 0x0110 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0110 }
        r1 = "device_brand";	 Catch:{ Exception -> 0x0110 }
        r2 = android.os.Build.BRAND;	 Catch:{ Exception -> 0x0110 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0110 }
        r1 = "device_manufacturer";	 Catch:{ Exception -> 0x0110 }
        r2 = android.os.Build.MANUFACTURER;	 Catch:{ Exception -> 0x0110 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0110 }
        r1 = "device_uuid";	 Catch:{ Exception -> 0x0110 }
        r6 = b(r6);	 Catch:{ Exception -> 0x0110 }
        r0.put(r1, r6);	 Catch:{ Exception -> 0x0110 }
    L_0x0110:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.util.i.a(android.content.Context):java.util.Map");
    }

    public static String b(Context context) {
        return UTDevice.getUtdid(context);
    }

    private static java.lang.String[] c(android.content.Context r6) {
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
        r0 = 2;
        r0 = new java.lang.String[r0];
        r1 = "Unknown";
        r2 = 0;
        r0[r2] = r1;
        r1 = "Unknown";
        r3 = 1;
        r0[r3] = r1;
        r1 = r6.getPackageManager();	 Catch:{ Exception -> 0x005c }
        r4 = "android.permission.ACCESS_NETWORK_STATE";	 Catch:{ Exception -> 0x005c }
        r5 = r6.getPackageName();	 Catch:{ Exception -> 0x005c }
        r1 = r1.checkPermission(r4, r5);	 Catch:{ Exception -> 0x005c }
        if (r1 == 0) goto L_0x0022;	 Catch:{ Exception -> 0x005c }
    L_0x001d:
        r6 = "Unknown";	 Catch:{ Exception -> 0x005c }
        r0[r2] = r6;	 Catch:{ Exception -> 0x005c }
        return r0;	 Catch:{ Exception -> 0x005c }
    L_0x0022:
        r1 = "connectivity";	 Catch:{ Exception -> 0x005c }
        r6 = r6.getSystemService(r1);	 Catch:{ Exception -> 0x005c }
        r6 = (android.net.ConnectivityManager) r6;	 Catch:{ Exception -> 0x005c }
        if (r6 != 0) goto L_0x0031;	 Catch:{ Exception -> 0x005c }
    L_0x002c:
        r6 = "Unknown";	 Catch:{ Exception -> 0x005c }
        r0[r2] = r6;	 Catch:{ Exception -> 0x005c }
        return r0;	 Catch:{ Exception -> 0x005c }
    L_0x0031:
        r1 = r6.getNetworkInfo(r3);	 Catch:{ Exception -> 0x005c }
        if (r1 == 0) goto L_0x0044;	 Catch:{ Exception -> 0x005c }
    L_0x0037:
        r1 = r1.getState();	 Catch:{ Exception -> 0x005c }
        r4 = android.net.NetworkInfo.State.CONNECTED;	 Catch:{ Exception -> 0x005c }
        if (r1 != r4) goto L_0x0044;	 Catch:{ Exception -> 0x005c }
    L_0x003f:
        r6 = "Wi-Fi";	 Catch:{ Exception -> 0x005c }
        r0[r2] = r6;	 Catch:{ Exception -> 0x005c }
        return r0;	 Catch:{ Exception -> 0x005c }
    L_0x0044:
        r6 = r6.getNetworkInfo(r2);	 Catch:{ Exception -> 0x005c }
        if (r6 == 0) goto L_0x005c;	 Catch:{ Exception -> 0x005c }
    L_0x004a:
        r1 = r6.getState();	 Catch:{ Exception -> 0x005c }
        r4 = android.net.NetworkInfo.State.CONNECTED;	 Catch:{ Exception -> 0x005c }
        if (r1 != r4) goto L_0x005c;	 Catch:{ Exception -> 0x005c }
    L_0x0052:
        r1 = "2G/3G";	 Catch:{ Exception -> 0x005c }
        r0[r2] = r1;	 Catch:{ Exception -> 0x005c }
        r6 = r6.getSubtypeName();	 Catch:{ Exception -> 0x005c }
        r0[r3] = r6;	 Catch:{ Exception -> 0x005c }
    L_0x005c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.util.i.c(android.content.Context):java.lang.String[]");
    }
}
