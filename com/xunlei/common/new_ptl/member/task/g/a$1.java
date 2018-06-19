package com.xunlei.common.new_ptl.member.task.g;

import com.xunlei.common.httpclient.BaseHttpClientListener;

/* compiled from: UserGetAuthQRCodeTask */
final class a$1 implements BaseHttpClientListener {
    final /* synthetic */ a a;

    a$1(a aVar) {
        this.a = aVar;
    }

    public final void onSuccess(int r1, org.apache.http.Header[] r2, byte[] r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r2) goto L_0x003b;
    L_0x0004:
        r1 = new java.lang.String;
        r1.<init>(r3);
        r3 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x003b }
        r3.<init>(r1);	 Catch:{ JSONException -> 0x003b }
        r1 = "result";	 Catch:{ JSONException -> 0x003b }
        r1 = r3.optInt(r1);	 Catch:{ JSONException -> 0x003b }
        if (r1 != r2) goto L_0x003b;	 Catch:{ JSONException -> 0x003b }
    L_0x0016:
        r1 = r0.a;	 Catch:{ JSONException -> 0x003b }
        r2 = "channel";	 Catch:{ JSONException -> 0x003b }
        r2 = r3.optString(r2);	 Catch:{ JSONException -> 0x003b }
        com.xunlei.common.new_ptl.member.task.g.a.a(r1, r2);	 Catch:{ JSONException -> 0x003b }
        r1 = r0.a;	 Catch:{ JSONException -> 0x003b }
        r2 = 1025; // 0x401 float:1.436E-42 double:5.064E-321;	 Catch:{ JSONException -> 0x003b }
        com.xunlei.common.new_ptl.member.task.g.a.a(r1, r2);	 Catch:{ JSONException -> 0x003b }
        r1 = r0.a;	 Catch:{ JSONException -> 0x003b }
        r1 = r1.d();	 Catch:{ JSONException -> 0x003b }
        r1 = r1.n();	 Catch:{ JSONException -> 0x003b }
        r2 = new com.xunlei.common.new_ptl.member.task.g.a$1$1;	 Catch:{ JSONException -> 0x003b }
        r2.<init>(r0);	 Catch:{ JSONException -> 0x003b }
        r1.post(r2);	 Catch:{ JSONException -> 0x003b }
        return;
    L_0x003b:
        r1 = r0.a;
        r2 = 50331649; // 0x3000001 float:3.7615824E-37 double:2.48671387E-316;
        com.xunlei.common.new_ptl.member.task.g.a.b(r1, r2);
        r1 = r0.a;
        r2 = 1026; // 0x402 float:1.438E-42 double:5.07E-321;
        com.xunlei.common.new_ptl.member.task.g.a.a(r1, r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.new_ptl.member.task.g.a$1.onSuccess(int, org.apache.http.Header[], byte[]):void");
    }

    public final void onFailure(Throwable th, byte[] bArr) {
        a.b(this.a, 50331649);
        a.a(this.a, 1026);
    }
}
