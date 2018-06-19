package com.xunlei.downloadprovider.search.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.search.b.i;
import com.xunlei.downloadprovider.search.c.a;

/* compiled from: MultiSearchAdapter */
final class x implements OnClickListener {
    final /* synthetic */ ai a;
    final /* synthetic */ o b;

    x(o oVar, ai aiVar) {
        this.b = oVar;
        this.a = aiVar;
    }

    public final void onClick(View view) {
        i.a().a(this.b.c, 1);
        m.a(this.b.b, Long.valueOf(this.a.g).longValue(), this.a.h, this.a.b, "", From.SEARCH_NOW_CHANNEL);
        a.a("channelflow");
    }
}
