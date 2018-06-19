package com.xunlei.downloadprovider.homepage.category;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;

/* compiled from: ShortVideoCategoryActivity */
final class n extends OnScrollListener {
    final /* synthetic */ ShortVideoCategoryActivity a;

    n(ShortVideoCategoryActivity shortVideoCategoryActivity) {
        this.a = shortVideoCategoryActivity;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        ShortVideoCategoryActivity.a;
        this.a.i.a(i);
        this.a.j.a(i);
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        i = this.a.h.findFirstVisibleItemPosition();
        i2 = this.a.h.findLastVisibleItemPosition();
        int i3 = i2 - i;
        if (this.a.j.a()) {
            this.a.j.a(recyclerView, i, i2, this.a.g.getHeaderViewsCount());
            return;
        }
        recyclerView = ak.a().b(PlayerTag.HOME);
        if (recyclerView != null) {
            i2 = this.a.g.getHeaderViewsCount();
            int i4 = recyclerView.n;
            if (i4 < i - i2 || i4 >= (i + i3) - i2) {
                recyclerView.r();
            }
        }
    }
}
