package com.xunlei.downloadprovider.xlui.widget.extendviewpager;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;

/* compiled from: CircleIndicator */
final class a implements OnPageChangeListener {
    final /* synthetic */ CircleIndicator a;

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    a(CircleIndicator circleIndicator) {
        this.a = circleIndicator;
    }

    public final void onPageSelected(int i) {
        if ((this.a.b instanceof c)) {
            i = ((c) this.a.b).b(i);
        }
        if (this.a.a.getAdapter() != null) {
            if (this.a.getPagerAdapterCount() > 0) {
                View childAt;
                if (this.a.k.isRunning()) {
                    this.a.k.end();
                    this.a.k.cancel();
                }
                if (this.a.j.isRunning()) {
                    this.a.j.end();
                    this.a.j.cancel();
                }
                if (this.a.n >= 0) {
                    childAt = this.a.getChildAt(this.a.n);
                    if (childAt != null) {
                        childAt.setBackgroundResource(this.a.i);
                        this.a.k.setTarget(childAt);
                        this.a.k.start();
                    }
                }
                childAt = this.a.getChildAt(i);
                if (childAt != null) {
                    childAt.setBackgroundResource(this.a.h);
                    this.a.j.setTarget(childAt);
                    this.a.j.start();
                }
                this.a.n = i;
            }
        }
    }
}
