package com.xunlei.downloadprovider.contentpublish.website.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteInfo;
import com.xunlei.downloadprovider.e.a.d;
import com.xunlei.downloadprovider.e.a.f;

/* compiled from: WebsiteCardView */
final class c implements OnClickListener {
    final /* synthetic */ WebsiteInfo a;
    final /* synthetic */ a b;

    c(a aVar, WebsiteInfo websiteInfo) {
        this.b = aVar;
        this.a = websiteInfo;
    }

    public final void onClick(View view) {
        if (a.d(this.b) != null && this.a.j == null) {
            this.b.k.a();
            view = new d(this.a.a, "", this.a.k);
            view.a = 5;
            view.e = false;
            f.a().a(this.b.getContext(), view, null);
            this.b.r.d();
        }
    }
}
