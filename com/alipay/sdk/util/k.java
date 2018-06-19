package com.alipay.sdk.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import anet.channel.util.HttpConstant;
import com.alipay.sdk.app.statistic.c;
import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayInputStream;
import java.net.URLDecoder;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

@SuppressLint({"SetJavaScriptEnabled", "DefaultLocale"})
public final class k {
    static final String a = "com.alipay.android.app";
    public static final String b = "com.eg.android.AlipayGphone";
    public static final int c = 99;
    public static final int d = 73;

    public static class a {
        public Signature[] a;
        public int b;

        public final boolean a() {
            boolean z = false;
            if (this.a != null) {
                if (this.a.length > 0) {
                    for (Signature toByteArray : this.a) {
                        String a = k.a(toByteArray.toByteArray());
                        if (a != null && !TextUtils.equals(a, com.alipay.sdk.cons.a.g)) {
                            com.alipay.sdk.app.statistic.a.a("biz", c.s, a);
                            z = true;
                            break;
                        }
                    }
                    return z;
                }
            }
            return false;
        }
    }

    private static String e() {
        return "-1;-1";
    }

    public static Map<String, String> a(String str) {
        Map<String, String> hashMap = new HashMap();
        for (String str2 : str.split("&")) {
            int indexOf = str2.indexOf("=", 1);
            hashMap.put(str2.substring(0, indexOf), URLDecoder.decode(str2.substring(indexOf + 1)));
        }
        return hashMap;
    }

