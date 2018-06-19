package com.xunlei.downloadprovider.homepage.category;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.ui.r;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: CategoryPlayerViewReportStrategy */
public final class a extends r<m> {
    private String a;

    public final String e() {
        return "home_choiceness";
    }

    public final String g() {
        return "videotag_collect";
    }

    public final String j() {
        return "home_collect_shot";
    }

    public final String k() {
        return DispatchConstants.OTHER;
    }

    public a(String str) {
        this.a = str;
    }

    public final void a() {
        v.a(this.a, ((m) this.b).b(), ((m) this.b).a.getUid());
    }

    public final void a(String str) {
        v.a(this.a, ((m) this.b).b(), ((m) this.b).a.getUid(), str);
    }

    public final void a(boolean z) {
        v.c(this.a, ((m) this.b).b(), ((m) this.b).a.getUid(), ((m) this.b).a.getKind());
    }

    public final void a(String str, String str2, int i) {
        v.b(this.a, ((m) this.b).b(), ((m) this.b).a.getUid(), ((m) this.b).a.getKind(), str, str2);
    }

    public final void b() {
        v.c(this.a, ((m) this.b).b(), ((m) this.b).a.getUid());
    }

    public final void b(boolean z) {
        v.b(this.a, ((m) this.b).b(), ((m) this.b).a.getUid());
    }

    public final void a(int i, ShareOperationType shareOperationType, boolean z) {
        v.a(this.a, ((m) this.b).b(), ((m) this.b).a.getUid(), shareOperationType.getReportShareTo(), com.xunlei.downloadprovider.f.a.a(i), String.valueOf(i));
    }

    public final void a(ShareOperationType shareOperationType, String str, String str2) {
        if (shareOperationType == ShareOperationType.REPORT) {
            v.b(this.a, "jubao");
        } else {
            v.b(this.a, ((m) this.b).b(), ((m) this.b).a.getUid(), str2);
        }
    }

    public final From c() {
        return From.VIDEOTAG_COLLECT;
    }

    public final ShortMovieDetailActivity.From d() {
        return ShortMovieDetailActivity.From.VIDEOTAG_COLLECT;
    }

    public final String f() {
        return ShortMovieDetailActivity.From.VIDEOTAG_COLLECT.getText();
    }

    public final PlayerTag h() {
        return PlayerTag.HOME;
    }

    public final LoginFrom i() {
        return LoginFrom.VIDEOTAG_COLLECT_FOLLOW;
    }
}
