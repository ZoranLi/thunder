package com.alibaba.mtl.appmonitor.d;

import org.json.JSONObject;

/* compiled from: AbstractSampling */
public abstract class a<T extends JSONObject> {
    protected int a;

    public a(int i) {
        this.a = i;
    }

    protected void a(T r2) {
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
        r1 = this;
        r0 = "sampling";	 Catch:{ Exception -> 0x0013 }
        r2 = r2.getInt(r0);	 Catch:{ Exception -> 0x0013 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ Exception -> 0x0013 }
        if (r2 == 0) goto L_0x0012;	 Catch:{ Exception -> 0x0013 }
    L_0x000c:
        r2 = r2.intValue();	 Catch:{ Exception -> 0x0013 }
        r1.a = r2;	 Catch:{ Exception -> 0x0013 }
    L_0x0012:
        return;
    L_0x0013:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.d.a.a(org.json.JSONObject):void");
    }

    protected final boolean a(int i) {
        return i < this.a;
    }
}
