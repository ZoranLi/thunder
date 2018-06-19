package com.alibaba.mtl.appmonitor.e;

/* compiled from: UTAggregationPlugin */
public final class a {
    private static final String a = null;
    private static a b;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    public static void a(java.util.Map<java.lang.String, java.lang.String> r7) {
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
        if (r7 != 0) goto L_0x0003;
    L_0x0002:
        return;
    L_0x0003:
        r0 = a;
        r1 = 3;
        r1 = new java.lang.Object[r1];
        r2 = "[sendToUT]:";
        r3 = 0;
        r1[r3] = r2;
        r2 = " args:";
        r4 = 1;
        r1[r4] = r2;
        r2 = 2;
        r1[r2] = r7;
        com.alibaba.mtl.log.e.i.a(r0, r1);
        r0 = com.alibaba.mtl.log.a.h;
        if (r0 == 0) goto L_0x0064;
    L_0x001c:
        if (r7 == 0) goto L_0x008d;
    L_0x001e:
        r0 = com.alibaba.mtl.log.model.LogField.ARG1;
        r0 = r0.toString();
        r0 = r7.get(r0);
        r3 = r0;
        r3 = (java.lang.String) r3;
        r0 = com.alibaba.mtl.log.model.LogField.ARG2;
        r0 = r0.toString();
        r0 = r7.get(r0);
        r4 = r0;
        r4 = (java.lang.String) r4;
        r0 = com.alibaba.mtl.log.model.LogField.ARG3;
        r0 = r0.toString();
        r0 = r7.get(r0);
        r5 = r0;
        r5 = (java.lang.String) r5;
        r0 = com.alibaba.mtl.log.model.LogField.PAGE;
        r0 = r0.toString();
        r0 = r7.get(r0);
        r1 = r0;
        r1 = (java.lang.String) r1;
        r0 = com.alibaba.mtl.log.model.LogField.EVENTID;
        r0 = r0.toString();
        r0 = r7.get(r0);
        r2 = r0;
        r2 = (java.lang.String) r2;
        r6 = r7;
        com.alibaba.mtl.log.a.a(r1, r2, r3, r4, r5, r6);
        return;
    L_0x0064:
        r0 = "_fuamf";
        r1 = "yes";
        r7.put(r0, r1);
        r0 = "com.ut.mini.UTAnalytics";	 Catch:{ Exception -> 0x008d }
        r1 = "getInstance";	 Catch:{ Exception -> 0x008d }
        r0 = com.alibaba.mtl.log.e.o.a(r0, r1);	 Catch:{ Exception -> 0x008d }
        if (r0 == 0) goto L_0x008c;	 Catch:{ Exception -> 0x008d }
    L_0x0075:
        r1 = "getDefaultTracker";	 Catch:{ Exception -> 0x008d }
        r0 = com.alibaba.mtl.log.e.o.a(r0, r1);	 Catch:{ Exception -> 0x008d }
        if (r0 == 0) goto L_0x008c;	 Catch:{ Exception -> 0x008d }
    L_0x007d:
        r1 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x008d }
        r1[r3] = r7;	 Catch:{ Exception -> 0x008d }
        r7 = "send";	 Catch:{ Exception -> 0x008d }
        r2 = new java.lang.Class[r4];	 Catch:{ Exception -> 0x008d }
        r4 = java.util.Map.class;	 Catch:{ Exception -> 0x008d }
        r2[r3] = r4;	 Catch:{ Exception -> 0x008d }
        com.alibaba.mtl.log.e.o.a(r0, r7, r1, r2);	 Catch:{ Exception -> 0x008d }
    L_0x008c:
        return;
    L_0x008d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.appmonitor.e.a.a(java.util.Map):void");
    }
}
