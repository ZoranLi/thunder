package com.alibaba.mtl.log.a;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: HostConfigMgr */
public final class d {
    private static d b = new d();
    public Map<String, c> a = Collections.synchronizedMap(new HashMap());
    private String c;

    public static d a() {
        return b;
    }

    public final void a(java.lang.String r10) {
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
        r9 = this;
        r0 = "HostConfigMgr";
        r1 = 1;
        r2 = new java.lang.Object[r1];
        r3 = new java.lang.StringBuilder;
        r4 = "host config:";
        r3.<init>(r4);
        r3.append(r10);
        r3 = r3.toString();
        r4 = 0;
        r2[r4] = r3;
        com.alibaba.mtl.log.e.i.a(r0, r2);
        if (r10 == 0) goto L_0x009a;
    L_0x001b:
        r0 = new org.json.JSONObject;	 Catch:{ Throwable -> 0x009a }
        r0.<init>(r10);	 Catch:{ Throwable -> 0x009a }
        r10 = "content";	 Catch:{ Throwable -> 0x009a }
        r10 = r0.getJSONObject(r10);	 Catch:{ Throwable -> 0x009a }
        if (r10 == 0) goto L_0x0091;	 Catch:{ Throwable -> 0x009a }
    L_0x0028:
        r2 = "hosts";	 Catch:{ Throwable -> 0x009a }
        r10 = r10.getJSONObject(r2);	 Catch:{ Throwable -> 0x009a }
        if (r10 == 0) goto L_0x0091;	 Catch:{ Throwable -> 0x009a }
    L_0x0030:
        r2 = r10.keys();	 Catch:{ Throwable -> 0x009a }
    L_0x0034:
        r3 = r2.hasNext();	 Catch:{ Throwable -> 0x009a }
        if (r3 == 0) goto L_0x0091;	 Catch:{ Throwable -> 0x009a }
    L_0x003a:
        r3 = r2.next();	 Catch:{ Throwable -> 0x009a }
        r3 = (java.lang.String) r3;	 Catch:{ Throwable -> 0x009a }
        if (r3 == 0) goto L_0x0034;	 Catch:{ Throwable -> 0x009a }
    L_0x0042:
        r5 = new com.alibaba.mtl.log.a.c;	 Catch:{ Throwable -> 0x009a }
        r5.<init>();	 Catch:{ Throwable -> 0x009a }
        r6 = r10.getJSONObject(r3);	 Catch:{ Throwable -> 0x009a }
        if (r6 == 0) goto L_0x007d;	 Catch:{ Throwable -> 0x009a }
    L_0x004d:
        r3 = r3.substring(r1);	 Catch:{ Throwable -> 0x009a }
        r5.c = r3;	 Catch:{ Throwable -> 0x009a }
        r3 = "host";	 Catch:{ Throwable -> 0x009a }
        r3 = r6.getString(r3);	 Catch:{ Throwable -> 0x009a }
        r5.a = r3;	 Catch:{ Throwable -> 0x009a }
        r3 = "eids";	 Catch:{ Throwable -> 0x009a }
        r3 = r6.getJSONArray(r3);	 Catch:{ Throwable -> 0x009a }
        if (r3 == 0) goto L_0x007d;	 Catch:{ Throwable -> 0x009a }
    L_0x0063:
        r6 = new java.util.ArrayList;	 Catch:{ Throwable -> 0x009a }
        r6.<init>();	 Catch:{ Throwable -> 0x009a }
        r5.b = r6;	 Catch:{ Throwable -> 0x009a }
        r6 = r4;	 Catch:{ Throwable -> 0x009a }
    L_0x006b:
        r7 = r3.length();	 Catch:{ Throwable -> 0x009a }
        if (r6 >= r7) goto L_0x007d;	 Catch:{ Throwable -> 0x009a }
    L_0x0071:
        r7 = r5.b;	 Catch:{ Throwable -> 0x009a }
        r8 = r3.getString(r6);	 Catch:{ Throwable -> 0x009a }
        r7.add(r8);	 Catch:{ Throwable -> 0x009a }
        r6 = r6 + 1;	 Catch:{ Throwable -> 0x009a }
        goto L_0x006b;	 Catch:{ Throwable -> 0x009a }
    L_0x007d:
        r3 = r9.a;	 Catch:{ Throwable -> 0x009a }
        r6 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x009a }
        r6.<init>();	 Catch:{ Throwable -> 0x009a }
        r7 = r5.c;	 Catch:{ Throwable -> 0x009a }
        r6.append(r7);	 Catch:{ Throwable -> 0x009a }
        r6 = r6.toString();	 Catch:{ Throwable -> 0x009a }
        r3.put(r6, r5);	 Catch:{ Throwable -> 0x009a }
        goto L_0x0034;	 Catch:{ Throwable -> 0x009a }
    L_0x0091:
        r10 = "timestamp";	 Catch:{ Throwable -> 0x009a }
        r10 = r0.getString(r10);	 Catch:{ Throwable -> 0x009a }
        r9.c = r10;	 Catch:{ Throwable -> 0x009a }
        return;
    L_0x009a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.a.d.a(java.lang.String):void");
    }
}
