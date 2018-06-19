package okio;

import com.umeng.message.proguard.k;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: Okio */
final class o implements v {
    final /* synthetic */ w a;
    final /* synthetic */ InputStream b;

    o(w wVar, InputStream inputStream) {
        this.a = wVar;
        this.b = inputStream;
    }

    public final long a(e eVar, long j) throws IOException {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (j == 0) {
            return 0;
        } else {
            try {
                this.a.f();
                s e = eVar.e(1);
                j = this.b.read(e.a, e.c, (int) Math.min(j, (long) (8192 - e.c)));
                if (j == -1) {
                    return -1;
                }
                e.c += j;
                j = (long) j;
                eVar.b += j;
                return j;
            } catch (AssertionError e2) {
                if (m.a(e2) != null) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }
    }

    public final void close() throws IOException {
        this.b.close();
    }

    public final w a() {
        return this.a;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("source(");
        stringBuilder.append(this.b);
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }
}
