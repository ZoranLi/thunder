package com.xunlei.downloadprovider.publiser.campaign;

import anet.channel.strategy.dispatch.DispatchConstants;
import com.xunlei.downloadprovider.f.a;
import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.publiser.campaign.a.m;
import com.xunlei.downloadprovider.publiser.campaign.a.n;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.ui.r;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: TopicPlayerViewReportStrategy */
public final class o extends r<n> {
    private int a;
    private String c;

    public final void b(boolean z) {
    }

    public final String j() {
        return "shortvideo_topic_shot";
    }

    public final String k() {
        return DispatchConstants.OTHER;
    }

    public o(int i, String str) {
        this.a = i;
        this.c = str;
    }

    public final void a() {
        m.a(this.a, ((n) this.b).b.getVideoId(), this.c);
    }

    public final From c() {
        switch (this.a) {
            case 2:
                return From.MUSIC_COLLECT;
            case 3:
                return From.LBS_COLLECT;
            default:
                return From.VIDEOCOLLECT;
        }
    }

    public final ShortMovieDetailActivity.From d() {
        switch (this.a) {
            case 2:
                return ShortMovieDetailActivity.From.MUSIC_COLLECT;
            case 3:
                return ShortMovieDetailActivity.From.LBS_COLLECT;
            default:
                return ShortMovieDetailActivity.From.VIDEO_COLLECT;
        }
    }

    public final String e() {
        switch (this.a) {
            case 2:
                return "shortvideo_music";
            case 3:
                return "shortvideo_lbs";
            default:
                return "shortvideo_collect";
        }
    }

    public final String f() {
        switch (this.a) {
            case 2:
                return "music_video_auto_ugc";
            case 3:
                return "lbs_video_auto_ugc";
            default:
                return "video_collect_video_auto_ugc";
        }
    }

    public final String g() {
        switch (this.a) {
            case 2:
                return "music_collect";
            case 3:
                return "lbs_collect";
            default:
                return "video_collect";
        }
    }

    public final PlayerTag h() {
        return PlayerTag.TOPIC_COLLECT;
    }

    public final LoginFrom i() {
        return LoginFrom.HOME_FOLLOW;
    }

    public final void a(String str) {
        m.a(this.a, ((n) this.b).b.getVideoId(), ((n) this.b).c.getUid(), this.c, str);
    }

    public final void a(boolean z) {
        z = ((n) this.b).b;
        VideoUserInfo videoUserInfo = ((n) this.b).c;
        int i = this.a;
        String videoId = z.getVideoId();
        String uid = videoUserInfo.getUid();
        String str = this.c;
        String kind = videoUserInfo.getKind();
        LoginHelper.a();
        m.a(i, videoId, uid, str, kind, l.c());
    }

    public final void a(String str, String str2, int i) {
        BaseVideoInfo baseVideoInfo = ((n) this.b).b;
        VideoUserInfo videoUserInfo = ((n) this.b).c;
        int i2 = this.a;
        String videoId = baseVideoInfo.getVideoId();
        String uid = videoUserInfo.getUid();
        String str3 = this.c;
        String kind = videoUserInfo.getKind();
        LoginHelper.a();
        m.a(i2, videoId, uid, str3, kind, l.c(), str, str2, i);
    }

    public final void b() {
        m.b(this.a, ((n) this.b).b.getVideoId(), ((n) this.b).c.getUid(), this.c);
    }

    public final void a(int i, ShareOperationType shareOperationType, boolean z) {
        int i2 = i;
        m.a(this.a, ((n) this.b).b.getVideoId(), shareOperationType.getReportShareTo(), a.a(i), i2, ((n) this.b).c.getUid(), this.c);
    }

    public final void a(ShareOperationType shareOperationType, String str, String str2) {
        m.b(this.a, ((n) this.b).b.getVideoId(), ((n) this.b).c.getUid(), this.c, str2);
    }
}
