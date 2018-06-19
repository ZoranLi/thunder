package com.xunlei.downloadprovider.d.a;

import android.text.TextUtils;

/* compiled from: AbsConfig */
final class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        String b;
        if (TextUtils.isEmpty(this.a.d)) {
            b = f.b(this.a.v);
        } else {
            b = f.a(this.a.v, this.a.d);
        }
        a.a(this.a, b);
    }
}
