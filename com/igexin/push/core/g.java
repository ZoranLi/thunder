package com.igexin.push.core;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Environment;
import android.text.TextUtils;
import com.igexin.assist.sdk.AssistPushConsts;
import com.igexin.b.b.a;
import com.igexin.push.config.SDKUrlConfig;
import com.igexin.push.config.q;
import com.igexin.push.core.bean.PushTaskBean;
import com.igexin.push.d.c.c;
import com.igexin.push.f.b.h;
import com.igexin.sdk.a.d;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;

public class g {
    public static String A = null;
    public static String B = null;
    public static String C = null;
    public static String D = "";
    public static long E = -1;
    public static long F = -1;
    public static long G = 0;
    public static long H = 0;
    public static long I = 0;
    public static long J = 0;
    public static long K = 0;
    public static long L = 0;
    public static long M = 0;
    public static String N = null;
    public static boolean O = q.a.equals("debug");
    public static long P = 0;
    public static long Q = 0;
    public static String R = null;
    public static long S = 0;
    public static int T = 0;
    public static long U = 0;
    public static String V = null;
    public static String W = null;
    public static String X = null;
    public static String Y = null;
    public static String Z = null;
    public static String a = "";
    public static String aA = null;
    public static boolean aB = false;
    public static int aC = 0;
    public static int aD = 0;
    private static HashMap<String, String> aE = new HashMap();
    private static Map<String, Integer> aF = null;
    public static String aa = null;
    public static String ab = null;
    public static String ac = null;
    public static String ad = null;
    public static byte[] ae = null;
    public static boolean af = false;
    public static boolean ag = false;
    public static boolean ah = false;
    public static Map<String, PushTaskBean> ai = null;
    public static Map<String, Integer> aj = null;
    public static HashMap<String, Timer> ak = null;
    public static HashMap<String, c> al = null;
    public static HashMap<String, Long> am = null;
    public static int an = 0;
    public static Map<String, String> ao = null;
    public static int ap = 0;
    public static int aq = 0;
    public static int ar = 0;
    public static com.igexin.push.core.bean.g as = null;
    public static boolean at = false;
    public static String au = null;
    public static h av = null;
    public static long aw = 0;
    public static String ax = null;
    public static String ay = null;
    public static String az = null;
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";
    public static Context f = null;
    public static AtomicBoolean g = new AtomicBoolean(false);
    public static boolean h = true;
    public static volatile boolean i = false;
    public static volatile boolean j = false;
    public static boolean k = true;
    public static volatile boolean l = false;
    public static volatile boolean m = false;
    public static boolean n = true;
    public static int o;
    public static int p;
    public static long q;
    public static String r;
    public static String s;
    public static String t;
    public static String u;
    public static String v;
    public static String w;
    public static String x;
    public static String y;
    public static String z;

    public static int a(String str, boolean z) {
        int intValue;
        synchronized (g.class) {
            if (aF.get(str) == null) {
                aF.put(str, Integer.valueOf(0));
            }
            intValue = ((Integer) aF.get(str)).intValue();
            if (z) {
                intValue--;
                aF.put(str, Integer.valueOf(intValue));
                if (intValue == 0) {
                    aF.remove(str);
                }
            }
        }
        return intValue;
    }

    public static String a() {
        return SDKUrlConfig.getConfigServiceUrl();
    }

    public static void a(long j) {
        q = j;
        r = a.a(String.valueOf(j));
    }

    public static boolean a(Context context) {
        f = context;
        e = context.getPackageName();
        if (f()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(c);
            stringBuilder.append(b);
            stringBuilder.append(context.getPackageName());
            ae = a.a(stringBuilder.toString()).getBytes();
            e();
            d();
            g();
            h = com.igexin.push.util.a.g();
            ai = new HashMap();
            aj = new HashMap();
            ak = new HashMap();
            al = new HashMap();
            am = new HashMap();
            ao = new HashMap();
            U = System.currentTimeMillis();
            stringBuilder = new StringBuilder("com.igexin.sdk.action.snlresponse.");
            stringBuilder.append(e);
            V = stringBuilder.toString();
            i = new d(context).c();
            j = new com.igexin.sdk.a.c(context).c();
            aF = new HashMap();
            h();
            aB = true;
            com.igexin.b.a.c.a.b("CoreRuntimeInfo", "getui sdk init success");
            com.igexin.b.a.c.a.b("CoreRuntimeInfo|getui sdk init success ##########");
            return true;
        }
        com.igexin.b.a.c.a.b("CoreRuntimeInfo|parseManifests failed");
        return false;
    }

