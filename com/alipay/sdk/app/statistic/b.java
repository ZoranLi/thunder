package com.alipay.sdk.app.statistic;

import android.content.Context;

final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;

    b(Context context, String str) {
        this.a = context;
        this.b = str;
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
        r4 = this;
        r0 = new com.alipay.sdk.packet.impl.c;
        r0.<init>();
        r1 = r4.a;	 Catch:{ Throwable -> 0x0023 }
        r2 = "alipay_cashier_statistic_record";	 Catch:{ Throwable -> 0x0023 }
        r3 = 0;	 Catch:{ Throwable -> 0x0023 }
        r1 = com.alipay.sdk.util.i.b(r1, r2, r3);	 Catch:{ Throwable -> 0x0023 }
        r2 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x0023 }
        if (r2 != 0) goto L_0x0023;	 Catch:{ Throwable -> 0x0023 }
    L_0x0014:
        r2 = r4.a;	 Catch:{ Throwable -> 0x0023 }
        r1 = r0.a(r2, r1);	 Catch:{ Throwable -> 0x0023 }
        if (r1 == 0) goto L_0x0023;	 Catch:{ Throwable -> 0x0023 }
    L_0x001c:
        r1 = r4.a;	 Catch:{ Throwable -> 0x0023 }
        r2 = "alipay_cashier_statistic_record";	 Catch:{ Throwable -> 0x0023 }
        com.alipay.sdk.util.i.a(r1, r2);	 Catch:{ Throwable -> 0x0023 }
    L_0x0023:
        r1 = r4.b;	 Catch:{ IOException -> 0x0034, Throwable -> 0x0033 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ IOException -> 0x0034, Throwable -> 0x0033 }
        if (r1 != 0) goto L_0x0032;	 Catch:{ IOException -> 0x0034, Throwable -> 0x0033 }
    L_0x002b:
        r1 = r4.a;	 Catch:{ IOException -> 0x0034, Throwable -> 0x0033 }
        r2 = r4.b;	 Catch:{ IOException -> 0x0034, Throwable -> 0x0033 }
        r0.a(r1, r2);	 Catch:{ IOException -> 0x0034, Throwable -> 0x0033 }
    L_0x0032:
        return;
    L_0x0033:
        return;
    L_0x0034:
        r0 = r4.a;
        r1 = "alipay_cashier_statistic_record";
        r2 = r4.b;
        com.alipay.sdk.util.i.a(r0, r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.statistic.b.run():void");
    }
}
