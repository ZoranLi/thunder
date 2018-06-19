package com.alibaba.sdk.android.feedback.xblink.view;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class b implements OnTouchListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int top = this.a.e.getTop();
        int y = (int) motionEvent.getY();
        if (motionEvent.getAction() == 1 && y < top) {
            this.a.c.dismiss();
        }
        return true;
    }
}
