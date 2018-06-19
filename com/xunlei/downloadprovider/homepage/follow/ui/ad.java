package com.xunlei.downloadprovider.homepage.follow.ui;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.f.a;
import com.xunlei.downloadprovider.homepage.choiceness.ChoicenessReporter;
import com.xunlei.downloadprovider.homepage.follow.b.d;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.ui.r;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: FollowingVideoReportStrategy */
public class ad extends r<d> {
    public final void a(String str, String str2, int i) {
    }

    public final void a(boolean z) {
    }

    public final void b(boolean z) {
    }

    public final String e() {
        return "follow_tab";
    }

    public final String f() {
        return "follow_tab";
    }

    public final String g() {
        return "follow_tab";
    }

    public final String j() {
        return "home_follow_shot";
    }

    public final String k() {
        return DispatchConstants.OTHER;
    }

    public final void a(ShareOperationType shareOperationType, String str, String str2) {
        if (shareOperationType == ShareOperationType.REPORT) {
            ChoicenessReporter.a(str, "jubao", "follow_tab");
        }
    }

    public final From c() {
        return From.FOLLOW_TAB;
    }

    public ShortMovieDetailActivity.From d() {
        return ShortMovieDetailActivity.From.FOLLOW_TAB_VIDEO_LIST;
    }

    public final PlayerTag h() {
        return PlayerTag.FOLLOW_TAB;
    }

    public final LoginFrom i() {
        return LoginFrom.HOME_FOLLOW;
    }

    public void a() {
        com.xunlei.downloadprovider.homepage.follow.ad.a(((d) this.b).b.getVideoId(), ((d) this.b).a(), ((d) this.b).b(), "followtab_video_list");
    }

    public final void a(String str) {
        com.xunlei.downloadprovider.homepage.follow.ad.a(((d) this.b).b.getVideoId(), ((d) this.b).a(), str);
    }

    public final void b() {
        BaseVideoInfo baseVideoInfo = ((d) this.b).b;
        com.xunlei.downloadprovider.homepage.follow.ad.a(baseVideoInfo.getVideoId(), String.valueOf(baseVideoInfo.getPublisherId()));
    }

    public final void a(int i, ShareOperationType shareOperationType, boolean z) {
        com.xunlei.downloadprovider.homepage.follow.ad.a(((d) this.b).b.getVideoId(), ((d) this.b).a(), shareOperationType.getReportShareTo(), a.a(i), String.valueOf(i));
    }
}
