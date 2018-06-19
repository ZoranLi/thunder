package com.xunlei.downloadprovider.member.payment.ui;

import android.support.v4.view.ViewPager.OnPageChangeListener;

/* compiled from: BasePayPagerActivity */
final class ac implements OnPageChangeListener {
    final /* synthetic */ BasePayPagerActivity a;

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    ac(BasePayPagerActivity basePayPagerActivity) {
        this.a = basePayPagerActivity;
    }

    public final void onPageSelected(int i) {
        if (this.a.n != null) {
            this.a.n.setCurrentTab(i);
        }
    }
}
