package com.xunlei.downloadprovider.vod.subtitle;

import android.os.Handler;
import android.os.Message;
import com.xunlei.downloadprovider.vod.subtitle.LoopView.ACTION;

/* compiled from: MessageHandler */
final class c extends Handler {
    final LoopView a;

    c(LoopView loopView) {
        this.a = loopView;
    }

    public final void handleMessage(Message message) {
        message = message.what;
        if (message == 1000) {
            this.a.invalidate();
        } else if (message != 2000) {
            if (message == 3000) {
                message = this.a;
                if (message.b != null) {
                    message.postDelayed(new d(message), 200);
                }
            }
        } else {
            this.a.a(ACTION.FLING);
        }
    }
}
