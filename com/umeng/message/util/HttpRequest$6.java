package com.umeng.message.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;

class HttpRequest$6 extends HttpRequest$b<HttpRequest> {
    final /* synthetic */ OutputStream a;
    final /* synthetic */ HttpRequest b;

    HttpRequest$6(HttpRequest httpRequest, Closeable closeable, boolean z, OutputStream outputStream) {
        this.b = httpRequest;
        this.a = outputStream;
        super(closeable, z);
    }

    protected /* synthetic */ Object b() throws HttpRequest$HttpRequestException, IOException {
        return a();
    }

    protected HttpRequest a() throws HttpRequest$HttpRequestException, IOException {
        return this.b.receive(this.a);
    }
}
