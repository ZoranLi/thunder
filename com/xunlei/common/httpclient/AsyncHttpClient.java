package com.xunlei.common.httpclient;

import android.content.Context;
import anet.channel.util.HttpConstant;
import com.taobao.accs.common.Constants;
import com.xunlei.common.httpclient.handler.HttpResponseHandler;
import com.xunlei.common.httpclient.request.b;
import com.xunlei.common.httpclient.request.c;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.SyncBasicHttpContext;

public class AsyncHttpClient implements BaseHttpClient {
    private static final int DEFAULT_MAX_CONNECTIONS = 10;
    private static final int DEFAULT_MAX_RETRIES = 5;
    private static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    private static final int DEFAULT_SOCKET_TIMEOUT = 15000;
    private static final String ENCODING_GZIP = "gzip";
    private static final String HEADER_ACCEPT_ENCODING = "Accept-Encoding";
    private static final String VERSION = "1.4.3";
    private static int maxConnections = 10;
    private static int socketTimeout = 15000;
    private Map<String, String> clientHeaderMap;
    private ThreadSafeClientConnManager connectManager;
    private DefaultHttpClient httpClient;
    private HttpContext httpContext;
    private String mAccSDKVersion = "1.0.0.1";
    private Map<Context, List<WeakReference<Future<?>>>> requestMap;
    private ThreadPoolExecutor threadPool;

    static class a extends HttpEntityWrapper {
        public final long getContentLength() {
            return -1;
        }

        public a(HttpEntity httpEntity) {
            super(httpEntity);
        }

        public final InputStream getContent() throws IOException {
            return new GZIPInputStream(this.wrappedEntity.getContent());
        }
    }

    public AsyncHttpClient(String str) {
        this.mAccSDKVersion = str;
        initHttpParam();
    }

    public AsyncHttpClient() {
        initHttpParam();
    }

