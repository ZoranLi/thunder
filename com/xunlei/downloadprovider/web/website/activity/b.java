package com.xunlei.downloadprovider.web.website.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/* compiled from: BroserCollectionAndHistoryActivity */
final class b extends FragmentPagerAdapter {
    final /* synthetic */ BroserCollectionAndHistoryActivity a;

    b(BroserCollectionAndHistoryActivity broserCollectionAndHistoryActivity, FragmentManager fragmentManager) {
        this.a = broserCollectionAndHistoryActivity;
        super(fragmentManager);
    }

    public final int getCount() {
        return BroserCollectionAndHistoryActivity.i.length;
    }

    public final Fragment getItem(int i) {
        return (Fragment) this.a.e.get(i);
    }

    public final CharSequence getPageTitle(int i) {
        return BroserCollectionAndHistoryActivity.i[i];
    }
}
