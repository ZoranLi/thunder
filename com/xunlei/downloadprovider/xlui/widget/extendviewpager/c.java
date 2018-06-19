package com.xunlei.downloadprovider.xlui.widget.extendviewpager;

import android.support.v4.view.PagerAdapter;

/* compiled from: InfiniteLoopPagerAdapter */
public abstract class c extends PagerAdapter {
    protected boolean a = false;

    public abstract int b();

    public int getCount() {
        return this.a ? 10000 : b();
    }

    public final int b(int i) {
        return this.a ? i % b() : i;
    }

    public final c c() {
        this.a = true;
        return this;
    }
}
