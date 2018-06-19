package com.xunlei.downloadprovider.player.xmp.ui;

import android.os.Handler;
import android.os.Message;

/* compiled from: MediaPlayerLoadingView */
final class a extends Handler {
    final /* synthetic */ MediaPlayerLoadingView a;

    a(MediaPlayerLoadingView mediaPlayerLoadingView) {
        this.a = mediaPlayerLoadingView;
    }

    public final void handleMessage(Message message) {
        super.handleMessage(message);
        if (message.what == 1) {
            MediaPlayerLoadingView.a(this.a);
        }
    }
}
