package com.xiaomi.account.openauth;

import android.accounts.OperationCanceledException;
import android.os.Looper;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

class XiaomiOAuthFutureImpl<V> extends FutureTask<V> implements XiaomiOAuthFuture<V> {
    private static final long DEFAULT_TIMEOUT_MINUTE = 10;

    private void ensureNotOnMainThread() {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null && myLooper == Looper.getMainLooper()) {
            throw new IllegalStateException("calling this from your main thread can lead to deadlock");
        }
    }

    XiaomiOAuthFutureImpl() {
        super(new Callable<V>() {
            public V call() throws Exception {
                throw new IllegalStateException("this should never be called");
            }
        });
    }

    public V getResult() throws IOException, OperationCanceledException, XMAuthericationException {
        return internalGetResult(Long.valueOf(DEFAULT_TIMEOUT_MINUTE), TimeUnit.MINUTES);
    }

    public V getResult(long j, TimeUnit timeUnit) throws IOException, OperationCanceledException, XMAuthericationException {
        return internalGetResult(Long.valueOf(j), timeUnit);
    }

    public void setException(Throwable th) {
        super.setException(th);
    }

    public void set(V v) {
        super.set(v);
    }

    private V internalGetResult(java.lang.Long r4, java.util.concurrent.TimeUnit r5) throws android.accounts.OperationCanceledException, java.io.IOException, com.xiaomi.account.openauth.XMAuthericationException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.isDone();
        if (r0 != 0) goto L_0x0009;
    L_0x0006:
        r3.ensureNotOnMainThread();
    L_0x0009:
        r0 = 1;
        if (r4 != 0) goto L_0x0018;
    L_0x000c:
        r4 = r3.get();	 Catch:{ CancellationException -> 0x005a, TimeoutException -> 0x0051, TimeoutException -> 0x0051, ExecutionException -> 0x0016 }
        r3.cancel(r0);
        return r4;
    L_0x0014:
        r4 = move-exception;
        goto L_0x0060;
    L_0x0016:
        r4 = move-exception;
        goto L_0x0024;
    L_0x0018:
        r1 = r4.longValue();	 Catch:{ CancellationException -> 0x005a, TimeoutException -> 0x0051, TimeoutException -> 0x0051, ExecutionException -> 0x0016 }
        r4 = r3.get(r1, r5);	 Catch:{ CancellationException -> 0x005a, TimeoutException -> 0x0051, TimeoutException -> 0x0051, ExecutionException -> 0x0016 }
        r3.cancel(r0);
        return r4;
    L_0x0024:
        r4 = r4.getCause();	 Catch:{ all -> 0x0014 }
        r5 = r4 instanceof java.io.IOException;	 Catch:{ all -> 0x0014 }
        if (r5 == 0) goto L_0x002f;	 Catch:{ all -> 0x0014 }
    L_0x002c:
        r4 = (java.io.IOException) r4;	 Catch:{ all -> 0x0014 }
        throw r4;	 Catch:{ all -> 0x0014 }
    L_0x002f:
        r5 = r4 instanceof java.lang.RuntimeException;	 Catch:{ all -> 0x0014 }
        if (r5 == 0) goto L_0x0036;	 Catch:{ all -> 0x0014 }
    L_0x0033:
        r4 = (java.lang.RuntimeException) r4;	 Catch:{ all -> 0x0014 }
        throw r4;	 Catch:{ all -> 0x0014 }
    L_0x0036:
        r5 = r4 instanceof java.lang.Error;	 Catch:{ all -> 0x0014 }
        if (r5 == 0) goto L_0x003d;	 Catch:{ all -> 0x0014 }
    L_0x003a:
        r4 = (java.lang.Error) r4;	 Catch:{ all -> 0x0014 }
        throw r4;	 Catch:{ all -> 0x0014 }
    L_0x003d:
        r5 = r4 instanceof com.xiaomi.account.openauth.XMAuthericationException;	 Catch:{ all -> 0x0014 }
        if (r5 == 0) goto L_0x0044;	 Catch:{ all -> 0x0014 }
    L_0x0041:
        r4 = (com.xiaomi.account.openauth.XMAuthericationException) r4;	 Catch:{ all -> 0x0014 }
        throw r4;	 Catch:{ all -> 0x0014 }
    L_0x0044:
        r5 = r4 instanceof android.accounts.OperationCanceledException;	 Catch:{ all -> 0x0014 }
        if (r5 == 0) goto L_0x004b;	 Catch:{ all -> 0x0014 }
    L_0x0048:
        r4 = (android.accounts.OperationCanceledException) r4;	 Catch:{ all -> 0x0014 }
        throw r4;	 Catch:{ all -> 0x0014 }
    L_0x004b:
        r5 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0014 }
        r5.<init>(r4);	 Catch:{ all -> 0x0014 }
        throw r5;	 Catch:{ all -> 0x0014 }
    L_0x0051:
        r3.cancel(r0);
        r4 = new android.accounts.OperationCanceledException;
        r4.<init>();
        throw r4;
    L_0x005a:
        r4 = new android.accounts.OperationCanceledException;	 Catch:{ all -> 0x0014 }
        r4.<init>();	 Catch:{ all -> 0x0014 }
        throw r4;	 Catch:{ all -> 0x0014 }
    L_0x0060:
        r3.cancel(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.account.openauth.XiaomiOAuthFutureImpl.internalGetResult(java.lang.Long, java.util.concurrent.TimeUnit):V");
    }
}
