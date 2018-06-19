package com.qihoo360.replugin.utils.a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ArraySet */
public final class c<E> implements Collection<E>, Set<E> {
    static Object[] a;
    static int b;
    static Object[] c;
    static int d;
    int[] e = f.a;
    public Object[] f = f.c;
    int g = 0;
    g<E, E> h;

    private int a(Object obj, int i) {
        int i2 = this.g;
        if (i2 == 0) {
            return -1;
        }
        int a = f.a(this.e, i2, i);
        if (a < 0 || obj.equals(this.f[a])) {
            return a;
        }
        int i3 = a + 1;
        while (i3 < i2 && this.e[i3] == i) {
            if (obj.equals(this.f[i3])) {
                return i3;
            }
            i3++;
        }
        a--;
        while (a >= 0 && this.e[a] == i) {
            if (obj.equals(this.f[a])) {
                return a;
            }
            a--;
        }
        return i3 ^ -1;
    }

    private int a() {
        int i = this.g;
        if (i == 0) {
            return -1;
        }
        int a = f.a(this.e, i, 0);
        if (a < 0 || this.f[a] == null) {
            return a;
        }
        int i2 = a + 1;
        while (i2 < i && this.e[i2] == 0) {
            if (this.f[i2] == null) {
                return i2;
            }
            i2++;
        }
        a--;
        while (a >= 0 && this.e[a] == 0) {
            if (this.f[a] == null) {
                return a;
            }
            a--;
        }
        return i2 ^ -1;
    }

    private void b(int i) {
        if (i == 8) {
            synchronized (c.class) {
                if (c != null) {
                    i = c;
                    this.f = i;
                    c = (Object[]) i[0];
                    this.e = (int[]) i[1];
                    i[1] = null;
                    i[0] = null;
                    d--;
                    return;
                }
            }
        } else if (i == 4) {
            synchronized (c.class) {
                if (a != null) {
                    i = a;
                    this.f = i;
                    a = (Object[]) i[0];
                    this.e = (int[]) i[1];
                    i[1] = null;
                    i[0] = null;
                    b--;
                    return;
                }
            }
        }
        this.e = new int[i];
        this.f = new Object[i];
    }

