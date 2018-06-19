package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.content.Context;
import com.xunlei.downloadprovider.ad.feedvideo.FeedGDTVideoItemView;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.player.a.b;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.ui.q;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;

/* compiled from: FeedVideoVoiceAutoPlayItemView */
public final class as extends s {
    private a l;

    protected final String getFormatType() {
        return "video_autoplay_sound";
    }

    public as(Context context, com.xunlei.downloadprovider.homepage.a aVar, a aVar2) {
        super(context, aVar, aVar2);
        this.l = aVar2;
    }

    protected final From getVideoDetailFrom() {
        return From.FEEDFLOW_AUTOPLAY_SOUND;
    }

    public final boolean b() {
        if (!this.a.f) {
            a(ThunderXmpPlayer.c());
        }
        return true;
    }

    protected final void b(boolean z) {
        super.b(z);
        z = com.xunlei.downloadprovider.ad.feedvideo.a.b();
        if (!(z.c == null || z.c.get() == null)) {
            ((FeedGDTVideoItemView) z.c.get()).c();
        }
        if (this.l) {
            this.l.a((b) this);
        }
    }

    protected final void d(ThunderXmpPlayer thunderXmpPlayer) {
        super.d(thunderXmpPlayer);
        thunderXmpPlayer = thunderXmpPlayer.l;
        if (thunderXmpPlayer instanceof q) {
            ((q) thunderXmpPlayer).f.setShouldShowVoiceBtn(true);
        }
    }
}
