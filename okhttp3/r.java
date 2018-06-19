package okhttp3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import okhttp3.ae.a;
import okhttp3.internal.c;

/* compiled from: Dispatcher */
public final class r {
    private int a = 64;
    private int b = 5;
    @Nullable
    private Runnable c;
    @Nullable
    private ExecutorService d;
    private final Deque<a> e = new ArrayDeque();
    private final Deque<a> f = new ArrayDeque();
    private final Deque<ae> g = new ArrayDeque();

    private synchronized ExecutorService a() {
        if (this.d == null) {
            this.d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp Dispatcher", false));
        }
        return this.d;
    }

    final synchronized void a(a aVar) {
        if (this.f.size() >= this.a || c(aVar) >= this.b) {
            this.e.add(aVar);
            return;
        }
        this.f.add(aVar);
        a().execute(aVar);
    }

    private void b() {
        if (this.f.size() < this.a && !this.e.isEmpty()) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (c(aVar) < this.b) {
                    it.remove();
                    this.f.add(aVar);
                    a().execute(aVar);
                }
                if (this.f.size() >= this.a) {
                    return;
                }
            }
        }
    }

    private int c(a aVar) {
        int i = 0;
        for (a a : this.f) {
            if (a.a().equals(aVar.a())) {
                i++;
            }
        }
        return i;
    }

    final synchronized void a(ae aeVar) {
        this.g.add(aeVar);
    }

    final void b(a aVar) {
        a(this.f, aVar, true);
    }

    final void b(ae aeVar) {
        a(this.g, aeVar, false);
    }

    private <T> void a(Deque<T> deque, T t, boolean z) {
        synchronized (this) {
            if (deque.remove(t) == null) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            if (z) {
                b();
            }
            deque = c();
            t = this.c;
        }
        if (deque == null && t != null) {
            t.run();
        }
    }

    private synchronized int c() {
        return this.f.size() + this.g.size();
    }
}
