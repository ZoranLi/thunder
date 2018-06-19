package com.getui.gtc.e;

import android.content.Context;

public final class b implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ com.getui.gtc.e.a.b b;

    public b(Context context, com.getui.gtc.e.a.b bVar) {
        this.a = context;
        this.b = bVar;
    }

    public final void run() {
        a.a(this.a, this.b);
    }
}
