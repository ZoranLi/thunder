package com.xunlei.downloadprovider.homepage.follow.c;

import com.xunlei.downloadprovider.member.payment.a.e$d;

/* compiled from: FollowNetworkHelper */
public final class e implements Runnable {
    final /* synthetic */ int a = 8;
    final /* synthetic */ String b;
    final /* synthetic */ e$d c;
    final /* synthetic */ a d;

    public e(a aVar, String str, e$d com_xunlei_downloadprovider_member_payment_a_e_d) {
        this.d = aVar;
        this.b = str;
        this.c = com_xunlei_downloadprovider_member_payment_a_e_d;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r3 = new org.json.JSONObject;
        r3.<init>();
        r0 = "user_id";	 Catch:{ JSONException -> 0x004d }
        r1 = com.xunlei.downloadprovider.member.login.LoginHelper.a();	 Catch:{ JSONException -> 0x004d }
        r1 = r1.g;	 Catch:{ JSONException -> 0x004d }
        r1 = r1.c();	 Catch:{ JSONException -> 0x004d }
        r3.put(r0, r1);	 Catch:{ JSONException -> 0x004d }
        r0 = "page_size";	 Catch:{ JSONException -> 0x004d }
        r1 = r8.a;	 Catch:{ JSONException -> 0x004d }
        r3.put(r0, r1);	 Catch:{ JSONException -> 0x004d }
        r0 = r8.b;	 Catch:{ JSONException -> 0x004d }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ JSONException -> 0x004d }
        if (r0 != 0) goto L_0x002a;	 Catch:{ JSONException -> 0x004d }
    L_0x0023:
        r0 = "last_row_key";	 Catch:{ JSONException -> 0x004d }
        r1 = r8.b;	 Catch:{ JSONException -> 0x004d }
        r3.put(r0, r1);	 Catch:{ JSONException -> 0x004d }
    L_0x002a:
        r0 = new java.lang.StringBuilder;	 Catch:{ JSONException -> 0x004d }
        r1 = "getFollowingVideoFeedList json=";	 Catch:{ JSONException -> 0x004d }
        r0.<init>(r1);	 Catch:{ JSONException -> 0x004d }
        r0.append(r3);	 Catch:{ JSONException -> 0x004d }
        r6 = r8.d;	 Catch:{ JSONException -> 0x004d }
        r7 = new com.xunlei.downloadprovider.homepage.follow.c.ar;	 Catch:{ JSONException -> 0x004d }
        r1 = 1;	 Catch:{ JSONException -> 0x004d }
        r2 = "http://api-shoulei-ssl.xunlei.com/dynamic/publish";	 Catch:{ JSONException -> 0x004d }
        r4 = new com.xunlei.downloadprovider.homepage.follow.c.f;	 Catch:{ JSONException -> 0x004d }
        r4.<init>(r8);	 Catch:{ JSONException -> 0x004d }
        r5 = new com.xunlei.downloadprovider.homepage.follow.c.i;	 Catch:{ JSONException -> 0x004d }
        r5.<init>(r8);	 Catch:{ JSONException -> 0x004d }
        r0 = r7;	 Catch:{ JSONException -> 0x004d }
        r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ JSONException -> 0x004d }
        r6.b(r7);	 Catch:{ JSONException -> 0x004d }
        return;
    L_0x004d:
        r0 = r8.c;
        r1 = "JSONException";
        r0.a(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.homepage.follow.c.e.run():void");
    }
}
