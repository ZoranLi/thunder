package com.android.volley;

public class VolleyError extends Exception {
    public final j networkResponse;
    private long networkTimeMs;

    public VolleyError() {
        this.networkResponse = null;
    }

    public VolleyError(j jVar) {
        this.networkResponse = jVar;
    }

    public VolleyError(String str) {
        super(str);
        this.networkResponse = null;
    }

    public VolleyError(String str, Throwable th) {
        super(str, th);
        this.networkResponse = null;
    }

    public VolleyError(Throwable th) {
        super(th);
        this.networkResponse = null;
    }

    void setNetworkTimeMs(long j) {
        this.networkTimeMs = j;
    }

    public long getNetworkTimeMs() {
        return this.networkTimeMs;
    }
}
