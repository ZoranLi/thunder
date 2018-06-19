package com.ali.auth.third.core.h.a;

import com.ali.auth.third.core.config.a;

final class d implements Runnable {
    final /* synthetic */ Runnable a;
    final /* synthetic */ b b;

    d(b bVar, Runnable runnable) {
        this.b = bVar;
        this.a = runnable;
    }

    public final void run() {
        try {
            this.a.run();
        } catch (Throwable th) {
            th.getMessage();
            boolean z = a.a;
        }
    }
}
