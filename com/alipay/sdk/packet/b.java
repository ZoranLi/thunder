package com.alipay.sdk.packet;

public final class b {
    String a;
    public String b;

    public b(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    private String b() {
        return this.a;
    }

    private void a(String str) {
        this.a = str;
    }

    private String c() {
        return this.b;
    }

    private void b(String str) {
        this.b = str;
    }

    public final org.json.JSONObject a() {
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
        r0 = r3.b;
        r0 = android.text.TextUtils.isEmpty(r0);
        r1 = 0;
        if (r0 == 0) goto L_0x000a;
    L_0x0009:
        return r1;
    L_0x000a:
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0012 }
        r2 = r3.b;	 Catch:{ Exception -> 0x0012 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x0012 }
        goto L_0x0013;
    L_0x0012:
        r0 = r1;
    L_0x0013:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.packet.b.a():org.json.JSONObject");
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("\nenvelop:");
        stringBuilder.append(this.a);
        stringBuilder.append("\nbody:");
        stringBuilder.append(this.b);
        return stringBuilder.toString();
    }
}
