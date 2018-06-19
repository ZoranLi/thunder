package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.view.ViewGroup.MarginLayoutParams;

/* compiled from: ShortMovieDetailActivity */
final class x implements OnVideoSizeChangedListener {
    final /* synthetic */ w a;

    x(w wVar) {
        this.a = wVar;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.a.a.o != i || this.a.a.n != i2) {
            this.a.a.o = i;
            this.a.a.n = i2;
            if (this.a.a.a != null && this.a.a.a.h.b == null) {
                if (this.a.a.a.i() == null) {
                    mediaPlayer = this.a.a.i();
                    if (this.a.a.E != 0) {
                        this.a.a.E.a(this.a.a.j(), this.a.a.i());
                    }
                    if (this.a.a.A == 0 || this.a.a.l == 0) {
                        ShortMovieDetailActivity.P(this.a.a);
                        return;
                    }
                    MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.a.a.i.getLayoutParams();
                    marginLayoutParams.height = mediaPlayer;
                    marginLayoutParams.topMargin = this.a.a.H;
                    if (!(this.a.a.B == null || this.a.a.l == null)) {
                        this.a.a.o();
                        marginLayoutParams.height = this.a.a.j();
                        marginLayoutParams.topMargin = this.a.a.H;
                    }
                    this.a.a.i.requestLayout();
                    this.a.a.d((boolean) this.a.a.H == 0 ? 1 : 0);
                    this.a.a.a(marginLayoutParams);
                    this.a.a.h();
                    if (this.a.a.H == null) {
                        this.a.a.a(this.a.a, this.a.a.r);
                    }
                    this.a.a.l = false;
                }
            }
        }
    }
}
