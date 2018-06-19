package com.android.volley.toolbox;

import com.android.volley.toolbox.o.c;

/* compiled from: NetworkImageView */
final class x implements Runnable {
    final /* synthetic */ c a;
    final /* synthetic */ w b;

    x(w wVar, c cVar) {
        this.b = wVar;
        this.a = cVar;
    }

    public final void run() {
        this.b.a(this.a, false);
    }
}
