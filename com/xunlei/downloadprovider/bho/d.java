package com.xunlei.downloadprovider.bho;

import android.os.Message;
import com.xunlei.common.androidutil.HandlerUtil.MessageListener;

/* compiled from: ThunderTaskBHOActivity */
final class d implements MessageListener {
    final /* synthetic */ ThunderTaskBHOActivity a;

    d(ThunderTaskBHOActivity thunderTaskBHOActivity) {
        this.a = thunderTaskBHOActivity;
    }

    public final void handleMessage(Message message) {
        if (message.what == 1) {
            this.a.a();
        }
    }
}
