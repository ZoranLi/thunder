package com.xunlei.downloadprovider.contentpublish.website;

import android.text.TextUtils;
import com.xunlei.downloadprovider.e.a.e;

/* compiled from: WebsiteDetailFragment */
final class o implements e {
    final /* synthetic */ WebsiteDetailFragment a;

    o(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void a(String str, int i) {
        if (!(this.a.i == null || TextUtils.equals(str, this.a.i.a) == null)) {
            this.a.i.k = i + 1;
            this.a.i.j = true;
            this.a.y.b(this.a.A);
            this.a.U.setSelected(true);
        }
    }
}
