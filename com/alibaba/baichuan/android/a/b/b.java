package com.alibaba.baichuan.android.a.b;

import android.content.Context;
import com.alibaba.baichuan.android.trade.c.b.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class b {
    private Context a = null;
    private d b = null;
    private Map c = new HashMap();
    private ReentrantReadWriteLock d = new ReentrantReadWriteLock(true);

    public b(Context context, d dVar) {
        this.a = context;
        this.b = dVar;
    }

    public final Object a(String str) {
        this.d.readLock().lock();
        Object obj;
        try {
            obj = this.c.get(str);
            if (obj != null) {
                return obj;
            }
            this.d.writeLock().lock();
            try {
                if (this.c.get(str) == null) {
                    a a = c.a(str, this.a, this.b);
                    if (a != null) {
                        this.c.put(str, a);
                        obj = a;
                    }
                }
                this.d.writeLock().unlock();
                return obj;
            } catch (Throwable th) {
                this.d.writeLock().unlock();
            }
        } finally {
            obj = this.d.readLock();
            obj.unlock();
        }
    }
}
