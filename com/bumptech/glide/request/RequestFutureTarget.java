package com.bumptech.glide.request;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.util.Util;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class RequestFutureTarget<T, R> implements FutureTarget<R>, Runnable {
    private static final Waiter DEFAULT_WAITER = new Waiter();
    private final boolean assertBackgroundThread;
    private Exception exception;
    private boolean exceptionReceived;
    private final int height;
    private boolean isCancelled;
    private final Handler mainHandler;
    private Request request;
    private R resource;
    private boolean resultReceived;
    private final Waiter waiter;
    private final int width;

    static class Waiter {
        Waiter() {
        }

        public void waitForTimeout(Object obj, long j) throws InterruptedException {
            obj.wait(j);
        }

        public void notifyAll(Object obj) {
            obj.notifyAll();
        }
    }

    public void onDestroy() {
    }

    public void onLoadCleared(Drawable drawable) {
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public RequestFutureTarget(Handler handler, int i, int i2) {
        this(handler, i, i2, true, DEFAULT_WAITER);
    }

    RequestFutureTarget(Handler handler, int i, int i2, boolean z, Waiter waiter) {
        this.mainHandler = handler;
        this.width = i;
        this.height = i2;
        this.assertBackgroundThread = z;
        this.waiter = waiter;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean cancel(boolean r3) {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.isCancelled;	 Catch:{ all -> 0x001d }
        r1 = 1;
        if (r0 == 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r2);
        return r1;
    L_0x0008:
        r0 = r2.isDone();	 Catch:{ all -> 0x001d }
        r0 = r0 ^ r1;
        if (r0 == 0) goto L_0x001b;
    L_0x000f:
        r2.isCancelled = r1;	 Catch:{ all -> 0x001d }
        if (r3 == 0) goto L_0x0016;
    L_0x0013:
        r2.clear();	 Catch:{ all -> 0x001d }
    L_0x0016:
        r3 = r2.waiter;	 Catch:{ all -> 0x001d }
        r3.notifyAll(r2);	 Catch:{ all -> 0x001d }
    L_0x001b:
        monitor-exit(r2);
        return r0;
    L_0x001d:
        r3 = move-exception;
        monitor-exit(r2);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.RequestFutureTarget.cancel(boolean):boolean");
    }

    public synchronized boolean isCancelled() {
        return this.isCancelled;
    }

    public synchronized boolean isDone() {
        boolean z;
        if (!this.isCancelled) {
            if (!this.resultReceived) {
                z = false;
            }
        }
        z = true;
        return z;
    }

    public R get() throws InterruptedException, ExecutionException {
        try {
            return doGet(null);
        } catch (TimeoutException e) {
            throw new AssertionError(e);
        }
    }

    public R get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return doGet(Long.valueOf(timeUnit.toMillis(j)));
    }

    public void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.width, this.height);
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Request getRequest() {
        return this.request;
    }

    public synchronized void onLoadFailed(Exception exception, Drawable drawable) {
        this.exceptionReceived = true;
        this.exception = exception;
        this.waiter.notifyAll(this);
    }

    public synchronized void onResourceReady(R r, GlideAnimation<? super R> glideAnimation) {
        this.resultReceived = true;
        this.resource = r;
        this.waiter.notifyAll(this);
    }

    private synchronized R doGet(Long l) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.assertBackgroundThread) {
            Util.assertBackgroundThread();
        }
        if (this.isCancelled) {
            throw new CancellationException();
        } else if (this.exceptionReceived) {
            throw new ExecutionException(this.exception);
        } else if (this.resultReceived) {
            return this.resource;
        } else {
            if (l == null) {
                this.waiter.waitForTimeout(this, 0);
            } else if (l.longValue() > 0) {
                this.waiter.waitForTimeout(this, l.longValue());
            }
            if (Thread.interrupted() != null) {
                throw new InterruptedException();
            } else if (this.exceptionReceived != null) {
                throw new ExecutionException(this.exception);
            } else if (this.isCancelled != null) {
                throw new CancellationException();
            } else if (this.resultReceived == null) {
                throw new TimeoutException();
            } else {
                return this.resource;
            }
        }
    }

    public void run() {
        if (this.request != null) {
            this.request.clear();
            cancel(false);
        }
    }

    public void clear() {
        this.mainHandler.post(this);
    }
}
