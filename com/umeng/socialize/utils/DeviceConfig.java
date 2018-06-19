package com.umeng.socialize.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

public class DeviceConfig {
    protected static final String LOG_TAG = "DeviceConfig";
    private static final String MOBILE_NETWORK = "2G/3G";
    protected static final String UNKNOW = "Unknown";
    private static final String WIFI = "Wi-Fi";
    public static Context context;
    private static Object object = new Object();

    public static boolean isAppInstalled(java.lang.String r3, android.content.Context r4) {
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
        r1 = object;
        monitor-enter(r1);
        r2 = 1;
        r4 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0013, NameNotFoundException -> 0x0013 }
        r4.getPackageInfo(r3, r2);	 Catch:{ NameNotFoundException -> 0x0013, NameNotFoundException -> 0x0013 }
        r0 = r2;
        goto L_0x0013;
    L_0x0011:
        r3 = move-exception;
        goto L_0x0015;
    L_0x0013:
        monitor-exit(r1);	 Catch:{ all -> 0x0011 }
        return r0;	 Catch:{ all -> 0x0011 }
    L_0x0015:
        monitor-exit(r1);	 Catch:{ all -> 0x0011 }
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.utils.DeviceConfig.isAppInstalled(java.lang.String, android.content.Context):boolean");
    }

    public static java.lang.String getAppVersion(java.lang.String r1, android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r2 != 0) goto L_0x0005;
    L_0x0002:
        r1 = "";
        return r1;
    L_0x0005:
        r2 = r2.getPackageManager();	 Catch:{ Exception -> 0x0011 }
        r0 = 0;	 Catch:{ Exception -> 0x0011 }
        r1 = r2.getPackageInfo(r1, r0);	 Catch:{ Exception -> 0x0011 }
        r1 = r1.versionName;	 Catch:{ Exception -> 0x0011 }
        return r1;
    L_0x0011:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.utils.DeviceConfig.getAppVersion(java.lang.String, android.content.Context):java.lang.String");
    }

    public static boolean checkPermission(Context context, String str) {
        if (context == null || context == null || context.getPackageManager().checkPermission(str, context.getPackageName()) != null) {
            return false;
        }
        return true;
    }

    public static String getDeviceId(Context context) {
        if (context == null) {
            return "";
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            Log.w(LOG_TAG, "No IMEI.");
        }
        String str = "";
        try {
            if (checkPermission(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                str = telephonyManager.getDeviceId();
            }
        } catch (Exception e) {
            Log.w(LOG_TAG, "No IMEI.", e);
        }
        if (TextUtils.isEmpty(str)) {
            Log.w(LOG_TAG, "No IMEI.");
            str = getMac(context);
            if (TextUtils.isEmpty(str)) {
                Log.w(LOG_TAG, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
                str = Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
                context = LOG_TAG;
                StringBuilder stringBuilder = new StringBuilder("getDeviceId: Secure.ANDROID_ID: ");
                stringBuilder.append(str);
                Log.w(context, stringBuilder.toString());
                if (TextUtils.isEmpty(str) != null) {
                    return getDeviceSN();
                }
            }
        }
        return str;
    }

    public static java.lang.String getDeviceSN() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "android.os.SystemProperties";	 Catch:{ Exception -> 0x002a }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x002a }
        r1 = "get";	 Catch:{ Exception -> 0x002a }
        r2 = 2;	 Catch:{ Exception -> 0x002a }
        r3 = new java.lang.Class[r2];	 Catch:{ Exception -> 0x002a }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x002a }
        r5 = 0;	 Catch:{ Exception -> 0x002a }
        r3[r5] = r4;	 Catch:{ Exception -> 0x002a }
        r4 = java.lang.String.class;	 Catch:{ Exception -> 0x002a }
        r6 = 1;	 Catch:{ Exception -> 0x002a }
        r3[r6] = r4;	 Catch:{ Exception -> 0x002a }
        r1 = r0.getMethod(r1, r3);	 Catch:{ Exception -> 0x002a }
        r2 = new java.lang.Object[r2];	 Catch:{ Exception -> 0x002a }
        r3 = "ro.serialno";	 Catch:{ Exception -> 0x002a }
        r2[r5] = r3;	 Catch:{ Exception -> 0x002a }
        r3 = "unknown";	 Catch:{ Exception -> 0x002a }
        r2[r6] = r3;	 Catch:{ Exception -> 0x002a }
        r0 = r1.invoke(r0, r2);	 Catch:{ Exception -> 0x002a }
        r0 = (java.lang.String) r0;	 Catch:{ Exception -> 0x002a }
        goto L_0x002b;
    L_0x002a:
        r0 = 0;
    L_0x002b:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.utils.DeviceConfig.getDeviceSN():java.lang.String");
    }

    public static String[] getNetworkAccessMode(Context context) {
        if (context == null) {
            return new String[]{"", ""};
        }
        String[] strArr = new String[]{UNKNOW, UNKNOW};
        if (context.getPackageManager().checkPermission(MsgConstant.PERMISSION_ACCESS_NETWORK_STATE, context.getPackageName()) != 0) {
            strArr[0] = UNKNOW;
            return strArr;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = UNKNOW;
            return strArr;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
        if (networkInfo == null || networkInfo.getState() != State.CONNECTED) {
            context = connectivityManager.getNetworkInfo(0);
            if (context == null || context.getState() != State.CONNECTED) {
                return strArr;
            }
            strArr[0] = MOBILE_NETWORK;
            strArr[1] = context.getSubtypeName();
            return strArr;
        }
        strArr[0] = "Wi-Fi";
        return strArr;
    }

    public static boolean isOnline(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r2 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = "connectivity";	 Catch:{ Exception -> 0x0018 }
        r2 = r2.getSystemService(r1);	 Catch:{ Exception -> 0x0018 }
        r2 = (android.net.ConnectivityManager) r2;	 Catch:{ Exception -> 0x0018 }
        r2 = r2.getActiveNetworkInfo();	 Catch:{ Exception -> 0x0018 }
        if (r2 == 0) goto L_0x0017;	 Catch:{ Exception -> 0x0018 }
    L_0x0012:
        r2 = r2.isConnectedOrConnecting();	 Catch:{ Exception -> 0x0018 }
        return r2;
    L_0x0017:
        return r0;
    L_0x0018:
        r2 = 1;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.utils.DeviceConfig.isOnline(android.content.Context):boolean");
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null || !checkPermission(context, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE) || isOnline(context) == null) {
            return false;
        }
        return true;
    }

    public static boolean isSdCardWrittenable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static String getAndroidID(Context context) {
        return context == null ? "" : Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
    }

    public static String getOsVersion() {
        return VERSION.RELEASE;
    }

    public static String getMac(Context context) {
        String str;
        StringBuilder stringBuilder;
        if (context == null) {
            return "";
        }
        String str2 = "";
        try {
            CharSequence macShell = getMacShell();
            try {
                Context context2;
                if (TextUtils.isEmpty(macShell)) {
                    Log.w(LOG_TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
                }
                if (TextUtils.isEmpty(macShell)) {
                    str2 = getMacByJava();
                    if (TextUtils.isEmpty(str2)) {
                        Log.w(LOG_TAG, "Could not get mac address by java");
                    }
                } else {
                    context2 = macShell;
                }
                if (TextUtils.isEmpty(context2)) {
                    context = SocializeSpUtils.getMac(context);
                } else {
                    SocializeSpUtils.putMac(context, context2);
                    context = context2;
                }
                return context;
            } catch (Exception e) {
                context = e;
                str2 = macShell;
                str = LOG_TAG;
                stringBuilder = new StringBuilder("Could not get mac address.");
                stringBuilder.append(context.toString());
                Log.w(str, stringBuilder.toString());
                return str2;
            }
        } catch (Exception e2) {
            context = e2;
            str = LOG_TAG;
            stringBuilder = new StringBuilder("Could not get mac address.");
            stringBuilder.append(context.toString());
            Log.w(str, stringBuilder.toString());
            return str2;
        }
    }

    private static java.lang.String getMacByJava() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = java.net.NetworkInterface.getNetworkInterfaces();	 Catch:{ Exception -> 0x005c }
    L_0x0005:
        r2 = r1.hasMoreElements();	 Catch:{ Exception -> 0x005c }
        if (r2 == 0) goto L_0x005c;	 Catch:{ Exception -> 0x005c }
    L_0x000b:
        r2 = r1.nextElement();	 Catch:{ Exception -> 0x005c }
        r2 = (java.net.NetworkInterface) r2;	 Catch:{ Exception -> 0x005c }
        r3 = r2.getName();	 Catch:{ Exception -> 0x005c }
        r4 = "wlan0";	 Catch:{ Exception -> 0x005c }
        r3 = r3.equals(r4);	 Catch:{ Exception -> 0x005c }
        if (r3 == 0) goto L_0x0005;	 Catch:{ Exception -> 0x005c }
    L_0x001d:
        r1 = r2.getHardwareAddress();	 Catch:{ Exception -> 0x005c }
        if (r1 == 0) goto L_0x005b;	 Catch:{ Exception -> 0x005c }
    L_0x0023:
        r2 = r1.length;	 Catch:{ Exception -> 0x005c }
        if (r2 != 0) goto L_0x0027;	 Catch:{ Exception -> 0x005c }
    L_0x0026:
        goto L_0x005b;	 Catch:{ Exception -> 0x005c }
    L_0x0027:
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x005c }
        r2.<init>();	 Catch:{ Exception -> 0x005c }
        r3 = r1.length;	 Catch:{ Exception -> 0x005c }
        r4 = 0;	 Catch:{ Exception -> 0x005c }
        r5 = r4;	 Catch:{ Exception -> 0x005c }
    L_0x002f:
        r6 = 1;	 Catch:{ Exception -> 0x005c }
        if (r5 >= r3) goto L_0x0048;	 Catch:{ Exception -> 0x005c }
    L_0x0032:
        r7 = r1[r5];	 Catch:{ Exception -> 0x005c }
        r8 = "%02X:";	 Catch:{ Exception -> 0x005c }
        r6 = new java.lang.Object[r6];	 Catch:{ Exception -> 0x005c }
        r7 = java.lang.Byte.valueOf(r7);	 Catch:{ Exception -> 0x005c }
        r6[r4] = r7;	 Catch:{ Exception -> 0x005c }
        r6 = java.lang.String.format(r8, r6);	 Catch:{ Exception -> 0x005c }
        r2.append(r6);	 Catch:{ Exception -> 0x005c }
        r5 = r5 + 1;	 Catch:{ Exception -> 0x005c }
        goto L_0x002f;	 Catch:{ Exception -> 0x005c }
    L_0x0048:
        r1 = r2.length();	 Catch:{ Exception -> 0x005c }
        if (r1 <= 0) goto L_0x0056;	 Catch:{ Exception -> 0x005c }
    L_0x004e:
        r1 = r2.length();	 Catch:{ Exception -> 0x005c }
        r1 = r1 - r6;	 Catch:{ Exception -> 0x005c }
        r2.deleteCharAt(r1);	 Catch:{ Exception -> 0x005c }
    L_0x0056:
        r1 = r2.toString();	 Catch:{ Exception -> 0x005c }
        return r1;
    L_0x005b:
        return r0;
    L_0x005c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.utils.DeviceConfig.getMacByJava():java.lang.String");
    }

    public static String getPackageName(Context context) {
        return context == null ? "" : context.getPackageName();
    }

    private static java.lang.String getMacShell() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 3;
        r1 = new java.lang.String[r0];
        r2 = "/sys/class/net/wlan0/address";
        r3 = 0;
        r1[r3] = r2;
        r2 = "/sys/class/net/eth0/address";
        r4 = 1;
        r1[r4] = r2;
        r2 = "/sys/devices/virtual/net/wlan0/address";
        r4 = 2;
        r1[r4] = r2;
    L_0x0012:
        if (r3 >= r0) goto L_0x0020;
    L_0x0014:
        r2 = r1[r3];	 Catch:{ Exception -> 0x001d }
        r2 = reaMac(r2);	 Catch:{ Exception -> 0x001d }
        if (r2 == 0) goto L_0x001d;
    L_0x001c:
        return r2;
    L_0x001d:
        r3 = r3 + 1;
        goto L_0x0012;
    L_0x0020:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.utils.DeviceConfig.getMacShell():java.lang.String");
    }

    private static java.lang.String reaMac(java.lang.String r4) throws java.io.FileNotFoundException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.FileReader;
        r0.<init>(r4);
        r4 = 0;
        r1 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x0028, all -> 0x001e }
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ IOException -> 0x0028, all -> 0x001e }
        r1.<init>(r0, r2);	 Catch:{ IOException -> 0x0028, all -> 0x001e }
        r2 = r1.readLine();	 Catch:{ IOException -> 0x0029, all -> 0x0019 }
        r0.close();	 Catch:{ IOException -> 0x0014 }
    L_0x0014:
        r1.close();	 Catch:{ IOException -> 0x0017 }
    L_0x0017:
        r4 = r2;
        goto L_0x0031;
    L_0x0019:
        r4 = move-exception;
        r3 = r1;
        r1 = r4;
        r4 = r3;
        goto L_0x001f;
    L_0x001e:
        r1 = move-exception;
    L_0x001f:
        r0.close();	 Catch:{ IOException -> 0x0022 }
    L_0x0022:
        if (r4 == 0) goto L_0x0027;
    L_0x0024:
        r4.close();	 Catch:{ IOException -> 0x0027 }
    L_0x0027:
        throw r1;
    L_0x0028:
        r1 = r4;
    L_0x0029:
        r0.close();	 Catch:{ IOException -> 0x002c }
    L_0x002c:
        if (r1 == 0) goto L_0x0031;
    L_0x002e:
        r1.close();	 Catch:{ IOException -> 0x0031 }
    L_0x0031:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.utils.DeviceConfig.reaMac(java.lang.String):java.lang.String");
    }
}
