package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.Inflater;

/* compiled from: InflaterSource */
public final class l implements v {
    private final g a;
    private final Inflater b;
    private int c;
    private boolean d;

    l(g gVar, Inflater inflater) {
        if (gVar == null) {
            throw new IllegalArgumentException("source == null");
        } else if (inflater == null) {
            throw new IllegalArgumentException("inflater == null");
        } else {
            this.a = gVar;
            this.b = inflater;
        }
    }

    public final long a(e eVar, long j) throws IOException {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.d) {
            throw new IllegalStateException("closed");
        } else if (j == 0) {
            return 0;
        } else {
            int i;
            do {
                i = 0;
                if (this.b.needsInput() != null) {
                    b();
                    if (this.b.getRemaining() != null) {
                        throw new IllegalStateException("?");
                    } else if (this.a.c() != null) {
                        i = 1;
                    } else {
                        j = this.a.b().a;
                        this.c = j.c - j.b;
                        this.b.setInput(j.a, j.b, this.c);
                    }
                }
                try {
                    j = eVar.e(1);
                    int inflate = this.b.inflate(j.a, j.c, 8192 - j.c);
                    if (inflate > 0) {
                        j.c += inflate;
                        j = (long) inflate;
                        eVar.b += j;
                        return j;
                    }
                    if (!this.b.finished()) {
                        if (this.b.needsDictionary()) {
                        }
                    }
                    b();
                    if (j.b == j.c) {
                        eVar.a = j.a();
                        t.a(j);
                    }
                    return -1;
                } catch (e eVar2) {
                    throw new IOException(eVar2);
                }
            } while (i == 0);
            throw new EOFException("source exhausted prematurely");
        }
    }

    private void b() throws IOException {
        if (this.c != 0) {
            int remaining = this.c - this.b.getRemaining();
            this.c -= remaining;
            this.a.f((long) remaining);
        }
    }

    public final w a() {
        return this.a.a();
    }

    public final void close() throws IOException {
        if (!this.d) {
            this.b.end();
            this.d = true;
            this.a.close();
        }
    }
}
