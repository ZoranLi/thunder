package com.tencent.wxop.stat.common;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.umeng.message.MsgConstant;
import org.json.JSONArray;

public class r {
    private static String a = "";

    public static java.lang.String a(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "android.permission.READ_PHONE_STATE";	 Catch:{ Throwable -> 0x0017 }
        r0 = a(r1, r0);	 Catch:{ Throwable -> 0x0017 }
        if (r0 == 0) goto L_0x0017;	 Catch:{ Throwable -> 0x0017 }
    L_0x0008:
        r0 = "phone";	 Catch:{ Throwable -> 0x0017 }
        r1 = r1.getSystemService(r0);	 Catch:{ Throwable -> 0x0017 }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Throwable -> 0x0017 }
        r1 = r1.getDeviceId();	 Catch:{ Throwable -> 0x0017 }
        if (r1 == 0) goto L_0x0017;
    L_0x0016:
        return r1;
    L_0x0017:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.r.a(android.content.Context):java.lang.String");
    }

    public static java.lang.String a(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r3 != 0) goto L_0x0004;
    L_0x0002:
        r3 = 0;
        return r3;
    L_0x0004:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 8;
        if (r0 >= r1) goto L_0x000b;
    L_0x000a:
        return r3;
    L_0x000b:
        r0 = "UTF-8";	 Catch:{ Throwable -> 0x0022 }
        r0 = r3.getBytes(r0);	 Catch:{ Throwable -> 0x0022 }
        r1 = 0;	 Catch:{ Throwable -> 0x0022 }
        r0 = com.tencent.wxop.stat.common.h.a(r0, r1);	 Catch:{ Throwable -> 0x0022 }
        r0 = com.tencent.wxop.stat.common.f.b(r0);	 Catch:{ Throwable -> 0x0022 }
        r1 = new java.lang.String;	 Catch:{ Throwable -> 0x0022 }
        r2 = "UTF-8";	 Catch:{ Throwable -> 0x0022 }
        r1.<init>(r0, r2);	 Catch:{ Throwable -> 0x0022 }
        return r1;
    L_0x0022:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.r.a(java.lang.String):java.lang.String");
    }

    public static JSONArray a(Context context, int i) {
        return null;
    }

    public static void a(org.json.JSONObject r1, java.lang.String r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r3 == 0) goto L_0x000c;
    L_0x0002:
        r0 = r3.length();	 Catch:{ Throwable -> 0x000c }
        if (r0 <= 0) goto L_0x000c;	 Catch:{ Throwable -> 0x000c }
    L_0x0008:
        r1.put(r2, r3);	 Catch:{ Throwable -> 0x000c }
        return;
    L_0x000c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.r.a(org.json.JSONObject, java.lang.String, java.lang.String):void");
    }

    public static boolean a(android.content.Context r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r2.getPackageManager();	 Catch:{ Throwable -> 0x0011 }
        r2 = r2.getPackageName();	 Catch:{ Throwable -> 0x0011 }
        r2 = r1.checkPermission(r3, r2);	 Catch:{ Throwable -> 0x0011 }
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        r2 = 1;
        r0 = r2;
    L_0x0011:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.r.a(android.content.Context, java.lang.String):boolean");
    }

    public static java.lang.String b(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "android.permission.ACCESS_WIFI_STATE";
        r0 = a(r1, r0);
        if (r0 == 0) goto L_0x0021;
    L_0x0008:
        r0 = "wifi";	 Catch:{ Exception -> 0x001e }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x001e }
        r1 = (android.net.wifi.WifiManager) r1;	 Catch:{ Exception -> 0x001e }
        if (r1 != 0) goto L_0x0015;	 Catch:{ Exception -> 0x001e }
    L_0x0012:
        r1 = "";	 Catch:{ Exception -> 0x001e }
        return r1;	 Catch:{ Exception -> 0x001e }
    L_0x0015:
        r1 = r1.getConnectionInfo();	 Catch:{ Exception -> 0x001e }
        r1 = r1.getMacAddress();	 Catch:{ Exception -> 0x001e }
        return r1;
    L_0x001e:
        r1 = "";
        return r1;
    L_0x0021:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.r.b(android.content.Context):java.lang.String");
    }

    public static java.lang.String b(java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r3 != 0) goto L_0x0004;
    L_0x0002:
        r3 = 0;
        return r3;
    L_0x0004:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 8;
        if (r0 >= r1) goto L_0x000b;
    L_0x000a:
        return r3;
    L_0x000b:
        r0 = "UTF-8";	 Catch:{ Throwable -> 0x0022 }
        r0 = r3.getBytes(r0);	 Catch:{ Throwable -> 0x0022 }
        r0 = com.tencent.wxop.stat.common.f.a(r0);	 Catch:{ Throwable -> 0x0022 }
        r1 = 0;	 Catch:{ Throwable -> 0x0022 }
        r0 = com.tencent.wxop.stat.common.h.b(r0, r1);	 Catch:{ Throwable -> 0x0022 }
        r1 = new java.lang.String;	 Catch:{ Throwable -> 0x0022 }
        r2 = "UTF-8";	 Catch:{ Throwable -> 0x0022 }
        r1.<init>(r0, r2);	 Catch:{ Throwable -> 0x0022 }
        return r1;
    L_0x0022:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.r.b(java.lang.String):java.lang.String");
    }

    public static WifiInfo c(Context context) {
        if (a(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
            WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
            if (wifiManager != null) {
                return wifiManager.getConnectionInfo();
            }
        }
        return null;
    }

    public static java.lang.String d(android.content.Context r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = c(r0);	 Catch:{ Throwable -> 0x000b }
        if (r0 == 0) goto L_0x000b;	 Catch:{ Throwable -> 0x000b }
    L_0x0006:
        r0 = r0.getBSSID();	 Catch:{ Throwable -> 0x000b }
        return r0;
    L_0x000b:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.r.d(android.content.Context):java.lang.String");
    }

    public static java.lang.String e(android.content.Context r0) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = c(r0);	 Catch:{ Throwable -> 0x000b }
        if (r0 == 0) goto L_0x000b;	 Catch:{ Throwable -> 0x000b }
    L_0x0006:
        r0 = r0.getSSID();	 Catch:{ Throwable -> 0x000b }
        return r0;
    L_0x000b:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.r.e(android.content.Context):java.lang.String");
    }

    public static boolean f(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "android.permission.INTERNET";	 Catch:{ Throwable -> 0x0029 }
        r1 = a(r2, r1);	 Catch:{ Throwable -> 0x0029 }
        if (r1 == 0) goto L_0x0029;	 Catch:{ Throwable -> 0x0029 }
    L_0x0009:
        r1 = "android.permission.ACCESS_NETWORK_STATE";	 Catch:{ Throwable -> 0x0029 }
        r1 = a(r2, r1);	 Catch:{ Throwable -> 0x0029 }
        if (r1 == 0) goto L_0x0029;	 Catch:{ Throwable -> 0x0029 }
    L_0x0011:
        r1 = "connectivity";	 Catch:{ Throwable -> 0x0029 }
        r2 = r2.getSystemService(r1);	 Catch:{ Throwable -> 0x0029 }
        r2 = (android.net.ConnectivityManager) r2;	 Catch:{ Throwable -> 0x0029 }
        if (r2 == 0) goto L_0x0029;	 Catch:{ Throwable -> 0x0029 }
    L_0x001b:
        r2 = r2.getActiveNetworkInfo();	 Catch:{ Throwable -> 0x0029 }
        if (r2 == 0) goto L_0x0029;	 Catch:{ Throwable -> 0x0029 }
    L_0x0021:
        r2 = r2.isAvailable();	 Catch:{ Throwable -> 0x0029 }
        if (r2 == 0) goto L_0x0029;
    L_0x0027:
        r2 = 1;
        return r2;
    L_0x0029:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.r.f(android.content.Context):boolean");
    }
}
