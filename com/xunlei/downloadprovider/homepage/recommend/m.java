package com.xunlei.downloadprovider.homepage.recommend;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ak;

/* compiled from: SummaryMoviesFeedView */
final class m implements OnScrollListener {
    final /* synthetic */ b a;

    m(b bVar) {
        this.a = bVar;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        absListView = this.a.a;
        if (absListView.a() && absListView.a != i) {
            absListView.b();
        }
        absListView.a = i;
        absListView = ak.a().b(PlayerTag.FEED);
        if (this.a.l.a() || absListView == null || absListView.l() == null) {
            this.a.l.a(i);
        } else {
            this.a.l.b = i;
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.a.d.getUserVisibleHint() != 0) {
            i3 = ak.a().b(PlayerTag.FEED);
            if (i3 == 0 || (!i3.h.b && i3.i() == 0)) {
                this.a.l.a(absListView, i, i2, ((ListView) this.a.g.getRefreshableView()).getHeaderViewsCount());
            }
        }
    }
}
