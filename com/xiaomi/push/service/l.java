package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;

public class l {
    private static long a;
    private static long b;
    private static long c;
    private final c d;
    private final a e;

    private static final class a {
        private final c a;

        a(c cVar) {
            this.a = cVar;
        }

        protected final void finalize() {
            try {
                synchronized (this.a) {
                    this.a.e = true;
                    this.a.notify();
                }
                super.finalize();
            } catch (Throwable th) {
                super.finalize();
            }
        }
    }

    public static abstract class b implements Runnable {
        protected int a;

        public b(int i) {
            this.a = i;
        }
    }

    private static final class c extends Thread {
        private volatile long a = 0;
        private volatile boolean b = false;
        private long c = 50;
        private boolean d;
        private boolean e;
        private a f = new a();

        private static final class a {
            private int a;
            private d[] b;
            private int c;
            private int d;

            private a() {
                this.a = 256;
                this.b = new d[this.a];
                this.c = 0;
                this.d = 0;
            }

            private int b(d dVar) {
                for (int i = 0; i < this.b.length; i++) {
                    if (this.b[i] == dVar) {
                        return i;
                    }
                }
                return -1;
            }

            private void d(int i) {
                int i2 = (2 * i) + 1;
                while (i2 < this.c && this.c > 0) {
                    int i3 = i2 + 1;
                    if (i3 < this.c && this.b[i3].c < this.b[i2].c) {
                        i2 = i3;
                    }
                    if (this.b[i].c >= this.b[i2].c) {
                        d dVar = this.b[i];
                        this.b[i] = this.b[i2];
                        this.b[i2] = dVar;
                        int i4 = i2;
                        i2 = (2 * i2) + 1;
                        i = i4;
                    } else {
                        return;
                    }
                }
            }

            private void e() {
                int i = this.c - 1;
                int i2 = (i - 1) / 2;
                while (this.b[i].c < this.b[i2].c) {
                    d dVar = this.b[i];
                    this.b[i] = this.b[i2];
                    this.b[i2] = dVar;
                    int i3 = i2;
                    i2 = (i2 - 1) / 2;
                    i = i3;
                }
            }

            public final d a() {
                return this.b[0];
            }

            public final void a(int i, b bVar) {
                for (i = 0; i < this.c; i++) {
                    if (this.b[i].d == bVar) {
                        this.b[i].a();
                    }
                }
                d();
            }

            public final void a(d dVar) {
                if (this.b.length == this.c) {
                    Object obj = new d[(this.c * 2)];
                    System.arraycopy(this.b, 0, obj, 0, this.c);
                    this.b = obj;
                }
                d[] dVarArr = this.b;
                int i = this.c;
                this.c = i + 1;
                dVarArr[i] = dVar;
                e();
            }

            public final boolean a(int i) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    if (this.b[i2].e == i) {
                        return true;
                    }
                }
                return false;
            }

            public final void b(int i) {
                for (int i2 = 0; i2 < this.c; i2++) {
                    if (this.b[i2].e == i) {
                        this.b[i2].a();
                    }
                }
                d();
            }

            public final boolean b() {
                return this.c == 0;
            }

            public final void c() {
                this.b = new d[this.a];
                this.c = 0;
            }

            public final void c(int i) {
                if (i >= 0 && i < this.c) {
                    d[] dVarArr = this.b;
                    d[] dVarArr2 = this.b;
                    int i2 = this.c - 1;
                    this.c = i2;
                    dVarArr[i] = dVarArr2[i2];
                    this.b[this.c] = null;
                    d(i);
                }
            }

