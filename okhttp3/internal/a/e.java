package okhttp3.internal.a;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import okio.f;

/* compiled from: DiskLruCache */
public final class e implements Closeable, Flushable {
    static final Pattern a = Pattern.compile("[a-z0-9_-]{1,120}");
    static final /* synthetic */ boolean j = true;
    final okhttp3.internal.d.a b;
    final int c;
    f d;
    final LinkedHashMap<String, b> e;
    int f;
    boolean g;
    boolean h;
    boolean i;
    private long k;
    private long l;
    private final Executor m;
    private final Runnable n;

    /* compiled from: DiskLruCache */
    public final class a {
        final b a;
        boolean b;
        final /* synthetic */ e c;
    }

    /* compiled from: DiskLruCache */
    private final class b {
        final String a;
        final long[] b;
        final File[] c;
        final File[] d;
        boolean e;
        a f;

        final void a(f fVar) throws IOException {
            for (long j : this.b) {
                fVar.h(32).j(j);
            }
        }
    }

    private synchronized void a(a aVar) throws IOException {
        b bVar = aVar.a;
        if (bVar.f != aVar) {
            throw new IllegalStateException();
        }
        for (int i = 0; i < this.c; i++) {
            this.b.a(bVar.d[i]);
        }
        this.f++;
        bVar.f = null;
        if ((null | bVar.e) != null) {
            bVar.e = true;
            this.d.b("CLEAN").h(32);
            this.d.b(bVar.a);
            bVar.a(this.d);
            this.d.h(10);
        } else {
            this.e.remove(bVar.a);
            this.d.b("REMOVE").h(32);
            this.d.b(bVar.a);
            this.d.h(10);
        }
        this.d.flush();
        if (this.l > this.k || a() != null) {
            this.m.execute(this.n);
        }
    }

    private boolean a() {
        return this.f >= 2000 && this.f >= this.e.size();
    }

    private boolean a(okhttp3.internal.a.e.b r9) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r9.f;
        r1 = 0;
        if (r0 == 0) goto L_0x0029;
    L_0x0005:
        r0 = r9.f;
        r2 = r0.a;
        r2 = r2.f;
        if (r2 != r0) goto L_0x0029;
    L_0x000d:
        r2 = r1;
    L_0x000e:
        r3 = r0.c;
        r3 = r3.c;
        if (r2 >= r3) goto L_0x0024;
    L_0x0014:
        r3 = r0.c;	 Catch:{ IOException -> 0x0021 }
        r3 = r3.b;	 Catch:{ IOException -> 0x0021 }
        r4 = r0.a;	 Catch:{ IOException -> 0x0021 }
        r4 = r4.d;	 Catch:{ IOException -> 0x0021 }
        r4 = r4[r2];	 Catch:{ IOException -> 0x0021 }
        r3.a(r4);	 Catch:{ IOException -> 0x0021 }
    L_0x0021:
        r2 = r2 + 1;
        goto L_0x000e;
    L_0x0024:
        r0 = r0.a;
        r2 = 0;
        r0.f = r2;
    L_0x0029:
        r0 = r8.c;
        if (r1 >= r0) goto L_0x0049;
    L_0x002d:
        r0 = r8.b;
        r2 = r9.c;
        r2 = r2[r1];
        r0.a(r2);
        r2 = r8.l;
        r0 = r9.b;
        r4 = r0[r1];
        r6 = r2 - r4;
        r8.l = r6;
        r0 = r9.b;
        r2 = 0;
        r0[r1] = r2;
        r1 = r1 + 1;
        goto L_0x0029;
    L_0x0049:
        r0 = r8.f;
        r1 = 1;
        r0 = r0 + r1;
        r8.f = r0;
        r0 = r8.d;
        r2 = "REMOVE";
        r0 = r0.b(r2);
        r2 = 32;
        r0 = r0.h(r2);
        r2 = r9.a;
        r0 = r0.b(r2);
        r2 = 10;
        r0.h(r2);
        r0 = r8.e;
        r9 = r9.a;
        r0.remove(r9);
        r9 = r8.a();
        if (r9 == 0) goto L_0x007c;
    L_0x0075:
        r9 = r8.m;
        r0 = r8.n;
        r9.execute(r0);
    L_0x007c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.a.e.a(okhttp3.internal.a.e$b):boolean");
    }

    private synchronized boolean b() {
        return this.h;
    }

    private synchronized void c() {
        if (b()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized void flush() throws IOException {
        if (this.g) {
            c();
            d();
            this.d.flush();
        }
    }

    public final synchronized void close() throws IOException {
        if (this.g) {
            if (!this.h) {
                for (b bVar : (b[]) this.e.values().toArray(new b[this.e.size()])) {
                    if (bVar.f != null) {
                        a aVar = bVar.f;
                        synchronized (aVar.c) {
                            if (aVar.b) {
                                throw new IllegalStateException();
                            }
                            if (aVar.a.f == aVar) {
                                aVar.c.a(aVar);
                            }
                            aVar.b = true;
                        }
                    }
                }
                d();
                this.d.close();
                this.d = null;
                this.h = true;
                return;
            }
        }
        this.h = true;
    }

    private void d() throws IOException {
        while (this.l > this.k) {
            a((b) this.e.values().iterator().next());
        }
        this.i = false;
    }
}
