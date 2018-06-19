package com.xunlei.downloadprovider.homepage.cinecism;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CinecismDetailActivity */
final class w implements OnClickListener {
    final /* synthetic */ CinecismDetailActivity a;

    w(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void onClick(View view) {
        if (this.a.g() == null) {
            this.a.a(this.a.getResources().getString(this.a.x));
            z.b(this.a.e, this.a.c(), "input");
            this.a.j.a(null);
        }
    }
}
