package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.internal.c;
import okio.e;
import okio.g;

/* compiled from: ResponseBody */
public abstract class ak implements Closeable {
    @Nullable
    public abstract aa a();

    public abstract long b();

    public abstract g c();

    public final byte[] d() throws IOException {
        long b = b();
        if (b > 2147483647L) {
            StringBuilder stringBuilder = new StringBuilder("Cannot buffer entire body for content length: ");
            stringBuilder.append(b);
            throw new IOException(stringBuilder.toString());
        }
        Closeable c = c();
        try {
            byte[] m = c.m();
            if (b == -1 || b == ((long) m.length)) {
                return m;
            }
            StringBuilder stringBuilder2 = new StringBuilder("Content-Length (");
            stringBuilder2.append(b);
            stringBuilder2.append(") and stream length (");
            stringBuilder2.append(m.length);
            stringBuilder2.append(") disagree");
            throw new IOException(stringBuilder2.toString());
        } finally {
            c.a(c);
        }
    }

    public void close() {
        c.a(c());
    }

    public static ak a(byte[] bArr) {
        g b = new e().b(bArr);
        long length = (long) bArr.length;
        if (b != null) {
            return new al(length, b);
        }
        throw new NullPointerException("source == null");
    }
}
