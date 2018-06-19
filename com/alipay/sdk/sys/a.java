package com.alipay.sdk.sys;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.sdk.util.k;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static final String a = "\"&";
    public static final String b = "&";
    public static final String c = "bizcontext=\"";
    public static final String d = "bizcontext=";
    public static final String e = "\"";
    public static final String f = "appkey";
    public static final String g = "ty";
    public static final String h = "sv";
    public static final String i = "an";
    public static final String j = "setting";
    public static final String k = "av";
    public static final String l = "sdk_start_time";
    public static final String m = "UTF-8";
    private String n = "";
    private String o = "";
    private Context p = null;

    public a(android.content.Context r4) {
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
        r3 = this;
        r3.<init>();
        r0 = "";
        r3.n = r0;
        r0 = "";
        r3.o = r0;
        r0 = 0;
        r3.p = r0;
        r0 = r4.getPackageManager();	 Catch:{ Exception -> 0x002a }
        r1 = r4.getPackageName();	 Catch:{ Exception -> 0x002a }
        r2 = 0;	 Catch:{ Exception -> 0x002a }
        r0 = r0.getPackageInfo(r1, r2);	 Catch:{ Exception -> 0x002a }
        r1 = r0.versionName;	 Catch:{ Exception -> 0x002a }
        r3.n = r1;	 Catch:{ Exception -> 0x002a }
        r0 = r0.packageName;	 Catch:{ Exception -> 0x002a }
        r3.o = r0;	 Catch:{ Exception -> 0x002a }
        r4 = r4.getApplicationContext();	 Catch:{ Exception -> 0x002a }
        r3.p = r4;	 Catch:{ Exception -> 0x002a }
        return;
    L_0x002a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.sys.a.<init>(android.content.Context):void");
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str) || str.startsWith("new_external_info==")) {
            return str;
        }
        if ((str.contains(a) ^ 1) != 0) {
            return c(str);
        }
        return d(str);
    }

    private static boolean b(String str) {
        return str.contains(a) == null ? true : null;
    }

    private java.lang.String c(java.lang.String r6) {
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
        r5 = this;
        r0 = "&";	 Catch:{ Throwable -> 0x0058 }
        r1 = "bizcontext=";	 Catch:{ Throwable -> 0x0058 }
        r0 = a(r6, r0, r1);	 Catch:{ Throwable -> 0x0058 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0058 }
        if (r1 == 0) goto L_0x002b;	 Catch:{ Throwable -> 0x0058 }
    L_0x000e:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0058 }
        r0.<init>();	 Catch:{ Throwable -> 0x0058 }
        r0.append(r6);	 Catch:{ Throwable -> 0x0058 }
        r1 = "&";	 Catch:{ Throwable -> 0x0058 }
        r0.append(r1);	 Catch:{ Throwable -> 0x0058 }
        r1 = "bizcontext=";	 Catch:{ Throwable -> 0x0058 }
        r2 = "";	 Catch:{ Throwable -> 0x0058 }
        r1 = r5.b(r1, r2);	 Catch:{ Throwable -> 0x0058 }
        r0.append(r1);	 Catch:{ Throwable -> 0x0058 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0058 }
        goto L_0x0059;	 Catch:{ Throwable -> 0x0058 }
    L_0x002b:
        r1 = r6.indexOf(r0);	 Catch:{ Throwable -> 0x0058 }
        r2 = 0;	 Catch:{ Throwable -> 0x0058 }
        r2 = r6.substring(r2, r1);	 Catch:{ Throwable -> 0x0058 }
        r3 = r0.length();	 Catch:{ Throwable -> 0x0058 }
        r1 = r1 + r3;	 Catch:{ Throwable -> 0x0058 }
        r1 = r6.substring(r1);	 Catch:{ Throwable -> 0x0058 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0058 }
        r3.<init>();	 Catch:{ Throwable -> 0x0058 }
        r3.append(r2);	 Catch:{ Throwable -> 0x0058 }
        r2 = "bizcontext=";	 Catch:{ Throwable -> 0x0058 }
        r4 = "";	 Catch:{ Throwable -> 0x0058 }
        r0 = r5.b(r0, r2, r4);	 Catch:{ Throwable -> 0x0058 }
        r3.append(r0);	 Catch:{ Throwable -> 0x0058 }
        r3.append(r1);	 Catch:{ Throwable -> 0x0058 }
        r0 = r3.toString();	 Catch:{ Throwable -> 0x0058 }
        goto L_0x0059;
    L_0x0058:
        r0 = r6;
    L_0x0059:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.sys.a.c(java.lang.String):java.lang.String");
    }

    private java.lang.String d(java.lang.String r6) {
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
        r5 = this;
        r0 = "\"&";	 Catch:{ Throwable -> 0x0071 }
        r1 = "bizcontext=\"";	 Catch:{ Throwable -> 0x0071 }
        r0 = a(r6, r0, r1);	 Catch:{ Throwable -> 0x0071 }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0071 }
        if (r1 == 0) goto L_0x002b;	 Catch:{ Throwable -> 0x0071 }
    L_0x000e:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0071 }
        r0.<init>();	 Catch:{ Throwable -> 0x0071 }
        r0.append(r6);	 Catch:{ Throwable -> 0x0071 }
        r1 = "&";	 Catch:{ Throwable -> 0x0071 }
        r0.append(r1);	 Catch:{ Throwable -> 0x0071 }
        r1 = "bizcontext=\"";	 Catch:{ Throwable -> 0x0071 }
        r2 = "\"";	 Catch:{ Throwable -> 0x0071 }
        r1 = r5.b(r1, r2);	 Catch:{ Throwable -> 0x0071 }
        r0.append(r1);	 Catch:{ Throwable -> 0x0071 }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x0071 }
        goto L_0x0072;	 Catch:{ Throwable -> 0x0071 }
    L_0x002b:
        r1 = "\"";	 Catch:{ Throwable -> 0x0071 }
        r1 = r0.endsWith(r1);	 Catch:{ Throwable -> 0x0071 }
        if (r1 != 0) goto L_0x0044;	 Catch:{ Throwable -> 0x0071 }
    L_0x0033:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0071 }
        r1.<init>();	 Catch:{ Throwable -> 0x0071 }
        r1.append(r0);	 Catch:{ Throwable -> 0x0071 }
        r0 = "\"";	 Catch:{ Throwable -> 0x0071 }
        r1.append(r0);	 Catch:{ Throwable -> 0x0071 }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x0071 }
    L_0x0044:
        r1 = r6.indexOf(r0);	 Catch:{ Throwable -> 0x0071 }
        r2 = 0;	 Catch:{ Throwable -> 0x0071 }
        r2 = r6.substring(r2, r1);	 Catch:{ Throwable -> 0x0071 }
        r3 = r0.length();	 Catch:{ Throwable -> 0x0071 }
        r1 = r1 + r3;	 Catch:{ Throwable -> 0x0071 }
        r1 = r6.substring(r1);	 Catch:{ Throwable -> 0x0071 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0071 }
        r3.<init>();	 Catch:{ Throwable -> 0x0071 }
        r3.append(r2);	 Catch:{ Throwable -> 0x0071 }
        r2 = "bizcontext=\"";	 Catch:{ Throwable -> 0x0071 }
        r4 = "\"";	 Catch:{ Throwable -> 0x0071 }
        r0 = r5.b(r0, r2, r4);	 Catch:{ Throwable -> 0x0071 }
        r3.append(r0);	 Catch:{ Throwable -> 0x0071 }
        r3.append(r1);	 Catch:{ Throwable -> 0x0071 }
        r0 = r3.toString();	 Catch:{ Throwable -> 0x0071 }
        goto L_0x0072;
    L_0x0071:
        r0 = r6;
    L_0x0072:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.sys.a.d(java.lang.String):java.lang.String");
    }

    private static String a(String str, String str2, String str3) {
        String str4 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        str = str.split(str2);
        str2 = null;
        while (str2 < str.length) {
            if (!TextUtils.isEmpty(str[str2]) && str[str2].startsWith(str3)) {
                str4 = str[str2];
                break;
            }
            str2++;
        }
        return str4;
    }

    private String b(String str, String str2) throws JSONException, UnsupportedEncodingException {
        String a = a("", "");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(a);
        stringBuilder.append(str2);
        return stringBuilder.toString();
    }

    public final java.lang.String a(java.lang.String r5, java.lang.String r6) {
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
        r4 = this;
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0051 }
        r0.<init>();	 Catch:{ Throwable -> 0x0051 }
        r1 = "appkey";	 Catch:{ Throwable -> 0x0051 }
        r2 = "2014052600006128";	 Catch:{ Throwable -> 0x0051 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0051 }
        r1 = "ty";	 Catch:{ Throwable -> 0x0051 }
        r2 = "and_lite";	 Catch:{ Throwable -> 0x0051 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0051 }
        r1 = "sv";	 Catch:{ Throwable -> 0x0051 }
        r2 = "h.a.3.2.0";	 Catch:{ Throwable -> 0x0051 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0051 }
        r1 = r4.o;	 Catch:{ Throwable -> 0x0051 }
        r2 = "setting";	 Catch:{ Throwable -> 0x0051 }
        r1 = r1.contains(r2);	 Catch:{ Throwable -> 0x0051 }
        if (r1 == 0) goto L_0x002c;	 Catch:{ Throwable -> 0x0051 }
    L_0x0024:
        r1 = r4.p;	 Catch:{ Throwable -> 0x0051 }
        r1 = com.alipay.sdk.util.k.c(r1);	 Catch:{ Throwable -> 0x0051 }
        if (r1 != 0) goto L_0x0033;	 Catch:{ Throwable -> 0x0051 }
    L_0x002c:
        r1 = "an";	 Catch:{ Throwable -> 0x0051 }
        r2 = r4.o;	 Catch:{ Throwable -> 0x0051 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0051 }
    L_0x0033:
        r1 = "av";	 Catch:{ Throwable -> 0x0051 }
        r2 = r4.n;	 Catch:{ Throwable -> 0x0051 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0051 }
        r1 = "sdk_start_time";	 Catch:{ Throwable -> 0x0051 }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Throwable -> 0x0051 }
        r0.put(r1, r2);	 Catch:{ Throwable -> 0x0051 }
        r1 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Throwable -> 0x0051 }
        if (r1 != 0) goto L_0x004c;	 Catch:{ Throwable -> 0x0051 }
    L_0x0049:
        r0.put(r5, r6);	 Catch:{ Throwable -> 0x0051 }
    L_0x004c:
        r5 = r0.toString();	 Catch:{ Throwable -> 0x0051 }
        return r5;
    L_0x0051:
        r5 = "";
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.sys.a.a(java.lang.String, java.lang.String):java.lang.String");
    }

    private String b(String str, String str2, String str3) throws JSONException, UnsupportedEncodingException {
        str = str.substring(str2.length());
        JSONObject jSONObject = new JSONObject(str.substring(0, str.length() - str3.length()));
        if (jSONObject.has("appkey") == null) {
            jSONObject.put("appkey", com.alipay.sdk.cons.a.c);
        }
        if (jSONObject.has(g) == null) {
            jSONObject.put(g, "and_lite");
        }
        if (jSONObject.has(h) == null) {
            jSONObject.put(h, com.alipay.sdk.cons.a.f);
        }
        if (jSONObject.has(i) == null && (this.o.contains(j) == null || k.c(this.p) == null)) {
            jSONObject.put(i, this.o);
        }
        if (jSONObject.has(k) == null) {
            jSONObject.put(k, this.n);
        }
        if (jSONObject.has(l) == null) {
            jSONObject.put(l, System.currentTimeMillis());
        }
        str = jSONObject.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str2);
        stringBuilder.append(str);
        stringBuilder.append(str3);
        return stringBuilder.toString();
    }
}
