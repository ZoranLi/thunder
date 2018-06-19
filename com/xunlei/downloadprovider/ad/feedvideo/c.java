package com.xunlei.downloadprovider.ad.feedvideo;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.xllib.android.b;

/* compiled from: FeedGDTVideoItemView */
final class c implements OnClickListener {
    final /* synthetic */ FeedGDTVideoItemView a;

    c(FeedGDTVideoItemView feedGDTVideoItemView) {
        this.a = feedGDTVideoItemView;
    }

    public final void onClick(View view) {
        view = this.a;
        boolean z = b.e(this.a.getContext()) && !FeedGDTVideoItemView.f(this.a);
        FeedGDTVideoItemView.a(view, z);
    }
}
