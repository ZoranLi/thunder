package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.l.a;
import com.xunlei.downloadprovider.homepage.follow.b;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: ChoicenessRecommendUserView */
final class ag implements OnClickListener {
    final /* synthetic */ a a;
    final /* synthetic */ int b;
    final /* synthetic */ b c;

    ag(b bVar, a aVar, int i) {
        this.c = bVar;
        this.a = aVar;
        this.b = i;
    }

    public final void onClick(View view) {
        LoginHelper.a();
        view = l.c();
        if (view != null) {
            b.a().a(Long.parseLong(this.a.a), true, new ai(this.c, this.b, this.a));
        } else {
            ChoicenessReporter.a(this.c.g.c, this.b + 1, this.a, false, false);
            LoginHelper.a().a(this.c.itemView.getContext(), new ah(this), LoginFrom.HOME_FOLLOW, null);
        }
        ChoicenessReporter.a(this.c.g.c, view, this.b + 1, this.a);
    }
}
