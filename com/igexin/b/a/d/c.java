package com.igexin.b.a.d;

import com.igexin.b.a.d.a.e;
import java.util.concurrent.ConcurrentLinkedQueue;

public class c {
    private final ConcurrentLinkedQueue<e> a = new ConcurrentLinkedQueue();
    private final ConcurrentLinkedQueue<e> b = new ConcurrentLinkedQueue();
    private ConcurrentLinkedQueue<e> c = this.a;

    public synchronized void a() {
        this.c = this.a;
    }

    public synchronized void a(e eVar) {
        this.c.offer(eVar);
    }

    public synchronized void b() {
        this.c = this.b;
        this.c.addAll(this.a);
        this.a.clear();
    }

    public synchronized boolean c() {
        return this.c.isEmpty();
    }

    public synchronized e d() {
        return (e) this.c.poll();
    }
}
