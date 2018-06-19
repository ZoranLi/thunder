package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.c;
import okio.e;
import okio.f;

/* compiled from: Http2Writer */
public final class s implements Closeable {
    private static final Logger c = Logger.getLogger(c.class.getName());
    int a = 16384;
    final b b = new b(this.f);
    private final f d;
    private final boolean e;
    private final e f = new e();
    private boolean g;

    s(f fVar, boolean z) {
        this.d = fVar;
        this.e = z;
    }

    public final synchronized void a() throws IOException {
        if (this.g) {
            throw new IOException("closed");
        } else if (this.e) {
            if (c.isLoggable(Level.FINE)) {
                c.fine(c.a(">> CONNECTION %s", c.a.hex()));
            }
            this.d.c(c.a.toByteArray());
            this.d.flush();
        }
    }

    public final synchronized void a(x xVar) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        int i = this.a;
        if ((32 & xVar.a) != 0) {
            i = xVar.b[5];
        }
        this.a = i;
        if (xVar.a() != -1) {
            this.b.a(xVar.a());
        }
        a(0, 0, (byte) 4, (byte) 1);
        this.d.flush();
    }

    public final synchronized void b() throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        this.d.flush();
    }

    public final synchronized void a(boolean z, int i, List<a> list) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        } else if (this.g) {
            throw new IOException("closed");
        } else {
            this.b.a((List) list);
            long j = this.f.b;
            int min = (int) Math.min((long) this.a, j);
            long j2 = (long) min;
            byte b = j == j2 ? (byte) 4 : (byte) 0;
            if (z) {
                b = (byte) (b | 1);
            }
            a(i, min, (byte) true, b);
            this.d.a_(this.f, j2);
            if (j > j2) {
                b(i, j - j2);
            }
        }
    }

    public final synchronized void a(int i, ErrorCode errorCode) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode == -1) {
            throw new IllegalArgumentException();
        } else {
            a(i, 4, (byte) 3, (byte) 0);
            this.d.f(errorCode.httpCode);
            this.d.flush();
        }
    }

    public final synchronized void a(boolean z, int i, e eVar, int i2) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        a(i, i2, (byte) 0, (byte) z);
        if (i2 > 0) {
            this.d.a_(eVar, (long) i2);
        }
    }

    public final synchronized void b(x xVar) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        int i = (byte) 0;
        a(0, Integer.bitCount(xVar.a) * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (xVar.a(i)) {
                int i2 = i == 4 ? 3 : i == 7 ? 4 : i;
                this.d.g(i2);
                this.d.f(xVar.b[i]);
            }
            i++;
        }
        this.d.flush();
    }

    public final synchronized void a(boolean z, int i, int i2) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        a(0, 8, (byte) 6, (byte) z);
        this.d.f(i);
        this.d.f(i2);
        this.d.flush();
    }

    public final synchronized void a(int i, ErrorCode errorCode, byte[] bArr) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        } else if (errorCode.httpCode == -1) {
            throw c.a("errorCode.httpCode == -1", new Object[0]);
        } else {
            a(0, 8 + bArr.length, (byte) 7, (byte) 0);
            this.d.f(i);
            this.d.f(errorCode.httpCode);
            if (bArr.length > 0) {
                this.d.c(bArr);
            }
            this.d.flush();
        }
    }

    public final synchronized void a(int i, long j) throws IOException {
        if (this.g) {
            throw new IOException("closed");
        }
        if (j != 0) {
            if (j <= 2147483647L) {
                a(i, 4, (byte) 8, (byte) 0);
                this.d.f((int) j);
                this.d.flush();
            }
        }
        throw c.a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
    }

    private void a(int i, int i2, byte b, byte b2) throws IOException {
        if (c.isLoggable(Level.FINE)) {
            c.fine(c.a(false, i, i2, b, b2));
        }
        if (i2 > this.a) {
            throw c.a("FRAME_SIZE_ERROR length > %d: %d", new Object[]{Integer.valueOf(this.a), Integer.valueOf(i2)});
        } else if ((Integer.MIN_VALUE & i) != 0) {
            throw c.a("reserved bit set: %s", new Object[]{Integer.valueOf(i)});
        } else {
            f fVar = this.d;
            fVar.h((i2 >>> 16) & 255);
            fVar.h((i2 >>> 8) & 255);
            fVar.h(i2 & 255);
            this.d.h(b & 255);
            this.d.h(b2 & 255);
            this.d.f(i & (byte) -1);
        }
    }

    public final synchronized void close() throws IOException {
        this.g = true;
        this.d.close();
    }

    private void b(int i, long j) throws IOException {
        while (j > 0) {
            int min = (int) Math.min((long) this.a, j);
            long j2 = (long) min;
            long j3 = j - j2;
            a(i, min, (byte) 9, j3 == 0 ? (byte) 4 : (byte) 0);
            this.d.a_(this.f, j2);
            j = j3;
        }
    }
}
