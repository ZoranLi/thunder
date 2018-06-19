package com.xunlei.downloadprovider.shortvideo.videodetail;

import android.os.Handler;
import android.os.Message;

/* compiled from: ShortMovieDetailFragment */
final class al extends Handler {
    final /* synthetic */ ShortMovieDetailFragment a;

    al(ShortMovieDetailFragment shortMovieDetailFragment) {
        this.a = shortMovieDetailFragment;
    }

    public final void handleMessage(Message message) {
        if (message.what == 203) {
            this.a.as[1] = Boolean.valueOf(false);
            this.a.H.b(this.a.O);
        }
    }
}
