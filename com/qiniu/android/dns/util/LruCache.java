package com.qiniu.android.dns.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

public final class LruCache<K, V> extends LinkedHashMap<K, V> {
    private int size;

    public LruCache() {
        this(256);
    }

    public LruCache(int i) {
        super(i, 1.0f, true);
        this.size = i;
    }

    protected final boolean removeEldestEntry(Entry<K, V> entry) {
        return size() > this.size ? true : null;
    }
}
