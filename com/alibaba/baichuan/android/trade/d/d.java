package com.alibaba.baichuan.android.trade.d;

public class d {
    private static final String a = "d";

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r4, com.alibaba.baichuan.android.trade.model.ApplinkOpenType r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.util.Map r11) {
        /*
        if (r11 != 0) goto L_0x0007;
    L_0x0002:
        r11 = new java.util.HashMap;
        r11.<init>();
    L_0x0007:
        r0 = 0;
        r1 = r11.entrySet();	 Catch:{ JSONException -> 0x0040 }
        r1 = r1.iterator();	 Catch:{ JSONException -> 0x0040 }
        r2 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0040 }
        r2.<init>();	 Catch:{ JSONException -> 0x0040 }
    L_0x0015:
        r0 = r1.hasNext();	 Catch:{ JSONException -> 0x003e }
        if (r0 == 0) goto L_0x002f;
    L_0x001b:
        r0 = r1.next();	 Catch:{ JSONException -> 0x003e }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ JSONException -> 0x003e }
        r3 = r0.getKey();	 Catch:{ JSONException -> 0x003e }
        r3 = (java.lang.String) r3;	 Catch:{ JSONException -> 0x003e }
        r0 = r0.getValue();	 Catch:{ JSONException -> 0x003e }
        r2.put(r3, r0);	 Catch:{ JSONException -> 0x003e }
        goto L_0x0015;
    L_0x002f:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x003e }
        r0.<init>();	 Catch:{ JSONException -> 0x003e }
        r1 = "params";
        r3 = r2.toString();	 Catch:{ JSONException -> 0x003e }
        r0.put(r1, r3);	 Catch:{ JSONException -> 0x003e }
        goto L_0x0046;
    L_0x003e:
        r0 = move-exception;
        goto L_0x0043;
    L_0x0040:
        r1 = move-exception;
        r2 = r0;
        r0 = r1;
    L_0x0043:
        r0.printStackTrace();
    L_0x0046:
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "backURL";
        r0.put(r1, r10);
        r1 = "pid";
        r0.put(r1, r9);
        r9 = "tag";
        r0.put(r9, r8);
        r8 = "TTID";
        r9 = com.alibaba.baichuan.android.trade.e.a.g();
        r9 = r9.e();
        r0.put(r8, r9);
        r8 = "source";
        r9 = "bc";
        r0.put(r8, r9);
        r8 = "utdid";
        r9 = com.alibaba.baichuan.android.trade.AlibcContext.a();
        r0.put(r8, r9);
        r8 = com.alibaba.baichuan.android.trade.adapter.b.a.a();
        r8.b();
        r9 = r8.a;
        if (r9 == 0) goto L_0x00e8;
    L_0x0082:
        r8 = r8.a;
        r8 = r8.sOpenParam;
        if (r8 == 0) goto L_0x00e8;
    L_0x0088:
        r9 = "backURL";
        r9 = r0.get(r9);
        r9 = (java.lang.String) r9;
        r1 = android.text.TextUtils.isEmpty(r9);
        if (r1 != 0) goto L_0x0098;
    L_0x0096:
        r8.mBackUrl = r9;
    L_0x0098:
        r9 = "pid";
        r9 = r0.get(r9);
        r9 = (java.lang.String) r9;
        r1 = android.text.TextUtils.isEmpty(r9);
        if (r1 != 0) goto L_0x00a8;
    L_0x00a6:
        r8.mPid = r9;
    L_0x00a8:
        r9 = "tag";
        r9 = r0.get(r9);
        r9 = (java.lang.String) r9;
        r1 = android.text.TextUtils.isEmpty(r9);
        if (r1 != 0) goto L_0x00b8;
    L_0x00b6:
        r8.mTag = r9;
    L_0x00b8:
        r9 = "TTID";
        r9 = r0.get(r9);
        r9 = (java.lang.String) r9;
        r1 = android.text.TextUtils.isEmpty(r9);
        if (r1 != 0) goto L_0x00c8;
    L_0x00c6:
        r8.mTtid = r9;
    L_0x00c8:
        r9 = "source";
        r9 = r0.get(r9);
        r9 = (java.lang.String) r9;
        r1 = android.text.TextUtils.isEmpty(r9);
        if (r1 != 0) goto L_0x00d8;
    L_0x00d6:
        r8.mSource = r9;
    L_0x00d8:
        r9 = "utdid";
        r9 = r0.get(r9);
        r9 = (java.lang.String) r9;
        r0 = android.text.TextUtils.isEmpty(r9);
        if (r0 != 0) goto L_0x00e8;
    L_0x00e6:
        r8.mUtdid = r9;
    L_0x00e8:
        r8 = new java.util.HashMap;
        r8.<init>();
        r9 = "backURL";
        r8.put(r9, r10);
        r9 = "addParams";
        r8.put(r9, r11);
        r9 = "jsonParams";
        r8.put(r9, r2);
        r9 = new java.lang.StringBuilder;
        r10 = "appType is ";
        r9.<init>(r10);
        r10 = "appType";
        r10 = r11.get(r10);
        r10 = (java.lang.String) r10;
        r9.append(r10);
        com.alibaba.baichuan.android.trade.utils.g.a.b();
        r9 = "appType";
        r10 = "appType";
        r10 = r11.get(r10);
        r8.put(r9, r10);
        r9 = com.alibaba.baichuan.android.trade.d.d.AnonymousClass1.a;
        r5 = r5.ordinal();
        r5 = r9[r5];
        switch(r5) {
            case 1: goto L_0x0128;
            case 2: goto L_0x0138;
            case 3: goto L_0x014b;
            default: goto L_0x0127;
        };
    L_0x0127:
        goto L_0x015e;
    L_0x0128:
        if (r7 == 0) goto L_0x0138;
    L_0x012a:
        r5 = "itemId";
        r8.put(r5, r7);
        r5 = com.alibaba.baichuan.android.trade.adapter.b.a.a();
        r4 = r5.b(r4, r8);
        return r4;
    L_0x0138:
        if (r7 == 0) goto L_0x0148;
    L_0x013a:
        r5 = "shopId";
        r8.put(r5, r7);
        r5 = com.alibaba.baichuan.android.trade.adapter.b.a.a();
        r4 = r5.a(r4, r8);
        return r4;
    L_0x0148:
        com.alibaba.baichuan.android.trade.utils.g.a.b();
    L_0x014b:
        if (r6 == 0) goto L_0x015b;
    L_0x014d:
        r5 = "url";
        r8.put(r5, r6);
        r5 = com.alibaba.baichuan.android.trade.adapter.b.a.a();
        r4 = r5.c(r4, r8);
        return r4;
    L_0x015b:
        com.alibaba.baichuan.android.trade.utils.g.a.b();
    L_0x015e:
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.d.d.a(android.content.Context, com.alibaba.baichuan.android.trade.model.ApplinkOpenType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map):boolean");
    }
}
