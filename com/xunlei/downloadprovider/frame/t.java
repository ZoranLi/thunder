package com.xunlei.downloadprovider.frame;

import com.xunlei.downloadprovider.frame.view.XLTabView;

/* compiled from: MainTabActivity */
final class t implements Runnable {
    final /* synthetic */ MainTabActivity a;

    t(MainTabActivity mainTabActivity) {
        this.a = mainTabActivity;
    }

    public final void run() {
        XLTabView currentTabView = MainTabActivity.b(this.a).getCurrentTabView();
        for (int i = 0; i < MainTabActivity.b(this.a).getChildCount(); i++) {
            XLTabView xLTabView = (XLTabView) MainTabActivity.b(this.a).getChildAt(i);
            if (xLTabView == currentTabView) {
                xLTabView.setPointVisible(8);
            } else {
                MainTabActivity.a(i, xLTabView);
            }
        }
    }
}
