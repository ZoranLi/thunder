package com.xunlei.downloadprovider.homepage.photoarticle;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.xlui.recyclerview.XRecyclerView.c;
import com.xunlei.xllib.android.b;

/* compiled from: PhotoArticleDetailActivity */
final class u extends c {
    final /* synthetic */ PhotoArticleDetailActivity a;

    u(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void b() {
        if (b.a(this.a)) {
            PhotoArticleDetailActivity.h(this.a);
        } else {
            XLToast.showToast(this.a, this.a.getString(R.string.net_disable));
        }
    }
}
