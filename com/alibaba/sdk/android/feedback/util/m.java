package com.alibaba.sdk.android.feedback.util;

import android.content.Context;

final class m implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ Context b;

    m(boolean z, Context context) {
        this.a = z;
        this.b = context;
    }

    public final void run() {
        if (this.a) {
            k.e(this.b);
        } else {
            k.f(this.b);
        }
    }
}
