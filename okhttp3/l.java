package okhttp3;

import java.lang.ref.Reference;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.internal.c;
import okhttp3.internal.connection.d;
import okhttp3.internal.connection.f.a;
import okhttp3.internal.e.e;

/* compiled from: ConnectionPool */
public final class l {
    static final Executor a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), c.a("OkHttp ConnectionPool", true));
    static final /* synthetic */ boolean g = true;
    final int b;
    final Runnable c;
    final Deque<okhttp3.internal.connection.c> d;
    final d e;
    boolean f;
    private final long h;

    public l() {
        this(TimeUnit.MINUTES);
    }

    private l(TimeUnit timeUnit) {
        this.c = new m(this);
        this.d = new ArrayDeque();
        this.e = new d();
        this.b = 5;
        this.h = timeUnit.toNanos(5);
    }

    final long a(long j) {
        synchronized (this) {
            long j2 = Long.MIN_VALUE;
            int i = 0;
            okhttp3.internal.connection.c cVar = null;
            int i2 = i;
            for (okhttp3.internal.connection.c cVar2 : this.d) {
                int i3;
                List list = cVar2.j;
                int i4 = 0;
                while (i4 < list.size()) {
                    Reference reference = (Reference) list.get(i4);
                    if (reference.get() != null) {
                        i4++;
                    } else {
                        a aVar = (a) reference;
                        StringBuilder stringBuilder = new StringBuilder("A connection to ");
                        stringBuilder.append(cVar2.a.a.a);
                        stringBuilder.append(" was leaked. Did you forget to close a response body?");
                        e.b().a(stringBuilder.toString(), aVar.a);
                        list.remove(i4);
                        cVar2.g = true;
                        if (list.isEmpty()) {
                            cVar2.k = j - this.h;
                            i3 = 0;
                            break;
                        }
                    }
                }
                i3 = list.size();
                if (i3 > 0) {
                    i++;
                } else {
                    i2++;
                    long j3 = j - cVar2.k;
                    if (j3 > j2) {
                        cVar = cVar2;
                        j2 = j3;
                    }
                }
            }
            if (j2 < this.h) {
                if (i2 <= this.b) {
                    if (i2 > 0) {
                        long j4 = this.h - j2;
                        return j4;
                    } else if (i > 0) {
                        j = this.h;
                        return j;
                    } else {
                        this.f = false;
                        return -1;
                    }
                }
            }
            this.d.remove(cVar);
            c.a(cVar.b);
            return 0;
        }
    }
}
