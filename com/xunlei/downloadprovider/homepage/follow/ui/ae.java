package com.xunlei.downloadprovider.homepage.follow.ui;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: MyFollowingActivity */
final class ae implements OnClickListener {
    final /* synthetic */ MyFollowingActivity a;

    ae(MyFollowingActivity myFollowingActivity) {
        this.a = myFollowingActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
