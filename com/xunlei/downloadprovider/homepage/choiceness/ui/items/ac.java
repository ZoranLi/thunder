package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;

/* compiled from: ChoicenessPhotoArticleView */
final class ac implements a {
    final /* synthetic */ y a;

    ac(y yVar) {
        this.a = yVar;
    }

    public final void a() {
        e a = this.a.d;
        VideoUserInfo videoUserInfo = this.a.d.b;
        String reportContentType = this.a.getReportContentType();
        LoginHelper.a();
        ChoicenessReporter.a(a, videoUserInfo, reportContentType, l.c(), "success", "", 0);
    }

    public final void a(String str) {
        e a = this.a.d;
        VideoUserInfo videoUserInfo = this.a.d.b;
        String reportContentType = this.a.getReportContentType();
        LoginHelper.a();
        ChoicenessReporter.a(a, videoUserInfo, reportContentType, l.c(), "fail", str, 0);
    }

    public final void a(boolean z) {
        ChoicenessReporter.a(this.a.d, this.a.d.b, this.a.getReportContentType(), z, false);
    }

    public final LoginFrom b() {
        return LoginFrom.HOME_COLLECT_NEWSFOLLOW;
    }
}
