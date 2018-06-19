package com.xunlei.downloadprovider.vod.recordpublish;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: RecordVideoPreviewActivity */
final class d implements OnErrorListener {
    final /* synthetic */ RecordVideoPreviewActivity a;

    d(RecordVideoPreviewActivity recordVideoPreviewActivity) {
        this.a = recordVideoPreviewActivity;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        RecordVideoPreviewActivity.a;
        mediaPlayer = new StringBuilder("onError=>");
        mediaPlayer.append(i);
        mediaPlayer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        mediaPlayer.append(i2);
        this.a.j.postDelayed(new e(this), 500);
        return true;
    }
}
