package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.member.login.b.c;

/* compiled from: ChoicenessRecommendUserView */
final class ah extends c {
    final /* synthetic */ ag a;

    ah(ag agVar) {
        this.a = agVar;
    }

    public final void onLoginCompleted(boolean z, int i, Object obj) {
        if (z) {
            b.a().a(Long.parseLong(this.a.a.a), true, new ai(this.a.c, this.a.b, this.a.a));
            return;
        }
        this.a.c.a((boolean) 0);
        XLToast.showToast(this.a.c.itemView.getContext(), "网络异常，请重试");
    }
}
