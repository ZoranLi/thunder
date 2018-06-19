package com.xunlei.common.net.volley;

import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.android.volley.n.b;

public class ResponseListenerWrapper<T> implements a, b<T> {
    private a mErrorListener;
    private b<T> mListener;

    public ResponseListenerWrapper(b<T> bVar, a aVar) {
        this.mErrorListener = aVar;
        this.mListener = bVar;
    }

    public void onErrorResponse(VolleyError volleyError) {
        if (this.mErrorListener != null) {
            this.mErrorListener.onErrorResponse(volleyError);
            this.mErrorListener = null;
        }
    }

    public void onResponse(T t) {
        if (this.mListener != null) {
            this.mListener.onResponse(t);
            this.mListener = null;
        }
        clear();
    }

    public void clear() {
        this.mErrorListener = null;
        this.mListener = null;
    }
}
