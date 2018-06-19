package com.xunlei.downloadprovider.search.ui.search;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/* compiled from: MainSearchFragmentAdapter */
public final class e extends FragmentPagerAdapter {
    private final List<Fragment> a;

    public e(FragmentManager fragmentManager, List<Fragment> list) {
        super(fragmentManager);
        this.a = list;
    }

    public final Fragment getItem(int i) {
        return (Fragment) this.a.get(i);
    }

    public final int getCount() {
        return this.a.size();
    }
}
