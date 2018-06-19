package com.xunlei.downloadprovider.shortvideo.videodetail.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: ShortMoviePublisherInfoView */
final class l implements OnClickListener {
    final /* synthetic */ ShortMoviePublisherInfoView a;

    l(ShortMoviePublisherInfoView shortMoviePublisherInfoView) {
        this.a = shortMoviePublisherInfoView;
    }

    public final void onClick(View view) {
        if (this.a.j == null && this.a.g != null) {
            this.a.b.a(this.a.a, 18, this.a.g);
        }
    }
}
