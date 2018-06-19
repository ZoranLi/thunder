package com.xunlei.downloadprovider.web.browser;

import android.widget.PopupWindow;
import com.xunlei.common.androidutil.DipPixelUtil;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.contentpublish.website.a.m;
import com.xunlei.downloadprovider.h.f;
import com.xunlei.downloadprovider.web.website.g.b;

/* compiled from: BrowserActivity */
final class j implements Runnable {
    final /* synthetic */ BrowserActivity a;

    j(BrowserActivity browserActivity) {
        this.a = browserActivity;
    }

    public final void run() {
        boolean b = f.b(BrothersApplication.getApplicationInstance(), "browser_collect_bottom_toast");
        if (!(b.a().a(this.a.m.g()) || !m.a().d(this.a.m.g()) || b || this.a.m == null)) {
            BrowserToolBarFragment k = this.a.q;
            if (k.isVisible()) {
                if (k.isResumed()) {
                    PopupWindow yVar = new y(k.getActivity());
                    int[] iArr = new int[2];
                    k.b.getLocationOnScreen(iArr);
                    yVar.showAtLocation(k.b, 0, (iArr[0] - DipPixelUtil.dip2px(46.0f)) + (k.b.getWidth() / 2), iArr[1] - (k.b.getHeight() / 2));
                    f.a(BrothersApplication.getApplicationInstance(), "browser_collect_bottom_toast", true);
                }
            }
        }
    }
}
