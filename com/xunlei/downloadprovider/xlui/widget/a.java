package com.xunlei.downloadprovider.xlui.widget;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

/* compiled from: PagerSlidingTabStrip */
final class a implements OnGlobalLayoutListener {
    final /* synthetic */ PagerSlidingTabStrip a;

    a(PagerSlidingTabStrip pagerSlidingTabStrip) {
        this.a = pagerSlidingTabStrip;
    }

    @SuppressLint({"NewApi"})
    public final void onGlobalLayout() {
        if (VERSION.SDK_INT < 16) {
            this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        } else {
            this.a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
        this.a.g = this.a.e.getCurrentItem();
        PagerSlidingTabStrip.a(this.a, this.a.g, 0);
    }
}
