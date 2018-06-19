package com.xunlei.downloadprovider.shortvideo.videodetail;

import com.tencent.smtt.sdk.TbsReaderView.ReaderCallback;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.downloadprovider.player.a;
import com.xunlei.downloadprovider.player.xmp.d;
import com.xunlei.downloadprovider.shortvideo.entity.LiveExtra;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.downloadprovider.shortvideo.videodetail.model.b;
import com.xunlei.downloadprovidershare.ShareOperationType;
import com.xunlei.tdlive.XLLiveRoomPlayFrom;

/* compiled from: ShortMovieDetailActivity */
final class ai implements d {
    final /* synthetic */ ShortMovieDetailActivity a;

    ai(ShortMovieDetailActivity shortMovieDetailActivity) {
        this.a = shortMovieDetailActivity;
    }

    public final void a() {
        this.a.l();
        a.a(this.a.K.getVideoId(), "short_video", "previous");
        if (this.a.t.isBackEnd()) {
            XLToast.showToast(this.a, "没有播放历史");
            this.a.m.c(false);
            return;
        }
        b bVar = (b) this.a.t.backward();
        this.a.K = bVar.a();
        this.a.a(bVar);
        this.a.a(bVar.a(), bVar.b(), "video_screen");
        this.a.m();
        ShortMovieDetailActivity shortMovieDetailActivity = this.a;
        bVar.b();
        shortMovieDetailActivity.n();
        this.a.k.a(bVar);
        this.a.G.a(bVar.b());
        if (this.a.f != null) {
            this.a.f.a(bVar);
        }
        this.a.m.c(this.a.t.isBackEnd() ^ 1);
    }

    public final void b() {
        this.a.l();
        a.a(this.a.K.getVideoId(), "short_video", "next");
        if (this.a.f != null) {
            int i = 1;
            if (this.a.t.isForwardEnd()) {
                ShortMovieDetailFragment a = this.a.f;
                a.f = a.f();
                if (a.f != null) {
                    if (a.f.size() > 0) {
                        a.a((b) a.f().get(0), false);
                        a.e = From.VIDEO_SCREEN.getText();
                        boolean isFromYouLiaoShot = a.d.a().isFromYouLiaoShot();
                        boolean z = isFromYouLiaoShot && com.xunlei.downloadprovider.d.d.a().r.j();
                        bv.a(a.d.a().getVideoId(), a.e, isFromYouLiaoShot, z);
                        if (i == 0) {
                            XLToast.showToast(this.a, "没有视频了");
                            this.a.m.d(false);
                        }
                    }
                }
                i = 0;
                if (i == 0) {
                    XLToast.showToast(this.a, "没有视频了");
                    this.a.m.d(false);
                }
            } else {
                b bVar = (b) this.a.t.forward();
                this.a.a(bVar);
                this.a.a(bVar.a(), bVar.b(), "video_screen");
                this.a.m();
                ShortMovieDetailActivity shortMovieDetailActivity = this.a;
                bVar.b();
                shortMovieDetailActivity.n();
                this.a.k.a(bVar);
                this.a.G.a(bVar.b());
                if (this.a.f != null) {
                    this.a.f.a(bVar);
                }
                this.a.m.c(true ^ this.a.t.isBackEnd());
            }
        }
    }

    public final void a(boolean z, int i) {
        if (!z) {
            if (this.a.O.getVisibility() && i >= ReaderCallback.GET_BAR_ANIMATING && ShortMovieDetailActivity.m(this.a)) {
                ShortMovieDetailActivity.n(this.a);
                return;
            }
            if (i < ReaderCallback.GET_BAR_ANIMATING && !this.a.O.getVisibility()) {
                this.a.O.setVisibility(8);
            }
        }
    }

    public final void c() {
        LiveExtra liveExtra = this.a.L.getLiveExtra();
        if (liveExtra != null) {
            com.xunlei.downloadprovider.launch.b.a.a().openUserLivePlayRoom(this.a, liveExtra.f, XLLiveRoomPlayFrom.VIDEO_DETAIL_FLOAT_ITEM);
            String str = liveExtra.a;
            String str2 = liveExtra.f;
            StatEvent build = HubbleEventBuilder.build("android_caomei", "zbhover_click");
            build.add("hostid", str);
            build.add("roomInfo", str2);
            com.xunlei.downloadprovider.shortvideo.a.a.a(build);
        }
    }

    public final void d() {
        LiveExtra liveExtra = this.a.L.getLiveExtra();
        if (liveExtra != null) {
            String str = liveExtra.a;
            String str2 = liveExtra.f;
            StatEvent build = HubbleEventBuilder.build("android_caomei", "zbhover_show");
            build.add("hostid", str);
            build.add("roomInfo", str2);
            com.xunlei.downloadprovider.shortvideo.a.a.a(build);
        }
    }

    public final void e() {
        this.a.f.a(ShareOperationType.WEIXIN);
    }

    public final void f() {
        this.a.f.a(ShareOperationType.WEIXIN_CIRCLE);
    }

    public final void g() {
        this.a.f.a(ShareOperationType.QQ);
    }

    public final void h() {
        this.a.f.a(ShareOperationType.QZONE);
    }
}
