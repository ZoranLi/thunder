package com.umeng.message.util;

import java.io.IOException;
import java.util.concurrent.Callable;

protected abstract class HttpRequest$d<V> implements Callable<V> {
    protected abstract V b() throws HttpRequest$HttpRequestException, IOException;

    protected abstract void c() throws IOException;

    protected HttpRequest$d() {
    }

    public V call() throws HttpRequest$HttpRequestException {
        Throwable th;
        Object obj = 1;
        try {
            V b = b();
            try {
                c();
                return b;
            } catch (IOException e) {
                throw new HttpRequest$HttpRequestException(e);
            }
        } catch (HttpRequest$HttpRequestException e2) {
            throw e2;
        } catch (IOException e3) {
            throw new HttpRequest$HttpRequestException(e3);
        } catch (Throwable th2) {
            th = th2;
            c();
            throw th;
        }
    }
}
