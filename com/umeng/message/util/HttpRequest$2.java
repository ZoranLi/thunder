package com.umeng.message.util;

import java.io.Flushable;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

class HttpRequest$2 extends HttpRequest$c<HttpRequest> {
    final /* synthetic */ Reader a;
    final /* synthetic */ Writer b;
    final /* synthetic */ HttpRequest c;

    HttpRequest$2(HttpRequest httpRequest, Flushable flushable, Reader reader, Writer writer) {
        this.c = httpRequest;
        this.a = reader;
        this.b = writer;
        super(flushable);
    }

    protected /* synthetic */ Object b() throws HttpRequest$HttpRequestException, IOException {
        return a();
    }

    protected HttpRequest a() throws IOException {
        return this.c.copy(this.a, this.b);
    }
}
