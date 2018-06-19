package com.xunlei.downloadprovider.shortvideo.videodetail;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.web.base.core.CustomWebView.c;

/* compiled from: LongVideoDetailActivity */
final class m implements c {
    final /* synthetic */ LongVideoDetailActivity a;

    m(LongVideoDetailActivity longVideoDetailActivity) {
        this.a = longVideoDetailActivity;
    }

    public final void a(boolean z) {
        this.a.k = z;
        if (this.a.j) {
            LongVideoDetailActivity.a(this.a, 1.0f);
            return;
        }
        LongVideoDetailActivity.a(this.a, 0.0f);
        if (z) {
            this.a.c.setImageResource(R.drawable.commonui_nav_arrow_back_selector);
        }
    }
}
