package com.xunlei.downloadprovider.publiser.per;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;

/* compiled from: HistoryPublishItemFragment */
final class at extends OnScrollListener {
    final /* synthetic */ HistoryPublishItemFragment a;

    at(HistoryPublishItemFragment historyPublishItemFragment) {
        this.a = historyPublishItemFragment;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        this.a.k.b(i);
        recyclerView = ak.a().b(PlayerTag.PERSONAL);
        if (this.a.o.a() || recyclerView == null || recyclerView.l() == null) {
            this.a.o.a(i);
        } else {
            this.a.o.b = i;
        }
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        i = ((LinearLayoutManager) this.a.h.getLayoutManager()).findFirstVisibleItemPosition();
        i2 = (((LinearLayoutManager) this.a.h.getLayoutManager()).findLastVisibleItemPosition() - i) + 1;
        int itemCount = this.a.h.getLayoutManager().getItemCount();
        StringBuilder stringBuilder = new StringBuilder("firstVisibleItem=");
        stringBuilder.append(i);
        stringBuilder.append(",visibleItemCount=");
        stringBuilder.append(i2);
        stringBuilder.append(",totalItemCount=");
        stringBuilder.append(itemCount);
        if (this.a.o.a()) {
            this.a.o.a(recyclerView, i, i2, 0);
            return;
        }
        recyclerView = ak.a().b(PlayerTag.PERSONAL);
        if (!(recyclerView == null || recyclerView.h.b || recyclerView.i())) {
            itemCount = recyclerView.n;
            if (itemCount < i + 0 || itemCount >= (i + i2) - 0) {
                recyclerView.r();
            }
        }
    }
}
