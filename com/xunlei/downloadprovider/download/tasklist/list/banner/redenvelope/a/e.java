package com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.tasklist.list.banner.redenvelope.a;

/* compiled from: RedEnvelopeBannerPresenter */
final class e implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ a b;

    e(a aVar, boolean z) {
        this.b = aVar;
        this.a = z;
    }

    public final void run() {
        a.a().c = false;
        if (this.b.a != null) {
            if (this.a) {
                this.b.a.c();
            } else {
                XLToast.showToast(BrothersApplication.getApplicationInstance(), "您已领取过该红包");
            }
        }
    }
}
