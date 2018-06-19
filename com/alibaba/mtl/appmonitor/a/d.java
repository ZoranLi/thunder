package com.alibaba.mtl.appmonitor.a;

import com.alibaba.mtl.appmonitor.c.b;

/* compiled from: Event */
public abstract class d implements b {
    public String f;
    public String g;
    public String h;
    public int i;

    public org.json.JSONObject c() {
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
        r0 = com.alibaba.mtl.appmonitor.c.a.a();
        r1 = com.alibaba.mtl.appmonitor.c.e.class;
        r2 = 0;
        r2 = new java.lang.Object[r2];
        r0 = r0.a(r1, r2);
        r0 = (org.json.JSONObject) r0;
        r1 = "page";	 Catch:{ JSONException -> 0x0028 }
        r2 = r3.f;	 Catch:{ JSONException -> 0x0028 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0028 }
        r1 = "monitorPoint";	 Catch:{ JSONException -> 0x0028 }
        r2 = r3.g;	 Catch:{ JSONException -> 0x0028 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0028 }
        r1 = r3.h;	 Catch:{ JSONException -> 0x0028 }
        if (r1 == 0) goto L_0x0028;	 Catch:{ JSONException -> 0x0028 }
    L_0x0021:
        r1 = "arg";	 Catch:{ JSONException -> 0x0028 }
        r2 = r3.h;	 Catch:{ JSONException -> 0x0028 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0028 }
    L_0x0028:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.a.d.c():org.json.JSONObject");
    }

    public void d() {
        this.i = 0;
        this.f = null;
        this.g = null;
        this.h = null;
    }

    public void a(Object... objArr) {
        this.i = ((Integer) objArr[0]).intValue();
        this.f = (String) objArr[1];
        this.g = (String) objArr[2];
        if (objArr.length > 3 && objArr[3] != null) {
            this.h = (String) objArr[3];
        }
    }
}
