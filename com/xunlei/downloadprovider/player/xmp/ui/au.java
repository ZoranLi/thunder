package com.xunlei.downloadprovider.player.xmp.ui;

import android.os.Handler;
import android.os.Message;

/* compiled from: PlayerOperationViewDetail */
final class au extends Handler {
    final /* synthetic */ PlayerOperationViewDetail a;

    au(PlayerOperationViewDetail playerOperationViewDetail) {
        this.a = playerOperationViewDetail;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                this.a.b(false);
                return;
            case 2:
                this.a.b();
                return;
            case 3:
                this.a.x.setVisibility(8);
                PlayerOperationViewDetail.b(this.a);
                this.a.g();
                break;
            default:
                break;
        }
    }
}
