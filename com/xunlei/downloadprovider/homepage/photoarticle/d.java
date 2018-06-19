package com.xunlei.downloadprovider.homepage.photoarticle;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.authphone.r;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: PhotoArticleDetailActivity */
final class d implements OnClickListener {
    final /* synthetic */ PhotoArticleDetailActivity a;

    d(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void onClick(View view) {
        if (this.a.c() == null) {
            long j;
            view = this.a.o.b;
            if (!r.a().a(this.a, LoginFrom.NEWS_DETAIL_DISCUSS, this.a.J)) {
                PhotoArticleDetailActivity.p(this.a);
            }
            if (view == null) {
                j = -1;
            } else {
                j = view.getId();
            }
            view = this.a.f;
            LoginHelper.a();
            boolean b = l.b();
            int i = j >= 0 ? 1 : 0;
            StatEvent build = HubbleEventBuilder.build("android_newsdetail", "newsDetail_discuss_submit");
            build.add("news_id", view);
            build.add("discussid", j);
            build.add("is_login", b);
            build.add("level", i);
            y.a(build);
        }
    }
}
