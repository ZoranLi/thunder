package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.umeng.message.proguard.k;
import java.io.EOFException;
import java.io.IOException;

/* compiled from: RealBufferedSource */
final class r implements g {
    public final e a = new e();
    public final v b;
    boolean c;

    r(v vVar) {
        if (vVar == null) {
            throw new NullPointerException("source == null");
        }
        this.b = vVar;
    }

    public final e b() {
        return this.a;
    }

    public final long a(e eVar, long j) throws IOException {
        if (eVar == null) {
            throw new IllegalArgumentException("sink == null");
        } else if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.c) {
            throw new IllegalStateException("closed");
        } else if (this.a.b == 0 && this.b.a(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
            return -1;
        } else {
            return this.a.a(eVar, Math.min(j, this.a.b));
        }
    }

    public final boolean c() throws IOException {
        if (!this.c) {
            return this.a.c() && this.b.a(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1;
        } else {
            throw new IllegalStateException("closed");
        }
    }

    public final void a(long j) throws IOException {
        if (b(j) == null) {
            throw new EOFException();
        }
    }

    private boolean b(long j) throws IOException {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (this.c) {
            throw new IllegalStateException("closed");
        } else {
            while (this.a.b < j) {
                if (this.b.a(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                    return 0;
                }
            }
            return 1;
        }
    }

    public final byte d() throws IOException {
        a(1);
        return this.a.d();
    }

    public final ByteString c(long j) throws IOException {
        a(j);
        return this.a.c(j);
    }

    public final byte[] m() throws IOException {
        this.a.a(this.b);
        return this.a.m();
    }

    public final byte[] e(long j) throws IOException {
        a(j);
        return this.a.e(j);
    }

    public final void a(byte[] bArr) throws IOException {
        try {
            a((long) bArr.length);
            this.a.a(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (this.a.b > 0) {
                int a = this.a.a(bArr, i, (int) this.a.b);
                if (a == -1) {
                    throw new AssertionError();
                }
                i += a;
            }
            throw e;
        }
    }

    public final short e() throws IOException {
        a(2);
        return this.a.e();
    }

    public final short g() throws IOException {
        a(2);
        return y.a(this.a.e());
    }

    public final int f() throws IOException {
        a(4);
        return this.a.f();
    }

    public final int h() throws IOException {
        a(4);
        return y.a(this.a.f());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long i() throws java.io.IOException {
        /*
        r6 = this;
        r0 = 1;
        r6.a(r0);
        r0 = 0;
        r1 = r0;
    L_0x0007:
        r2 = r1 + 1;
        r3 = (long) r2;
        r3 = r6.b(r3);
        if (r3 == 0) goto L_0x0049;
    L_0x0010:
        r3 = r6.a;
        r4 = (long) r1;
        r3 = r3.b(r4);
        r4 = 48;
        if (r3 < r4) goto L_0x001f;
    L_0x001b:
        r4 = 57;
        if (r3 <= r4) goto L_0x0030;
    L_0x001f:
        r4 = 97;
        if (r3 < r4) goto L_0x0027;
    L_0x0023:
        r4 = 102; // 0x66 float:1.43E-43 double:5.04E-322;
        if (r3 <= r4) goto L_0x0030;
    L_0x0027:
        r4 = 65;
        if (r3 < r4) goto L_0x0032;
    L_0x002b:
        r4 = 70;
        if (r3 <= r4) goto L_0x0030;
    L_0x002f:
        goto L_0x0032;
    L_0x0030:
        r1 = r2;
        goto L_0x0007;
    L_0x0032:
        if (r1 != 0) goto L_0x0049;
    L_0x0034:
        r1 = new java.lang.NumberFormatException;
        r2 = "Expected leading [0-9a-fA-F] character but was %#x";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r3 = java.lang.Byte.valueOf(r3);
        r4[r0] = r3;
        r0 = java.lang.String.format(r2, r4);
        r1.<init>(r0);
        throw r1;
    L_0x0049:
        r0 = r6.a;
        r0 = r0.i();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.r.i():long");
    }

    public final void f(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        while (j > 0) {
            if (this.a.b == 0 && this.b.a(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j, this.a.b);
            this.a.f(min);
            j -= min;
        }
    }

    public final long o() throws IOException {
        return a((byte) 0, 0, Long.MAX_VALUE);
    }

    private long a(byte b, long j, long j2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        } else if (j2 < 0) {
            throw new IllegalArgumentException(String.format("fromIndex=%s toIndex=%s", new Object[]{Long.valueOf(0), Long.valueOf(j2)}));
        } else {
            while (j < j2) {
                long a = this.a.a(b, j, j2);
                if (a != -1) {
                    return a;
                }
                a = this.a.b;
                if (a < j2) {
                    if (this.b.a(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                        j = Math.max(j, a);
                    }
                }
                return -1;
            }
            return -1;
        }
    }

    public final void close() throws IOException {
        if (!this.c) {
            this.c = true;
            this.b.close();
            this.a.n();
        }
    }

    public final w a() {
        return this.b.a();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("buffer(");
        stringBuilder.append(this.b);
        stringBuilder.append(k.t);
        return stringBuilder.toString();
    }

    public final String l() throws IOException {
        long a = a((byte) 10, 0, Long.MAX_VALUE);
        if (a != -1) {
            return this.a.d(a);
        }
        e eVar = new e();
        this.a.a(eVar, 0, Math.min(32, this.a.b));
        StringBuilder stringBuilder = new StringBuilder("\\n not found: limit=");
        stringBuilder.append(Math.min(this.a.b, Long.MAX_VALUE));
        stringBuilder.append(" content=");
        stringBuilder.append(eVar.j().hex());
        stringBuilder.append('…');
        throw new EOFException(stringBuilder.toString());
    }
}
