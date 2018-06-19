package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* compiled from: AsyncTimeout */
public class a extends w {
    private static final long a = TimeUnit.SECONDS.toMillis(60);
    @Nullable
    static a b;
    private static final long d = TimeUnit.MILLISECONDS.toNanos(a);
    private boolean e;
    @Nullable
    private a f;
    private long g;

    protected void a() {
    }

    public final void t_() {
        if (this.e) {
            throw new IllegalStateException("Unbalanced enter/exit");
        }
        long v_ = v_();
        boolean w_ = w_();
        if (v_ != 0 || w_) {
            this.e = true;
            a(this, v_, w_);
        }
    }

    private static synchronized void a(a aVar, long j, boolean z) {
        synchronized (a.class) {
            if (b == null) {
                b = new a();
                new a().start();
            }
            long nanoTime = System.nanoTime();
            if (j != 0 && z) {
                aVar.g = nanoTime + Math.min(j, aVar.c() - nanoTime);
            } else if (j != 0) {
                aVar.g = nanoTime + j;
            } else if (z) {
                aVar.g = aVar.c();
            } else {
                throw new AssertionError();
            }
            long j2 = aVar.g - nanoTime;
            j = b;
            while (j.f != null) {
                if (j2 < j.f.g - nanoTime) {
                    break;
                }
                j = j.f;
            }
            aVar.f = j.f;
            j.f = aVar;
            if (j == b) {
                a.class.notify();
                return;
            }
        }
    }

    public final boolean u_() {
        if (!this.e) {
            return false;
        }
        this.e = false;
        return a(this);
    }

    private static synchronized boolean a(a aVar) {
        synchronized (a.class) {
            for (a aVar2 = b; aVar2 != null; aVar2 = aVar2.f) {
                if (aVar2.f == aVar) {
                    aVar2.f = aVar.f;
                    aVar.f = null;
                    return null;
                }
            }
            return true;
        }
    }

    final void a(boolean z) throws IOException {
        if (u_() && z) {
            throw a((IOException) false);
        }
    }

    final IOException b(IOException iOException) throws IOException {
        if (u_()) {
            return a(iOException);
        }
        return iOException;
    }

    protected IOException a(@Nullable IOException iOException) {
        IOException interruptedIOException = new InterruptedIOException(com.alipay.sdk.data.a.f);
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    @Nullable
    static a e() throws InterruptedException {
        a aVar = b.f;
        if (aVar == null) {
            long nanoTime = System.nanoTime();
            a.class.wait(a);
            if (b.f != null || System.nanoTime() - nanoTime < d) {
                return null;
            }
            return b;
        }
        long nanoTime2 = aVar.g - System.nanoTime();
        if (nanoTime2 > 0) {
            long j = nanoTime2 / 1000000;
            a.class.wait(j, (int) (nanoTime2 - (1000000 * j)));
            return null;
        }
        b.f = aVar.f;
        aVar.f = null;
        return aVar;
    }
}
