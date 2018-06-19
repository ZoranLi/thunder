package com.alipay.sdk.app.statistic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.alipay.sdk.cons.a;
import com.alipay.sdk.tid.b;
import com.umeng.message.proguard.k;
import com.xiaomi.mipush.sdk.Constants;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class c {
    public static final String A = "CheckClientExistEx";
    public static final String B = "CheckClientSignEx";
    public static final String C = "GetInstalledAppEx";
    public static final String D = "partner";
    public static final String E = "out_trade_no";
    public static final String F = "trade_no";
    public static final String a = "net";
    public static final String b = "biz";
    public static final String c = "cp";
    public static final String d = "auth";
    public static final String e = "third";
    public static final String f = "GetApdidEx";
    public static final String g = "GetApdidNull";
    public static final String h = "GetApdidTimeout";
    public static final String i = "GetUtdidEx";
    public static final String j = "GetPackageInfoEx";
    public static final String k = "NotIncludeSignatures";
    public static final String l = "GetInstalledPackagesEx";
    public static final String m = "GetPublicKeyFromSignEx";
    public static final String n = "H5PayNetworkError";
    public static final String o = "H5AuthNetworkError";
    public static final String p = "SSLError";
    public static final String q = "H5PayDataAnalysisError";
    public static final String r = "H5AuthDataAnalysisError";
    public static final String s = "PublicKeyUnmatch";
    public static final String t = "ClientBindFailed";
    public static final String u = "TriDesEncryptError";
    public static final String v = "TriDesDecryptError";
    public static final String w = "ClientBindException";
    public static final String x = "SaveTradeTokenError";
    public static final String y = "ClientBindServiceFailed";
    public static final String z = "BindWaitTimeoutEx";
    String G;
    String H;
    String I;
    String J;
    String K;
    String L;
    String M;
    String N;
    String O = "";
    String P;

    public c(Context context) {
        String format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date());
        this.G = String.format("123456789,%s", new Object[]{format});
        this.I = a(context);
        format = a(a.e);
        String a = a(a.f);
        this.J = String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,-,-", new Object[]{format, a});
        format = a(b.a().a);
        a = a(com.alipay.sdk.sys.b.a().c());
        this.K = String.format("%s,%s,-,-,-", new Object[]{format, a});
        format = a(com.alipay.sdk.util.a.d(context));
        a = DispatchConstants.ANDROID;
        String a2 = a(VERSION.RELEASE);
        String a3 = a(Build.MODEL);
        String a4 = a(com.alipay.sdk.util.a.a(context).a());
        String a5 = a(com.alipay.sdk.util.a.b(context).p);
        context = a(com.alipay.sdk.util.a.a(context).b());
        this.L = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", new Object[]{format, a, a2, a3, "-", a4, a5, "gw", context});
        this.M = "-";
        this.N = "-";
        this.P = "-";
    }

    private boolean a() {
        return TextUtils.isEmpty(this.O);
    }

    public final void a(String str, String str2, Throwable th) {
        a(str, str2, a(th));
    }

    private void a(String str, String str2, Throwable th, String str3) {
        a(str, str2, a(th), str3);
    }

    public final void a(String str, String str2, String str3, String str4) {
        StringBuilder stringBuilder;
        String str5 = "";
        if (!TextUtils.isEmpty(this.O)) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(str5);
            stringBuilder.append("^");
            str5 = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str5);
        stringBuilder.append(String.format("%s,%s,%s,%s", new Object[]{str, str2, a(str3), str4}));
        str = stringBuilder.toString();
        str2 = new StringBuilder();
        str2.append(this.O);
        str2.append(str);
        this.O = str2.toString();
    }

    public final void a(String str, String str2, String str3) {
        a(str, str2, str3, "-");
    }

    static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("[", "【").replace("]", "】").replace(k.s, "（").replace(k.t, "）").replace(Constants.ACCEPT_TIME_SEPARATOR_SP, "，").replace("-", "=").replace("^", Constants.WAVE_SEPARATOR);
    }

    static java.lang.String a(java.lang.Throwable r4) {
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
        if (r4 != 0) goto L_0x0005;
    L_0x0002:
        r4 = "";
        return r4;
    L_0x0005:
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r1 = r4.getClass();	 Catch:{ Throwable -> 0x004d }
        r1 = r1.getName();	 Catch:{ Throwable -> 0x004d }
        r0.append(r1);	 Catch:{ Throwable -> 0x004d }
        r1 = ":";	 Catch:{ Throwable -> 0x004d }
        r0.append(r1);	 Catch:{ Throwable -> 0x004d }
        r1 = r4.getMessage();	 Catch:{ Throwable -> 0x004d }
        r0.append(r1);	 Catch:{ Throwable -> 0x004d }
        r1 = " 》 ";	 Catch:{ Throwable -> 0x004d }
        r0.append(r1);	 Catch:{ Throwable -> 0x004d }
        r4 = r4.getStackTrace();	 Catch:{ Throwable -> 0x004d }
        if (r4 == 0) goto L_0x004d;	 Catch:{ Throwable -> 0x004d }
    L_0x002c:
        r1 = 0;	 Catch:{ Throwable -> 0x004d }
    L_0x002d:
        r2 = r4.length;	 Catch:{ Throwable -> 0x004d }
        if (r1 >= r2) goto L_0x004d;	 Catch:{ Throwable -> 0x004d }
    L_0x0030:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x004d }
        r2.<init>();	 Catch:{ Throwable -> 0x004d }
        r3 = r4[r1];	 Catch:{ Throwable -> 0x004d }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x004d }
        r2.append(r3);	 Catch:{ Throwable -> 0x004d }
        r3 = " 》 ";	 Catch:{ Throwable -> 0x004d }
        r2.append(r3);	 Catch:{ Throwable -> 0x004d }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x004d }
        r0.append(r2);	 Catch:{ Throwable -> 0x004d }
        r1 = r1 + 1;
        goto L_0x002d;
    L_0x004d:
        r4 = r0.toString();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.statistic.c.a(java.lang.Throwable):java.lang.String");
    }

    private String b(String str) {
        if (TextUtils.isEmpty(this.O)) {
            return "";
        }
        String str2;
        str = str.split("&");
        String str3 = null;
        if (str != null) {
            str2 = null;
            String str4 = str2;
            for (String split : str) {
                String[] split2 = split.split("=");
                if (split2 != null && split2.length == 2) {
                    if (split2[0].equalsIgnoreCase(D)) {
                        split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(E)) {
                        str2 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(F)) {
                        str4 = split2[1].replace("\"", "");
                    }
                }
            }
            str3 = str4;
        } else {
            str2 = null;
        }
        str = a(str3);
        String a = a(a(str2));
        this.H = String.format("%s,%s,-,%s,-,-,-", new Object[]{str, str3, a});
        return String.format("[(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s),(%s)]", new Object[]{this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P});
    }

    @SuppressLint({"SimpleDateFormat"})
    private static String b() {
        String format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss").format(new Date());
        return String.format("123456789,%s", new Object[]{format});
    }

    private static String c(String str) {
        String str2;
        str = str.split("&");
        String str3 = null;
        if (str != null) {
            str2 = null;
            String str4 = str2;
            for (String split : str) {
                String[] split2 = split.split("=");
                if (split2 != null && split2.length == 2) {
                    if (split2[0].equalsIgnoreCase(D)) {
                        split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(E)) {
                        str2 = split2[1].replace("\"", "");
                    } else if (split2[0].equalsIgnoreCase(F)) {
                        str4 = split2[1].replace("\"", "");
                    }
                }
            }
            str3 = str4;
        } else {
            str2 = null;
        }
        str = a(str3);
        String a = a(a(str2));
        return String.format("%s,%s,-,%s,-,-,-", new Object[]{str, a(str2), a});
    }

    private static java.lang.String a(android.content.Context r4) {
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
        r0 = "-";
        r1 = "-";
        r2 = 0;
        if (r4 == 0) goto L_0x001b;
    L_0x0007:
        r4 = r4.getApplicationContext();	 Catch:{ Throwable -> 0x001b }
        r3 = r4.getPackageName();	 Catch:{ Throwable -> 0x001b }
        r4 = r4.getPackageManager();	 Catch:{ Throwable -> 0x001a }
        r4 = r4.getPackageInfo(r3, r2);	 Catch:{ Throwable -> 0x001a }
        r4 = r4.versionName;	 Catch:{ Throwable -> 0x001a }
        r1 = r4;
    L_0x001a:
        r0 = r3;
    L_0x001b:
        r4 = "%s,%s,-,-,-";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r3[r2] = r0;
        r0 = 1;
        r3[r0] = r1;
        r4 = java.lang.String.format(r4, r3);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.statistic.c.a(android.content.Context):java.lang.String");
    }

    private static String c() {
        String a = a(a.e);
        String a2 = a(a.f);
        return String.format("android,3,%s,%s,com.alipay.mcpay,5.0,-,-,-", new Object[]{a, a2});
    }

    private static String d() {
        String a = a(b.a().a);
        String a2 = a(com.alipay.sdk.sys.b.a().c());
        return String.format("%s,%s,-,-,-", new Object[]{a, a2});
    }

    private static String b(Context context) {
        String a = a(com.alipay.sdk.util.a.d(context));
        String str = DispatchConstants.ANDROID;
        String a2 = a(VERSION.RELEASE);
        String a3 = a(Build.MODEL);
        String a4 = a(com.alipay.sdk.util.a.a(context).a());
        String a5 = a(com.alipay.sdk.util.a.b(context).p);
        context = a(com.alipay.sdk.util.a.a(context).b());
        return String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,-", new Object[]{a, str, a2, a3, "-", a4, a5, "gw", context});
    }
}
