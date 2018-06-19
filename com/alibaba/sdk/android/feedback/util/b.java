package com.alibaba.sdk.android.feedback.util;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;

class b implements OnPreparedListener {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.a.c.start();
    }
}
