package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.xunlei.downloadprovider.frame.BaseFragment;
import java.util.ArrayList;
import java.util.List;

/* compiled from: LXSpaceFragmentAdapter */
final class z extends FragmentPagerAdapter {
    private List<BaseFragment> a = new ArrayList(3);

    public final /* synthetic */ Fragment getItem(int i) {
        return a(i);
    }

    public z(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    public final void a(BaseFragment baseFragment) {
        if (baseFragment != null) {
            this.a.add(baseFragment);
        }
    }

    public final BaseFragment a(int i) {
        return (BaseFragment) this.a.get(i);
    }

    public final int getCount() {
        return this.a.size();
    }
}
