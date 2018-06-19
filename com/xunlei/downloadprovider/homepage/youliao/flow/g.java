package com.xunlei.downloadprovider.homepage.youliao.flow;

import android.view.View;
import com.xunlei.common.report.HubbleEventBuilder;
import com.xunlei.common.report.StatEvent;
import com.xunlei.common.report.ThunderReport;
import com.xunlei.downloadprovider.e.a.e;
import com.xunlei.downloadprovider.e.a.f;
import com.xunlei.downloadprovider.homepage.a;
import com.xunlei.downloadprovider.homepage.youliao.data.YouliaoVideo;
import com.xunlei.downloadprovider.homepage.youliao.data.i;
import com.xunlei.downloadprovider.personal.user.account.m;
import com.xunlei.downloadprovider.publiser.per.PublisherActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;

/* compiled from: YouliaoVideoCardViewHolder */
final class g extends b {
    a a;
    e b;
    private YouliaoVideo c;
    private YouliaoVideoCardView d;

    static g a(View view, a aVar) {
        view = new g(new YouliaoVideoCardView(view.getContext()));
        view.a = aVar;
        return view;
    }

    private g(View view) {
        super(view);
        this.d = (YouliaoVideoCardView) view;
        this.d.setOnClickListener(new h(this));
        this.d.setUserIconClickListener(new i(this));
        c();
    }

    public final void a(a aVar, int i) {
        this.d.setPosition(i);
        this.c = aVar.a();
        if (this.c != null) {
            this.d.setYouliaoVideo(this.c);
        }
    }

    public final void a() {
        c();
    }

    private void c() {
        if (this.b == null) {
            this.b = new j(this);
            f.a().a(1, this.b);
            return;
        }
        f.a().a(this.b);
        f.a().a(1, this.b);
    }

    public final void b() {
        if (this.b != null) {
            f.a().b(1, this.b);
        }
    }

    static /* synthetic */ void a(g gVar, YouliaoVideo youliaoVideo) {
        if (gVar.a != null) {
            gVar.a.b = false;
        }
        new StringBuilder("YouliaoVideo: ").append(youliaoVideo);
        String str = youliaoVideo.isGif() ? "yes" : "no";
        String videoId = youliaoVideo.getVideoId();
        String publisherId = youliaoVideo.getPublisherInfo().getPublisherId();
        String serverParams = youliaoVideo.getServerParams();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i.b);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(youliaoVideo.getPosition());
        String stringBuilder4 = stringBuilder3.toString();
        String recommendTag = youliaoVideo.getRecommendTag();
        StatEvent build = HubbleEventBuilder.build("android_youliao", "youliao_content_click");
        String str2 = "movieid";
        if (videoId == null) {
            videoId = "";
        }
        build.add(str2, videoId);
        videoId = "author_id";
        if (publisherId == null) {
            publisherId = "";
        }
        build.add(videoId, publisherId);
        build.add("rec_params", serverParams);
        videoId = "sessionid";
        if (stringBuilder2 == null) {
            stringBuilder2 = "";
        }
        build.add(videoId, stringBuilder2);
        videoId = "rn";
        if (stringBuilder4 == null) {
            stringBuilder4 = "";
        }
        build.add(videoId, stringBuilder4);
        build.add("gif", str);
        str = "tag";
        if (recommendTag == null) {
            recommendTag = "";
        }
        build.add(str, recommendTag);
        ThunderReport.reportEvent(build);
        ShortMovieDetailActivity.a aVar = new ShortMovieDetailActivity.a();
        aVar.h = 0;
        aVar.u = From.YOULIAO_TAB;
        aVar.a = youliaoVideo.getVideoId();
        aVar.b = youliaoVideo.getGcid();
        aVar.c = youliaoVideo.getTitle();
        aVar.d = youliaoVideo.getPlayUrl();
        aVar.i = youliaoVideo.getDuration();
        aVar.j = Long.parseLong(youliaoVideo.getPublisherInfo().getPublisherId());
        aVar.l = youliaoVideo.getPublisherInfo().getPublisherName();
        aVar.e = youliaoVideo.getPosterUrl();
        aVar.f = youliaoVideo.getLikeInfo().getLikeCount();
        aVar.g = youliaoVideo.getLikeInfo().isLiked();
        ShortMovieDetailActivity.a(gVar.itemView.getContext(), aVar);
    }

    static /* synthetic */ void b(g gVar, YouliaoVideo youliaoVideo) {
        long longValue;
        if (gVar.a != null) {
            gVar.a.b = false;
        }
        String str = youliaoVideo.isGif() ? "yes" : "no";
        String videoId = youliaoVideo.getVideoId();
        String publisherId = youliaoVideo.getPublisherInfo().getPublisherId();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i.b);
        String stringBuilder2 = stringBuilder.toString();
        StringBuilder stringBuilder3 = new StringBuilder();
        stringBuilder3.append(youliaoVideo.getPosition());
        String stringBuilder4 = stringBuilder3.toString();
        String recommendTag = youliaoVideo.getRecommendTag();
        StatEvent build = HubbleEventBuilder.build("android_youliao", "youliao_common_click");
        String str2 = "movieid";
        if (videoId == null) {
            videoId = "";
        }
        build.add(str2, videoId);
        videoId = "author_id";
        if (publisherId == null) {
            publisherId = "";
        }
        build.add(videoId, publisherId);
        videoId = "sessionid";
        if (stringBuilder2 == null) {
            stringBuilder2 = "";
        }
        build.add(videoId, stringBuilder2);
        videoId = "rn";
        if (stringBuilder4 == null) {
            stringBuilder4 = "";
        }
        build.add(videoId, stringBuilder4);
        build.add("gif", str);
        str = "tag";
        if (recommendTag == null) {
            recommendTag = "";
        }
        build.add(str, recommendTag);
        ThunderReport.reportEvent(build);
        recommendTag = youliaoVideo.getPublisherInfo().getPublisherName();
        String avatarUrl = youliaoVideo.getPublisherInfo().getAvatarUrl();
        try {
            longValue = Long.valueOf(youliaoVideo.getPublisherInfo().getPublisherId()).longValue();
        } catch (Throwable th) {
            th.printStackTrace();
            longValue = 0;
        }
        m.a(gVar.itemView.getContext(), longValue, youliaoVideo.getPublisherInfo().getUserKind(), recommendTag, avatarUrl, PublisherActivity.From.YOULIAO_TAB, gVar.c.getGcid(), gVar.c.getVideoId());
    }
}
