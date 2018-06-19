package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;

/* compiled from: BaseListFragment */
final class a implements OnScrollListener {
    final /* synthetic */ BaseListFragment a;

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    a(BaseListFragment baseListFragment) {
        this.a = baseListFragment;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.a.b.getMode() == Mode.DISABLED) {
            absListView = this.a.c.getCount() - 1;
            int lastVisiblePosition = this.a.b.getLastVisiblePosition() - 1;
            if (((i == 0 && lastVisiblePosition == absListView) || lastVisiblePosition == absListView - 1) && this.a.k() != null) {
                this.a.g();
            }
        }
    }
}
