package com.alibaba.baichuan.android.a;

import android.os.Build.VERSION;
import com.alibaba.baichuan.android.trade.AlibcContext;

public final class d {
    private static boolean g = (VERSION.SDK_INT >= 19);
    g a;
    String b;
    String c;
    String d;
    boolean e = false;
    String f = null;

    public d(g gVar, String str, String str2, String str3) {
        this.a = gVar;
        this.b = str;
        this.c = str2;
        this.d = str3;
    }

    private static java.lang.String a(java.lang.String r2) {
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
        r0 = " ";
        r0 = r2.contains(r0);
        if (r0 == 0) goto L_0x0011;
    L_0x0008:
        r0 = " ";	 Catch:{ Exception -> 0x0011 }
        r1 = "\\u2028";	 Catch:{ Exception -> 0x0011 }
        r0 = r2.replace(r0, r1);	 Catch:{ Exception -> 0x0011 }
        r2 = r0;
    L_0x0011:
        r0 = " ";
        r0 = r2.contains(r0);
        if (r0 == 0) goto L_0x0022;
    L_0x0019:
        r0 = " ";	 Catch:{ Exception -> 0x0022 }
        r1 = "\\u2029";	 Catch:{ Exception -> 0x0022 }
        r0 = r2.replace(r0, r1);	 Catch:{ Exception -> 0x0022 }
        r2 = r0;
    L_0x0022:
        r0 = "\\";
        r1 = "\\\\";
        r2 = r2.replace(r0, r1);
        r0 = "'";
        r1 = "\\'";
        r2 = r2.replace(r0, r1);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.a.d.a(java.lang.String):java.lang.String");
    }

    private static void a(com.alibaba.baichuan.android.a.g r2, java.lang.String r3, java.lang.String r4) {
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
        r0 = com.alibaba.baichuan.android.trade.AlibcContext.b();
        if (r0 == 0) goto L_0x0027;
    L_0x0006:
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 != 0) goto L_0x0027;
    L_0x000c:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0012 }
        r0.<init>(r4);	 Catch:{ JSONException -> 0x0012 }
        goto L_0x0027;
    L_0x0012:
        r0 = new java.lang.StringBuilder;
        r1 = "return param is not a valid json!\n";
        r0.<init>(r1);
        r0.append(r3);
        r1 = "\n";
        r0.append(r1);
        r0.append(r4);
        com.alibaba.baichuan.android.trade.utils.g.a.b();
    L_0x0027:
        r0 = android.text.TextUtils.isEmpty(r4);
        if (r0 == 0) goto L_0x002f;
    L_0x002d:
        r4 = "{}";
    L_0x002f:
        r4 = a(r4);
        r0 = 1;
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x004a }
        r1 = 0;	 Catch:{ Exception -> 0x004a }
        r0[r1] = r4;	 Catch:{ Exception -> 0x004a }
        r3 = java.lang.String.format(r3, r0);	 Catch:{ Exception -> 0x004a }
        r4 = r2.a();	 Catch:{ Exception -> 0x004a }
        r0 = new com.alibaba.baichuan.android.a.i;	 Catch:{ Exception -> 0x004a }
        r0.<init>(r2, r3);	 Catch:{ Exception -> 0x004a }
        r4.post(r0);	 Catch:{ Exception -> 0x004a }
        return;
    L_0x004a:
        r2 = move-exception;
        r3 = new java.lang.StringBuilder;
        r4 = "callback error. ";
        r3.<init>(r4);
        r2 = r2.getMessage();
        r3.append(r2);
        com.alibaba.baichuan.android.trade.utils.g.a.b();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.a.d.a(com.alibaba.baichuan.android.a.g, java.lang.String, java.lang.String):void");
    }

    public final void a(e eVar) {
        a(this.a, String.format("javascript:window.AliBCBridge&&window.AliBCBridge.onSuccess(%s,'%%s');", new Object[]{this.b}), eVar.b());
    }

    public final void b(e eVar) {
        AlibcContext.b();
        a(this.a, String.format("javascript:window.AliBCBridge&&window.AliBCBridge.onFailure(%s,'%%s');", new Object[]{this.b}), eVar.b());
    }

    public static void a(android.webkit.WebView r4, java.lang.String r5) {
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
    L_0x0000:
        if (r4 == 0) goto L_0x0048;
    L_0x0002:
        r0 = 0;
        if (r5 == 0) goto L_0x0023;
    L_0x0005:
        r1 = r5.length();
        r2 = 10;
        if (r1 <= r2) goto L_0x0023;
    L_0x000d:
        r1 = "javascript:";
        r2 = 11;
        r3 = r5.substring(r0, r2);
        r3 = r3.toLowerCase();
        r1 = r1.equals(r3);
        if (r1 == 0) goto L_0x0023;
    L_0x001f:
        r5 = r5.substring(r2);
    L_0x0023:
        r1 = g;
        if (r1 == 0) goto L_0x0033;
    L_0x0027:
        r1 = 0;
        r4.evaluateJavascript(r5, r1);	 Catch:{ NoSuchMethodError -> 0x0030, NoSuchMethodError -> 0x0030, Throwable -> 0x002c }
        return;
    L_0x002c:
        com.alibaba.baichuan.android.trade.utils.g.a.a();
        return;
    L_0x0030:
        g = r0;
        goto L_0x0000;
    L_0x0033:
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0045 }
        r1 = "javascript:";	 Catch:{ Throwable -> 0x0045 }
        r0.<init>(r1);	 Catch:{ Throwable -> 0x0045 }
        r0.append(r5);	 Catch:{ Throwable -> 0x0045 }
        r5 = r0.toString();	 Catch:{ Throwable -> 0x0045 }
        r4.loadUrl(r5);	 Catch:{ Throwable -> 0x0045 }
        return;
    L_0x0045:
        com.alibaba.baichuan.android.trade.utils.g.a.a();
    L_0x0048:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.a.d.a(android.webkit.WebView, java.lang.String):void");
    }
}
