package com.alipay.sdk.auth;

import android.app.Activity;
import com.alipay.sdk.widget.a;

public final class h {
    private static final String a = "com.eg.android.AlipayGphone";
    private static final int b = 65;
    private static a c;
    private static String d;

    private static boolean a(android.content.Context r3) {
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
        r3 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0019 }
        r1 = "com.eg.android.AlipayGphone";	 Catch:{ NameNotFoundException -> 0x0019 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0019 }
        r3 = r3.getPackageInfo(r1, r2);	 Catch:{ NameNotFoundException -> 0x0019 }
        if (r3 != 0) goto L_0x0010;	 Catch:{ NameNotFoundException -> 0x0019 }
    L_0x000f:
        return r0;	 Catch:{ NameNotFoundException -> 0x0019 }
    L_0x0010:
        r3 = r3.versionCode;	 Catch:{ NameNotFoundException -> 0x0019 }
        r1 = 65;
        if (r3 >= r1) goto L_0x0017;
    L_0x0016:
        return r0;
    L_0x0017:
        r3 = 1;
        return r3;
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.h.a(android.content.Context):boolean");
    }

    public static void a(android.app.Activity r3, com.alipay.sdk.auth.APAuthInfo r4) {
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
        r0 = com.alipay.sdk.sys.b.a();
        com.alipay.sdk.data.c.a();
        r0.a(r3);
        r0 = a(r3);
        if (r0 == 0) goto L_0x0055;
    L_0x0010:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "alipayauth://platformapi/startapp";
        r0.append(r1);
        r1 = "?appId=20000122";
        r0.append(r1);
        r1 = "&approveType=005";
        r0.append(r1);
        r1 = "&scope=kuaijie";
        r0.append(r1);
        r1 = "&productId=";
        r0.append(r1);
        r1 = r4.getProductId();
        r0.append(r1);
        r1 = "&thirdpartyId=";
        r0.append(r1);
        r1 = r4.getAppId();
        r0.append(r1);
        r1 = "&redirectUri=";
        r0.append(r1);
        r4 = r4.getRedirectUri();
        r0.append(r4);
        r4 = r0.toString();
        a(r3, r4);
        return;
    L_0x0055:
        if (r3 == 0) goto L_0x006d;
    L_0x0057:
        r0 = r3.isFinishing();	 Catch:{ Exception -> 0x006a }
        if (r0 != 0) goto L_0x006d;	 Catch:{ Exception -> 0x006a }
    L_0x005d:
        r0 = new com.alipay.sdk.widget.a;	 Catch:{ Exception -> 0x006a }
        r1 = "正在加载";	 Catch:{ Exception -> 0x006a }
        r0.<init>(r3, r1);	 Catch:{ Exception -> 0x006a }
        c = r0;	 Catch:{ Exception -> 0x006a }
        r0.a();	 Catch:{ Exception -> 0x006a }
        goto L_0x006d;
    L_0x006a:
        r0 = 0;
        c = r0;
    L_0x006d:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "app_id=";
        r0.append(r1);
        r1 = r4.getAppId();
        r0.append(r1);
        r1 = "&partner=";
        r0.append(r1);
        r1 = r4.getPid();
        r0.append(r1);
        r1 = "&scope=kuaijie";
        r0.append(r1);
        r1 = "&login_goal=auth";
        r0.append(r1);
        r1 = "&redirect_url=";
        r0.append(r1);
        r1 = r4.getRedirectUri();
        r0.append(r1);
        r1 = "&view=wap";
        r0.append(r1);
        r1 = "&prod_code=";
        r0.append(r1);
        r1 = r4.getProductId();
        r0.append(r1);
        r1 = new java.lang.Thread;
        r2 = new com.alipay.sdk.auth.i;
        r2.<init>(r3, r0, r4);
        r1.<init>(r2);
        r1.start();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.h.a(android.app.Activity, com.alipay.sdk.auth.APAuthInfo):void");
    }

    private static void b(Activity activity, APAuthInfo aPAuthInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("alipayauth://platformapi/startapp");
        stringBuilder.append("?appId=20000122");
        stringBuilder.append("&approveType=005");
        stringBuilder.append("&scope=kuaijie");
        stringBuilder.append("&productId=");
        stringBuilder.append(aPAuthInfo.getProductId());
        stringBuilder.append("&thirdpartyId=");
        stringBuilder.append(aPAuthInfo.getAppId());
        stringBuilder.append("&redirectUri=");
        stringBuilder.append(aPAuthInfo.getRedirectUri());
        a(activity, stringBuilder.toString());
    }

    private static void c(android.app.Activity r3, com.alipay.sdk.auth.APAuthInfo r4) {
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
        if (r3 == 0) goto L_0x0018;
    L_0x0002:
        r0 = r3.isFinishing();	 Catch:{ Exception -> 0x0015 }
        if (r0 != 0) goto L_0x0018;	 Catch:{ Exception -> 0x0015 }
    L_0x0008:
        r0 = new com.alipay.sdk.widget.a;	 Catch:{ Exception -> 0x0015 }
        r1 = "正在加载";	 Catch:{ Exception -> 0x0015 }
        r0.<init>(r3, r1);	 Catch:{ Exception -> 0x0015 }
        c = r0;	 Catch:{ Exception -> 0x0015 }
        r0.a();	 Catch:{ Exception -> 0x0015 }
        goto L_0x0018;
    L_0x0015:
        r0 = 0;
        c = r0;
    L_0x0018:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "app_id=";
        r0.append(r1);
        r1 = r4.getAppId();
        r0.append(r1);
        r1 = "&partner=";
        r0.append(r1);
        r1 = r4.getPid();
        r0.append(r1);
        r1 = "&scope=kuaijie";
        r0.append(r1);
        r1 = "&login_goal=auth";
        r0.append(r1);
        r1 = "&redirect_url=";
        r0.append(r1);
        r1 = r4.getRedirectUri();
        r0.append(r1);
        r1 = "&view=wap";
        r0.append(r1);
        r1 = "&prod_code=";
        r0.append(r1);
        r1 = r4.getProductId();
        r0.append(r1);
        r1 = new java.lang.Thread;
        r2 = new com.alipay.sdk.auth.i;
        r2.<init>(r3, r0, r4);
        r1.<init>(r2);
        r1.start();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.h.c(android.app.Activity, com.alipay.sdk.auth.APAuthInfo):void");
    }

    public static void a(android.app.Activity r2, java.lang.String r3) {
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
        r0 = new android.content.Intent;	 Catch:{ ActivityNotFoundException -> 0x0012 }
        r1 = "android.intent.action.VIEW";	 Catch:{ ActivityNotFoundException -> 0x0012 }
        r0.<init>(r1);	 Catch:{ ActivityNotFoundException -> 0x0012 }
        r3 = android.net.Uri.parse(r3);	 Catch:{ ActivityNotFoundException -> 0x0012 }
        r0.setData(r3);	 Catch:{ ActivityNotFoundException -> 0x0012 }
        r2.startActivity(r0);	 Catch:{ ActivityNotFoundException -> 0x0012 }
        return;
    L_0x0012:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.h.a(android.app.Activity, java.lang.String):void");
    }
}
