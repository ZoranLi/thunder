package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* compiled from: Timeout */
public class w {
    public static final w c = new x();
    private boolean a;
    private long b;
    private long d;

    public w a(long j, TimeUnit timeUnit) {
        if (j < 0) {
            StringBuilder stringBuilder = new StringBuilder("timeout < 0: ");
            stringBuilder.append(j);
            throw new IllegalArgumentException(stringBuilder.toString());
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            this.d = timeUnit.toNanos(j);
            return this;
        }
    }

    public long v_() {
        return this.d;
    }

    public boolean w_() {
        return this.a;
    }

    public long c() {
        if (this.a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public w a(long j) {
        this.a = true;
        this.b = j;
        return this;
    }

    public w d() {
        this.d = 0;
        return this;
    }

    public w x_() {
        this.a = false;
        return this;
    }

    public void f() throws IOException {
        if (Thread.interrupted()) {
            throw new InterruptedIOException("thread interrupted");
        } else if (this.a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }
}
