package com.xunlei.downloadprovider.homepage.cinecism;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CinecismDetailActivity */
final class u implements OnClickListener {
    final /* synthetic */ CinecismDetailActivity a;

    u(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void onClick(View view) {
        this.a.onBackPressed();
        if (this.a.g() == null) {
            z.b(this.a.e, this.a.c(), "return");
        }
    }
}
