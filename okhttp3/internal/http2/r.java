package okhttp3.internal.http2;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.EOFException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.util.List;
import okio.e;
import okio.g;
import okio.u;
import okio.v;
import okio.w;

/* compiled from: Http2Stream */
public final class r {
    static final /* synthetic */ boolean l = true;
    long a = 0;
    long b;
    final int c;
    final e d;
    List<a> e;
    boolean f;
    final b g;
    final a h;
    final c i = new c(this);
    final c j = new c(this);
    ErrorCode k = null;
    private final List<a> m;

    /* compiled from: Http2Stream */
    final class a implements u {
        static final /* synthetic */ boolean c = true;
        boolean a;
        boolean b;
        final /* synthetic */ r d;
        private final e e = new e();

        static {
            Class cls = r.class;
        }

        a(r rVar) {
            this.d = rVar;
        }

        public final void a_(e eVar, long j) throws IOException {
            if (c || !Thread.holdsLock(this.d)) {
                this.e.a_(eVar, j);
                while (this.e.b >= PlaybackStateCompat.ACTION_PREPARE) {
                    a(null);
                }
                return;
            }
            throw new AssertionError();
        }

        private void a(boolean z) throws IOException {
            synchronized (this.d) {
                this.d.j.t_();
                while (this.d.b <= 0 && !this.b && !this.a && this.d.k == null) {
                    try {
                        this.d.h();
                    } finally {
                        this.d.j.b();
                    }
                }
                this.d.g();
                long min = Math.min(this.d.b, this.e.b);
                r rVar = this.d;
                rVar.b -= min;
            }
            this.d.j.t_();
            try {
                e eVar = this.d.d;
                int i = this.d.c;
                z = z && min == this.e.b;
                eVar.a(i, z, this.e, min);
            } finally {
                this.d.j.b();
            }
        }

        public final void flush() throws IOException {
            if (c || !Thread.holdsLock(this.d)) {
                synchronized (this.d) {
                    this.d.g();
                }
                while (this.e.b > 0) {
                    a(false);
                    this.d.d.q.b();
                }
                return;
            }
            throw new AssertionError();
        }

