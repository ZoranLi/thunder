package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView.b;

/* compiled from: FollowFragment */
final class c implements b {
    final /* synthetic */ FollowFragment a;

    public final void a() {
    }

    c(FollowFragment followFragment) {
        this.a = followFragment;
    }

    public final void b() {
        if (com.xunlei.xllib.android.b.a(this.a.getContext())) {
            this.a.a(this.a.g);
        } else {
            XLToast.showToast(this.a.getContext(), this.a.getString(R.string.net_disable));
        }
    }
}
