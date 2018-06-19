package com.bumptech.glide.integration.volley;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.android.volley.n.b;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class VolleyRequestFuture<T> implements a, b<T>, Future<T> {
    private VolleyError mException;
    private boolean mIsCancelled = false;
    private Request<?> mRequest;
    private T mResult;
    private boolean mResultReceived = false;

    public static <E> VolleyRequestFuture<E> newFuture() {
        return new VolleyRequestFuture();
    }

    public synchronized void setRequest(Request<?> request) {
        this.mRequest = request;
        if (!(this.mIsCancelled == null || this.mRequest == null)) {
            this.mRequest.cancel();
        }
    }

    public synchronized boolean cancel(boolean z) {
        if (isDone()) {
            return false;
        }
        this.mIsCancelled = true;
        if (this.mRequest != null) {
            this.mRequest.cancel();
        }
        notifyAll();
        return true;
    }

    public T get() throws InterruptedException, ExecutionException {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    private synchronized T doGet(Long l) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.mException != null) {
            throw new ExecutionException(this.mException);
        } else if (this.mResultReceived) {
            return this.mResult;
        } else if (isCancelled()) {
            throw new CancellationException();
        } else {
            if (l == null) {
                wait(0);
            } else if (l.longValue() > 0) {
                wait(l.longValue());
            }
            if (this.mException != null) {
                throw new ExecutionException(this.mException);
            } else if (isCancelled() != null) {
                throw new CancellationException();
            } else if (this.mResultReceived == null) {
                throw new TimeoutException();
            } else {
                return this.mResult;
            }
        }
    }

    public boolean isCancelled() {
        return this.mIsCancelled;
    }

    public synchronized boolean isDone() {
        boolean z;
        if (!this.mResultReceived && this.mException == null) {
            if (!isCancelled()) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    public synchronized void onResponse(T t) {
        this.mResultReceived = true;
        this.mResult = t;
        notifyAll();
    }

    public synchronized void onErrorResponse(VolleyError volleyError) {
        this.mException = volleyError;
        notifyAll();
    }
}