    public static boolean a(String str, Integer num, boolean z) {
        synchronized (g.class) {
            int intValue = num.intValue();
            if (z && aF.get(str) != null) {
                intValue = ((Integer) aF.get(str)).intValue() + num.intValue();
                if (intValue == 0) {
                    aF.remove(str);
                    return false;
                }
            }
            aF.put(str, Integer.valueOf(intValue));
            return true;
        }
    }

    public static HashMap<String, String> b() {
        return aE;
    }

    private static java.util.HashMap<java.lang.String, java.lang.String> c() {
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
        r0 = new java.io.File;
        r1 = aa;
        r0.<init>(r1);
        r0 = r0.exists();
        r1 = 0;
        if (r0 == 0) goto L_0x0024;
    L_0x000e:
        r0 = new java.io.FileInputStream;	 Catch:{ Exception -> 0x0024 }
        r2 = aa;	 Catch:{ Exception -> 0x0024 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0024 }
        r2 = new java.io.ObjectInputStream;	 Catch:{ Exception -> 0x0024 }
        r2.<init>(r0);	 Catch:{ Exception -> 0x0024 }
        r0 = r2.readObject();	 Catch:{ Exception -> 0x0024 }
        r0 = (java.util.HashMap) r0;	 Catch:{ Exception -> 0x0024 }
        r2.close();	 Catch:{ Exception -> 0x0023 }
    L_0x0023:
        r1 = r0;
    L_0x0024:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.g.c():java.util.HashMap<java.lang.String, java.lang.String>");
    }

    private static void d() {
        try {
            File file = new File("/sdcard/libs/");
            if (file.exists() && file.isFile()) {
                com.igexin.b.a.c.a.b("CoreRuntimeInfo|libs is file not directory, delete libs file ++++");
                file.delete();
            }
            if (!(file.exists() || file.mkdir())) {
                com.igexin.b.a.c.a.b("CoreRuntimeInfo|create libs directory failed ++++++");
            }
            f.getFilesDir();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(Environment.getExternalStorageDirectory().getPath());
            stringBuilder.append("/system/tmp/local");
            file = new File(stringBuilder.toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            ab = file.getAbsolutePath();
        } catch (Throwable th) {
            stringBuilder = new StringBuilder("CoreRuntimeInfo|initFile exception = ");
            stringBuilder.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            return;
        }
        ac = f.getFilesDir().getPath();
        StringBuilder stringBuilder2 = new StringBuilder("/sdcard/libs//");
        stringBuilder2.append(e);
        stringBuilder2.append(".db");
        X = stringBuilder2.toString();
        Y = "/sdcard/libs//com.igexin.sdk.deviceId.db";
        Z = "/sdcard/libs//app.db";
        aa = "/sdcard/libs//imsi.db";
        stringBuilder2 = new StringBuilder("/sdcard/libs//");
        stringBuilder2.append(e);
        stringBuilder2.append(".properties");
        W = stringBuilder2.toString();
        stringBuilder2 = new StringBuilder("/sdcard/libs//");
        stringBuilder2.append(e);
        stringBuilder2.append(com.xunlei.download.proguard.c.o);
        ad = stringBuilder2.toString();
    }

    private static void e() {
        try {
            PackageInfo packageInfo = f.getPackageManager().getPackageInfo(e, 4096);
            if (!(packageInfo == null || packageInfo.requestedPermissions == null)) {
                String[] strArr = packageInfo.requestedPermissions;
            }
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("CoreRuntimeInfo|init exception : ");
            stringBuilder.append(e.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
        }
    }

    private static boolean f() {
        try {
            ApplicationInfo applicationInfo = f.getPackageManager().getApplicationInfo(e, 128);
            if (!(applicationInfo == null || applicationInfo.metaData == null)) {
                Object string = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPID);
                Object string2 = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPSECRET);
                Object string3 = applicationInfo.metaData.getString(AssistPushConsts.GETUI_APPKEY);
                if (string != null) {
                    string = string.trim();
                }
                if (string2 != null) {
                    string2 = string2.trim();
                }
                if (string3 != null) {
                    string3 = string3.trim();
                }
                if (!(TextUtils.isEmpty(string) || TextUtils.isEmpty(string2))) {
                    if (!TextUtils.isEmpty(string3)) {
                        a = string;
                        b = string3;
                        c = string2;
                        d = SDKUrlConfig.getLocation();
                        return true;
                    }
                }
                com.igexin.b.a.c.a.b("CoreRuntimeInfo|getui sdk init error, missing parm #####");
            }
            return false;
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("CoreRuntimeInfo|get ApplicationInfo meta data exception :");
            stringBuilder.append(th.toString());
            com.igexin.b.a.c.a.b(stringBuilder.toString());
            return false;
        }
    }

