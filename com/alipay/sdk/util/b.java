package com.alipay.sdk.util;

public final class b {
    public static org.json.JSONObject a(org.json.JSONObject r6, org.json.JSONObject r7) {
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
        r0 = new org.json.JSONObject;
        r0.<init>();
        r1 = 2;
        r2 = new org.json.JSONObject[r1];	 Catch:{ JSONException -> 0x002f }
        r3 = 0;	 Catch:{ JSONException -> 0x002f }
        r2[r3] = r6;	 Catch:{ JSONException -> 0x002f }
        r6 = 1;	 Catch:{ JSONException -> 0x002f }
        r2[r6] = r7;	 Catch:{ JSONException -> 0x002f }
    L_0x000e:
        if (r3 >= r1) goto L_0x002f;	 Catch:{ JSONException -> 0x002f }
    L_0x0010:
        r6 = r2[r3];	 Catch:{ JSONException -> 0x002f }
        if (r6 == 0) goto L_0x002c;	 Catch:{ JSONException -> 0x002f }
    L_0x0014:
        r7 = r6.keys();	 Catch:{ JSONException -> 0x002f }
    L_0x0018:
        r4 = r7.hasNext();	 Catch:{ JSONException -> 0x002f }
        if (r4 == 0) goto L_0x002c;	 Catch:{ JSONException -> 0x002f }
    L_0x001e:
        r4 = r7.next();	 Catch:{ JSONException -> 0x002f }
        r4 = (java.lang.String) r4;	 Catch:{ JSONException -> 0x002f }
        r5 = r6.get(r4);	 Catch:{ JSONException -> 0x002f }
        r0.put(r4, r5);	 Catch:{ JSONException -> 0x002f }
        goto L_0x0018;
    L_0x002c:
        r3 = r3 + 1;
        goto L_0x000e;
    L_0x002f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.b.a(org.json.JSONObject, org.json.JSONObject):org.json.JSONObject");
    }
}
