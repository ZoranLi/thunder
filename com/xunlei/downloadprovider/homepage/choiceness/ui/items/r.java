package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView.a;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: ChoicenessLivestreamItemView */
final class r implements a {
    final /* synthetic */ ChoicenessLivestreamItemView a;

    r(ChoicenessLivestreamItemView choicenessLivestreamItemView) {
        this.a = choicenessLivestreamItemView;
    }

    public final void a() {
        ChoicenessReporter.a(this.a.b, this.a.b.E, this.a.getReportContentType(), true, "success", "", 0);
        if (this.a.e != null) {
            this.a.e.a(this.a.b);
        }
    }

    public final void a(String str) {
        ChoicenessReporter.a(this.a.b, this.a.b.E, this.a.getReportContentType(), true, "fail", str, 0);
    }

    public final void a(boolean z) {
        ChoicenessReporter.a(this.a.b, this.a.b.E, this.a.getReportContentType(), z, false);
    }

    public final LoginFrom b() {
        return LoginFrom.HOME_FOLLOW;
    }
}
