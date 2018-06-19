package com.xunlei.downloadprovider.homepage.choiceness;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.contentpublish.website.view.n;
import com.xunlei.downloadprovider.f.a;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.web.BrowserFrom;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: ChoicenessWebsiteReportStrategy */
public final class m extends n<com.xunlei.downloadprovider.homepage.choiceness.a.a.n> {
    public final String h() {
        return "home_choiceness";
    }

    public final String i() {
        return DispatchConstants.OTHER;
    }

    public final String k() {
        return "home_collect_card";
    }

    public final String l() {
        return "home_collect_carddiscuss";
    }

    public final void a(ShareOperationType shareOperationType, String str, String str2) {
        if (shareOperationType == ShareOperationType.REPORT) {
            ChoicenessReporter.a(str, "jubao", "home_collect");
        } else {
            ChoicenessReporter.b((e) this.a, str2, "web_url");
        }
    }

    public final BrowserFrom j() {
        return BrowserFrom.HOME_COLLECT_URL;
    }

    public final From m() {
        return From.HOMEPAGE;
    }

    public final void a() {
        ChoicenessReporter.a((com.xunlei.downloadprovider.homepage.choiceness.a.a.n) this.a, "detail");
    }

    public final void b() {
        ChoicenessReporter.a((com.xunlei.downloadprovider.homepage.choiceness.a.a.n) this.a, "websize");
    }

    public final void c() {
        ChoicenessReporter.a(((com.xunlei.downloadprovider.homepage.choiceness.a.a.n) this.a).b.getKind(), "web_url");
    }

    public final void d() {
        ChoicenessReporter.a((e) this.a, "", "web_url");
    }

    public final void e() {
        com.xunlei.downloadprovider.homepage.choiceness.a.a.n nVar = (com.xunlei.downloadprovider.homepage.choiceness.a.a.n) this.a;
        LoginHelper.a();
        ChoicenessReporter.a(nVar, nVar.b, "web_url", l.c(), false);
    }

    public final void a(String str, String str2) {
        com.xunlei.downloadprovider.homepage.choiceness.a.a.n nVar = (com.xunlei.downloadprovider.homepage.choiceness.a.a.n) this.a;
        LoginHelper.a();
        ChoicenessReporter.a(nVar, nVar.b, "web_url", l.c(), str, str2, 0);
    }

    public final void f() {
        ChoicenessReporter.a((e) this.a, "web_url");
    }

    public final void g() {
        ChoicenessReporter.a((e) this.a, false, "web_url");
    }

    public final void a(int i, ShareOperationType shareOperationType) {
        ChoicenessReporter.a((e) this.a, shareOperationType.getReportShareTo(), a.a(i), i, false, "web_url");
    }
}
