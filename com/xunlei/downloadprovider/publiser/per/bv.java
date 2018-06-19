package com.xunlei.downloadprovider.publiser.per;

import android.support.v4.view.ViewPager.OnPageChangeListener;
import com.xunlei.downloadprovider.homepage.recommend.a;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;

/* compiled from: PublisherActivity */
final class bv implements OnPageChangeListener {
    final /* synthetic */ PublisherActivity a;

    public final void onPageScrollStateChanged(int i) {
    }

    public final void onPageScrolled(int i, float f, int i2) {
    }

    bv(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final void onPageSelected(int i) {
        this.a.S = true;
        long j = 0;
        boolean z = false;
        if (i == 0) {
            this.a.E.setSelected(true);
            this.a.F.setSelected(false);
            String str = "public";
            if (this.a.c <= 0) {
                z = true;
            }
            if (this.a.c > 0) {
                j = (long) this.a.c;
            }
            a.a(str, z, j);
            return;
        }
        this.a.E.setSelected(false);
        this.a.F.setSelected(true);
        ak.a().c(PlayerTag.PERSONAL);
        str = "active";
        if (this.a.a <= 0) {
            z = true;
        }
        if (this.a.a > 0) {
            j = (long) this.a.a;
        }
        a.a(str, z, j);
    }
}
