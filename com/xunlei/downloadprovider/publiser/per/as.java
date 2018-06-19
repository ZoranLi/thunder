package com.xunlei.downloadprovider.publiser.per;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

/* compiled from: HistoryPublishItemFragment */
final class as implements OnTouchListener {
    final /* synthetic */ HistoryPublishItemFragment a;

    as(HistoryPublishItemFragment historyPublishItemFragment) {
        this.a = historyPublishItemFragment;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.o.a(motionEvent);
        return null;
    }
}
