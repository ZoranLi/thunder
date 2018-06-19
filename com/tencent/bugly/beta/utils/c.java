package com.tencent.bugly.beta.utils;

import com.tencent.bugly.proguard.an;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

/* compiled from: BUGLY */
public class c {
    private static HashMap<Long, String> u = new HashMap();
    private a a = null;
    private String b = null;
    private long c = 0;
    private long d = 0;
    private HashMap<String, b> e = null;
    private byte[] f = new byte[16];
    private long g = 0;
    private long h = 0;
    private String i = null;
    private long j = 0;
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private long n = 0;
    private long o = 0;
    private long p = 0;
    private long q = 0;
    private long r = 0;
    private long s = 0;
    private long t = 0;

    /* compiled from: BUGLY */
    public static class a {
        private long a = -1;
        private long b = 0;
        private long c = 0;
        private long d = -1;
        private long e = -1;
        private long f = 0;
        private long g = 0;
        private long h = 0;
        private long i = 0;
        private long j = 0;

        public long a() {
            return this.a;
        }

        public long b() {
            return this.d;
        }

        public long c() {
            return this.e;
        }

        public long d() {
            return this.f;
        }

        public long e() {
            return this.j;
        }

        public synchronized void a(long j) {
            this.a = j;
        }

        public synchronized void b(long j) {
            this.b = j;
        }

        public synchronized void c(long j) {
            this.c = j;
        }

        public synchronized void d(long j) {
            this.e = j;
        }

        public synchronized void e(long j) {
            this.d = j;
        }

        public synchronized void f(long j) {
            this.f = j;
        }

        public synchronized void g(long j) {
            this.g = j;
        }

        public synchronized void h(long j) {
            this.h = j;
        }

        public synchronized void i(long j) {
            this.i = j;
        }

        public synchronized void j(long j) {
            this.j = j;
        }
    }

    /* compiled from: BUGLY */
    public static class b {
        private String a = null;
        private long b = -1;
        private long c = -1;
        private long d = 0;
        private long e = 0;

        public long a() {
            return this.c;
        }

        public synchronized void a(String str) {
            this.a = str;
        }

        public synchronized void a(long j) {
            this.b = j;
        }

        public synchronized void b(long j) {
            this.c = j;
        }

        public synchronized void c(long j) {
            this.d = j;
        }

        public synchronized void d(long j) {
            this.e = j;
        }
    }

    private long a(byte b) {
        return (byte) 1 == b ? 32 : (byte) 2 == b ? 64 : 0;
    }

    public c(String str) {
        this.b = str;
        u.put(Long.valueOf(3), "x86");
        u.put(Long.valueOf(7), "x86");
        u.put(Long.valueOf(8), "mips");
        u.put(Long.valueOf(10), "mips");
        u.put(Long.valueOf(40), "armeabi");
        u.put(Long.valueOf(62), "x86_64");
        u.put(Long.valueOf(183), "arm64-v8a");
    }

    private String b() {
        return this.i;
    }

    private long c() {
        return this.m;
    }

    private long d() {
        return this.s;
    }

    private long e() {
        return this.t;
    }

    public synchronized String a() {
        if (!f()) {
            return null;
        }
        String b = b();
        if (!b.equals("armeabi")) {
            return b;
        }
        if (!i()) {
            return b;
        }
        b bVar = (b) this.e.get(".ARM.attributes");
        if (bVar == null) {
            return b;
        }
        return b.a(this.b, this.d, bVar.a());
    }

    private static String a(long j, long j2) {
        String str = (String) u.get(Long.valueOf(j));
        return (64 == j2 && str.equals("mips")) ? "mips64" : str;
    }

    private boolean f() {
        if (!l()) {
            return false;
        }
        if (g()) {
            j();
            return true;
        }
        j();
        return false;
    }