            public final void d() {
                int i = 0;
                while (i < this.c) {
                    if (this.b[i].b) {
                        this.d++;
                        c(i);
                        i--;
                    }
                    i++;
                }
            }
        }

        c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        private void a(d dVar) {
            this.f.a(dVar);
            notify();
        }

        public final synchronized void a() {
            this.d = true;
            this.f.c();
            notify();
        }

        public final boolean b() {
            return this.b && SystemClock.uptimeMillis() - this.a > 600000;
        }

        public final void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r10 = this;
        L_0x0000:
            monitor-enter(r10);
            r0 = r10.d;	 Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0007;	 Catch:{ all -> 0x00b7 }
        L_0x0005:
            monitor-exit(r10);	 Catch:{ all -> 0x00b7 }
            return;	 Catch:{ all -> 0x00b7 }
        L_0x0007:
            r0 = r10.f;	 Catch:{ all -> 0x00b7 }
            r0 = r0.b();	 Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x001a;	 Catch:{ all -> 0x00b7 }
        L_0x000f:
            r0 = r10.e;	 Catch:{ all -> 0x00b7 }
            if (r0 == 0) goto L_0x0015;	 Catch:{ all -> 0x00b7 }
        L_0x0013:
            monitor-exit(r10);	 Catch:{ all -> 0x00b7 }
            return;
        L_0x0015:
            r10.wait();	 Catch:{ InterruptedException -> 0x0018 }
        L_0x0018:
            monitor-exit(r10);	 Catch:{ all -> 0x00b7 }
            goto L_0x0000;	 Catch:{ all -> 0x00b7 }
        L_0x001a:
            r0 = com.xiaomi.push.service.l.a();	 Catch:{ all -> 0x00b7 }
            r2 = r10.f;	 Catch:{ all -> 0x00b7 }
            r2 = r2.a();	 Catch:{ all -> 0x00b7 }
            r3 = r2.a;	 Catch:{ all -> 0x00b7 }
            monitor-enter(r3);	 Catch:{ all -> 0x00b7 }
            r4 = r2.b;	 Catch:{ all -> 0x00b4 }
            r5 = 0;	 Catch:{ all -> 0x00b4 }
            if (r4 == 0) goto L_0x0033;	 Catch:{ all -> 0x00b4 }
        L_0x002c:
            r0 = r10.f;	 Catch:{ all -> 0x00b4 }
            r0.c(r5);	 Catch:{ all -> 0x00b4 }
            monitor-exit(r3);	 Catch:{ all -> 0x00b4 }
            goto L_0x0018;	 Catch:{ all -> 0x00b4 }
        L_0x0033:
            r6 = r2.c;	 Catch:{ all -> 0x00b4 }
            r8 = r6 - r0;	 Catch:{ all -> 0x00b4 }
            monitor-exit(r3);	 Catch:{ all -> 0x00b4 }
            r0 = 0;
            r3 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));
            r6 = 50;
            if (r3 <= 0) goto L_0x005c;
        L_0x0040:
            r0 = r10.c;	 Catch:{ all -> 0x00b7 }
            r2 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1));	 Catch:{ all -> 0x00b7 }
            if (r2 <= 0) goto L_0x0048;	 Catch:{ all -> 0x00b7 }
        L_0x0046:
            r8 = r10.c;	 Catch:{ all -> 0x00b7 }
        L_0x0048:
            r0 = r10.c;	 Catch:{ all -> 0x00b7 }
            r2 = r0 + r6;	 Catch:{ all -> 0x00b7 }
            r10.c = r2;	 Catch:{ all -> 0x00b7 }
            r0 = r10.c;	 Catch:{ all -> 0x00b7 }
            r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ all -> 0x00b7 }
            r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));	 Catch:{ all -> 0x00b7 }
            if (r4 <= 0) goto L_0x0058;	 Catch:{ all -> 0x00b7 }
        L_0x0056:
            r10.c = r2;	 Catch:{ all -> 0x00b7 }
        L_0x0058:
            r10.wait(r8);	 Catch:{ InterruptedException -> 0x0018 }
            goto L_0x0018;
        L_0x005c:
            r10.c = r6;	 Catch:{ all -> 0x00b7 }
            r3 = r2.a;	 Catch:{ all -> 0x00b7 }
            monitor-enter(r3);	 Catch:{ all -> 0x00b7 }
            r4 = r10.f;	 Catch:{ all -> 0x00b1 }
            r4 = r4.a();	 Catch:{ all -> 0x00b1 }
            r6 = r4.c;	 Catch:{ all -> 0x00b1 }
            r8 = r2.c;	 Catch:{ all -> 0x00b1 }
            r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));	 Catch:{ all -> 0x00b1 }
            if (r4 == 0) goto L_0x0076;	 Catch:{ all -> 0x00b1 }
        L_0x006f:
            r4 = r10.f;	 Catch:{ all -> 0x00b1 }
            r4 = r4.b(r2);	 Catch:{ all -> 0x00b1 }
            goto L_0x0077;	 Catch:{ all -> 0x00b1 }
        L_0x0076:
            r4 = r5;	 Catch:{ all -> 0x00b1 }
        L_0x0077:
            r6 = r2.b;	 Catch:{ all -> 0x00b1 }
            if (r6 == 0) goto L_0x0088;	 Catch:{ all -> 0x00b1 }
        L_0x007b:
            r0 = r10.f;	 Catch:{ all -> 0x00b1 }
            r1 = r10.f;	 Catch:{ all -> 0x00b1 }
            r1 = r1.b(r2);	 Catch:{ all -> 0x00b1 }
            r0.c(r1);	 Catch:{ all -> 0x00b1 }
            monitor-exit(r3);	 Catch:{ all -> 0x00b1 }
            goto L_0x0018;	 Catch:{ all -> 0x00b1 }
        L_0x0088:
            r6 = r2.c;	 Catch:{ all -> 0x00b1 }
            r2.a(r6);	 Catch:{ all -> 0x00b1 }
            r6 = r10.f;	 Catch:{ all -> 0x00b1 }
            r6.c(r4);	 Catch:{ all -> 0x00b1 }
            r2.c = r0;	 Catch:{ all -> 0x00b1 }
            monitor-exit(r3);	 Catch:{ all -> 0x00b1 }
            monitor-exit(r10);	 Catch:{ all -> 0x00b7 }
            r0 = 1;
            r3 = android.os.SystemClock.uptimeMillis();	 Catch:{ all -> 0x00a8 }
            r10.a = r3;	 Catch:{ all -> 0x00a8 }
            r10.b = r0;	 Catch:{ all -> 0x00a8 }
            r1 = r2.d;	 Catch:{ all -> 0x00a8 }
            r1.run();	 Catch:{ all -> 0x00a8 }
            r10.b = r5;	 Catch:{ all -> 0x00a8 }
            goto L_0x0000;
        L_0x00a8:
            r1 = move-exception;
            monitor-enter(r10);
            r10.d = r0;	 Catch:{ all -> 0x00ae }
            monitor-exit(r10);	 Catch:{ all -> 0x00ae }
            throw r1;
        L_0x00ae:
            r0 = move-exception;
            monitor-exit(r10);	 Catch:{ all -> 0x00ae }
            throw r0;
        L_0x00b1:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x00b1 }
            throw r0;	 Catch:{ all -> 0x00b7 }
        L_0x00b4:
            r0 = move-exception;
            monitor-exit(r3);	 Catch:{ all -> 0x00b4 }
            throw r0;	 Catch:{ all -> 0x00b7 }
        L_0x00b7:
            r0 = move-exception;	 Catch:{ all -> 0x00b7 }
            monitor-exit(r10);	 Catch:{ all -> 0x00b7 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.l.c.run():void");
        }
    }

    static class d {
        final Object a = new Object();
        boolean b;
        long c;
        b d;
        int e;
        private long f;

        d() {
        }

        void a(long j) {
            synchronized (this.a) {
                this.f = j;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.a) {
                z = !this.b && this.c > 0;
                this.b = true;
            }
            return z;
        }
    }

    static {
        long j = 0;
        if (SystemClock.elapsedRealtime() > 0) {
            j = SystemClock.elapsedRealtime();
        }
        a = j;
        b = j;
    }

    public l() {
        this(false);
    }

    public l(String str) {
        this(str, false);
    }

    public l(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        this.d = new c(str, z);
        this.e = new a(this.d);
    }

    public l(boolean z) {
        StringBuilder stringBuilder = new StringBuilder("Timer-");
        stringBuilder.append(e());
        this(stringBuilder.toString(), z);
    }

    static synchronized long a() {
        long elapsedRealtime;
        synchronized (l.class) {
            elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime > b) {
                a += elapsedRealtime - b;
            }
            b = elapsedRealtime;
            elapsedRealtime = a;
        }
        return elapsedRealtime;
    }

    private void b(b bVar, long j) {
        synchronized (this.d) {
            if (this.d.d) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a = j + a();
            if (a < 0) {
                StringBuilder stringBuilder = new StringBuilder("Illegal delay to start the TimerTask: ");
                stringBuilder.append(a);
                throw new IllegalArgumentException(stringBuilder.toString());
            }
            d dVar = new d();
            dVar.e = bVar.a;
            dVar.d = bVar;
            dVar.c = a;
            this.d.a(dVar);
        }
    }

    private static synchronized long e() {
        long j;
        synchronized (l.class) {
            j = c;
            c = j + 1;
        }
        return j;
    }

    public void a(int i, b bVar) {
        synchronized (this.d) {
            this.d.f.a(i, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() > 0 || Thread.currentThread() == this.d) {
            bVar.run();
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(b bVar, long j) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("delay < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        b(bVar, j);
    }

    public boolean a(int i) {
        boolean a;
        synchronized (this.d) {
            a = this.d.f.a(i);
        }
        return a;
    }

    public void b() {
        this.d.a();
    }

    public void b(int i) {
        synchronized (this.d) {
            this.d.f.b(i);
        }
    }

    public void c() {
        synchronized (this.d) {
            this.d.f.c();
        }
    }

    public boolean d() {
        return this.d.b();
    }
}
