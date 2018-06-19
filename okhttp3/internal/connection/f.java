package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Proxy.Type;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import okhttp3.ac;
import okhttp3.am;
import okhttp3.internal.b.c;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;
import okhttp3.internal.http2.d;
import okhttp3.l;

/* compiled from: StreamAllocation */
public final class f {
    public static final /* synthetic */ boolean g = true;
    public final okhttp3.a a;
    public am b;
    public final l c;
    public final e d;
    public c e;
    public c f;
    private final Object h;
    private int i;
    private boolean j;
    private boolean k;

    /* compiled from: StreamAllocation */
    public static final class a extends WeakReference<f> {
        public final Object a;

        a(f fVar, Object obj) {
            super(fVar);
            this.a = obj;
        }
    }

    public f(l lVar, okhttp3.a aVar, Object obj) {
        this.c = lVar;
        this.a = aVar;
        this.d = new e(aVar, e());
        this.h = obj;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.c a(int r4, int r5, int r6, boolean r7, boolean r8) throws java.io.IOException {
        /*
        r3 = this;
    L_0x0000:
        r0 = r3.a(r4, r5, r6, r7);
        r1 = r3.c;
        monitor-enter(r1);
        r2 = r0.h;	 Catch:{ all -> 0x0019 }
        if (r2 != 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        return r0;
    L_0x000d:
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        r1 = r0.a(r8);
        if (r1 != 0) goto L_0x0018;
    L_0x0014:
        r3.d();
        goto L_0x0000;
    L_0x0018:
        return r0;
    L_0x0019:
        r4 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0019 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.f.a(int, int, int, boolean, boolean):okhttp3.internal.connection.c");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private okhttp3.internal.connection.c a(int r7, int r8, int r9, boolean r10) throws java.io.IOException {
        /*
        r6 = this;
        r0 = r6.c;
        monitor-enter(r0);
        r1 = r6.j;	 Catch:{ all -> 0x00b3 }
        if (r1 == 0) goto L_0x000f;
    L_0x0007:
        r7 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00b3 }
        r8 = "released";
        r7.<init>(r8);	 Catch:{ all -> 0x00b3 }
        throw r7;	 Catch:{ all -> 0x00b3 }
    L_0x000f:
        r1 = r6.f;	 Catch:{ all -> 0x00b3 }
        if (r1 == 0) goto L_0x001b;
    L_0x0013:
        r7 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x00b3 }
        r8 = "codec != null";
        r7.<init>(r8);	 Catch:{ all -> 0x00b3 }
        throw r7;	 Catch:{ all -> 0x00b3 }
    L_0x001b:
        r1 = r6.k;	 Catch:{ all -> 0x00b3 }
        if (r1 == 0) goto L_0x0027;
    L_0x001f:
        r7 = new java.io.IOException;	 Catch:{ all -> 0x00b3 }
        r8 = "Canceled";
        r7.<init>(r8);	 Catch:{ all -> 0x00b3 }
        throw r7;	 Catch:{ all -> 0x00b3 }
    L_0x0027:
        r1 = r6.e;	 Catch:{ all -> 0x00b3 }
        if (r1 == 0) goto L_0x0031;
    L_0x002b:
        r2 = r1.g;	 Catch:{ all -> 0x00b3 }
        if (r2 != 0) goto L_0x0031;
    L_0x002f:
        monitor-exit(r0);	 Catch:{ all -> 0x00b3 }
        return r1;
    L_0x0031:
        r1 = okhttp3.internal.a.a;	 Catch:{ all -> 0x00b3 }
        r2 = r6.c;	 Catch:{ all -> 0x00b3 }
        r3 = r6.a;	 Catch:{ all -> 0x00b3 }
        r4 = 0;
        r1.a(r2, r3, r6, r4);	 Catch:{ all -> 0x00b3 }
        r1 = r6.e;	 Catch:{ all -> 0x00b3 }
        if (r1 == 0) goto L_0x0043;
    L_0x003f:
        r7 = r6.e;	 Catch:{ all -> 0x00b3 }
        monitor-exit(r0);	 Catch:{ all -> 0x00b3 }
        return r7;
    L_0x0043:
        r1 = r6.b;	 Catch:{ all -> 0x00b3 }
        monitor-exit(r0);	 Catch:{ all -> 0x00b3 }
        if (r1 != 0) goto L_0x004e;
    L_0x0048:
        r0 = r6.d;
        r1 = r0.a();
    L_0x004e:
        r2 = r6.c;
        monitor-enter(r2);
        r0 = r6.k;	 Catch:{ all -> 0x00b0 }
        if (r0 == 0) goto L_0x005d;
    L_0x0055:
        r7 = new java.io.IOException;	 Catch:{ all -> 0x00b0 }
        r8 = "Canceled";
        r7.<init>(r8);	 Catch:{ all -> 0x00b0 }
        throw r7;	 Catch:{ all -> 0x00b0 }
    L_0x005d:
        r0 = okhttp3.internal.a.a;	 Catch:{ all -> 0x00b0 }
        r3 = r6.c;	 Catch:{ all -> 0x00b0 }
        r5 = r6.a;	 Catch:{ all -> 0x00b0 }
        r0.a(r3, r5, r6, r1);	 Catch:{ all -> 0x00b0 }
        r0 = r6.e;	 Catch:{ all -> 0x00b0 }
        if (r0 == 0) goto L_0x0070;
    L_0x006a:
        r6.b = r1;	 Catch:{ all -> 0x00b0 }
        r7 = r6.e;	 Catch:{ all -> 0x00b0 }
        monitor-exit(r2);	 Catch:{ all -> 0x00b0 }
        return r7;
    L_0x0070:
        r6.b = r1;	 Catch:{ all -> 0x00b0 }
        r0 = 0;
        r6.i = r0;	 Catch:{ all -> 0x00b0 }
        r0 = new okhttp3.internal.connection.c;	 Catch:{ all -> 0x00b0 }
        r3 = r6.c;	 Catch:{ all -> 0x00b0 }
        r0.<init>(r3, r1);	 Catch:{ all -> 0x00b0 }
        r6.a(r0);	 Catch:{ all -> 0x00b0 }
        monitor-exit(r2);	 Catch:{ all -> 0x00b0 }
        r0.a(r7, r8, r9, r10);
        r7 = r6.e();
        r8 = r0.a;
        r7.b(r8);
        r7 = r6.c;
        monitor-enter(r7);
        r8 = okhttp3.internal.a.a;	 Catch:{ all -> 0x00ad }
        r9 = r6.c;	 Catch:{ all -> 0x00ad }
        r8.b(r9, r0);	 Catch:{ all -> 0x00ad }
        r8 = r0.c();	 Catch:{ all -> 0x00ad }
        if (r8 == 0) goto L_0x00a8;
    L_0x009c:
        r8 = okhttp3.internal.a.a;	 Catch:{ all -> 0x00ad }
        r9 = r6.c;	 Catch:{ all -> 0x00ad }
        r10 = r6.a;	 Catch:{ all -> 0x00ad }
        r4 = r8.a(r9, r10, r6);	 Catch:{ all -> 0x00ad }
        r0 = r6.e;	 Catch:{ all -> 0x00ad }
    L_0x00a8:
        monitor-exit(r7);	 Catch:{ all -> 0x00ad }
        okhttp3.internal.c.a(r4);
        return r0;
    L_0x00ad:
        r8 = move-exception;
        monitor-exit(r7);	 Catch:{ all -> 0x00ad }
        throw r8;
    L_0x00b0:
        r7 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x00b0 }
        throw r7;
    L_0x00b3:
        r7 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x00b3 }
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.f.a(int, int, int, boolean):okhttp3.internal.connection.c");
    }

    public final void a(boolean z, c cVar) {
        Socket a;
        synchronized (this.c) {
            if (cVar != null) {
                if (cVar == this.f) {
                    if (!z) {
                        c cVar2 = this.e;
                        cVar2.h++;
                    }
                    a = a(z, false, true);
                }
            }
            StringBuilder stringBuilder = new StringBuilder("expected ");
            stringBuilder.append(this.f);
            stringBuilder.append(" but was ");
            stringBuilder.append(cVar);
            throw new IllegalStateException(stringBuilder.toString());
        }
        okhttp3.internal.c.a(a);
    }

    public final c a() {
        c cVar;
        synchronized (this.c) {
            cVar = this.f;
        }
        return cVar;
    }

    private d e() {
        return okhttp3.internal.a.a.a(this.c);
    }

    public final synchronized c b() {
        return this.e;
    }

    public final void c() {
        Socket a;
        synchronized (this.c) {
            a = a(false, true, false);
        }
        okhttp3.internal.c.a(a);
    }

    public final void d() {
        Socket a;
        synchronized (this.c) {
            a = a(true, false, false);
        }
        okhttp3.internal.c.a(a);
    }

    public final Socket a(boolean z, boolean z2, boolean z3) {
        if (g || Thread.holdsLock(this.c)) {
            if (z3) {
                this.f = null;
            }
            if (z2) {
                this.j = true;
            }
            if (this.e) {
                if (z) {
                    this.e.g = true;
                }
                if (!this.f && (this.j || this.e.g)) {
                    b(this.e);
                    if (this.e.j.isEmpty()) {
                        this.e.k = System.nanoTime();
                        if (okhttp3.internal.a.a.a(this.c, this.e)) {
                            z = this.e.b;
                            this.e = null;
                            return z;
                        }
                    }
                    z = false;
                    this.e = null;
                    return z;
                }
            }
            return false;
        }
        throw new AssertionError();
    }

    public final void a(IOException iOException) {
        Socket a;
        synchronized (this.c) {
            if (iOException instanceof StreamResetException) {
                StreamResetException streamResetException = (StreamResetException) iOException;
                if (streamResetException.errorCode == ErrorCode.REFUSED_STREAM) {
                    this.i++;
                }
                if (streamResetException.errorCode != ErrorCode.REFUSED_STREAM || this.i > 1) {
                    this.b = null;
                }
                iOException = null;
                a = a(iOException, false, true);
            } else {
                if (this.e != null && (!this.e.c() || (iOException instanceof ConnectionShutdownException))) {
                    if (this.e.h == 0) {
                        if (!(this.b == null || iOException == null)) {
                            e eVar = this.d;
                            am amVar = this.b;
                            if (!(amVar.b.type() == Type.DIRECT || eVar.a.g == null)) {
                                eVar.a.g.connectFailed(eVar.a.a.a(), amVar.b.address(), iOException);
                            }
                            eVar.b.a(amVar);
                        }
                        this.b = null;
                    }
                }
                iOException = null;
                a = a(iOException, false, true);
            }
            iOException = 1;
            a = a(iOException, false, true);
        }
        okhttp3.internal.c.a(a);
    }

    public final void a(c cVar) {
        if (!g && !Thread.holdsLock(this.c)) {
            throw new AssertionError();
        } else if (this.e != null) {
            throw new IllegalStateException();
        } else {
            this.e = cVar;
            cVar.j.add(new a(this, this.h));
        }
    }

    private void b(c cVar) {
        int size = cVar.j.size();
        for (int i = 0; i < size; i++) {
            if (((Reference) cVar.j.get(i)).get() == this) {
                cVar.j.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    public final String toString() {
        c b = b();
        return b != null ? b.toString() : this.a.toString();
    }

    public final c a(ac acVar, boolean z) {
        try {
            c dVar;
            z = a(acVar.z, acVar.A, acVar.B, acVar.y, z);
            if (z.d != null) {
                dVar = new d(acVar, this, z.d);
            } else {
                z.b.setSoTimeout(acVar.A);
                z.e.a().a((long) acVar.A, TimeUnit.MILLISECONDS);
                z.f.a().a((long) acVar.B, TimeUnit.MILLISECONDS);
                dVar = new okhttp3.internal.c.a(acVar, this, z.e, z.f);
            }
            synchronized (this.c) {
                this.f = dVar;
            }
            return dVar;
        } catch (ac acVar2) {
            throw new RouteException(acVar2);
        }
    }
}
