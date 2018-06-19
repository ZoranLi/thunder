package com.xunlei.downloadprovider.homepage.follow.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import com.xunlei.downloadprovider.homepage.follow.b.d;
import com.xunlei.downloadprovider.homepage.follow.ui.aa;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.ui.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;

@SuppressLint({"ViewConstructor"})
/* compiled from: FollowingPlayerUGCView */
public final class h extends a<d> {
    private aa a;

    protected final boolean h() {
        return false;
    }

    public h(Context context, com.xunlei.downloadprovider.player.a.a aVar, aa aaVar) {
        super(context, aVar);
        this.a = aaVar;
        this.b.D.setFrom("FOLLOW_TAB");
    }

    public final void a(BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, boolean z, From from, boolean z2) {
        super.a(baseVideoInfo, videoUserInfo, z, from, z2);
        if (this.a != null) {
            this.a.a = null;
        }
    }
}
