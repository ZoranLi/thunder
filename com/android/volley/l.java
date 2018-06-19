package com.android.volley;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: RequestQueue */
public final class l {
    private final AtomicInteger a;
    private final Set<Request<?>> b;
    private final PriorityBlockingQueue<Request<?>> c;
    private final PriorityBlockingQueue<Request<?>> d;
    private final a e;
    private final h f;
    private final o g;
    private final i[] h;
    private b i;
    private final List<Object> j;

    /* compiled from: RequestQueue */
    public interface a {
        boolean a(Request<?> request);
    }

    public l(a aVar, h hVar, int i, o oVar) {
        this.a = new AtomicInteger();
        this.b = new HashSet();
        this.c = new PriorityBlockingQueue();
        this.d = new PriorityBlockingQueue();
        this.j = new ArrayList();
        this.e = aVar;
        this.f = hVar;
        this.h = new i[i];
        this.g = oVar;
    }

    public l(a aVar, h hVar, int i) {
        this(aVar, hVar, i, new e(new Handler(Looper.getMainLooper())));
    }

    public l(a aVar, h hVar) {
        this(aVar, hVar, 4);
    }

    private void a(a aVar) {
        synchronized (this.b) {
            for (Request request : this.b) {
                if (aVar.a(request)) {
                    request.cancel();
                }
            }
        }
    }

    public final void a(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Cannot cancelAll with a null tag");
        }
        a(new m(this, obj));
    }

    public final <T> Request<T> a(Request<T> request) {
        request.setRequestQueue(this);
        synchronized (this.b) {
            this.b.add(request);
        }
        request.setSequence(this.a.incrementAndGet());
        request.addMarker("add-to-queue");
        if (request.shouldCache()) {
            this.c.add(request);
            return request;
        }
        this.d.add(request);
        return request;
    }

    final <T> void b(Request<T> request) {
        synchronized (this.b) {
            this.b.remove(request);
        }
        synchronized (this.j) {
            Iterator it = this.j.iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
    }

    public final void a() {
        if (this.i != null) {
            this.i.a();
        }
        int i = 0;
        for (i iVar : this.h) {
            if (iVar != null) {
                iVar.a = true;
                iVar.interrupt();
            }
        }
        this.i = new b(this.c, this.d, this.e, this.g);
        this.i.start();
        while (i < this.h.length) {
            i iVar2 = new i(this.d, this.f, this.e, this.g);
            this.h[i] = iVar2;
            iVar2.start();
            i++;
        }
    }
}
