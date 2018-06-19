package okhttp3;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import okhttp3.internal.a.e;
import okhttp3.internal.a.f;

/* compiled from: Cache */
public final class d implements Closeable, Flushable {
    final f a;
    final e b;

    public final void flush() throws IOException {
        this.b.flush();
    }

    public final void close() throws IOException {
        this.b.close();
    }
}
