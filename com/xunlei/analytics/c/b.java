package com.xunlei.analytics.c;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.message.MsgConstant;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.util.Enumeration;

public class b {
    private static int a(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
                return 3;
            case 13:
                return 4;
            default:
                return -1;
        }
    }

    public static String a() {
        String str = null;
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        str = inetAddress.getHostAddress();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str == null ? "" : str;
    }

    public static String a(Context context) {
        String str;
        if (context != null) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str != null ? "" : str;
        }
        str = null;
        if (str != null) {
        }
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static String b(Context context) {
        String deviceId;
        if (context.getApplicationContext().checkPermission(MsgConstant.PERMISSION_READ_PHONE_STATE, Process.myPid(), Process.myUid()) == 0) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                deviceId = telephonyManager.getDeviceId();
                return deviceId == null ? deviceId : "";
            }
        }
        deviceId = null;
        if (deviceId == null) {
        }
    }

    public static java.lang.String c(android.content.Context r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = "wlan0";	 Catch:{ Exception -> 0x0068 }
        r0 = java.net.NetworkInterface.getNetworkInterfaces();	 Catch:{ Exception -> 0x0068 }
        r0 = java.util.Collections.list(r0);	 Catch:{ Exception -> 0x0068 }
        r0 = r0.iterator();	 Catch:{ Exception -> 0x0068 }
    L_0x000e:
        r1 = r0.hasNext();	 Catch:{ Exception -> 0x0068 }
        if (r1 == 0) goto L_0x0065;	 Catch:{ Exception -> 0x0068 }
    L_0x0014:
        r1 = r0.next();	 Catch:{ Exception -> 0x0068 }
        r1 = (java.net.NetworkInterface) r1;	 Catch:{ Exception -> 0x0068 }
        r2 = r1.getName();	 Catch:{ Exception -> 0x0068 }
        r2 = r2.equalsIgnoreCase(r7);	 Catch:{ Exception -> 0x0068 }
        if (r2 == 0) goto L_0x000e;	 Catch:{ Exception -> 0x0068 }
    L_0x0024:
        r7 = r1.getHardwareAddress();	 Catch:{ Exception -> 0x0068 }
        if (r7 != 0) goto L_0x002d;	 Catch:{ Exception -> 0x0068 }
    L_0x002a:
        r7 = "";	 Catch:{ Exception -> 0x0068 }
        return r7;	 Catch:{ Exception -> 0x0068 }
    L_0x002d:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0068 }
        r0.<init>();	 Catch:{ Exception -> 0x0068 }
        r1 = r7.length;	 Catch:{ Exception -> 0x0068 }
        r2 = 0;	 Catch:{ Exception -> 0x0068 }
        r3 = r2;	 Catch:{ Exception -> 0x0068 }
    L_0x0035:
        r4 = 1;	 Catch:{ Exception -> 0x0068 }
        if (r3 >= r1) goto L_0x004e;	 Catch:{ Exception -> 0x0068 }
    L_0x0038:
        r5 = r7[r3];	 Catch:{ Exception -> 0x0068 }
        r6 = "%02X:";	 Catch:{ Exception -> 0x0068 }
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0068 }
        r5 = java.lang.Byte.valueOf(r5);	 Catch:{ Exception -> 0x0068 }
        r4[r2] = r5;	 Catch:{ Exception -> 0x0068 }
        r4 = java.lang.String.format(r6, r4);	 Catch:{ Exception -> 0x0068 }
        r0.append(r4);	 Catch:{ Exception -> 0x0068 }
        r3 = r3 + 1;	 Catch:{ Exception -> 0x0068 }
        goto L_0x0035;	 Catch:{ Exception -> 0x0068 }
    L_0x004e:
        r7 = r0.length();	 Catch:{ Exception -> 0x0068 }
        if (r7 <= 0) goto L_0x005c;	 Catch:{ Exception -> 0x0068 }
    L_0x0054:
        r7 = r0.length();	 Catch:{ Exception -> 0x0068 }
        r7 = r7 - r4;	 Catch:{ Exception -> 0x0068 }
        r0.deleteCharAt(r7);	 Catch:{ Exception -> 0x0068 }
    L_0x005c:
        r7 = r0.toString();	 Catch:{ Exception -> 0x0068 }
        r7 = r7.toLowerCase();	 Catch:{ Exception -> 0x0068 }
        return r7;
    L_0x0065:
        r7 = "";
        return r7;
    L_0x0068:
        r7 = "";
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.analytics.c.b.c(android.content.Context):java.lang.String");
    }

    public static int d(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.getType() == 1) {
                return 9;
            }
            if (activeNetworkInfo.getType() == 0) {
                return a(activeNetworkInfo.getSubtype());
            }
        }
        return -1;
    }

    public static boolean e(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            activeNetworkInfo.getType();
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static boolean f(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected() && activeNetworkInfo.getType() == 1;
    }

    public static int g(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null ? activeNetworkInfo.getType() : 1;
    }
}