    private synchronized boolean g() {
        if (!h()) {
            return false;
        }
        try {
            this.g = this.a.g();
            this.h = this.a.g();
            this.i = a(this.h, this.c);
            this.j = this.a.h();
            long h;
            if (32 == this.c) {
                h = this.a.h();
                this.j = h;
                this.k = h;
                this.l = this.a.h();
                this.m = this.a.h();
            } else if (64 != this.c) {
                return false;
            } else {
                h = this.a.i();
                this.j = h;
                this.k = h;
                this.l = this.a.i();
                this.m = this.a.i();
            }
            this.n = this.a.h();
            this.o = this.a.g();
            this.p = this.a.g();
            this.q = this.a.g();
            this.r = this.a.g();
            this.s = this.a.g();
            this.t = this.a.g();
            return true;
        } catch (IOException e) {
            e.getMessage();
            return false;
        }
    }

    private synchronized boolean h() {
        if (!this.a.a(this.f)) {
            return false;
        }
        if (a(this.f)) {
            this.c = a(this.f[4]);
            if (0 == this.c) {
                new StringBuilder("File format error: ").append(this.f[4]);
                return false;
            }
            this.d = b(this.f[5]);
            if (a.a == this.d) {
                new StringBuilder("Endian error: ").append(this.f[5]);
                return false;
            }
            this.a.a(this.d);
            return true;
        }
        new StringBuilder("Not a elf file: ").append(this.b);
        return false;
    }

    private static boolean a(byte[] bArr) {
        if (bArr.length >= 3 && Byte.MAX_VALUE == bArr[0] && (byte) 69 == bArr[1] && (byte) 76 == bArr[2] && 70 == bArr[3]) {
            return true;
        }
        return false;
    }

    private long b(byte b) {
        if ((byte) 1 == b) {
            return a.c;
        }
        if ((byte) 2 == b) {
            return a.b;
        }
        return a.a;
    }

    private synchronized boolean i() {
        this.e = a(c(), d(), e());
        if (this.e == null) {
            return false;
        }
        return true;
    }

    private synchronized void j() {
        if (this.a != null) {
            if (this.a.a()) {
                this.a = null;
            }
        }
    }

