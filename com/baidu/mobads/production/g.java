package com.baidu.mobads.production;

import android.content.Context;

class g implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ b b;

    g(b bVar, Context context) {
        this.b = bVar;
        this.a = context;
    }

    public void run() {
        this.b.a(this.a);
    }
}
