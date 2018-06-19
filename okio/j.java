package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* compiled from: ForwardingTimeout */
public final class j extends w {
    public w a;

    public j(w wVar) {
        if (wVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = wVar;
    }

    public final w a(long j, TimeUnit timeUnit) {
        return this.a.a(j, timeUnit);
    }

    public final long v_() {
        return this.a.v_();
    }

    public final boolean w_() {
        return this.a.w_();
    }

    public final long c() {
        return this.a.c();
    }

    public final w a(long j) {
        return this.a.a(j);
    }

    public final w d() {
        return this.a.d();
    }

    public final w x_() {
        return this.a.x_();
    }

    public final void f() throws IOException {
        this.a.f();
    }
}
