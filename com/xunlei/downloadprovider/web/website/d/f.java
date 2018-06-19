package com.xunlei.downloadprovider.web.website.d;

import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.engine.report.a;
import com.xunlei.downloadprovider.web.website.g.b;
import com.xunlei.xllib.android.XLIntent;

/* compiled from: CollectionTipDialog */
final class f implements OnClickListener {
    final /* synthetic */ e a;

    f(e eVar) {
        this.a = eVar;
    }

    public final void onClick(View view) {
        this.a.dismiss();
        view = "web_dl_create";
        if ("bho".equals(this.a.a)) {
            view = "dl_waibu_create";
        }
        b.a().a(this.a.g, this.a.h, this.a.l, view, this.a.m);
        a.a(this.a.g, "collect", this.a.a);
        view = new XLIntent("com.xunlei.downloadprovider.web.website.fragment.CollectionAndHistoryFragment");
        if (this.a.b != null) {
            LocalBroadcastManager.getInstance(this.a.b).sendBroadcast(view);
        }
    }
}
