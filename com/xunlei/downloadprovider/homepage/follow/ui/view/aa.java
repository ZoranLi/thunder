package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.follow.b.g;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: RecommendFollowListBaseView */
final class aa implements OnClickListener {
    final /* synthetic */ g a;
    final /* synthetic */ y b;

    aa(y yVar, g gVar) {
        this.b = yVar;
        this.a = gVar;
    }

    public final void onClick(View view) {
        LoginHelper.a();
        if (l.c()) {
            y.a(this.b, this.a);
            return;
        }
        y.a(this.b, null, false, "skip_login", "");
        LoginHelper.a().a(view.getContext(), new ab(this), LoginFrom.FOLLOW_TAB, null);
    }
}
