package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.follow.b.a;

/* compiled from: RecommendFollowView */
final class aj implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ RecommendFollowView b;

    aj(RecommendFollowView recommendFollowView, a aVar) {
        this.b = recommendFollowView;
        this.a = aVar;
    }

    public final void onClick(View view) {
        this.b.b(this.a);
    }
}
