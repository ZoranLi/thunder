package okhttp3.internal.c;

import com.alipay.sdk.util.h;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import okhttp3.ac;
import okhttp3.af;
import okhttp3.aj;
import okhttp3.ak;
import okhttp3.internal.b.i;
import okhttp3.internal.b.l;
import okhttp3.y;
import okhttp3.y$a;
import okio.g;
import okio.j;
import okio.m;
import okio.u;
import okio.v;
import okio.w;

/* compiled from: Http1Codec */
public final class a implements okhttp3.internal.b.c {
    final ac a;
    final okhttp3.internal.connection.f b;
    final g c;
    final okio.f d;
    int e = 0;

    /* compiled from: Http1Codec */
    private abstract class a implements v {
        protected final j a;
        protected boolean b;
        final /* synthetic */ a c;

        private a(a aVar) {
            this.c = aVar;
            this.a = new j(this.c.c.a());
        }

        public final w a() {
            return this.a;
        }

        protected final void a(boolean z) throws IOException {
            if (this.c.e != 6) {
                if (this.c.e != 5) {
                    StringBuilder stringBuilder = new StringBuilder("state: ");
                    stringBuilder.append(this.c.e);
                    throw new IllegalStateException(stringBuilder.toString());
                }
                a.a(this.a);
                this.c.e = 6;
                if (this.c.b != null) {
                    this.c.b.a(z ^ 1, this.c);
                }
            }
        }
    }

    /* compiled from: Http1Codec */
    private final class b implements u {
        final /* synthetic */ a a;
        private final j b = new j(this.a.d.a());
        private boolean c;

        b(a aVar) {
            this.a = aVar;
        }

        public final w a() {
            return this.b;
        }

        public final void a_(okio.e eVar, long j) throws IOException {
            if (this.c) {
                throw new IllegalStateException("closed");
            } else if (j != 0) {
                this.a.d.i(j);
                this.a.d.b("\r\n");
                this.a.d.a_(eVar, j);
                this.a.d.b("\r\n");
            }
        }

        public final synchronized void flush() throws IOException {
            if (!this.c) {
                this.a.d.flush();
            }
        }

        public final synchronized void close() throws IOException {
            if (!this.c) {
                this.c = true;
                this.a.d.b("0\r\n\r\n");
                a.a(this.b);
                this.a.e = 3;
            }
        }
    }

    /* compiled from: Http1Codec */
    private final class d implements u {
        final /* synthetic */ a a;
        private final j b = new j(this.a.d.a());
        private boolean c;
        private long d;

        d(a aVar, long j) {
            this.a = aVar;
            this.d = j;
        }

        public final w a() {
            return this.b;
        }

        public final void a_(okio.e eVar, long j) throws IOException {
            if (this.c) {
                throw new IllegalStateException("closed");
            }
            okhttp3.internal.c.a(eVar.b, j);
            if (j > this.d) {
                StringBuilder stringBuilder = new StringBuilder("expected ");
                stringBuilder.append(this.d);
                stringBuilder.append(" bytes but received ");
                stringBuilder.append(j);
                throw new ProtocolException(stringBuilder.toString());
            }
            this.a.d.a_(eVar, j);
            this.d -= j;
        }

        public final void flush() throws IOException {
            if (!this.c) {
                this.a.d.flush();
            }
        }

        public final void close() throws IOException {
            if (!this.c) {
                this.c = true;
                if (this.d > 0) {
                    throw new ProtocolException("unexpected end of stream");
                }
                a.a(this.b);
                this.a.e = 3;
            }
        }
    }

    /* compiled from: Http1Codec */
    private class c extends a {
        final /* synthetic */ a d;
        private final HttpUrl e;
        private long f = -1;
        private boolean g = true;

        c(a aVar, HttpUrl httpUrl) {
            this.d = aVar;
            super();
            this.e = httpUrl;
        }

