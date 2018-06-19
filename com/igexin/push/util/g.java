package com.igexin.push.util;

import android.content.Context;

final class g implements Runnable {
    final /* synthetic */ Context a;

    g(Context context) {
        this.a = context;
    }

    public final void run() {
        e.a(this.a, String.valueOf(System.currentTimeMillis()));
    }
}
