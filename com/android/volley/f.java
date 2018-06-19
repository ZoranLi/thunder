package com.android.volley;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: ExecutorDelivery */
final class f implements Executor {
    final /* synthetic */ Handler a;
    final /* synthetic */ e b;

    f(e eVar, Handler handler) {
        this.b = eVar;
        this.a = handler;
    }

    public final void execute(Runnable runnable) {
        this.a.post(runnable);
    }
}
