package com.xiaomi.metoknlp.devicediscover;

import android.content.Context;
import android.content.SharedPreferences.Editor;

class j {
    public static android.net.DhcpInfo a(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r4 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = "wifi";
        r1 = r4.getSystemService(r1);
        r1 = (android.net.wifi.WifiManager) r1;
        if (r1 == 0) goto L_0x002a;
    L_0x000e:
        r2 = r1.isWifiEnabled();
        if (r2 != 0) goto L_0x0015;
    L_0x0014:
        return r0;
    L_0x0015:
        r2 = r4.getPackageManager();	 Catch:{ Exception -> 0x002a }
        r3 = "android.permission.ACCESS_WIFI_STATE";	 Catch:{ Exception -> 0x002a }
        r4 = r4.getPackageName();	 Catch:{ Exception -> 0x002a }
        r4 = r2.checkPermission(r3, r4);	 Catch:{ Exception -> 0x002a }
        if (r4 != 0) goto L_0x002a;	 Catch:{ Exception -> 0x002a }
    L_0x0025:
        r4 = r1.getDhcpInfo();	 Catch:{ Exception -> 0x002a }
        r0 = r4;
    L_0x002a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.devicediscover.j.a(android.content.Context):android.net.DhcpInfo");
    }

    public static java.lang.String a(android.content.Context r4, int r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "wifi";	 Catch:{ Exception -> 0x0046 }
        r1 = r4.getSystemService(r1);	 Catch:{ Exception -> 0x0046 }
        r1 = (android.net.wifi.WifiManager) r1;	 Catch:{ Exception -> 0x0046 }
        if (r1 == 0) goto L_0x0046;	 Catch:{ Exception -> 0x0046 }
    L_0x000b:
        r2 = r1.isWifiEnabled();	 Catch:{ Exception -> 0x0046 }
        if (r2 != 0) goto L_0x0012;
    L_0x0011:
        return r0;
    L_0x0012:
        r2 = r4.getPackageManager();	 Catch:{ Exception -> 0x0027 }
        r3 = "android.permission.ACCESS_WIFI_STATE";	 Catch:{ Exception -> 0x0027 }
        r4 = r4.getPackageName();	 Catch:{ Exception -> 0x0027 }
        r4 = r2.checkPermission(r3, r4);	 Catch:{ Exception -> 0x0027 }
        if (r4 != 0) goto L_0x0027;	 Catch:{ Exception -> 0x0027 }
    L_0x0022:
        r4 = r1.getConnectionInfo();	 Catch:{ Exception -> 0x0027 }
        goto L_0x0028;
    L_0x0027:
        r4 = r0;
    L_0x0028:
        if (r4 != 0) goto L_0x002b;
    L_0x002a:
        return r0;
    L_0x002b:
        if (r5 != 0) goto L_0x0032;
    L_0x002d:
        r4 = r4.getMacAddress();	 Catch:{ Exception -> 0x0046 }
        return r4;	 Catch:{ Exception -> 0x0046 }
    L_0x0032:
        r1 = 1;	 Catch:{ Exception -> 0x0046 }
        if (r5 != r1) goto L_0x003a;	 Catch:{ Exception -> 0x0046 }
    L_0x0035:
        r4 = r4.getBSSID();	 Catch:{ Exception -> 0x0046 }
        return r4;	 Catch:{ Exception -> 0x0046 }
    L_0x003a:
        r1 = 2;	 Catch:{ Exception -> 0x0046 }
        if (r5 != r1) goto L_0x0046;	 Catch:{ Exception -> 0x0046 }
    L_0x003d:
        r4 = r4.getSSID();	 Catch:{ Exception -> 0x0046 }
        r4 = a(r4);	 Catch:{ Exception -> 0x0046 }
        return r4;
    L_0x0046:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.devicediscover.j.a(android.content.Context, int):java.lang.String");
    }

    private static String a(String str) {
        return (str.startsWith("\"") && str.endsWith("\"")) ? str.substring(1, str.length() - 1) : str;
    }

    public static java.net.InetAddress a(int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 4;
        r0 = new byte[r0];
        r1 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r2 = r1 & r4;
        r2 = (byte) r2;
        r3 = 0;
        r0[r3] = r2;
        r2 = r4 >> 8;
        r2 = r2 & r1;
        r2 = (byte) r2;
        r3 = 1;
        r0[r3] = r2;
        r2 = r4 >> 16;
        r2 = r2 & r1;
        r2 = (byte) r2;
        r3 = 2;
        r0[r3] = r2;
        r4 = r4 >> 24;
        r4 = r4 & r1;
        r4 = (byte) r4;
        r1 = 3;
        r0[r1] = r4;
        r4 = java.net.InetAddress.getByAddress(r0);	 Catch:{ UnknownHostException -> 0x0025 }
        return r4;
    L_0x0025:
        r4 = new java.lang.AssertionError;
        r4.<init>();
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.devicediscover.j.a(int):java.net.InetAddress");
    }

