package com.xunlei.downloadprovider.homepage.follow.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.xllib.android.b;

/* compiled from: FollowTabFragment */
final class v implements OnClickListener {
    final /* synthetic */ FollowTabFragment a;

    v(FollowTabFragment followTabFragment) {
        this.a = followTabFragment;
    }

    public final void onClick(View view) {
        if (b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.g.setVisibility(8);
            this.a.c.d();
        }
    }
}
