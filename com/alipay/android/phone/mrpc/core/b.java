package com.alipay.android.phone.mrpc.core;

import android.net.SSLCertificateSocketFactory;
import android.util.Base64;
import android.util.Log;
import anet.channel.util.HttpConstant;
import com.alipay.sdk.packet.d;
import com.qihoo360.replugin.RePlugin;
import com.taobao.accs.common.Constants;
import com.umeng.message.util.HttpRequest;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.Security;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

public final class b implements HttpClient {
    public static long a = 160;
    private static String[] b = new String[]{"text/", "application/xml", HttpRequest.CONTENT_TYPE_JSON};
    private static final HttpRequestInterceptor c = new c();
    private final HttpClient d;
    private RuntimeException e = new IllegalStateException("AndroidHttpClient created and never closed");
    private volatile b f;

    private class a implements HttpRequestInterceptor {
        final /* synthetic */ b a;

        private a(b bVar) {
            this.a = bVar;
        }

        public final void process(org.apache.http.HttpRequest httpRequest, HttpContext httpContext) {
            b a = this.a.f;
            if (a != null && Log.isLoggable(a.a, a.b) && (httpRequest instanceof HttpUriRequest)) {
                Log.println(a.b, a.a, b.a((HttpUriRequest) httpRequest));
            }
        }
    }

    private static class b {
        private final String a;
        private final int b;
    }

    private b(ClientConnectionManager clientConnectionManager, HttpParams httpParams) {
        this.d = new d(this, clientConnectionManager, httpParams);
    }

