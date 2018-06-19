package anetwork.channel.cache;

import anet.channel.a.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/* compiled from: Taobao */
public final class e {
    private static List<a> a = new ArrayList();
    private static final ReentrantReadWriteLock b;
    private static final ReadLock c;
    private static final WriteLock d = b.writeLock();

    /* compiled from: Taobao */
    private static class a implements Comparable<a> {
        final Cache a;
        final h b;
        final int c = 1;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.c - ((a) obj).c;
        }

        a(Cache cache, h hVar) {
            this.a = cache;
            this.b = hVar;
        }
    }

    static {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        b = reentrantReadWriteLock;
        c = reentrantReadWriteLock.readLock();
        c.a(new f());
    }

    public static void a(Cache cache, h hVar) {
        try {
            d.lock();
            a.add(new a(cache, hVar));
            Collections.sort(a);
        } finally {
            d.unlock();
        }
    }

    public static Cache a(Map<String, String> map) {
        try {
            c.lock();
            for (a aVar : a) {
                if (aVar.b.a(map)) {
                    map = aVar.a;
                    return map;
                }
            }
            c.unlock();
            return null;
        } finally {
            c.unlock();
        }
    }
}
