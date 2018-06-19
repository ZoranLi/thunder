package com.ta.utdid2.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;

public class NetworkUtils {
    public static final String DEFAULT_WIFI_ADDRESS = "00-00-00-00-00-00";
    private static final String TAG = "NetworkUtils";
    private static final int[] WEAK_NETWORK_GROUP = new int[]{4, 7, 2, 1};
    public static final String WIFI = "Wi-Fi";
    private static ConnectivityManager sConnManager;

    public static boolean isConnected(Context context) {
        context = getConnManager(context);
        if (context != null) {
            try {
                context = context.getActiveNetworkInfo();
                if (context != null) {
                    return context.isConnected();
                }
            } catch (Context context2) {
                context2.toString();
            }
        }
        return null;
    }

    public static boolean isConnectedToWeakNetwork(Context context) {
        context = getConnManager(context);
        if (context != null) {
            try {
                context = context.getActiveNetworkInfo();
                if (context != null) {
                    int subtype = context.getSubtype();
                    if (DebugUtils.DBG) {
                        StringBuilder stringBuilder = new StringBuilder("subType:");
                        stringBuilder.append(subtype);
                        stringBuilder.append(": name:");
                        stringBuilder.append(context.getSubtypeName());
                    }
                    for (int i : WEAK_NETWORK_GROUP) {
                        if (i == subtype) {
                            return true;
                        }
                    }
                }
            } catch (Context context2) {
                context2.toString();
            }
        }
        return false;
    }

    public static ConnectivityManager getConnManager(Context context) {
        if (context == null) {
            return null;
        }
        if (sConnManager == null) {
            sConnManager = (ConnectivityManager) context.getSystemService("connectivity");
        }
        return sConnManager;
    }

    public static java.lang.String[] getNetworkState(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
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
        r1 = r6.getPackageManager();	 Catch:{ Exception -> 0x005d }
        r4 = "android.permission.ACCESS_NETWORK_STATE";	 Catch:{ Exception -> 0x005d }
        r5 = r6.getPackageName();	 Catch:{ Exception -> 0x005d }
        r1 = r1.checkPermission(r4, r5);	 Catch:{ Exception -> 0x005d }
        if (r1 == 0) goto L_0x0022;	 Catch:{ Exception -> 0x005d }
    L_0x001d:
        r6 = "Unknown";	 Catch:{ Exception -> 0x005d }
        r0[r2] = r6;	 Catch:{ Exception -> 0x005d }
        return r0;	 Catch:{ Exception -> 0x005d }
    L_0x0022:
        r1 = "connectivity";	 Catch:{ Exception -> 0x005d }
        r6 = r6.getSystemService(r1);	 Catch:{ Exception -> 0x005d }
        r6 = (android.net.ConnectivityManager) r6;	 Catch:{ Exception -> 0x005d }
        if (r6 != 0) goto L_0x0031;	 Catch:{ Exception -> 0x005d }
    L_0x002c:
        r6 = "Unknown";	 Catch:{ Exception -> 0x005d }
        r0[r2] = r6;	 Catch:{ Exception -> 0x005d }
        return r0;	 Catch:{ Exception -> 0x005d }
    L_0x0031:
        r1 = r6.getNetworkInfo(r3);	 Catch:{ Exception -> 0x005d }
        if (r1 == 0) goto L_0x0044;	 Catch:{ Exception -> 0x005d }
    L_0x0037:
        r1 = r1.getState();	 Catch:{ Exception -> 0x005d }
        r4 = android.net.NetworkInfo.State.CONNECTED;	 Catch:{ Exception -> 0x005d }
        if (r1 != r4) goto L_0x0044;	 Catch:{ Exception -> 0x005d }
    L_0x003f:
        r6 = "Wi-Fi";	 Catch:{ Exception -> 0x005d }
        r0[r2] = r6;	 Catch:{ Exception -> 0x005d }
        return r0;	 Catch:{ Exception -> 0x005d }
    L_0x0044:
        r6 = r6.getNetworkInfo(r2);	 Catch:{ Exception -> 0x005d }
        if (r6 == 0) goto L_0x005d;	 Catch:{ Exception -> 0x005d }
    L_0x004a:
        r1 = r6.getState();	 Catch:{ Exception -> 0x005d }
        r4 = android.net.NetworkInfo.State.CONNECTED;	 Catch:{ Exception -> 0x005d }
        if (r1 != r4) goto L_0x005d;	 Catch:{ Exception -> 0x005d }
    L_0x0052:
        r1 = "2G/3G";	 Catch:{ Exception -> 0x005d }
        r0[r2] = r1;	 Catch:{ Exception -> 0x005d }
        r6 = r6.getSubtypeName();	 Catch:{ Exception -> 0x005d }
        r0[r3] = r6;	 Catch:{ Exception -> 0x005d }
        return r0;
    L_0x005d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.android.utils.NetworkUtils.getNetworkState(android.content.Context):java.lang.String[]");
    }

    public static String getWifiAddress(Context context) {
        if (context == null) {
            return DEFAULT_WIFI_ADDRESS;
        }
        context = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (context == null) {
            return DEFAULT_WIFI_ADDRESS;
        }
        context = context.getMacAddress();
        if (StringUtils.isEmpty(context)) {
            context = DEFAULT_WIFI_ADDRESS;
        }
        return context;
    }

    private static String _convertIntToIp(int i) {
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(i & 255));
        stringBuilder.append(".");
        stringBuilder.append((i >> 8) & 255);
        stringBuilder.append(".");
        stringBuilder.append((i >> 16) & 255);
        stringBuilder.append(".");
        stringBuilder.append((i >> 24) & 255);
        return stringBuilder.toString();
    }

    public static java.lang.String getWifiIpAddress(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r2 == 0) goto L_0x001b;
    L_0x0003:
        r1 = "wifi";	 Catch:{ Exception -> 0x001b }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x001b }
        r2 = (android.net.wifi.WifiManager) r2;	 Catch:{ Exception -> 0x001b }
        r2 = r2.getConnectionInfo();	 Catch:{ Exception -> 0x001b }
        if (r2 == 0) goto L_0x001a;	 Catch:{ Exception -> 0x001b }
    L_0x0011:
        r2 = r2.getIpAddress();	 Catch:{ Exception -> 0x001b }
        r2 = _convertIntToIp(r2);	 Catch:{ Exception -> 0x001b }
        return r2;
    L_0x001a:
        return r0;
    L_0x001b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.android.utils.NetworkUtils.getWifiIpAddress(android.content.Context):java.lang.String");
    }

    public static boolean isWifi(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r2 == 0) goto L_0x0013;
    L_0x0003:
        r2 = getNetworkState(r2);	 Catch:{ Exception -> 0x0013 }
        r2 = r2[r0];	 Catch:{ Exception -> 0x0013 }
        r1 = "Wi-Fi";	 Catch:{ Exception -> 0x0013 }
        r2 = r2.equals(r1);	 Catch:{ Exception -> 0x0013 }
        if (r2 == 0) goto L_0x0013;
    L_0x0011:
        r2 = 1;
        return r2;
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ta.utdid2.android.utils.NetworkUtils.isWifi(android.content.Context):boolean");
    }
}
