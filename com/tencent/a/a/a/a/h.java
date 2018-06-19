package com.tencent.a.a.a.a;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.util.Base64;
import com.tencent.wxop.stat.common.f;
import com.umeng.message.MsgConstant;
import org.json.JSONObject;

public final class h {
    static java.lang.String a(android.content.Context r1) {
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
        r1 = "";
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.a.a.a.a.h.a(android.content.Context):java.lang.String");
    }

    private static void a(String str, Throwable th) {
    }

    static void a(JSONObject jSONObject, String str, String str2) {
        if (b(str2)) {
            jSONObject.put(str, str2);
        }
    }

    static boolean a(Context context, String str) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
        } catch (Throwable th) {
            a("checkPermission error", th);
        }
        return false;
    }

    static String b(Context context) {
        if (!a(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return wifiManager == null ? "" : wifiManager.getConnectionInfo().getMacAddress();
        } catch (Exception e) {
            new StringBuilder("get wifi address error").append(e);
            return "";
        }
    }

    static boolean b(String str) {
        if (str != null) {
            if (str.trim().length() != 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean c(String str) {
        return str != null && str.trim().length() >= 40;
    }

    static String f(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(f.b(Base64.decode(str.getBytes("UTF-8"), 0)), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            a("decode error", th);
            return str;
        }
    }

    static String g(String str) {
        if (str == null) {
            return null;
        }
        if (VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(Base64.encode(f.a(str.getBytes("UTF-8")), 0), "UTF-8").trim().replace("\t", "").replace("\n", "").replace("\r", "");
        } catch (Throwable th) {
            a("decode error", th);
            return str;
        }
    }
}
