package com.xunlei.tdlive.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;

/* compiled from: Util */
public class l {
    private static int a = -1;
    private static ApplicationInfo b;
    private static DisplayMetrics c;

    public static boolean a(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "connectivity";	 Catch:{ Throwable -> 0x0015 }
        r2 = r2.getSystemService(r1);	 Catch:{ Throwable -> 0x0015 }
        r2 = (android.net.ConnectivityManager) r2;	 Catch:{ Throwable -> 0x0015 }
        r2 = r2.getActiveNetworkInfo();	 Catch:{ Throwable -> 0x0015 }
        if (r2 != 0) goto L_0x0010;	 Catch:{ Throwable -> 0x0015 }
    L_0x000f:
        return r0;	 Catch:{ Throwable -> 0x0015 }
    L_0x0010:
        r2 = r2.isConnected();	 Catch:{ Throwable -> 0x0015 }
        return r2;
    L_0x0015:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.l.a(android.content.Context):boolean");
    }

    public static int b(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "connectivity";	 Catch:{ Exception -> 0x0028 }
        r3 = r3.getSystemService(r1);	 Catch:{ Exception -> 0x0028 }
        r3 = (android.net.ConnectivityManager) r3;	 Catch:{ Exception -> 0x0028 }
        r3 = r3.getActiveNetworkInfo();	 Catch:{ Exception -> 0x0028 }
        if (r3 != 0) goto L_0x0010;	 Catch:{ Exception -> 0x0028 }
    L_0x000f:
        return r0;	 Catch:{ Exception -> 0x0028 }
    L_0x0010:
        r1 = r3.getType();	 Catch:{ Exception -> 0x0028 }
        r2 = 1;	 Catch:{ Exception -> 0x0028 }
        if (r1 != r2) goto L_0x001a;	 Catch:{ Exception -> 0x0028 }
    L_0x0017:
        r3 = 9;	 Catch:{ Exception -> 0x0028 }
        return r3;	 Catch:{ Exception -> 0x0028 }
    L_0x001a:
        r3 = r3.getSubtype();	 Catch:{ Exception -> 0x0028 }
        switch(r3) {
            case 1: goto L_0x0026;
            case 2: goto L_0x0026;
            case 3: goto L_0x0024;
            case 4: goto L_0x0026;
            case 5: goto L_0x0024;
            case 6: goto L_0x0024;
            case 7: goto L_0x0026;
            case 8: goto L_0x0024;
            case 9: goto L_0x0024;
            case 10: goto L_0x0024;
            case 11: goto L_0x0026;
            case 12: goto L_0x0024;
            case 13: goto L_0x0022;
            case 14: goto L_0x0024;
            case 15: goto L_0x0024;
            default: goto L_0x0021;
        };
    L_0x0021:
        return r0;
    L_0x0022:
        r3 = 4;
        return r3;
    L_0x0024:
        r3 = 3;
        return r3;
    L_0x0026:
        r3 = 2;
        return r3;
    L_0x0028:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.l.b(android.content.Context):int");
    }

