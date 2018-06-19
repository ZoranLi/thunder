package com.xunlei.downloadprovider.download.taskdetails.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.web.website.f.a;

/* compiled from: DetailWebSourceInfoViewHolder */
final class r implements OnClickListener {
    final /* synthetic */ q a;

    r(q qVar) {
        this.a = qVar;
    }

    public final void onClick(View view) {
        q.a("sniff_view_web", this.a.l);
        a.a("dl_center_detail", this.a.k, false);
        if (this.a.f != null && this.a.l != null) {
            view = this.a.f.b();
            if (view != null) {
                this.a.l;
                view.c();
            }
        }
    }
}
