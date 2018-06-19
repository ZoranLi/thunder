package com.xunlei.downloadprovider.publiser.campaign;

import android.content.Context;
import com.xunlei.downloadprovider.publiser.campaign.a.n;
import com.xunlei.downloadprovider.shortvideo.entity.BaseVideoInfo;
import com.xunlei.downloadprovider.shortvideo.entity.VideoUserInfo;
import com.xunlei.downloadprovider.shortvideo.ui.a;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;

/* compiled from: TopicAdapter */
final class h extends a<n> {
    final /* synthetic */ g a;

    public final boolean e() {
        return true;
    }

    h(g gVar, Context context, com.xunlei.downloadprovider.player.a.a aVar) {
        this.a = gVar;
        super(context, aVar);
    }

    public final void a(BaseVideoInfo baseVideoInfo, VideoUserInfo videoUserInfo, boolean z, From from, boolean z2) {
        super.a(baseVideoInfo, videoUserInfo, z, from, z2);
        this.a.i = false;
    }
}
