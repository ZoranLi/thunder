package com.baidu.android.common.net;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.common.logging.Log;
import java.io.IOException;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

public class ProxyHttpClient extends DefaultHttpClient {
    private static final boolean DEBUG = false;
    private static final int HTTP_TIMEOUT_MS = 30000;
    private static final String TAG = "ProxyHttpClient";
    private RuntimeException mLeakedException;
    private String mPort;
    private String mProxy;
    private boolean mUseWap;

    public ProxyHttpClient(Context context) {
        this(context, null, null);
    }

    public ProxyHttpClient(Context context, ConnectManager connectManager) {
        this(context, null, connectManager);
    }

    public ProxyHttpClient(Context context, String str) {
        this(context, str, null);
    }

    public ProxyHttpClient(Context context, String str, ConnectManager connectManager) {
        this.mLeakedException = new IllegalStateException("ProxyHttpClient created and never closed");
        if (connectManager == null) {
            connectManager = new ConnectManager(context);
        }
        this.mUseWap = connectManager.isWapNetwork();
        this.mProxy = connectManager.getProxy();
        this.mPort = connectManager.getProxyPort();
        if (this.mProxy != null && this.mProxy.length() > 0) {
            getParams().setParameter("http.route.default-proxy", new HttpHost(this.mProxy, Integer.valueOf(this.mPort).intValue()));
        }
        HttpConnectionParams.setConnectionTimeout(getParams(), 30000);
        HttpConnectionParams.setSoTimeout(getParams(), 30000);
        HttpConnectionParams.setSocketBufferSize(getParams(), 8192);
        if (!TextUtils.isEmpty(str)) {
            HttpProtocolParams.setUserAgent(getParams(), str);
        }
    }

    public void close() {
        if (this.mLeakedException != null) {
            getConnectionManager().shutdown();
            this.mLeakedException = null;
        }
    }

    protected org.apache.http.params.HttpParams createHttpParams() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = super.createHttpParams();	 Catch:{ ArrayIndexOutOfBoundsException -> 0x0005 }
        goto L_0x0019;
    L_0x0005:
        r0 = new org.apache.http.params.BasicHttpParams;
        r0.<init>();
        r1 = org.apache.http.HttpVersion.HTTP_1_1;
        org.apache.http.params.HttpProtocolParams.setVersion(r0, r1);
        r1 = "ISO-8859-1";
        org.apache.http.params.HttpProtocolParams.setContentCharset(r0, r1);
        r1 = "Apache-HttpClient/UNAVAILABLE (java 1.4)";
        org.apache.http.params.HttpProtocolParams.setUserAgent(r0, r1);
    L_0x0019:
        r1 = 0;
        org.apache.http.params.HttpProtocolParams.setUseExpectContinue(r0, r1);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.android.common.net.ProxyHttpClient.createHttpParams():org.apache.http.params.HttpParams");
    }

    public HttpResponse executeSafely(HttpUriRequest httpUriRequest) throws ClientProtocolException, IOException {
        try {
            return execute(httpUriRequest);
        } catch (Throwable e) {
            throw new ClientProtocolException(e);
        }
    }

    protected void finalize() throws Throwable {
        super.finalize();
        if (this.mLeakedException != null) {
            Log.e(TAG, "Leak found", this.mLeakedException);
        }
    }

    public boolean isWap() {
        return this.mUseWap;
    }
}
