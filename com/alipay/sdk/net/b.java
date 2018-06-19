package com.alipay.sdk.net;

import android.os.Build.VERSION;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

public final class b {
    public static final String a = "msp";
    static b b;
    final DefaultHttpClient c;

    private static b b() {
        return b;
    }

    private static void c() {
        b = null;
    }

    private b(HttpParams httpParams) {
        this.c = new DefaultHttpClient(httpParams);
    }

    private b(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.c = new DefaultHttpClient(clientConnectionManager, httpParams);
    }

    public static com.alipay.sdk.net.b a() {
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
        r0 = b;
        if (r0 != 0) goto L_0x0087;
    L_0x0004:
        r0 = new org.apache.http.params.BasicHttpParams;
        r0.<init>();
        r1 = org.apache.http.HttpVersion.HTTP_1_1;
        org.apache.http.params.HttpProtocolParams.setVersion(r0, r1);
        r1 = 1;
        org.apache.http.params.HttpConnectionParams.setStaleCheckingEnabled(r0, r1);
        r2 = "http.protocol.expect-continue";
        r3 = 0;
        r0.setBooleanParameter(r2, r3);
        r2 = 50;
        org.apache.http.conn.params.ConnManagerParams.setMaxTotalConnections(r0, r2);
        r2 = new org.apache.http.conn.params.ConnPerRouteBean;
        r4 = 30;
        r2.<init>(r4);
        org.apache.http.conn.params.ConnManagerParams.setMaxConnectionsPerRoute(r0, r2);
        r4 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        org.apache.http.conn.params.ConnManagerParams.setTimeout(r0, r4);
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        org.apache.http.params.HttpConnectionParams.setConnectionTimeout(r0, r2);
        r2 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;
        org.apache.http.params.HttpConnectionParams.setSoTimeout(r0, r2);
        r2 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        org.apache.http.params.HttpConnectionParams.setSocketBufferSize(r0, r2);
        org.apache.http.params.HttpProtocolParams.setUseExpectContinue(r0, r3);
        org.apache.http.client.params.HttpClientParams.setRedirecting(r0, r1);
        org.apache.http.client.params.HttpClientParams.setAuthenticating(r0, r3);
        r1 = "msp";
        org.apache.http.params.HttpProtocolParams.setUserAgent(r0, r1);
        r1 = org.apache.http.conn.ssl.SSLSocketFactory.getSocketFactory();	 Catch:{ Exception -> 0x0080 }
        r2 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;	 Catch:{ Exception -> 0x0080 }
        r1.setHostnameVerifier(r2);	 Catch:{ Exception -> 0x0080 }
        r2 = new org.apache.http.conn.scheme.Scheme;	 Catch:{ Exception -> 0x0080 }
        r3 = "https";	 Catch:{ Exception -> 0x0080 }
        r4 = 443; // 0x1bb float:6.21E-43 double:2.19E-321;	 Catch:{ Exception -> 0x0080 }
        r2.<init>(r3, r1, r4);	 Catch:{ Exception -> 0x0080 }
        r1 = new org.apache.http.conn.scheme.Scheme;	 Catch:{ Exception -> 0x0080 }
        r3 = "http";	 Catch:{ Exception -> 0x0080 }
        r4 = org.apache.http.conn.scheme.PlainSocketFactory.getSocketFactory();	 Catch:{ Exception -> 0x0080 }
        r5 = 80;	 Catch:{ Exception -> 0x0080 }
        r1.<init>(r3, r4, r5);	 Catch:{ Exception -> 0x0080 }
        r3 = new org.apache.http.conn.scheme.SchemeRegistry;	 Catch:{ Exception -> 0x0080 }
        r3.<init>();	 Catch:{ Exception -> 0x0080 }
        r3.register(r2);	 Catch:{ Exception -> 0x0080 }
        r3.register(r1);	 Catch:{ Exception -> 0x0080 }
        r1 = new org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;	 Catch:{ Exception -> 0x0080 }
        r1.<init>(r0, r3);	 Catch:{ Exception -> 0x0080 }
        r2 = new com.alipay.sdk.net.b;	 Catch:{ Exception -> 0x0080 }
        r2.<init>(r1, r0);	 Catch:{ Exception -> 0x0080 }
        b = r2;	 Catch:{ Exception -> 0x0080 }
        goto L_0x0087;
    L_0x0080:
        r1 = new com.alipay.sdk.net.b;
        r1.<init>(r0);
        b = r1;
    L_0x0087:
        r0 = b;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.net.b.a():com.alipay.sdk.net.b");
    }

    private void d() {
        ClientConnectionManager connectionManager = this.c.getConnectionManager();
        if (connectionManager != null) {
            connectionManager.closeExpiredConnections();
            if (VERSION.SDK_INT >= 9) {
                connectionManager.closeIdleConnections(30, TimeUnit.MINUTES);
            }
        }
    }

    private void e() {
        ClientConnectionManager connectionManager = this.c.getConnectionManager();
        if (connectionManager != null) {
            connectionManager.shutdown();
            b = null;
        }
    }

    private HttpParams f() {
        return this.c.getParams();
    }

    private ClientConnectionManager g() {
        return this.c.getConnectionManager();
    }

    public final HttpResponse a(HttpUriRequest httpUriRequest) throws Exception {
        try {
            return this.c.execute(httpUriRequest);
        } catch (HttpUriRequest httpUriRequest2) {
            throw httpUriRequest2;
        }
    }

    private HttpResponse a(HttpUriRequest httpUriRequest, HttpContext httpContext) throws Exception {
        try {
            return this.c.execute(httpUriRequest, httpContext);
        } catch (HttpUriRequest httpUriRequest2) {
            throw new Exception(httpUriRequest2);
        }
    }

    private HttpResponse a(HttpHost httpHost, HttpRequest httpRequest) throws Exception {
        try {
            return this.c.execute(httpHost, httpRequest);
        } catch (HttpHost httpHost2) {
            throw new Exception(httpHost2);
        }
    }

    private HttpResponse a(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws Exception {
        try {
            return this.c.execute(httpHost, httpRequest, httpContext);
        } catch (HttpHost httpHost2) {
            throw new Exception(httpHost2);
        }
    }

    private <T> T a(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) throws Exception {
        try {
            return this.c.execute(httpUriRequest, responseHandler);
        } catch (HttpUriRequest httpUriRequest2) {
            throw new Exception(httpUriRequest2);
        }
    }

    private <T> T a(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws Exception {
        try {
            return this.c.execute(httpUriRequest, responseHandler, httpContext);
        } catch (HttpUriRequest httpUriRequest2) {
            throw new Exception(httpUriRequest2);
        }
    }

    private <T> T a(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) throws Exception {
        try {
            return this.c.execute(httpHost, httpRequest, responseHandler);
        } catch (HttpHost httpHost2) {
            throw new Exception(httpHost2);
        }
    }

    private <T> T a(HttpHost httpHost, HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) throws Exception {
        try {
            return this.c.execute(httpHost, httpRequest, responseHandler, httpContext);
        } catch (HttpHost httpHost2) {
            throw new Exception(httpHost2);
        }
    }
}
