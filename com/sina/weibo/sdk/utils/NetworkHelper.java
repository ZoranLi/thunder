package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.umeng.message.MsgConstant;
import java.util.List;

public class NetworkHelper {
    public static boolean hasInternetPermission(Context context) {
        return (context == null || context.checkCallingOrSelfPermission(MsgConstant.PERMISSION_INTERNET) == null) ? true : null;
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        context = getActiveNetworkInfo(context);
        if (context == null || context.isConnected() == null) {
            return false;
        }
        return true;
    }

    public static boolean isWifiValid(Context context) {
        if (context == null) {
            return false;
        }
        context = getActiveNetworkInfo(context);
        if (context == null || 1 != context.getType() || context.isConnected() == null) {
            return false;
        }
        return true;
    }

    public static boolean isMobileNetwork(Context context) {
        if (context == null) {
            return false;
        }
        context = getActiveNetworkInfo(context);
        if (context == null || context == null || context.getType() != 0 || context.isConnected() == null) {
            return false;
        }
        return true;
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
    }

    public static NetworkInfo getNetworkInfo(Context context, int i) {
        return ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(i);
    }

    public static int getNetworkType(Context context) {
        if (context == null) {
            return -1;
        }
        context = getActiveNetworkInfo(context);
        if (context == null) {
            return -1;
        }
        return context.getType();
    }

    public static int getWifiState(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            return 4;
        }
        return wifiManager.getWifiState();
    }

    public static DetailedState getWifiConnectivityState(Context context) {
        context = getNetworkInfo(context, 1);
        return context == null ? DetailedState.FAILED : context.getDetailedState();
    }

    public static boolean wifiConnection(Context context, String str, String str2) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        StringBuilder stringBuilder = new StringBuilder("\"");
        stringBuilder.append(str);
        stringBuilder.append("\"");
        String stringBuilder2 = stringBuilder.toString();
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo != null) {
            if (str.equals(connectionInfo.getSSID())) {
                return true;
            }
            if (stringBuilder2.equals(connectionInfo.getSSID())) {
                return true;
            }
        }
        List scanResults = wifiManager.getScanResults();
        if (!(scanResults == null || scanResults.size() == 0)) {
            int size = scanResults.size() - 1;
            while (size >= 0) {
                String str3 = ((ScanResult) scanResults.get(size)).SSID;
                if (!str.equals(str3)) {
                    if (!stringBuilder2.equals(str3)) {
                        size--;
                    }
                }
                str = new WifiConfiguration();
                str.SSID = stringBuilder2;
                stringBuilder = new StringBuilder("\"");
                stringBuilder.append(str2);
                stringBuilder.append("\"");
                str.preSharedKey = stringBuilder.toString();
                str.status = 2;
                return wifiManager.enableNetwork(wifiManager.addNetwork(str), false);
            }
        }
        return false;
    }

    public static void clearCookies(Context context) {
        CookieSyncManager.createInstance(context);
        CookieManager.getInstance().removeAllCookie();
        CookieSyncManager.getInstance().sync();
    }

    public static java.lang.String generateUA(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Android";
        r0.append(r1);
        r1 = "__";
        r0.append(r1);
        r1 = "weibo";
        r0.append(r1);
        r1 = "__";
        r0.append(r1);
        r1 = "sdk";
        r0.append(r1);
        r1 = "__";
        r0.append(r1);
        r1 = r3.getPackageManager();	 Catch:{ Exception -> 0x003f }
        r3 = r3.getPackageName();	 Catch:{ Exception -> 0x003f }
        r2 = 16;	 Catch:{ Exception -> 0x003f }
        r3 = r1.getPackageInfo(r3, r2);	 Catch:{ Exception -> 0x003f }
        r3 = r3.versionName;	 Catch:{ Exception -> 0x003f }
        r1 = "\\s+";	 Catch:{ Exception -> 0x003f }
        r2 = "_";	 Catch:{ Exception -> 0x003f }
        r3 = r3.replaceAll(r1, r2);	 Catch:{ Exception -> 0x003f }
        r0.append(r3);	 Catch:{ Exception -> 0x003f }
        goto L_0x0044;
    L_0x003f:
        r3 = "unknown";
        r0.append(r3);
    L_0x0044:
        r3 = r0.toString();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.NetworkHelper.generateUA(android.content.Context):java.lang.String");
    }
}
