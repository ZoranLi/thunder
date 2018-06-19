package com.xunlei.downloadprovider.frame;

import com.xunlei.downloadprovider.frame.view.XLTabLayout.b;
import com.xunlei.downloadprovider.frame.view.XLTabView;

/* compiled from: MainTabActivity */
final class y implements b {
    final /* synthetic */ MainTabActivity a;

    y(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    public final void a(XLTabView xLTabView) {
        this.a.b();
        String currentTag = MainTabActivity.b(this.a).getCurrentTag();
        xLTabView = xLTabView.getTabTag();
        boolean equals = xLTabView.equals(currentTag) ^ 1;
        BaseFragment baseFragment = null;
        if (MainTabActivity.d(this.a) != null) {
            baseFragment = MainTabActivity.d(this.a).a(xLTabView);
        }
        if ((baseFragment instanceof BaseViewPagerFragment) != null) {
            ((BaseViewPagerFragment) baseFragment).a(equals);
            return;
        }
        if ((baseFragment instanceof BasePageFragment) != null) {
            ((BasePageFragment) baseFragment).onMainTabClick(equals);
        }
    }
}
