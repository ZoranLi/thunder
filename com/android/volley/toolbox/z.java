package com.android.volley.toolbox;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.android.volley.n.a;
import com.android.volley.n.b;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: RequestFuture */
public final class z<T> implements a, b<T>, Future<T> {
    private Request<?> a;
    private boolean b = false;
    private T c;
    private VolleyError d;

    public static <E> z<E> a() {
        return new z();
    }

    private z() {
    }

    public final synchronized boolean cancel(boolean z) {
        if (!this.a) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.a.cancel();
        return true;
    }

    public final T get() throws InterruptedException, ExecutionException {
        try {
            return a(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public final T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    private synchronized T a(Long l) throws InterruptedException, ExecutionException, TimeoutException {
        if (this.d != null) {
            throw new ExecutionException(this.d);
        } else if (this.b) {
            return this.c;
        } else {
            if (l == null) {
                wait(0);
            } else if (l.longValue() > 0) {
                wait(l.longValue());
            }
            if (this.d != null) {
                throw new ExecutionException(this.d);
            } else if (this.b == null) {
                throw new TimeoutException();
            } else {
                return this.c;
            }
        }
    }

    public final boolean isCancelled() {
        if (this.a == null) {
            return false;
        }
        return this.a.isCanceled();
    }

    public final synchronized boolean isDone() {
        boolean z;
        if (!this.b && this.d == null) {
            if (!isCancelled()) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    public final synchronized void onResponse(T t) {
        this.b = true;
        this.c = t;
        notifyAll();
    }

    public final synchronized void onErrorResponse(VolleyError volleyError) {
        this.d = volleyError;
        notifyAll();
    }
}
