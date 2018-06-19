package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer;
import com.xunlei.downloadprovider.player.xmp.ThunderXmpPlayer.VideoViewType;
import com.xunlei.downloadprovider.player.xmp.ui.PlayerContainer;

/* compiled from: ShortMovieDetailActivity */
final class w implements PlayerContainer {
    final /* synthetic */ ShortMovieDetailActivity a;

    w(ShortMovieDetailActivity shortMovieDetailActivity) {
        this.a = shortMovieDetailActivity;
    }

    public final ViewGroup getContainerLayout() {
        return this.a.g;
    }

    public final void a(ThunderXmpPlayer thunderXmpPlayer) {
        thunderXmpPlayer.q = VideoViewType.ADAPTIVE_VIEW_TYPE;
        this.a.o = thunderXmpPlayer.j;
        this.a.n = thunderXmpPlayer.k;
        if (!(this.a.i == null || this.a.i.getLayoutParams() == null)) {
            int C = this.a.i();
            if (this.a.E != null) {
                this.a.E.a(this.a.j(), this.a.i());
            }
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.a.i.getLayoutParams();
            marginLayoutParams.height = C;
            marginLayoutParams.topMargin = this.a.H;
            if (this.a.B && this.a.l) {
                this.a.o();
                marginLayoutParams.height = this.a.j();
            }
            this.a.i.requestLayout();
            this.a.d(this.a.H == 0);
            this.a.a(marginLayoutParams);
            if (this.a.H == 0) {
                this.a.a(this.a, this.a.r);
            }
        }
        thunderXmpPlayer.m = new x(this);
    }

    public final void b(ThunderXmpPlayer thunderXmpPlayer) {
        if (thunderXmpPlayer != null) {
            thunderXmpPlayer.p();
        }
    }
}
