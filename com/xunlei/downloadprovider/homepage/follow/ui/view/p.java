package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.follow.ad;
import com.xunlei.downloadprovider.homepage.follow.ui.MyFollowingActivity;

/* compiled from: MyFollowingTitleViewHolder */
final class p implements OnClickListener {
    final /* synthetic */ o a;

    p(o oVar) {
        this.a = oVar;
    }

    public final void onClick(View view) {
        MyFollowingActivity.a(view.getContext());
        ad.a("my_follow");
    }
}
