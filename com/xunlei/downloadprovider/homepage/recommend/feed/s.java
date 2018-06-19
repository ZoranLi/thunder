package com.xunlei.downloadprovider.homepage.recommend.feed;

import android.content.Context;
import android.view.View;
import com.xunlei.downloadprovider.player.a.a;
import com.xunlei.downloadprovider.player.a.b;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.shortvideo.videodetail.ShortMovieDetailActivity.From;

/* compiled from: FeedVideoAutoPlayItemView */
public class s extends z implements b {
    private a l;

    public final boolean d() {
        return true;
    }

    protected String getFormatType() {
        return "video_autoplay_nosound";
    }

    public s(Context context, com.xunlei.downloadprovider.homepage.a aVar, a aVar2) {
        super(context, aVar);
        this.l = aVar2;
    }

    public View getPlayerContainerView() {
        return this.b;
    }

    public boolean b() {
        if (!this.a.f) {
            a(true);
        }
        return true;
    }

    public final boolean c() {
        if (getPlayer() != null) {
            getPlayer().r();
        }
        return true;
    }

    public int getPosition() {
        return this.k;
    }

    public final void b(ThunderXmpPlayer thunderXmpPlayer) {
        super.b(thunderXmpPlayer);
        if (this.l != null) {
            this.l.a(null);
        }
    }

    public final void a(ThunderXmpPlayer thunderXmpPlayer) {
        super.a(thunderXmpPlayer);
        if (this.l != null) {
            this.l.a((b) this);
        }
    }

    protected From getVideoDetailFrom() {
        return From.FEEDFLOW_AUTOPLAY_NOSOUND;
    }
}
