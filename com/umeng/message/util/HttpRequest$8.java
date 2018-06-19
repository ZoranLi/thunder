package com.umeng.message.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;

class HttpRequest$8 extends HttpRequest$b<HttpRequest> {
    final /* synthetic */ BufferedReader a;
    final /* synthetic */ Writer b;
    final /* synthetic */ HttpRequest c;

    HttpRequest$8(HttpRequest httpRequest, Closeable closeable, boolean z, BufferedReader bufferedReader, Writer writer) {
        this.c = httpRequest;
        this.a = bufferedReader;
        this.b = writer;
        super(closeable, z);
    }

    public /* synthetic */ Object b() throws HttpRequest$HttpRequestException, IOException {
        return a();
    }

    public HttpRequest a() throws IOException {
        return this.c.copy(this.a, this.b);
    }
}
