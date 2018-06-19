package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.a;
import com.android.volley.n.b;

/* compiled from: JsonRequest */
public abstract class v<T> extends Request<T> {
    protected static final String PROTOCOL_CHARSET = "utf-8";
    private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", new Object[]{PROTOCOL_CHARSET});
    private b<T> mListener;
    private final Object mLock;
    private final String mRequestBody;

    public abstract n<T> parseNetworkResponse(j jVar);

    @Deprecated
    public v(String str, String str2, b<T> bVar, a aVar) {
        this(-1, str, str2, bVar, aVar);
    }

    public v(int i, String str, String str2, b<T> bVar, a aVar) {
        super(i, str, aVar);
        this.mLock = new Object();
        this.mListener = bVar;
        this.mRequestBody = str2;
    }

    public void cancel() {
        super.cancel();
        synchronized (this.mLock) {
            this.mListener = null;
        }
    }

    protected void deliverResponse(T t) {
        synchronized (this.mLock) {
            b bVar = this.mListener;
        }
        if (bVar != null) {
            bVar.onResponse(t);
        }
    }

    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Deprecated
    public byte[] getPostBody() {
        return getBody();
    }

    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE;
    }

    public byte[] getBody() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 0;
        r1 = r5.mRequestBody;	 Catch:{ UnsupportedEncodingException -> 0x000f }
        if (r1 != 0) goto L_0x0006;	 Catch:{ UnsupportedEncodingException -> 0x000f }
    L_0x0005:
        return r0;	 Catch:{ UnsupportedEncodingException -> 0x000f }
    L_0x0006:
        r1 = r5.mRequestBody;	 Catch:{ UnsupportedEncodingException -> 0x000f }
        r2 = "utf-8";	 Catch:{ UnsupportedEncodingException -> 0x000f }
        r1 = r1.getBytes(r2);	 Catch:{ UnsupportedEncodingException -> 0x000f }
        return r1;
    L_0x000f:
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
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.v.getBody():byte[]");
    }
}
