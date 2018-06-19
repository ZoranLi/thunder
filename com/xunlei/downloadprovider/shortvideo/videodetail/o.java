package com.xunlei.downloadprovider.shortvideo.videodetail;

import com.xunlei.downloadprovider.R;
import com.xunlei.downloadprovider.web.base.core.ObservableWebView.a;

/* compiled from: LongVideoDetailActivity */
final class o implements a {
    final /* synthetic */ LongVideoDetailActivity a;

    o(LongVideoDetailActivity longVideoDetailActivity) {
        this.a = longVideoDetailActivity;
    }

    public final void a(int i) {
        float f = 0.0f;
        if (!this.a.j) {
            if (!this.a.k) {
                int e = this.a.l - this.a.a.getHeight();
                int i2 = e / 2;
                if (i >= e) {
                    f = 1.0f;
                } else if (i >= i2) {
                    f = 1.0f - (((float) (e - i)) / ((float) (e - i2)));
                }
                LongVideoDetailActivity.a(this.a, f);
                return;
            }
        }
        LongVideoDetailActivity.a(this.a, 1.0f);
        if (this.a.k != 0) {
            LongVideoDetailActivity.a(this.a, 0.0f);
            this.a.c.setImageResource(R.drawable.commonui_nav_arrow_back_selector);
        }
    }
}
