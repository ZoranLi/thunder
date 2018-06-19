package com.xunlei.downloadprovider.vod.floatwindow;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: VodPlayerFloatWindow */
final class g implements OnTouchListener {
    float a;
    float b;
    final /* synthetic */ int c;
    final /* synthetic */ a d;

    g(a aVar, int i) {
        this.d = aVar;
        this.c = i;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.d.h.onTouchEvent(motionEvent);
        view = motionEvent.getRawX();
        float rawY = motionEvent.getRawY() - ((float) this.c);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.a = motionEvent.getX();
            this.b = motionEvent.getY();
        } else if (action == 2) {
            this.d.e.x = (int) (view - this.a);
            this.d.e.y = (int) (rawY - this.b);
            this.d.d.updateViewLayout(this.d.f, this.d.e);
        }
        return true;
    }
}
