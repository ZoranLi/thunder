package com.xunlei.downloadprovider.homepage.follow.c;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: FollowNetworkHelper */
final class l implements b<JSONObject> {
    final /* synthetic */ k a;

    l(k kVar) {
        this.a = kVar;
    }

    public final /* synthetic */ void onResponse(java.lang.Object r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r6 = (org.json.JSONObject) r6;
        r0 = new java.lang.StringBuilder;
        r1 = "getFollowingLatestVideoFeedList:result=>";
        r0.<init>(r1);
        r0.append(r6);
        r0 = "result";
        r0 = r6.optString(r0);
        r1 = "ok";
        r1 = r1.equalsIgnoreCase(r0);
        if (r1 == 0) goto L_0x0051;
    L_0x001a:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = "data";
        r1 = r6.optJSONArray(r1);
        r2 = 0;
        if (r1 == 0) goto L_0x003d;
    L_0x0028:
        r3 = r2;
    L_0x0029:
        r4 = r1.length();
        if (r3 >= r4) goto L_0x003d;
    L_0x002f:
        r4 = r1.optJSONObject(r3);	 Catch:{ JSONException -> 0x003a }
        r4 = com.xunlei.downloadprovider.homepage.follow.b.d.a(r4);	 Catch:{ JSONException -> 0x003a }
        r0.add(r4);	 Catch:{ JSONException -> 0x003a }
    L_0x003a:
        r3 = r3 + 1;
        goto L_0x0029;
    L_0x003d:
        r1 = "clear_cache";
        r6 = r6.optInt(r1);
        r1 = 1;
        if (r6 != r1) goto L_0x0047;
    L_0x0046:
        goto L_0x0048;
    L_0x0047:
        r1 = r2;
    L_0x0048:
        r6 = new com.xunlei.downloadprovider.homepage.follow.c.m;
        r6.<init>(r5, r0, r1);
        com.xunlei.downloadprovider.homepage.follow.c.a.j(r6);
        return;
    L_0x0051:
        r6 = new com.xunlei.downloadprovider.homepage.follow.c.n;
        r6.<init>(r5, r0);
        com.xunlei.downloadprovider.homepage.follow.c.a.j(r6);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.follow.c.l.onResponse(java.lang.Object):void");
    }
}
