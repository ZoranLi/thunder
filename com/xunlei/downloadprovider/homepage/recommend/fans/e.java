package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;

/* compiled from: BaseRecyViewFragment */
final class e extends OnScrollListener {
    final /* synthetic */ BaseRecyViewFragment a;

    e(BaseRecyViewFragment baseRecyViewFragment) {
        this.a = baseRecyViewFragment;
    }

    public final void onScrollStateChanged(RecyclerView recyclerView, int i) {
        super.onScrollStateChanged(recyclerView, i);
        if (this.a.e != null) {
            recyclerView = ak.a().b(PlayerTag.TOPIC_COLLECT);
            if (this.a.e.a() || recyclerView == null || recyclerView.l() == null) {
                this.a.e.a(i);
            } else {
                this.a.e.b = i;
            }
        }
    }

    public final void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        if (this.a.e != 0) {
            i = ((LinearLayoutManager) this.a.c.getLayoutManager()).findFirstVisibleItemPosition();
            i2 = (((LinearLayoutManager) this.a.c.getLayoutManager()).findLastVisibleItemPosition() - i) + 1;
            int itemCount = this.a.c.getLayoutManager().getItemCount();
            StringBuilder stringBuilder = new StringBuilder("firstVisibleItem=");
            stringBuilder.append(i);
            stringBuilder.append(",visibleItemCount=");
            stringBuilder.append(i2);
            stringBuilder.append(",totalItemCount=");
            stringBuilder.append(itemCount);
            if (this.a.e.a()) {
                this.a.e.a(recyclerView, i, i2, 0);
                return;
            }
            recyclerView = ak.a().b(PlayerTag.TOPIC_COLLECT);
            if (!(recyclerView == null || recyclerView.h.b || recyclerView.i())) {
                itemCount = recyclerView.n;
                if (itemCount < i + 0 || itemCount >= (i + i2) - 0) {
                    recyclerView.r();
                }
            }
        }
    }
}