    public static void a(Context context, String str, String str2) {
        Editor edit = context.getSharedPreferences("devicediscover", 0).edit();
        edit.putString(str, str2);
        edit.commit();
    }

    public static java.lang.String b(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = a(r1);	 Catch:{ Exception -> 0x0013 }
        if (r1 != 0) goto L_0x0008;	 Catch:{ Exception -> 0x0013 }
    L_0x0007:
        return r0;	 Catch:{ Exception -> 0x0013 }
    L_0x0008:
        r1 = r1.gateway;	 Catch:{ Exception -> 0x0013 }
        r1 = a(r1);	 Catch:{ Exception -> 0x0013 }
        r1 = r1.getHostAddress();	 Catch:{ Exception -> 0x0013 }
        return r1;
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.devicediscover.j.b(android.content.Context):java.lang.String");
    }

    public static String b(Context context, String str, String str2) {
        return context.getSharedPreferences("devicediscover", 0).getString(str, str2);
    }

    public static java.lang.String c(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = a(r1);	 Catch:{ Exception -> 0x0013 }
        if (r1 != 0) goto L_0x0008;	 Catch:{ Exception -> 0x0013 }
    L_0x0007:
        return r0;	 Catch:{ Exception -> 0x0013 }
    L_0x0008:
        r1 = r1.serverAddress;	 Catch:{ Exception -> 0x0013 }
        r1 = a(r1);	 Catch:{ Exception -> 0x0013 }
        r1 = r1.getHostAddress();	 Catch:{ Exception -> 0x0013 }
        return r1;
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.devicediscover.j.c(android.content.Context):java.lang.String");
    }

    public static java.lang.String d(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r6 = a(r6, r0);
        if (r6 == 0) goto L_0x0015;
    L_0x0007:
        r1 = r6.isEmpty();
        if (r1 != 0) goto L_0x0015;
    L_0x000d:
        r1 = "02:00:00:00:00:00";
        r1 = r1.equals(r6);
        if (r1 == 0) goto L_0x004a;
    L_0x0015:
        r1 = 0;
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3 = new char[r2];	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x0041, all -> 0x003a }
        r4 = new java.io.FileReader;	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x0041, all -> 0x003a }
        r5 = "/sys/class/net/wlan0/address";	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x0041, all -> 0x003a }
        r4.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0047, Exception -> 0x0041, all -> 0x003a }
        r1 = r4.read(r3, r0, r2);	 Catch:{ FileNotFoundException -> 0x0038, Exception -> 0x0036, all -> 0x0033 }
        r2 = new java.lang.String;	 Catch:{ FileNotFoundException -> 0x0038, Exception -> 0x0036, all -> 0x0033 }
        r2.<init>(r3, r0, r1);	 Catch:{ FileNotFoundException -> 0x0038, Exception -> 0x0036, all -> 0x0033 }
        r0 = r2.trim();	 Catch:{ FileNotFoundException -> 0x0038, Exception -> 0x0036, all -> 0x0033 }
        r4.close();	 Catch:{ Exception -> 0x0031 }
    L_0x0031:
        r6 = r0;
        return r6;
    L_0x0033:
        r6 = move-exception;
        r1 = r4;
        goto L_0x003b;
    L_0x0036:
        r1 = r4;
        goto L_0x0041;
    L_0x0038:
        r1 = r4;
        goto L_0x0047;
    L_0x003a:
        r6 = move-exception;
    L_0x003b:
        if (r1 == 0) goto L_0x0040;
    L_0x003d:
        r1.close();	 Catch:{ Exception -> 0x0040 }
    L_0x0040:
        throw r6;
    L_0x0041:
        if (r1 == 0) goto L_0x004a;
    L_0x0043:
        r1.close();	 Catch:{ Exception -> 0x004a }
        return r6;
    L_0x0047:
        if (r1 == 0) goto L_0x004a;
    L_0x0049:
        goto L_0x0043;
    L_0x004a:
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.metoknlp.devicediscover.j.d(android.content.Context):java.lang.String");
    }
}
