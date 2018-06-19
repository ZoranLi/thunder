package com.xunlei.downloadprovider.player.xmp.b;

import android.util.LruCache;

/* compiled from: XmpLruCache */
public final class g<K, V> extends LruCache<K, V> {
    public a a;

    /* compiled from: XmpLruCache */
    public interface a<K, V> {
        void a(boolean z, K k, V v, V v2);
    }

    public g(int i) {
        super(i);
    }

    protected final void entryRemoved(boolean z, K k, V v, V v2) {
        super.entryRemoved(z, k, v, v2);
        if (this.a != null) {
            this.a.a(z, k, v, v2);
        }
    }
}
