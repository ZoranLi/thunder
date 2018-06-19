package com.xunlei.downloadprovider.contentpublish.website;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.contentpublish.website.a.a;
import com.xunlei.xllib.b.k;

/* compiled from: WebsiteDetailActivity */
final class c implements OnClickListener {
    final /* synthetic */ WebsiteDetailActivity a;

    c(WebsiteDetailActivity websiteDetailActivity) {
        this.a = websiteDetailActivity;
    }

    public final void onClick(View view) {
        String str = this.a.l.a;
        String a = k.a(this.a.l.f, "UTF-8");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.j.getUid());
        a.b("detail_news_top", str, a, stringBuilder.toString());
        this.a.k.b("detail_news_top");
    }
}
