package com.tencent.wxop.stat.common;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Environment;
import android.os.StatFs;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.StatSpecifyReportedInfo;
import com.umeng.message.MsgConstant;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.http.HttpHost;

public class l {
    private static String a = null;
    private static String b = null;
    private static String c = null;
    private static String d = null;
    private static Random e = null;
    private static DisplayMetrics f = null;
    private static String g = null;
    private static String h = "";
    private static String i = "";
    private static int j = -1;
    private static StatLogger k = null;
    private static String l = null;
    private static String m = null;
    private static volatile int n = -1;
    private static String o = null;
    private static String p = null;
    private static long q = -1;
    private static String r = "";
    private static o s = null;
    private static String t = "__MTA_FIRST_ACTIVATE__";
    private static int u = -1;
    private static long v = -1;
    private static int w = 0;
    private static String x = "";

    public static String A(Context context) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
        return (resolveActivity.activityInfo == null || resolveActivity.activityInfo.packageName.equals(DispatchConstants.ANDROID)) ? null : resolveActivity.activityInfo.packageName;
    }

    private static long B(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo.availMem;
    }

    public static int a() {
        return g().nextInt(Integer.MAX_VALUE);
    }

    public static int a(Context context, boolean z) {
        if (z) {
            w = y(context);
        }
        return w;
    }

    public static java.lang.Long a(java.lang.String r8, java.lang.String r9, int r10, int r11, java.lang.Long r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r8 == 0) goto L_0x004e;
    L_0x0002:
        if (r9 != 0) goto L_0x0005;
    L_0x0004:
        return r12;
    L_0x0005:
        r0 = ".";
        r0 = r9.equalsIgnoreCase(r0);
        if (r0 != 0) goto L_0x0015;
    L_0x000d:
        r0 = "|";
        r0 = r9.equalsIgnoreCase(r0);
        if (r0 == 0) goto L_0x0023;
    L_0x0015:
        r0 = new java.lang.StringBuilder;
        r1 = "\\";
        r0.<init>(r1);
        r0.append(r9);
        r9 = r0.toString();
    L_0x0023:
        r8 = r8.split(r9);
        r9 = r8.length;
        if (r9 != r11) goto L_0x004e;
    L_0x002a:
        r0 = 0;
        r9 = java.lang.Long.valueOf(r0);	 Catch:{ NumberFormatException -> 0x004e }
        r11 = 0;	 Catch:{ NumberFormatException -> 0x004e }
    L_0x0031:
        r0 = r8.length;	 Catch:{ NumberFormatException -> 0x004e }
        if (r11 >= r0) goto L_0x004d;	 Catch:{ NumberFormatException -> 0x004e }
    L_0x0034:
        r0 = (long) r10;	 Catch:{ NumberFormatException -> 0x004e }
        r2 = r9.longValue();	 Catch:{ NumberFormatException -> 0x004e }
        r9 = r8[r11];	 Catch:{ NumberFormatException -> 0x004e }
        r9 = java.lang.Long.valueOf(r9);	 Catch:{ NumberFormatException -> 0x004e }
        r4 = r9.longValue();	 Catch:{ NumberFormatException -> 0x004e }
        r6 = r2 + r4;	 Catch:{ NumberFormatException -> 0x004e }
        r0 = r0 * r6;	 Catch:{ NumberFormatException -> 0x004e }
        r9 = java.lang.Long.valueOf(r0);	 Catch:{ NumberFormatException -> 0x004e }
        r11 = r11 + 1;
        goto L_0x0031;
    L_0x004d:
        return r9;
    L_0x004e:
        return r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.l.a(java.lang.String, java.lang.String, int, int, java.lang.Long):java.lang.Long");
    }

    public static String a(int i) {
        Calendar instance = Calendar.getInstance();
        instance.roll(6, i);
        return new SimpleDateFormat("yyyyMMdd").format(instance.getTime());
    }

    public static String a(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    public static String a(Context context, String str) {
        if (StatConfig.isEnableConcurrentProcess()) {
            if (m == null) {
                m = o(context);
            }
            if (m != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append("_");
                stringBuilder.append(m);
                return stringBuilder.toString();
            }
        }
        return str;
    }

    public static java.lang.String a(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r4 != 0) goto L_0x0005;
    L_0x0002:
        r4 = "0";
        return r4;
    L_0x0005:
        r0 = "MD5";	 Catch:{ Throwable -> 0x003c }
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ Throwable -> 0x003c }
        r4 = r4.getBytes();	 Catch:{ Throwable -> 0x003c }
        r0.update(r4);	 Catch:{ Throwable -> 0x003c }
        r4 = r0.digest();	 Catch:{ Throwable -> 0x003c }
        r0 = new java.lang.StringBuffer;	 Catch:{ Throwable -> 0x003c }
        r0.<init>();	 Catch:{ Throwable -> 0x003c }
        r1 = 0;	 Catch:{ Throwable -> 0x003c }
    L_0x001c:
        r2 = r4.length;	 Catch:{ Throwable -> 0x003c }
        if (r1 >= r2) goto L_0x0037;	 Catch:{ Throwable -> 0x003c }
    L_0x001f:
        r2 = 255; // 0xff float:3.57E-43 double:1.26E-321;	 Catch:{ Throwable -> 0x003c }
        r3 = r4[r1];	 Catch:{ Throwable -> 0x003c }
        r2 = r2 & r3;	 Catch:{ Throwable -> 0x003c }
        r3 = 16;	 Catch:{ Throwable -> 0x003c }
        if (r2 >= r3) goto L_0x002d;	 Catch:{ Throwable -> 0x003c }
    L_0x0028:
        r3 = "0";	 Catch:{ Throwable -> 0x003c }
        r0.append(r3);	 Catch:{ Throwable -> 0x003c }
    L_0x002d:
        r2 = java.lang.Integer.toHexString(r2);	 Catch:{ Throwable -> 0x003c }
        r0.append(r2);	 Catch:{ Throwable -> 0x003c }
        r1 = r1 + 1;	 Catch:{ Throwable -> 0x003c }
        goto L_0x001c;	 Catch:{ Throwable -> 0x003c }
    L_0x0037:
        r4 = r0.toString();	 Catch:{ Throwable -> 0x003c }
        return r4;
    L_0x003c:
        r4 = "0";
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.l.a(java.lang.String):java.lang.String");
    }

    public static HttpHost a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            if (context.getPackageManager().checkPermission(MsgConstant.PERMISSION_ACCESS_NETWORK_STATE, context.getPackageName()) != 0) {
                return null;
            }
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return null;
            }
            if (activeNetworkInfo.getTypeName() != null && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) {
                return null;
            }
            String extraInfo = activeNetworkInfo.getExtraInfo();
            if (extraInfo == null) {
                return null;
            }
            if (!(extraInfo.equals("cmwap") || extraInfo.equals("3gwap"))) {
                if (!extraInfo.equals("uniwap")) {
                    if (extraInfo.equals("ctwap")) {
                        return new HttpHost("10.0.0.200", 80);
                    }
                    extraInfo = Proxy.getDefaultHost();
                    if (extraInfo != null && extraInfo.trim().length() > 0) {
                        return new HttpHost(extraInfo, Proxy.getDefaultPort());
                    }
                    return null;
                }
            }
            return new HttpHost("10.0.0.172", 80);
        } catch (Throwable th) {
            k.e(th);
        }
    }

    public static void a(Context context, int i) {
        w = i;
        q.b(context, "mta.qq.com.difftime", i);
    }

    public static boolean a(StatSpecifyReportedInfo statSpecifyReportedInfo) {
        return statSpecifyReportedInfo == null ? false : c(statSpecifyReportedInfo.getAppKey());
    }

    public static byte[] a(byte[] bArr) {
        InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayInputStream.close();
                gZIPInputStream.close();
                byteArrayOutputStream.close();
                return bArr;
            }
        }
    }

    public static long b(String str) {
        return a(str, ".", 100, 3, Long.valueOf(0)).longValue();
    }

    public static synchronized StatLogger b() {
        StatLogger statLogger;
        synchronized (l.class) {
            if (k == null) {
                statLogger = new StatLogger(StatConstants.LOG_TAG);
                k = statLogger;
                statLogger.setDebugEnable(false);
            }
            statLogger = k;
        }
        return statLogger;
    }

    public static synchronized String b(Context context) {
        synchronized (l.class) {
            String a;
            if (a == null || a.trim().length() == 0) {
                a = r.a(context);
                a = a;
                if (a == null || a.trim().length() == 0) {
                    a = Integer.toString(g().nextInt(Integer.MAX_VALUE));
                }
                a = a;
                return a;
            }
            a = a;
            return a;
        }
    }

    public static long c() {
        try {
            Calendar instance = Calendar.getInstance();
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            return 86400000 + instance.getTimeInMillis();
        } catch (Throwable th) {
            k.e(th);
            return 86400000 + System.currentTimeMillis();
        }
    }

    public static synchronized String c(Context context) {
        String str;
        synchronized (l.class) {
            if (c == null || c.trim().length() == 0) {
                c = r.b(context);
            }
            str = c;
        }
        return str;
    }

    public static boolean c(String str) {
        if (str != null) {
            if (str.trim().length() != 0) {
                return true;
            }
        }
        return false;
    }

    public static DisplayMetrics d(Context context) {
        if (f == null) {
            f = new DisplayMetrics();
            ((WindowManager) context.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(f);
        }
        return f;
    }

    public static String d() {
        if (c(p)) {
            return p;
        }
        long e = e() / 1000000;
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = (((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks())) / 1000000;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.valueOf(blockSize));
        stringBuilder.append("/");
        stringBuilder.append(String.valueOf(e));
        String stringBuilder2 = stringBuilder.toString();
        p = stringBuilder2;
        return stringBuilder2;
    }

    public static long e() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
    }

    public static boolean e(Context context) {
        try {
            if (r.a(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE)) {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
                if (connectivityManager != null) {
                    NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
                    if (allNetworkInfo != null) {
                        int i = 0;
                        while (i < allNetworkInfo.length) {
                            if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                                return true;
                            }
                            i++;
                        }
                    }
                }
                return false;
            }
            k.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        } catch (Throwable th) {
            k.e(th);
            return false;
        }
    }

    public static String f(Context context) {
        return context == null ? null : context.getClass().getName();
    }

    public static String g(Context context) {
        if (g != null) {
            return g;
        }
        try {
            if (!r.a(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                k.e((Object) "Could not get permission of android.permission.READ_PHONE_STATE");
            } else if (i(context)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    g = telephonyManager.getSimOperator();
                }
            }
        } catch (Throwable th) {
            k.e(th);
        }
        return g;
    }

    private static synchronized Random g() {
        Random random;
        synchronized (l.class) {
            if (e == null) {
                e = new Random();
            }
            random = e;
        }
        return random;
    }

    private static long h() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = q;
        r2 = 0;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x000b;
    L_0x0008:
        r0 = q;
        return r0;
    L_0x000b:
        r0 = "/proc/meminfo";
        r1 = 1;
        r3 = new java.io.FileReader;	 Catch:{ Exception -> 0x0036 }
        r3.<init>(r0);	 Catch:{ Exception -> 0x0036 }
        r0 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x0036 }
        r4 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;	 Catch:{ Exception -> 0x0036 }
        r0.<init>(r3, r4);	 Catch:{ Exception -> 0x0036 }
        r3 = r0.readLine();	 Catch:{ Exception -> 0x0036 }
        r4 = "\\s+";	 Catch:{ Exception -> 0x0036 }
        r3 = r3.split(r4);	 Catch:{ Exception -> 0x0036 }
        r4 = 1;	 Catch:{ Exception -> 0x0036 }
        r3 = r3[r4];	 Catch:{ Exception -> 0x0036 }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ Exception -> 0x0036 }
        r3 = r3.intValue();	 Catch:{ Exception -> 0x0036 }
        r3 = r3 * 1024;	 Catch:{ Exception -> 0x0036 }
        r1 = (long) r3;	 Catch:{ Exception -> 0x0036 }
        r0.close();	 Catch:{ Exception -> 0x0036 }
    L_0x0036:
        q = r1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.l.h():long");
    }

    public static String h(Context context) {
        if (c(h)) {
            return h;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            h = str;
            if (str == null) {
                return "";
            }
        } catch (Throwable th) {
            k.e(th);
        }
        return h;
    }

    public static boolean i(Context context) {
        return context.getPackageManager().checkPermission(MsgConstant.PERMISSION_READ_PHONE_STATE, context.getPackageName()) == 0;
    }

    public static String j(Context context) {
        String str = "";
        try {
            if (r.a(context, MsgConstant.PERMISSION_INTERNET) && r.a(context, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE)) {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                    String typeName = activeNetworkInfo.getTypeName();
                    String extraInfo = activeNetworkInfo.getExtraInfo();
                    if (typeName != null) {
                        if (typeName.equalsIgnoreCase("WIFI")) {
                            return "WIFI";
                        }
                        if (typeName.equalsIgnoreCase("MOBILE")) {
                            return extraInfo != null ? extraInfo : "MOBILE";
                        } else {
                            if (extraInfo != null) {
                                return extraInfo;
                            }
                            str = typeName;
                        }
                    }
                }
                return str;
            }
            k.e((Object) "can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return str;
        } catch (Throwable th) {
            k.e(th);
        }
    }

    public static java.lang.Integer k(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "phone";	 Catch:{ Throwable -> 0x0013 }
        r1 = r1.getSystemService(r0);	 Catch:{ Throwable -> 0x0013 }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Throwable -> 0x0013 }
        if (r1 == 0) goto L_0x0013;	 Catch:{ Throwable -> 0x0013 }
    L_0x000a:
        r1 = r1.getNetworkType();	 Catch:{ Throwable -> 0x0013 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x0013 }
        return r1;
    L_0x0013:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.l.k(android.content.Context):java.lang.Integer");
    }

    public static String l(Context context) {
        if (c(i)) {
            return i;
        }
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            i = str;
            if (str == null || i.length() == 0) {
                return "unknown";
            }
        } catch (Throwable th) {
            k.e(th);
        }
        return i;
    }

    public static int m(Context context) {
        if (j != -1) {
            return j;
        }
        try {
            if (p.a()) {
                j = 1;
            }
        } catch (Throwable th) {
            k.e(th);
        }
        j = 0;
        return 0;
    }

    public static String n(Context context) {
        if (c(l)) {
            return l;
        }
        try {
            if (r.a(context, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
                String externalStorageState = Environment.getExternalStorageState();
                if (externalStorageState != null && externalStorageState.equals("mounted")) {
                    externalStorageState = Environment.getExternalStorageDirectory().getPath();
                    if (externalStorageState != null) {
                        StatFs statFs = new StatFs(externalStorageState);
                        long blockCount = (((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize())) / 1000000;
                        long availableBlocks = (((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize())) / 1000000;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(String.valueOf(availableBlocks));
                        stringBuilder.append("/");
                        stringBuilder.append(String.valueOf(blockCount));
                        externalStorageState = stringBuilder.toString();
                        l = externalStorageState;
                        return externalStorageState;
                    }
                }
                return null;
            }
            k.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
            return null;
        } catch (Throwable th) {
            k.e(th);
        }
    }

    static java.lang.String o(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = m;	 Catch:{ Throwable -> 0x002f }
        if (r0 == 0) goto L_0x0007;	 Catch:{ Throwable -> 0x002f }
    L_0x0004:
        r3 = m;	 Catch:{ Throwable -> 0x002f }
        return r3;	 Catch:{ Throwable -> 0x002f }
    L_0x0007:
        r0 = android.os.Process.myPid();	 Catch:{ Throwable -> 0x002f }
        r1 = "activity";	 Catch:{ Throwable -> 0x002f }
        r3 = r3.getSystemService(r1);	 Catch:{ Throwable -> 0x002f }
        r3 = (android.app.ActivityManager) r3;	 Catch:{ Throwable -> 0x002f }
        r3 = r3.getRunningAppProcesses();	 Catch:{ Throwable -> 0x002f }
        r3 = r3.iterator();	 Catch:{ Throwable -> 0x002f }
    L_0x001b:
        r1 = r3.hasNext();	 Catch:{ Throwable -> 0x002f }
        if (r1 == 0) goto L_0x002f;	 Catch:{ Throwable -> 0x002f }
    L_0x0021:
        r1 = r3.next();	 Catch:{ Throwable -> 0x002f }
        r1 = (android.app.ActivityManager.RunningAppProcessInfo) r1;	 Catch:{ Throwable -> 0x002f }
        r2 = r1.pid;	 Catch:{ Throwable -> 0x002f }
        if (r2 != r0) goto L_0x001b;	 Catch:{ Throwable -> 0x002f }
    L_0x002b:
        r3 = r1.processName;	 Catch:{ Throwable -> 0x002f }
        m = r3;	 Catch:{ Throwable -> 0x002f }
    L_0x002f:
        r3 = m;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.l.o(android.content.Context):java.lang.String");
    }

    public static String p(Context context) {
        return a(context, StatConstants.DATABASE_NAME);
    }

    public static synchronized Integer q(Context context) {
        Integer valueOf;
        synchronized (l.class) {
            if (n <= 0) {
                n = q.a(context, "MTA_EVENT_INDEX", 0);
                q.b(context, "MTA_EVENT_INDEX", n + 1000);
            } else if (n % 1000 == 0) {
                try {
                    int i = n + 1000;
                    if (n >= 2147383647) {
                        i = 0;
                    }
                    q.b(context, "MTA_EVENT_INDEX", i);
                } catch (Throwable th) {
                    k.w(th);
                }
            }
            int i2 = n + 1;
            n = i2;
            valueOf = Integer.valueOf(i2);
        }
        return valueOf;
    }

    public static String r(Context context) {
        try {
            long B = B(context) / 1000000;
            long h = h() / 1000000;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(B));
            stringBuilder.append("/");
            stringBuilder.append(String.valueOf(h));
            return stringBuilder.toString();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static org.json.JSONObject s(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = new org.json.JSONObject;
        r3.<init>();
        r0 = "n";	 Catch:{ Throwable -> 0x003a }
        r1 = com.tencent.wxop.stat.common.m.a();	 Catch:{ Throwable -> 0x003a }
        r3.put(r0, r1);	 Catch:{ Throwable -> 0x003a }
        r0 = com.tencent.wxop.stat.common.m.d();	 Catch:{ Throwable -> 0x003a }
        if (r0 == 0) goto L_0x001f;	 Catch:{ Throwable -> 0x003a }
    L_0x0014:
        r1 = r0.length();	 Catch:{ Throwable -> 0x003a }
        if (r1 <= 0) goto L_0x001f;	 Catch:{ Throwable -> 0x003a }
    L_0x001a:
        r1 = "na";	 Catch:{ Throwable -> 0x003a }
        r3.put(r1, r0);	 Catch:{ Throwable -> 0x003a }
    L_0x001f:
        r0 = com.tencent.wxop.stat.common.m.b();	 Catch:{ Throwable -> 0x003a }
        r1 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;	 Catch:{ Throwable -> 0x003a }
        if (r0 <= 0) goto L_0x002e;	 Catch:{ Throwable -> 0x003a }
    L_0x0028:
        r2 = "fx";	 Catch:{ Throwable -> 0x003a }
        r0 = r0 / r1;	 Catch:{ Throwable -> 0x003a }
        r3.put(r2, r0);	 Catch:{ Throwable -> 0x003a }
    L_0x002e:
        r0 = com.tencent.wxop.stat.common.m.c();	 Catch:{ Throwable -> 0x003a }
        if (r0 <= 0) goto L_0x003a;	 Catch:{ Throwable -> 0x003a }
    L_0x0034:
        r2 = "fn";	 Catch:{ Throwable -> 0x003a }
        r0 = r0 / r1;	 Catch:{ Throwable -> 0x003a }
        r3.put(r2, r0);	 Catch:{ Throwable -> 0x003a }
    L_0x003a:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.wxop.stat.common.l.s(android.content.Context):org.json.JSONObject");
    }

    public static String t(Context context) {
        if (c(r)) {
            return r;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager != null) {
                List sensorList = sensorManager.getSensorList(-1);
                if (sensorList != null) {
                    StringBuilder stringBuilder = new StringBuilder(sensorList.size() * 10);
                    for (int i = 0; i < sensorList.size(); i++) {
                        stringBuilder.append(((Sensor) sensorList.get(i)).getType());
                        if (i != sensorList.size() - 1) {
                            stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    r = stringBuilder.toString();
                }
            }
        } catch (Throwable th) {
            k.e(th);
        }
        return r;
    }

    public static synchronized int u(Context context) {
        synchronized (l.class) {
            if (u != -1) {
                int i = u;
                return i;
            }
            v(context);
            i = u;
            return i;
        }
    }

    public static void v(Context context) {
        int a = q.a(context, t, 1);
        u = a;
        if (a == 1) {
            q.b(context, t, 0);
        }
    }

    public static boolean w(Context context) {
        if (v < 0) {
            v = q.a(context, "mta.qq.com.checktime", 0);
        }
        return Math.abs(System.currentTimeMillis() - v) > 86400000;
    }

    public static void x(Context context) {
        v = System.currentTimeMillis();
        q.b(context, "mta.qq.com.checktime", v);
    }

    public static int y(Context context) {
        return q.a(context, "mta.qq.com.difftime", 0);
    }

    public static boolean z(Context context) {
        if (context == null) {
            return false;
        }
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
            if (runningAppProcessInfo.processName.startsWith(packageName)) {
                if (runningAppProcessInfo.importance == 400) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
