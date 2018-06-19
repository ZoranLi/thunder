package com.xunlei.downloadprovider.contentpublish.website.view;

import android.text.TextUtils;
import com.xunlei.downloadprovider.e.a.e;

/* compiled from: WebsiteCardView */
final class d implements e {
    final /* synthetic */ a a;

    d(a aVar) {
        this.a = aVar;
    }

    public final void a(String str, int i) {
        if (!(this.a.v == null || TextUtils.equals(str, this.a.v.a) == null)) {
            this.a.v.k = i + 1;
            this.a.v.j = true;
            this.a.setLikeCountAndState(this.a.v);
        }
    }
}
