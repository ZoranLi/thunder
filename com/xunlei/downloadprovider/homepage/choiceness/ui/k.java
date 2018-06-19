package com.xunlei.downloadprovider.homepage.choiceness.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;

/* compiled from: HomeChoicenessFragment */
final class k extends OnScrollListener {
    final /* synthetic */ HomeChoicenessFragment a;

    k(HomeChoicenessFragment homeChoicenessFragment) {
        this.a = homeChoicenessFragment;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (this.a.getUserVisibleHint() != null) {
            this.a.f.a(i);
            this.a.g.a(i);
        }
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        i = this.a.e.findFirstVisibleItemPosition();
        i2 = this.a.e.findLastVisibleItemPosition();
        int i3 = i2 - i;
        if (this.a.getUserVisibleHint()) {
            if (this.a.g.a()) {
                this.a.g.a(recyclerView, i, i2, this.a.c.getHeaderViewsCount());
                return;
            }
            recyclerView = ak.a().b(PlayerTag.HOME);
            if (recyclerView != null) {
                i2 = this.a.c.getHeaderViewsCount();
                int i4 = recyclerView.n;
                if (i4 < i - i2 || i4 >= (i + i3) - i2) {
                    recyclerView.r();
                }
            }
        }
    }
}
