package com.xunlei.downloadprovider.homepage.cinecism;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: CinecismDetailActivity */
final class c implements OnClickListener {
    final /* synthetic */ CinecismDetailActivity a;

    c(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void onClick(View view) {
        if (this.a.g() == null) {
            view = this.a.j.b;
            if (!r.a().a(this.a, LoginFrom.CINECISM_DETAIL_DISCUSS, this.a.y)) {
                CinecismDetailActivity.q(this.a);
            }
            int i = 0;
            long j = 0;
            if (view != null) {
                i = 1;
                j = view.getId();
            }
            int i2 = i;
            long j2 = j;
            String h = this.a.e;
            boolean l = LoginHelper.a().l();
            LoginHelper.a();
            z.a(i2, h, j2, l, l.b());
        }
    }
}
