package com.xunlei.downloadprovider.vod.floatwindow;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* compiled from: VodPlayerFloatWindow */
final class c extends SimpleOnGestureListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (this.a.g != null) {
            if ((this.a.f.g.getVisibility() == null ? 1 : null) != null) {
                this.a.f.a();
            } else {
                this.a.f.a(this.a.g.t() ^ true);
            }
        }
        return true;
    }
}
