package com.taobao.accs.data;

import android.content.Context;
import android.content.Intent;

/* compiled from: Taobao */
final class e implements Runnable {
    final /* synthetic */ Context a;
    final /* synthetic */ Intent b;

    e(Context context, Intent intent) {
        this.a = context;
        this.b = intent;
    }

    public final void run() {
        d.a(d.a(), this.a, this.b);
    }
}
