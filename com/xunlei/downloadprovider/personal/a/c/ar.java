package com.xunlei.downloadprovider.personal.a.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.recommend.fans.FollowActivity;

/* compiled from: UserInfoViewHolder */
final class ar implements OnClickListener {
    final /* synthetic */ s a;

    ar(s sVar) {
        this.a = sVar;
    }

    public final void onClick(View view) {
        FollowActivity.a(this.a.X, this.a.W.g.c(), "per_cl");
    }
}
