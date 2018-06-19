package com.xunlei.downloadprovider.web.base.core;

import com.android.volley.AuthFailureError;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.xunlei.common.net.thunderserver.request.SigRequest;
import java.util.Map;

/* compiled from: JsHttpClient */
final class ad extends SigRequest<String> {
    final /* synthetic */ d a;

    ad(d dVar, int i, String str, String str2, b bVar, a aVar) {
        this.a = dVar;
        super(i, str, str2, bVar, aVar);
    }

    public final Map<String, String> getHeaders() throws AuthFailureError {
        Map<String, String> headers = super.getHeaders();
        headers.putAll(this.a.c);
        return headers;
    }

    protected final com.android.volley.n<java.lang.String> parseNetworkResponse(com.android.volley.j r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r4.b;
        r1 = 0;
        r2 = r0.length;
        r0 = com.xunlei.xllib.b.j.a(r0, r1, r2);
        if (r0 != 0) goto L_0x001f;
    L_0x000a:
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0018 }
        r1 = r4.b;	 Catch:{ UnsupportedEncodingException -> 0x0018 }
        r2 = r4.c;	 Catch:{ UnsupportedEncodingException -> 0x0018 }
        r2 = com.android.volley.toolbox.k.a(r2);	 Catch:{ UnsupportedEncodingException -> 0x0018 }
        r0.<init>(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x0018 }
        goto L_0x001f;
    L_0x0018:
        r0 = new java.lang.String;
        r1 = r4.b;
        r0.<init>(r1);
    L_0x001f:
        r4 = com.android.volley.toolbox.k.a(r4);
        r4 = com.android.volley.n.a(r0, r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.base.core.ad.parseNetworkResponse(com.android.volley.j):com.android.volley.n<java.lang.String>");
    }
}
