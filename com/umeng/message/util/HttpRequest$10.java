package com.umeng.message.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

class HttpRequest$10 extends HttpRequest$b<HttpRequest> {
    final /* synthetic */ Reader a;
    final /* synthetic */ Writer b;
    final /* synthetic */ HttpRequest c;

    HttpRequest$10(HttpRequest httpRequest, Closeable closeable, boolean z, Reader reader, Writer writer) {
        this.c = httpRequest;
        this.a = reader;
        this.b = writer;
        super(closeable, z);
    }

    public /* synthetic */ Object b() throws HttpRequest$HttpRequestException, IOException {
        return a();
    }

    public HttpRequest a() throws IOException {
        char[] cArr = new char[HttpRequest.access$100(this.c)];
        while (true) {
            int read = this.a.read(cArr);
            if (read == -1) {
                return this.c;
            }
            this.b.write(cArr, 0, read);
        }
    }
}
