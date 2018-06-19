package anet.channel.a;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
class b extends ThreadPoolExecutor {

    /* compiled from: Taobao */
    class a<V> extends FutureTask<V> implements Comparable<a<V>> {
        final /* synthetic */ b a;
        private Object b;

        public /* synthetic */ int compareTo(Object obj) {
            return a((a) obj);
        }

        public a(b bVar, Callable<V> callable) {
            this.a = bVar;
            super(callable);
            this.b = callable;
        }

        public a(b bVar, Runnable runnable, V v) {
            this.a = bVar;
            super(runnable, v);
            this.b = runnable;
        }

        public int a(a<V> aVar) {
            if (this == aVar) {
                return 0;
            }
            if (aVar == null) {
                return -1;
            }
            if (this.b == null || aVar.b == null || !this.b.getClass().equals(aVar.b.getClass()) || !(this.b instanceof Comparable)) {
                return 0;
            }
            return ((Comparable) this.b).compareTo(aVar.b);
        }
    }

    public b(int i, ThreadFactory threadFactory) {
        super(i, i, 60, TimeUnit.SECONDS, new PriorityBlockingQueue(), threadFactory);
    }

    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return new a(this, runnable, t);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new a(this, callable);
    }
}
