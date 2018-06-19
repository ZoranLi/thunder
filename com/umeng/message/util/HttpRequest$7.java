package com.umeng.message.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.nio.CharBuffer;

class HttpRequest$7 extends HttpRequest$b<HttpRequest> {
    final /* synthetic */ BufferedReader a;
    final /* synthetic */ Appendable b;
    final /* synthetic */ HttpRequest c;

    HttpRequest$7(HttpRequest httpRequest, Closeable closeable, boolean z, BufferedReader bufferedReader, Appendable appendable) {
        this.c = httpRequest;
        this.a = bufferedReader;
        this.b = appendable;
        super(closeable, z);
    }

    public /* synthetic */ Object b() throws HttpRequest$HttpRequestException, IOException {
        return a();
    }

    public HttpRequest a() throws IOException {
        Object allocate = CharBuffer.allocate(HttpRequest.access$100(this.c));
        while (true) {
            int read = this.a.read(allocate);
            if (read == -1) {
                return this.c;
            }
            allocate.rewind();
            this.b.append(allocate, 0, read);
            allocate.rewind();
        }
    }
}
