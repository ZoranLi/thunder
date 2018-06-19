package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* compiled from: GzipSource */
public final class k implements v {
    private int a = 0;
    private final g b;
    private final Inflater c;
    private final l d;
    private final CRC32 e = new CRC32();

    public k(v vVar) {
        if (vVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.c = new Inflater(true);
        this.b = m.a(vVar);
        this.d = new l(this.b, this.c);
    }

    public final long a(e eVar, long j) throws IOException {
        k kVar = this;
        e eVar2 = eVar;
        long j2 = j;
        if (j2 < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j2);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (j2 == 0) {
            return 0;
        } else {
            if (kVar.a == 0) {
                long o;
                kVar.b.a(10);
                byte b = kVar.b.b().b(3);
                int i = ((b >> 1) & 1) == 1 ? 1 : 0;
                if (i != 0) {
                    a(kVar.b.b(), 0, 10);
                }
                a("ID1ID2", 8075, kVar.b.e());
                kVar.b.f(8);
                if (((b >> 2) & 1) == 1) {
                    long j3;
                    kVar.b.a(2);
                    if (i != 0) {
                        a(kVar.b.b(), 0, 2);
                    }
                    long g = (long) kVar.b.b().g();
                    kVar.b.a(g);
                    if (i != 0) {
                        j3 = g;
                        a(kVar.b.b(), 0, g);
                    } else {
                        j3 = g;
                    }
                    kVar.b.f(j3);
                }
                if (((b >> 3) & 1) == 1) {
                    o = kVar.b.o();
                    if (o == -1) {
                        throw new EOFException();
                    }
                    if (i != 0) {
                        a(kVar.b.b(), 0, o + 1);
                    }
                    kVar.b.f(o + 1);
                }
                if (((b >> 4) & 1) == 1) {
                    o = kVar.b.o();
                    if (o == -1) {
                        throw new EOFException();
                    }
                    if (i != 0) {
                        a(kVar.b.b(), 0, o + 1);
                    }
                    kVar.b.f(o + 1);
                }
                if (i != 0) {
                    a("FHCRC", kVar.b.g(), (short) ((int) kVar.e.getValue()));
                    kVar.e.reset();
                }
                kVar.a = 1;
            }
            if (kVar.a == 1) {
                long j4 = eVar2.b;
                j2 = kVar.d.a(eVar2, j2);
                if (j2 != -1) {
                    a(eVar2, j4, j2);
                    return j2;
                }
                kVar.a = 2;
            }
            if (kVar.a == 2) {
                a("CRC", kVar.b.h(), (int) kVar.e.getValue());
                a("ISIZE", kVar.b.h(), (int) kVar.c.getBytesWritten());
                kVar.a = 3;
                if (!kVar.b.c()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1;
        }
    }

    public final w a() {
        return this.b.a();
    }

    public final void close() throws IOException {
        this.d.close();
    }

    private void a(e eVar, long j, long j2) {
        eVar = eVar.a;
        while (j >= ((long) (eVar.c - eVar.b))) {
            long j3 = j - ((long) (eVar.c - eVar.b));
            eVar = eVar.f;
            j = j3;
        }
        while (j2 > 0) {
            j = (int) (((long) eVar.b) + j);
            int min = (int) Math.min((long) (eVar.c - j), j2);
            this.e.update(eVar.a, j, min);
            j3 = j2 - ((long) min);
            eVar = eVar.f;
            j = 0;
            j2 = j3;
        }
    }

    private static void a(String str, int i, int i2) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}));
        }
    }
}
