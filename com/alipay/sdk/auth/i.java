package com.alipay.sdk.auth;

import android.app.Activity;

final class i implements Runnable {
    final /* synthetic */ Activity a;
    final /* synthetic */ StringBuilder b;
    final /* synthetic */ APAuthInfo c;

    i(Activity activity, StringBuilder stringBuilder, APAuthInfo aPAuthInfo) {
        this.a = activity;
        this.b = stringBuilder;
        this.c = aPAuthInfo;
    }

    public final void run() {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r0 = new com.alipay.sdk.packet.impl.a;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0.<init>();	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = 0;
        r2 = r5.a;	 Catch:{ Throwable -> 0x0013 }
        r3 = r5.b;	 Catch:{ Throwable -> 0x0013 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x0013 }
        r0 = r0.a(r2, r3);	 Catch:{ Throwable -> 0x0013 }
        goto L_0x0014;
    L_0x0013:
        r0 = r1;
    L_0x0014:
        r1 = com.alipay.sdk.auth.h.c;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        if (r1 == 0) goto L_0x0024;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
    L_0x001a:
        r1 = com.alipay.sdk.auth.h.c;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1.b();	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        com.alipay.sdk.auth.h.c = null;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
    L_0x0024:
        if (r0 != 0) goto L_0x0057;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
    L_0x0026:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0.<init>();	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = r5.c;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = r1.getRedirectUri();	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0.append(r1);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = "?resultCode=202";	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0.append(r1);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = r0.toString();	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        com.alipay.sdk.auth.h.d = r0;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = r5.a;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = com.alipay.sdk.auth.h.d;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        com.alipay.sdk.auth.h.a(r0, r1);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = com.alipay.sdk.auth.h.c;
        if (r0 == 0) goto L_0x0056;
    L_0x004f:
        r0 = com.alipay.sdk.auth.h.c;
        r0.b();
    L_0x0056:
        return;
    L_0x0057:
        r0 = r0.a();	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = "form";	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = r0.optJSONObject(r1);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = "onload";	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = r0.optJSONObject(r1);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = com.alipay.sdk.protocol.b.a(r0);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = 0;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r2 = r1;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
    L_0x006d:
        r3 = r0.size();	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        if (r2 >= r3) goto L_0x0090;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
    L_0x0073:
        r3 = r0.get(r2);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r3 = (com.alipay.sdk.protocol.b) r3;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r3 = r3.a;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r4 = com.alipay.sdk.protocol.a.WapPay;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        if (r3 != r4) goto L_0x008d;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
    L_0x007f:
        r0 = r0.get(r2);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = (com.alipay.sdk.protocol.b) r0;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = r0.b;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = r0[r1];	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        com.alipay.sdk.auth.h.d = r0;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        goto L_0x0090;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
    L_0x008d:
        r2 = r2 + 1;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        goto L_0x006d;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
    L_0x0090:
        r0 = com.alipay.sdk.auth.h.d;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        if (r0 == 0) goto L_0x00cb;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
    L_0x009a:
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0.<init>();	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = r5.c;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = r1.getRedirectUri();	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0.append(r1);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = "?resultCode=202";	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0.append(r1);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = r0.toString();	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        com.alipay.sdk.auth.h.d = r0;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = r5.a;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = com.alipay.sdk.auth.h.d;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        com.alipay.sdk.auth.h.a(r0, r1);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = com.alipay.sdk.auth.h.c;
        if (r0 == 0) goto L_0x00ca;
    L_0x00c3:
        r0 = com.alipay.sdk.auth.h.c;
        r0.b();
    L_0x00ca:
        return;
    L_0x00cb:
        r0 = new android.content.Intent;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = r5.a;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r2 = com.alipay.sdk.auth.AuthActivity.class;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0.<init>(r1, r2);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = "params";	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r2 = com.alipay.sdk.auth.h.d;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0.putExtra(r1, r2);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = "redirectUri";	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r2 = r5.c;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r2 = r2.getRedirectUri();	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0.putExtra(r1, r2);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1 = r5.a;	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r1.startActivity(r0);	 Catch:{ Exception -> 0x010a, all -> 0x00fb }
        r0 = com.alipay.sdk.auth.h.c;
        if (r0 == 0) goto L_0x0111;
    L_0x00f3:
        r0 = com.alipay.sdk.auth.h.c;
        r0.b();
        return;
    L_0x00fb:
        r0 = move-exception;
        r1 = com.alipay.sdk.auth.h.c;
        if (r1 == 0) goto L_0x0109;
    L_0x0102:
        r1 = com.alipay.sdk.auth.h.c;
        r1.b();
    L_0x0109:
        throw r0;
    L_0x010a:
        r0 = com.alipay.sdk.auth.h.c;
        if (r0 == 0) goto L_0x0111;
    L_0x0110:
        goto L_0x00f3;
    L_0x0111:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.i.run():void");
    }
}
