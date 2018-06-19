package com.xunlei.downloadprovider.publiser.per;

import android.content.Context;
import android.view.View;
import com.xunlei.downloadprovider.member.login.ui.LoginFrom;
import com.xunlei.downloadprovider.player.xmp.PlayerTag;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerControl.ControlType;
import com.xunlei.downloadprovider.player.xmp.ui.item.BasePlayerView;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.common.o;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity.From;
import com.xunlei.downloadprovider.publiser.per.model.PublishVideoFeedInfo;
import com.xunlei.downloadprovider.shortvideo.ui.r;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovidershare.ShareOperationType;

/* compiled from: PublishVideoItemViewWrapper */
public final class bs implements bn {
    BasePlayerView a;
    g b;
    private final a c = new a(this);
    private final com.xunlei.downloadprovider.player.a.a d;

    /* compiled from: PublishVideoItemViewWrapper */
    class a extends r<PublishVideoFeedInfo> {
        final /* synthetic */ bs a;

        public final void a(String str, String str2, int i) {
        }

        public final void a(boolean z) {
        }

        public final void b(boolean z) {
        }

        public final String e() {
            return "personal_space_video_share";
        }

        public final String f() {
            return "channel_video_auto";
        }

        public final String g() {
            return "channelflow";
        }

        public final String j() {
            return "shortvideo_usercenter_shot";
        }

        public final String k() {
            return "shortvideo_usercenter";
        }

        a(bs bsVar) {
            this.a = bsVar;
        }

        public final void a() {
            if (this.a.b != null) {
                this.a.b.a(7, this.b);
            }
            int i = 0;
            if (this.a.a.getPlayerControllerType() == ControlType.AUTO_PLAY) {
                i = 1;
            }
            com.xunlei.downloadprovider.homepage.recommend.a.a(((PublishVideoFeedInfo) this.b).getRelatedVideoInfo().getVideoId(), i, "shortvideo", o.a(((PublishVideoFeedInfo) this.b).getUserInfo().getKind()), "publish", "publish");
        }

        public final void a(ShareOperationType shareOperationType, String str, String str2) {
            if (shareOperationType == ShareOperationType.DELETE) {
                if (this.a.b != null) {
                    this.a.b.a(8, this.b);
                }
                return;
            }
            com.xunlei.downloadprovider.homepage.recommend.a.b(str, "shortvideo", str2, "foot", o.a(((PublishVideoFeedInfo) this.b).getUserInfo().getKind()), "publish");
        }

        public final From c() {
            return From.PERSONAL_SPACE;
        }

        public final ShortMovieDetailActivity.From d() {
            return ShortMovieDetailActivity.From.PERSONAL_SPACE_AUTOPLAY_SOUND;
        }

        public final PlayerTag h() {
            return PlayerTag.PERSONAL;
        }

        public final LoginFrom i() {
            return LoginFrom.PERSONAL_FOLLOW;
        }

        public final void a(String str) {
            com.xunlei.downloadprovider.homepage.recommend.a.a(((PublishVideoFeedInfo) this.b).getRelatedVideoInfo().getVideoId(), "shortvideo", o.a(((PublishVideoFeedInfo) this.b).getUserInfo().getKind()), "publish", str);
        }

        public final void b() {
            com.xunlei.downloadprovider.homepage.recommend.a.a(((PublishVideoFeedInfo) this.b).getRelatedVideoInfo().getVideoId(), o.a(((PublishVideoFeedInfo) this.b).getUserInfo().getKind()), "shortvideo");
        }

        public final void a(int i, ShareOperationType shareOperationType, boolean z) {
            com.xunlei.downloadprovider.homepage.recommend.a.a(((PublishVideoFeedInfo) this.b).getRelatedVideoInfo().getVideoId(), "shortvideo", shareOperationType.getReportShareTo(), com.xunlei.downloadprovider.f.a.a(i), i, "foot", o.a(((PublishVideoFeedInfo) this.b).getUserInfo().getKind()), "publish");
        }
    }

    public bs(Context context, com.xunlei.downloadprovider.player.a.a aVar) {
        this.d = aVar;
        this.a = new com.xunlei.downloadprovider.publiser.per.view.a(context, this.d);
    }

    public final View a() {
        return this.a;
    }

    public final void a(int i, PublishVideoFeedInfo publishVideoFeedInfo) {
        this.c.b = publishVideoFeedInfo;
        ((com.xunlei.downloadprovider.publiser.per.view.a) this.a).a(i, publishVideoFeedInfo, this.c);
    }

    public final void a(g gVar) {
        this.b = gVar;
        ((com.xunlei.downloadprovider.publiser.per.view.a) this.a).setOnItemEventListener(this.b);
    }
}
