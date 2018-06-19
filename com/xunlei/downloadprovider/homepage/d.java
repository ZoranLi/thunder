package com.xunlei.downloadprovider.homepage;

import android.app.Activity;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/* compiled from: GoBackGestureDetector */
final class d extends SimpleOnGestureListener {
    final /* synthetic */ float a;
    final /* synthetic */ float b;
    final /* synthetic */ Activity c;
    final /* synthetic */ c d;

    d(c cVar, float f, float f2, Activity activity) {
        this.d = cVar;
        this.a = f;
        this.b = f2;
        this.c = activity;
    }

    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent != null) {
            if (motionEvent2 != null) {
                float rawY = motionEvent2.getRawY() - motionEvent.getRawY();
                motionEvent2 = motionEvent2.getRawX() - motionEvent.getRawX();
                if (Math.abs(rawY) > this.a || motionEvent2 <= null || 1073741824 * Math.abs(motionEvent2) < 3.0f * Math.abs(rawY) || motionEvent2 <= this.b || f <= 500.0f) {
                    return false;
                }
                if (this.d.a == null) {
                    this.c.finish();
                } else {
                    this.d.a.a();
                }
                return true;
            }
        }
        return false;
    }
}
