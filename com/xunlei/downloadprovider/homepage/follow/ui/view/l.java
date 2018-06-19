package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.follow.b.a;

/* compiled from: FollowingViewHolder */
final class l implements OnClickListener {
    final /* synthetic */ ap a;
    final /* synthetic */ k b;

    l(k kVar, ap apVar) {
        this.b = kVar;
        this.a = apVar;
    }

    public final void onClick(View view) {
        this.b.g.postDelayed(new m(this), 300);
        k.a(this.b, (a) this.a.b);
    }
}
