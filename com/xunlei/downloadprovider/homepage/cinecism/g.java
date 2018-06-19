package com.xunlei.downloadprovider.homepage.cinecism;

import android.view.View;
import android.view.View.OnClickListener;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.personal.user.ReportActivity;
import org.android.agoo.common.AgooConstants;

/* compiled from: CinecismDetailActivity */
final class g implements OnClickListener {
    final /* synthetic */ CinecismDetailActivity a;

    g(CinecismDetailActivity cinecismDetailActivity) {
        this.a = cinecismDetailActivity;
    }

    public final void onClick(View view) {
        this.a.i.dismiss();
        view = this.a.i.a;
        if (view == null) {
            throw new IllegalStateException("comment target is null, call method setTargetComment First");
        }
        ReportActivity.a(this.a, 8, view.getId(), this.a.f.a, this.a.e, DispatchConstants.OTHER);
        String h = this.a.e;
        String m = this.a.c();
        long id = view.getId();
        LoginHelper.a();
        z.a(h, m, id, l.b(), AgooConstants.MESSAGE_REPORT);
    }
}
