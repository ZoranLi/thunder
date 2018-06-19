package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.n.a;
import com.android.volley.n.b;

/* compiled from: StringRequest */
public class aa extends Request<String> {
    private b<String> mListener;
    private final Object mLock;

    public aa(int i, String str, b<String> bVar, a aVar) {
        super(i, str, aVar);
        this.mLock = new Object();
        this.mListener = bVar;
    }

    public aa(String str, b<String> bVar, a aVar) {
        this(0, str, bVar, aVar);
    }

    public void cancel() {
        super.cancel();
        synchronized (this.mLock) {
            this.mListener = null;
        }
    }

    protected void deliverResponse(String str) {
        synchronized (this.mLock) {
            b bVar = this.mListener;
        }
        if (bVar != null) {
            bVar.onResponse(str);
        }
    }

    public com.android.volley.n<java.lang.String> parseNetworkResponse(com.android.volley.j r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r1 = r4.b;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r2 = r4.c;	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r2 = com.android.volley.toolbox.k.a(r2);	 Catch:{ UnsupportedEncodingException -> 0x000e }
        r0.<init>(r1, r2);	 Catch:{ UnsupportedEncodingException -> 0x000e }
        goto L_0x0015;
    L_0x000e:
        r0 = new java.lang.String;
        r1 = r4.b;
        r0.<init>(r1);
    L_0x0015:
        r4 = com.android.volley.toolbox.k.a(r4);
        r4 = com.android.volley.n.a(r0, r4);
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.aa.parseNetworkResponse(com.android.volley.j):com.android.volley.n<java.lang.String>");
    }
}
