package com.android.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;

public abstract class Request<T> implements Comparable<Request<T>> {
    private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
    private com.android.volley.a.a mCacheEntry;
    private boolean mCanceled;
    private final int mDefaultTrafficStatsTag;
    private com.android.volley.n.a mErrorListener;
    private final a mEventLog;
    private final Object mLock;
    private final int mMethod;
    private a mRequestCompleteListener;
    private l mRequestQueue;
    private boolean mResponseDelivered;
    private p mRetryPolicy;
    private Integer mSequence;
    private boolean mShouldCache;
    private boolean mShouldRetryServerErrors;
    private Object mTag;
    private final String mUrl;

    public enum Priority {
        LOW,
        NORMAL,
        HIGH,
        IMMEDIATE
    }

    interface a {
        void a(Request<?> request);

        void a(Request<?> request, n<?> nVar);
    }

    public abstract void deliverResponse(T t);

    public Map<String, String> getParams() throws AuthFailureError {
        return null;
    }

    protected String getParamsEncoding() {
        return "UTF-8";
    }

    protected VolleyError parseNetworkError(VolleyError volleyError) {
        return volleyError;
    }

    public abstract n<T> parseNetworkResponse(j jVar);

    @Deprecated
    public Request(String str, com.android.volley.n.a aVar) {
        this(-1, str, aVar);
    }

    public Request(int i, String str, com.android.volley.n.a aVar) {
        this.mEventLog = a.a ? new a() : null;
        this.mLock = new Object();
        this.mShouldCache = true;
        this.mCanceled = false;
        this.mResponseDelivered = false;
        this.mShouldRetryServerErrors = false;
        this.mCacheEntry = null;
        this.mMethod = i;
        this.mUrl = str;
        this.mErrorListener = aVar;
        setRetryPolicy(new d());
        this.mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(str);
    }

    public int getMethod() {
        return this.mMethod;
    }

    public Request<?> setTag(Object obj) {
        this.mTag = obj;
        return this;
    }

    public Object getTag() {
        return this.mTag;
    }

    public com.android.volley.n.a getErrorListener() {
        return this.mErrorListener;
    }

    public int getTrafficStatsTag() {
        return this.mDefaultTrafficStatsTag;
    }

