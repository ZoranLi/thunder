package com.xunlei.downloadprovider.vod.recordpublish;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;

/* compiled from: VodPlayerPublishActivity */
final class i implements OnVideoSizeChangedListener {
    final /* synthetic */ VodPlayerPublishActivity a;

    i(VodPlayerPublishActivity vodPlayerPublishActivity) {
        this.a = vodPlayerPublishActivity;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        VodPlayerPublishActivity.a(this.a, i, i2);
    }
}
