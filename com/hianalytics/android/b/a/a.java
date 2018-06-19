package com.hianalytics.android.b.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ta.utdid2.android.utils.NetworkUtils;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.umeng.message.MsgConstant;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DeflaterOutputStream;
import org.android.agoo.common.AgooConstants;

public final class a {
    static final char[] a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static boolean b = true;
    private static Long c = Long.valueOf(30);
    private static Long d = Long.valueOf(TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC);
    private static Long e = Long.valueOf(1000);
    private static Long f = Long.valueOf(1800);
    private static int g = Integer.MAX_VALUE;
    private static HandlerThread h;
    private static HandlerThread i;
    private static Handler j;
    private static Handler k;

    static {
        HandlerThread handlerThread = new HandlerThread("HiAnalytics_messageThread");
        h = handlerThread;
        handlerThread.start();
        handlerThread = new HandlerThread("HiAnalytics_sessionThread");
        i = handlerThread;
        handlerThread.start();
    }

    public static long a(String str) {
        long time;
        try {
            Date parse = new SimpleDateFormat("yyyyMMddHHmmss").parse(str);
            if (parse != null) {
                time = parse.getTime();
                return time / 1000;
            }
        } catch (ParseException e) {
            e.toString();
        }
        time = 0;
        return time / 1000;
    }

    public static Long a() {
        return c;
    }

    public static String a(Context context) {
        String str = "";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("APPKEY");
                if (obj != null) {
                    str = obj.toString();
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
        if (str != null) {
            if (str.trim().length() != 0) {
                return str;
            }
        }
        return context.getPackageName();
    }

    public static void a(int i) {
        g = i;
    }

    public static void a(Long l) {
        c = l;
    }

    public static void a(boolean z) {
        b = z;
    }

    public static byte[] a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        DeflaterOutputStream deflaterOutputStream;
        Exception e;
        Throwable th;
        DeflaterOutputStream deflaterOutputStream2 = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream);
                try {
                    deflaterOutputStream.write(bArr);
                    deflaterOutputStream.close();
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        deflaterOutputStream.close();
                        byteArrayOutputStream.close();
                        return bArr;
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        return bArr;
                    }
                } catch (Exception e3) {
                    e = e3;
                    try {
                        e.printStackTrace();
                        if (deflaterOutputStream != null) {
                            try {
                                deflaterOutputStream.close();
                                byteArrayOutputStream.close();
                                return null;
                            } catch (IOException e4) {
                                e4.printStackTrace();
                                return null;
                            }
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        deflaterOutputStream2 = deflaterOutputStream;
                        if (deflaterOutputStream2 != null) {
                            try {
                                deflaterOutputStream2.close();
                                byteArrayOutputStream.close();
                            } catch (IOException e22) {
                                e22.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                deflaterOutputStream = null;
                e.printStackTrace();
                if (deflaterOutputStream != null) {
                    deflaterOutputStream.close();
                    byteArrayOutputStream.close();
                    return null;
                }
                return null;
            } catch (Throwable th3) {
                th = th3;
                if (deflaterOutputStream2 != null) {
                    deflaterOutputStream2.close();
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            byteArrayOutputStream = null;
            deflaterOutputStream = byteArrayOutputStream;
            e.printStackTrace();
            if (deflaterOutputStream != null) {
                deflaterOutputStream.close();
                byteArrayOutputStream.close();
                return null;
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            byteArrayOutputStream = null;
            if (deflaterOutputStream2 != null) {
                deflaterOutputStream2.close();
                byteArrayOutputStream.close();
            }
            throw th;
        }
    }

    public static Long b() {
        return d;
    }

    public static String b(Context context) {
        String str = "Unknown";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object obj = applicationInfo.metaData.get("CHANNEL");
                if (obj != null) {
                    return obj.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String b(String str) {
        if (str != null) {
            if (!str.equals("")) {
                return str;
            }
        }
        return "000000000000000";
    }

    public static String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(2 * bArr.length);
        for (byte b : bArr) {
            stringBuilder.append(a[(b & 240) >> 4]);
            stringBuilder.append(a[b & 15]);
        }
        return stringBuilder.toString();
    }

    public static void b(Long l) {
        d = l;
    }

    public static Long c() {
        return f;
    }

    public static void c(Long l) {
        e = l;
    }

    public static String[] c(Context context) {
        String[] strArr = new String[]{"Unknown", "Unknown"};
        if (context.getPackageManager().checkPermission(MsgConstant.PERMISSION_ACCESS_NETWORK_STATE, context.getPackageName()) != 0) {
            strArr[0] = "Unknown";
            return strArr;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            strArr[0] = "Unknown";
            return strArr;
        } else if (connectivityManager.getNetworkInfo(1).getState() == State.CONNECTED) {
            strArr[0] = NetworkUtils.WIFI;
            return strArr;
        } else {
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
            if (networkInfo.getState() == State.CONNECTED) {
                strArr[0] = "2G/3G/4G";
                strArr[1] = networkInfo.getSubtypeName();
            }
            return strArr;
        }
    }

    public static int d() {
        return g;
    }

    public static void d(Long l) {
        f = l;
    }

    public static boolean d(Context context) {
        if (e.longValue() < 0) {
            return false;
        }
        String packageName = context.getPackageName();
        StringBuilder stringBuilder = new StringBuilder("hianalytics_state_");
        stringBuilder.append(packageName);
        stringBuilder.append(".xml");
        packageName = stringBuilder.toString();
        File filesDir = context.getFilesDir();
        StringBuilder stringBuilder2 = new StringBuilder("../shared_prefs/");
        stringBuilder2.append(packageName);
        return new File(filesDir, stringBuilder2.toString()).length() > e.longValue();
    }

    public static java.lang.String e(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r2.getPackageManager();
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0014 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0014 }
        r2 = r0.getPackageInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0014 }
        r2 = r2.versionName;	 Catch:{ NameNotFoundException -> 0x0014 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ NameNotFoundException -> 0x0014 }
        return r2;
    L_0x0014:
        r2 = "unknown";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hianalytics.android.b.a.a.e(android.content.Context):java.lang.String");
    }

    public static boolean e() {
        return b;
    }

    public static Handler f() {
        if (j == null) {
            Looper looper = h.getLooper();
            if (looper == null) {
                return null;
            }
            j = new Handler(looper);
        }
        return j;
    }

    public static boolean f(Context context) {
        SharedPreferences a = c.a(context, AgooConstants.MESSAGE_FLAG);
        String str = Build.DISPLAY;
        String string = a.getString("rom_version", "");
        return "".equals(string) || !string.equals(str);
    }

    public static Handler g() {
        if (k == null) {
            Looper looper = i.getLooper();
            if (looper == null) {
                return null;
            }
            k = new Handler(looper);
        }
        return k;
    }

    public static void h() {
    }

    public static String i() {
        return "http://data.hicloud.com:8089/sdkv2";
    }
}
