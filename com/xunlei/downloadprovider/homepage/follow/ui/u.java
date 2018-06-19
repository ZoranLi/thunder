package com.xunlei.downloadprovider.homepage.follow.ui;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;

/* compiled from: FollowTabFragment */
final class u extends OnScrollListener {
    final /* synthetic */ FollowTabFragment a;

    u(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        recyclerView = ak.a().b(PlayerTag.FOLLOW_TAB);
        if (this.a.f.a() || recyclerView == null || recyclerView.l() == null) {
            this.a.f.a(i);
        } else {
            this.a.f.b = i;
        }
        if (this.a.e != null) {
            this.a.e.a(i);
        }
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        i = ((LinearLayoutManager) this.a.c.getLayoutManager()).findFirstVisibleItemPosition();
        i2 = (((LinearLayoutManager) this.a.c.getLayoutManager()).findLastVisibleItemPosition() - i) + 1;
        int itemCount = this.a.c.getLayoutManager().getItemCount();
        StringBuilder stringBuilder = new StringBuilder("firstVisibleItem=");
        stringBuilder.append(i);
        stringBuilder.append(",visibleItemCount=");
        stringBuilder.append(i2);
        stringBuilder.append(",totalItemCount=");
        stringBuilder.append(itemCount);
        if (this.a.f.a()) {
            this.a.f.a(recyclerView, i, i2, 0);
            return;
        }
        recyclerView = ak.a().b(PlayerTag.FOLLOW_TAB);
        if (!(recyclerView == null || recyclerView.h.b || recyclerView.i())) {
            itemCount = recyclerView.n;
            if (itemCount < i + 0 || itemCount >= (i + i2) - 0) {
                recyclerView.r();
            }
        }
    }
}
