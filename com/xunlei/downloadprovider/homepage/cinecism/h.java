package com.xunlei.downloadprovider.homepage.cinecism;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: CinecismDetailActivity */
final class h implements OnClickListener {
    final /* synthetic */ CinecismDetailActivity a;

    h(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void onClick(View view) {
        this.a.i.dismiss();
        view = this.a.i.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        String h = this.a.e;
        String m = this.a.c();
        long id = view.getId();
        LoginHelper.a();
        z.a(h, m, id, l.b(), "cancel");
    }
}
