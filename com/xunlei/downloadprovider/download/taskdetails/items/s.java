package com.xunlei.downloadprovider.download.taskdetails.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.web.website.g.b;

/* compiled from: DetailWebSourceInfoViewHolder */
final class s implements OnClickListener {
    final /* synthetic */ q a;

    s(q qVar) {
        this.a = qVar;
    }

    public final void onClick(View view) {
        this.a.m = b.a().a(this.a.k);
        if (this.a.m != null) {
            b.a().a(this.a.k, "dl_center_detail", "click_star", new t(this));
        } else {
            b.a().a(this.a.k, this.a.l.mWebsiteName, "", "dl_center_detail", new u(this));
        }
    }
}
