package com.xunlei.downloadprovider.download.privatespace;

import com.android.volley.n.a;
import com.android.volley.n.b;
import com.xunlei.common.net.volley.BaseStringRequest;

/* compiled from: PrivateSpaceHelper */
class v$b extends BaseStringRequest {
    private v$b(String str, b<String> bVar, a aVar) {
        super(1, str, bVar, aVar);
    }

    protected com.android.volley.n<java.lang.String> parseNetworkResponse(com.android.volley.j r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x000a }
        r1 = r4.b;	 Catch:{ UnsupportedEncodingException -> 0x000a }
        r2 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x000a }
        r0.<init>(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x000a }
        goto L_0x0011;
    L_0x000a:
        r0 = new java.lang.String;
        r1 = r4.b;
        r0.<init>(r1);
    L_0x0011:
        r4 = com.android.volley.toolbox.k.a(r4);
        r4 = com.android.volley.n.a(r0, r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.privatespace.v$b.parseNetworkResponse(com.android.volley.j):com.android.volley.n<java.lang.String>");
    }
}