    public static b a(String str) {
        HttpParams basicHttpParams = new BasicHttpParams();
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
        HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, true);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 20000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, com.tencent.bugly.BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpClientParams.setRedirecting(basicHttpParams, true);
        HttpClientParams.setAuthenticating(basicHttpParams, false);
        HttpProtocolParams.setUserAgent(basicHttpParams, str);
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpConstant.HTTP, PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", SSLCertificateSocketFactory.getHttpSocketFactory(com.tencent.bugly.BuglyStrategy.a.MAX_USERDATA_VALUE_LENGTH, null), Constants.PORT));
        ClientConnectionManager threadSafeClientConnManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        ConnManagerParams.setTimeout(basicHttpParams, 60000);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 50);
        Security.setProperty("networkaddress.cache.ttl", RePlugin.PROCESS_UI);
        HttpsURLConnection.setDefaultHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
        return new b(threadSafeClientConnManager, basicHttpParams);
    }

    public static InputStream a(HttpEntity httpEntity) {
        InputStream content = httpEntity.getContent();
        if (content == null) {
            return content;
        }
        Header contentEncoding = httpEntity.getContentEncoding();
        if (contentEncoding == null) {
            return content;
        }
        String value = contentEncoding.getValue();
        return value == null ? content : value.contains("gzip") ? new GZIPInputStream(content) : content;
    }

    static /* synthetic */ String a(HttpUriRequest httpUriRequest) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("curl ");
        for (Header header : httpUriRequest.getAllHeaders()) {
            if (!(header.getName().equals("Authorization") || header.getName().equals(HttpConstant.COOKIE))) {
                stringBuilder.append("--header \"");
                stringBuilder.append(header.toString().trim());
                stringBuilder.append("\" ");
            }
        }
        Object uri = httpUriRequest.getURI();
        if (httpUriRequest instanceof RequestWrapper) {
            org.apache.http.HttpRequest original = ((RequestWrapper) httpUriRequest).getOriginal();
            if (original instanceof HttpUriRequest) {
                uri = ((HttpUriRequest) original).getURI();
            }
        }
        stringBuilder.append("\"");
        stringBuilder.append(uri);
        stringBuilder.append("\"");
        if (httpUriRequest instanceof HttpEntityEnclosingRequest) {
            HttpEntity entity = ((HttpEntityEnclosingRequest) httpUriRequest).getEntity();
            if (entity != null && entity.isRepeatable()) {
                String encodeToString;
                if (entity.getContentLength() < 1024) {
                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    entity.writeTo(byteArrayOutputStream);
                    if (b(httpUriRequest)) {
                        encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
                        StringBuilder stringBuilder2 = new StringBuilder("echo '");
                        stringBuilder2.append(encodeToString);
                        stringBuilder2.append("' | base64 -d > /tmp/$$.bin; ");
                        stringBuilder.insert(0, stringBuilder2.toString());
                        encodeToString = " --data-binary @/tmp/$$.bin";
                    } else {
                        encodeToString = byteArrayOutputStream.toString();
                        stringBuilder.append(" --data-ascii \"");
                        stringBuilder.append(encodeToString);
                        encodeToString = "\"";
                    }
                } else {
                    encodeToString = " [TOO MUCH DATA TO INCLUDE]";
                }
                stringBuilder.append(encodeToString);
            }
        }
        return stringBuilder.toString();
    }

    public static AbstractHttpEntity a(byte[] bArr) {
        if (((long) bArr.length) < a) {
            return new ByteArrayEntity(bArr);
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        OutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.close();
        AbstractHttpEntity byteArrayEntity = new ByteArrayEntity(byteArrayOutputStream.toByteArray());
        byteArrayEntity.setContentEncoding("gzip");
        StringBuilder stringBuilder = new StringBuilder("gzip size:");
        stringBuilder.append(bArr.length);
        stringBuilder.append("->");
        stringBuilder.append(byteArrayEntity.getContentLength());
        return byteArrayEntity;
    }

    public static void a(org.apache.http.HttpRequest httpRequest) {
        httpRequest.addHeader("Accept-Encoding", "gzip");
    }

    public static long b(String str) {
        return k.a(str);
    }

    public static void b(org.apache.http.HttpRequest httpRequest) {
        httpRequest.addHeader(HttpConstant.CONNECTION, "Keep-Alive");
    }

    private static boolean b(HttpUriRequest httpUriRequest) {
        Header[] headers = httpUriRequest.getHeaders("content-encoding");
        if (headers != null) {
            for (Header value : headers) {
                if ("gzip".equalsIgnoreCase(value.getValue())) {
                    return true;
                }
            }
        }
        Header[] headers2 = httpUriRequest.getHeaders(d.d);
        if (headers2 != null) {
            for (Header header : headers2) {
                for (String startsWith : b) {
                    if (header.getValue().startsWith(startsWith)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public final void a(HttpRequestRetryHandler httpRequestRetryHandler) {
        ((DefaultHttpClient) this.d).setHttpRequestRetryHandler(httpRequestRetryHandler);
    }

    public final <T> T execute(HttpHost httpHost, org.apache.http.HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler) {
        return this.d.execute(httpHost, httpRequest, responseHandler);
    }

    public final <T> T execute(HttpHost httpHost, org.apache.http.HttpRequest httpRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return this.d.execute(httpHost, httpRequest, responseHandler, httpContext);
    }

    public final <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler) {
        return this.d.execute(httpUriRequest, responseHandler);
    }

    public final <T> T execute(HttpUriRequest httpUriRequest, ResponseHandler<? extends T> responseHandler, HttpContext httpContext) {
        return this.d.execute(httpUriRequest, responseHandler, httpContext);
    }

    public final HttpResponse execute(HttpHost httpHost, org.apache.http.HttpRequest httpRequest) {
        return this.d.execute(httpHost, httpRequest);
    }

    public final HttpResponse execute(HttpHost httpHost, org.apache.http.HttpRequest httpRequest, HttpContext httpContext) {
        return this.d.execute(httpHost, httpRequest, httpContext);
    }

    public final HttpResponse execute(HttpUriRequest httpUriRequest) {
        return this.d.execute(httpUriRequest);
    }

    public final HttpResponse execute(HttpUriRequest httpUriRequest, HttpContext httpContext) {
        return this.d.execute(httpUriRequest, httpContext);
    }

    public final ClientConnectionManager getConnectionManager() {
        return this.d.getConnectionManager();
    }

    public final HttpParams getParams() {
        return this.d.getParams();
    }
}
