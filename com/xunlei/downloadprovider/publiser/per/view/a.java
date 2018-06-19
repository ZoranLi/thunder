package com.xunlei.downloadprovider.publiser.per.view;

import android.content.Context;
import android.text.TextUtils;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.publiser.common.g;
import com.xunlei.downloadprovider.publiser.per.HistoryPublishItemFragment;
import com.xunlei.downloadprovider.publiser.per.model.PublishVideoFeedInfo;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.ui.r;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;
import com.xunlei.downloadprovidershare.b.c;

/* compiled from: LimitWHPublishViewItemView */
public final class a extends com.xunlei.downloadprovider.shortvideo.ui.a<PublishVideoFeedInfo> {
    private r a;
    private g g;
    private VideoUserInfo h;
    private BaseVideoInfo i;

    public final boolean e() {
        return false;
    }

    protected final boolean h() {
        return false;
    }

    protected final boolean i() {
        return true;
    }

    public a(Context context, com.xunlei.downloadprovider.player.a.a aVar) {
        super(context, aVar);
        this.b.D.setFrom("PERSONAL_SPACE");
    }

    public final void setOnItemEventListener(g gVar) {
        this.g = gVar;
    }

    public final void a(int i, BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, r<PublishVideoFeedInfo> rVar) {
        super.a(i, baseVideoInfo, videoUserInfo, (r) rVar);
        this.a = rVar;
        this.i = baseVideoInfo;
        this.h = videoUserInfo;
        this.b.B.setVisibility(8);
        this.b.z.setVisibility(8);
        this.b.A.setVisibility(0);
        this.b.y.setVisibility(8);
        this.b.u.setOnClickListener(null);
        this.b.u.setClickable(false);
    }

    public final void a(int i, PublishVideoFeedInfo publishVideoFeedInfo, r<PublishVideoFeedInfo> rVar) {
        a(i, publishVideoFeedInfo.getRelatedVideoInfo(), publishVideoFeedInfo.getUserInfo(), rVar);
        if (TextUtils.isEmpty(publishVideoFeedInfo.getRelatedVideoInfo().getCoverUrl()) != 0 && publishVideoFeedInfo.getPosterBitmap() != 0) {
            i = publishVideoFeedInfo.getPosterBitmap();
            a((int) i.getWidth(), (int) i.getHeight());
            this.b.j.setImageBitmap(i);
        }
    }

    protected final void a(ThunderXmpPlayer thunderXmpPlayer, String str) {
        super.a(thunderXmpPlayer, str);
        if (this.g != null) {
            this.g.a(str);
        }
    }

    public final c m() {
        return super.m();
    }

    public final void a(BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, boolean z, From from, boolean z2) {
        super.a(baseVideoInfo, videoUserInfo, z, from, z2);
        HistoryPublishItemFragment.a = true;
    }
}
