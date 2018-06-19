package com.xunlei.downloadprovider.homepage.cinecism;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CinecismDetailActivity */
final class v implements OnClickListener {
    final /* synthetic */ CinecismDetailActivity a;

    v(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void onClick(View view) {
        if (this.a.g() == null) {
            if (this.a.p != null) {
                this.a.p.a("javascript:window.comment_position()");
            }
            z.b(this.a.e, this.a.c(), "comment");
        }
    }
}
