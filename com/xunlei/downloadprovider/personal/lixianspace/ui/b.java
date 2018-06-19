package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.xunlei.downloadprovider.personal.lixianspace.ui.fragment.PullToRefreshWebFragment;

/* compiled from: LXSpaceActivity */
final class b implements OnPageChangeListener {
    final /* synthetic */ LXSpaceActivity a;

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    b(LXSpaceActivity lXSpaceActivity) {
        this.a = lXSpaceActivity;
    }

    public final void onPageSelected(int i) {
        this.a.a(i);
        i = this.a.f.a(i);
        if (i != 0 && (i instanceof PullToRefreshWebFragment)) {
            ((PullToRefreshWebFragment) i).d();
        }
    }
}