    public static java.lang.String a(java.lang.String r2, java.lang.String r3, java.lang.String r4) {
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
        r0 = r4.indexOf(r2);	 Catch:{ Throwable -> 0x0029 }
        r1 = r2.length();	 Catch:{ Throwable -> 0x0029 }
        r0 = r0 + r1;	 Catch:{ Throwable -> 0x0029 }
        r2 = r2.length();	 Catch:{ Throwable -> 0x0029 }
        if (r0 > r2) goto L_0x0012;	 Catch:{ Throwable -> 0x0029 }
    L_0x000f:
        r2 = "";	 Catch:{ Throwable -> 0x0029 }
        return r2;	 Catch:{ Throwable -> 0x0029 }
    L_0x0012:
        r2 = 0;	 Catch:{ Throwable -> 0x0029 }
        r1 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x0029 }
        if (r1 != 0) goto L_0x001d;	 Catch:{ Throwable -> 0x0029 }
    L_0x0019:
        r2 = r4.indexOf(r3, r0);	 Catch:{ Throwable -> 0x0029 }
    L_0x001d:
        if (r2 > 0) goto L_0x0024;	 Catch:{ Throwable -> 0x0029 }
    L_0x001f:
        r2 = r4.substring(r0);	 Catch:{ Throwable -> 0x0029 }
        return r2;	 Catch:{ Throwable -> 0x0029 }
    L_0x0024:
        r2 = r4.substring(r0, r2);	 Catch:{ Throwable -> 0x0029 }
        return r2;
    L_0x0029:
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.k.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    public static String a(byte[] bArr) {
        try {
            bArr = ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(bArr))).getPublicKey().toString();
            if (bArr.indexOf("modulus") != -1) {
                return bArr.substring(bArr.indexOf("modulus") + 8, bArr.lastIndexOf(Constants.ACCEPT_TIME_SEPARATOR_SP)).trim();
            }
        } catch (Throwable e) {
            com.alipay.sdk.app.statistic.a.a("auth", c.m, e);
        }
        return null;
    }

    private static a i(Context context) {
        return a(context, b);
    }

    public static a a(Context context, String str) {
        PackageInfo c;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 192);
            if (!a(packageInfo)) {
                try {
                    c = c(context, str);
                } catch (Throwable th) {
                    com.alipay.sdk.app.statistic.a.a("auth", c.l, th);
                }
                if (a(c) != null || c == null) {
                    return null;
                }
                str = new a();
                str.a = c.signatures;
                str.b = c.versionCode;
                return str;
            }
            c = packageInfo;
        } catch (Throwable th2) {
            com.alipay.sdk.app.statistic.a.a("auth", c.l, th2);
            c = null;
        }
        if (a(c) != null) {
            return null;
        }
        str = new a();
        str.a = c.signatures;
        str.b = c.versionCode;
        return str;
    }

    private static boolean a(PackageInfo packageInfo) {
        String str = "";
        boolean z = false;
        if (packageInfo == null) {
            packageInfo = new StringBuilder();
            packageInfo.append(str);
            packageInfo.append("info == null");
            str = packageInfo.toString();
        } else if (packageInfo.signatures == null) {
            packageInfo = new StringBuilder();
            packageInfo.append(str);
            packageInfo.append("info.signatures == null");
            str = packageInfo.toString();
        } else if (packageInfo.signatures.length <= null) {
            packageInfo = new StringBuilder();
            packageInfo.append(str);
            packageInfo.append("info.signatures.length <= 0");
            str = packageInfo.toString();
        } else {
            z = true;
        }
        if (!z) {
            com.alipay.sdk.app.statistic.a.a("auth", c.k, str);
        }
        return z;
    }

    private static PackageInfo b(Context context, String str) throws NameNotFoundException {
        return context.getPackageManager().getPackageInfo(str, 192);
    }

    private static PackageInfo c(Context context, String str) {
        for (PackageInfo packageInfo : context.getPackageManager().getInstalledPackages(192)) {
            if (packageInfo.packageName.equals(str)) {
                return packageInfo;
            }
        }
        return null;
    }

    private static a b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return null;
        }
        a aVar = new a();
        aVar.a = packageInfo.signatures;
        aVar.b = packageInfo.versionCode;
        return aVar;
    }

    public static boolean a(android.content.Context r3) {
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
        r3 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0012 }
        r1 = "com.alipay.android.app";	 Catch:{ NameNotFoundException -> 0x0012 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0012 }
        r3 = r3.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x0012 }
        if (r3 != 0) goto L_0x0010;
    L_0x000f:
        return r0;
    L_0x0010:
        r3 = 1;
        return r3;
    L_0x0012:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.k.a(android.content.Context):boolean");
    }

    public static boolean b(Context context) {
        try {
            context = context.getPackageManager().getPackageInfo(b, 128);
            if (context != null && context.versionCode > 73) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a("biz", c.A, th);
            return false;
        }
    }

    public static boolean c(android.content.Context r3) {
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
        r3 = r3.getPackageManager();	 Catch:{ Throwable -> 0x0019 }
        r1 = "com.eg.android.AlipayGphone";	 Catch:{ Throwable -> 0x0019 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Throwable -> 0x0019 }
        r3 = r3.getPackageInfo(r1, r2);	 Catch:{ Throwable -> 0x0019 }
        if (r3 != 0) goto L_0x0010;	 Catch:{ Throwable -> 0x0019 }
    L_0x000f:
        return r0;	 Catch:{ Throwable -> 0x0019 }
    L_0x0010:
        r3 = r3.versionCode;	 Catch:{ Throwable -> 0x0019 }
        r1 = 99;
        if (r3 >= r1) goto L_0x0018;
    L_0x0016:
        r3 = 1;
        return r3;
    L_0x0018:
        return r0;
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.k.c(android.content.Context):boolean");
    }

    public static String d(Context context) {
        String a = a();
        String b = b();
        String e = e(context);
        context = f(context);
        StringBuilder stringBuilder = new StringBuilder(" (");
        stringBuilder.append(a);
        stringBuilder.append(h.b);
        stringBuilder.append(b);
        stringBuilder.append(h.b);
        stringBuilder.append(e);
        stringBuilder.append(";;");
        stringBuilder.append(context);
        stringBuilder.append(")(sdk android)");
        return stringBuilder.toString();
    }

    public static String a() {
        StringBuilder stringBuilder = new StringBuilder("Android ");
        stringBuilder.append(VERSION.RELEASE);
        return stringBuilder.toString();
    }

    public static android.webkit.WebView a(android.app.Activity r5, java.lang.String r6, java.lang.String r7) {
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
        r0 = android.text.TextUtils.isEmpty(r7);
        if (r0 != 0) goto L_0x001f;
    L_0x0006:
        r0 = r5.getApplicationContext();
        r0 = android.webkit.CookieSyncManager.createInstance(r0);
        r0.sync();
        r0 = android.webkit.CookieManager.getInstance();
        r0.setCookie(r6, r7);
        r7 = android.webkit.CookieSyncManager.getInstance();
        r7.sync();
    L_0x001f:
        r7 = new android.widget.LinearLayout;
        r7.<init>(r5);
        r0 = new android.widget.LinearLayout$LayoutParams;
        r1 = -1;
        r0.<init>(r1, r1);
        r1 = 1;
        r7.setOrientation(r1);
        r5.setContentView(r7, r0);
        r2 = new android.webkit.WebView;
        r2.<init>(r5);
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r0.weight = r3;
        r3 = 0;
        r2.setVisibility(r3);
        r7.addView(r2, r0);
        r7 = r2.getSettings();
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r4 = r7.getUserAgentString();
        r0.append(r4);
        r4 = d(r5);
        r0.append(r4);
        r0 = r0.toString();
        r7.setUserAgentString(r0);
        r0 = android.webkit.WebSettings.RenderPriority.HIGH;
        r7.setRenderPriority(r0);
        r7.setSupportMultipleWindows(r1);
        r7.setJavaScriptEnabled(r1);
        r7.setSavePassword(r3);
        r7.setJavaScriptCanOpenWindowsAutomatically(r1);
        r0 = r7.getMinimumFontSize();
        r0 = r0 + 8;
        r7.setMinimumFontSize(r0);
        r7.setAllowFileAccess(r3);
        r0 = android.webkit.WebSettings.TextSize.NORMAL;
        r7.setTextSize(r0);
        r2.setVerticalScrollbarOverlay(r1);
        r7 = new com.alipay.sdk.util.l;
        r7.<init>(r5);
        r2.setDownloadListener(r7);
        r5 = android.os.Build.VERSION.SDK_INT;
        r7 = 7;
        if (r5 < r7) goto L_0x00b6;
    L_0x0091:
        r5 = r2.getSettings();	 Catch:{ Exception -> 0x00b6 }
        r5 = r5.getClass();	 Catch:{ Exception -> 0x00b6 }
        r7 = "setDomStorageEnabled";	 Catch:{ Exception -> 0x00b6 }
        r0 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x00b6 }
        r4 = java.lang.Boolean.TYPE;	 Catch:{ Exception -> 0x00b6 }
        r0[r3] = r4;	 Catch:{ Exception -> 0x00b6 }
        r5 = r5.getMethod(r7, r0);	 Catch:{ Exception -> 0x00b6 }
        if (r5 == 0) goto L_0x00b6;	 Catch:{ Exception -> 0x00b6 }
    L_0x00a7:
        r7 = r2.getSettings();	 Catch:{ Exception -> 0x00b6 }
        r0 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x00b6 }
        r4 = java.lang.Boolean.valueOf(r1);	 Catch:{ Exception -> 0x00b6 }
        r0[r3] = r4;	 Catch:{ Exception -> 0x00b6 }
        r5.invoke(r7, r0);	 Catch:{ Exception -> 0x00b6 }
    L_0x00b6:
        r5 = "searchBoxJavaBridge_";	 Catch:{ Throwable -> 0x00c6 }
        r2.removeJavascriptInterface(r5);	 Catch:{ Throwable -> 0x00c6 }
        r5 = "accessibility";	 Catch:{ Throwable -> 0x00c6 }
        r2.removeJavascriptInterface(r5);	 Catch:{ Throwable -> 0x00c6 }
        r5 = "accessibilityTraversal";	 Catch:{ Throwable -> 0x00c6 }
        r2.removeJavascriptInterface(r5);	 Catch:{ Throwable -> 0x00c6 }
        goto L_0x00ef;
    L_0x00c6:
        r5 = r2.getClass();	 Catch:{ Throwable -> 0x00ef }
        r7 = "removeJavascriptInterface";	 Catch:{ Throwable -> 0x00ef }
        r0 = new java.lang.Class[r3];	 Catch:{ Throwable -> 0x00ef }
        r5 = r5.getMethod(r7, r0);	 Catch:{ Throwable -> 0x00ef }
        if (r5 == 0) goto L_0x00ef;	 Catch:{ Throwable -> 0x00ef }
    L_0x00d4:
        r7 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00ef }
        r0 = "searchBoxJavaBridge_";	 Catch:{ Throwable -> 0x00ef }
        r7[r3] = r0;	 Catch:{ Throwable -> 0x00ef }
        r5.invoke(r2, r7);	 Catch:{ Throwable -> 0x00ef }
        r7 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00ef }
        r0 = "accessibility";	 Catch:{ Throwable -> 0x00ef }
        r7[r3] = r0;	 Catch:{ Throwable -> 0x00ef }
        r5.invoke(r2, r7);	 Catch:{ Throwable -> 0x00ef }
        r7 = new java.lang.Object[r1];	 Catch:{ Throwable -> 0x00ef }
        r0 = "accessibilityTraversal";	 Catch:{ Throwable -> 0x00ef }
        r7[r3] = r0;	 Catch:{ Throwable -> 0x00ef }
        r5.invoke(r2, r7);	 Catch:{ Throwable -> 0x00ef }
    L_0x00ef:
        r5 = android.os.Build.VERSION.SDK_INT;
        r7 = 19;
        if (r5 < r7) goto L_0x00fc;
    L_0x00f5:
        r5 = r2.getSettings();
        r5.setCacheMode(r1);
    L_0x00fc:
        r2.loadUrl(r6);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.k.a(android.app.Activity, java.lang.String, java.lang.String):android.webkit.WebView");
    }

    public static String b() {
        String d = d();
        int indexOf = d.indexOf("-");
        if (indexOf != -1) {
            d = d.substring(0, indexOf);
        }
        indexOf = d.indexOf("\n");
        if (indexOf != -1) {
            d = d.substring(0, indexOf);
        }
        StringBuilder stringBuilder = new StringBuilder("Linux ");
        stringBuilder.append(d);
        return stringBuilder.toString();
    }

    private static java.lang.String d() {
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
        r0 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x006c }
        r1 = new java.io.FileReader;	 Catch:{ IOException -> 0x006c }
        r2 = "/proc/version";	 Catch:{ IOException -> 0x006c }
        r1.<init>(r2);	 Catch:{ IOException -> 0x006c }
        r2 = 256; // 0x100 float:3.59E-43 double:1.265E-321;	 Catch:{ IOException -> 0x006c }
        r0.<init>(r1, r2);	 Catch:{ IOException -> 0x006c }
        r1 = r0.readLine();	 Catch:{ all -> 0x0067 }
        r0.close();	 Catch:{ IOException -> 0x006c }
        r0 = "\\w+\\s+\\w+\\s+([^\\s]+)\\s+\\(([^\\s@]+(?:@[^\\s.]+)?)[^)]*\\)\\s+\\((?:[^(]*\\([^)]*\\))?[^)]*\\)\\s+([^\\s]+)\\s+(?:PREEMPT\\s+)?(.+)";	 Catch:{ IOException -> 0x006c }
        r0 = java.util.regex.Pattern.compile(r0);	 Catch:{ IOException -> 0x006c }
        r0 = r0.matcher(r1);	 Catch:{ IOException -> 0x006c }
        r1 = r0.matches();	 Catch:{ IOException -> 0x006c }
        if (r1 != 0) goto L_0x0028;	 Catch:{ IOException -> 0x006c }
    L_0x0025:
        r0 = "Unavailable";	 Catch:{ IOException -> 0x006c }
        return r0;	 Catch:{ IOException -> 0x006c }
    L_0x0028:
        r1 = r0.groupCount();	 Catch:{ IOException -> 0x006c }
        r2 = 4;	 Catch:{ IOException -> 0x006c }
        if (r1 >= r2) goto L_0x0032;	 Catch:{ IOException -> 0x006c }
    L_0x002f:
        r0 = "Unavailable";	 Catch:{ IOException -> 0x006c }
        return r0;	 Catch:{ IOException -> 0x006c }
    L_0x0032:
        r1 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x006c }
        r3 = 1;	 Catch:{ IOException -> 0x006c }
        r3 = r0.group(r3);	 Catch:{ IOException -> 0x006c }
        r1.<init>(r3);	 Catch:{ IOException -> 0x006c }
        r3 = "\n";	 Catch:{ IOException -> 0x006c }
        r1.append(r3);	 Catch:{ IOException -> 0x006c }
        r3 = 2;	 Catch:{ IOException -> 0x006c }
        r3 = r0.group(r3);	 Catch:{ IOException -> 0x006c }
        r1.append(r3);	 Catch:{ IOException -> 0x006c }
        r3 = " ";	 Catch:{ IOException -> 0x006c }
        r1.append(r3);	 Catch:{ IOException -> 0x006c }
        r3 = 3;	 Catch:{ IOException -> 0x006c }
        r3 = r0.group(r3);	 Catch:{ IOException -> 0x006c }
        r1.append(r3);	 Catch:{ IOException -> 0x006c }
        r3 = "\n";	 Catch:{ IOException -> 0x006c }
        r1.append(r3);	 Catch:{ IOException -> 0x006c }
        r0 = r0.group(r2);	 Catch:{ IOException -> 0x006c }
        r1.append(r0);	 Catch:{ IOException -> 0x006c }
        r0 = r1.toString();	 Catch:{ IOException -> 0x006c }
        return r0;	 Catch:{ IOException -> 0x006c }
    L_0x0067:
        r1 = move-exception;	 Catch:{ IOException -> 0x006c }
        r0.close();	 Catch:{ IOException -> 0x006c }
        throw r1;	 Catch:{ IOException -> 0x006c }
    L_0x006c:
        r0 = "Unavailable";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.k.d():java.lang.String");
    }

    public static String e(Context context) {
        return context.getResources().getConfiguration().locale.toString();
    }

    public static String f(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        context = new StringBuilder();
        context.append(displayMetrics.widthPixels);
        context.append("*");
        context.append(displayMetrics.heightPixels);
        return context.toString();
    }

    private static DisplayMetrics j(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics;
    }

    private static String k(Context context) {
        context = j.a(context);
        return context.substring(0, context.indexOf(HttpConstant.SCHEME_SPLIT));
    }

    public static String c() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 24; i++) {
            switch (random.nextInt(3)) {
                case 0:
                    stringBuilder.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 65.0d))));
                    break;
                case 1:
                    stringBuilder.append(String.valueOf((char) ((int) Math.round((Math.random() * 25.0d) + 97.0d))));
                    break;
                case 2:
                    stringBuilder.append(String.valueOf(new Random().nextInt(10)));
                    break;
                default:
                    break;
            }
        }
        return stringBuilder.toString();
    }

    public static boolean b(String str) {
        return Pattern.compile("^http(s)?://([a-z0-9_\\-]+\\.)*(alipay|taobao)\\.(com|net)(:\\d+)?(/.*)?$").matcher(str).matches();
    }

    public static java.lang.String g(android.content.Context r4) {
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
        r0 = "";
        r1 = "activity";	 Catch:{ Throwable -> 0x0063 }
        r4 = r4.getSystemService(r1);	 Catch:{ Throwable -> 0x0063 }
        r4 = (android.app.ActivityManager) r4;	 Catch:{ Throwable -> 0x0063 }
        r4 = r4.getRunningAppProcesses();	 Catch:{ Throwable -> 0x0063 }
        r4 = r4.iterator();	 Catch:{ Throwable -> 0x0063 }
    L_0x0012:
        r1 = r4.hasNext();	 Catch:{ Throwable -> 0x0063 }
        if (r1 == 0) goto L_0x0065;	 Catch:{ Throwable -> 0x0063 }
    L_0x0018:
        r1 = r4.next();	 Catch:{ Throwable -> 0x0063 }
        r1 = (android.app.ActivityManager.RunningAppProcessInfo) r1;	 Catch:{ Throwable -> 0x0063 }
        r2 = r1.processName;	 Catch:{ Throwable -> 0x0063 }
        r3 = "com.eg.android.AlipayGphone";	 Catch:{ Throwable -> 0x0063 }
        r2 = r2.equals(r3);	 Catch:{ Throwable -> 0x0063 }
        if (r2 == 0) goto L_0x003a;	 Catch:{ Throwable -> 0x0063 }
    L_0x0028:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0063 }
        r1.<init>();	 Catch:{ Throwable -> 0x0063 }
        r1.append(r0);	 Catch:{ Throwable -> 0x0063 }
        r0 = "#M";	 Catch:{ Throwable -> 0x0063 }
        r1.append(r0);	 Catch:{ Throwable -> 0x0063 }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x0063 }
        goto L_0x0012;	 Catch:{ Throwable -> 0x0063 }
    L_0x003a:
        r2 = r1.processName;	 Catch:{ Throwable -> 0x0063 }
        r3 = "com.eg.android.AlipayGphone:";	 Catch:{ Throwable -> 0x0063 }
        r2 = r2.startsWith(r3);	 Catch:{ Throwable -> 0x0063 }
        if (r2 == 0) goto L_0x0012;	 Catch:{ Throwable -> 0x0063 }
    L_0x0044:
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0063 }
        r2.<init>();	 Catch:{ Throwable -> 0x0063 }
        r2.append(r0);	 Catch:{ Throwable -> 0x0063 }
        r0 = "#";	 Catch:{ Throwable -> 0x0063 }
        r2.append(r0);	 Catch:{ Throwable -> 0x0063 }
        r0 = r1.processName;	 Catch:{ Throwable -> 0x0063 }
        r1 = "com.eg.android.AlipayGphone:";	 Catch:{ Throwable -> 0x0063 }
        r3 = "";	 Catch:{ Throwable -> 0x0063 }
        r0 = r0.replace(r1, r3);	 Catch:{ Throwable -> 0x0063 }
        r2.append(r0);	 Catch:{ Throwable -> 0x0063 }
        r0 = r2.toString();	 Catch:{ Throwable -> 0x0063 }
        goto L_0x0012;
    L_0x0063:
        r0 = "";
    L_0x0065:
        r4 = r0.length();
        if (r4 <= 0) goto L_0x0070;
    L_0x006b:
        r4 = 1;
        r0 = r0.substring(r4);
    L_0x0070:
        r4 = r0.length();
        if (r4 != 0) goto L_0x0078;
    L_0x0076:
        r0 = "N";
    L_0x0078:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.k.g(android.content.Context):java.lang.String");
    }

    public static String h(Context context) {
        try {
            context = context.getPackageManager().getInstalledPackages(0);
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < context.size(); i++) {
                PackageInfo packageInfo = (PackageInfo) context.get(i);
                int i2 = packageInfo.applicationInfo.flags;
                i2 = ((i2 & 1) == 0 && (i2 & 128) == 0) ? 1 : 0;
                if (i2 != 0) {
                    if (packageInfo.packageName.equals(b)) {
                        stringBuilder.append(packageInfo.packageName);
                        stringBuilder.append(packageInfo.versionCode);
                        stringBuilder.append("-");
                    } else if (!(packageInfo.packageName.contains("theme") || packageInfo.packageName.startsWith("com.google.") || packageInfo.packageName.startsWith("com.android."))) {
                        stringBuilder.append(packageInfo.packageName);
                        stringBuilder.append("-");
                    }
                }
            }
            return stringBuilder.toString();
        } catch (Throwable th) {
            com.alipay.sdk.app.statistic.a.a("biz", c.C, th);
            return "";
        }
    }

    @SuppressLint({"InlinedApi"})
    private static boolean c(PackageInfo packageInfo) {
        packageInfo = packageInfo.applicationInfo.flags;
        return ((packageInfo & 1) == 0 && (packageInfo & 128) == null) ? true : null;
    }

    public static boolean a(android.webkit.WebView r4, java.lang.String r5, android.app.Activity r6) {
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
        r0 = android.text.TextUtils.isEmpty(r5);
        r1 = 1;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r0 = r5.toLowerCase();
        r2 = "alipays://platformapi/startApp?";
        r2 = r2.toLowerCase();
        r0 = r0.startsWith(r2);
        if (r0 != 0) goto L_0x0117;
    L_0x0018:
        r0 = r5.toLowerCase();
        r2 = "intent://platformapi/startapp?";
        r2 = r2.toLowerCase();
        r0 = r0.startsWith(r2);
        if (r0 == 0) goto L_0x002a;
    L_0x0028:
        goto L_0x0117;
    L_0x002a:
        r0 = "sdklite://h5quit";
        r0 = android.text.TextUtils.equals(r5, r0);
        if (r0 != 0) goto L_0x010d;
    L_0x0032:
        r0 = "http://m.alipay.com/?action=h5quit";
        r0 = android.text.TextUtils.equals(r5, r0);
        if (r0 == 0) goto L_0x003c;
    L_0x003a:
        goto L_0x010d;
    L_0x003c:
        r0 = "sdklite://h5quit?result=";
        r0 = r5.startsWith(r0);
        if (r0 == 0) goto L_0x0109;
    L_0x0044:
        r4 = "sdklite://h5quit?result=";	 Catch:{ Exception -> 0x00ec }
        r4 = r5.indexOf(r4);	 Catch:{ Exception -> 0x00ec }
        r4 = r4 + 24;	 Catch:{ Exception -> 0x00ec }
        r4 = r5.substring(r4);	 Catch:{ Exception -> 0x00ec }
        r0 = "&end_code=";	 Catch:{ Exception -> 0x00ec }
        r0 = r4.lastIndexOf(r0);	 Catch:{ Exception -> 0x00ec }
        r0 = r0 + 10;	 Catch:{ Exception -> 0x00ec }
        r4 = r4.substring(r0);	 Catch:{ Exception -> 0x00ec }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ Exception -> 0x00ec }
        r0 = com.alipay.sdk.app.i.SUCCEEDED;	 Catch:{ Exception -> 0x00ec }
        r0 = r0.h;	 Catch:{ Exception -> 0x00ec }
        if (r4 == r0) goto L_0x0083;	 Catch:{ Exception -> 0x00ec }
    L_0x0066:
        r0 = com.alipay.sdk.app.i.PAY_WAITTING;	 Catch:{ Exception -> 0x00ec }
        r0 = r0.h;	 Catch:{ Exception -> 0x00ec }
        if (r4 != r0) goto L_0x006d;	 Catch:{ Exception -> 0x00ec }
    L_0x006c:
        goto L_0x0083;	 Catch:{ Exception -> 0x00ec }
    L_0x006d:
        r4 = com.alipay.sdk.app.i.FAILED;	 Catch:{ Exception -> 0x00ec }
        r4 = r4.h;	 Catch:{ Exception -> 0x00ec }
        r4 = com.alipay.sdk.app.i.a(r4);	 Catch:{ Exception -> 0x00ec }
        r5 = r4.h;	 Catch:{ Exception -> 0x00ec }
        r4 = r4.i;	 Catch:{ Exception -> 0x00ec }
        r0 = "";	 Catch:{ Exception -> 0x00ec }
        r4 = com.alipay.sdk.app.h.a(r5, r4, r0);	 Catch:{ Exception -> 0x00ec }
        com.alipay.sdk.app.h.a = r4;	 Catch:{ Exception -> 0x00ec }
        goto L_0x0100;	 Catch:{ Exception -> 0x00ec }
    L_0x0083:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ec }
        r0.<init>();	 Catch:{ Exception -> 0x00ec }
        r5 = java.net.URLDecoder.decode(r5);	 Catch:{ Exception -> 0x00ec }
        r2 = "sdklite://h5quit?result=";	 Catch:{ Exception -> 0x00ec }
        r2 = r5.indexOf(r2);	 Catch:{ Exception -> 0x00ec }
        r2 = r2 + 24;	 Catch:{ Exception -> 0x00ec }
        r3 = "&end_code=";	 Catch:{ Exception -> 0x00ec }
        r3 = r5.lastIndexOf(r3);	 Catch:{ Exception -> 0x00ec }
        r5 = r5.substring(r2, r3);	 Catch:{ Exception -> 0x00ec }
        r2 = "&return_url=";	 Catch:{ Exception -> 0x00ec }
        r2 = r5.contains(r2);	 Catch:{ Exception -> 0x00ec }
        if (r2 == 0) goto L_0x00dd;	 Catch:{ Exception -> 0x00ec }
    L_0x00a6:
        r2 = "&return_url=";	 Catch:{ Exception -> 0x00ec }
        r2 = r5.split(r2);	 Catch:{ Exception -> 0x00ec }
        r3 = 0;	 Catch:{ Exception -> 0x00ec }
        r2 = r2[r3];	 Catch:{ Exception -> 0x00ec }
        r3 = "&return_url=";	 Catch:{ Exception -> 0x00ec }
        r3 = r5.indexOf(r3);	 Catch:{ Exception -> 0x00ec }
        r3 = r3 + 12;	 Catch:{ Exception -> 0x00ec }
        r0.append(r2);	 Catch:{ Exception -> 0x00ec }
        r2 = "&return_url=";	 Catch:{ Exception -> 0x00ec }
        r0.append(r2);	 Catch:{ Exception -> 0x00ec }
        r2 = "\"&";	 Catch:{ Exception -> 0x00ec }
        r2 = r5.indexOf(r2, r3);	 Catch:{ Exception -> 0x00ec }
        r2 = r5.substring(r3, r2);	 Catch:{ Exception -> 0x00ec }
        r0.append(r2);	 Catch:{ Exception -> 0x00ec }
        r2 = "\"&";	 Catch:{ Exception -> 0x00ec }
        r2 = r5.indexOf(r2, r3);	 Catch:{ Exception -> 0x00ec }
        r5 = r5.substring(r2);	 Catch:{ Exception -> 0x00ec }
        r0.append(r5);	 Catch:{ Exception -> 0x00ec }
        r5 = r0.toString();	 Catch:{ Exception -> 0x00ec }
    L_0x00dd:
        r4 = com.alipay.sdk.app.i.a(r4);	 Catch:{ Exception -> 0x00ec }
        r0 = r4.h;	 Catch:{ Exception -> 0x00ec }
        r4 = r4.i;	 Catch:{ Exception -> 0x00ec }
        r4 = com.alipay.sdk.app.h.a(r0, r4, r5);	 Catch:{ Exception -> 0x00ec }
        com.alipay.sdk.app.h.a = r4;	 Catch:{ Exception -> 0x00ec }
        goto L_0x0100;
    L_0x00ec:
        r4 = com.alipay.sdk.app.i.PARAMS_ERROR;
        r4 = r4.h;
        r4 = com.alipay.sdk.app.i.a(r4);
        r5 = r4.h;
        r4 = r4.i;
        r0 = "";
        r4 = com.alipay.sdk.app.h.a(r5, r4, r0);
        com.alipay.sdk.app.h.a = r4;
    L_0x0100:
        r4 = new com.alipay.sdk.util.m;
        r4.<init>(r6);
        r6.runOnUiThread(r4);
        return r1;
    L_0x0109:
        r4.loadUrl(r5);
        return r1;
    L_0x010d:
        r4 = com.alipay.sdk.app.h.a();
        com.alipay.sdk.app.h.a = r4;
        r6.finish();
        return r1;
    L_0x0117:
        r4 = "com.eg.android.AlipayGphone";	 Catch:{ Throwable -> 0x0146 }
        r4 = a(r6, r4);	 Catch:{ Throwable -> 0x0146 }
        if (r4 == 0) goto L_0x0145;	 Catch:{ Throwable -> 0x0146 }
    L_0x011f:
        r4 = r4.a();	 Catch:{ Throwable -> 0x0146 }
        if (r4 == 0) goto L_0x0126;	 Catch:{ Throwable -> 0x0146 }
    L_0x0125:
        goto L_0x0145;	 Catch:{ Throwable -> 0x0146 }
    L_0x0126:
        r4 = "intent://platformapi/startapp";	 Catch:{ Throwable -> 0x0146 }
        r4 = r5.startsWith(r4);	 Catch:{ Throwable -> 0x0146 }
        if (r4 == 0) goto L_0x0136;	 Catch:{ Throwable -> 0x0146 }
    L_0x012e:
        r4 = "intent://platformapi/startapp\\?";	 Catch:{ Throwable -> 0x0146 }
        r0 = "alipays://platformapi/startApp?";	 Catch:{ Throwable -> 0x0146 }
        r5 = r5.replaceFirst(r4, r0);	 Catch:{ Throwable -> 0x0146 }
    L_0x0136:
        r4 = new android.content.Intent;	 Catch:{ Throwable -> 0x0146 }
        r0 = "android.intent.action.VIEW";	 Catch:{ Throwable -> 0x0146 }
        r5 = android.net.Uri.parse(r5);	 Catch:{ Throwable -> 0x0146 }
        r4.<init>(r0, r5);	 Catch:{ Throwable -> 0x0146 }
        r6.startActivity(r4);	 Catch:{ Throwable -> 0x0146 }
        goto L_0x0146;
    L_0x0145:
        return r1;
    L_0x0146:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.k.a(android.webkit.WebView, java.lang.String, android.app.Activity):boolean");
    }
}
