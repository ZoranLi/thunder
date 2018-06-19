package anet.channel.strategy.utils;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: Taobao */
public class SerialLruCache<K, V> extends LinkedHashMap<K, V> {
    private int a;

    public boolean a(Entry<K, V> entry) {
        return true;
    }

    public SerialLruCache(int i) {
        super(i + 1, 1.0f, true);
        this.a = i;
    }

    protected boolean removeEldestEntry(Entry<K, V> entry) {
        return size() > this.a ? a(entry) : null;
    }
}
