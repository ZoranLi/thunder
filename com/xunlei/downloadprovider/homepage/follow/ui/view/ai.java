package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.follow.b.a;

/* compiled from: RecommendFollowLiveView */
final class ai implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ RecommendFollowLiveView b;

    ai(RecommendFollowLiveView recommendFollowLiveView, a aVar) {
        this.b = recommendFollowLiveView;
        this.a = aVar;
    }

    public final void onClick(View view) {
        this.b.a((Context) view.getContext(), this.a);
    }
}
