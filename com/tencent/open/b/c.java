package com.tencent.open.b;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.open.a.f;
import com.tencent.open.utils.d;
import java.util.Locale;

/* compiled from: ProGuard */
public class c {
    static String a;
    static String b;
    static String c;
    private static String d;
    private static String e;

    public static String a() {
        try {
            Context a = d.a();
            if (a == null) {
                return "";
            }
            WifiManager wifiManager = (WifiManager) a.getSystemService("wifi");
            if (wifiManager == null) {
                return "";
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return "";
            }
            return connectionInfo.getMacAddress();
        } catch (Throwable e) {
            f.b("openSDK_LOG.MobileInfoUtil", "getLocalMacAddress>>>", e);
            return "";
        }
    }

    public static String a(Context context) {
        if (!TextUtils.isEmpty(d)) {
            return d;
        }
        if (context == null) {
            return "";
        }
        d = "";
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager != null) {
            int width = windowManager.getDefaultDisplay().getWidth();
            context = windowManager.getDefaultDisplay().getHeight();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(width);
            stringBuilder.append("x");
            stringBuilder.append(context);
            d = stringBuilder.toString();
        }
        return d;
    }

    public static String b() {
        return Locale.getDefault().getLanguage();
    }

    public static java.lang.String b(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = a;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        r0 = a;
        r0 = r0.length();
        if (r0 <= 0) goto L_0x000f;
    L_0x000c:
        r1 = a;
        return r1;
    L_0x000f:
        if (r1 != 0) goto L_0x0014;
    L_0x0011:
        r1 = "";
        return r1;
    L_0x0014:
        r0 = "phone";	 Catch:{ Exception -> 0x0023 }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x0023 }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x0023 }
        r1 = r1.getDeviceId();	 Catch:{ Exception -> 0x0023 }
        a = r1;	 Catch:{ Exception -> 0x0023 }
        return r1;
    L_0x0023:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.c.b(android.content.Context):java.lang.String");
    }

    public static java.lang.String c(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = b;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        r0 = b;
        r0 = r0.length();
        if (r0 <= 0) goto L_0x000f;
    L_0x000c:
        r1 = b;
        return r1;
    L_0x000f:
        if (r1 != 0) goto L_0x0014;
    L_0x0011:
        r1 = "";
        return r1;
    L_0x0014:
        r0 = "phone";	 Catch:{ Exception -> 0x0023 }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x0023 }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Exception -> 0x0023 }
        r1 = r1.getSimSerialNumber();	 Catch:{ Exception -> 0x0023 }
        b = r1;	 Catch:{ Exception -> 0x0023 }
        return r1;
    L_0x0023:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.c.c(android.content.Context):java.lang.String");
    }

    public static java.lang.String d(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = c;
        if (r0 == 0) goto L_0x000f;
    L_0x0004:
        r0 = c;
        r0 = r0.length();
        if (r0 <= 0) goto L_0x000f;
    L_0x000c:
        r1 = c;
        return r1;
    L_0x000f:
        if (r1 != 0) goto L_0x0014;
    L_0x0011:
        r1 = "";
        return r1;
    L_0x0014:
        r1 = r1.getContentResolver();	 Catch:{ Exception -> 0x0021 }
        r0 = "android_id";	 Catch:{ Exception -> 0x0021 }
        r1 = android.provider.Settings.Secure.getString(r1, r0);	 Catch:{ Exception -> 0x0021 }
        c = r1;	 Catch:{ Exception -> 0x0021 }
        return r1;
    L_0x0021:
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.c.d(android.content.Context):java.lang.String");
    }

    public static java.lang.String e(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = e;	 Catch:{ Exception -> 0x00b8 }
        if (r0 != 0) goto L_0x00b5;	 Catch:{ Exception -> 0x00b8 }
    L_0x0004:
        r0 = "window";	 Catch:{ Exception -> 0x00b8 }
        r0 = r5.getSystemService(r0);	 Catch:{ Exception -> 0x00b8 }
        r0 = (android.view.WindowManager) r0;	 Catch:{ Exception -> 0x00b8 }
        r1 = new android.util.DisplayMetrics;	 Catch:{ Exception -> 0x00b8 }
        r1.<init>();	 Catch:{ Exception -> 0x00b8 }
        r0 = r0.getDefaultDisplay();	 Catch:{ Exception -> 0x00b8 }
        r0.getMetrics(r1);	 Catch:{ Exception -> 0x00b8 }
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b8 }
        r0.<init>();	 Catch:{ Exception -> 0x00b8 }
        r2 = "imei=";	 Catch:{ Exception -> 0x00b8 }
        r0.append(r2);	 Catch:{ Exception -> 0x00b8 }
        r2 = b(r5);	 Catch:{ Exception -> 0x00b8 }
        r0.append(r2);	 Catch:{ Exception -> 0x00b8 }
        r2 = 38;	 Catch:{ Exception -> 0x00b8 }
        r0.append(r2);	 Catch:{ Exception -> 0x00b8 }
        r3 = "model=";	 Catch:{ Exception -> 0x00b8 }
        r0.append(r3);	 Catch:{ Exception -> 0x00b8 }
        r3 = android.os.Build.MODEL;	 Catch:{ Exception -> 0x00b8 }
        r0.append(r3);	 Catch:{ Exception -> 0x00b8 }
        r0.append(r2);	 Catch:{ Exception -> 0x00b8 }
        r3 = "os=";	 Catch:{ Exception -> 0x00b8 }
        r0.append(r3);	 Catch:{ Exception -> 0x00b8 }
        r3 = android.os.Build.VERSION.RELEASE;	 Catch:{ Exception -> 0x00b8 }
        r0.append(r3);	 Catch:{ Exception -> 0x00b8 }
        r0.append(r2);	 Catch:{ Exception -> 0x00b8 }
        r3 = "apilevel=";	 Catch:{ Exception -> 0x00b8 }
        r0.append(r3);	 Catch:{ Exception -> 0x00b8 }
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x00b8 }
        r0.append(r3);	 Catch:{ Exception -> 0x00b8 }
        r0.append(r2);	 Catch:{ Exception -> 0x00b8 }
        r3 = com.tencent.open.b.a.b(r5);	 Catch:{ Exception -> 0x00b8 }
        if (r3 != 0) goto L_0x005d;	 Catch:{ Exception -> 0x00b8 }
    L_0x005b:
        r3 = "";	 Catch:{ Exception -> 0x00b8 }
    L_0x005d:
        r4 = "network=";	 Catch:{ Exception -> 0x00b8 }
        r0.append(r4);	 Catch:{ Exception -> 0x00b8 }
        r0.append(r3);	 Catch:{ Exception -> 0x00b8 }
        r0.append(r2);	 Catch:{ Exception -> 0x00b8 }
        r3 = "sdcard=";	 Catch:{ Exception -> 0x00b8 }
        r0.append(r3);	 Catch:{ Exception -> 0x00b8 }
        r3 = android.os.Environment.getExternalStorageState();	 Catch:{ Exception -> 0x00b8 }
        r4 = "mounted";	 Catch:{ Exception -> 0x00b8 }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x00b8 }
        r0.append(r3);	 Catch:{ Exception -> 0x00b8 }
        r0.append(r2);	 Catch:{ Exception -> 0x00b8 }
        r3 = "display=";	 Catch:{ Exception -> 0x00b8 }
        r0.append(r3);	 Catch:{ Exception -> 0x00b8 }
        r3 = r1.widthPixels;	 Catch:{ Exception -> 0x00b8 }
        r0.append(r3);	 Catch:{ Exception -> 0x00b8 }
        r3 = 42;	 Catch:{ Exception -> 0x00b8 }
        r0.append(r3);	 Catch:{ Exception -> 0x00b8 }
        r1 = r1.heightPixels;	 Catch:{ Exception -> 0x00b8 }
        r0.append(r1);	 Catch:{ Exception -> 0x00b8 }
        r0.append(r2);	 Catch:{ Exception -> 0x00b8 }
        r1 = "manu=";	 Catch:{ Exception -> 0x00b8 }
        r0.append(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = android.os.Build.MANUFACTURER;	 Catch:{ Exception -> 0x00b8 }
        r0.append(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = "&";	 Catch:{ Exception -> 0x00b8 }
        r0.append(r1);	 Catch:{ Exception -> 0x00b8 }
        r1 = "wifi=";	 Catch:{ Exception -> 0x00b8 }
        r0.append(r1);	 Catch:{ Exception -> 0x00b8 }
        r5 = com.tencent.open.b.a.e(r5);	 Catch:{ Exception -> 0x00b8 }
        r0.append(r5);	 Catch:{ Exception -> 0x00b8 }
        r5 = r0.toString();	 Catch:{ Exception -> 0x00b8 }
        e = r5;	 Catch:{ Exception -> 0x00b8 }
    L_0x00b5:
        r5 = e;	 Catch:{ Exception -> 0x00b8 }
        return r5;
    L_0x00b8:
        r5 = 0;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.c.e(android.content.Context):java.lang.String");
    }
}
