package com.igexin.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class p {
    public static void a(android.content.Context r3, android.content.Intent r4) {
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
        r0 = "us";	 Catch:{ Throwable -> 0x00a7 }
        r0 = r4.hasExtra(r0);	 Catch:{ Throwable -> 0x00a7 }
        if (r0 == 0) goto L_0x003b;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0008:
        r0 = "us";	 Catch:{ Throwable -> 0x00a7 }
        r0 = r4.getStringExtra(r0);	 Catch:{ Throwable -> 0x00a7 }
        r1 = com.igexin.sdk.GTServiceManager.getInstance();	 Catch:{ Throwable -> 0x00a7 }
        r1 = r1.getUserPushService(r3);	 Catch:{ Throwable -> 0x00a7 }
        r1 = r1.getName();	 Catch:{ Throwable -> 0x00a7 }
        r2 = r1.equals(r0);	 Catch:{ Throwable -> 0x00a7 }
        if (r2 != 0) goto L_0x003b;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0020:
        r2 = com.igexin.push.core.a.n;	 Catch:{ Throwable -> 0x00a7 }
        r2 = r0.equals(r2);	 Catch:{ Throwable -> 0x00a7 }
        if (r2 == 0) goto L_0x0036;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0028:
        r0 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x00a7 }
        if (r0 != 0) goto L_0x003b;	 Catch:{ Throwable -> 0x00a7 }
    L_0x002e:
        r0 = "us";	 Catch:{ Throwable -> 0x00a7 }
        r1 = "";	 Catch:{ Throwable -> 0x00a7 }
        a(r3, r0, r1);	 Catch:{ Throwable -> 0x00a7 }
        goto L_0x003b;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0036:
        r1 = "us";	 Catch:{ Throwable -> 0x00a7 }
        a(r3, r1, r0);	 Catch:{ Throwable -> 0x00a7 }
    L_0x003b:
        r0 = "uis";	 Catch:{ Throwable -> 0x00a7 }
        r0 = r4.hasExtra(r0);	 Catch:{ Throwable -> 0x00a7 }
        if (r0 == 0) goto L_0x0070;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0043:
        r0 = com.igexin.sdk.GTServiceManager.getInstance();	 Catch:{ Throwable -> 0x00a7 }
        r0 = r0.getUserIntentService(r3);	 Catch:{ Throwable -> 0x00a7 }
        r1 = "uis";	 Catch:{ Throwable -> 0x00a7 }
        r1 = r4.getStringExtra(r1);	 Catch:{ Throwable -> 0x00a7 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x00a7 }
        if (r2 != 0) goto L_0x0069;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0057:
        if (r0 == 0) goto L_0x0063;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0059:
        r0 = r0.getName();	 Catch:{ Throwable -> 0x00a7 }
        r0 = r1.equals(r0);	 Catch:{ Throwable -> 0x00a7 }
        if (r0 != 0) goto L_0x0070;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0063:
        r0 = "uis";	 Catch:{ Throwable -> 0x00a7 }
    L_0x0065:
        a(r3, r0, r1);	 Catch:{ Throwable -> 0x00a7 }
        goto L_0x0070;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0069:
        if (r0 == 0) goto L_0x0070;	 Catch:{ Throwable -> 0x00a7 }
    L_0x006b:
        r0 = "uis";	 Catch:{ Throwable -> 0x00a7 }
        r1 = "";	 Catch:{ Throwable -> 0x00a7 }
        goto L_0x0065;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0070:
        r0 = "ua";	 Catch:{ Throwable -> 0x00a7 }
        r0 = r4.hasExtra(r0);	 Catch:{ Throwable -> 0x00a7 }
        if (r0 == 0) goto L_0x00a7;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0078:
        r0 = com.igexin.sdk.GTServiceManager.getInstance();	 Catch:{ Throwable -> 0x00a7 }
        r0 = r0.getUserActivtiy(r3);	 Catch:{ Throwable -> 0x00a7 }
        r1 = "ua";	 Catch:{ Throwable -> 0x00a7 }
        r4 = r4.getStringExtra(r1);	 Catch:{ Throwable -> 0x00a7 }
        r1 = android.text.TextUtils.isEmpty(r4);	 Catch:{ Throwable -> 0x00a7 }
        if (r1 != 0) goto L_0x009a;	 Catch:{ Throwable -> 0x00a7 }
    L_0x008c:
        if (r0 == 0) goto L_0x0094;	 Catch:{ Throwable -> 0x00a7 }
    L_0x008e:
        r0 = r4.equals(r0);	 Catch:{ Throwable -> 0x00a7 }
        if (r0 != 0) goto L_0x00a7;	 Catch:{ Throwable -> 0x00a7 }
    L_0x0094:
        r0 = "ua";	 Catch:{ Throwable -> 0x00a7 }
        a(r3, r0, r4);	 Catch:{ Throwable -> 0x00a7 }
        return;	 Catch:{ Throwable -> 0x00a7 }
    L_0x009a:
        r4 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x00a7 }
        if (r4 != 0) goto L_0x00a7;	 Catch:{ Throwable -> 0x00a7 }
    L_0x00a0:
        r4 = "ua";	 Catch:{ Throwable -> 0x00a7 }
        r0 = "";	 Catch:{ Throwable -> 0x00a7 }
        a(r3, r4, r0);	 Catch:{ Throwable -> 0x00a7 }
    L_0x00a7:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.p.a(android.content.Context, android.content.Intent):void");
    }

    public static void a(Context context, String str, Object obj) {
        Editor edit = context.getSharedPreferences("getui_sp", 0).edit();
        if (obj instanceof String) {
            edit.putString(str, (String) obj);
        } else if (obj instanceof Integer) {
            edit.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Boolean) {
            edit.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Float) {
            edit.putFloat(str, ((Float) obj).floatValue());
        } else if (obj instanceof Long) {
            edit.putLong(str, ((Long) obj).longValue());
        }
        edit.commit();
    }

    public static Object b(Context context, String str, Object obj) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("getui_sp", 0);
        return obj instanceof String ? sharedPreferences.getString(str, (String) obj) : obj instanceof Integer ? Integer.valueOf(sharedPreferences.getInt(str, ((Integer) obj).intValue())) : obj instanceof Boolean ? Boolean.valueOf(sharedPreferences.getBoolean(str, ((Boolean) obj).booleanValue())) : obj instanceof Float ? Float.valueOf(sharedPreferences.getFloat(str, ((Float) obj).floatValue())) : obj instanceof Long ? Long.valueOf(sharedPreferences.getLong(str, ((Long) obj).longValue())) : obj;
    }
}
