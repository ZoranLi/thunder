package com.xunlei.downloadprovider.xlui.widget.extendviewpager.autoscrollviewpager;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/* compiled from: CustomDurationScroller */
public final class a extends Scroller {
    double a = 0;

    public a(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public final void startScroll(int i, int i2, int i3, int i4, int i5) {
        super.startScroll(i, i2, i3, i4, (int) (((double) i5) * this.a));
    }
}
