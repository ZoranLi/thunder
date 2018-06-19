package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: ExecutorDelivery */
public final class e implements o {
    private final Executor a;

    /* compiled from: ExecutorDelivery */
    private class a implements Runnable {
        final /* synthetic */ e a;
        private final Request b;
        private final n c;
        private final Runnable d;

        public a(e eVar, Request request, n nVar, Runnable runnable) {
            this.a = eVar;
            this.b = request;
            this.c = nVar;
            this.d = runnable;
        }

        public final void run() {
            if (this.b.isCanceled()) {
                this.b.finish("canceled-at-delivery");
                return;
            }
            if ((this.c.c == null ? 1 : null) != null) {
                this.b.deliverResponse(this.c.a);
            } else {
                this.b.deliverError(this.c.c);
            }
            if (this.c.d) {
                this.b.addMarker("intermediate-response");
            } else {
                this.b.finish("done");
            }
            if (this.d != null) {
                this.d.run();
            }
        }
    }

    public e(Handler handler) {
        this.a = new f(this, handler);
    }

    public e(Executor executor) {
        this.a = executor;
    }

    public final void a(Request<?> request, n<?> nVar) {
        a(request, nVar, null);
    }

    public final void a(Request<?> request, n<?> nVar, Runnable runnable) {
        request.markDelivered();
        request.addMarker("post-response");
        this.a.execute(new a(this, request, nVar, runnable));
    }

    public final void a(Request<?> request, VolleyError volleyError) {
        request.addMarker("post-error");
        this.a.execute(new a(this, request, n.a(volleyError), null));
    }
}
