package com.xunlei.downloadprovider.homepage.choiceness.ui;

import android.view.MotionEvent;

/* compiled from: HomeChoicenessFragment */
final class p implements Runnable {
    final /* synthetic */ MotionEvent a;
    final /* synthetic */ o b;

    p(o oVar, MotionEvent motionEvent) {
        this.b = oVar;
        this.a = motionEvent;
    }

    public final void run() {
        this.b.a.f.a(this.a);
    }
}
