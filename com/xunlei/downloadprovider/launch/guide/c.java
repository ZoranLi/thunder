package com.xunlei.downloadprovider.launch.guide;

import android.support.v4.view.ViewPager.OnPageChangeListener;

/* compiled from: GuideActivity */
final class c implements OnPageChangeListener {
    final /* synthetic */ GuideActivity a;

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    c(GuideActivity guideActivity) {
        this.a = guideActivity;
    }

    public final void onPageSelected(int i) {
        GuideActivity.a(this.a).a(GuideActivity.b(this.a).b(i));
    }
}
