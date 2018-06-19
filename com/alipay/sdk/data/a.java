package com.alipay.sdk.data;

import android.content.Context;

public final class a {
    public static final int a = 3500;
    public static final String b = "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&";
    public static final int c = 1000;
    public static final int d = 20000;
    public static final String e = "alipay_cashier_dynamic_config";
    public static final String f = "timeout";
    public static final String g = "st_sdk_config";
    public static final String h = "tbreturl";
    private static a k;
    int i = a;
    public String j = b;

    private static /* synthetic */ void a(com.alipay.sdk.data.a r3) {
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
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0024 }
        r0.<init>();	 Catch:{ Exception -> 0x0024 }
        r1 = "timeout";	 Catch:{ Exception -> 0x0024 }
        r2 = r3.a();	 Catch:{ Exception -> 0x0024 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0024 }
        r1 = "tbreturl";	 Catch:{ Exception -> 0x0024 }
        r3 = r3.j;	 Catch:{ Exception -> 0x0024 }
        r0.put(r1, r3);	 Catch:{ Exception -> 0x0024 }
        r3 = com.alipay.sdk.sys.b.a();	 Catch:{ Exception -> 0x0024 }
        r3 = r3.a;	 Catch:{ Exception -> 0x0024 }
        r1 = "alipay_cashier_dynamic_config";	 Catch:{ Exception -> 0x0024 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0024 }
        com.alipay.sdk.util.i.a(r3, r1, r0);	 Catch:{ Exception -> 0x0024 }
    L_0x0024:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.data.a.a(com.alipay.sdk.data.a):void");
    }

    private static /* synthetic */ void a(com.alipay.sdk.data.a r2, java.lang.String r3) {
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
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 != 0) goto L_0x0029;
    L_0x0006:
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0029 }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x0029 }
        r3 = "st_sdk_config";	 Catch:{ Throwable -> 0x0029 }
        r3 = r0.optJSONObject(r3);	 Catch:{ Throwable -> 0x0029 }
        r0 = "timeout";	 Catch:{ Throwable -> 0x0029 }
        r1 = 3500; // 0xdac float:4.905E-42 double:1.729E-320;	 Catch:{ Throwable -> 0x0029 }
        r0 = r3.optInt(r0, r1);	 Catch:{ Throwable -> 0x0029 }
        r2.i = r0;	 Catch:{ Throwable -> 0x0029 }
        r0 = "tbreturl";	 Catch:{ Throwable -> 0x0029 }
        r1 = "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&";	 Catch:{ Throwable -> 0x0029 }
        r3 = r3.optString(r0, r1);	 Catch:{ Throwable -> 0x0029 }
        r3 = r3.trim();	 Catch:{ Throwable -> 0x0029 }
        r2.j = r3;	 Catch:{ Throwable -> 0x0029 }
    L_0x0029:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.data.a.a(com.alipay.sdk.data.a, java.lang.String):void");
    }

    public final int a() {
        if (this.i >= 1000) {
            if (this.i <= 20000) {
                new StringBuilder("DynamicConfig::getJumpTimeout >").append(this.i);
                return this.i;
            }
        }
        return a;
    }

    private String c() {
        return this.j;
    }

    public static com.alipay.sdk.data.a b() {
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
        r0 = k;
        if (r0 != 0) goto L_0x003b;
    L_0x0004:
        r0 = new com.alipay.sdk.data.a;
        r0.<init>();
        k = r0;
        r1 = com.alipay.sdk.sys.b.a();
        r1 = r1.a;
        r2 = "alipay_cashier_dynamic_config";
        r3 = 0;
        r1 = com.alipay.sdk.util.i.b(r1, r2, r3);
        r2 = android.text.TextUtils.isEmpty(r1);
        if (r2 != 0) goto L_0x003b;
    L_0x001e:
        r2 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x003b }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x003b }
        r1 = "timeout";	 Catch:{ Throwable -> 0x003b }
        r3 = 3500; // 0xdac float:4.905E-42 double:1.729E-320;	 Catch:{ Throwable -> 0x003b }
        r1 = r2.optInt(r1, r3);	 Catch:{ Throwable -> 0x003b }
        r0.i = r1;	 Catch:{ Throwable -> 0x003b }
        r1 = "tbreturl";	 Catch:{ Throwable -> 0x003b }
        r3 = "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&";	 Catch:{ Throwable -> 0x003b }
        r1 = r2.optString(r1, r3);	 Catch:{ Throwable -> 0x003b }
        r1 = r1.trim();	 Catch:{ Throwable -> 0x003b }
        r0.j = r1;	 Catch:{ Throwable -> 0x003b }
    L_0x003b:
        r0 = k;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.data.a.b():com.alipay.sdk.data.a");
    }

    private void d() {
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
        r0 = com.alipay.sdk.sys.b.a();
        r0 = r0.a;
        r1 = "alipay_cashier_dynamic_config";
        r2 = 0;
        r0 = com.alipay.sdk.util.i.b(r0, r1, r2);
        r1 = android.text.TextUtils.isEmpty(r0);
        if (r1 != 0) goto L_0x0031;
    L_0x0013:
        r1 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0031 }
        r1.<init>(r0);	 Catch:{ Throwable -> 0x0031 }
        r0 = "timeout";	 Catch:{ Throwable -> 0x0031 }
        r2 = 3500; // 0xdac float:4.905E-42 double:1.729E-320;	 Catch:{ Throwable -> 0x0031 }
        r0 = r1.optInt(r0, r2);	 Catch:{ Throwable -> 0x0031 }
        r3.i = r0;	 Catch:{ Throwable -> 0x0031 }
        r0 = "tbreturl";	 Catch:{ Throwable -> 0x0031 }
        r2 = "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&";	 Catch:{ Throwable -> 0x0031 }
        r0 = r1.optString(r0, r2);	 Catch:{ Throwable -> 0x0031 }
        r0 = r0.trim();	 Catch:{ Throwable -> 0x0031 }
        r3.j = r0;	 Catch:{ Throwable -> 0x0031 }
        return;
    L_0x0031:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.data.a.d():void");
    }

    private void a(java.lang.String r3) {
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
        r2 = this;
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0025 }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x0025 }
        r3 = "timeout";	 Catch:{ Throwable -> 0x0025 }
        r1 = 3500; // 0xdac float:4.905E-42 double:1.729E-320;	 Catch:{ Throwable -> 0x0025 }
        r3 = r0.optInt(r3, r1);	 Catch:{ Throwable -> 0x0025 }
        r2.i = r3;	 Catch:{ Throwable -> 0x0025 }
        r3 = "tbreturl";	 Catch:{ Throwable -> 0x0025 }
        r1 = "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&";	 Catch:{ Throwable -> 0x0025 }
        r3 = r0.optString(r3, r1);	 Catch:{ Throwable -> 0x0025 }
        r3 = r3.trim();	 Catch:{ Throwable -> 0x0025 }
        r2.j = r3;	 Catch:{ Throwable -> 0x0025 }
        return;
    L_0x0025:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.data.a.a(java.lang.String):void");
    }

    private void e() {
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
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0025 }
        r0.<init>();	 Catch:{ Exception -> 0x0025 }
        r1 = "timeout";	 Catch:{ Exception -> 0x0025 }
        r2 = r3.a();	 Catch:{ Exception -> 0x0025 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0025 }
        r1 = "tbreturl";	 Catch:{ Exception -> 0x0025 }
        r2 = r3.j;	 Catch:{ Exception -> 0x0025 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0025 }
        r1 = com.alipay.sdk.sys.b.a();	 Catch:{ Exception -> 0x0025 }
        r1 = r1.a;	 Catch:{ Exception -> 0x0025 }
        r2 = "alipay_cashier_dynamic_config";	 Catch:{ Exception -> 0x0025 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0025 }
        com.alipay.sdk.util.i.a(r1, r2, r0);	 Catch:{ Exception -> 0x0025 }
        return;
    L_0x0025:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.data.a.e():void");
    }

    private void b(java.lang.String r3) {
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
        r2 = this;
        r0 = android.text.TextUtils.isEmpty(r3);
        if (r0 == 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x002b }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x002b }
        r3 = "st_sdk_config";	 Catch:{ Throwable -> 0x002b }
        r3 = r0.optJSONObject(r3);	 Catch:{ Throwable -> 0x002b }
        r0 = "timeout";	 Catch:{ Throwable -> 0x002b }
        r1 = 3500; // 0xdac float:4.905E-42 double:1.729E-320;	 Catch:{ Throwable -> 0x002b }
        r0 = r3.optInt(r0, r1);	 Catch:{ Throwable -> 0x002b }
        r2.i = r0;	 Catch:{ Throwable -> 0x002b }
        r0 = "tbreturl";	 Catch:{ Throwable -> 0x002b }
        r1 = "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&";	 Catch:{ Throwable -> 0x002b }
        r3 = r3.optString(r0, r1);	 Catch:{ Throwable -> 0x002b }
        r3 = r3.trim();	 Catch:{ Throwable -> 0x002b }
        r2.j = r3;	 Catch:{ Throwable -> 0x002b }
        return;
    L_0x002b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.data.a.b(java.lang.String):void");
    }

    public final void a(Context context) {
        new Thread(new b(this, context)).start();
    }
}
