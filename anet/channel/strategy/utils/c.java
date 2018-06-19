package anet.channel.strategy.utils;

import java.io.IOException;
import java.io.InputStream;

/* compiled from: Taobao */
public class c extends InputStream {
    private InputStream a = null;
    private long b = 0;

    public c(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException("input stream cannot be null");
        }
        this.a = inputStream;
    }

    public long a() {
        return this.b;
    }

    public int read() throws IOException {
        this.b++;
        return this.a.read();
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        bArr = this.a.read(bArr, i, i2);
        this.b += (long) bArr;
        return bArr;
    }
}
