package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;

@Deprecated
/* compiled from: HttpClientStack */
public final class j implements m {
    protected final HttpClient a;

    /* compiled from: HttpClientStack */
    public static final class a extends HttpEntityEnclosingRequestBase {
        public final String getMethod() {
            return "PATCH";
        }

        public a(String str) {
            setURI(URI.create(str));
        }
    }

    public j(HttpClient httpClient) {
        this.a = httpClient;
    }

    private static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        for (String str : map.keySet()) {
            httpUriRequest.setHeader(str, (String) map.get(str));
        }
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request<?> request) throws AuthFailureError {
        request = request.getBody();
        if (request != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(request));
        }
    }

    public final HttpResponse b(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        HttpUriRequest httpGet;
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody == null) {
                    httpGet = new HttpGet(request.getUrl());
                    break;
                }
                HttpPost httpPost = new HttpPost(request.getUrl());
                httpPost.addHeader("Content-Type", request.getPostBodyContentType());
                httpPost.setEntity(new ByteArrayEntity(postBody));
                httpGet = httpPost;
                break;
            case 0:
                httpGet = new HttpGet(request.getUrl());
                break;
            case 1:
                httpGet = new HttpPost(request.getUrl());
                httpGet.addHeader("Content-Type", request.getBodyContentType());
                a((HttpEntityEnclosingRequestBase) httpGet, (Request) request);
                break;
            case 2:
                httpGet = new HttpPut(request.getUrl());
                httpGet.addHeader("Content-Type", request.getBodyContentType());
                a((HttpEntityEnclosingRequestBase) httpGet, (Request) request);
                break;
            case 3:
                httpGet = new HttpDelete(request.getUrl());
                break;
            case 4:
                httpGet = new HttpHead(request.getUrl());
                break;
            case 5:
                httpGet = new HttpOptions(request.getUrl());
                break;
            case 6:
                httpGet = new HttpTrace(request.getUrl());
                break;
            case 7:
                httpGet = new a(request.getUrl());
                httpGet.addHeader("Content-Type", request.getBodyContentType());
                a((HttpEntityEnclosingRequestBase) httpGet, (Request) request);
                break;
            default:
                throw new IllegalStateException("Unknown request method.");
        }
        a(httpGet, (Map) map);
        a(httpGet, request.getHeaders());
        map = httpGet.getParams();
        request = request.getTimeoutMs();
        HttpConnectionParams.setConnectionTimeout(map, ReaderCallback.GET_BAR_ANIMATING);
        HttpConnectionParams.setSoTimeout(map, request);
        return this.a.execute(httpGet);
    }
}
