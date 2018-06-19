package com.xunlei.downloadprovider.personal.message.chat.personalchat.dialog;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: MessageSendFrequencyLimiter */
final class c implements MessageListener {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public final void handleMessage(Message message) {
        switch (message.what) {
            case 1000:
                b.a(this.a, ((Long) message.obj).longValue());
                return;
            case 1001:
                b.b(this.a, ((Long) message.obj).longValue());
                break;
            default:
                break;
        }
    }
}
