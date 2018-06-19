package com.duiba.maila.sdk.a;

public final class b {
    private boolean a;

    public static class a {
        public static com.duiba.maila.sdk.a.b a(java.lang.String r3) {
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
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r0 = 0;
            if (r3 == 0) goto L_0x0049;
        L_0x0003:
            r1 = r3.trim();
            r1 = r1.isEmpty();
            if (r1 != 0) goto L_0x0049;
        L_0x000d:
            r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0028 }
            r1.<init>(r3);	 Catch:{ Exception -> 0x0028 }
            r3 = "success";	 Catch:{ Exception -> 0x0028 }
            r3 = r1.has(r3);	 Catch:{ Exception -> 0x0028 }
            if (r3 == 0) goto L_0x0021;	 Catch:{ Exception -> 0x0028 }
        L_0x001a:
            r3 = "success";	 Catch:{ Exception -> 0x0028 }
            r3 = r1.getBoolean(r3);	 Catch:{ Exception -> 0x0028 }
            goto L_0x0022;	 Catch:{ Exception -> 0x0028 }
        L_0x0021:
            r3 = 0;	 Catch:{ Exception -> 0x0028 }
        L_0x0022:
            r1 = new com.duiba.maila.sdk.a.b;	 Catch:{ Exception -> 0x0028 }
            r1.<init>(r3);	 Catch:{ Exception -> 0x0028 }
            return r1;
        L_0x0028:
            r3 = com.duiba.maila.sdk.util.e.a();
            r1 = "failed to parse JSON";
            r3 = r3.b();
            if (r3 == 0) goto L_0x0045;
        L_0x0034:
            r2 = new java.lang.StringBuilder;
            r2.<init>();
            r2.append(r3);
            r3 = " - ";
            r2.append(r3);
            r2.append(r1);
            goto L_0x0048;
        L_0x0045:
            r1.toString();
        L_0x0048:
            return r0;
        L_0x0049:
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.duiba.maila.sdk.a.b.a.a(java.lang.String):com.duiba.maila.sdk.a.b");
        }
    }

    public b(boolean z) {
        this.a = z;
    }
}
