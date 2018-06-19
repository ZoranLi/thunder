package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.ap;
import com.umeng.message.proguard.k;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.NetworkInterface;
import java.util.Locale;

/* compiled from: BUGLY */
public class b {
    private static String a;
    private static String b;

    public static String a() {
        try {
            return Build.MODEL;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static String b() {
        try {
            return VERSION.RELEASE;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return "fail";
        }
    }

    public static int c() {
        try {
            return VERSION.SDK_INT;
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    public static java.lang.String a(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = "android.permission.READ_PHONE_STATE";
        r1 = com.tencent.bugly.crashreport.common.info.AppInfo.a(r3, r1);
        r2 = 0;
        if (r1 != 0) goto L_0x0015;
    L_0x000d:
        r3 = "no READ_PHONE_STATE permission to get IMEI";
        r1 = new java.lang.Object[r2];
        com.tencent.bugly.proguard.an.d(r3, r1);
        return r0;
    L_0x0015:
        r1 = "phone";	 Catch:{ Throwable -> 0x002e }
        r3 = r3.getSystemService(r1);	 Catch:{ Throwable -> 0x002e }
        r3 = (android.telephony.TelephonyManager) r3;	 Catch:{ Throwable -> 0x002e }
        if (r3 == 0) goto L_0x0035;	 Catch:{ Throwable -> 0x002e }
    L_0x001f:
        r3 = r3.getDeviceId();	 Catch:{ Throwable -> 0x002e }
        if (r3 == 0) goto L_0x002c;
    L_0x0025:
        r0 = r3.toLowerCase();	 Catch:{ Throwable -> 0x002a }
        goto L_0x0035;
    L_0x002a:
        r0 = r3;
        goto L_0x002e;
    L_0x002c:
        r0 = r3;
        goto L_0x0035;
    L_0x002e:
        r3 = "Failed to get IMEI.";
        r1 = new java.lang.Object[r2];
        com.tencent.bugly.proguard.an.a(r3, r1);
    L_0x0035:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.a(android.content.Context):java.lang.String");
    }

    public static java.lang.String b(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = "android.permission.READ_PHONE_STATE";
        r1 = com.tencent.bugly.crashreport.common.info.AppInfo.a(r3, r1);
        r2 = 0;
        if (r1 != 0) goto L_0x0015;
    L_0x000d:
        r3 = "no READ_PHONE_STATE permission to get IMSI";
        r1 = new java.lang.Object[r2];
        com.tencent.bugly.proguard.an.d(r3, r1);
        return r0;
    L_0x0015:
        r1 = "phone";	 Catch:{ Throwable -> 0x002e }
        r3 = r3.getSystemService(r1);	 Catch:{ Throwable -> 0x002e }
        r3 = (android.telephony.TelephonyManager) r3;	 Catch:{ Throwable -> 0x002e }
        if (r3 == 0) goto L_0x0035;	 Catch:{ Throwable -> 0x002e }
    L_0x001f:
        r3 = r3.getSubscriberId();	 Catch:{ Throwable -> 0x002e }
        if (r3 == 0) goto L_0x002c;
    L_0x0025:
        r0 = r3.toLowerCase();	 Catch:{ Throwable -> 0x002a }
        goto L_0x0035;
    L_0x002a:
        r0 = r3;
        goto L_0x002e;
    L_0x002c:
        r0 = r3;
        goto L_0x0035;
    L_0x002e:
        r3 = "Failed to get IMSI.";
        r1 = new java.lang.Object[r2];
        com.tencent.bugly.proguard.an.a(r3, r1);
    L_0x0035:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.b(android.content.Context):java.lang.String");
    }

    public static String c(Context context) {
        String str = "fail";
        if (context == null) {
            return str;
        }
        try {
            context = Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
            if (context == null) {
                try {
                    str = "null";
                } catch (Throwable th) {
                    Throwable th2 = th;
                    str = context;
                    context = th2;
                    if (an.a(context) == null) {
                        an.a("Failed to get Android ID.", new Object[0]);
                    }
                    return str;
                }
            }
            str = context.toLowerCase();
        } catch (Throwable th3) {
            context = th3;
            if (an.a(context) == null) {
                an.a("Failed to get Android ID.", new Object[0]);
            }
            return str;
        }
        return str;
    }

    public static String d(Context context) {
        String str = "fail";
        if (context == null) {
            return str;
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null) {
                    String macAddress = connectionInfo.getMacAddress();
                    if (macAddress != null) {
                        try {
                            if (macAddress.equals("02:00:00:00:00:00")) {
                            }
                            str = macAddress;
                        } catch (Throwable th) {
                            context = th;
                            str = macAddress;
                            if (!an.a(context)) {
                                context.printStackTrace();
                            }
                            if (str == null) {
                                str = "null";
                            }
                            an.c("MAC address: %s", str);
                            return str.toLowerCase();
                        }
                    }
                    an.c("MAC interface: %s", ap.a(context, "wifi.interface"));
                    context = NetworkInterface.getByName(context);
                    if (context == null) {
                        context = NetworkInterface.getByName("wlan0");
                    }
                    if (context == null) {
                        context = NetworkInterface.getByName("eth0");
                    }
                    if (context != null) {
                        str = ap.e(context.getHardwareAddress());
                    }
                    str = macAddress;
                }
            }
        } catch (Throwable th2) {
            context = th2;
            if (an.a(context)) {
                context.printStackTrace();
            }
            if (str == null) {
                str = "null";
            }
            an.c("MAC address: %s", str);
            return str.toLowerCase();
        }
        if (str == null) {
            str = "null";
        }
        an.c("MAC address: %s", str);
        return str.toLowerCase();
    }

    public static java.lang.String e(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "fail";
        if (r2 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r1 = "phone";	 Catch:{ Throwable -> 0x001c }
        r2 = r2.getSystemService(r1);	 Catch:{ Throwable -> 0x001c }
        r2 = (android.telephony.TelephonyManager) r2;	 Catch:{ Throwable -> 0x001c }
        if (r2 == 0) goto L_0x0024;	 Catch:{ Throwable -> 0x001c }
    L_0x000f:
        r2 = r2.getSimSerialNumber();	 Catch:{ Throwable -> 0x001c }
        if (r2 != 0) goto L_0x001a;
    L_0x0015:
        r0 = "null";	 Catch:{ Throwable -> 0x0018 }
        goto L_0x0024;
    L_0x0018:
        r0 = r2;
        goto L_0x001c;
    L_0x001a:
        r0 = r2;
        goto L_0x0024;
    L_0x001c:
        r2 = "Failed to get SIM serial number.";
        r1 = 0;
        r1 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.an.a(r2, r1);
    L_0x0024:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.e(android.content.Context):java.lang.String");
    }

    public static java.lang.String d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Build.SERIAL;	 Catch:{ Throwable -> 0x0003 }
        return r0;
    L_0x0003:
        r0 = "Failed to get hardware serial number.";
        r1 = 0;
        r1 = new java.lang.Object[r1];
        com.tencent.bugly.proguard.an.a(r0, r1);
        r0 = "fail";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.d():java.lang.String");
    }

    public static boolean e() {
        try {
            if (Environment.getExternalStorageState().equals("mounted")) {
                return true;
            }
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String o() {
        /*
        r0 = "/system/build.prop";
        r1 = 0;
        r2 = new java.io.FileReader;	 Catch:{ Throwable -> 0x0072, all -> 0x006d }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x0072, all -> 0x006d }
        r0 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x006a, all -> 0x0065 }
        r3 = 2048; // 0x800 float:2.87E-42 double:1.0118E-320;
        r0.<init>(r2, r3);	 Catch:{ Throwable -> 0x006a, all -> 0x0065 }
    L_0x000f:
        r3 = r0.readLine();	 Catch:{ Throwable -> 0x0063 }
        r4 = 0;
        if (r3 == 0) goto L_0x003b;
    L_0x0016:
        r5 = "=";
        r6 = 2;
        r3 = r3.split(r5, r6);	 Catch:{ Throwable -> 0x0063 }
        r5 = r3.length;	 Catch:{ Throwable -> 0x0063 }
        if (r5 != r6) goto L_0x000f;
    L_0x0020:
        r5 = r3[r4];	 Catch:{ Throwable -> 0x0063 }
        r6 = "ro.product.cpu.abilist";
        r5 = r5.equals(r6);	 Catch:{ Throwable -> 0x0063 }
        r6 = 1;
        if (r5 == 0) goto L_0x002e;
    L_0x002b:
        r3 = r3[r6];	 Catch:{ Throwable -> 0x0063 }
        goto L_0x003c;
    L_0x002e:
        r5 = r3[r4];	 Catch:{ Throwable -> 0x0063 }
        r7 = "ro.product.cpu.abi";
        r5 = r5.equals(r7);	 Catch:{ Throwable -> 0x0063 }
        if (r5 == 0) goto L_0x000f;
    L_0x0038:
        r3 = r3[r6];	 Catch:{ Throwable -> 0x0063 }
        goto L_0x003c;
    L_0x003b:
        r3 = r1;
    L_0x003c:
        if (r3 == 0) goto L_0x0046;
    L_0x003e:
        r5 = ",";
        r3 = r3.split(r5);	 Catch:{ Throwable -> 0x0063 }
        r3 = r3[r4];	 Catch:{ Throwable -> 0x0063 }
    L_0x0046:
        r0.close();	 Catch:{ IOException -> 0x004a }
        goto L_0x0054;
    L_0x004a:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.an.a(r0);
        if (r1 != 0) goto L_0x0054;
    L_0x0051:
        r0.printStackTrace();
    L_0x0054:
        r2.close();	 Catch:{ IOException -> 0x0058 }
        goto L_0x0062;
    L_0x0058:
        r0 = move-exception;
        r1 = com.tencent.bugly.proguard.an.a(r0);
        if (r1 != 0) goto L_0x0062;
    L_0x005f:
        r0.printStackTrace();
    L_0x0062:
        return r3;
    L_0x0063:
        r3 = move-exception;
        goto L_0x0075;
    L_0x0065:
        r0 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x00a0;
    L_0x006a:
        r3 = move-exception;
        r0 = r1;
        goto L_0x0075;
    L_0x006d:
        r0 = move-exception;
        r2 = r1;
        r1 = r0;
        r0 = r2;
        goto L_0x00a0;
    L_0x0072:
        r3 = move-exception;
        r0 = r1;
        r2 = r0;
    L_0x0075:
        r4 = com.tencent.bugly.proguard.an.a(r3);	 Catch:{ all -> 0x009f }
        if (r4 != 0) goto L_0x007e;
    L_0x007b:
        r3.printStackTrace();	 Catch:{ all -> 0x009f }
    L_0x007e:
        if (r0 == 0) goto L_0x008e;
    L_0x0080:
        r0.close();	 Catch:{ IOException -> 0x0084 }
        goto L_0x008e;
    L_0x0084:
        r0 = move-exception;
        r3 = com.tencent.bugly.proguard.an.a(r0);
        if (r3 != 0) goto L_0x008e;
    L_0x008b:
        r0.printStackTrace();
    L_0x008e:
        if (r2 == 0) goto L_0x009e;
    L_0x0090:
        r2.close();	 Catch:{ IOException -> 0x0094 }
        goto L_0x009e;
    L_0x0094:
        r0 = move-exception;
        r2 = com.tencent.bugly.proguard.an.a(r0);
        if (r2 != 0) goto L_0x009e;
    L_0x009b:
        r0.printStackTrace();
    L_0x009e:
        return r1;
    L_0x009f:
        r1 = move-exception;
    L_0x00a0:
        if (r0 == 0) goto L_0x00b0;
    L_0x00a2:
        r0.close();	 Catch:{ IOException -> 0x00a6 }
        goto L_0x00b0;
    L_0x00a6:
        r0 = move-exception;
        r3 = com.tencent.bugly.proguard.an.a(r0);
        if (r3 != 0) goto L_0x00b0;
    L_0x00ad:
        r0.printStackTrace();
    L_0x00b0:
        if (r2 == 0) goto L_0x00c0;
    L_0x00b2:
        r2.close();	 Catch:{ IOException -> 0x00b6 }
        goto L_0x00c0;
    L_0x00b6:
        r0 = move-exception;
        r2 = com.tencent.bugly.proguard.an.a(r0);
        if (r2 != 0) goto L_0x00c0;
    L_0x00bd:
        r0.printStackTrace();
    L_0x00c0:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.o():java.lang.String");
    }

    public static String a(boolean z) {
        String str = null;
        if (z) {
            try {
                str = o();
            } catch (boolean z2) {
                if (!an.a(z2)) {
                    z2.printStackTrace();
                }
                return "fail";
            }
        }
        if (str == null) {
            str = System.getProperty("os.arch");
        }
        return str;
    }

    public static long f() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    public static long g() {
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return -1;
        }
    }

    public static long h() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        Throwable th;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e) {
                            if (!an.a(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (Throwable e2) {
                            if (!an.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        return -1;
                    }
                    long parseLong = Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024;
                    try {
                        bufferedReader.close();
                    } catch (Throwable e22) {
                        if (!an.a(e22)) {
                            e22.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (Throwable e222) {
                        if (!an.a(e222)) {
                            e222.printStackTrace();
                        }
                    }
                    return parseLong;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!an.a(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable e2222) {
                                if (!an.a(e2222)) {
                                    e2222.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable e22222) {
                                if (!an.a(e22222)) {
                                    e22222.printStackTrace();
                                }
                            }
                        }
                        return -2;
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable e222222) {
                                if (!an.a(e222222)) {
                                    e222222.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable e2222222) {
                                if (!an.a(e2222222)) {
                                    e2222222.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable e22222222) {
                th = e22222222;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw th;
            }
        } catch (Throwable e222222222) {
            fileReader = null;
            th = e222222222;
            bufferedReader = fileReader;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
            throw th;
        }
    }

    public static long i() {
        FileReader fileReader;
        Throwable th;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader("/proc/meminfo");
            try {
                bufferedReader = new BufferedReader(fileReader, 2048);
                try {
                    bufferedReader.readLine();
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e) {
                            if (!an.a(e)) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (Throwable e2) {
                            if (!an.a(e2)) {
                                e2.printStackTrace();
                            }
                        }
                        return -1;
                    }
                    long parseLong = 0 + (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e22) {
                            if (!an.a(e22)) {
                                e22.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (Throwable e222) {
                            if (!an.a(e222)) {
                                e222.printStackTrace();
                            }
                        }
                        return -1;
                    }
                    long parseLong2 = parseLong + (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
                    readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable e2222) {
                            if (!an.a(e2222)) {
                                e2222.printStackTrace();
                            }
                        }
                        try {
                            fileReader.close();
                        } catch (Throwable e22222) {
                            if (!an.a(e22222)) {
                                e22222.printStackTrace();
                            }
                        }
                        return -1;
                    }
                    long parseLong3 = parseLong2 + (Long.parseLong(readLine.split(":\\s+", 2)[1].toLowerCase().replace("kb", "").trim()) * 1024);
                    try {
                        bufferedReader.close();
                    } catch (Throwable e222222) {
                        if (!an.a(e222222)) {
                            e222222.printStackTrace();
                        }
                    }
                    try {
                        fileReader.close();
                    } catch (Throwable e2222222) {
                        if (!an.a(e2222222)) {
                            e2222222.printStackTrace();
                        }
                    }
                    return parseLong3;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        if (!an.a(th)) {
                            th.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable e22222222) {
                                if (!an.a(e22222222)) {
                                    e22222222.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable e222222222) {
                                if (!an.a(e222222222)) {
                                    e222222222.printStackTrace();
                                }
                            }
                        }
                        return -2;
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Throwable e2222222222) {
                                if (!an.a(e2222222222)) {
                                    e2222222222.printStackTrace();
                                }
                            }
                        }
                        if (fileReader != null) {
                            try {
                                fileReader.close();
                            } catch (Throwable e22222222222) {
                                if (!an.a(e22222222222)) {
                                    e22222222222.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable e222222222222) {
                th = e222222222222;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw th;
            }
        } catch (Throwable e2222222222222) {
            fileReader = null;
            th = e2222222222222;
            bufferedReader = fileReader;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
            throw th;
        }
    }

    public static long j() {
        if (!e()) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return -2;
        }
    }

    public static long k() {
        if (!e()) {
            return 0;
        }
        try {
            StatFs statFs = new StatFs(Environment.getExternalStorageDirectory().getPath());
            return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Throwable th) {
            if (!an.a(th)) {
                th.printStackTrace();
            }
            return -2;
        }
    }

    public static String l() {
        String str = "fail";
        try {
            return Locale.getDefault().getCountry();
        } catch (Throwable th) {
            if (an.a(th)) {
                return str;
            }
            th.printStackTrace();
            return str;
        }
    }

    public static String m() {
        String str = "fail";
        try {
            return Build.BRAND;
        } catch (Throwable th) {
            if (an.a(th)) {
                return str;
            }
            th.printStackTrace();
            return str;
        }
    }

    public static String f(Context context) {
        String str = "unknown";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getType() == 1) {
                context = "WIFI";
            } else {
                if (activeNetworkInfo.getType() == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        context = telephonyManager.getNetworkType();
                        switch (context) {
                            case 1:
                                context = "GPRS";
                                break;
                            case 2:
                                context = "EDGE";
                                break;
                            case 3:
                                context = "UMTS";
                                break;
                            case 4:
                                context = "CDMA";
                                break;
                            case 5:
                                context = "EVDO_0";
                                break;
                            case 6:
                                context = "EVDO_A";
                                break;
                            case 7:
                                context = "1xRTT";
                                break;
                            case 8:
                                context = "HSDPA";
                                break;
                            case 9:
                                context = "HSUPA";
                                break;
                            case 10:
                                context = "HSPA";
                                break;
                            case 11:
                                context = "iDen";
                                break;
                            case 12:
                                context = "EVDO_B";
                                break;
                            case 13:
                                context = "LTE";
                                break;
                            case 14:
                                context = "eHRPD";
                                break;
                            case 15:
                                context = "HSPA+";
                                break;
                            default:
                                StringBuilder stringBuilder = new StringBuilder("MOBILE(");
                                stringBuilder.append(context);
                                stringBuilder.append(k.t);
                                str = stringBuilder.toString();
                                break;
                        }
                    }
                }
                context = str;
            }
            return context;
        } catch (Context context2) {
            if (!an.a(context2)) {
                context2.printStackTrace();
            }
        }
    }

    public static String g(Context context) {
        String a = ap.a(context, "ro.miui.ui.version.name");
        if (ap.a(a) || a.equals("fail")) {
            a = ap.a(context, "ro.build.version.emui");
            if (ap.a(a) || a.equals("fail")) {
                a = ap.a(context, "ro.lenovo.series");
                StringBuilder stringBuilder;
                if (ap.a(a) || a.equals("fail")) {
                    a = ap.a(context, "ro.build.nubia.rom.name");
                    StringBuilder stringBuilder2;
                    if (ap.a(a) || a.equals("fail")) {
                        a = ap.a(context, "ro.meizu.product.model");
                        if (ap.a(a) || a.equals("fail")) {
                            a = ap.a(context, "ro.build.version.opporom");
                            if (ap.a(a) || a.equals("fail")) {
                                a = ap.a(context, "ro.vivo.os.build.display.id");
                                if (ap.a(a) || a.equals("fail")) {
                                    a = ap.a(context, "ro.aa.romver");
                                    if (ap.a(a) || a.equals("fail")) {
                                        a = ap.a(context, "ro.lewa.version");
                                        if (ap.a(a) || a.equals("fail")) {
                                            a = ap.a(context, "ro.gn.gnromvernumber");
                                            if (ap.a(a) || a.equals("fail")) {
                                                a = ap.a(context, "ro.build.tyd.kbstyle_version");
                                                if (ap.a(a) || a.equals("fail")) {
                                                    stringBuilder = new StringBuilder();
                                                    stringBuilder.append(ap.a(context, "ro.build.fingerprint"));
                                                    stringBuilder.append("/");
                                                    stringBuilder.append(ap.a(context, "ro.build.rom.id"));
                                                    return stringBuilder.toString();
                                                }
                                                context = new StringBuilder("dido/");
                                                context.append(a);
                                                return context.toString();
                                            }
                                            stringBuilder2 = new StringBuilder("amigo/");
                                            stringBuilder2.append(a);
                                            stringBuilder2.append("/");
                                            stringBuilder2.append(ap.a(context, "ro.build.display.id"));
                                            return stringBuilder2.toString();
                                        }
                                        stringBuilder2 = new StringBuilder("tcl/");
                                        stringBuilder2.append(a);
                                        stringBuilder2.append("/");
                                        stringBuilder2.append(ap.a(context, "ro.build.display.id"));
                                        return stringBuilder2.toString();
                                    }
                                    stringBuilder2 = new StringBuilder("htc/");
                                    stringBuilder2.append(a);
                                    stringBuilder2.append("/");
                                    stringBuilder2.append(ap.a(context, "ro.build.description"));
                                    return stringBuilder2.toString();
                                }
                                context = new StringBuilder("vivo/FUNTOUCH/");
                                context.append(a);
                                return context.toString();
                            }
                            context = new StringBuilder("Oppo/COLOROS/");
                            context.append(a);
                            return context.toString();
                        }
                        stringBuilder = new StringBuilder("Meizu/FLYME/");
                        stringBuilder.append(ap.a(context, "ro.build.display.id"));
                        return stringBuilder.toString();
                    }
                    stringBuilder2 = new StringBuilder("Zte/NUBIA/");
                    stringBuilder2.append(a);
                    stringBuilder2.append("_");
                    stringBuilder2.append(ap.a(context, "ro.build.nubia.rom.code"));
                    return stringBuilder2.toString();
                }
                context = ap.a(context, "ro.build.version.incremental");
                stringBuilder = new StringBuilder("Lenovo/VIBE/");
                stringBuilder.append(context);
                return stringBuilder.toString();
            }
            context = new StringBuilder("HuaWei/EMOTION/");
            context.append(a);
            return context.toString();
        }
        context = new StringBuilder("XiaoMi/MIUI/");
        context.append(a);
        return context.toString();
    }

    public static String h(Context context) {
        return ap.a(context, "ro.board.platform");
    }

    public static boolean i(Context context) {
        boolean exists;
        try {
            exists = new File("/system/app/Superuser.apk").exists();
        } catch (Throwable th) {
            if (!an.b(th)) {
                th.printStackTrace();
            }
            exists = false;
        }
        Boolean bool = null;
        context = ap.a(context, new String[]{"/system/bin/sh", "-c", "type su"});
        if (context != null && context.size() > 0) {
            context = context.iterator();
            while (context.hasNext()) {
                String str = (String) context.next();
                an.c(str, new Object[0]);
                if (str.contains("not found")) {
                    bool = Boolean.valueOf(false);
                }
            }
            if (bool == null) {
                bool = Boolean.valueOf(true);
            }
        }
        if (bool == null) {
            context = null;
        } else {
            context = bool.booleanValue();
        }
        context = Boolean.valueOf(context);
        boolean z = Build.TAGS != null && Build.TAGS.contains("test-keys");
        if (z || r1 || context.booleanValue() != null) {
            return true;
        }
        return false;
    }

    public static java.lang.String n() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r1.<init>();	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r2 = new java.io.File;	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r3 = "/sys/block/mmcblk0/device/type";	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r2 = r2.exists();	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        if (r2 == 0) goto L_0x002c;	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
    L_0x0013:
        r2 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r3 = new java.io.FileReader;	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r4 = "/sys/block/mmcblk0/device/type";	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00a5, all -> 0x0097 }
        r3 = r2.readLine();	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        if (r3 == 0) goto L_0x0028;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
    L_0x0025:
        r1.append(r3);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
    L_0x0028:
        r2.close();	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        goto L_0x002d;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
    L_0x002c:
        r2 = r0;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
    L_0x002d:
        r3 = ",";	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r1.append(r3);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r4 = "/sys/block/mmcblk0/device/name";	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3 = r3.exists();	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        if (r3 == 0) goto L_0x005e;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
    L_0x003f:
        r3 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r4 = new java.io.FileReader;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r5 = "/sys/block/mmcblk0/device/name";	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r2 = r3.readLine();	 Catch:{ Throwable -> 0x005c, all -> 0x0059 }
        if (r2 == 0) goto L_0x0054;	 Catch:{ Throwable -> 0x005c, all -> 0x0059 }
    L_0x0051:
        r1.append(r2);	 Catch:{ Throwable -> 0x005c, all -> 0x0059 }
    L_0x0054:
        r3.close();	 Catch:{ Throwable -> 0x005c, all -> 0x0059 }
        r2 = r3;
        goto L_0x005e;
    L_0x0059:
        r0 = move-exception;
        r2 = r3;
        goto L_0x009a;
    L_0x005c:
        r2 = r3;
        goto L_0x00a6;
    L_0x005e:
        r3 = ",";	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r1.append(r3);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3 = new java.io.File;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r4 = "/sys/block/mmcblk0/device/cid";	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3 = r3.exists();	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        if (r3 == 0) goto L_0x0086;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
    L_0x0070:
        r3 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r4 = new java.io.FileReader;	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r5 = "/sys/block/mmcblk0/device/cid";	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        r2 = r3.readLine();	 Catch:{ Throwable -> 0x005c, all -> 0x0059 }
        if (r2 == 0) goto L_0x0085;	 Catch:{ Throwable -> 0x005c, all -> 0x0059 }
    L_0x0082:
        r1.append(r2);	 Catch:{ Throwable -> 0x005c, all -> 0x0059 }
    L_0x0085:
        r2 = r3;
    L_0x0086:
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00a6, all -> 0x0095 }
        if (r2 == 0) goto L_0x0094;
    L_0x008c:
        r2.close();	 Catch:{ IOException -> 0x0090 }
        goto L_0x0094;
    L_0x0090:
        r0 = move-exception;
        com.tencent.bugly.proguard.an.a(r0);
    L_0x0094:
        return r1;
    L_0x0095:
        r0 = move-exception;
        goto L_0x009a;
    L_0x0097:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x009a:
        if (r2 == 0) goto L_0x00a4;
    L_0x009c:
        r2.close();	 Catch:{ IOException -> 0x00a0 }
        goto L_0x00a4;
    L_0x00a0:
        r1 = move-exception;
        com.tencent.bugly.proguard.an.a(r1);
    L_0x00a4:
        throw r0;
    L_0x00a5:
        r2 = r0;
    L_0x00a6:
        if (r2 == 0) goto L_0x00b0;
    L_0x00a8:
        r2.close();	 Catch:{ IOException -> 0x00ac }
        goto L_0x00b0;
    L_0x00ac:
        r1 = move-exception;
        com.tencent.bugly.proguard.an.a(r1);
    L_0x00b0:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.n():java.lang.String");
    }

    public static String j(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        String a = ap.a(context, "ro.genymotion.version");
        if (a != null) {
            stringBuilder.append("ro.genymotion.version");
            stringBuilder.append("|");
            stringBuilder.append(a);
            stringBuilder.append("\n");
        }
        a = ap.a(context, "androVM.vbox_dpi");
        if (a != null) {
            stringBuilder.append("androVM.vbox_dpi");
            stringBuilder.append("|");
            stringBuilder.append(a);
            stringBuilder.append("\n");
        }
        context = ap.a(context, "qemu.sf.fake_camera");
        if (context != null) {
            stringBuilder.append("qemu.sf.fake_camera");
            stringBuilder.append("|");
            stringBuilder.append(context);
        }
        return stringBuilder.toString();
    }

    public static String k(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        if (a == null) {
            a = ap.a(context, "ro.secure");
        }
        if (a != null) {
            stringBuilder.append("ro.secure");
            stringBuilder.append("|");
            stringBuilder.append(a);
            stringBuilder.append("\n");
        }
        if (b == null) {
            b = ap.a(context, "ro.debuggable");
        }
        if (b != null) {
            stringBuilder.append("ro.debuggable");
            stringBuilder.append("|");
            stringBuilder.append(b);
            stringBuilder.append("\n");
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
            do {
                try {
                    context = bufferedReader.readLine();
                    if (context == null) {
                        break;
                    }
                } catch (Throwable th) {
                    context = th;
                }
            } while (!context.startsWith("TracerPid:"));
            if (context != null) {
                context = context.substring(10).trim();
                stringBuilder.append("tracer_pid");
                stringBuilder.append("|");
                stringBuilder.append(context);
            }
            context = stringBuilder.toString();
            try {
                bufferedReader.close();
            } catch (Throwable e) {
                an.a(e);
            }
            return context;
        } catch (Throwable e2) {
            bufferedReader = null;
            context = e2;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw context;
        }
    }

    public static java.lang.String l(android.content.Context r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2 = "/sys/class/power_supply/ac/online";	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1 = r1.exists();	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        if (r1 == 0) goto L_0x003e;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
    L_0x0013:
        r1 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2 = new java.io.FileReader;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r3 = "/sys/class/power_supply/ac/online";	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r0 = r1.readLine();	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        if (r0 == 0) goto L_0x0032;	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
    L_0x0025:
        r2 = "ac_online";	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r4.append(r2);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r2 = "|";	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r4.append(r2);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r4.append(r0);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
    L_0x0032:
        r1.close();	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r0 = r1;
        goto L_0x003e;
    L_0x0037:
        r4 = move-exception;
        r0 = r1;
        goto L_0x00af;
    L_0x003b:
        r0 = r1;
        goto L_0x00ba;
    L_0x003e:
        r1 = "\n";	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r4.append(r1);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2 = "/sys/class/power_supply/usb/online";	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1 = r1.exists();	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        if (r1 == 0) goto L_0x0073;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
    L_0x0050:
        r1 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2 = new java.io.FileReader;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r3 = "/sys/class/power_supply/usb/online";	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r0 = r1.readLine();	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        if (r0 == 0) goto L_0x006f;	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
    L_0x0062:
        r2 = "usb_online";	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r4.append(r2);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r2 = "|";	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r4.append(r2);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r4.append(r0);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
    L_0x006f:
        r1.close();	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r0 = r1;
    L_0x0073:
        r1 = "\n";	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r4.append(r1);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2 = "/sys/class/power_supply/battery/capacity";	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1 = r1.exists();	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        if (r1 == 0) goto L_0x00a8;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
    L_0x0085:
        r1 = new java.io.BufferedReader;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2 = new java.io.FileReader;	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r3 = "/sys/class/power_supply/battery/capacity";	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00ba, all -> 0x00ae }
        r0 = r1.readLine();	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        if (r0 == 0) goto L_0x00a4;	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
    L_0x0097:
        r2 = "battery_capacity";	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r4.append(r2);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r2 = "|";	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r4.append(r2);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r4.append(r0);	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
    L_0x00a4:
        r1.close();	 Catch:{ Throwable -> 0x003b, all -> 0x0037 }
        r0 = r1;
    L_0x00a8:
        if (r0 == 0) goto L_0x00c4;
    L_0x00aa:
        r0.close();	 Catch:{ IOException -> 0x00c0 }
        goto L_0x00c4;
    L_0x00ae:
        r4 = move-exception;
    L_0x00af:
        if (r0 == 0) goto L_0x00b9;
    L_0x00b1:
        r0.close();	 Catch:{ IOException -> 0x00b5 }
        goto L_0x00b9;
    L_0x00b5:
        r0 = move-exception;
        com.tencent.bugly.proguard.an.a(r0);
    L_0x00b9:
        throw r4;
    L_0x00ba:
        if (r0 == 0) goto L_0x00c4;
    L_0x00bc:
        r0.close();	 Catch:{ IOException -> 0x00c0 }
        goto L_0x00c4;
    L_0x00c0:
        r0 = move-exception;
        com.tencent.bugly.proguard.an.a(r0);
    L_0x00c4:
        r4 = r4.toString();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.common.info.b.l(android.content.Context):java.lang.String");
    }

    public static String m(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        String a = ap.a(context, "gsm.sim.state");
        if (a != null) {
            stringBuilder.append("gsm.sim.state");
            stringBuilder.append("|");
            stringBuilder.append(a);
        }
        stringBuilder.append("\n");
        context = ap.a(context, "gsm.sim.state2");
        if (context != null) {
            stringBuilder.append("gsm.sim.state2");
            stringBuilder.append("|");
            stringBuilder.append(context);
        }
        return stringBuilder.toString();
    }

    public static long n(Context context) {
        BufferedReader bufferedReader;
        Throwable th;
        context = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/uptime"));
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    context = ((float) (System.currentTimeMillis() / 1000)) - Float.parseFloat(readLine.split(" ")[0]);
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    an.a(th);
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    return (long) context;
                } catch (Throwable th3) {
                    context = th3;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Throwable th4) {
                            an.a(th4);
                        }
                    }
                    throw context;
                }
            }
            try {
                bufferedReader.close();
            } catch (Throwable th42) {
                an.a(th42);
            }
        } catch (Throwable th5) {
            context = th5;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw context;
        }
        return (long) context;
    }
}
