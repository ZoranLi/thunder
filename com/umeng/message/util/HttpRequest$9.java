package com.umeng.message.util;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

class HttpRequest$9 extends HttpRequest$b<HttpRequest> {
    final /* synthetic */ InputStream a;
    final /* synthetic */ OutputStream b;
    final /* synthetic */ HttpRequest c;

    HttpRequest$9(HttpRequest httpRequest, Closeable closeable, boolean z, InputStream inputStream, OutputStream outputStream) {
        this.c = httpRequest;
        this.a = inputStream;
        this.b = outputStream;
        super(closeable, z);
    }

    public /* synthetic */ Object b() throws HttpRequest$HttpRequestException, IOException {
        return a();
    }

    public HttpRequest a() throws IOException {
        byte[] bArr = new byte[HttpRequest.access$100(this.c)];
        while (true) {
            int read = this.a.read(bArr);
            if (read == -1) {
                return this.c;
            }
            this.b.write(bArr, 0, read);
        }
    }
}
