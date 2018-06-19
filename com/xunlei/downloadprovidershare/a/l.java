package com.xunlei.downloadprovidershare.a;

import com.xiaomi.mipush.sdk.Constants;

/* compiled from: ShareWebsiteInfo */
public final class l extends f {
    private String a;
    private String b;
    private String m;

    public l(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        super(str, str2, str3);
        this.h = str5;
        str = new StringBuilder();
        str.append(str8);
        str.append(Constants.COLON_SEPARATOR);
        str.append(str4);
        this.d = str.toString();
        this.a = str6;
        this.b = str7;
        this.m = str8;
    }

    public final boolean a(android.content.Context r7, com.xunlei.downloadprovidershare.ShareOperationType r8, com.xunlei.downloadprovidershare.a.a r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r7 = com.xunlei.downloadprovidershare.a.f.c();
        r8 = "userid";
        r0 = r6.b;
        r7.put(r8, r0);
        r8 = "siteid";
        r0 = r6.a;
        r7.put(r8, r0);
        r8 = "nickname";
        r0 = r6.m;
        r1 = "UTF-8";
        r0 = com.xunlei.xllib.b.k.a(r0, r1);
        r7.put(r8, r0);
        r8 = r6.f;
        r7 = com.xunlei.downloadprovidershare.y.a(r8, r7);
        r6.f = r7;
        r8 = new com.xunlei.downloadprovidershare.a.m;
        r8.<init>(r6, r7, r9);
        r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0051 }
        r3.<init>();	 Catch:{ JSONException -> 0x0051 }
        r9 = "url";	 Catch:{ JSONException -> 0x0051 }
        r3.put(r9, r7);	 Catch:{ JSONException -> 0x0051 }
        r7 = new com.xunlei.common.net.thunderserver.request.SigJsonObjectRequest;	 Catch:{ JSONException -> 0x0051 }
        r1 = 1;	 Catch:{ JSONException -> 0x0051 }
        r2 = "http://api-shoulei-ssl.xunlei.com/dlj_create";	 Catch:{ JSONException -> 0x0051 }
        r4 = new com.xunlei.downloadprovidershare.ae;	 Catch:{ JSONException -> 0x0051 }
        r4.<init>(r8);	 Catch:{ JSONException -> 0x0051 }
        r5 = new com.xunlei.downloadprovidershare.af;	 Catch:{ JSONException -> 0x0051 }
        r5.<init>(r8);	 Catch:{ JSONException -> 0x0051 }
        r0 = r7;	 Catch:{ JSONException -> 0x0051 }
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ JSONException -> 0x0051 }
        r9 = com.xunlei.common.net.volley.VolleyRequestManager.getRequestQueue();	 Catch:{ JSONException -> 0x0051 }
        r9.a(r7);	 Catch:{ JSONException -> 0x0051 }
        goto L_0x0054;
    L_0x0051:
        r8.a();
    L_0x0054:
        r7 = 1;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovidershare.a.l.a(android.content.Context, com.xunlei.downloadprovidershare.ShareOperationType, com.xunlei.downloadprovidershare.a$a):boolean");
    }
}
