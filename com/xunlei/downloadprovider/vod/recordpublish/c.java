package com.xunlei.downloadprovider.vod.recordpublish;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnVideoSizeChangedListener;

/* compiled from: RecordVideoPreviewActivity */
final class c implements OnVideoSizeChangedListener {
    final /* synthetic */ RecordVideoPreviewActivity a;

    c(RecordVideoPreviewActivity recordVideoPreviewActivity) {
        this.a = recordVideoPreviewActivity;
    }

    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        RecordVideoPreviewActivity.a(this.a, i, i2);
    }
}
