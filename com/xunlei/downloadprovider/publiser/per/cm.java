package com.xunlei.downloadprovider.publiser.per;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.publiser.visitors.VisitActivity;

/* compiled from: PublisherActivity */
final class cm implements OnClickListener {
    final /* synthetic */ PublisherActivity a;

    cm(PublisherActivity publisherActivity) {
        this.a = publisherActivity;
    }

    public final void onClick(View view) {
        view = LoginHelper.a();
        if (l.c() && this.a.k == view.g.c()) {
            VisitActivity.a(this.a, this.a.k, this.a.l, this.a.m, "personal_space_visit");
        } else {
            XLToast.showToast(this.a, "暂未开放，敬请期待");
        }
    }
}
