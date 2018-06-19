package com.alipay.sdk.authjs;

import java.util.TimerTask;

final class e extends TimerTask {
    final /* synthetic */ a a;
    final /* synthetic */ c b;

    e(c cVar, a aVar) {
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
        r3 = this;
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = "toastCallBack";	 Catch:{ JSONException -> 0x000c }
        r2 = "true";	 Catch:{ JSONException -> 0x000c }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x000c }
    L_0x000c:
        r1 = new com.alipay.sdk.authjs.a;
        r2 = "callback";
        r1.<init>(r2);
        r2 = r3.a;
        r2 = r2.i;
        r1.i = r2;
        r1.m = r0;
        r0 = r3.b;
        r0 = r0.a;
        r0.a(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.authjs.e.run():void");
    }
}
