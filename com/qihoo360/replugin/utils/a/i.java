package com.qihoo360.replugin.utils.a;

/* compiled from: SimpleArrayMap */
public class i<K, V> {
    static Object[] b;
    static int c;
    static Object[] d;
    static int e;
    int[] f = f.a;
    Object[] g = f.c;
    int h = 0;

    private int a(Object obj, int i) {
        int i2 = this.h;
        if (i2 == 0) {
            return -1;
        }
        int a = f.a(this.f, i2, i);
        if (a < 0 || obj.equals(this.g[a << 1])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.f[i3] == i) {
            if (obj.equals(this.g[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.f[a] == i) {
            if (obj.equals(this.g[a << 1])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    private int a() {
        int i = this.h;
        if (i == 0) {
            return -1;
        }
        int a = f.a(this.f, i, 0);
        if (a < 0 || this.g[a << 1] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.f[i2] == 0) {
            if (this.g[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.f[a] == 0) {
            if (this.g[a << 1] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    final void a(int i) {
        if (i == 8) {
            synchronized (a.class) {
                if (d != null) {
                    i = d;
                    this.g = i;
                    d = (Object[]) i[0];
                    this.f = (int[]) i[1];
                    i[1] = null;
                    i[0] = null;
                    e--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (a.class) {
                if (b != null) {
                    i = b;
                    this.g = i;
                    b = (Object[]) i[0];
                    this.f = (int[]) i[1];
                    i[1] = null;
                    i[0] = null;
                    c--;
                    return;
                }
            }
        }
        this.f = new int[i];
        this.g = new Object[(i << 1)];
    }

    static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (a.class) {
                if (e < 10) {
                    objArr[0] = d;
                    objArr[1] = iArr;
                    for (iArr = (i << 1) - 1; iArr >= 2; iArr--) {
                        objArr[iArr] = null;
                    }
                    d = objArr;
                    e += 1;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (a.class) {
                if (c < 10) {
                    objArr[0] = b;
                    objArr[1] = iArr;
                    for (iArr = (i << 1) - 1; iArr >= 2; iArr--) {
                        objArr[iArr] = null;
                    }
                    b = objArr;
                    c += 1;
                }
            }
        }
    }

    public void clear() {
        if (this.h != 0) {
            a(this.f, this.g, this.h);
            this.f = f.a;
            this.g = f.c;
            this.h = 0;
        }
    }

    public boolean containsKey(Object obj) {
        return a(obj) >= null ? true : null;
    }

    public final int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    final int b(Object obj) {
        int i = this.h * 2;
        Object[] objArr = this.g;
        if (obj == null) {
            for (obj = 1; obj < i; obj += 2) {
                if (objArr[obj] == null) {
                    return obj >> 1;
                }
            }
        } else {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (obj.equals(objArr[i2])) {
                    return i2 >> 1;
                }
            }
        }
        return -1;
    }

    public boolean containsValue(Object obj) {
        return b(obj) >= null ? true : null;
    }

    public V get(Object obj) {
        obj = a(obj);
        return obj >= null ? this.g[(obj << 1) + 1] : null;
    }

    private K d(int i) {
        return this.g[i << 1];
    }

    public final V b(int i) {
        return this.g[(i << 1) + 1];
    }

    public boolean isEmpty() {
        return this.h <= 0;
    }

    public V put(K k, V v) {
        int a;
        int i;
        if (k == null) {
            a = a();
            i = 0;
        } else {
            a = k.hashCode();
            i = a;
            a = a(k, a);
        }
        if (a >= 0) {
            k = (a << 1) + 1;
            V v2 = this.g[k];
            this.g[k] = v;
            return v2;
        }
        int i2;
        a ^= -1;
        if (this.h >= this.f.length) {
            i2 = 4;
            if (this.h >= 8) {
                i2 = (this.h >> 1) + this.h;
            } else if (this.h >= 4) {
                i2 = 8;
            }
            Object obj = this.f;
            Object obj2 = this.g;
            a(i2);
            if (this.f.length > 0) {
                System.arraycopy(obj, 0, this.f, 0, obj.length);
                System.arraycopy(obj2, 0, this.g, 0, obj2.length);
            }
            a(obj, obj2, this.h);
        }
        if (a < this.h) {
            i2 = a + 1;
            System.arraycopy(this.f, a, this.f, i2, this.h - a);
            System.arraycopy(this.g, a << 1, this.g, i2 << 1, (this.h - a) << 1);
        }
        this.f[a] = i;
        a <<= 1;
        this.g[a] = k;
        this.g[a + 1] = v;
        this.h++;
        return null;
    }

    public V remove(Object obj) {
        obj = a(obj);
        return obj >= null ? c(obj) : null;
    }

    public final V c(int i) {
        int i2 = i << 1;
        V v = this.g[i2 + 1];
        if (this.h <= 1) {
            a(this.f, this.g, this.h);
            this.f = f.a;
            this.g = f.c;
            this.h = 0;
        } else {
            int i3 = 8;
            int i4;
            if (this.f.length <= 8 || this.h >= this.f.length / 3) {
                this.h--;
                if (i < this.h) {
                    i4 = i + 1;
                    System.arraycopy(this.f, i4, this.f, i, this.h - i);
                    System.arraycopy(this.g, i4 << 1, this.g, i2, (this.h - i) << 1);
                }
                this.g[this.h << 1] = null;
                this.g[(this.h << 1) + 1] = null;
            } else {
                if (this.h > 8) {
                    i3 = (this.h >> 1) + this.h;
                }
                Object obj = this.f;
                Object obj2 = this.g;
                a(i3);
                this.h--;
                if (i > 0) {
                    System.arraycopy(obj, 0, this.f, 0, i);
                    System.arraycopy(obj2, 0, this.g, 0, i2);
                }
                if (i < this.h) {
                    i4 = i + 1;
                    System.arraycopy(obj, i4, this.f, i, this.h - i);
                    System.arraycopy(obj2, i4 << 1, this.g, i2, (this.h - i) << 1);
                }
            }
        }
        return v;
    }

    public int size() {
        return this.h;
    }

    public boolean equals(java.lang.Object r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 1;
        if (r6 != r7) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r7 instanceof java.util.Map;
        r2 = 0;
        if (r1 == 0) goto L_0x003f;
    L_0x0009:
        r7 = (java.util.Map) r7;
        r1 = r6.size();
        r3 = r7.size();
        if (r1 == r3) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r1 = r2;
    L_0x0017:
        r3 = r6.h;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        if (r1 >= r3) goto L_0x003c;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x001b:
        r3 = r6.d(r1);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        r4 = r6.b(r1);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        r5 = r7.get(r3);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        if (r4 != 0) goto L_0x0032;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x0029:
        if (r5 != 0) goto L_0x0031;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x002b:
        r3 = r7.containsKey(r3);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        if (r3 != 0) goto L_0x0039;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x0031:
        return r2;	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
    L_0x0032:
        r3 = r4.equals(r5);	 Catch:{ NullPointerException -> 0x003e, ClassCastException -> 0x003d }
        if (r3 != 0) goto L_0x0039;
    L_0x0038:
        return r2;
    L_0x0039:
        r1 = r1 + 1;
        goto L_0x0017;
    L_0x003c:
        return r0;
    L_0x003d:
        return r2;
    L_0x003e:
        return r2;
    L_0x003f:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.utils.a.i.equals(java.lang.Object):boolean");
    }

    public int hashCode() {
        int[] iArr = this.f;
        Object[] objArr = this.g;
        int i = this.h;
        int i2 = 1;
        int i3 = 0;
        int i4 = i3;
        while (i3 < i) {
            Object obj = objArr[i2];
            i4 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return i4;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.h * 28);
        stringBuilder.append('{');
        for (int i = 0; i < this.h; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            i d = d(i);
            if (d != this) {
                stringBuilder.append(d);
            } else {
                stringBuilder.append("(this Map)");
            }
            stringBuilder.append('=');
            d = b(i);
            if (d != this) {
                stringBuilder.append(d);
            } else {
                stringBuilder.append("(this Map)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