    private static void a(int[] iArr, Object[] objArr, int i) {
        if (iArr.length == 8) {
            synchronized (c.class) {
                if (d < 10) {
                    objArr[0] = c;
                    objArr[1] = iArr;
                    for (i--; i >= 2; i--) {
                        objArr[i] = null;
                    }
                    c = objArr;
                    d += 1;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (c.class) {
                if (b < 10) {
                    objArr[0] = a;
                    objArr[1] = iArr;
                    for (i--; i >= 2; i--) {
                        objArr[i] = null;
                    }
                    a = objArr;
                    b += 1;
                }
            }
        }
    }

    public final void clear() {
        if (this.g != 0) {
            a(this.e, this.f, this.g);
            this.e = f.a;
            this.f = f.c;
            this.g = 0;
        }
    }

    public final boolean contains(Object obj) {
        return a(obj) >= null ? true : null;
    }

    public final int a(Object obj) {
        return obj == null ? a() : a(obj, obj.hashCode());
    }

    public final boolean isEmpty() {
        return this.g <= 0;
    }

    public final boolean add(E e) {
        int a;
        boolean z;
        if (e == null) {
            a = a();
            z = false;
        } else {
            boolean hashCode = e.hashCode();
            z = hashCode;
            a = a(e, hashCode);
        }
        if (a >= 0) {
            return false;
        }
        int i;
        a ^= -1;
        if (this.g >= this.e.length) {
            i = 4;
            if (this.g >= 8) {
                i = (this.g >> 1) + this.g;
            } else if (this.g >= 4) {
                i = 8;
            }
            Object obj = this.e;
            Object obj2 = this.f;
            b(i);
            if (this.e.length > 0) {
                System.arraycopy(obj, 0, this.e, 0, obj.length);
                System.arraycopy(obj2, 0, this.f, 0, obj2.length);
            }
            a(obj, obj2, this.g);
        }
        if (a < this.g) {
            i = a + 1;
            System.arraycopy(this.e, a, this.e, i, this.g - a);
            System.arraycopy(this.f, a, this.f, i, this.g - a);
        }
        this.e[a] = z;
        this.f[a] = e;
        this.g += 1;
        return true;
    }

    public final boolean remove(Object obj) {
        int a = a(obj);
        if (a < null) {
            return null;
        }
        a(a);
        return true;
    }

    public final E a(int i) {
        E e = this.f[i];
        if (this.g <= 1) {
            a(this.e, this.f, this.g);
            this.e = f.a;
            this.f = f.c;
            this.g = 0;
        } else {
            int i2 = 8;
            int i3;
            if (this.e.length <= 8 || this.g >= this.e.length / 3) {
                this.g--;
                if (i < this.g) {
                    i3 = i + 1;
                    System.arraycopy(this.e, i3, this.e, i, this.g - i);
                    System.arraycopy(this.f, i3, this.f, i, this.g - i);
                }
                this.f[this.g] = null;
            } else {
                if (this.g > 8) {
                    i2 = (this.g >> 1) + this.g;
                }
                Object obj = this.e;
                Object obj2 = this.f;
                b(i2);
                this.g--;
                if (i > 0) {
                    System.arraycopy(obj, 0, this.e, 0, i);
                    System.arraycopy(obj2, 0, this.f, 0, i);
                }
                if (i < this.g) {
                    i3 = i + 1;
                    System.arraycopy(obj, i3, this.e, i, this.g - i);
                    System.arraycopy(obj2, i3, this.f, i, this.g - i);
                }
            }
        }
        return e;
    }

    public final int size() {
        return this.g;
    }

    public final Object[] toArray() {
        Object obj = new Object[this.g];
        System.arraycopy(this.f, 0, obj, 0, this.g);
        return obj;
    }

    public final <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.g) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.g);
        }
        System.arraycopy(this.f, 0, tArr, 0, this.g);
        if (tArr.length > this.g) {
            tArr[this.g] = null;
        }
        return tArr;
    }

    public final boolean equals(java.lang.Object r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof java.util.Set;
        r2 = 0;
        if (r1 == 0) goto L_0x002c;
    L_0x0009:
        r5 = (java.util.Set) r5;
        r1 = r4.size();
        r3 = r5.size();
        if (r1 == r3) goto L_0x0016;
    L_0x0015:
        return r2;
    L_0x0016:
        r1 = r2;
    L_0x0017:
        r3 = r4.g;	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
        if (r1 >= r3) goto L_0x0029;	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
    L_0x001b:
        r3 = r4.f;	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
        r3 = r3[r1];	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
        r3 = r5.contains(r3);	 Catch:{ NullPointerException -> 0x002b, ClassCastException -> 0x002a }
        if (r3 != 0) goto L_0x0026;
    L_0x0025:
        return r2;
    L_0x0026:
        r1 = r1 + 1;
        goto L_0x0017;
    L_0x0029:
        return r0;
    L_0x002a:
        return r2;
    L_0x002b:
        return r2;
    L_0x002c:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.utils.a.c.equals(java.lang.Object):boolean");
    }

    public final int hashCode() {
        int[] iArr = this.e;
        int i = 0;
        int i2 = 0;
        while (i < this.g) {
            i2 += iArr[i];
            i++;
        }
        return i2;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder stringBuilder = new StringBuilder(this.g * 14);
        stringBuilder.append('{');
        for (int i = 0; i < this.g; i++) {
            if (i > 0) {
                stringBuilder.append(", ");
            }
            c cVar = this.f[i];
            if (cVar != this) {
                stringBuilder.append(cVar);
            } else {
                stringBuilder.append("(this Set)");
            }
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return null;
            }
        }
        return true;
    }

    public final boolean addAll(Collection<? extends E> collection) {
        int size = this.g + collection.size();
        boolean z = false;
        if (this.e.length < size) {
            Object obj = this.e;
            Object obj2 = this.f;
            b(size);
            if (this.g > 0) {
                System.arraycopy(obj, 0, this.e, 0, this.g);
                System.arraycopy(obj2, 0, this.f, 0, this.g);
            }
            a(obj, obj2, this.g);
        }
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public final boolean removeAll(Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public final boolean retainAll(Collection<?> collection) {
        boolean z = false;
        for (int i = this.g - 1; i >= 0; i--) {
            if (!collection.contains(this.f[i])) {
                a(i);
                z = true;
            }
        }
        return z;
    }

    public final Iterator<E> iterator() {
        if (this.h == null) {
            this.h = new d(this);
        }
        return this.h.d().iterator();
    }
}
