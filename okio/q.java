package okio;

import android.support.v4.media.session.PlaybackStateCompat;
import com.umeng.message.proguard.k;
import java.io.IOException;

/* compiled from: RealBufferedSink */
final class q implements f {
    public final e a = new e();
    public final u b;
    boolean c;

    q(u uVar) {
        if (uVar == null) {
            throw new NullPointerException("sink == null");
        }
        this.b = uVar;
    }

    public final e b() {
        return this.a;
    }

    public final void a_(e eVar, long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a_(eVar, j);
        p();
    }

    public final f b(ByteString byteString) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(byteString);
        return p();
    }

    public final f b(String str) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(str);
        return p();
    }

    public final f c(byte[] bArr) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(bArr);
        return p();
    }

    public final f c(byte[] bArr, int i, int i2) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(bArr, i, i2);
        return p();
    }

    public final long a(v vVar) throws IOException {
        if (vVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = 0;
        while (true) {
            long a = vVar.a(this.a, PlaybackStateCompat.ACTION_PLAY_FROM_URI);
            if (a == -1) {
                return j;
            }
            long j2 = j + a;
            p();
            j = j2;
        }
    }

    public final f h(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(i);
        return p();
    }

    public final f g(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(i);
        return p();
    }

    public final f f(int i) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.d(i);
        return p();
    }

    public final f j(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.g(j);
        return p();
    }

    public final f i(long j) throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        this.a.h(j);
        return p();
    }

    public final f p() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        e eVar = this.a;
        long j = eVar.b;
        if (j == 0) {
            j = 0;
        } else {
            s sVar = eVar.a.g;
            if (sVar.c < 8192 && sVar.e) {
                j -= (long) (sVar.c - sVar.b);
            }
        }
        if (j > 0) {
            this.b.a_(this.a, j);
        }
        return this;
    }

    public final void flush() throws IOException {
        if (this.c) {
            throw new IllegalStateException("closed");
        }
        if (this.a.b > 0) {
            this.b.a_(this.a, this.a.b);
        }
        this.b.flush();
    }

    public final void close() throws IOException {
        if (!this.c) {
            Throwable th = null;
            try {
                if (this.a.b > 0) {
                    this.b.a_(this.a, this.a.b);
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.b.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.c = true;
            if (th != null) {
                y.a(th);
            }
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
}
