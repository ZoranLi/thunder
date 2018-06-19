package com.alibaba.sdk.android.feedback.windvane;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class i implements OnTouchListener {
    final /* synthetic */ WXBaseHybridActivity a;

    i(WXBaseHybridActivity wXBaseHybridActivity) {
        this.a = wXBaseHybridActivity;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
            case 1:
                if (!view.hasFocus()) {
                    view.requestFocus();
                    break;
                }
                break;
            default:
                break;
        }
        return false;
    }
}
