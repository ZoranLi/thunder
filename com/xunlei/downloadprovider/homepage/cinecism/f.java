package com.xunlei.downloadprovider.homepage.cinecism;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.xllib.android.b;

/* compiled from: CinecismDetailActivity */
final class f implements OnClickListener {
    final /* synthetic */ CinecismDetailActivity a;

    f(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void onClick(View view) {
        this.a.i.dismiss();
        if (b.a(this.a) == null) {
            XLToast.showNoNetworkToast(this.a);
            return;
        }
        view = this.a.i.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        this.a.h.a(view.getId());
        String h = this.a.e;
        String m = this.a.c();
        long id = view.getId();
        LoginHelper.a();
        z.a(h, m, id, l.b(), "delete");
    }
}
