package com.xunlei.downloadprovider.ad.home.ui;

import com.qq.e.ads.nativ.MediaListener;
import com.qq.e.comm.util.AdError;
import com.xunlei.downloadprovider.ad.home.a;

/* compiled from: ADGDTVideoItemBase */
final class f implements MediaListener {
    final /* synthetic */ long a;
    final /* synthetic */ a b;

    f(a aVar, long j) {
        this.b = aVar;
        this.a = j;
    }

    public final void onVideoReady(long j) {
        if (a.a(this.b, this.a) != null) {
            this.b.f;
        }
    }

    public final void onVideoStart() {
        if (a.a(this.b, this.a)) {
            this.b.f;
        }
    }

    public final void onVideoPause() {
        if (a.a(this.b, this.a)) {
            this.b.f;
        }
    }

    public final void onVideoComplete() {
        if (a.a(this.b, this.a)) {
            this.b.f;
        }
    }

    public final void onVideoError(AdError adError) {
        if (a.a(this.b, this.a)) {
            this.b.f;
            new StringBuilder("onVideoError errorCode: ").append(adError.getErrorCode());
        }
    }

    public final void onReplayButtonClicked() {
        if (a.a(this.b, this.a)) {
            this.b.f;
        }
    }

    public final void onADButtonClicked() {
        if (a.a(this.b, this.a)) {
            this.b.f;
            if (this.b.d != null) {
                a.a(this.b.d, "gdt_button");
                this.b.d.N();
            }
        }
    }

    public final void onFullScreenChanged(boolean z) {
        if (a.a(this.b, this.a)) {
            this.b.f;
            if (z) {
                a.d(this.b);
            } else {
                if (this.b.g != null) {
                    this.b.g.a(this.b);
                }
                a.f(this.b);
            }
            if (this.b.l != null) {
                this.b.l.setVolumeOn(z);
            }
        }
    }
}