    private static int findDefaultTrafficStatsTag(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = Uri.parse(str);
            if (str != null) {
                str = str.getHost();
                if (str != null) {
                    return str.hashCode();
                }
            }
        }
        return null;
    }

    public Request<?> setRetryPolicy(p pVar) {
        this.mRetryPolicy = pVar;
        return this;
    }

    public void addMarker(String str) {
        if (a.a) {
            this.mEventLog.a(str, Thread.currentThread().getId());
        }
    }

    void finish(String str) {
        if (this.mRequestQueue != null) {
            this.mRequestQueue.b(this);
        }
        if (a.a) {
            long id = Thread.currentThread().getId();
            if (Looper.myLooper() != Looper.getMainLooper()) {
                new Handler(Looper.getMainLooper()).post(new k(this, str, id));
            } else {
                this.mEventLog.a(str, id);
                this.mEventLog.a(toString());
            }
        }
    }

    public Request<?> setRequestQueue(l lVar) {
        this.mRequestQueue = lVar;
        return this;
    }

    public final Request<?> setSequence(int i) {
        this.mSequence = Integer.valueOf(i);
        return this;
    }

    public final int getSequence() {
        if (this.mSequence != null) {
            return this.mSequence.intValue();
        }
        throw new IllegalStateException("getSequence called before setSequence");
    }

    public String getUrl() {
        return this.mUrl;
    }

    public String getCacheKey() {
        return getUrl();
    }

    public Request<?> setCacheEntry(com.android.volley.a.a aVar) {
        this.mCacheEntry = aVar;
        return this;
    }

    public com.android.volley.a.a getCacheEntry() {
        return this.mCacheEntry;
    }

    public void cancel() {
        synchronized (this.mLock) {
            this.mCanceled = true;
            this.mErrorListener = null;
        }
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mCanceled;
        }
        return z;
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        return Collections.emptyMap();
    }

    @Deprecated
    protected Map<String, String> getPostParams() throws AuthFailureError {
        return getParams();
    }

    @Deprecated
    protected String getPostParamsEncoding() {
        return getParamsEncoding();
    }

    @Deprecated
    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    @Deprecated
    public byte[] getPostBody() throws AuthFailureError {
        Map postParams = getPostParams();
        return (postParams == null || postParams.size() <= 0) ? null : encodeParameters(postParams, getPostParamsEncoding());
    }

    public String getBodyContentType() {
        StringBuilder stringBuilder = new StringBuilder("application/x-www-form-urlencoded; charset=");
        stringBuilder.append(getParamsEncoding());
        return stringBuilder.toString();
    }

    public byte[] getBody() throws AuthFailureError {
        Map params = getParams();
        return (params == null || params.size() <= 0) ? null : encodeParameters(params, getParamsEncoding());
    }

    private byte[] encodeParameters(Map<String, String> map, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            map = map.entrySet().iterator();
            while (map.hasNext()) {
                Entry entry = (Entry) map.next();
                stringBuilder.append(URLEncoder.encode((String) entry.getKey(), str));
                stringBuilder.append('=');
                stringBuilder.append(URLEncoder.encode((String) entry.getValue(), str));
                stringBuilder.append('&');
            }
            return stringBuilder.toString().getBytes(str);
        } catch (Map<String, String> map2) {
            StringBuilder stringBuilder2 = new StringBuilder("Encoding not supported: ");
            stringBuilder2.append(str);
            throw new RuntimeException(stringBuilder2.toString(), map2);
        }
    }

    public final Request<?> setShouldCache(boolean z) {
        this.mShouldCache = z;
        return this;
    }

    public final boolean shouldCache() {
        return this.mShouldCache;
    }

    public final Request<?> setShouldRetryServerErrors(boolean z) {
        this.mShouldRetryServerErrors = z;
        return this;
    }

    public final boolean shouldRetryServerErrors() {
        return this.mShouldRetryServerErrors;
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    public final int getTimeoutMs() {
        return this.mRetryPolicy.a();
    }

    public p getRetryPolicy() {
        return this.mRetryPolicy;
    }

    public void markDelivered() {
        synchronized (this.mLock) {
            this.mResponseDelivered = true;
        }
    }

    public boolean hasHadResponseDelivered() {
        boolean z;
        synchronized (this.mLock) {
            z = this.mResponseDelivered;
        }
        return z;
    }

    public void deliverError(VolleyError volleyError) {
        synchronized (this.mLock) {
            com.android.volley.n.a aVar = this.mErrorListener;
        }
        if (aVar != null) {
            aVar.onErrorResponse(volleyError);
        }
    }

    void setNetworkRequestCompleteListener(a aVar) {
        synchronized (this.mLock) {
            this.mRequestCompleteListener = aVar;
        }
    }

    void notifyListenerResponseReceived(n<?> nVar) {
        synchronized (this.mLock) {
            a aVar = this.mRequestCompleteListener;
        }
        if (aVar != null) {
            aVar.a(this, nVar);
        }
    }

    void notifyListenerResponseNotUsable() {
        synchronized (this.mLock) {
            a aVar = this.mRequestCompleteListener;
        }
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public int compareTo(Request<T> request) {
        Priority priority = getPriority();
        Priority priority2 = request.getPriority();
        if (priority == priority2) {
            return this.mSequence.intValue() - request.mSequence.intValue();
        }
        return priority2.ordinal() - priority.ordinal();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("0x");
        stringBuilder.append(Integer.toHexString(getTrafficStatsTag()));
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(this.mCanceled ? "[X] " : "[ ] ");
        stringBuilder3.append(getUrl());
        stringBuilder3.append(" ");
        stringBuilder3.append(stringBuilder2);
        stringBuilder3.append(" ");
        stringBuilder3.append(getPriority());
        stringBuilder3.append(" ");
        stringBuilder3.append(this.mSequence);
        return stringBuilder3.toString();
    }
}
