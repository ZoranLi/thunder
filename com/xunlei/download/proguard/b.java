package com.xunlei.download.proguard;

/* compiled from: LongSparseLongArray */
public class b implements Cloneable {
    private long[] a;
    private long[] b;
    private int c;

    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        return a();
    }

    public b() {
        this(10);
    }

    public b(int i) {
        if (i == 0) {
            this.a = a.c;
            this.b = a.c;
        } else {
            i = e(i);
            this.a = new long[i];
            this.b = new long[i];
        }
        this.c = 0;
    }

    public com.xunlei.download.proguard.b a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = super.clone();	 Catch:{ CloneNotSupportedException -> 0x001b }
        r0 = (com.xunlei.download.proguard.b) r0;	 Catch:{ CloneNotSupportedException -> 0x001b }
        r1 = r2.a;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r1.clone();	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = (long[]) r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r0.a = r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r2.b;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = r1.clone();	 Catch:{ CloneNotSupportedException -> 0x001c }
        r1 = (long[]) r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        r0.b = r1;	 Catch:{ CloneNotSupportedException -> 0x001c }
        goto L_0x001c;
    L_0x001b:
        r0 = 0;
    L_0x001c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.b.a():com.xunlei.download.proguard.b");
    }

    public long a(long j) {
        return a(j, 0);
    }

    public long a(long j, long j2) {
        j = a.a(this.a, this.c, j);
        if (j < null) {
            return j2;
        }
        return this.b[j];
    }

    public void b(long j) {
        int a = a.a(this.a, this.c, j);
        if (a >= 0) {
            a(a);
        }
    }

    public void a(int i) {
        int i2 = i + 1;
        System.arraycopy(this.a, i2, this.a, i, this.c - i2);
        System.arraycopy(this.b, i2, this.b, i, this.c - i2);
        this.c--;
    }

    public void b(long j, long j2) {
        int a = a.a(this.a, this.c, j);
        if (a >= 0) {
            this.b[a] = j2;
            return;
        }
        a ^= -1;
        if (this.c >= this.a.length) {
            d(this.c + 1);
        }
        if (this.c - a != 0) {
            int i = a + 1;
            System.arraycopy(this.a, a, this.a, i, this.c - a);
            System.arraycopy(this.b, a, this.b, i, this.c - a);
        }
        this.a[a] = j;
        this.b[a] = j2;
        this.c++;
    }

    public int b() {
        return this.c;
    }

    public long b(int i) {
        return this.a[i];
    }

    public long c(int i) {
        return this.b[i];
    }

    public int c(long j) {
        return a.a(this.a, this.c, j);
    }

    public int d(long j) {
        for (int i = 0; i < this.c; i++) {
            if (this.b[i] == j) {
                return i;
            }
        }
        return -1;
    }

    public void c() {
        this.c = 0;
    }

    public void c(long j, long j2) {
        if (this.c == 0 || j > this.a[this.c - 1]) {
            int i = this.c;
            if (i >= this.a.length) {
                d(i + 1);
            }
            this.a[i] = j;
            this.b[i] = j2;
            this.c = i + 1;
            return;
        }
        b(j, j2);
    }

    private void d(int i) {
        i = e(i);
        Object obj = new long[i];
        i = new long[i];
        System.arraycopy(this.a, 0, obj, 0, this.a.length);
        System.arraycopy(this.b, 0, i, 0, this.b.length);
        this.a = obj;
        this.b = i;
    }

    private int e(int i) {
        i *= 8;
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                i = i3;
                break;
            }
        }
        return i / 8;
    }

    public String toString() {
        if (b() <= 0) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.c * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.c; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            stringBuilder.append(b(i));
            stringBuilder.append('=');
            stringBuilder.append(c(i));
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
