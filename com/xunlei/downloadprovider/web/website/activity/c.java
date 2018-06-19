package com.xunlei.downloadprovider.web.website.activity;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.xunlei.downloadprovider.web.browser.aa;

/* compiled from: BroserCollectionAndHistoryActivity */
final class c implements OnPageChangeListener {
    final /* synthetic */ BroserCollectionAndHistoryActivity a;

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    c(BroserCollectionAndHistoryActivity broserCollectionAndHistoryActivity) {
        this.a = broserCollectionAndHistoryActivity;
    }

    public final void onPageSelected(int i) {
        if (i == 0) {
            aa.b();
        } else {
            aa.c();
        }
    }
}
