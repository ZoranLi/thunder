package com.xunlei.downloadprovider.homepage.recommend.fans.a;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: FansAndFollowNetWork */
final class c implements b<JSONObject> {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final /* synthetic */ void onResponse(java.lang.Object r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r6 = (org.json.JSONObject) r6;
        com.xunlei.downloadprovider.homepage.recommend.fans.a.a.a;
        r0 = new java.lang.StringBuilder;
        r1 = "getHotCampaignList onResponse=";
        r0.<init>(r1);
        r0.append(r6);
        r0 = "result";
        r0 = r6.optString(r0);
        r1 = "cursor";
        r1 = r6.optString(r1);
        r2 = "is_more";
        r2 = r6.optBoolean(r2);
        r3 = new java.util.ArrayList;
        r3.<init>();
        if (r0 == 0) goto L_0x0053;
    L_0x0028:
        r4 = "ok";
        r0 = r4.equals(r0);
        if (r0 == 0) goto L_0x0053;
    L_0x0030:
        r0 = "list";
        r6 = r6.optJSONArray(r0);
        if (r6 == 0) goto L_0x0053;
    L_0x0038:
        r0 = 0;
    L_0x0039:
        r4 = r6.length();
        if (r0 >= r4) goto L_0x0053;
    L_0x003f:
        r4 = r6.optJSONObject(r0);
        if (r4 == 0) goto L_0x0050;
    L_0x0045:
        r4 = com.xunlei.downloadprovider.homepage.follow.b.a.b(r4);	 Catch:{ JSONException -> 0x004d }
        r3.add(r4);	 Catch:{ JSONException -> 0x004d }
        goto L_0x0050;
    L_0x004d:
        com.xunlei.downloadprovider.homepage.recommend.fans.a.a.a;
    L_0x0050:
        r0 = r0 + 1;
        goto L_0x0039;
    L_0x0053:
        r6 = r5.a;
        r6 = r6.b;
        if (r6 == 0) goto L_0x0064;
    L_0x0059:
        r6 = r5.a;
        r6 = r6.b;
        r0 = java.lang.Boolean.valueOf(r2);
        r6.a(r3, r1, r0);
    L_0x0064:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.recommend.fans.a.c.onResponse(java.lang.Object):void");
    }
}