    public static android.util.DisplayMetrics c(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = c;
        if (r0 != 0) goto L_0x001c;
    L_0x0004:
        r0 = new android.util.DisplayMetrics;	 Catch:{ Exception -> 0x001c }
        r0.<init>();	 Catch:{ Exception -> 0x001c }
        c = r0;	 Catch:{ Exception -> 0x001c }
        r0 = "window";	 Catch:{ Exception -> 0x001c }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x001c }
        r1 = (android.view.WindowManager) r1;	 Catch:{ Exception -> 0x001c }
        r1 = r1.getDefaultDisplay();	 Catch:{ Exception -> 0x001c }
        r0 = c;	 Catch:{ Exception -> 0x001c }
        r1.getMetrics(r0);	 Catch:{ Exception -> 0x001c }
    L_0x001c:
        r1 = c;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.l.c(android.content.Context):android.util.DisplayMetrics");
    }

    public static int d(Context context) {
        if (c(context) == null) {
            return null;
        }
        return c(context).widthPixels;
    }

    public static java.lang.String a(boolean r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = android.os.Build.MANUFACTURER;
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r1 = android.os.Build.BRAND;
        r0.append(r1);
        r1 = "-";
        r0.append(r1);
        r1 = android.os.Build.MODEL;
        r0.append(r1);
        r0 = r0.toString();
        if (r2 == 0) goto L_0x002b;
    L_0x0024:
        r2 = "UTF-8";	 Catch:{ Exception -> 0x002b }
        r2 = java.net.URLEncoder.encode(r0, r2);	 Catch:{ Exception -> 0x002b }
        return r2;
    L_0x002b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.l.a(boolean):java.lang.String");
    }

    public static String a() {
        return VERSION.RELEASE;
    }

    public static java.lang.String e(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "__device_info_new__";
        r1 = 0;
        r0 = r5.getSharedPreferences(r0, r1);
        r2 = "hubble_id";
        r3 = "";
        r2 = r0.getString(r2, r3);
        r3 = android.text.TextUtils.isEmpty(r2);
        if (r3 != 0) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r2 = "";
        r3 = "wifi";
        r3 = r5.getSystemService(r3);
        r3 = (android.net.wifi.WifiManager) r3;
        if (r3 == 0) goto L_0x002f;
    L_0x0022:
        r3 = r3.getConnectionInfo();	 Catch:{ Throwable -> 0x002b }
        r3 = r3.getMacAddress();	 Catch:{ Throwable -> 0x002b }
        r2 = r3;
    L_0x002b:
        if (r2 != 0) goto L_0x002f;
    L_0x002d:
        r2 = "";
    L_0x002f:
        if (r2 == 0) goto L_0x005a;
    L_0x0031:
        r3 = r2.length();
        r4 = 2;
        if (r3 <= r4) goto L_0x005a;
    L_0x0038:
        r3 = "";
        r4 = ":";
        r2 = r2.split(r4);
    L_0x0040:
        if (r2 == 0) goto L_0x0059;
    L_0x0042:
        r4 = r2.length;
        if (r1 >= r4) goto L_0x0059;
    L_0x0045:
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r4.append(r3);
        r3 = r2[r1];
        r4.append(r3);
        r3 = r4.toString();
        r1 = r1 + 1;
        goto L_0x0040;
    L_0x0059:
        r2 = r3;
    L_0x005a:
        if (r2 == 0) goto L_0x0060;
    L_0x005c:
        r1 = "";
        if (r2 != r1) goto L_0x0062;
    L_0x0060:
        r2 = "999999999999";
    L_0x0062:
        r1 = "";
        r3 = "phone";
        r5 = r5.getSystemService(r3);
        r5 = (android.telephony.TelephonyManager) r5;
        if (r5 == 0) goto L_0x0081;
    L_0x006e:
        r5 = r5.getDeviceId();	 Catch:{ Throwable -> 0x0081 }
        if (r5 == 0) goto L_0x007f;
    L_0x0074:
        r1 = "";	 Catch:{ Throwable -> 0x007d }
        r1 = r1.equalsIgnoreCase(r5);	 Catch:{ Throwable -> 0x007d }
        if (r1 == 0) goto L_0x007d;	 Catch:{ Throwable -> 0x007d }
    L_0x007c:
        goto L_0x007f;	 Catch:{ Throwable -> 0x007d }
    L_0x007d:
        r1 = r5;	 Catch:{ Throwable -> 0x007d }
        goto L_0x0081;	 Catch:{ Throwable -> 0x007d }
    L_0x007f:
        r1 = "";	 Catch:{ Throwable -> 0x007d }
    L_0x0081:
        if (r1 == 0) goto L_0x0087;
    L_0x0083:
        r5 = "";
        if (r1 != r5) goto L_0x0089;
    L_0x0087:
        r1 = "999999999999999";
    L_0x0089:
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r5.append(r2);
        r3 = "_";
        r5.append(r3);
        r5.append(r1);
        r5 = r5.toString();
        r5 = com.xunlei.tdlive.util.f.a(r5);
        r3 = "999999999999";
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x00b1;
    L_0x00a9:
        r2 = "999999999999999";
        r1 = r1.equals(r2);
        if (r1 != 0) goto L_0x00be;
    L_0x00b1:
        r0 = r0.edit();
        r1 = "hubble_id";
        r0 = r0.putString(r1, r5);
        r0.commit();
    L_0x00be:
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.l.e(android.content.Context):java.lang.String");
    }

    public static String f(Context context) {
        Object string = context.getSharedPreferences("__device_info_new__", 0).getString("device_id_new", "");
        if (TextUtils.isEmpty(string)) {
            return e(context);
        }
        return string;
    }

    public static java.lang.String a(android.content.Context r2, java.lang.String r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = b;	 Catch:{ Throwable -> 0x0024 }
        if (r0 != 0) goto L_0x0014;	 Catch:{ Throwable -> 0x0024 }
    L_0x0004:
        r0 = r2.getPackageManager();	 Catch:{ Throwable -> 0x0024 }
        r2 = r2.getPackageName();	 Catch:{ Throwable -> 0x0024 }
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Throwable -> 0x0024 }
        r2 = r0.getApplicationInfo(r2, r1);	 Catch:{ Throwable -> 0x0024 }
        b = r2;	 Catch:{ Throwable -> 0x0024 }
    L_0x0014:
        r2 = b;	 Catch:{ Throwable -> 0x0024 }
        r2 = r2.metaData;	 Catch:{ Throwable -> 0x0024 }
        r2 = r2.get(r3);	 Catch:{ Throwable -> 0x0024 }
        if (r2 != 0) goto L_0x001f;	 Catch:{ Throwable -> 0x0024 }
    L_0x001e:
        return r4;	 Catch:{ Throwable -> 0x0024 }
    L_0x001f:
        r2 = r2.toString();	 Catch:{ Throwable -> 0x0024 }
        return r2;
    L_0x0024:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.util.l.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }
}