    private static void g() {
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
        r0 = f;	 Catch:{ Throwable -> 0x004f }
        r1 = "phone";	 Catch:{ Throwable -> 0x004f }
        r0 = r0.getSystemService(r1);	 Catch:{ Throwable -> 0x004f }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Throwable -> 0x004f }
        r1 = r0.getDeviceId();	 Catch:{ Throwable -> 0x004f }
        t = r1;	 Catch:{ Throwable -> 0x004f }
        r0 = r0.getSubscriberId();	 Catch:{ Throwable -> 0x004f }
        u = r0;	 Catch:{ Throwable -> 0x004f }
        r0 = x;	 Catch:{ Throwable -> 0x004f }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x004f }
        if (r0 == 0) goto L_0x004b;	 Catch:{ Throwable -> 0x004f }
    L_0x001e:
        r0 = com.igexin.push.config.m.g;	 Catch:{ Throwable -> 0x004f }
        r1 = 0;	 Catch:{ Throwable -> 0x004f }
        if (r0 == 0) goto L_0x0049;	 Catch:{ Throwable -> 0x004f }
    L_0x0023:
        r0 = c();	 Catch:{ Throwable -> 0x004f }
        if (r0 == 0) goto L_0x003b;	 Catch:{ Throwable -> 0x004f }
    L_0x0029:
        r2 = u;	 Catch:{ Throwable -> 0x004f }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x004f }
        if (r2 != 0) goto L_0x003b;	 Catch:{ Throwable -> 0x004f }
    L_0x0031:
        r2 = u;	 Catch:{ Throwable -> 0x004f }
        r0 = r0.get(r2);	 Catch:{ Throwable -> 0x004f }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x004f }
        x = r0;	 Catch:{ Throwable -> 0x004f }
    L_0x003b:
        r0 = x;	 Catch:{ Throwable -> 0x004f }
        if (r0 == 0) goto L_0x0049;	 Catch:{ Throwable -> 0x004f }
    L_0x003f:
        r0 = x;	 Catch:{ Throwable -> 0x004f }
        r2 = "";	 Catch:{ Throwable -> 0x004f }
        r0 = r0.equals(r2);	 Catch:{ Throwable -> 0x004f }
        if (r0 != 0) goto L_0x004b;	 Catch:{ Throwable -> 0x004f }
    L_0x0049:
        x = r1;	 Catch:{ Throwable -> 0x004f }
    L_0x004b:
        r0 = android.os.Build.MODEL;	 Catch:{ Throwable -> 0x004f }
        v = r0;	 Catch:{ Throwable -> 0x004f }
    L_0x004f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.g.g():void");
    }

    private static void h() {
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
        r0 = 0;
        r1 = com.igexin.push.core.f.a();	 Catch:{ Throwable -> 0x002b }
        r2 = r1.k();	 Catch:{ Throwable -> 0x002b }
        r3 = "message";	 Catch:{ Throwable -> 0x002b }
        r4 = 0;	 Catch:{ Throwable -> 0x002b }
        r5 = 0;	 Catch:{ Throwable -> 0x002b }
        r6 = 0;	 Catch:{ Throwable -> 0x002b }
        r7 = 0;	 Catch:{ Throwable -> 0x002b }
        r1 = r2.a(r3, r4, r5, r6, r7);	 Catch:{ Throwable -> 0x002b }
        if (r1 == 0) goto L_0x0023;
    L_0x0015:
        r0 = r1.getCount();	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        aD = r0;	 Catch:{ Throwable -> 0x0021, all -> 0x001c }
        goto L_0x0023;
    L_0x001c:
        r0 = move-exception;
        r8 = r1;
        r1 = r0;
        r0 = r8;
        goto L_0x0036;
    L_0x0021:
        r0 = r1;
        goto L_0x002b;
    L_0x0023:
        if (r1 == 0) goto L_0x0035;
    L_0x0025:
        r1.close();
        return;
    L_0x0029:
        r1 = move-exception;
        goto L_0x0036;
    L_0x002b:
        r1 = "CoreRuntimeInfogetMessageTableNum error";	 Catch:{ all -> 0x0029 }
        com.igexin.b.a.c.a.b(r1);	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0035;
    L_0x0032:
        r0.close();
    L_0x0035:
        return;
    L_0x0036:
        if (r0 == 0) goto L_0x003b;
    L_0x0038:
        r0.close();
    L_0x003b:
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.core.g.h():void");
    }
}
