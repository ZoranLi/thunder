package com.tencent.bugly.beta.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: BUGLY */
public class a {
    public static long a = -1;
    public static long b = 0;
    public static long c = 1;
    private byte[] d;
    private byte[] e;
    private byte[] f;
    private long g;
    private String h;
    private BufferedInputStream i;
    private long j;
    private long k;

    public synchronized void a(long j) {
        this.g = j;
    }

    public a(String str) throws Exception {
        this.d = new byte[2];
        this.e = new byte[4];
        this.f = new byte[8];
        this.g = c;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.h = str;
        this.i = new BufferedInputStream(new FileInputStream(this.h));
        this.j = 0;
        this.k = 0;
    }

    public a(String str, long j) throws Exception {
        this.d = new byte[2];
        this.e = new byte[4];
        this.f = new byte[8];
        this.g = c;
        this.h = null;
        this.i = null;
        this.j = 0;
        this.k = 0;
        this.h = str;
        this.g = j;
        this.i = new BufferedInputStream(new FileInputStream(this.h));
        this.j = 0;
        this.k = 0;
    }

    public synchronized boolean a() {
        try {
            if (this.i != null) {
                this.i.close();
            }
            this.i = null;
            this.h = null;
            this.j = 0;
            this.k = 0;
        } catch (IOException e) {
            e.getMessage();
            return false;
        }
        return true;
    }

    public synchronized boolean b(long r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        monitor-enter(r11);
        r0 = r11.i;	 Catch:{ all -> 0x002a }
        r1 = 0;
        if (r0 != 0) goto L_0x0008;
    L_0x0006:
        monitor-exit(r11);
        return r1;
    L_0x0008:
        r2 = 0;
        r0 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1));
        r4 = 1;
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r11);
        return r4;
    L_0x0011:
        r5 = r12;
    L_0x0012:
        r0 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r0 <= 0) goto L_0x0022;
    L_0x0016:
        r0 = r11.i;	 Catch:{ IOException -> 0x0020 }
        r7 = r0.skip(r5);	 Catch:{ IOException -> 0x0020 }
        r9 = r5 - r7;
        r5 = r9;
        goto L_0x0012;
    L_0x0020:
        monitor-exit(r11);
        return r1;
    L_0x0022:
        r0 = r11.j;	 Catch:{ all -> 0x002a }
        r2 = r0 + r12;	 Catch:{ all -> 0x002a }
        r11.j = r2;	 Catch:{ all -> 0x002a }
        monitor-exit(r11);
        return r4;
    L_0x002a:
        r12 = move-exception;
        monitor-exit(r11);
        throw r12;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.utils.a.b(long):boolean");
    }

    public synchronized boolean a(byte[] bArr) {
        try {
            this.i.read(bArr);
            this.j += (long) bArr.length;
            this.k += (long) bArr.length;
        } catch (byte[] bArr2) {
            bArr2.getMessage();
            return null;
        }
        return 1;
    }

    public synchronized byte b() throws IOException {
        if (this.i == null) {
            return (byte) 0;
        }
        byte read = (byte) this.i.read();
        this.j++;
        this.k++;
        return read;
    }

    public synchronized short c() throws IOException {
        if (this.i == null) {
            return (short) 0;
        }
        this.i.read(this.d);
        short a = a(this.d, this.g);
        this.j += 2;
        this.k += 2;
        return a;
    }

    public synchronized int d() throws IOException {
        if (this.i == null) {
            return 0;
        }
        this.i.read(this.e);
        int b = b(this.e, this.g);
        this.j += 4;
        this.k += 4;
        return b;
    }

    public synchronized long e() throws IOException {
        if (this.i == null) {
            return 0;
        }
        this.i.read(this.f);
        long c = c(this.f, this.g);
        this.j += 8;
        this.k += 8;
        return c;
    }

    public synchronized long f() throws IOException {
        return ((long) b()) & 255;
    }

    public synchronized long g() throws IOException {
        return ((long) c()) & 65535;
    }

    public synchronized long h() throws IOException {
        return ((long) d()) & 4294967295L;
    }

    public synchronized long i() throws IOException {
        return e();
    }

    private static short b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= 2) {
                return (short) c(bArr);
            }
        }
        return -1;
    }

    private static int c(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= 4) {
                return (int) d(bArr);
            }
        }
        return -1;
    }

    private static long d(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= 8) {
                long j = 0;
                int length = bArr.length - 1;
                while (length >= 0) {
                    length--;
                    j = (j << 8) | (((long) bArr[length]) & 255);
                }
                return j;
            }
        }
        return -1;
    }

    private static short e(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= 2) {
                return (short) f(bArr);
            }
        }
        return -1;
    }

    private static int f(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= 4) {
                return (int) g(bArr);
            }
        }
        return -1;
    }

    private static long g(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= 8) {
                long j = 0;
                int i = 0;
                while (i < bArr.length) {
                    i++;
                    j = (j << 8) | (((long) bArr[i]) & 255);
                }
                return j;
            }
        }
        return -1;
    }

    public static short a(byte[] bArr, long j) {
        if (j == c) {
            return b(bArr);
        }
        return e(bArr);
    }

    public static int b(byte[] bArr, long j) {
        if (j == c) {
            return c(bArr);
        }
        return f(bArr);
    }

    public static long c(byte[] bArr, long j) {
        if (j == c) {
            return d(bArr);
        }
        return g(bArr);
    }
}
