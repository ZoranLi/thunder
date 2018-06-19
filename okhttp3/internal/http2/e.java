package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.b;
import okio.ByteString;
import okio.f;
import okio.g;

/* compiled from: Http2Connection */
public final class e implements Closeable {
    static final ExecutorService a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), okhttp3.internal.c.a("OkHttp Http2Connection", true));
    static final /* synthetic */ boolean t = true;
    final boolean b;
    final b c;
    final Map<Integer, r> d = new LinkedHashMap();
    final String e;
    int f;
    int g;
    boolean h;
    final ExecutorService i;
    final v j;
    long k = 0;
    long l;
    public x m = new x();
    final x n = new x();
    boolean o = false;
    final Socket p;
    public final s q;
    public final c r;
    final Set<Integer> s = new LinkedHashSet();
    private Map<Integer, u> u;
    private int v;

    /* compiled from: Http2Connection */
    public static class a {
        public Socket a;
        public String b;
        public g c;
        public f d;
        public b e = b.l;
        v f = v.a;
        boolean g = true;
    }

    /* compiled from: Http2Connection */
    class c extends b implements b {
        final q a;
        final /* synthetic */ e c;

        c(e eVar, q qVar) {
            this.c = eVar;
            super("OkHttp %s", eVar.e);
            this.a = qVar;
        }

        protected final void b() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r10 = this;
            r0 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR;
            r1 = okhttp3.internal.http2.ErrorCode.INTERNAL_ERROR;
            r2 = r10.a;	 Catch:{ IOException -> 0x0077 }
            r3 = r2.c;	 Catch:{ IOException -> 0x0077 }
            r4 = 1;	 Catch:{ IOException -> 0x0077 }
            r5 = 0;	 Catch:{ IOException -> 0x0077 }
            if (r3 == 0) goto L_0x001b;	 Catch:{ IOException -> 0x0077 }
        L_0x000c:
            r2 = r2.a(r4, r10);	 Catch:{ IOException -> 0x0077 }
            if (r2 != 0) goto L_0x005c;	 Catch:{ IOException -> 0x0077 }
        L_0x0012:
            r2 = "Required SETTINGS preface not received";	 Catch:{ IOException -> 0x0077 }
            r3 = new java.lang.Object[r5];	 Catch:{ IOException -> 0x0077 }
            r2 = okhttp3.internal.http2.c.b(r2, r3);	 Catch:{ IOException -> 0x0077 }
            throw r2;	 Catch:{ IOException -> 0x0077 }
        L_0x001b:
            r2 = r2.b;	 Catch:{ IOException -> 0x0077 }
            r3 = okhttp3.internal.http2.c.a;	 Catch:{ IOException -> 0x0077 }
            r3 = r3.size();	 Catch:{ IOException -> 0x0077 }
            r6 = (long) r3;	 Catch:{ IOException -> 0x0077 }
            r2 = r2.c(r6);	 Catch:{ IOException -> 0x0077 }
            r3 = okhttp3.internal.http2.q.a;	 Catch:{ IOException -> 0x0077 }
            r6 = java.util.logging.Level.FINE;	 Catch:{ IOException -> 0x0077 }
            r3 = r3.isLoggable(r6);	 Catch:{ IOException -> 0x0077 }
            if (r3 == 0) goto L_0x0045;	 Catch:{ IOException -> 0x0077 }
        L_0x0032:
            r3 = okhttp3.internal.http2.q.a;	 Catch:{ IOException -> 0x0077 }
            r6 = "<< CONNECTION %s";	 Catch:{ IOException -> 0x0077 }
            r7 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0077 }
            r8 = r2.hex();	 Catch:{ IOException -> 0x0077 }
            r7[r5] = r8;	 Catch:{ IOException -> 0x0077 }
            r6 = okhttp3.internal.c.a(r6, r7);	 Catch:{ IOException -> 0x0077 }
            r3.fine(r6);	 Catch:{ IOException -> 0x0077 }
        L_0x0045:
            r3 = okhttp3.internal.http2.c.a;	 Catch:{ IOException -> 0x0077 }
            r3 = r3.equals(r2);	 Catch:{ IOException -> 0x0077 }
            if (r3 != 0) goto L_0x005c;	 Catch:{ IOException -> 0x0077 }
        L_0x004d:
            r3 = "Expected a connection header but was %s";	 Catch:{ IOException -> 0x0077 }
            r4 = new java.lang.Object[r4];	 Catch:{ IOException -> 0x0077 }
            r2 = r2.utf8();	 Catch:{ IOException -> 0x0077 }
            r4[r5] = r2;	 Catch:{ IOException -> 0x0077 }
            r2 = okhttp3.internal.http2.c.b(r3, r4);	 Catch:{ IOException -> 0x0077 }
            throw r2;	 Catch:{ IOException -> 0x0077 }
        L_0x005c:
            r2 = r10.a;	 Catch:{ IOException -> 0x0077 }
            r2 = r2.a(r5, r10);	 Catch:{ IOException -> 0x0077 }
            if (r2 != 0) goto L_0x005c;	 Catch:{ IOException -> 0x0077 }
        L_0x0064:
            r2 = okhttp3.internal.http2.ErrorCode.NO_ERROR;	 Catch:{ IOException -> 0x0077 }
            r0 = okhttp3.internal.http2.ErrorCode.CANCEL;	 Catch:{ IOException -> 0x0073 }
            r1 = r10.c;	 Catch:{ IOException -> 0x006d }
        L_0x006a:
            r1.a(r2, r0);	 Catch:{ IOException -> 0x006d }
        L_0x006d:
            r0 = r10.a;
            okhttp3.internal.c.a(r0);
            return;
        L_0x0073:
            r0 = r2;
            goto L_0x0077;
        L_0x0075:
            r2 = move-exception;
            goto L_0x0082;
        L_0x0077:
            r2 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;	 Catch:{ all -> 0x0075 }
            r0 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;	 Catch:{ all -> 0x007e }
            r1 = r10.c;	 Catch:{ IOException -> 0x006d }
            goto L_0x006a;
        L_0x007e:
            r0 = move-exception;
            r9 = r2;
            r2 = r0;
            r0 = r9;
        L_0x0082:
            r3 = r10.c;	 Catch:{ IOException -> 0x0087 }
            r3.a(r0, r1);	 Catch:{ IOException -> 0x0087 }
        L_0x0087:
            r0 = r10.a;
            okhttp3.internal.c.a(r0);
            throw r2;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.e.c.b():void");
        }

        public final void a(boolean z, int i, g gVar, int i2) throws IOException {
            if (e.d(i)) {
                e eVar = this.c;
                okio.e eVar2 = new okio.e();
                long j = (long) i2;
                gVar.a(j);
                gVar.a(eVar2, j);
                if (eVar2.b != j) {
                    i = new StringBuilder();
                    i.append(eVar2.b);
                    i.append(" != ");
                    i.append(i2);
                    throw new IOException(i.toString());
                }
                eVar.i.execute(new k(eVar, "OkHttp %s Push Data[%s]", new Object[]{eVar.e, Integer.valueOf(i)}, i, eVar2, i2, z));
                return;
            }
            r a = this.c.a(i);
            if (a == null) {
                this.c.a(i, ErrorCode.PROTOCOL_ERROR);
                gVar.f((long) i2);
            } else if (r.l != 0 || Thread.holdsLock(a) == 0) {
                a.g.a(gVar, (long) i2);
                if (z) {
                    a.e();
                }
            } else {
                throw new AssertionError();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(boolean r13, int r14, java.util.List<okhttp3.internal.http2.a> r15) {
            /*
            r12 = this;
            r0 = okhttp3.internal.http2.e.d(r14);
            r1 = 0;
            r2 = 1;
            r3 = 2;
            if (r0 == 0) goto L_0x0028;
        L_0x0009:
            r5 = r12.c;
            r0 = r5.i;
            r11 = new okhttp3.internal.http2.j;
            r6 = "OkHttp %s Push Headers[%s]";
            r7 = new java.lang.Object[r3];
            r3 = r5.e;
            r7[r1] = r3;
            r1 = java.lang.Integer.valueOf(r14);
            r7[r2] = r1;
            r4 = r11;
            r8 = r14;
            r9 = r15;
            r10 = r13;
            r4.<init>(r5, r6, r7, r8, r9, r10);
            r0.execute(r11);
            return;
        L_0x0028:
            r0 = r12.c;
            monitor-enter(r0);
            r4 = r12.c;	 Catch:{ all -> 0x00cd }
            r4 = r4.h;	 Catch:{ all -> 0x00cd }
            if (r4 == 0) goto L_0x0033;
        L_0x0031:
            monitor-exit(r0);	 Catch:{ all -> 0x00cd }
            return;
        L_0x0033:
            r4 = r12.c;	 Catch:{ all -> 0x00cd }
            r4 = r4.a(r14);	 Catch:{ all -> 0x00cd }
            if (r4 != 0) goto L_0x0085;
        L_0x003b:
            r4 = r12.c;	 Catch:{ all -> 0x00cd }
            r4 = r4.f;	 Catch:{ all -> 0x00cd }
            if (r14 > r4) goto L_0x0043;
        L_0x0041:
            monitor-exit(r0);	 Catch:{ all -> 0x00cd }
            return;
        L_0x0043:
            r4 = r14 % 2;
            r5 = r12.c;	 Catch:{ all -> 0x00cd }
            r5 = r5.g;	 Catch:{ all -> 0x00cd }
            r5 = r5 % r3;
            if (r4 != r5) goto L_0x004e;
        L_0x004c:
            monitor-exit(r0);	 Catch:{ all -> 0x00cd }
            return;
        L_0x004e:
            r10 = new okhttp3.internal.http2.r;	 Catch:{ all -> 0x00cd }
            r6 = r12.c;	 Catch:{ all -> 0x00cd }
            r7 = 0;
            r4 = r10;
            r5 = r14;
            r8 = r13;
            r9 = r15;
            r4.<init>(r5, r6, r7, r8, r9);	 Catch:{ all -> 0x00cd }
            r13 = r12.c;	 Catch:{ all -> 0x00cd }
            r13.f = r14;	 Catch:{ all -> 0x00cd }
            r13 = r12.c;	 Catch:{ all -> 0x00cd }
            r13 = r13.d;	 Catch:{ all -> 0x00cd }
            r15 = java.lang.Integer.valueOf(r14);	 Catch:{ all -> 0x00cd }
            r13.put(r15, r10);	 Catch:{ all -> 0x00cd }
            r13 = okhttp3.internal.http2.e.a;	 Catch:{ all -> 0x00cd }
            r15 = new okhttp3.internal.http2.n;	 Catch:{ all -> 0x00cd }
            r4 = "OkHttp %s stream %d";
            r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x00cd }
            r5 = r12.c;	 Catch:{ all -> 0x00cd }
            r5 = r5.e;	 Catch:{ all -> 0x00cd }
            r3[r1] = r5;	 Catch:{ all -> 0x00cd }
            r14 = java.lang.Integer.valueOf(r14);	 Catch:{ all -> 0x00cd }
            r3[r2] = r14;	 Catch:{ all -> 0x00cd }
            r15.<init>(r12, r4, r3, r10);	 Catch:{ all -> 0x00cd }
            r13.execute(r15);	 Catch:{ all -> 0x00cd }
            monitor-exit(r0);	 Catch:{ all -> 0x00cd }
            return;
        L_0x0085:
            monitor-exit(r0);	 Catch:{ all -> 0x00cd }
            r14 = okhttp3.internal.http2.r.l;
            if (r14 != 0) goto L_0x0096;
        L_0x008a:
            r14 = java.lang.Thread.holdsLock(r4);
            if (r14 == 0) goto L_0x0096;
        L_0x0090:
            r13 = new java.lang.AssertionError;
            r13.<init>();
            throw r13;
        L_0x0096:
            monitor-enter(r4);
            r4.f = r2;	 Catch:{ all -> 0x00ca }
            r14 = r4.e;	 Catch:{ all -> 0x00ca }
            if (r14 != 0) goto L_0x00a7;
        L_0x009d:
            r4.e = r15;	 Catch:{ all -> 0x00ca }
            r2 = r4.a();	 Catch:{ all -> 0x00ca }
            r4.notifyAll();	 Catch:{ all -> 0x00ca }
            goto L_0x00ba;
        L_0x00a7:
            r14 = new java.util.ArrayList;	 Catch:{ all -> 0x00ca }
            r14.<init>();	 Catch:{ all -> 0x00ca }
            r0 = r4.e;	 Catch:{ all -> 0x00ca }
            r14.addAll(r0);	 Catch:{ all -> 0x00ca }
            r0 = 0;
            r14.add(r0);	 Catch:{ all -> 0x00ca }
            r14.addAll(r15);	 Catch:{ all -> 0x00ca }
            r4.e = r14;	 Catch:{ all -> 0x00ca }
        L_0x00ba:
            monitor-exit(r4);	 Catch:{ all -> 0x00ca }
            if (r2 != 0) goto L_0x00c4;
        L_0x00bd:
            r14 = r4.d;
            r15 = r4.c;
            r14.b(r15);
        L_0x00c4:
            if (r13 == 0) goto L_0x00c9;
        L_0x00c6:
            r4.e();
        L_0x00c9:
            return;
        L_0x00ca:
            r13 = move-exception;
            monitor-exit(r4);	 Catch:{ all -> 0x00ca }
            throw r13;
        L_0x00cd:
            r13 = move-exception;
            monitor-exit(r0);	 Catch:{ all -> 0x00cd }
            throw r13;
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.e.c.a(boolean, int, java.util.List):void");
        }

        public final void a(int i, ErrorCode errorCode) {
            if (e.d(i)) {
                e eVar = this.c;
                eVar.i.execute(new l(eVar, "OkHttp %s Push Reset[%s]", new Object[]{eVar.e, Integer.valueOf(i)}, i, errorCode));
                return;
            }
            i = this.c.b(i);
            if (i != 0) {
                i.c(errorCode);
            }
        }

        public final void a(x xVar) {
            synchronized (this.c) {
                long j;
                int b = this.c.n.b();
                x xVar2 = this.c.n;
                int i = 0;
                for (int i2 = 0; i2 < 10; i2++) {
                    if (xVar.a(i2)) {
                        xVar2.a(i2, xVar.b[i2]);
                    }
                }
                e.a.execute(new p(this, "OkHttp %s ACK Settings", new Object[]{this.c.e}, xVar));
                xVar = this.c.n.b();
                r[] rVarArr = null;
                if (xVar == -1 || xVar == b) {
                    j = 0;
                } else {
                    j = (long) (xVar - b);
                    if (this.c.o == null) {
                        xVar = this.c;
                        xVar.l += j;
                        if (j > 0) {
                            xVar.notifyAll();
                        }
                        this.c.o = true;
                    }
                    if (this.c.d.isEmpty() == null) {
                        rVarArr = (r[]) this.c.d.values().toArray(new r[this.c.d.size()]);
                    }
                }
                e.a.execute(new o(this, "OkHttp %s settings", this.c.e));
            }
            if (rVarArr != null && j != 0) {
                xVar = rVarArr.length;
                while (i < xVar) {
                    r rVar = rVarArr[i];
                    synchronized (rVar) {
                        rVar.a(j);
                    }
                    i++;
                }
            }
        }

        public final void a(boolean z, int i, int i2) {
            if (z) {
                z = this.c.c(i);
                if (z) {
                    if (z.c == -1) {
                        if (z.b != -1) {
                            z.c = System.nanoTime();
                            z.a.countDown();
                        }
                    }
                    throw new IllegalStateException();
                }
                return;
            }
            e eVar = this.c;
            e.a.execute(new h(eVar, "OkHttp %s ping %08x%08x", new Object[]{eVar.e, Integer.valueOf(i), Integer.valueOf(i2)}, i, i2));
        }

        public final void a(int i, ByteString byteString) {
            byteString.size();
            synchronized (this.c) {
                r[] rVarArr = (r[]) this.c.d.values().toArray(new r[this.c.d.size()]);
                this.c.h = true;
            }
            for (r rVar : rVarArr) {
                if (rVar.c > i && rVar.b()) {
                    rVar.c(ErrorCode.REFUSED_STREAM);
                    this.c.b(rVar.c);
                }
            }
        }

        public final void a(int i, long j) {
            if (i == 0) {
                synchronized (this.c) {
                    i = this.c;
                    i.l += j;
                    this.c.notifyAll();
                }
                return;
            }
            i = this.c.a(i);
            if (i != 0) {
                synchronized (i) {
                    i.a(j);
                }
            }
        }

        public final void a(int i, List<a> list) {
            e eVar = this.c;
            synchronized (eVar) {
                if (eVar.s.contains(Integer.valueOf(i))) {
                    eVar.a(i, ErrorCode.PROTOCOL_ERROR);
                    return;
                }
                eVar.s.add(Integer.valueOf(i));
                eVar.i.execute(new i(eVar, "OkHttp %s Push Request[%s]", new Object[]{eVar.e, Integer.valueOf(i)}, i, list));
            }
        }
    }

    static boolean d(int i) {
        return i != 0 && (i & 1) == 0;
    }

    public e(a aVar) {
        this.j = aVar.f;
        this.b = aVar.g;
        this.c = aVar.e;
        int i = 2;
        this.g = aVar.g ? 1 : 2;
        if (aVar.g) {
            this.g += 2;
        }
        if (aVar.g) {
            i = 1;
        }
        this.v = i;
        if (aVar.g) {
            this.m.a(7, 16777216);
        }
        this.e = aVar.b;
        this.i = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), okhttp3.internal.c.a(okhttp3.internal.c.a("OkHttp %s Push Observer", this.e), true));
        this.n.a(7, 65535);
        this.n.a(5, 16384);
        this.l = (long) this.n.b();
        this.p = aVar.a;
        this.q = new s(aVar.d, this.b);
        this.r = new c(this, new q(aVar.c, this.b));
    }

    final synchronized r a(int i) {
        return (r) this.d.get(Integer.valueOf(i));
    }

    final synchronized r b(int i) {
        r rVar;
        rVar = (r) this.d.remove(Integer.valueOf(i));
        notifyAll();
        return rVar;
    }

    public final synchronized int a() {
        x xVar = this.n;
        if ((16 & xVar.a) == 0) {
            return Integer.MAX_VALUE;
        }
        return xVar.b[4];
    }

    final r a(List<a> list, boolean z) throws IOException {
        r rVar;
        boolean z2 = z ^ 1;
        synchronized (this.q) {
            int i;
            synchronized (this) {
                if (this.h) {
                    throw new ConnectionShutdownException();
                }
                i = this.g;
                this.g += 2;
                rVar = new r(i, this, z2, false, list);
                if (z && this.l != 0) {
                    if (rVar.b != 0) {
                        z = false;
                        if (rVar.a()) {
                            this.d.put(Integer.valueOf(i), rVar);
                        }
                    }
                }
                z = true;
                if (rVar.a()) {
                    this.d.put(Integer.valueOf(i), rVar);
                }
            }
            this.q.a(z2, i, (List) list);
        }
        if (z) {
            this.q.b();
        }
        return rVar;
    }

    public final void a(int r11, boolean r12, okio.e r13, long r14) throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = 0;
        r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        r3 = 0;
        if (r2 != 0) goto L_0x000d;
    L_0x0007:
        r14 = r10.q;
        r14.a(r12, r11, r13, r3);
        return;
    L_0x000d:
        r2 = (r14 > r0 ? 1 : (r14 == r0 ? 0 : -1));
        if (r2 <= 0) goto L_0x0063;
    L_0x0011:
        monitor-enter(r10);
    L_0x0012:
        r4 = r10.l;	 Catch:{ InterruptedException -> 0x005b }
        r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));	 Catch:{ InterruptedException -> 0x005b }
        if (r2 > 0) goto L_0x0030;	 Catch:{ InterruptedException -> 0x005b }
    L_0x0018:
        r2 = r10.d;	 Catch:{ InterruptedException -> 0x005b }
        r4 = java.lang.Integer.valueOf(r11);	 Catch:{ InterruptedException -> 0x005b }
        r2 = r2.containsKey(r4);	 Catch:{ InterruptedException -> 0x005b }
        if (r2 != 0) goto L_0x002c;	 Catch:{ InterruptedException -> 0x005b }
    L_0x0024:
        r11 = new java.io.IOException;	 Catch:{ InterruptedException -> 0x005b }
        r12 = "stream closed";	 Catch:{ InterruptedException -> 0x005b }
        r11.<init>(r12);	 Catch:{ InterruptedException -> 0x005b }
        throw r11;	 Catch:{ InterruptedException -> 0x005b }
    L_0x002c:
        r10.wait();	 Catch:{ InterruptedException -> 0x005b }
        goto L_0x0012;
    L_0x0030:
        r4 = r10.l;	 Catch:{ all -> 0x0059 }
        r4 = java.lang.Math.min(r14, r4);	 Catch:{ all -> 0x0059 }
        r2 = (int) r4;	 Catch:{ all -> 0x0059 }
        r4 = r10.q;	 Catch:{ all -> 0x0059 }
        r4 = r4.a;	 Catch:{ all -> 0x0059 }
        r2 = java.lang.Math.min(r2, r4);	 Catch:{ all -> 0x0059 }
        r4 = r10.l;	 Catch:{ all -> 0x0059 }
        r6 = (long) r2;	 Catch:{ all -> 0x0059 }
        r8 = r4 - r6;	 Catch:{ all -> 0x0059 }
        r10.l = r8;	 Catch:{ all -> 0x0059 }
        monitor-exit(r10);	 Catch:{ all -> 0x0059 }
        r4 = r14 - r6;
        r14 = r10.q;
        if (r12 == 0) goto L_0x0053;
    L_0x004d:
        r15 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r15 != 0) goto L_0x0053;
    L_0x0051:
        r15 = 1;
        goto L_0x0054;
    L_0x0053:
        r15 = r3;
    L_0x0054:
        r14.a(r15, r11, r13, r2);
        r14 = r4;
        goto L_0x000d;
    L_0x0059:
        r11 = move-exception;
        goto L_0x0061;
    L_0x005b:
        r11 = new java.io.InterruptedIOException;	 Catch:{ all -> 0x0059 }
        r11.<init>();	 Catch:{ all -> 0x0059 }
        throw r11;	 Catch:{ all -> 0x0059 }
    L_0x0061:
        monitor-exit(r10);	 Catch:{ all -> 0x0059 }
        throw r11;
    L_0x0063:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.e.a(int, boolean, okio.e, long):void");
    }

    final void a(int i, ErrorCode errorCode) {
        a.execute(new f(this, "OkHttp %s stream %d", new Object[]{this.e, Integer.valueOf(i)}, i, errorCode));
    }

    final void b(int i, ErrorCode errorCode) throws IOException {
        this.q.a(i, errorCode);
    }

    final void a(int i, long j) {
        a.execute(new g(this, "OkHttp Window Update %s stream %d", new Object[]{this.e, Integer.valueOf(i)}, i, j));
    }

    final synchronized u c(int i) {
        if (this.u == null) {
            return 0;
        }
        return (u) this.u.remove(Integer.valueOf(i));
    }

    public final void close() throws IOException {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    final void a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        ErrorCode errorCode3;
        if (t || !Thread.holdsLock(this)) {
            int i;
            r[] rVarArr;
            u uVar;
            Map map = null;
            try {
                synchronized (this.q) {
                    synchronized (this) {
                        if (this.h) {
                        } else {
                            this.h = true;
                            this.q.a(this.f, errorCode, okhttp3.internal.c.a);
                        }
                    }
                    i = 0;
                    if (rVarArr != null) {
                        errorCode3 = errorCode;
                        for (r a : rVarArr) {
                            try {
                                a.a(errorCode2);
                            } catch (IOException e) {
                                if (errorCode3 != null) {
                                    errorCode3 = e;
                                }
                            }
                        }
                        errorCode = errorCode3;
                    }
                    if (map != null) {
                        errorCode2 = map.length;
                        while (i < errorCode2) {
                            uVar = map[i];
                            if (uVar.c != -1) {
                                if (uVar.b == -1) {
                                    uVar.c = uVar.b - 1;
                                    uVar.a.countDown();
                                    i++;
                                }
                            }
                            throw new IllegalStateException();
                        }
                    }
                    this.q.close();
                    this.p.close();
                    if (errorCode != null) {
                        throw errorCode;
                    }
                    return;
                }
                errorCode = null;
            } catch (IOException e2) {
                errorCode = e2;
            }
            synchronized (this) {
                if (this.d.isEmpty()) {
                    rVarArr = null;
                } else {
                    rVarArr = (r[]) this.d.values().toArray(new r[this.d.size()]);
                    this.d.clear();
                }
                if (this.u != null) {
                    u[] uVarArr = (u[]) this.u.values().toArray(new u[this.u.size()]);
                    this.u = null;
                    map = uVarArr;
                }
            }
            i = 0;
            if (rVarArr != null) {
                errorCode3 = errorCode;
                while (errorCode < r3) {
                    a.a(errorCode2);
                }
                errorCode = errorCode3;
            }
            if (map != null) {
                errorCode2 = map.length;
                while (i < errorCode2) {
                    uVar = map[i];
                    if (uVar.c != -1) {
                        if (uVar.b == -1) {
                            uVar.c = uVar.b - 1;
                            uVar.a.countDown();
                            i++;
                        }
                    }
                    throw new IllegalStateException();
                }
            }
            try {
                this.q.close();
            } catch (ErrorCode errorCode22) {
                if (errorCode == null) {
                    errorCode = errorCode22;
                }
            }
            try {
                this.p.close();
            } catch (IOException e3) {
                errorCode = e3;
            }
            if (errorCode != null) {
                throw errorCode;
            }
            return;
        }
        throw new AssertionError();
    }

    public final synchronized boolean b() {
        return this.h;
    }
}
