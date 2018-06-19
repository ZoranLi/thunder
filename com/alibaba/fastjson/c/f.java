package com.alibaba.fastjson.c;

import com.tencent.tinker.android.dex.DebugInfoItem;

/* compiled from: IdentityHashMap */
public class f<K, V> {
    private final a<K, V>[] a;
    private final int b;

    /* compiled from: IdentityHashMap */
    protected static final class a<K, V> {
        public final int a;
        public final K b;
        public V c;
        public final a<K, V> d;

        public a(K k, V v, int i, a<K, V> aVar) {
            this.b = k;
            this.c = v;
            this.d = aVar;
            this.a = i;
        }
    }

    public f() {
        this((byte) 0);
    }

    public f(byte b) {
        this.b = (byte) -1;
        this.a = new a[DebugInfoItem.DBG_END_SEQUENCE];
    }

    public final V a(K k) {
        for (a aVar = this.a[System.identityHashCode(k) & this.b]; aVar != null; aVar = aVar.d) {
            if (k == aVar.b) {
                return aVar.c;
            }
        }
        return null;
    }

    public final boolean a(K k, V v) {
        int identityHashCode = System.identityHashCode(k);
        int i = this.b & identityHashCode;
        for (a aVar = this.a[i]; aVar != null; aVar = aVar.d) {
            if (k == aVar.b) {
                aVar.c = v;
                return true;
            }
        }
        this.a[i] = new a(k, v, identityHashCode, this.a[i]);
        return null;
    }
}
