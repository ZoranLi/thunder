package com.xunlei.downloadprovider.homepage.recommend.fans;

import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.e;

/* compiled from: BaseListFragment */
final class b implements e<ListView> {
    final /* synthetic */ BaseListFragment a;

    public final void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
    }

    b(BaseListFragment baseListFragment) {
        this.a = baseListFragment;
    }

    public final void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
        this.a.g();
    }
}
