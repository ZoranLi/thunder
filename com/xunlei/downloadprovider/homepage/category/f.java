package com.xunlei.downloadprovider.homepage.category;

import android.view.MotionEvent;

/* compiled from: ShortVideoCategoryActivity */
final class f implements Runnable {
    final /* synthetic */ MotionEvent a;
    final /* synthetic */ e b;

    f(e eVar, MotionEvent motionEvent) {
        this.b = eVar;
        this.a = motionEvent;
    }

    public final void run() {
        this.b.a.i.a(this.a);
    }
}
