package com.xunlei.downloadprovider.download.tasklist.list.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.q;

/* compiled from: VipRenewRemindViewHolder */
final class c implements OnClickListener {
    final /* synthetic */ a a;

    c(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        this.a.b();
        q.a("dl_center_top_close", "close", this.a.c(), this.a.h.l.a, this.a.m);
        this.a.a();
    }
}
