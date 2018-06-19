package com.xunlei.downloadprovider.personal.a.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.recommend.fans.FansActivity;

/* compiled from: UserInfoViewHolder */
final class u implements OnClickListener {
    final /* synthetic */ s a;

    u(s sVar) {
        this.a = sVar;
    }

    public final void onClick(View view) {
        FansActivity.a(this.a.X, this.a.W.g.c(), "per_cl");
    }
}