        public final long a(okio.e eVar, long j) throws IOException {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (!this.g) {
                return -1;
            } else {
                if (this.f == 0 || this.f == -1) {
                    if (this.f != -1) {
                        this.d.c.l();
                    }
                    try {
                        this.f = this.d.c.i();
                        String trim = this.d.c.l().trim();
                        if (this.f >= 0) {
                            if (trim.isEmpty() || trim.startsWith(h.b)) {
                                if (this.f == 0) {
                                    this.g = false;
                                    okhttp3.internal.b.f.a(this.d.a.k, this.e, this.d.c());
                                    a(true);
                                }
                                if (!this.g) {
                                    return -1;
                                }
                            }
                        }
                        j = new StringBuilder("expected chunk size and optional extensions but was \"");
                        j.append(this.f);
                        j.append(trim);
                        j.append("\"");
                        throw new ProtocolException(j.toString());
                    } catch (okio.e eVar2) {
                        throw new ProtocolException(eVar2.getMessage());
                    }
                }
                eVar2 = this.d.c.a(eVar2, Math.min(j, this.f));
                if (eVar2 == -1) {
                    a(false);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.f -= eVar2;
                return eVar2;
            }
        }

        public final void close() throws IOException {
            if (!this.b) {
                if (this.g && !okhttp3.internal.c.a((v) this, TimeUnit.MILLISECONDS)) {
                    a(false);
                }
                this.b = true;
            }
        }
    }

    /* compiled from: Http1Codec */
    private class e extends a {
        final /* synthetic */ a d;
        private long e;

        e(a aVar, long j) throws IOException {
            this.d = aVar;
            super();
            this.e = j;
            if (this.e == 0) {
                a(true);
            }
        }

        public final long a(okio.e eVar, long j) throws IOException {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (this.e == 0) {
                return -1;
            } else {
                eVar = this.d.c.a(eVar, Math.min(this.e, j));
                if (eVar == -1) {
                    a(null);
                    throw new ProtocolException("unexpected end of stream");
                }
                this.e -= eVar;
                if (this.e == 0) {
                    a(true);
                }
                return eVar;
            }
        }

        public final void close() throws IOException {
            if (!this.b) {
                if (!(this.e == 0 || okhttp3.internal.c.a((v) this, TimeUnit.MILLISECONDS))) {
                    a(false);
                }
                this.b = true;
            }
        }
    }

    /* compiled from: Http1Codec */
    private class f extends a {
        final /* synthetic */ a d;
        private boolean e;

        f(a aVar) {
            this.d = aVar;
            super();
        }

        public final long a(okio.e eVar, long j) throws IOException {
            if (j < 0) {
                StringBuilder stringBuilder = new StringBuilder("byteCount < 0: ");
                stringBuilder.append(j);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else if (this.e) {
                return -1;
            } else {
                eVar = this.d.c.a(eVar, j);
                if (eVar != -1) {
                    return eVar;
                }
                this.e = true;
                a(true);
                return -1;
            }
        }

        public final void close() throws IOException {
            if (!this.b) {
                if (!this.e) {
                    a(false);
                }
                this.b = true;
            }
        }
    }

    public a(ac acVar, okhttp3.internal.connection.f fVar, g gVar, okio.f fVar2) {
        this.a = acVar;
        this.b = fVar;
        this.c = gVar;
        this.d = fVar2;
    }

    public final u a(af afVar, long j) {
        if ("chunked".equalsIgnoreCase(afVar.a("Transfer-Encoding")) != null) {
            if (this.e != 1) {
                j = new StringBuilder("state: ");
                j.append(this.e);
                throw new IllegalStateException(j.toString());
            }
            this.e = 2;
            return new b(this);
        } else if (j == -1) {
            throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        } else if (this.e != 1) {
            j = new StringBuilder("state: ");
            j.append(this.e);
            throw new IllegalStateException(j.toString());
        } else {
            this.e = 2;
            return new d(this, j);
        }
    }

