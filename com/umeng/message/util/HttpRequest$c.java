package com.umeng.message.util;

import java.io.Flushable;
import java.io.IOException;

protected abstract class HttpRequest$c<V> extends HttpRequest$d<V> {
    private final Flushable a;

    protected HttpRequest$c(Flushable flushable) {
        this.a = flushable;
    }

    protected void c() throws IOException {
        this.a.flush();
    }
}
