package com.alibaba.sdk.android.feedback.xblink.f.a;

import com.alibaba.sdk.android.feedback.xblink.f.a;
import com.alibaba.sdk.android.feedback.xblink.f.b;

public class c extends a {
    private com.alibaba.sdk.android.feedback.xblink.e.a d = null;

    public synchronized void a(com.alibaba.sdk.android.feedback.xblink.f.b r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        monitor-enter(r4);
        r0 = r4.d;	 Catch:{ all -> 0x009d }
        if (r0 != 0) goto L_0x000d;	 Catch:{ all -> 0x009d }
    L_0x0005:
        r0 = r4.b;	 Catch:{ all -> 0x009d }
        r0 = r0.getUrlFilter();	 Catch:{ all -> 0x009d }
        r4.d = r0;	 Catch:{ all -> 0x009d }
    L_0x000d:
        r0 = 0;	 Catch:{ all -> 0x009d }
        r1 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x009d }
        if (r1 != 0) goto L_0x004f;
    L_0x0014:
        r1 = "utf-8";	 Catch:{ UnsupportedEncodingException -> 0x001c }
        r1 = java.net.URLDecoder.decode(r6, r1);	 Catch:{ UnsupportedEncodingException -> 0x001c }
        r6 = r1;
        goto L_0x002f;
    L_0x001c:
        r1 = "WVWebUrl";	 Catch:{ all -> 0x009d }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009d }
        r3 = "intercept: param decode error param=";	 Catch:{ all -> 0x009d }
        r2.<init>(r3);	 Catch:{ all -> 0x009d }
        r2.append(r6);	 Catch:{ all -> 0x009d }
        r2 = r2.toString();	 Catch:{ all -> 0x009d }
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r1, r2);	 Catch:{ all -> 0x009d }
    L_0x002f:
        r1 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x003c }
        r1.<init>(r6);	 Catch:{ JSONException -> 0x003c }
        r2 = "url";	 Catch:{ JSONException -> 0x003c }
        r1 = r1.getString(r2);	 Catch:{ JSONException -> 0x003c }
        r0 = r1;
        goto L_0x004f;
    L_0x003c:
        r1 = "WVWebUrl";	 Catch:{ all -> 0x009d }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009d }
        r3 = "intercept: param parse to JSON error, param=";	 Catch:{ all -> 0x009d }
        r2.<init>(r3);	 Catch:{ all -> 0x009d }
        r2.append(r6);	 Catch:{ all -> 0x009d }
        r6 = r2.toString();	 Catch:{ all -> 0x009d }
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r1, r6);	 Catch:{ all -> 0x009d }
    L_0x004f:
        r6 = new com.alibaba.sdk.android.feedback.xblink.f.m;	 Catch:{ all -> 0x009d }
        r6.<init>();	 Catch:{ all -> 0x009d }
        r1 = r4.d;	 Catch:{ all -> 0x009d }
        if (r1 == 0) goto L_0x007f;	 Catch:{ all -> 0x009d }
    L_0x0058:
        r1 = r4.d;	 Catch:{ all -> 0x009d }
        r1 = r1.a(r0);	 Catch:{ all -> 0x009d }
        if (r1 != 0) goto L_0x0061;	 Catch:{ all -> 0x009d }
    L_0x0060:
        goto L_0x007f;	 Catch:{ all -> 0x009d }
    L_0x0061:
        r1 = com.alibaba.sdk.android.feedback.xblink.i.g.a();	 Catch:{ all -> 0x009d }
        if (r1 == 0) goto L_0x007a;	 Catch:{ all -> 0x009d }
    L_0x0067:
        r1 = "WVWebUrl";	 Catch:{ all -> 0x009d }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009d }
        r3 = "intercept: success, url= ";	 Catch:{ all -> 0x009d }
        r2.<init>(r3);	 Catch:{ all -> 0x009d }
        r2.append(r0);	 Catch:{ all -> 0x009d }
        r0 = r2.toString();	 Catch:{ all -> 0x009d }
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r1, r0);	 Catch:{ all -> 0x009d }
    L_0x007a:
        r5.a(r6);	 Catch:{ all -> 0x009d }
        monitor-exit(r4);
        return;
    L_0x007f:
        r1 = com.alibaba.sdk.android.feedback.xblink.i.g.a();	 Catch:{ all -> 0x009d }
        if (r1 == 0) goto L_0x0098;	 Catch:{ all -> 0x009d }
    L_0x0085:
        r1 = "WVWebUrl";	 Catch:{ all -> 0x009d }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009d }
        r3 = "intercept: fail, url=";	 Catch:{ all -> 0x009d }
        r2.<init>(r3);	 Catch:{ all -> 0x009d }
        r2.append(r0);	 Catch:{ all -> 0x009d }
        r0 = r2.toString();	 Catch:{ all -> 0x009d }
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r1, r0);	 Catch:{ all -> 0x009d }
    L_0x0098:
        r5.b(r6);	 Catch:{ all -> 0x009d }
        monitor-exit(r4);
        return;
    L_0x009d:
        r5 = move-exception;
        monitor-exit(r4);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.f.a.c.a(com.alibaba.sdk.android.feedback.xblink.f.b, java.lang.String):void");
    }

    public boolean a(String str, String str2, b bVar) {
        if (!"intercept".equals(str)) {
            return false;
        }
        a(bVar, str2);
        return true;
    }
}