    private synchronized boolean k() {
        if (this.a != null) {
            j();
        }
        try {
            this.a = new a(this.b, this.d);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
        return true;
    }

    private synchronized boolean l() {
        if (this.a != null) {
            j();
        }
        try {
            this.a = new a(this.b);
        } catch (Exception e) {
            e.getMessage();
            return false;
        }
        return true;
    }

    private synchronized HashMap<String, b> a(long j, long j2, long j3) {
        if (!k()) {
            j();
            return null;
        } else if (this.a.b(j) == null) {
            j();
            return null;
        } else {
            j = b(j2, j3);
            j();
            return j;
        }
    }

    private synchronized HashMap<String, b> b(long j, long j2) {
        if (j > 0) {
            if (j2 > 0) {
                Vector vector = new Vector();
                for (int i = 0; ((long) i) < j; i++) {
                    vector.add(m());
                }
                a aVar = (a) vector.get((int) j2);
                an.c("File length = %d", Long.valueOf(new File(this.b).length()));
                if (aVar.c() >= new File(this.b).length()) {
                    an.d("The SO file is invalid or has a shell.", new Object[0]);
                    return null;
                }
                d dVar = new d(this.b, aVar.c(), aVar.d());
                j = new HashMap();
                j2 = vector.iterator();
                while (j2.hasNext()) {
                    a aVar2 = (a) j2.next();
                    String a = dVar.a(aVar2.a());
                    b bVar = new b();
                    bVar.a(a);
                    bVar.a(aVar2.b());
                    bVar.b(aVar2.c());
                    bVar.c(aVar2.d());
                    bVar.d(aVar2.e());
                    j.put(a, bVar);
                }
                dVar.a();
                return j;
            }
        }
        an.d("The SO file is invalid or has a shell.", new Object[0]);
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized com.tencent.bugly.beta.utils.c.a m() {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = new com.tencent.bugly.beta.utils.c$a;	 Catch:{ all -> 0x00c1 }
        r0.<init>();	 Catch:{ all -> 0x00c1 }
        r1 = 0;
        r2 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r2 = r2.h();	 Catch:{ IOException -> 0x00bb }
        r0.a(r2);	 Catch:{ IOException -> 0x00bb }
        r2 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r2 = r2.h();	 Catch:{ IOException -> 0x00bb }
        r0.b(r2);	 Catch:{ IOException -> 0x00bb }
        r2 = r9.c;	 Catch:{ IOException -> 0x00bb }
        r4 = 32;
        r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        r2 = 64;
        if (r6 != 0) goto L_0x0048;
    L_0x0023:
        r6 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r6 = r6.h();	 Catch:{ IOException -> 0x00bb }
        r0.c(r6);	 Catch:{ IOException -> 0x00bb }
        r6 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r6 = r6.h();	 Catch:{ IOException -> 0x00bb }
        r0.e(r6);	 Catch:{ IOException -> 0x00bb }
        r6 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r6 = r6.h();	 Catch:{ IOException -> 0x00bb }
        r0.d(r6);	 Catch:{ IOException -> 0x00bb }
        r6 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r6 = r6.h();	 Catch:{ IOException -> 0x00bb }
        r0.f(r6);	 Catch:{ IOException -> 0x00bb }
        goto L_0x0072;
    L_0x0048:
        r6 = r9.c;	 Catch:{ IOException -> 0x00bb }
        r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1));
        if (r8 != 0) goto L_0x00b9;
    L_0x004e:
        r6 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r6 = r6.i();	 Catch:{ IOException -> 0x00bb }
        r0.c(r6);	 Catch:{ IOException -> 0x00bb }
        r6 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r6 = r6.i();	 Catch:{ IOException -> 0x00bb }
        r0.e(r6);	 Catch:{ IOException -> 0x00bb }
        r6 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r6 = r6.i();	 Catch:{ IOException -> 0x00bb }
        r0.d(r6);	 Catch:{ IOException -> 0x00bb }
        r6 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r6 = r6.i();	 Catch:{ IOException -> 0x00bb }
        r0.f(r6);	 Catch:{ IOException -> 0x00bb }
    L_0x0072:
        r6 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r6 = r6.h();	 Catch:{ IOException -> 0x00bb }
        r0.g(r6);	 Catch:{ IOException -> 0x00bb }
        r6 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r6 = r6.h();	 Catch:{ IOException -> 0x00bb }
        r0.h(r6);	 Catch:{ IOException -> 0x00bb }
        r6 = r9.c;	 Catch:{ IOException -> 0x00bb }
        r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r8 != 0) goto L_0x009d;
    L_0x008a:
        r2 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r2 = r2.h();	 Catch:{ IOException -> 0x00bb }
        r0.i(r2);	 Catch:{ IOException -> 0x00bb }
        r2 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r2 = r2.h();	 Catch:{ IOException -> 0x00bb }
        r0.j(r2);	 Catch:{ IOException -> 0x00bb }
        goto L_0x00b5;
    L_0x009d:
        r4 = r9.c;	 Catch:{ IOException -> 0x00bb }
        r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r6 != 0) goto L_0x00b7;
    L_0x00a3:
        r2 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r2 = r2.i();	 Catch:{ IOException -> 0x00bb }
        r0.i(r2);	 Catch:{ IOException -> 0x00bb }
        r2 = r9.a;	 Catch:{ IOException -> 0x00bb }
        r2 = r2.i();	 Catch:{ IOException -> 0x00bb }
        r0.j(r2);	 Catch:{ IOException -> 0x00bb }
    L_0x00b5:
        monitor-exit(r9);
        return r0;
    L_0x00b7:
        monitor-exit(r9);
        return r1;
    L_0x00b9:
        monitor-exit(r9);
        return r1;
    L_0x00bb:
        r0 = move-exception;
        r0.getMessage();	 Catch:{ all -> 0x00c1 }
        monitor-exit(r9);
        return r1;
    L_0x00c1:
        r0 = move-exception;
        monitor-exit(r9);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.c.m():com.tencent.bugly.beta.utils.c$a");
    }
}
