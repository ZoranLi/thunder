package com.xunlei.downloadprovider.homepage.follow.ui;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView.b;

/* compiled from: FollowTabFragment */
final class s implements b {
    final /* synthetic */ FollowTabFragment a;

    s(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final void a() {
        FollowTabFragment.b(this.a);
    }

    public final void b() {
        if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance())) {
            FollowTabFragment.e(this.a);
            return;
        }
        this.a.g();
        this.a.c.a();
    }
}
