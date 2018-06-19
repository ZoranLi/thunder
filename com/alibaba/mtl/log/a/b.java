package com.alibaba.mtl.log.a;

/* compiled from: GcConfigChannelMgr */
public final class b {
    private static b a = new b();
    private static String b = "http://adashx.m.taobao.com/rest/gc2";

    /* compiled from: GcConfigChannelMgr */
    class a implements Runnable {
        final /* synthetic */ b a;

        a(b bVar) {
            this.a = bVar;
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
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r8 = this;
            r0 = com.alibaba.mtl.log.e.l.b();
            if (r0 != 0) goto L_0x0007;
        L_0x0006:
            return;
        L_0x0007:
            r0 = 0;
            r1 = r0;
        L_0x0009:
            r2 = 8;
            if (r1 >= r2) goto L_0x006e;
        L_0x000d:
            r2 = new java.util.HashMap;
            r2.<init>();
            r3 = "b01n15";
            r3 = com.alibaba.mtl.log.a.a.c(r3);
            r4 = "b01na";
            r4 = com.alibaba.mtl.log.a.a.c(r4);
            r5 = "_b01n15";
            r2.put(r5, r3);
            r3 = "_b01na";
            r2.put(r3, r4);
            r3 = com.alibaba.mtl.log.a.b.b;	 Catch:{ Exception -> 0x0062 }
            r2 = com.alibaba.mtl.log.e.t.b(r3, r2);	 Catch:{ Exception -> 0x0062 }
            r3 = "ConfigMgr";	 Catch:{ Exception -> 0x0062 }
            r4 = 1;	 Catch:{ Exception -> 0x0062 }
            r5 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0062 }
            r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0062 }
            r7 = "config:";	 Catch:{ Exception -> 0x0062 }
            r6.<init>(r7);	 Catch:{ Exception -> 0x0062 }
            r6.append(r2);	 Catch:{ Exception -> 0x0062 }
            r6 = r6.toString();	 Catch:{ Exception -> 0x0062 }
            r5[r0] = r6;	 Catch:{ Exception -> 0x0062 }
            com.alibaba.mtl.log.e.i.a(r3, r5);	 Catch:{ Exception -> 0x0062 }
            r3 = 0;	 Catch:{ Exception -> 0x0062 }
            r2 = com.alibaba.mtl.log.e.e.a(r4, r2, r3);	 Catch:{ Exception -> 0x0062 }
            r3 = r2.b;	 Catch:{ Exception -> 0x0062 }
            if (r3 == 0) goto L_0x0066;	 Catch:{ Exception -> 0x0062 }
        L_0x0051:
            r3 = new java.lang.String;	 Catch:{ Exception -> 0x0062 }
            r4 = r2.b;	 Catch:{ Exception -> 0x0062 }
            r2 = r2.b;	 Catch:{ Exception -> 0x0062 }
            r2 = r2.length;	 Catch:{ Exception -> 0x0062 }
            r3.<init>(r4, r0, r2);	 Catch:{ Exception -> 0x0062 }
            com.alibaba.mtl.log.a.a.b(r3);	 Catch:{ Exception -> 0x0062 }
            com.alibaba.mtl.log.a.a.f();	 Catch:{ Exception -> 0x0062 }
            return;
        L_0x0062:
            r2 = move-exception;
            r2.printStackTrace();
        L_0x0066:
            r2 = 10000; // 0x2710 float:1.4013E-41 double:4.9407E-320;
            java.lang.Thread.sleep(r2);	 Catch:{ Exception -> 0x006b }
        L_0x006b:
            r1 = r1 + 1;
            goto L_0x0009;
        L_0x006e:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.a.b.a.run():void");
        }
    }

    public static b a() {
        return a;
    }
}
