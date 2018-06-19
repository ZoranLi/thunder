package com.alibaba.mtl.appmonitor.a;

/* compiled from: CountEvent */
public class b extends d {
    public int a;
    public double b;

    public final synchronized void a(double d) {
        this.b += d;
        this.a++;
    }

    public final synchronized org.json.JSONObject c() {
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
        r4 = this;
        monitor-enter(r4);
        r0 = super.c();	 Catch:{ all -> 0x0015 }
        r1 = "count";	 Catch:{ Exception -> 0x0013 }
        r2 = r4.a;	 Catch:{ Exception -> 0x0013 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0013 }
        r1 = "value";	 Catch:{ Exception -> 0x0013 }
        r2 = r4.b;	 Catch:{ Exception -> 0x0013 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0013 }
    L_0x0013:
        monitor-exit(r4);
        return r0;
    L_0x0015:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.a.b.c():org.json.JSONObject");
    }

    public final synchronized void a(Object... objArr) {
        super.a(objArr);
        this.b = 0.0d;
        this.a = null;
    }
}
