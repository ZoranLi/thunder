package com.xunlei.downloadprovider.ad.feedvideo;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: FeedVideoADItemView */
final class i implements OnClickListener {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public final void onClick(View view) {
        if (this.a.n) {
            this.a.a(false);
        } else {
            h.a(this.a, view);
        }
    }
}
