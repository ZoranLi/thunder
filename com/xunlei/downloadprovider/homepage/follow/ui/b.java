package com.xunlei.downloadprovider.homepage.follow.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.app.BrothersApplication;

/* compiled from: FollowFragment */
final class b implements OnClickListener {
    final /* synthetic */ FollowFragment a;

    b(FollowFragment followFragment) {
        this.a = followFragment;
    }

    public final void onClick(View view) {
        if (com.xunlei.xllib.android.b.a(BrothersApplication.getApplicationInstance()) != null) {
            this.a.c.setVisibility(8);
            this.a.a();
        }
    }
}
