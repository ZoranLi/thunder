package com.android.volley.toolbox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* compiled from: PoolingByteArrayOutputStream */
public final class y extends ByteArrayOutputStream {
    private final g a;

    public y(g gVar, int i) {
        this.a = gVar;
        this.buf = this.a.a(Math.max(i, 256));
    }

    public final void close() throws IOException {
        this.a.a(this.buf);
        this.buf = null;
        super.close();
    }

    public final void finalize() {
        this.a.a(this.buf);
    }

    private void a(int i) {
        if (this.count + i > this.buf.length) {
            i = this.a.a((this.count + i) * 2);
            System.arraycopy(this.buf, 0, i, 0, this.count);
            this.a.a(this.buf);
            this.buf = i;
        }
    }

    public final synchronized void write(byte[] bArr, int i, int i2) {
        a(i2);
        super.write(bArr, i, i2);
    }

    public final synchronized void write(int i) {
        a(1);
        super.write(i);
    }
}
