package com.xunlei.common.net.thunderserver.request;

import com.android.volley.ParseError;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.android.volley.toolbox.k;
import org.json.JSONArray;

public class NoSigJsonArrayRequest extends BasicRequest<JSONArray> {
    private JSONArray mRequestBody;

    public NoSigJsonArrayRequest(int i, String str, JSONArray jSONArray, b<JSONArray> bVar, a aVar) {
        super(i, str, bVar, aVar);
        this.mRequestBody = jSONArray;
    }

    protected n<JSONArray> parseNetworkResponse(j jVar) {
        try {
            return n.a(new JSONArray(new String(jVar.b, k.a(jVar.c, "utf-8"))), k.a(jVar));
        } catch (Throwable e) {
            return n.a(new ParseError(e));
        }
    }

    public byte[] getBody() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.mRequestBody;	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        if (r1 != 0) goto L_0x0006;	 Catch:{ UnsupportedEncodingException -> 0x0013 }
    L_0x0005:
        return r0;	 Catch:{ UnsupportedEncodingException -> 0x0013 }
    L_0x0006:
        r1 = r5.mRequestBody;	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r1 = r1.toString();	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r2 = "utf-8";	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        r1 = r1.getBytes(r2);	 Catch:{ UnsupportedEncodingException -> 0x0013 }
        return r1;
    L_0x0013:
        r1 = "Unsupported Encoding while trying to get the bytes of %s using %s";
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r5.mRequestBody;
        r2[r3] = r4;
        r3 = 1;
        r4 = "utf-8";
        r2[r3] = r4;
        com.android.volley.q.e(r1, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.net.thunderserver.request.NoSigJsonArrayRequest.getBody():byte[]");
    }
}
