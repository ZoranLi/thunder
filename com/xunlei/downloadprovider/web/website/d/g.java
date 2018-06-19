package com.xunlei.downloadprovider.web.website.d;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.engine.report.a;

/* compiled from: CollectionTipDialog */
final class g implements OnClickListener {
    final /* synthetic */ e a;

    g(e eVar) {
        this.a = eVar;
    }

    public final void onClick(View view) {
        this.a.dismiss();
        a.a(this.a.g, "cancel", this.a.a);
    }
}
