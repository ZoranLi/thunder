package com.xunlei.downloadprovider.web.base.core;

import com.android.volley.AuthFailureError;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.android.volley.toolbox.k;
import java.util.Map;

/* compiled from: JsHttpClient */
final class aa extends com.android.volley.toolbox.aa {
    final /* synthetic */ a a;

    aa(a aVar, int i, String str, b bVar, a aVar2) {
        this.a = aVar;
        super(i, str, bVar, aVar2);
    }

    public final Map<String, String> getHeaders() throws AuthFailureError {
        if (this.a.c != null) {
            return this.a.c;
        }
        return super.getHeaders();
    }

    protected final n<String> parseNetworkResponse(j jVar) {
        byte[] bArr = jVar.b;
        String a = com.xunlei.xllib.b.j.a(bArr, 0, bArr.length);
        if (a == null) {
            return super.parseNetworkResponse(jVar);
        }
        return n.a(a, k.a(jVar));
    }

    public final byte[] getBody() throws com.android.volley.AuthFailureError {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = r2.getMethod();
        r1 = 1;
        if (r0 != r1) goto L_0x0039;
    L_0x0007:
        r0 = r2.a;
        r0 = r0.d;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 != 0) goto L_0x0039;
    L_0x0011:
        r0 = r2.a;
        r0 = r0.e;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x002c;
    L_0x001b:
        r0 = r2.a;	 Catch:{ UnsupportedEncodingException -> 0x0028 }
        r0 = r0.d;	 Catch:{ UnsupportedEncodingException -> 0x0028 }
        r1 = r2.a;	 Catch:{ UnsupportedEncodingException -> 0x0028 }
        r1 = r1.e;	 Catch:{ UnsupportedEncodingException -> 0x0028 }
        r0 = r0.getBytes(r1);	 Catch:{ UnsupportedEncodingException -> 0x0028 }
        return r0;
    L_0x0028:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x002c:
        r0 = r2.a;	 Catch:{ UnsupportedEncodingException -> 0x0037 }
        r0 = r0.d;	 Catch:{ UnsupportedEncodingException -> 0x0037 }
        r1 = "utf-8";	 Catch:{ UnsupportedEncodingException -> 0x0037 }
        r0 = r0.getBytes(r1);	 Catch:{ UnsupportedEncodingException -> 0x0037 }
        return r0;
    L_0x0037:
        r0 = 0;
        return r0;
    L_0x0039:
        r0 = super.getBody();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.web.base.core.aa.getBody():byte[]");
    }
}
