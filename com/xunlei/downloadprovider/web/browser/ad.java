package com.xunlei.downloadprovider.web.browser;

import com.xunlei.downloadprovider.f.a;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.downloadprovidershare.a.f;
import com.xunlei.downloadprovidershare.k;

/* compiled from: BrowserShareHelper */
final class ad implements k {
    final /* synthetic */ ab a;

    ad(ab abVar) {
        this.a = abVar;
    }

    public final void onShareTargetClicked(ShareOperationType shareOperationType, f fVar) {
        if (shareOperationType == ShareOperationType.MAIN_PAGE && r.a().a(this.a.a, LoginFrom.BROWSER_WEBSITE_SHARE, this.a.d) == null) {
            ab.a(this.a);
        }
        aa.a(this.a.c, shareOperationType.getReportShareTo(), this.a.b);
    }

    public final void onShareComplete(int i, ShareOperationType shareOperationType, f fVar) {
        aa.a(this.a.b, this.a.c, shareOperationType.getReportShareTo(), a.a(i));
    }
}
