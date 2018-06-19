package com.android.volley.toolbox;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.g;
import com.umeng.message.util.HttpRequest;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: HurlStack */
public class n extends c {
    private final a a;
    private final SSLSocketFactory b;

    /* compiled from: HurlStack */
    public interface a {
        String a();
    }

    public n() {
        this((byte) 0);
    }

    private n(byte b) {
        this((char) (byte) 0);
    }

    private n(char c) {
        this.a = null;
        this.b = null;
    }

    public final l a(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        String url = request.getUrl();
        HashMap hashMap = new HashMap();
        hashMap.putAll(request.getHeaders());
        hashMap.putAll(map);
        if (this.a != null) {
            map = this.a.a();
            if (map == null) {
                map = new StringBuilder("URL blocked by rewriter: ");
                map.append(url);
                throw new IOException(map.toString());
            }
        }
        map = url;
        URL url2 = new URL(map);
        HttpURLConnection a = a(url2);
        int timeoutMs = request.getTimeoutMs();
        a.setConnectTimeout(timeoutMs);
        a.setReadTimeout(timeoutMs);
        boolean z = false;
        a.setUseCaches(false);
        a.setDoInput(true);
        if ("https".equals(url2.getProtocol()) && this.b != null) {
            ((HttpsURLConnection) a).setSSLSocketFactory(this.b);
        }
        for (String str : hashMap.keySet()) {
            a.addRequestProperty(str, (String) hashMap.get(str));
        }
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    a.setRequestMethod("POST");
                    a(a, request, postBody);
                    break;
                }
                break;
            case 0:
                a.setRequestMethod("GET");
                break;
            case 1:
                a.setRequestMethod("POST");
                a(a, (Request) request);
                break;
            case 2:
                a.setRequestMethod("PUT");
                a(a, (Request) request);
                break;
            case 3:
                a.setRequestMethod("DELETE");
                break;
            case 4:
                a.setRequestMethod("HEAD");
                break;
            case 5:
                a.setRequestMethod("OPTIONS");
                break;
            case 6:
                a.setRequestMethod(HttpRequest.METHOD_TRACE);
                break;
            case 7:
                a.setRequestMethod("PATCH");
                a(a, (Request) request);
                break;
            default:
                throw new IllegalStateException("Unknown method type.");
        }
        int responseCode = a.getResponseCode();
        if (responseCode == -1) {
            throw new IOException("Could not retrieve response code from HttpUrlConnection.");
        }
        if (!(request.getMethod() == 4 || ((100 <= responseCode && responseCode < 200) || responseCode == 204 || responseCode == 304))) {
            z = true;
        }
        if (z) {
            return new l(responseCode, a(a.getHeaderFields()), a.getContentLength(), a(a));
        }
        return new l(responseCode, a(a.getHeaderFields()));
    }

    private static List<g> a(Map<String, List<String>> map) {
        List<g> arrayList = new ArrayList(map.size());
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            if (entry.getKey() != null) {
                for (String gVar : (List) entry.getValue()) {
                    arrayList.add(new g((String) entry.getKey(), gVar));
                }
            }
        }
        return arrayList;
    }

    private static java.io.InputStream a(java.net.HttpURLConnection r1) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r1.getInputStream();	 Catch:{ IOException -> 0x0005 }
        goto L_0x0009;
    L_0x0005:
        r0 = r1.getErrorStream();
    L_0x0009:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.volley.toolbox.n.a(java.net.HttpURLConnection):java.io.InputStream");
    }

    public HttpURLConnection a(URL url) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setInstanceFollowRedirects(HttpURLConnection.getFollowRedirects());
        return httpURLConnection;
    }

    private static void a(HttpURLConnection httpURLConnection, Request<?> request) throws IOException, AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            a(httpURLConnection, request, body);
        }
    }

    private static void a(HttpURLConnection httpURLConnection, Request<?> request, byte[] bArr) throws IOException, AuthFailureError {
        httpURLConnection.setDoOutput(true);
        httpURLConnection.addRequestProperty("Content-Type", request.getBodyContentType());
        request = new DataOutputStream(httpURLConnection.getOutputStream());
        request.write(bArr);
        request.close();
    }
}
