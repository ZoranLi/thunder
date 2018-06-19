package com.alipay.sdk.authjs;

final class d implements Runnable {
    final /* synthetic */ a a;
    final /* synthetic */ c b;

    d(c cVar, a aVar) {
        this.b = cVar;
        this.a = aVar;
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
        r6 = this;
        r0 = r6.b;
        r1 = r6.a;
        if (r1 == 0) goto L_0x003b;
    L_0x0006:
        r2 = "toast";
        r3 = r1.k;
        r2 = r2.equals(r3);
        if (r2 == 0) goto L_0x003b;
    L_0x0010:
        r2 = r1.m;
        r3 = "content";
        r3 = r2.optString(r3);
        r4 = "duration";
        r2 = r2.optInt(r4);
        r4 = 1;
        r5 = 2500; // 0x9c4 float:3.503E-42 double:1.235E-320;
        if (r2 >= r5) goto L_0x0024;
    L_0x0023:
        r4 = 0;
    L_0x0024:
        r2 = r0.b;
        r2 = android.widget.Toast.makeText(r2, r3, r4);
        r2.show();
        r2 = new java.util.Timer;
        r2.<init>();
        r3 = new com.alipay.sdk.authjs.e;
        r3.<init>(r0, r1);
        r0 = (long) r4;
        r2.schedule(r3, r0);
    L_0x003b:
        r0 = com.alipay.sdk.authjs.a.a.a;
        r1 = com.alipay.sdk.authjs.a.a.a;
        if (r0 == r1) goto L_0x004b;
    L_0x0041:
        r1 = r6.b;	 Catch:{ JSONException -> 0x004b }
        r2 = r6.a;	 Catch:{ JSONException -> 0x004b }
        r2 = r2.i;	 Catch:{ JSONException -> 0x004b }
        r1.a(r2, r0);	 Catch:{ JSONException -> 0x004b }
        return;
    L_0x004b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.authjs.d.run():void");
    }
}
