package com.bumptech.glide.integration.volley;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Request.Priority;
import com.android.volley.j;
import com.android.volley.l;
import com.android.volley.n;
import com.android.volley.toolbox.k;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Collections;
import java.util.Map;

public class VolleyStreamFetcher implements DataFetcher<InputStream> {
    public static final VolleyRequestFactory DEFAULT_REQUEST_FACTORY = new VolleyRequestFactory() {
        public final Request<byte[]> create(String str, VolleyRequestFuture<InputStream> volleyRequestFuture, Priority priority, Map<String, String> map) {
            return new GlideRequest(str, volleyRequestFuture, priority, map);
        }
    };
    private final VolleyRequestFactory requestFactory;
    private VolleyRequestFuture<InputStream> requestFuture;
    private final l requestQueue;
    private final GlideUrl url;

    private static class GlideRequest extends Request<byte[]> {
        private final VolleyRequestFuture<InputStream> future;
        private final Map<String, String> headers;
        private final Priority priority;

        public GlideRequest(String str, VolleyRequestFuture<InputStream> volleyRequestFuture, Priority priority) {
            this(str, volleyRequestFuture, priority, Collections.emptyMap());
        }

        public GlideRequest(String str, VolleyRequestFuture<InputStream> volleyRequestFuture, Priority priority, Map<String, String> map) {
            super(0, str, volleyRequestFuture);
            this.future = volleyRequestFuture;
            this.priority = priority;
            this.headers = map;
        }

        public Map<String, String> getHeaders() throws AuthFailureError {
            return this.headers;
        }

        public Priority getPriority() {
            return this.priority;
        }

        protected n<byte[]> parseNetworkResponse(j jVar) {
            return n.a(jVar.b, k.a(jVar));
        }

        protected void deliverResponse(byte[] bArr) {
            this.future.onResponse(new ByteArrayInputStream(bArr));
        }
    }

    public void cleanup() {
    }

    public VolleyStreamFetcher(l lVar, GlideUrl glideUrl) {
        this(lVar, glideUrl, null);
    }

    public VolleyStreamFetcher(l lVar, GlideUrl glideUrl, VolleyRequestFuture<InputStream> volleyRequestFuture) {
        this(lVar, glideUrl, volleyRequestFuture, DEFAULT_REQUEST_FACTORY);
    }

    public VolleyStreamFetcher(l lVar, GlideUrl glideUrl, VolleyRequestFuture<InputStream> volleyRequestFuture, VolleyRequestFactory volleyRequestFactory) {
        this.requestQueue = lVar;
        this.url = glideUrl;
        this.requestFactory = volleyRequestFactory;
        this.requestFuture = volleyRequestFuture;
        if (volleyRequestFuture == null) {
            this.requestFuture = VolleyRequestFuture.newFuture();
        }
    }

    public InputStream loadData(com.bumptech.glide.Priority priority) throws Exception {
        this.requestFuture.setRequest(this.requestQueue.a(this.requestFactory.create(this.url.toStringUrl(), this.requestFuture, glideToVolleyPriority(priority), this.url.getHeaders())));
        return (InputStream) this.requestFuture.get();
    }

    public String getId() {
        return this.url.getCacheKey();
    }

    public void cancel() {
        VolleyRequestFuture volleyRequestFuture = this.requestFuture;
        if (volleyRequestFuture != null) {
            volleyRequestFuture.cancel(true);
        }
    }

    private static Priority glideToVolleyPriority(com.bumptech.glide.Priority priority) {
        switch (priority) {
            case LOW:
                return Priority.LOW;
            case HIGH:
                return Priority.HIGH;
            case IMMEDIATE:
                return Priority.IMMEDIATE;
            default:
                return Priority.NORMAL;
        }
    }
}
