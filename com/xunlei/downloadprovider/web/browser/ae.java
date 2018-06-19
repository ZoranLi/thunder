package com.xunlei.downloadprovider.web.browser;

import com.xunlei.downloadprovider.web.browser.ab.a;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: BrowserShareHelper */
final class ae implements a {
    final /* synthetic */ ab a;

    ae(ab abVar) {
        this.a = abVar;
    }

    public final void a(int i) {
        aa.a(this.a.b, this.a.c, ShareOperationType.MAIN_PAGE.getReportShareTo(), com.xunlei.downloadprovider.f.a.a(i));
    }
}
