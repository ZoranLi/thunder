package com.xunlei.downloadprovider.homepage;

import android.view.View;
import android.widget.ImageView;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.member.login.b.g;
import com.xunlei.downloadprovider.xlui.widget.PagerSlidingTabStrip;

/* compiled from: HomeFragment */
final class e implements g {
    final /* synthetic */ HomeFragment a;

    e(HomeFragment homeFragment) {
        this.a = homeFragment;
    }

    public final void onLogout() {
        this.a.o = false;
        PagerSlidingTabStrip b = this.a.d();
        if (b != null) {
            int length = this.a.l.f.length;
            for (int i = 0; i < length; i++) {
                if ("follow".equals(this.a.f(i))) {
                    View a = b.a(i);
                    if (a != null) {
                        ImageView imageView = (ImageView) a.findViewById(R.id.main_tab_top_point);
                        ((ImageView) a.findViewById(R.id.main_tab_top_live)).setVisibility(8);
                        imageView.setVisibility(8);
                    }
                }
            }
        }
    }
}
