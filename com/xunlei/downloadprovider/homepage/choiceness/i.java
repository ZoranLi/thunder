package com.xunlei.downloadprovider.homepage.choiceness;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.umeng.socialize.common.SocializeConstants;
import com.xunlei.downloadprovider.f.a;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.e;
import com.xunlei.downloadprovider.homepage.choiceness.a.a.m;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.ui.r;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: ChoicenessPlayerViewReportStrategy */
public final class i extends r<m> {
    public final String e() {
        return "home_choiceness";
    }

    public final String g() {
        return "home_page";
    }

    public final String j() {
        return "home_collect_shot";
    }

    public final String k() {
        return DispatchConstants.OTHER;
    }

    public final void a(ShareOperationType shareOperationType, String str, String str2) {
        if (shareOperationType == ShareOperationType.REPORT) {
            ChoicenessReporter.a(str, "jubao", "home_collect");
        } else {
            ChoicenessReporter.b((e) this.b, str2, "shortvideo");
        }
    }

    public final From c() {
        return From.HOMEPAGE;
    }

    public final ShortMovieDetailActivity.From d() {
        return ShortMovieDetailActivity.From.HOME_PAGE;
    }

    public final PlayerTag h() {
        return PlayerTag.HOME;
    }

    public final LoginFrom i() {
        return LoginFrom.HOME_FOLLOW;
    }

    public final void a() {
        ChoicenessReporter.b((e) this.b, SocializeConstants.KEY_PIC);
    }

    public final void a(String str) {
        ChoicenessReporter.a((e) this.b, str, "shortvideo");
    }

    public final void a(boolean z) {
        m mVar = (m) this.b;
        LoginHelper.a();
        ChoicenessReporter.a(mVar, mVar.a, "shortvideo", l.c(), z);
    }

    public final void a(String str, String str2, int i) {
        m mVar = (m) this.b;
        LoginHelper.a();
        ChoicenessReporter.a(mVar, mVar.a, "shortvideo", l.c(), str, str2, i);
    }

    public final void b() {
        ChoicenessReporter.a((e) this.b, "shortvideo");
    }

    public final void b(boolean z) {
        ChoicenessReporter.a((e) this.b, z, "shortvideo");
    }

    public final void a(int i, ShareOperationType shareOperationType, boolean z) {
        ChoicenessReporter.a((e) this.b, shareOperationType.getReportShareTo(), a.a(i), i, z, "shortvideo");
    }

    public final String f() {
        if (this.b == null) {
            return "";
        }
        return ChoicenessReporter.a((e) this.b);
    }
}
