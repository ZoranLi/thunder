package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

final class d extends Thread {
    final /* synthetic */ Context a;
    final /* synthetic */ String b;
    final /* synthetic */ ValueCallback c;

    d(Context context, String str, ValueCallback valueCallback) {
        this.a = context;
        this.b = str;
        this.c = valueCallback;
    }

    public final void run() {
        bk b = bk.b();
        b.a(this.a);
        new Handler(Looper.getMainLooper()).post(new e(this, b.c() ? b.d().a(this.a, this.b) : false));
    }
}
