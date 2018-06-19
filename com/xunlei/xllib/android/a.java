package com.xunlei.xllib.android;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/* compiled from: AndroidUtil */
public final class a {
    public static Bundle a(Context context) {
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (context != null) {
                return context.metaData;
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        return null;
    }

    public static String b(Context context) {
        Exception e;
        String str = "";
        if (context == null) {
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            return str;
        }
        try {
            context = telephonyManager.getDeviceId();
            try {
                if (TextUtils.isEmpty(context)) {
                    context = "";
                }
            } catch (Exception e2) {
                e = e2;
                if (e instanceof SecurityException) {
                    e.printStackTrace();
                }
                return context;
            }
        } catch (Context context2) {
            String str2 = str;
            e = context2;
            context2 = str2;
            if (e instanceof SecurityException) {
                e.printStackTrace();
            }
            return context2;
        }
        return context2;
    }

    public static String c(Context context) {
        Exception e;
        String str = "";
        if (context == null) {
            return str;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            return str;
        }
        try {
            context = wifiManager.getConnectionInfo();
            if (context != null) {
                context = context.getMacAddress();
                try {
                    if (TextUtils.isEmpty(context)) {
                        str = "";
                    } else {
                        str = context.trim();
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    str = context;
                    return str;
                }
            }
        } catch (Context context2) {
            String str2 = str;
            e = context2;
            context2 = str2;
            e.printStackTrace();
            str = context2;
            return str;
        }
        return str;
    }
}
