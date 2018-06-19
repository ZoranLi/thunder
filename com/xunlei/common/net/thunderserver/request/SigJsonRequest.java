package com.xunlei.common.net.thunderserver.request;

import com.android.volley.AuthFailureError;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.a;
import com.android.volley.n.b;
import java.io.UnsupportedEncodingException;

public abstract class SigJsonRequest<T> extends SigRequest<T> {
    protected abstract n<T> parseNetworkResponse(j jVar);

    public SigJsonRequest(int i, String str, String str2, b<T> bVar, a aVar) {
        super(i, str, str2, bVar, aVar);
    }

    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE_JSON;
    }

    public byte[] getBody() throws AuthFailureError {
        if (!(this.mSignatureBuilder == null || getMethod() == 0 || getMethod() == 3)) {
            try {
                return this.mSignatureBuilder.getRequestBody().getBytes("utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
