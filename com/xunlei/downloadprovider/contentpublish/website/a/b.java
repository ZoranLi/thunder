package com.xunlei.downloadprovider.contentpublish.website.a;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.member.payment.a.e;
import com.xunlei.downloadprovider.member.payment.a.e.a;

/* compiled from: WebsiteNetworkHelper */
public final class b extends e {
    public final com.android.volley.Request a(com.xunlei.downloadprovider.contentpublish.website.au r7, com.xunlei.downloadprovider.member.payment.a.e.c<java.lang.String> r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0047 }
        r3.<init>();	 Catch:{ JSONException -> 0x0047 }
        r0 = "uid";	 Catch:{ JSONException -> 0x0047 }
        r1 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ JSONException -> 0x0047 }
        r1 = r1.g;	 Catch:{ JSONException -> 0x0047 }
        r1 = r1.c();	 Catch:{ JSONException -> 0x0047 }
        r3.put(r0, r1);	 Catch:{ JSONException -> 0x0047 }
        r0 = "url";	 Catch:{ JSONException -> 0x0047 }
        r1 = r7.a;	 Catch:{ JSONException -> 0x0047 }
        r3.put(r0, r1);	 Catch:{ JSONException -> 0x0047 }
        r0 = "title";	 Catch:{ JSONException -> 0x0047 }
        r1 = r7.c;	 Catch:{ JSONException -> 0x0047 }
        r3.put(r0, r1);	 Catch:{ JSONException -> 0x0047 }
        r0 = "description";	 Catch:{ JSONException -> 0x0047 }
        r1 = r7.d;	 Catch:{ JSONException -> 0x0047 }
        r3.put(r0, r1);	 Catch:{ JSONException -> 0x0047 }
        r0 = "pic";	 Catch:{ JSONException -> 0x0047 }
        r7 = r7.b;	 Catch:{ JSONException -> 0x0047 }
        r3.put(r0, r7);	 Catch:{ JSONException -> 0x0047 }
        r7 = new com.xunlei.downloadprovider.homepage.follow.c.ar;	 Catch:{ JSONException -> 0x0047 }
        r1 = 1;	 Catch:{ JSONException -> 0x0047 }
        r2 = "http://api-shoulei-ssl.xunlei.com/fav_site/api/pub";	 Catch:{ JSONException -> 0x0047 }
        r4 = new com.xunlei.downloadprovider.contentpublish.website.a.c;	 Catch:{ JSONException -> 0x0047 }
        r4.<init>(r6, r8);	 Catch:{ JSONException -> 0x0047 }
        r5 = new com.xunlei.downloadprovider.contentpublish.website.a.d;	 Catch:{ JSONException -> 0x0047 }
        r5.<init>(r6, r8);	 Catch:{ JSONException -> 0x0047 }
        r0 = r7;	 Catch:{ JSONException -> 0x0047 }
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ JSONException -> 0x0047 }
        r6.a(r7);	 Catch:{ JSONException -> 0x0047 }
        return r7;
    L_0x0047:
        r7 = "publish_failed";
        r8.onFail(r7);
        r7 = 0;
        return r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.contentpublish.website.a.b.a(com.xunlei.downloadprovider.contentpublish.website.au, com.xunlei.downloadprovider.member.payment.a.e$c):com.android.volley.Request");
    }

    public final com.android.volley.Request a(java.lang.String r9, com.xunlei.downloadprovider.member.payment.a.e.c<com.xunlei.downloadprovider.contentpublish.website.a.l> r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = android.text.TextUtils.isEmpty(r9);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r5 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0029 }
        r5.<init>();	 Catch:{ JSONException -> 0x0029 }
        r0 = "url";	 Catch:{ JSONException -> 0x0029 }
        r5.put(r0, r9);	 Catch:{ JSONException -> 0x0029 }
        r9 = new com.xunlei.downloadprovider.homepage.follow.c.ar;	 Catch:{ JSONException -> 0x0029 }
        r3 = 1;	 Catch:{ JSONException -> 0x0029 }
        r4 = "http://api-shoulei-ssl.xunlei.com/faceless/crawl";	 Catch:{ JSONException -> 0x0029 }
        r6 = new com.xunlei.downloadprovider.contentpublish.website.a.e;	 Catch:{ JSONException -> 0x0029 }
        r6.<init>(r8, r10);	 Catch:{ JSONException -> 0x0029 }
        r7 = new com.xunlei.downloadprovider.contentpublish.website.a.f;	 Catch:{ JSONException -> 0x0029 }
        r7.<init>(r8, r10);	 Catch:{ JSONException -> 0x0029 }
        r2 = r9;	 Catch:{ JSONException -> 0x0029 }
        r2.<init>(r3, r4, r5, r6, r7);	 Catch:{ JSONException -> 0x0029 }
        r8.a(r9);	 Catch:{ JSONException -> 0x0029 }
        return r9;
    L_0x0029:
        r9 = "";
        r10.onFail(r9);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.contentpublish.website.a.b.a(java.lang.String, com.xunlei.downloadprovider.member.payment.a.e$c):com.android.volley.Request");
    }

    public final void a(String str, a aVar) {
        XLThreadPool.execute(new i(this, str, aVar));
    }
}
