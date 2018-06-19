package com.xunlei.downloadprovider.personal.liked;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: LikeContentActivity */
final class g implements OnClickListener {
    final /* synthetic */ LikeContentActivity a;

    g(LikeContentActivity likeContentActivity) {
        this.a = likeContentActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
    }
}
