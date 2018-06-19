package com.xunlei.common.net.thunderserver.request;

import android.text.TextUtils;
import com.android.volley.AuthFailureError;
import com.android.volley.d;
import com.android.volley.j;
import com.android.volley.n;
import com.android.volley.n.a;
import com.android.volley.n.b;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.net.thunderserver.signature.SignatureUrlBuilder;
import java.io.UnsupportedEncodingException;
import java.util.Map;

public abstract class SigRequest<T> extends BasicRequest<T> {
    protected static final String PROTOCOL_CHARSET = "utf-8";
    protected static final String PROTOCOL_CONTENT_TYPE_JSON = String.format("application/json; charset=%s", new Object[]{PROTOCOL_CHARSET});
    protected static final String PROTOCOL_CONTENT_TYPE_URLENCODED = String.format("application/x-www-form-urlencoded; charset=%s", new Object[]{PROTOCOL_CHARSET});
    protected SignatureUrlBuilder mSignatureBuilder;

    public static String methodNameOf(int i) {
        String str = "";
        switch (i) {
            case 0:
                return "GET";
            case 1:
                return "POST";
            case 2:
                return "PUT";
            case 3:
                return "DELETE";
            default:
                return str;
        }
    }

    public abstract n<T> parseNetworkResponse(j jVar);

    public SigRequest(int i, String str, String str2, b<T> bVar, a aVar) {
        this(i, new SignatureUrlBuilder(methodNameOf(i), str, str2), bVar, aVar);
    }

    public SigRequest(int i, SignatureUrlBuilder signatureUrlBuilder, b<T> bVar, a aVar) {
        super(i, signatureUrlBuilder.getSignatureRequestUrl(), bVar, aVar);
        this.mSignatureBuilder = signatureUrlBuilder;
        setShouldCache(0);
        setRetryPolicy(new d(ReaderCallback.GET_BAR_ANIMATING, 1, 1.0f));
    }

    public SigRequest(String str, a aVar) {
        this(0, str, null, null, aVar);
    }

    public SigRequest(int i, String str, a aVar) {
        this(i, str, null, null, aVar);
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        return super.getHeaders();
    }

    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    public byte[] getPostBody() throws AuthFailureError {
        return getBody();
    }

    public String getBodyContentType() {
        return PROTOCOL_CONTENT_TYPE_URLENCODED;
    }

    public byte[] getBody() throws AuthFailureError {
        if (!(this.mSignatureBuilder == null || getMethod() == 0 || getMethod() == 3)) {
            String requestBody = this.mSignatureBuilder.getRequestBody();
            if (TextUtils.isEmpty(requestBody)) {
                requestBody = this.mSignatureBuilder.getSignatureBaseString();
            }
            try {
                return requestBody.getBytes(PROTOCOL_CHARSET);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