        public final w a() {
            return this.d.j;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void close() throws java.io.IOException {
            /*
            r8 = this;
            r0 = c;
            if (r0 != 0) goto L_0x0012;
        L_0x0004:
            r0 = r8.d;
            r0 = java.lang.Thread.holdsLock(r0);
            if (r0 == 0) goto L_0x0012;
        L_0x000c:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x0012:
            r0 = r8.d;
            monitor-enter(r0);
            r1 = r8.a;	 Catch:{ all -> 0x0062 }
            if (r1 == 0) goto L_0x001b;
        L_0x0019:
            monitor-exit(r0);	 Catch:{ all -> 0x0062 }
            return;
        L_0x001b:
            monitor-exit(r0);	 Catch:{ all -> 0x0062 }
            r0 = r8.d;
            r0 = r0.h;
            r0 = r0.b;
            r1 = 1;
            if (r0 != 0) goto L_0x004a;
        L_0x0025:
            r0 = r8.e;
            r2 = r0.b;
            r4 = 0;
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r0 <= 0) goto L_0x003b;
        L_0x002f:
            r0 = r8.e;
            r2 = r0.b;
            r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r0 <= 0) goto L_0x004a;
        L_0x0037:
            r8.a(r1);
            goto L_0x002f;
        L_0x003b:
            r0 = r8.d;
            r2 = r0.d;
            r0 = r8.d;
            r3 = r0.c;
            r4 = 1;
            r5 = 0;
            r6 = 0;
            r2.a(r3, r4, r5, r6);
        L_0x004a:
            r2 = r8.d;
            monitor-enter(r2);
            r8.a = r1;	 Catch:{ all -> 0x005f }
            monitor-exit(r2);	 Catch:{ all -> 0x005f }
            r0 = r8.d;
            r0 = r0.d;
            r0 = r0.q;
            r0.b();
            r0 = r8.d;
            r0.f();
            return;
        L_0x005f:
            r0 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x005f }
            throw r0;
        L_0x0062:
            r1 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x0062 }
            throw r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.r.a.close():void");
        }
    }

    /* compiled from: Http2Stream */
    private final class b implements v {
        static final /* synthetic */ boolean c = true;
        boolean a;
        boolean b;
        final /* synthetic */ r d;
        private final e e = new e();
        private final e f = new e();
        private final long g;

        static {
            Class cls = r.class;
        }

        b(r rVar, long j) {
            this.d = rVar;
            this.g = j;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final long a(okio.e r8, long r9) throws java.io.IOException {
            /*
            r7 = this;
            r0 = 0;
            r2 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1));
            if (r2 >= 0) goto L_0x001a;
        L_0x0006:
            r8 = new java.lang.IllegalArgumentException;
            r0 = new java.lang.StringBuilder;
            r1 = "byteCount < 0: ";
            r0.<init>(r1);
            r0.append(r9);
            r9 = r0.toString();
            r8.<init>(r9);
            throw r8;
        L_0x001a:
            r2 = r7.d;
            monitor-enter(r2);
            r7.b();	 Catch:{ all -> 0x00c6 }
            r3 = r7.a;	 Catch:{ all -> 0x00c6 }
            if (r3 == 0) goto L_0x002c;
        L_0x0024:
            r8 = new java.io.IOException;	 Catch:{ all -> 0x00c6 }
            r9 = "stream closed";
            r8.<init>(r9);	 Catch:{ all -> 0x00c6 }
            throw r8;	 Catch:{ all -> 0x00c6 }
        L_0x002c:
            r3 = r7.d;	 Catch:{ all -> 0x00c6 }
            r3 = r3.k;	 Catch:{ all -> 0x00c6 }
            if (r3 == 0) goto L_0x003c;
        L_0x0032:
            r8 = new okhttp3.internal.http2.StreamResetException;	 Catch:{ all -> 0x00c6 }
            r9 = r7.d;	 Catch:{ all -> 0x00c6 }
            r9 = r9.k;	 Catch:{ all -> 0x00c6 }
            r8.<init>(r9);	 Catch:{ all -> 0x00c6 }
            throw r8;	 Catch:{ all -> 0x00c6 }
        L_0x003c:
            r3 = r7.f;	 Catch:{ all -> 0x00c6 }
            r3 = r3.b;	 Catch:{ all -> 0x00c6 }
            r5 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1));
            if (r5 != 0) goto L_0x0048;
        L_0x0044:
            r8 = -1;
            monitor-exit(r2);	 Catch:{ all -> 0x00c6 }
            return r8;
        L_0x0048:
            r3 = r7.f;	 Catch:{ all -> 0x00c6 }
            r4 = r7.f;	 Catch:{ all -> 0x00c6 }
            r4 = r4.b;	 Catch:{ all -> 0x00c6 }
            r9 = java.lang.Math.min(r9, r4);	 Catch:{ all -> 0x00c6 }
            r8 = r3.a(r8, r9);	 Catch:{ all -> 0x00c6 }
            r10 = r7.d;	 Catch:{ all -> 0x00c6 }
            r3 = r10.a;	 Catch:{ all -> 0x00c6 }
            r5 = r3 + r8;
            r10.a = r5;	 Catch:{ all -> 0x00c6 }
            r10 = r7.d;	 Catch:{ all -> 0x00c6 }
            r3 = r10.a;	 Catch:{ all -> 0x00c6 }
            r10 = r7.d;	 Catch:{ all -> 0x00c6 }
            r10 = r10.d;	 Catch:{ all -> 0x00c6 }
            r10 = r10.m;	 Catch:{ all -> 0x00c6 }
            r10 = r10.b();	 Catch:{ all -> 0x00c6 }
            r10 = r10 / 2;
            r5 = (long) r10;	 Catch:{ all -> 0x00c6 }
            r10 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1));
            if (r10 < 0) goto L_0x0086;
        L_0x0073:
            r10 = r7.d;	 Catch:{ all -> 0x00c6 }
            r10 = r10.d;	 Catch:{ all -> 0x00c6 }
            r3 = r7.d;	 Catch:{ all -> 0x00c6 }
            r3 = r3.c;	 Catch:{ all -> 0x00c6 }
            r4 = r7.d;	 Catch:{ all -> 0x00c6 }
            r4 = r4.a;	 Catch:{ all -> 0x00c6 }
            r10.a(r3, r4);	 Catch:{ all -> 0x00c6 }
            r10 = r7.d;	 Catch:{ all -> 0x00c6 }
            r10.a = r0;	 Catch:{ all -> 0x00c6 }
        L_0x0086:
            monitor-exit(r2);	 Catch:{ all -> 0x00c6 }
            r10 = r7.d;
            r10 = r10.d;
            monitor-enter(r10);
            r2 = r7.d;	 Catch:{ all -> 0x00c3 }
            r2 = r2.d;	 Catch:{ all -> 0x00c3 }
            r3 = r2.k;	 Catch:{ all -> 0x00c3 }
            r5 = r3 + r8;
            r2.k = r5;	 Catch:{ all -> 0x00c3 }
            r2 = r7.d;	 Catch:{ all -> 0x00c3 }
            r2 = r2.d;	 Catch:{ all -> 0x00c3 }
            r2 = r2.k;	 Catch:{ all -> 0x00c3 }
            r4 = r7.d;	 Catch:{ all -> 0x00c3 }
            r4 = r4.d;	 Catch:{ all -> 0x00c3 }
            r4 = r4.m;	 Catch:{ all -> 0x00c3 }
            r4 = r4.b();	 Catch:{ all -> 0x00c3 }
            r4 = r4 / 2;
            r4 = (long) r4;	 Catch:{ all -> 0x00c3 }
            r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
            if (r6 < 0) goto L_0x00c1;
        L_0x00ad:
            r2 = r7.d;	 Catch:{ all -> 0x00c3 }
            r2 = r2.d;	 Catch:{ all -> 0x00c3 }
            r3 = 0;
            r4 = r7.d;	 Catch:{ all -> 0x00c3 }
            r4 = r4.d;	 Catch:{ all -> 0x00c3 }
            r4 = r4.k;	 Catch:{ all -> 0x00c3 }
            r2.a(r3, r4);	 Catch:{ all -> 0x00c3 }
            r2 = r7.d;	 Catch:{ all -> 0x00c3 }
            r2 = r2.d;	 Catch:{ all -> 0x00c3 }
            r2.k = r0;	 Catch:{ all -> 0x00c3 }
        L_0x00c1:
            monitor-exit(r10);	 Catch:{ all -> 0x00c3 }
            return r8;
        L_0x00c3:
            r8 = move-exception;
            monitor-exit(r10);	 Catch:{ all -> 0x00c3 }
            throw r8;
        L_0x00c6:
            r8 = move-exception;
            monitor-exit(r2);	 Catch:{ all -> 0x00c6 }
            throw r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.r.b.a(okio.e, long):long");
        }

        private void b() throws IOException {
            this.d.i.t_();
            while (this.f.b == 0 && !this.b && !this.a && this.d.k == null) {
                try {
                    this.d.h();
                } catch (Throwable th) {
                    this.d.i.b();
                }
            }
            this.d.i.b();
        }

        final void a(g gVar, long j) throws IOException {
            if (c || !Thread.holdsLock(this.d)) {
                while (j > 0) {
                    boolean z;
                    Object obj;
                    Object obj2;
                    synchronized (this.d) {
                        z = this.b;
                        obj = null;
                        obj2 = j + this.f.b > this.g ? 1 : null;
                    }
                    if (obj2 != null) {
                        gVar.f(j);
                        this.d.b(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        gVar.f(j);
                        return;
                    } else {
                        long a = gVar.a(this.e, j);
                        if (a == -1) {
                            throw new EOFException();
                        }
                        long j2 = j - a;
                        synchronized (this.d) {
                            if (this.f.b == 0) {
                                obj = 1;
                            }
                            this.f.a(this.e);
                            if (obj != null) {
                                this.d.notifyAll();
                            }
                        }
                        j = j2;
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public final w a() {
            return this.d.i;
        }

        public final void close() throws IOException {
            synchronized (this.d) {
                this.a = true;
                this.f.n();
                this.d.notifyAll();
            }
            this.d.f();
        }
    }

    /* compiled from: Http2Stream */
    class c extends okio.a {
        final /* synthetic */ r a;

        c(r rVar) {
            this.a = rVar;
        }

        protected final void a() {
            this.a.b(ErrorCode.CANCEL);
        }

        protected final IOException a(IOException iOException) {
            IOException socketTimeoutException = new SocketTimeoutException(com.alipay.sdk.data.a.f);
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        public final void b() throws IOException {
            if (u_()) {
                throw a(null);
            }
        }
    }

    r(int i, e eVar, boolean z, boolean z2, List<a> list) {
        if (eVar == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.c = i;
            this.d = eVar;
            this.b = (long) eVar.n.b();
            this.g = new b(this, (long) eVar.m.b());
            this.h = new a(this);
            this.g.b = z2;
            this.h.b = z;
            this.m = list;
        }
    }

    public final synchronized boolean a() {
        if (this.k != null) {
            return false;
        }
        if ((this.g.b || this.g.a) && ((this.h.b || this.h.a) && this.f)) {
            return false;
        }
        return true;
    }

    public final boolean b() {
        return this.d.b == ((this.c & 1) == 1);
    }

    public final synchronized List<a> c() throws IOException {
        List<a> list;
        if (b()) {
            this.i.t_();
            while (this.e == null && this.k == null) {
                try {
                    h();
                } finally {
                    this.i.b();
                }
            }
            list = this.e;
            if (list != null) {
                this.e = null;
            } else {
                throw new StreamResetException(this.k);
            }
        }
        throw new IllegalStateException("servers cannot read response headers");
        return list;
    }

    public final u d() {
        synchronized (this) {
            if (this.f || b()) {
            } else {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.h;
    }

    public final void a(ErrorCode errorCode) throws IOException {
        if (d(errorCode)) {
            this.d.b(this.c, errorCode);
        }
    }

    public final void b(ErrorCode errorCode) {
        if (d(errorCode)) {
            this.d.a(this.c, errorCode);
        }
    }

    private boolean d(ErrorCode errorCode) {
        if (l || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.k != null) {
                    return false;
                } else if (this.g.b && this.h.b) {
                    return false;
                } else {
                    this.k = errorCode;
                    notifyAll();
                    this.d.b(this.c);
                    return true;
                }
            }
        }
        throw new AssertionError();
    }

    final void e() {
        if (l || !Thread.holdsLock(this)) {
            boolean a;
            synchronized (this) {
                this.g.b = true;
                a = a();
                notifyAll();
            }
            if (!a) {
                this.d.b(this.c);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    final synchronized void c(ErrorCode errorCode) {
        if (this.k == null) {
            this.k = errorCode;
            notifyAll();
        }
    }

    final void f() throws IOException {
        if (l || !Thread.holdsLock(this)) {
            Object obj;
            boolean a;
            synchronized (this) {
                obj = (!this.g.b && this.g.a && (this.h.b || this.h.a)) ? 1 : null;
                a = a();
            }
            if (obj != null) {
                a(ErrorCode.CANCEL);
                return;
            }
            if (!a) {
                this.d.b(this.c);
            }
            return;
        }
        throw new AssertionError();
    }

    final void a(long j) {
        this.b += j;
        if (j > 0) {
            notifyAll();
        }
    }

    final void g() throws IOException {
        if (this.h.a) {
            throw new IOException("stream closed");
        } else if (this.h.b) {
            throw new IOException("stream finished");
        } else if (this.k != null) {
            throw new StreamResetException(this.k);
        }
    }

    final void h() throws java.io.InterruptedIOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r1.wait();	 Catch:{ InterruptedException -> 0x0004 }
        return;
    L_0x0004:
        r0 = new java.io.InterruptedIOException;
        r0.<init>();
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.r.h():void");
    }
}
