package com.xunlei.downloadprovider.web.browser;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: InputAutoCompleteView */
final class ar implements OnTouchListener {
    final /* synthetic */ InputAutoCompleteView a;

    ar(InputAutoCompleteView inputAutoCompleteView) {
        this.a = inputAutoCompleteView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case null:
                if (this.a.n != null) {
                    this.a.n.a();
                    break;
                }
                break;
            case 1:
                view.performClick();
                break;
            default:
                break;
        }
        return true;
    }
}
