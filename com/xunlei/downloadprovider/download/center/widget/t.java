package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCreateMoreTaskDialog */
final class t implements OnClickListener {
    final /* synthetic */ p a;

    t(p pVar) {
        this.a = pVar;
    }

    public final void onClick(View view) {
        a.h("newbt");
        p.c(this.a);
        this.a.dismiss();
    }
}
