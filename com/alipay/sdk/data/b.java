package com.alipay.sdk.data;

import android.content.Context;

final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ a b;

    b(a aVar, Context context) {
        this.b = aVar;
        this.a = context;
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
        r0 = new com.alipay.sdk.packet.impl.b;	 Catch:{ Throwable -> 0x0069 }
        r0.<init>();	 Catch:{ Throwable -> 0x0069 }
        r1 = r5.a;	 Catch:{ Throwable -> 0x0069 }
        r2 = "";	 Catch:{ Throwable -> 0x0069 }
        r3 = com.alipay.sdk.util.j.a(r1);	 Catch:{ Throwable -> 0x0069 }
        r4 = 1;	 Catch:{ Throwable -> 0x0069 }
        r0 = r0.a(r1, r2, r3, r4);	 Catch:{ Throwable -> 0x0069 }
        if (r0 == 0) goto L_0x0068;	 Catch:{ Throwable -> 0x0069 }
    L_0x0014:
        r1 = r5.b;	 Catch:{ Throwable -> 0x0069 }
        r0 = r0.b;	 Catch:{ Throwable -> 0x0069 }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x0069 }
        if (r2 != 0) goto L_0x0041;
    L_0x001e:
        r2 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x0041 }
        r2.<init>(r0);	 Catch:{ Throwable -> 0x0041 }
        r0 = "st_sdk_config";	 Catch:{ Throwable -> 0x0041 }
        r0 = r2.optJSONObject(r0);	 Catch:{ Throwable -> 0x0041 }
        r2 = "timeout";	 Catch:{ Throwable -> 0x0041 }
        r3 = 3500; // 0xdac float:4.905E-42 double:1.729E-320;	 Catch:{ Throwable -> 0x0041 }
        r2 = r0.optInt(r2, r3);	 Catch:{ Throwable -> 0x0041 }
        r1.i = r2;	 Catch:{ Throwable -> 0x0041 }
        r2 = "tbreturl";	 Catch:{ Throwable -> 0x0041 }
        r3 = "http://h5.m.taobao.com/trade/paySuccess.html?bizOrderId=$OrderId$&";	 Catch:{ Throwable -> 0x0041 }
        r0 = r0.optString(r2, r3);	 Catch:{ Throwable -> 0x0041 }
        r0 = r0.trim();	 Catch:{ Throwable -> 0x0041 }
        r1.j = r0;	 Catch:{ Throwable -> 0x0041 }
    L_0x0041:
        r0 = r5.b;	 Catch:{ Throwable -> 0x0069 }
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0068 }
        r1.<init>();	 Catch:{ Exception -> 0x0068 }
        r2 = "timeout";	 Catch:{ Exception -> 0x0068 }
        r3 = r0.a();	 Catch:{ Exception -> 0x0068 }
        r1.put(r2, r3);	 Catch:{ Exception -> 0x0068 }
        r2 = "tbreturl";	 Catch:{ Exception -> 0x0068 }
        r0 = r0.j;	 Catch:{ Exception -> 0x0068 }
        r1.put(r2, r0);	 Catch:{ Exception -> 0x0068 }
        r0 = com.alipay.sdk.sys.b.a();	 Catch:{ Exception -> 0x0068 }
        r0 = r0.a;	 Catch:{ Exception -> 0x0068 }
        r2 = "alipay_cashier_dynamic_config";	 Catch:{ Exception -> 0x0068 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x0068 }
        com.alipay.sdk.util.i.a(r0, r2, r1);	 Catch:{ Exception -> 0x0068 }
        return;
    L_0x0068:
        return;
    L_0x0069:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.data.b.run():void");
    }
}
