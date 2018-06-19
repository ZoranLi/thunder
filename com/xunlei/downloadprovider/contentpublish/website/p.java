package com.xunlei.downloadprovider.contentpublish.website;

import android.text.TextUtils;
import com.xunlei.downloadprovider.contentpublish.website.WebsiteDetailFragment.a;
import com.xunlei.downloadprovider.homepage.follow.aa;
import java.util.List;

/* compiled from: WebsiteDetailFragment */
final class p implements aa {
    final /* synthetic */ WebsiteDetailFragment a;

    p(WebsiteDetailFragment websiteDetailFragment) {
        this.a = websiteDetailFragment;
    }

    public final void a(boolean z, List<String> list) {
        if (list != null) {
            if (!list.isEmpty()) {
                CharSequence uid = this.a.al.getUid();
                if (!(TextUtils.isEmpty(uid) || list.contains(uid) == null)) {
                    if (z) {
                        this.a.j.c = true;
                        this.a.j.a = true;
                    } else {
                        this.a.j.a = false;
                        this.a.j.c = false;
                    }
                    ((a) this.a.mActivity).a(this.a.j);
                }
            }
        }
    }
}
