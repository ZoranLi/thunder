package com.xunlei.downloadprovider.contentpublish.website.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteDetailActivity;

/* compiled from: WebsiteCardView */
final class f implements OnClickListener {
    final /* synthetic */ a a;

    f(a aVar) {
        this.a = aVar;
    }

    public final void onClick(View view) {
        if (a.d(this.a)) {
            WebsiteDetailActivity.a(view.getContext(), this.a.w, this.a.v, this.a.r.k());
            this.a.r.a();
        }
    }
}
