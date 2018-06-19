package com.xunlei.downloadprovider.vod.recordpublish;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnErrorListener;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: VodPlayerPublishActivity */
final class j implements OnErrorListener {
    final /* synthetic */ VodPlayerPublishActivity a;

    j(VodPlayerPublishActivity vodPlayerPublishActivity) {
        this.a = vodPlayerPublishActivity;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        VodPlayerPublishActivity.a;
        mediaPlayer = new StringBuilder("onError=>");
        mediaPlayer.append(i);
        mediaPlayer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
        mediaPlayer.append(i2);
        this.a.o.postDelayed(new k(this), 500);
        return true;
    }
}
