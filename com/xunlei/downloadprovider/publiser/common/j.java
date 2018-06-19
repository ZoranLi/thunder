package com.xunlei.downloadprovider.publiser.common;

import com.android.volley.n.b;
import org.json.JSONObject;

/* compiled from: PublisherDataNetworkHelper */
final class j implements b<JSONObject> {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final /* synthetic */ void onResponse(java.lang.Object r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r5 = (org.json.JSONObject) r5;
        r0 = new java.lang.StringBuilder;
        r1 = "getUserInfo=>";
        r0.<init>(r1);
        r0.append(r5);
        r0 = "result";
        r0 = r5.optString(r0);
        r1 = "ok";
        r1 = r1.equals(r0);
        if (r1 == 0) goto L_0x0061;
    L_0x001a:
        r5 = com.xunlei.downloadprovider.publiser.common.PublisherInfo.a(r5);	 Catch:{ JSONException -> 0x0057 }
        r0 = r5.b();	 Catch:{ JSONException -> 0x0057 }
        r0 = r0.a;	 Catch:{ JSONException -> 0x0057 }
        if (r0 == 0) goto L_0x0038;	 Catch:{ JSONException -> 0x0057 }
    L_0x0026:
        r0 = com.xunlei.downloadprovider.homepage.follow.b.a();	 Catch:{ JSONException -> 0x0057 }
        r1 = r4.a;	 Catch:{ JSONException -> 0x0057 }
        r1 = r1.b;	 Catch:{ JSONException -> 0x0057 }
        r0 = r0.g;	 Catch:{ JSONException -> 0x0057 }
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ JSONException -> 0x0057 }
        r0.add(r1);	 Catch:{ JSONException -> 0x0057 }
        goto L_0x004f;	 Catch:{ JSONException -> 0x0057 }
    L_0x0038:
        r0 = com.xunlei.downloadprovider.homepage.follow.b.a();	 Catch:{ JSONException -> 0x0057 }
        r1 = r4.a;	 Catch:{ JSONException -> 0x0057 }
        r1 = r1.b;	 Catch:{ JSONException -> 0x0057 }
        r3 = r0.b(r1);	 Catch:{ JSONException -> 0x0057 }
        if (r3 == 0) goto L_0x004f;	 Catch:{ JSONException -> 0x0057 }
    L_0x0046:
        r0 = r0.g;	 Catch:{ JSONException -> 0x0057 }
        r1 = java.lang.Long.valueOf(r1);	 Catch:{ JSONException -> 0x0057 }
        r0.remove(r1);	 Catch:{ JSONException -> 0x0057 }
    L_0x004f:
        r0 = r4.a;	 Catch:{ JSONException -> 0x0057 }
        r0 = r0.c;	 Catch:{ JSONException -> 0x0057 }
        r0.onSuccess(r5);	 Catch:{ JSONException -> 0x0057 }
        return;
    L_0x0057:
        r5 = r4.a;
        r5 = r5.c;
        r0 = "JSONException";
        r5.onFail(r0);
        return;
    L_0x0061:
        r5 = r4.a;
        r5 = r5.c;
        r5.onFail(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.publiser.common.j.onResponse(java.lang.Object):void");
    }
}
