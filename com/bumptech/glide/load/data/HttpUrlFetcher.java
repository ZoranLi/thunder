package com.bumptech.glide.load.data;

import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.util.ContentLengthInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUrlFetcher implements DataFetcher<InputStream> {
    private static final HttpUrlConnectionFactory DEFAULT_CONNECTION_FACTORY = new DefaultHttpUrlConnectionFactory();
    private static final int MAXIMUM_REDIRECTS = 5;
    private static final String TAG = "HttpUrlFetcher";
    private final HttpUrlConnectionFactory connectionFactory;
    private final GlideUrl glideUrl;
    private volatile boolean isCancelled;
    private InputStream stream;
    private HttpURLConnection urlConnection;

    interface HttpUrlConnectionFactory {
        HttpURLConnection build(URL url) throws IOException;
    }

    private static class DefaultHttpUrlConnectionFactory implements HttpUrlConnectionFactory {
        private DefaultHttpUrlConnectionFactory() {
        }

        public HttpURLConnection build(URL url) throws IOException {
            return (HttpURLConnection) url.openConnection();
        }
    }

    public HttpUrlFetcher(GlideUrl glideUrl) {
        this(glideUrl, DEFAULT_CONNECTION_FACTORY);
    }

    HttpUrlFetcher(GlideUrl glideUrl, HttpUrlConnectionFactory httpUrlConnectionFactory) {
        this.glideUrl = glideUrl;
        this.connectionFactory = httpUrlConnectionFactory;
    }

    public InputStream loadData(Priority priority) throws Exception {
        return loadDataWithRedirects(this.glideUrl.toURL(), 0, null, this.glideUrl.getHeaders());
    }

    private java.io.InputStream loadDataWithRedirects(java.net.URL r4, int r5, java.net.URL r6, java.util.Map<java.lang.String, java.lang.String> r7) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
    L_0x0000:
        r0 = 5;
        if (r5 < r0) goto L_0x000b;
    L_0x0003:
        r4 = new java.io.IOException;
        r5 = "Too many (> 5) redirects!";
        r4.<init>(r5);
        throw r4;
    L_0x000b:
        if (r6 == 0) goto L_0x0023;
    L_0x000d:
        r0 = r4.toURI();	 Catch:{ URISyntaxException -> 0x0023 }
        r6 = r6.toURI();	 Catch:{ URISyntaxException -> 0x0023 }
        r6 = r0.equals(r6);	 Catch:{ URISyntaxException -> 0x0023 }
        if (r6 == 0) goto L_0x0023;	 Catch:{ URISyntaxException -> 0x0023 }
    L_0x001b:
        r6 = new java.io.IOException;	 Catch:{ URISyntaxException -> 0x0023 }
        r0 = "In re-direct loop";	 Catch:{ URISyntaxException -> 0x0023 }
        r6.<init>(r0);	 Catch:{ URISyntaxException -> 0x0023 }
        throw r6;	 Catch:{ URISyntaxException -> 0x0023 }
    L_0x0023:
        r6 = r3.connectionFactory;
        r6 = r6.build(r4);
        r3.urlConnection = r6;
        r6 = r7.entrySet();
        r6 = r6.iterator();
    L_0x0033:
        r0 = r6.hasNext();
        if (r0 == 0) goto L_0x0051;
    L_0x0039:
        r0 = r6.next();
        r0 = (java.util.Map.Entry) r0;
        r1 = r3.urlConnection;
        r2 = r0.getKey();
        r2 = (java.lang.String) r2;
        r0 = r0.getValue();
        r0 = (java.lang.String) r0;
        r1.addRequestProperty(r2, r0);
        goto L_0x0033;
    L_0x0051:
        r6 = r3.urlConnection;
        r0 = 2500; // 0x9c4 float:3.503E-42 double:1.235E-320;
        r6.setConnectTimeout(r0);
        r6 = r3.urlConnection;
        r6.setReadTimeout(r0);
        r6 = r3.urlConnection;
        r0 = 0;
        r6.setUseCaches(r0);
        r6 = r3.urlConnection;
        r0 = 1;
        r6.setDoInput(r0);
        r6 = r3.urlConnection;
        r6.connect();
        r6 = r3.isCancelled;
        if (r6 == 0) goto L_0x0074;
    L_0x0072:
        r4 = 0;
        return r4;
    L_0x0074:
        r6 = r3.urlConnection;
        r6 = r6.getResponseCode();
        r0 = r6 / 100;
        r1 = 2;
        if (r0 != r1) goto L_0x0086;
    L_0x007f:
        r4 = r3.urlConnection;
        r4 = r3.getStreamForSuccessfulRequest(r4);
        return r4;
    L_0x0086:
        r1 = 3;
        if (r0 != r1) goto L_0x00aa;
    L_0x0089:
        r6 = r3.urlConnection;
        r0 = "Location";
        r6 = r6.getHeaderField(r0);
        r0 = android.text.TextUtils.isEmpty(r6);
        if (r0 == 0) goto L_0x009f;
    L_0x0097:
        r4 = new java.io.IOException;
        r5 = "Received empty or null redirect url";
        r4.<init>(r5);
        throw r4;
    L_0x009f:
        r0 = new java.net.URL;
        r0.<init>(r4, r6);
        r5 = r5 + 1;
        r6 = r4;
        r4 = r0;
        goto L_0x0000;
    L_0x00aa:
        r4 = -1;
        if (r6 != r4) goto L_0x00b5;
    L_0x00ad:
        r4 = new java.io.IOException;
        r5 = "Unable to retrieve response code from HttpUrlConnection.";
        r4.<init>(r5);
        throw r4;
    L_0x00b5:
        r4 = new java.io.IOException;
        r5 = new java.lang.StringBuilder;
        r7 = "Request failed ";
        r5.<init>(r7);
        r5.append(r6);
        r6 = ": ";
        r5.append(r6);
        r6 = r3.urlConnection;
        r6 = r6.getResponseMessage();
        r5.append(r6);
        r5 = r5.toString();
        r4.<init>(r5);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.HttpUrlFetcher.loadDataWithRedirects(java.net.URL, int, java.net.URL, java.util.Map):java.io.InputStream");
    }

    private InputStream getStreamForSuccessfulRequest(HttpURLConnection httpURLConnection) throws IOException {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.stream = ContentLengthInputStream.obtain(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable(TAG, 3)) {
                new StringBuilder("Got non empty content encoding: ").append(httpURLConnection.getContentEncoding());
            }
            this.stream = httpURLConnection.getInputStream();
        }
        return this.stream;
    }

    public void cleanup() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.stream;
        if (r0 == 0) goto L_0x0009;
    L_0x0004:
        r0 = r1.stream;	 Catch:{ IOException -> 0x0009 }
        r0.close();	 Catch:{ IOException -> 0x0009 }
    L_0x0009:
        r0 = r1.urlConnection;
        if (r0 == 0) goto L_0x0012;
    L_0x000d:
        r0 = r1.urlConnection;
        r0.disconnect();
    L_0x0012:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.HttpUrlFetcher.cleanup():void");
    }

    public String getId() {
        return this.glideUrl.getCacheKey();
    }

    public void cancel() {
        this.isCancelled = true;
    }
}
