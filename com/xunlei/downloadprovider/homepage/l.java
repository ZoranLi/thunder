package com.xunlei.downloadprovider.homepage;

import android.view.View;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip;

/* compiled from: HomeFragment */
final class l implements Runnable {
    final /* synthetic */ HomeFragment a;

    l(HomeFragment homeFragment) {
        this.a = homeFragment;
    }

    public final void run() {
        if (this.a.c) {
            PagerSlidingTabStrip p = this.a.d();
            int currentTabIndext = p.getCurrentTabIndext();
            int length = this.a.l.f.length;
            for (int i = 0; i < length; i++) {
                View a = p.a(i);
                if (a != null) {
                    a = (ImageView) a.findViewById(R.id.main_tab_top_point);
                    this.a.a(i, a);
                    if (currentTabIndext == i) {
                        this.a.e(i);
                        a.setVisibility(8);
                    }
                }
            }
        }
    }
}
