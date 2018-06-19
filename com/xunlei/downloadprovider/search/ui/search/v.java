package com.xunlei.downloadprovider.search.ui.search;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.search.b.i;
import com.xunlei.downloadprovider.search.c.a;

/* compiled from: MultiSearchAdapter */
final class v implements OnClickListener {
    final /* synthetic */ ak a;
    final /* synthetic */ o b;

    v(o oVar, ak akVar) {
        this.b = oVar;
        this.a = akVar;
    }

    public final void onClick(View view) {
        i.a().a(this.b.c, 1);
        m.a(this.b.b, Long.valueOf(this.a.a).longValue(), this.a.g, this.a.b, "", From.SEARCH_NOW_LINK);
        a.a("zhannei_channel");
    }
}
