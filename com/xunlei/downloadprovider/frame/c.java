package com.xunlei.downloadprovider.frame;

import android.support.v4.view.ViewPager.OnPageChangeListener;

/* compiled from: BaseViewPagerFragment */
final class c implements OnPageChangeListener {
    final /* synthetic */ BaseViewPagerFragment a;
    private int b = null;

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    c(BaseViewPagerFragment baseViewPagerFragment) {
        this.a = baseViewPagerFragment;
    }

    public final void onPageSelected(int i) {
        this.a.e(i);
        if (this.b != i) {
            this.a.c(this.b);
            this.b = i;
        }
        this.a.b(i);
    }
}
