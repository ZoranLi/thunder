package com.qihoo360.replugin.utils.a;

import java.util.Map;

/* compiled from: ArrayMap */
final class b extends g<K, V> {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    protected final int a() {
        return this.a.h;
    }

    protected final Object a(int i, int i2) {
        return this.a.g[(i << 1) + i2];
    }

    protected final int a(Object obj) {
        return this.a.a(obj);
    }

    protected final int b(Object obj) {
        return this.a.b(obj);
    }

    protected final Map<K, V> b() {
        return this.a;
    }

    protected final void a(K k, V v) {
        this.a.put(k, v);
    }

    protected final V a(int i, V v) {
        i iVar = this.a;
        i = (i << 1) + 1;
        V v2 = iVar.g[i];
        iVar.g[i] = v;
        return v2;
    }

    protected final void a(int i) {
        this.a.c(i);
    }

    protected final void c() {
        this.a.clear();
    }
}
