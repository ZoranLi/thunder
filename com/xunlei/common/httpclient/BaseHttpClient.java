package com.xunlei.common.httpclient;

import android.content.Context;
import org.apache.http.Header;
import org.apache.http.conn.ssl.SSLSocketFactory;

public interface BaseHttpClient {
    void clearInvalidConnections();

    void get(Context context, String str, Header[] headerArr, BaseHttpClientListener baseHttpClientListener);

    void post(Context context, String str, Header[] headerArr, byte[] bArr, BaseHttpClientListener baseHttpClientListener);

    void post(Context context, String str, Header[] headerArr, byte[] bArr, BaseHttpClientListener baseHttpClientListener, int i);

    void setHttpClientTimeout(int i);

    void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory);
}
