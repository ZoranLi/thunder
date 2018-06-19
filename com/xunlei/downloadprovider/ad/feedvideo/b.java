package com.xunlei.downloadprovider.ad.feedvideo;

import com.qq.e.ads.nativ.MediaListener;
import com.qq.e.comm.util.AdError;

/* compiled from: FeedGDTVideoItemView */
final class b implements MediaListener {
    final /* synthetic */ long a;
    final /* synthetic */ FeedGDTVideoItemView b;

    b(FeedGDTVideoItemView feedGDTVideoItemView, long j) {
        this.b = feedGDTVideoItemView;
        this.a = j;
    }

    public final void onVideoReady(long j) {
        if (FeedGDTVideoItemView.a(this.b, this.a) != null) {
            FeedGDTVideoItemView.a(this.b, FeedGDTVideoItemView$PLAY_STATUS.PLAY_READY);
            FeedGDTVideoItemView.a(this.b);
        }
    }

    public final void onVideoStart() {
        if (FeedGDTVideoItemView.a(this.b, this.a)) {
            FeedGDTVideoItemView.a(this.b, FeedGDTVideoItemView$PLAY_STATUS.PLAY_START);
            FeedGDTVideoItemView.a(this.b);
        }
    }

    public final void onVideoPause() {
        if (!FeedGDTVideoItemView.a(this.b, this.a)) {
        }
    }

    public final void onVideoComplete() {
        if (FeedGDTVideoItemView.a(this.b, this.a)) {
            FeedGDTVideoItemView.a(this.b, FeedGDTVideoItemView$PLAY_STATUS.PLAY_COMPLETE);
            FeedGDTVideoItemView.a(this.b);
        }
    }

    public final void onVideoError(AdError adError) {
        if (FeedGDTVideoItemView.a(this.b, this.a)) {
            new StringBuilder("onVideoError errorCode: ").append(adError.getErrorCode());
        }
    }

    public final void onReplayButtonClicked() {
        if (FeedGDTVideoItemView.a(this.b, this.a)) {
            if (FeedGDTVideoItemView.b(this.b) != null) {
                com.xunlei.downloadprovider.player.a.b bVar = FeedGDTVideoItemView.b(this.b).c;
                if (bVar != null) {
                    bVar.c();
                    FeedGDTVideoItemView.b(this.b).a(null);
                }
            }
            if (FeedGDTVideoItemView.b(this.b) != null) {
                FeedGDTVideoItemView.b(this.b).a(this.b);
            }
        }
    }

    public final void onADButtonClicked() {
        if (FeedGDTVideoItemView.a(this.b, this.a) && FeedGDTVideoItemView.c(this.b) != null) {
            FeedGDTVideoItemView.c(this.b).N();
        }
    }

    public final void onFullScreenChanged(boolean z) {
        if (!FeedGDTVideoItemView.a(this.b, this.a)) {
            return;
        }
        if (z) {
            FeedGDTVideoItemView.d(this.b);
            return;
        }
        if (FeedGDTVideoItemView.b(this.b)) {
            FeedGDTVideoItemView.b(this.b).a(this.b);
        }
        FeedGDTVideoItemView.e(this.b);
    }
}
