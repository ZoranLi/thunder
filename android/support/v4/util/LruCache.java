package android.support.v4.util;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    protected V create(K k) {
        return null;
    }

    protected void entryRemoved(boolean z, K k, V v, V v2) {
    }

    protected int sizeOf(K k, V v) {
        return 1;
    }

    public LruCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap(0, 0.75f, true);
    }

    public void resize(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        synchronized (this) {
            this.maxSize = i;
        }
        trimToSize(i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V get(K r5) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000a;
    L_0x0002:
        r5 = new java.lang.NullPointerException;
        r0 = "key == null";
        r5.<init>(r0);
        throw r5;
    L_0x000a:
        monitor-enter(r4);
        r0 = r4.map;	 Catch:{ all -> 0x0059 }
        r0 = r0.get(r5);	 Catch:{ all -> 0x0059 }
        if (r0 == 0) goto L_0x001b;
    L_0x0013:
        r5 = r4.hitCount;	 Catch:{ all -> 0x0059 }
        r5 = r5 + 1;
        r4.hitCount = r5;	 Catch:{ all -> 0x0059 }
        monitor-exit(r4);	 Catch:{ all -> 0x0059 }
        return r0;
    L_0x001b:
        r0 = r4.missCount;	 Catch:{ all -> 0x0059 }
        r0 = r0 + 1;
        r4.missCount = r0;	 Catch:{ all -> 0x0059 }
        monitor-exit(r4);	 Catch:{ all -> 0x0059 }
        r0 = r4.create(r5);
        if (r0 != 0) goto L_0x002a;
    L_0x0028:
        r5 = 0;
        return r5;
    L_0x002a:
        monitor-enter(r4);
        r1 = r4.createCount;	 Catch:{ all -> 0x0056 }
        r1 = r1 + 1;
        r4.createCount = r1;	 Catch:{ all -> 0x0056 }
        r1 = r4.map;	 Catch:{ all -> 0x0056 }
        r1 = r1.put(r5, r0);	 Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x003f;
    L_0x0039:
        r2 = r4.map;	 Catch:{ all -> 0x0056 }
        r2.put(r5, r1);	 Catch:{ all -> 0x0056 }
        goto L_0x0048;
    L_0x003f:
        r2 = r4.size;	 Catch:{ all -> 0x0056 }
        r3 = r4.safeSizeOf(r5, r0);	 Catch:{ all -> 0x0056 }
        r2 = r2 + r3;
        r4.size = r2;	 Catch:{ all -> 0x0056 }
    L_0x0048:
        monitor-exit(r4);	 Catch:{ all -> 0x0056 }
        if (r1 == 0) goto L_0x0050;
    L_0x004b:
        r2 = 0;
        r4.entryRemoved(r2, r5, r0, r1);
        return r1;
    L_0x0050:
        r5 = r4.maxSize;
        r4.trimToSize(r5);
        return r0;
    L_0x0056:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0056 }
        throw r5;
    L_0x0059:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0059 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.LruCache.get(java.lang.Object):V");
    }

    public final V put(K k, V v) {
        if (k != null) {
            if (v != null) {
                V put;
                synchronized (this) {
                    this.putCount++;
                    this.size += safeSizeOf(k, v);
                    put = this.map.put(k, v);
                    if (put != null) {
                        this.size -= safeSizeOf(k, put);
                    }
                }
                if (put != null) {
                    entryRemoved(false, k, put, v);
                }
                trimToSize(this.maxSize);
                return put;
            }
        }
        throw new NullPointerException("key == null || value == null");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void trimToSize(int r5) {
        /*
        r4 = this;
    L_0x0000:
        monitor-enter(r4);
        r0 = r4.size;	 Catch:{ all -> 0x0072 }
        if (r0 < 0) goto L_0x0053;
    L_0x0005:
        r0 = r4.map;	 Catch:{ all -> 0x0072 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x0012;
    L_0x000d:
        r0 = r4.size;	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x0012;
    L_0x0011:
        goto L_0x0053;
    L_0x0012:
        r0 = r4.size;	 Catch:{ all -> 0x0072 }
        if (r0 <= r5) goto L_0x0051;
    L_0x0016:
        r0 = r4.map;	 Catch:{ all -> 0x0072 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0072 }
        if (r0 == 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0051;
    L_0x001f:
        r0 = r4.map;	 Catch:{ all -> 0x0072 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0072 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0072 }
        r0 = r0.next();	 Catch:{ all -> 0x0072 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0072 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0072 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0072 }
        r2 = r4.map;	 Catch:{ all -> 0x0072 }
        r2.remove(r1);	 Catch:{ all -> 0x0072 }
        r2 = r4.size;	 Catch:{ all -> 0x0072 }
        r3 = r4.safeSizeOf(r1, r0);	 Catch:{ all -> 0x0072 }
        r2 = r2 - r3;
        r4.size = r2;	 Catch:{ all -> 0x0072 }
        r2 = r4.evictionCount;	 Catch:{ all -> 0x0072 }
        r3 = 1;
        r2 = r2 + r3;
        r4.evictionCount = r2;	 Catch:{ all -> 0x0072 }
        monitor-exit(r4);	 Catch:{ all -> 0x0072 }
        r2 = 0;
        r4.entryRemoved(r3, r1, r0, r2);
        goto L_0x0000;
    L_0x0051:
        monitor-exit(r4);	 Catch:{ all -> 0x0072 }
        return;
    L_0x0053:
        r5 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0072 }
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0072 }
        r0.<init>();	 Catch:{ all -> 0x0072 }
        r1 = r4.getClass();	 Catch:{ all -> 0x0072 }
        r1 = r1.getName();	 Catch:{ all -> 0x0072 }
        r0.append(r1);	 Catch:{ all -> 0x0072 }
        r1 = ".sizeOf() is reporting inconsistent results!";
        r0.append(r1);	 Catch:{ all -> 0x0072 }
        r0 = r0.toString();	 Catch:{ all -> 0x0072 }
        r5.<init>(r0);	 Catch:{ all -> 0x0072 }
        throw r5;	 Catch:{ all -> 0x0072 }
    L_0x0072:
        r5 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0072 }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.util.LruCache.trimToSize(int):void");
    }

    public final V remove(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        V remove;
        synchronized (this) {
            remove = this.map.remove(k);
            if (remove != null) {
                this.size -= safeSizeOf(k, remove);
            }
        }
        if (remove != null) {
            entryRemoved(false, k, remove, null);
        }
        return remove;
    }

    private int safeSizeOf(K k, V v) {
        int sizeOf = sizeOf(k, v);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        StringBuilder stringBuilder = new StringBuilder("Negative size: ");
        stringBuilder.append(k);
        stringBuilder.append("=");
        stringBuilder.append(v);
        throw new IllegalStateException(stringBuilder.toString());
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final synchronized int size() {
        return this.size;
    }

    public final synchronized int maxSize() {
        return this.maxSize;
    }

    public final synchronized int hitCount() {
        return this.hitCount;
    }

    public final synchronized int missCount() {
        return this.missCount;
    }

    public final synchronized int createCount() {
        return this.createCount;
    }

    public final synchronized int putCount() {
        return this.putCount;
    }

    public final synchronized int evictionCount() {
        return this.evictionCount;
    }

    public final synchronized Map<K, V> snapshot() {
        return new LinkedHashMap(this.map);
    }

    public final synchronized String toString() {
        int i;
        i = this.hitCount + this.missCount;
        i = i != 0 ? (100 * this.hitCount) / i : 0;
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.maxSize), Integer.valueOf(this.hitCount), Integer.valueOf(this.missCount), Integer.valueOf(i)});
    }
}
