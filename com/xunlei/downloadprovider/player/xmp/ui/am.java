package com.xunlei.downloadprovider.player.xmp.ui;

import android.os.Handler;
import android.os.Message;

/* compiled from: PlayerOperationViewDefault */
final class am extends Handler {
    final /* synthetic */ PlayerOperationViewDefault a;

    am(PlayerOperationViewDefault playerOperationViewDefault) {
        this.a = playerOperationViewDefault;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            this.a.c();
        }
    }
}
