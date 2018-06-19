package com.xunlei.downloadprovider.search.ui.search;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.xunlei.common.concurrent.XLThreadPool;

/* compiled from: MultiSearchDetailCtr */
final class ag implements OnScrollListener {
    final /* synthetic */ af a;

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    ag(af afVar) {
        this.a = afVar;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i + i2 == i3) {
            a aVar = this.a;
            String str = this.a.f.c;
            af afVar = this.a;
            String str2 = this.a.g;
            int i4 = this.a.h;
            if (g.a == null) {
                if (g.b == null) {
                    g.a = true;
                    XLThreadPool.execute(new k(str, str2, i4, afVar, aVar));
                }
            }
        }
    }
}