    private void initHttpParam() {
        HttpParams basicHttpParams = new BasicHttpParams();
        ConnManagerParams.setTimeout(basicHttpParams, (long) socketTimeout);
        ConnManagerParams.setMaxConnectionsPerRoute(basicHttpParams, new ConnPerRouteBean(maxConnections));
        ConnManagerParams.setMaxTotalConnections(basicHttpParams, 10);
        HttpConnectionParams.setSoTimeout(basicHttpParams, socketTimeout);
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, socketTimeout);
        HttpConnectionParams.setTcpNoDelay(basicHttpParams, true);
        HttpConnectionParams.setSocketBufferSize(basicHttpParams, 8192);
        HttpProtocolParams.setUseExpectContinue(basicHttpParams, false);
        HttpProtocolParams.setVersion(basicHttpParams, HttpVersion.HTTP_1_1);
        StringBuilder stringBuilder = new StringBuilder("android-async-http/xl-acc-sdk/version-");
        stringBuilder.append(this.mAccSDKVersion);
        HttpProtocolParams.setUserAgent(basicHttpParams, String.format(stringBuilder.toString(), new Object[]{VERSION}));
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpConstant.HTTP, PlainSocketFactory.getSocketFactory(), 80));
        this.connectManager = new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry);
        this.httpContext = new SyncBasicHttpContext(new BasicHttpContext());
        this.httpClient = new DefaultHttpClient(this.connectManager, basicHttpParams);
        this.httpClient.addRequestInterceptor(new HttpRequestInterceptor(this) {
            private /* synthetic */ AsyncHttpClient a;

            {
                this.a = r1;
            }

            public final void process(HttpRequest httpRequest, HttpContext httpContext) {
                if (httpRequest.containsHeader("Accept-Encoding") == null) {
                    httpRequest.addHeader("Accept-Encoding", "gzip");
                }
                for (String str : this.a.clientHeaderMap.keySet()) {
                    httpRequest.addHeader(str, (String) this.a.clientHeaderMap.get(str));
                }
            }
        });
        this.httpClient.addResponseInterceptor(new HttpResponseInterceptor(this) {
            private /* synthetic */ AsyncHttpClient a;

            public final void process(HttpResponse httpResponse, HttpContext httpContext) {
                httpContext = httpResponse.getEntity();
                if (httpContext != null) {
                    httpContext = httpContext.getContentEncoding();
                    if (httpContext != null) {
                        for (HeaderElement name : httpContext.getElements()) {
                            if (name.getName().equalsIgnoreCase("gzip")) {
                                httpResponse.setEntity(new a(httpResponse.getEntity()));
                                return;
                            }
                        }
                    }
                }
            }
        });
        this.httpClient.setHttpRequestRetryHandler(new c(5));
        this.threadPool = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        this.requestMap = new WeakHashMap();
        this.clientHeaderMap = new HashMap();
    }

    public HttpClient getHttpClient() {
        return this.httpClient;
    }

    public HttpContext getHttpContext() {
        return this.httpContext;
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.httpContext.setAttribute("http.cookie-store", cookieStore);
    }

    public void setThreadPool(ThreadPoolExecutor threadPoolExecutor) {
        this.threadPool = threadPoolExecutor;
    }

    public void setUserAgent(String str) {
        HttpProtocolParams.setUserAgent(this.httpClient.getParams(), str);
    }

    public void setTimeout(int i) {
        HttpParams params = this.httpClient.getParams();
        ConnManagerParams.setTimeout(params, (long) i);
        HttpConnectionParams.setSoTimeout(params, i);
        HttpConnectionParams.setConnectionTimeout(params, i);
    }

    public void setSSLSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https", sSLSocketFactory, Constants.PORT));
    }

    public void clearInvalidConnections() {
        this.connectManager.closeExpiredConnections();
        this.connectManager.closeIdleConnections(30, TimeUnit.SECONDS);
    }

    public void addHeader(String str, String str2) {
        this.clientHeaderMap.put(str, str2);
    }

    public void setBasicAuth(String str, String str2) {
        setBasicAuth(str, str2, AuthScope.ANY);
    }

    public void setBasicAuth(String str, String str2, AuthScope authScope) {
        this.httpClient.getCredentialsProvider().setCredentials(authScope, new UsernamePasswordCredentials(str, str2));
    }

    public void cancelRequests(Context context, boolean z) {
        List<WeakReference> list = (List) this.requestMap.get(context);
        if (list != null) {
            for (WeakReference weakReference : list) {
                Future future = (Future) weakReference.get();
                if (future != null) {
                    future.cancel(z);
                }
            }
        }
        this.requestMap.remove(context);
    }

    public void get(String str, HttpResponseHandler httpResponseHandler) {
        get(null, str, null, httpResponseHandler);
    }

    public void get(String str, b bVar, HttpResponseHandler httpResponseHandler) {
        get(null, str, bVar, httpResponseHandler);
    }

    public void get(Context context, String str, HttpResponseHandler httpResponseHandler) {
        get(context, str, null, httpResponseHandler);
    }

    public void get(Context context, String str, b bVar, HttpResponseHandler httpResponseHandler) {
        try {
            sendRequest(this.httpClient, this.httpContext, new HttpGet(getUrlWithQueryString(str, bVar)), null, httpResponseHandler, context);
        } catch (Context context2) {
            context2.printStackTrace();
            httpResponseHandler.sendFailureMessage(context2, "".getBytes());
        }
    }

    public void get(Context context, String str, Header[] headerArr, b bVar, HttpResponseHandler httpResponseHandler) {
        try {
            HttpUriRequest httpGet = new HttpGet(getUrlWithQueryString(str, bVar));
            if (headerArr != null) {
                httpGet.setHeaders(headerArr);
            }
            sendRequest(this.httpClient, this.httpContext, httpGet, null, httpResponseHandler, context);
        } catch (Context context2) {
            context2.printStackTrace();
            httpResponseHandler.sendFailureMessage(context2, "".getBytes());
        }
    }

    public void post(String str, HttpResponseHandler httpResponseHandler) {
        post(null, str, null, httpResponseHandler);
    }

    public void post(String str, b bVar, HttpResponseHandler httpResponseHandler) {
        post(null, str, bVar, httpResponseHandler);
    }

    public void post(Context context, String str, b bVar, HttpResponseHandler httpResponseHandler) {
        post(context, str, paramsToEntity(bVar), null, httpResponseHandler);
    }

    public void post(Context context, String str, HttpEntity httpEntity, String str2, HttpResponseHandler httpResponseHandler) {
        HttpPost httpPost = (HttpPost) newHttpMethod("Post", str, null);
        if (httpPost == null) {
            httpResponseHandler.sendFailureMessage(new IllegalArgumentException("the url is invlid."), "the url is invlid.".getBytes());
        } else {
            sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(httpPost, httpEntity), str2, httpResponseHandler, context);
        }
    }

    public void post(Context context, String str, Header[] headerArr, b bVar, String str2, HttpResponseHandler httpResponseHandler) {
        HttpPost httpPost = (HttpPost) newHttpMethod("Post", str, bVar);
        if (httpPost == null) {
            httpResponseHandler.sendFailureMessage(new IllegalArgumentException("the url is invlid."), "the url is invlid.".getBytes());
            return;
        }
        if (bVar != null) {
            httpPost.setEntity(paramsToEntity(bVar));
        }
        if (headerArr != null) {
            httpPost.setHeaders(headerArr);
        }
        sendRequest(this.httpClient, this.httpContext, httpPost, str2, httpResponseHandler, context);
    }

    public void post(Context context, String str, Header[] headerArr, HttpEntity httpEntity, String str2, HttpResponseHandler httpResponseHandler, int i) {
        HttpPost httpPost = (HttpPost) newHttpMethod("Post", str, null);
        if (httpPost == null) {
            httpResponseHandler.sendFailureMessage(new IllegalArgumentException("the url is invlid."), "the url is invlid.".getBytes());
            return;
        }
        HttpUriRequest addEntityToRequestBase = addEntityToRequestBase(httpPost, httpEntity);
        if (headerArr != null) {
            addEntityToRequestBase.setHeaders(headerArr);
        }
        sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase, str2, httpResponseHandler, context, i);
    }

    public void put(String str, HttpResponseHandler httpResponseHandler) {
        put(null, str, null, httpResponseHandler);
    }

    public void put(String str, b bVar, HttpResponseHandler httpResponseHandler) {
        put(null, str, bVar, httpResponseHandler);
    }

    public void put(Context context, String str, b bVar, HttpResponseHandler httpResponseHandler) {
        put(context, str, paramsToEntity(bVar), null, httpResponseHandler);
    }

    public void put(Context context, String str, HttpEntity httpEntity, String str2, HttpResponseHandler httpResponseHandler) {
        HttpPut httpPut = (HttpPut) newHttpMethod("Put", str, null);
        if (httpPut == null) {
            httpResponseHandler.sendFailureMessage(new IllegalArgumentException("the url is invlid."), "the url is invlid.".getBytes());
        } else {
            sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase(httpPut, httpEntity), str2, httpResponseHandler, context);
        }
    }

    public void put(Context context, String str, Header[] headerArr, HttpEntity httpEntity, String str2, HttpResponseHandler httpResponseHandler) {
        HttpPut httpPut = (HttpPut) newHttpMethod("Put", str, null);
        if (httpPut == null) {
            httpResponseHandler.sendFailureMessage(new IllegalArgumentException("the url is invlid."), "the url is invlid.".getBytes());
            return;
        }
        HttpUriRequest addEntityToRequestBase = addEntityToRequestBase(httpPut, httpEntity);
        if (headerArr != null) {
            addEntityToRequestBase.setHeaders(headerArr);
        }
        sendRequest(this.httpClient, this.httpContext, addEntityToRequestBase, str2, httpResponseHandler, context);
    }

    public void delete(String str, HttpResponseHandler httpResponseHandler) {
        delete(null, str, httpResponseHandler);
    }

    public void delete(Context context, String str, HttpResponseHandler httpResponseHandler) {
        HttpDelete httpDelete = (HttpDelete) newHttpMethod("Delete", str, null);
        if (httpDelete == null) {
            httpResponseHandler.sendFailureMessage(new IllegalArgumentException("the url is invlid."), "the url is invlid.".getBytes());
        } else {
            sendRequest(this.httpClient, this.httpContext, httpDelete, null, httpResponseHandler, context);
        }
    }

    public void delete(Context context, String str, Header[] headerArr, HttpResponseHandler httpResponseHandler) {
        HttpDelete httpDelete = (HttpDelete) newHttpMethod("Delete", str, null);
        if (httpDelete == null) {
            httpResponseHandler.sendFailureMessage(new IllegalArgumentException("the url is invlid."), "the url is invlid.".getBytes());
            return;
        }
        if (headerArr != null) {
            httpDelete.setHeaders(headerArr);
        }
        sendRequest(this.httpClient, this.httpContext, httpDelete, null, httpResponseHandler, context);
    }

    protected void sendRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, HttpResponseHandler httpResponseHandler, Context context) {
        sendRequest(defaultHttpClient, httpContext, httpUriRequest, str, httpResponseHandler, context, 0);
    }

    protected void sendRequest(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, HttpResponseHandler httpResponseHandler, Context context, int i) {
        if (i >= 1000) {
            httpUriRequest.getParams().setParameter("http.connection.timeout", Integer.valueOf(i));
            httpUriRequest.getParams().setParameter("http.socket.timeout", Integer.valueOf(i));
        }
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        defaultHttpClient = this.threadPool.submit(new com.xunlei.common.httpclient.request.a(defaultHttpClient, httpContext, httpUriRequest, httpResponseHandler));
        if (context != null) {
            httpContext = (List) this.requestMap.get(context);
            if (httpContext == null) {
                httpContext = new LinkedList();
                this.requestMap.put(context, httpContext);
            }
            httpContext.add(new WeakReference(defaultHttpClient));
        }
    }

    public static String getUrlWithQueryString(String str, b bVar) {
        if (bVar == null) {
            return str;
        }
        bVar = bVar.b();
        if (str.indexOf("?") == -1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("?");
            stringBuilder.append(bVar);
            return stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append("&");
        stringBuilder.append(bVar);
        return stringBuilder.toString();
    }

    private HttpRequest newHttpMethod(String str, String str2, b bVar) {
        str2 = getUrlWithQueryString(str2, bVar);
        bVar = null;
        try {
            if ("Get".equalsIgnoreCase(str)) {
                return new HttpGet(str2);
            }
            if ("Post".equalsIgnoreCase(str)) {
                return new HttpPost(str2);
            }
            if ("Put".equalsIgnoreCase(str)) {
                return new HttpPut(str2);
            }
            if ("Delete".equalsIgnoreCase(str) != null) {
                bVar = new HttpDelete(str2);
            }
            return bVar;
        } catch (String str3) {
            str3.printStackTrace();
        }
    }

    private HttpEntity paramsToEntity(b bVar) {
        return bVar != null ? bVar.a() : null;
    }

    private HttpEntityEnclosingRequestBase addEntityToRequestBase(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, HttpEntity httpEntity) {
        if (httpEntity != null) {
            httpEntityEnclosingRequestBase.setEntity(httpEntity);
        }
        return httpEntityEnclosingRequestBase;
    }

    public void post(Context context, String str, Header[] headerArr, byte[] bArr, BaseHttpClientListener baseHttpClientListener) {
        post(context, str, headerArr, bArr, baseHttpClientListener, 0);
    }

    public void post(Context context, String str, Header[] headerArr, byte[] bArr, final BaseHttpClientListener baseHttpClientListener, int i) {
        post(context, str, headerArr, bArr != null ? new ByteArrayEntity(bArr) : null, null, new HttpResponseHandler(this) {
            private /* synthetic */ AsyncHttpClient b;

            public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                baseHttpClientListener.onSuccess(i, headerArr, bArr);
            }

            public final void onFailure(Throwable th, byte[] bArr) {
                baseHttpClientListener.onFailure(th, bArr);
            }
        }, i);
    }

    public void get(Context context, String str, Header[] headerArr, final BaseHttpClientListener baseHttpClientListener) {
        get(context, str, headerArr, null, new HttpResponseHandler(this) {
            private /* synthetic */ AsyncHttpClient b;

            public final void onSuccess(int i, Header[] headerArr, byte[] bArr) {
                baseHttpClientListener.onSuccess(i, headerArr, bArr);
            }

            public final void onFailure(Throwable th, byte[] bArr) {
                baseHttpClientListener.onFailure(th, bArr);
            }
        });
    }

    public void setHttpClientTimeout(int i) {
        setTimeout(i);
    }
}
