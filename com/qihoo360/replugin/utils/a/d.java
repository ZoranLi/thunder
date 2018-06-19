package com.qihoo360.replugin.utils.a;

import java.util.Map;

/* compiled from: ArraySet */
final class d extends g<E, E> {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    protected final int a() {
        return this.a.g;
    }

    protected final Object a(int i, int i2) {
        return this.a.f[i];
    }

    protected final int a(Object obj) {
        return this.a.a(obj);
    }

    protected final int b(Object obj) {
        return this.a.a(obj);
    }

    protected final Map<E, E> b() {
        throw new UnsupportedOperationException("not a map");
    }

    protected final void a(E e, E e2) {
        this.a.add(e);
    }

    protected final E a(int i, E e) {
        throw new UnsupportedOperationException("not a map");
    }

    protected final void a(int i) {
        this.a.a(i);
    }

    protected final void c() {
        this.a.clear();
    }
}
