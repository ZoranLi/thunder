package com.xunlei.downloadprovider.vod.recordpublish;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.vod.recordpublish.topicsearch.a;

/* compiled from: XlpsHotTopicAdapter */
final class aa implements OnClickListener {
    final /* synthetic */ int a;
    final /* synthetic */ z b;

    aa(z zVar, int i) {
        this.b = zVar;
        this.a = i;
    }

    public final void onClick(View view) {
        if (this.b.a != null) {
            this.b.a.a((a) this.b.b.get(this.a));
        }
    }
}