    public final void a(af afVar) throws IOException {
        Type type = this.b.b().a.b.type();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(afVar.b);
        stringBuilder.append(' ');
        Object obj = (afVar.a.b() || type != Type.HTTP) ? null : 1;
        if (obj != null) {
            stringBuilder.append(afVar.a);
        } else {
            stringBuilder.append(okhttp3.internal.b.j.a(afVar.a));
        }
        stringBuilder.append(" HTTP/1.1");
        a(afVar.c, stringBuilder.toString());
    }

    public final void a() throws IOException {
        this.d.flush();
    }

    public final void b() throws IOException {
        this.d.flush();
    }

    public final void a(y yVar, String str) throws IOException {
        if (this.e != 0) {
            str = new StringBuilder("state: ");
            str.append(this.e);
            throw new IllegalStateException(str.toString());
        }
        this.d.b(str).b("\r\n");
        int length = yVar.a.length / 2;
        for (str = null; str < length; str++) {
            this.d.b(yVar.a(str)).b(": ").b(yVar.b(str)).b("\r\n");
        }
        this.d.b("\r\n");
        this.e = 1;
    }

    public final okhttp3.aj.a a(boolean z) throws IOException {
        if (this.e == 1 || this.e == 3) {
            try {
                l a = l.a(this.c.l());
                okhttp3.aj.a aVar = new okhttp3.aj.a();
                aVar.b = a.a;
                aVar.c = a.b;
                aVar.d = a.c;
                aVar = aVar.a(c());
                if (z && a.b) {
                    return false;
                }
                this.e = true;
                return aVar;
            } catch (boolean z2) {
                StringBuilder stringBuilder = new StringBuilder("unexpected end of stream on ");
                stringBuilder.append(this.b);
                IOException iOException = new IOException(stringBuilder.toString());
                iOException.initCause(z2);
                throw iOException;
            }
        }
        StringBuilder stringBuilder2 = new StringBuilder("state: ");
        stringBuilder2.append(this.e);
        throw new IllegalStateException(stringBuilder2.toString());
    }

    public final y c() throws IOException {
        y$a okhttp3_y_a = new y$a();
        while (true) {
            String l = this.c.l();
            if (l.length() == 0) {
                return okhttp3_y_a.a();
            }
            okhttp3.internal.a.a.a(okhttp3_y_a, l);
        }
    }

    public final v a(long j) throws IOException {
        if (this.e != 4) {
            StringBuilder stringBuilder = new StringBuilder("state: ");
            stringBuilder.append(this.e);
            throw new IllegalStateException(stringBuilder.toString());
        }
        this.e = 5;
        return new e(this, j);
    }

    public final ak a(aj ajVar) throws IOException {
        v a;
        if (!okhttp3.internal.b.f.b(ajVar)) {
            a = a(0);
        } else if ("chunked".equalsIgnoreCase(ajVar.a("Transfer-Encoding", null))) {
            HttpUrl httpUrl = ajVar.a.a;
            if (this.e != 4) {
                r0 = new StringBuilder("state: ");
                r0.append(this.e);
                throw new IllegalStateException(r0.toString());
            }
            this.e = 5;
            a = new c(this, httpUrl);
        } else {
            long a2 = okhttp3.internal.b.f.a(ajVar);
            if (a2 != -1) {
                a = a(a2);
            } else if (this.e != 4) {
                r0 = new StringBuilder("state: ");
                r0.append(this.e);
                throw new IllegalStateException(r0.toString());
            } else if (this.b == null) {
                throw new IllegalStateException("streamAllocation == null");
            } else {
                this.e = 5;
                this.b.d();
                a = new f(this);
            }
        }
        return new i(ajVar.f, m.a(a));
    }

    static void a(j jVar) {
        w wVar = jVar.a;
        w wVar2 = w.c;
        if (wVar2 == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        jVar.a = wVar2;
        wVar.x_();
        wVar.d();
    }
}
