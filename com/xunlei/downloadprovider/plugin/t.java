package com.xunlei.downloadprovider.plugin;

import com.xunlei.common.androidutil.AndroidConfig;
import com.xunlei.downloadprovider.member.payment.a.e;

/* compiled from: XLPluginNetworkHelper */
class t extends e {
    static final String a;
    private static final String b = "t";

    t() {
    }

    static {
        StringBuilder stringBuilder = new StringBuilder("http://upgrade.xl9.xunlei.com/plugin?os=10.0.0.0.1&pid=7&cid=100001&lng=0804&peerid=");
        stringBuilder.append(AndroidConfig.getHubbleDeviceGUID());
        stringBuilder.append("&v=11100");
        a = stringBuilder.toString();
    }

    private static java.util.Map<java.lang.String, com.xunlei.downloadprovider.plugin.p> b(org.json.JSONObject r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "data";
        r5 = r5.optJSONArray(r0);
        if (r5 == 0) goto L_0x009c;
    L_0x0008:
        r0 = r5.length();
        if (r0 <= 0) goto L_0x009c;
    L_0x000e:
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = 0;
    L_0x0014:
        r2 = r5.length();
        if (r1 >= r2) goto L_0x009d;
    L_0x001a:
        r2 = r5.getJSONObject(r1);	 Catch:{ JSONException -> 0x0098 }
        r3 = new com.xunlei.downloadprovider.plugin.p;	 Catch:{ JSONException -> 0x0098 }
        r3.<init>();	 Catch:{ JSONException -> 0x0098 }
        r4 = "name";	 Catch:{ JSONException -> 0x0098 }
        r4 = r2.optString(r4);	 Catch:{ JSONException -> 0x0098 }
        r3.a = r4;	 Catch:{ JSONException -> 0x0098 }
        r4 = "version";	 Catch:{ JSONException -> 0x0098 }
        r4 = r2.optInt(r4);	 Catch:{ JSONException -> 0x0098 }
        r3.b = r4;	 Catch:{ JSONException -> 0x0098 }
        r4 = "time";	 Catch:{ JSONException -> 0x0098 }
        r4 = r2.optInt(r4);	 Catch:{ JSONException -> 0x0098 }
        r3.c = r4;	 Catch:{ JSONException -> 0x0098 }
        r4 = "status";	 Catch:{ JSONException -> 0x0098 }
        r4 = r2.optInt(r4);	 Catch:{ JSONException -> 0x0098 }
        r3.d = r4;	 Catch:{ JSONException -> 0x0098 }
        r4 = "loadtype";	 Catch:{ JSONException -> 0x0098 }
        r4 = r2.optInt(r4);	 Catch:{ JSONException -> 0x0098 }
        r3.e = r4;	 Catch:{ JSONException -> 0x0098 }
        r4 = "vipstate";	 Catch:{ JSONException -> 0x0098 }
        r4 = r2.optInt(r4);	 Catch:{ JSONException -> 0x0098 }
        r3.f = r4;	 Catch:{ JSONException -> 0x0098 }
        r4 = "state";	 Catch:{ JSONException -> 0x0098 }
        r4 = r2.optInt(r4);	 Catch:{ JSONException -> 0x0098 }
        r3.g = r4;	 Catch:{ JSONException -> 0x0098 }
        r4 = "url";	 Catch:{ JSONException -> 0x0098 }
        r4 = r2.optString(r4);	 Catch:{ JSONException -> 0x0098 }
        r3.h = r4;	 Catch:{ JSONException -> 0x0098 }
        r4 = "md5";	 Catch:{ JSONException -> 0x0098 }
        r4 = r2.optString(r4);	 Catch:{ JSONException -> 0x0098 }
        r3.i = r4;	 Catch:{ JSONException -> 0x0098 }
        r4 = "description";	 Catch:{ JSONException -> 0x0098 }
        r4 = r2.optString(r4);	 Catch:{ JSONException -> 0x0098 }
        r3.j = r4;	 Catch:{ JSONException -> 0x0098 }
        r4 = "versionDetail";	 Catch:{ JSONException -> 0x0098 }
        r4 = r2.optString(r4);	 Catch:{ JSONException -> 0x0098 }
        r3.k = r4;	 Catch:{ JSONException -> 0x0098 }
        r4 = "cid";	 Catch:{ JSONException -> 0x0098 }
        r2 = r2.optString(r4);	 Catch:{ JSONException -> 0x0098 }
        r3.l = r2;	 Catch:{ JSONException -> 0x0098 }
        r2 = r3.a;	 Catch:{ JSONException -> 0x0098 }
        r2 = r0.get(r2);	 Catch:{ JSONException -> 0x0098 }
        r2 = (com.xunlei.downloadprovider.plugin.p) r2;	 Catch:{ JSONException -> 0x0098 }
        if (r2 == 0) goto L_0x0093;	 Catch:{ JSONException -> 0x0098 }
    L_0x008d:
        r4 = r3.b;	 Catch:{ JSONException -> 0x0098 }
        r2 = r2.b;	 Catch:{ JSONException -> 0x0098 }
        if (r4 <= r2) goto L_0x0098;	 Catch:{ JSONException -> 0x0098 }
    L_0x0093:
        r2 = r3.a;	 Catch:{ JSONException -> 0x0098 }
        r0.put(r2, r3);	 Catch:{ JSONException -> 0x0098 }
    L_0x0098:
        r1 = r1 + 1;
        goto L_0x0014;
    L_0x009c:
        r0 = 0;
    L_0x009d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.plugin.t.b(org.json.JSONObject):java.util.Map<java.lang.String, com.xunlei.downloadprovider.plugin.p>");
    }
}
