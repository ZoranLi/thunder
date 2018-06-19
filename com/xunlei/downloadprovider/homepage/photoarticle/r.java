package com.xunlei.downloadprovider.homepage.photoarticle;

import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.homepage.choiceness.ui.widget.FollowBtnView.a;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;

/* compiled from: PhotoArticleDetailActivity */
final class r implements a {
    final /* synthetic */ PhotoArticleDetailActivity a;

    r(PhotoArticleDetailActivity photoArticleDetailActivity) {
        this.a = photoArticleDetailActivity;
    }

    public final void a() {
        if (!this.a.c()) {
            y.a(this.a.f, this.a.h(), this.a.h.getKind(), true, "", "follow_button");
        }
    }

    public final void a(String str) {
        if (!this.a.c()) {
            y.a(this.a.f, this.a.h(), this.a.h.getKind(), false, str, "follow_button");
        }
    }

    public final void a(boolean z) {
        if (!this.a.c()) {
            z = this.a.f;
            String f = this.a.h();
            String kind = this.a.h.getKind();
            StatEvent build = HubbleEventBuilder.build("android_newsdetail", "newsDetail_follow_click");
            build.add("news_id", z);
            build.add("author_id", f);
            build.add("author_type", kind);
            build.add("position", "follow_button");
            y.a(build);
        }
    }

    public final LoginFrom b() {
        return LoginFrom.NEWS_DETAIL_FOLLOW;
    }
}
