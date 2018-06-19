package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.ad.common.b.a;

/* compiled from: DetailBannerAdViewHolder */
final class d implements OnClickListener {
    final /* synthetic */ b a;

    d(b bVar) {
        this.a = bVar;
    }

    public final void onClick(View view) {
        view = this.a.a;
        if (view.a.c != null) {
            view.a.c.a(new a("manual"));
        }
        view.a.b = true;
        view.j_();
    }
}
