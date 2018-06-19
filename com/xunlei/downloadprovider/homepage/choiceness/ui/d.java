package com.xunlei.downloadprovider.homepage.choiceness.ui;

import android.view.View;
import android.view.ViewGroup;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.shortvideo.videodetail.p;
import com.xunlei.downloadprovider.shortvideo.videodetail.widget.QuickCommentView.a;

/* compiled from: ChoicenessQuickCommentHelper */
final class d implements a {
    final /* synthetic */ ViewGroup a;
    final /* synthetic */ m b;
    final /* synthetic */ String c;
    final /* synthetic */ b d;

    d(b bVar, ViewGroup viewGroup, m mVar, String str) {
        this.d = bVar;
        this.a = viewGroup;
        this.b = mVar;
        this.c = str;
    }

    public final void a(View view, p pVar) {
        LoginHelper.a();
        if (l.c() != null) {
            b.a(this.d, this.a, this.b, pVar);
        } else {
            LoginHelper.a().a(this.d.a, new e(this, pVar), LoginFrom.HOME_FOLLOW, null);
        }
        LoginHelper.a();
        ChoicenessReporter.a(l.c(), this.b, pVar, this.c);
    }
}
