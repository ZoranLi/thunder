package com.xunlei.downloadprovider.personal.liked;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.xunlei.downloadprovider.personal.message.data.q;

/* compiled from: LikeContentActivity */
final class i implements OnPageChangeListener {
    final /* synthetic */ LikeContentActivity a;

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    i(LikeContentActivity likeContentActivity) {
        this.a = likeContentActivity;
    }

    public final void onPageSelected(int i) {
        LikeContentActivity.a;
        if (i == 0) {
            this.a.g.setSelected(true);
            this.a.h.setSelected(false);
            q.b();
            return;
        }
        this.a.g.setSelected(false);
        this.a.h.setSelected(true);
        q.a();
    }
}
