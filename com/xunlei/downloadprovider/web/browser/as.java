package com.xunlei.downloadprovider.web.browser;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.xunlei.common.androidutil.AndroidConfig;

/* compiled from: InputAutoCompleteView */
final class as implements OnTouchListener {
    final /* synthetic */ InputAutoCompleteView a;

    as(InputAutoCompleteView inputAutoCompleteView) {
        this.a = inputAutoCompleteView;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        AndroidConfig.hiddenInput(this.a.h, view);
        return null;
    }
}
