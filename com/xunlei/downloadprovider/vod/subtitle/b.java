package com.xunlei.downloadprovider.vod.subtitle;

import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import java.util.concurrent.TimeUnit;

/* compiled from: LoopViewGestureListener */
final class b extends SimpleOnGestureListener {
    final LoopView a;

    b(LoopView loopView) {
        this.a = loopView;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        motionEvent = this.a;
        motionEvent.a();
        motionEvent.d = motionEvent.c.scheduleWithFixedDelay(new a(motionEvent, f2), 0, 10, TimeUnit.MILLISECONDS);
        return true;
    }
}
